package pl.stanistas.modul_4;

import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

class LoginWithValidCredentials extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {

        page.navigate("http://localhost:7080/login");
        page.fill("id=username", "tomsmith");
        page.fill("id=password", "SuperSecretPassword");
        page.click("text=Login");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}