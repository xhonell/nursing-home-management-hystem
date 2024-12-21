package bean.dto.equit;

import lombok.Data;

@Data
public class EquipUpdateDto {
    private Long equipId;
    private String equipName;
    private String equipPosition;
    private String equipState;
}

