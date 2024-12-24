package bean.vo;

import lombok.Data;

@Data
public class FileVo {
    private long fileId;
    private String fileExperience;
    private String fileStudy;
    private String fileExam;
    private String doctorName;
    private long doctorId;
}
