from page import BasePage
from Locators import Locator

class LoginPage(BasePage):
    def do_login(self):
        login_button = self.driver.find_element_by_id(Locator.login_button)
        login_button.click()

        user_name = self.driver.find_element_by_id(Locator.user_name)
        user_name.click()
        user_name.clear()
        user_name.send_keys("qaigor")
        print("username entered")
        self.driver.back()

        password = self.driver.find_element_by_id(Locator.password)
        password.click()
        password.clear()
        password.send_keys("7799369")
        print("password entered")

        log_in_button = self.driver.find_element_by_id(Locator.log_in_button)
        log_in_button.click()
        print("log in button clicked")