package bean.dto.grade;

import lombok.Data;

@Data
public class GradeCreateDto {
    private String gradeName;
    private String gradeContent;
    private double gradeCharge;
}
