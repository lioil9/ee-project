package club.banyuan.entity;

import javax.persistence.*;

public class Province {
    @Id
    private Integer id;

    @Column(name = "pName")
    private String pname;

    private String spell;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return pName
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return spell
     */
    public String getSpell() {
        return spell;
    }

    /**
     * @param spell
     */
    public void setSpell(String spell) {
        this.spell = spell;
    }
}