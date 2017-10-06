CREATE OR REPLACE PROCEDURE ivr_callid_check

/*
  Author : Демченко И.В.
  job 57470
*/

IS
  v_text    CLOB;
  v_varchar VARCHAR2 (32767);
  v_row INTEGER;

BEGIN
v_row := 1;
          --Проинициализируем CLOB приемник
  DBMS_LOB.CREATETEMPORARY(v_text, TRUE);

          --Напишем название отчета
  v_varchar := '<p aligh="right"><b>CallID Stat</b></p>';
  DBMS_LOB.WRITEAPPEND(v_text,LENGTH(v_varchar),v_varchar);
          --Создадим заголовок таблицы (шапка)
  v_varchar:='<table border=1 width=100% style="BORDER: #999999 1px solid" cellspacing=0 cellpadding=0><tr bgcolor="#e1f7fc" align="center">';
  DBMS_LOB.WRITEAPPEND(v_text, LENGTH(v_varchar),v_varchar);

  v_varchar :='<td><b>DATA</b></td><td><b>IVR_ID</b></td><td><b>IVRNAME</b></td><td><b>CALLID</b></td><td><b>CALLID_START</b></td><td><b>CALLID_END</b></td>';
  DBMS_LOB.WRITEAPPEND(v_text,LENGTH(v_varchar),v_varchar);


 -- курсор
  for curs in (Select calls.dt, calls.ivr_id_name, s.ivrname, max_id, iv.callid_start, iv.callid_end
from
(select
      trunc(im.starttime, 'hh24') dt,
      trim(substr(im.file_name_load,1,instr(im.file_name_load,'_')-1)) ivr_id_name,
      max(callid) as max_id
from rscc.imcall im
    where im.starttime >= sysdate - 1/48
 group by trunc(im.starttime, 'hh24'),
  trim(substr(im.file_name_load,1,instr(im.file_name_load,'_')-1))
) calls
  join  IVR_REPORT.Dir_Ivr_Callid iv on to_char(iv.ivr_id) = calls.ivr_id_name
  join IVR_REPORT.DIR_IVR_IVRSERVERS s on s.ivr_id = iv.ivr_id
  order by calls.ivr_id_name )

--формирование отчета
  
 loop

IF MOD(v_row,2)=1 then
    v_varchar:='<tr>';
ELSE
    v_varchar:='<tr bgcolor="#E8E8E8">';
END IF;
DBMS_LOB.WRITEAPPEND(v_text,LENGTH(v_varchar),v_varchar);
               -- результирующая таблица (без шапки)
IF (curs.max_id + 800000) > curs.callid_end THEN v_varchar :='<td>'||curs.dt||'</td><td align= ''center''>'||curs.ivr_id_name||'</td><td align= ''center''>'||curs.ivrname||'</td><td align= ''center''><div style="color: red"><b>'|| curs.max_id ||'</b></div></td><td align= ''center''>'||curs.callid_start||'</td><td align= ''center''>'||curs.callid_end||'</td><td align= ''center''>';
ELSE  v_varchar :='<td>'||curs.dt||'</td><td align= ''center''>'||curs.ivr_id_name||'</td><td align= ''center''>'||curs.ivrname||'</td><td align= ''center''><div style="color: green"><b>'|| curs.max_id ||'</b></div></td><td align= ''center''>'||curs.callid_start||'</td><td align= ''center''>'||curs.callid_end||'</td><td align= ''center''>';
END IF;



  v_row := v_row +1;
  DBMS_LOB.WRITEAPPEND(v_text,LENGTH(v_varchar),v_varchar);

  end loop;


-- отправка на E-mail
ivr_report.Send_EMailHTML('SVN@kyivstar.net','ccsupportgroup@kyivstar.net', v_text, 'CallID Key Stat');

END;
