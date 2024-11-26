package pl.stanistas.module_8.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContactUsDTO {

    private String subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String fileToUpload;
    private String message;

    public static ContactUsDTO getDefaultContactUsDTO() {
        return ContactUsDTO.builder()
                .subjectHeading("Webmaster")
                .emailAddress("kCk6A@example.com")
                .orderReference("12345")
                .fileToUpload("uploads/upload-file.txt")
                .message("Test message")
                .build();
    }
}
