package pl.stanistas.modul_3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

class zadanieDomowe1 {

    @Test
    void should_open_onet_chromium() {

        Playwright playwright = Playwright.create();
        List<BrowserType> browsers = List.of(playwright.chromium(), playwright.firefox(), playwright.webkit());

        for (BrowserType browserType : browsers) {
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            page.navigate("https://onet.pl/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + browserType.name() + ".png")));
            browser.close();
        }

    }
}
