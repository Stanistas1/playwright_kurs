package pl.stanistas.module_8;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;
import pl.stanistas.module_8.dto.ContactUsDTO;
import pl.stanistas.module_8.pages.ContactUsPage;
import pl.stanistas.module_8.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class SendContactUsFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/");
    }

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {

        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickOnSendMessageButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessega()).isVisible();
    }

    @Test
    void should_fill_and_send_contact_us_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();

        contactUsPage.getContactUsFormSection().sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());

        assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessage()).isVisible();
    }
}
