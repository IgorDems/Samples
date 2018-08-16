from page import BasePage
from Locators import Locator

class GalleryPage(BasePage):

    def click_and_save_image(self):
        camera_button = self.driver.find_element_by_id(Locator.camera_button)
        camera_button.click()
        print("camera button clicked")

        camera_save = self.driver.find_element_by_id(Locator.camera_save)
        camera_save.click()
        print("camera save button clicked")
        self.driver.back()
        self.driver.back()

    def click_next(self):
        next_button = self.driver.find_element_by_id(Locator.next_button)
        next_button.click()
        print("next button clicked")



class GalleryEdit(BasePage):

    def click_next_edit(self):
        next_e_button = self.driver.find_element_by_id(Locator.next_e_button)
        next_e_button.click()
        print("next_edit button clicked")

    def click_shareto(self):
        share_to_fb = self.driver.find_element_by_id(Locator.share_to_fb)
        share_to_fb.click()
        print("share_to_fb button clicked")

    def click_share_all(self):
        share = self.driver.find_element_by_id(Locator.share)
        share.click()
        print("share link clicked")
