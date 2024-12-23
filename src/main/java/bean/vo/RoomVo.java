package bean.vo;

import lombok.Data;

@Data
public class RoomVo {
    private long roomId;
    private String roomName;
    private long doctorId;
    private long olderId;
    private String olderName;
    private String doctorName;
}
