package pl.stanistas.module_7;

import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _2ShadowDOMTest extends BaseTest {
    @Test
    void shadowDOMTest() {

        page.navigate("http://localhost:7080/shadowdom");
        System.out.println(page.locator("span[slot=\"my-text\"]").innerText());
    }

    @Test
    void shadowDOMTest1() {
        page.navigate("http://bugs.chromium.org/p/chromium/issues/list");
        page.selectOption("#can", "New issues");
    }
}
