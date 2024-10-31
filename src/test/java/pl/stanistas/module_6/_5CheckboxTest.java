package pl.stanistas.module_6;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _5CheckboxTest extends BaseTest {

    @Test
    void checkboxTest() {
        page.navigate("http://localhost:7080/checkboxes");
        page.getByRole(AriaRole.CHECKBOX).first().check();
        page.getByRole(AriaRole.CHECKBOX).last().uncheck();
    }
}
