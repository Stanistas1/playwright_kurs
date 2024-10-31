package pl.stanistas.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _8DynamicElementsTest extends BaseTest {
    @Test
    void dynamicElementsTest1() {
        page.navigate("http://localhost:7080/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start  ")).click();
        PlaywrightAssertions.assertThat(text).isVisible();
    }

    @Test
    void dynamicElementsTest2() {
        page.navigate("http://localhost:7080/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start  ")).click();
        PlaywrightAssertions.assertThat(text).isVisible();
    }

    @Test
    void dynamicControlsTest1() {
        page.navigate("http://localhost:7080/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).not().isVisible();
        PlaywrightAssertions.assertThat(page.getByText("it's gone!")).isVisible();
    }
    @Test
    void dynamicControlsTest2() {
        page.navigate("http://localhost:7080/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isEnabled();
    }
}