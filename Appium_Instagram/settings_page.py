from page import BasePage
from Locators import Locator

class SettingsPage(BasePage):
    def do_logout(self):
        log_out = self.driver.find_element_by_xpath(Locator.log_out)
        log_out.click()
        print("logout clicked")

    def do_confirm_logout(self):
        confirm_logout = self.driver.find_element_by_id(Locator.confirm_logout)
        confirm_logout.click()
        print("confirm_logout clicked")
        print("automation over")