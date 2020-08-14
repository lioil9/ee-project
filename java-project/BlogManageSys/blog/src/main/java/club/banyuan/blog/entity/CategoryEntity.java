package club.banyuan.blog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String cateName;
    private Timestamp date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
