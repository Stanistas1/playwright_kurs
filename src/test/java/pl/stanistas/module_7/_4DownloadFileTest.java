package pl.stanistas.module_7;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

import java.nio.file.Paths;

public class _4DownloadFileTest extends BaseTest {
    @Test
    void downloadWithHandlerTest() {
        page.navigate("http://localhost:7080/download");
        page.onDownload(download -> download.saveAs(Paths.get("downloads/some-file.txt")));
        page.getByText("some-file.txt").click();
    }

    @Test
    void dwonloadWithSaveTest() {
        page.navigate("http://localhost:7080/download");
        Download download = page.waitForDownload(() -> page.getByText("some-file.txt").click());
        download.saveAs(Paths.get("downloads/some-file1.txt"));
    }
}
