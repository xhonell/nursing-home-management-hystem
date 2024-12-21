package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Router {

  private long pageId;
  private String pagePath;
  private String pageComponent;
  private String pageName;
  private String pageTitle;
  private String pageIcon;
  private long pageParentId;
  private List<Router> pageChildren;

}
