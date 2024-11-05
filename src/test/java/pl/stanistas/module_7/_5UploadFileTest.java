package pl.stanistas.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class _5UploadFileTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("http://localhost:7080/upload");

        page.setInputFiles("#file-upload", Paths.get("uploads/upload-file.txt"));
        page.locator("#file-submit").click();
        PlaywrightAssertions.assertThat(page.getByText("File Uploaded"));
    }

    @Test
    void uploadMultipleFilesTest() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.setInputFiles("#filesToUpload", new Path[] {
                Paths.get("uploads/upload-file.txt"),
                Paths.get("uploads/upload-file1.txt"),
        });
    }
}
