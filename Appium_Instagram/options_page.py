from page import BasePage
from Locators import Locator


class OptionsPage(BasePage):
    def do_logout(self):
        log_out = self.driver.find_element_by_android_uiautomator(Locator.log_out)
        log_out.click()
        print("log out clicked")

        confirm_logout = self.driver.find_element_by_id(Locator.confirm_logout)
        confirm_logout.click()

        print("automation over")
