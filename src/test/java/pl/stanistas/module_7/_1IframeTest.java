package pl.stanistas.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _1IframeTest extends BaseTest {

    @Test
    void should_enter_text_into_the_iframe() {

        page.navigate("http://localhost:7080/iframe");
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("DEMO");
    }

    @Test
    void should_get_text_from_nested_frames() {
        page.navigate("http://localhost:7080/nested_frames");
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
