package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Router {

  private long router_id;
  private String router_path;
  private String router_component;
  private String router_name;
  private String router_title;
  private String router_icon;
  private String router_parentId;

}
