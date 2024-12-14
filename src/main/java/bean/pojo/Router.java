package bean.pojo;

import lombok.Data;

import java.util.List;

@Data
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
