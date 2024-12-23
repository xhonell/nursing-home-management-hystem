package bean.dto.grade;

import lombok.Data;

@Data
public class GradeUpdateDto {
    private long gradeId;
    private String gradeName;
    private String gradeContent;
    private double gradeCharge;
}
