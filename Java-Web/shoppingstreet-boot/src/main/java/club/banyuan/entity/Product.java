package club.banyuan.entity;

import javax.persistence.*;

public class Product {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private Float price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 分类1
     */
    @Column(name = "categoryLevel1Id")
    private Integer categorylevel1id;

    /**
     * 分类2
     */
    @Column(name = "categoryLevel2Id")
    private Integer categorylevel2id;

    /**
     * 分类3
     */
    @Column(name = "categoryLevel3Id")
    private Integer categorylevel3id;

    /**
     * 文件名称
     */
    @Column(name = "fileName")
    private String filename;

    /**
     * 是否删除(1：删除 0：未删除)
     */
    @Column(name = "isDelete")
    private Integer isdelete;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取分类1
     *
     * @return categoryLevel1Id - 分类1
     */
    public Integer getCategorylevel1id() {
        return categorylevel1id;
    }

    /**
     * 设置分类1
     *
     * @param categorylevel1id 分类1
     */
    public void setCategorylevel1id(Integer categorylevel1id) {
        this.categorylevel1id = categorylevel1id;
    }

    /**
     * 获取分类2
     *
     * @return categoryLevel2Id - 分类2
     */
    public Integer getCategorylevel2id() {
        return categorylevel2id;
    }

    /**
     * 设置分类2
     *
     * @param categorylevel2id 分类2
     */
    public void setCategorylevel2id(Integer categorylevel2id) {
        this.categorylevel2id = categorylevel2id;
    }

    /**
     * 获取分类3
     *
     * @return categoryLevel3Id - 分类3
     */
    public Integer getCategorylevel3id() {
        return categorylevel3id;
    }

    /**
     * 设置分类3
     *
     * @param categorylevel3id 分类3
     */
    public void setCategorylevel3id(Integer categorylevel3id) {
        this.categorylevel3id = categorylevel3id;
    }

    /**
     * 获取文件名称
     *
     * @return fileName - 文件名称
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置文件名称
     *
     * @param filename 文件名称
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 获取是否删除(1：删除 0：未删除)
     *
     * @return isDelete - 是否删除(1：删除 0：未删除)
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置是否删除(1：删除 0：未删除)
     *
     * @param isdelete 是否删除(1：删除 0：未删除)
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}