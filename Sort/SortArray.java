package Sort;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aryNums;
		aryNums = new int[6];

		System.out.println("aryNums.length = " + aryNums.length);

		aryNums[0] = 10;
		aryNums[1] = 37;
		aryNums[2] = 21;
		aryNums[3] = 45;
		aryNums[4] = 30;
		aryNums[5] = 15;

		Integer[] intArr = new Integer[aryNums.length];

		System.out.println("intArr.length = " + intArr.length);

		for (int i = 0; i < aryNums.length; i++) {

			intArr[i] = new Integer(aryNums[i]);

		}

		Arrays.sort(intArr, Collections.reverseOrder());

		for (int i = 0; i < aryNums.length; i++) {

			System.out.println("num = " + intArr[i]);

		}

	}

}
