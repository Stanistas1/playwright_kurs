package pl.stanistas.module_6;

import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _1And2PageAndInputTest extends BaseTest {

    @Test
    void pageTest() {

        page.navigate("http://localhost:7080/login");
        page.fill("#username", "tomsmith");
        page.type("#password", "SuperSecretPassword!");


    }
}
