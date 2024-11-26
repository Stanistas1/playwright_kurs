package pl.stanistas.module_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

class _8TracingTest extends BaseTest {
    @Test
    void traceDemoTest() {
        page.navigate("http://localhost:7080/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "tomaszkowalski");
        page.type("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
