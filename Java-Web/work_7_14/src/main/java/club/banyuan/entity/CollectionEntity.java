package club.banyuan.entity;

import java.util.List;

public class CollectionEntity {
  private List<User> list;

  public CollectionEntity(){

  }
  public CollectionEntity(List list) {
    this.list = list;
  }

  public List getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }
}
