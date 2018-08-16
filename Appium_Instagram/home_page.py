from page import BasePage
from Locators import Locator

class HomePage(BasePage):
    def verify_home_page(self):
        action_button = self.driver.find_element_by_id(Locator.action_button)

        if action_button.is_displayed():
            print("Home Page verified")
            return "True"
        else:
            print("Login unsuccessful")
            return "False"

    def click_avatar_button(self):
        avatar_button = self.driver.find_element_by_id(Locator.avatar_button)
        avatar_button.click()
        print("avatar button clicked")

    def click_profile_icon(self):
        tab_icons = self.driver.find_elements_by_id(Locator.tab_icons)
        tab_icons[4].click()
        print("profile button clicked")

    def click_plus_icon(self):
        tab_icons = self.driver.find_elements_by_id(Locator.tab_icons)
        tab_icons[2].click()
        print("'plus' button clicked")
