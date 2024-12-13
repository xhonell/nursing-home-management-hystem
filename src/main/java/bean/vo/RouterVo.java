package bean.vo;

import bean.pojo.Router;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouterVo {

  private long router_id;
  private String router_path;
  private String router_component;
  private String router_name;
  private String router_title;
  private String router_icon;
  private List<Router> children;

}
