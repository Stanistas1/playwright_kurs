package pl.stanistas.modul_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

class LoginWithValidCredentials extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {

        page.navigate("http://localhost:7080/login");
        page.fill("id=username", "tomsmith");
        page.fill("id=password", "SuperSecretPassword!");
        page.click("#login button");

        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();
    }
}