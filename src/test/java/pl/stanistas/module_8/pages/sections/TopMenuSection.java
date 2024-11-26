package pl.stanistas.module_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.stanistas.module_8.pages.BasePage;
import pl.stanistas.module_8.pages.ContactUsPage;

public class TopMenuSection extends BasePage {


    private Locator contactUsLink;
    private Locator signInLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
        signInLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));
    }

    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }
}
