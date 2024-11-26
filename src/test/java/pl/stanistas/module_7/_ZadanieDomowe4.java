package pl.stanistas.module_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

import java.nio.file.Paths;

public class _ZadanieDomowe4 extends BaseTest {
    @Test
    void should_show_an_error_when_trying_to_send_empty_from(){

        page.navigate("http:automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();
        PlaywrightAssertions.assertThat(page.getByText("Invalid email address.")).isVisible();

        page.locator("#center_column").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/empty_contact_us_form.png")));
    }

    @Test
    void should_fill_and_send_contact_us_from(){

        page.navigate("http:automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.selectOption("#id_contact", "Webmaster");
        page.getByLabel("Email addres").fill("test@test.pl");
        page.locator("#id_order").fill("123456");
        page.setInputFiles("#fileUpload", Paths.get("uploads/upload-file.txt"));
        page.locator("#message").fill("test");
        page.locator("#submitMessage").click();
        PlaywrightAssertions.assertThat(page.getByText("Your message has been successfully sent to our team.")).isVisible();

    }
}
