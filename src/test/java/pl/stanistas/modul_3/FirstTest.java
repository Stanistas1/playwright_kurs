package pl.stanistas.modul_3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

class FirstTest extends BaseTest {

    @Test
    void should_return_correct_page_title() {
        page.navigate("https://playwright.dev/");
        Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}
