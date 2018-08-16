# This is a demo automation for Instagram to log in to the app, take a photo, save to the gallery and then logout.
import unittest


from appium import webdriver

import gallery_page
import home_page
import login_page
import profile_page
import settings_page

class InstagramTest(unittest.TestCase):
    def setUp(self):
        desired_capabilities = {'platformName': 'Android', 'platformVersion': '6.0',
                        'deviceName': 'LEY7A07310020278', 'appPackage': 'com.instagram.android',
                        'appActivity': 'com.instagram.android.activity.MainTabActivity', 'autoGrantPermissions': 'true'}
        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_capabilities)
        self.driver.implicitly_wait(30)

    def test_automation(self):

        login = login_page.LoginPage(self.driver)
        login.do_login()

        home = home_page.HomePage(self.driver)
        self.assertEqual(home.verify_home_page(), 'True')
        home.click_avatar_button()

        gallery = gallery_page.GalleryPage(self.driver)
        gallery.click_and_save_image()

        home = home_page.HomePage(self.driver)
        home.click_profile_icon()

        home = home_page.HomePage(self.driver)
        home.click_plus_icon()

        photo_choice = gallery_page.GalleryPage(self.driver)
        photo_choice.click_next()

        photo_choice1 = gallery_page.GalleryEdit(self.driver)
        photo_choice1.click_next_edit()

        share_to_fb = gallery_page.GalleryEdit(self.driver)
        share_to_fb.click_shareto()

        share = gallery_page.GalleryEdit(self.driver)
        share.click_share_all()

        home = home_page.HomePage(self.driver)
        home.click_profile_icon()

        profile = profile_page.ProfilePage(self.driver)
        profile.click_settings()

        log_out = settings_page.SettingsPage(self.driver)
        log_out.do_logout()

        confirm_logout = settings_page.SettingsPage(self.driver)
        confirm_logout.do_confirm_logout()

    def tearDown(self):
        self.driver.quit()


if __name__ == '__main__':
    unittest.main()
