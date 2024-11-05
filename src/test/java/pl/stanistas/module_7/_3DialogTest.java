package pl.stanistas.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _3DialogTest extends BaseTest {
    @Test
    void dialogAlertTest() {
        page.navigate("http://localhost:7080/javascript_alerts");
        page.onDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });
        page.locator("text=Click for JS Alert").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfuly clicked an alert");
    }

    @Test
    void dialogConfirmTest() {
        page.navigate("http://localhost:7080/javascript_alerts");
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });
        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.dismiss();
        });
        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() {
        page.navigate("http://localhost:7080/javascript_alerts");

        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept("123");
        });
        page.locator("text=Click for JS Prompt").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: 123");
    }
}
