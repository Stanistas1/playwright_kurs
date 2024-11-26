package pl.stanistas.module_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.stanistas.module_8.pages.sections.TopMenuSection;

public class HomePage extends BasePage {

    @Getter
    private TopMenuSection topMenuSection;

    public HomePage(Page page) {
        super(page);
        this.topMenuSection = new TopMenuSection(page);
    }
}
