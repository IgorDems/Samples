from page import BasePage


class Locator(BasePage):

# login_page locators

    login_button = "com.instagram.android:id/log_in_button"
    user_name = "com.instagram.android:id/login_username"
    password = "com.instagram.android:id/password"
    log_in_button = "com.instagram.android:id/button_text"


# home_page locators

    action_button = "com.instagram.android:id/action_bar_left_button"
    avatar_button = "com.instagram.android:id/avatar_image_view"
    tab_icons = "com.instagram.android:id/tab_icon"

# gallery_page locarors

    camera_button = "com.instagram.android:id/camera_shutter_button"
    next_button = "com.instagram.android:id/next_button_textview"
    camera_save = "com.instagram.android:id/camera_save_button_icon"
    next_e_button = "com.instagram.android:id/next_button_textview"
    share_to_fb = "com.instagram.android:id/share_switch"
    share = "com.instagram.android:id/next_button_textview"

# option_page locators
    log_out = "//android.widget.TextView[@text='Log Out']"
    #log_out = "com.instagram.android:id/row_simple_link_textview"
    confirm_logout = "com.instagram.android:id/button_positive"

# profile_page locators

    settings = "com.instagram.android:id/action_bar_overflow_icon"

