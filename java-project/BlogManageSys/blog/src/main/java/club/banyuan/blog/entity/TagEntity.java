package club.banyuan.blog.entity;

import java.io.Serializable;

public class TagEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String tagName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
