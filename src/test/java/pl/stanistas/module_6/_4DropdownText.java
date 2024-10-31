package pl.stanistas.module_6;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

public class _4DropdownText extends BaseTest {

    @Test
    void dropDownTest() {
        page.navigate("http://localhost:7080/dropdown");
        page.selectOption("#dropdown", "Option 2");

    }

    @Test
    void mulitselectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[]{"ms2", "ms3"});
        page.waitForTimeout(3000);
    }
}
