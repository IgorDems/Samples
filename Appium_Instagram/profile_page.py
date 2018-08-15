from page import BasePage
from Locators import Locator

class ProfilePage(BasePage):
    def click_settings(self):
        settings = self.driver.find_element_by_id(Locator.settings)
        settings.click()
        print("settings button clicked")