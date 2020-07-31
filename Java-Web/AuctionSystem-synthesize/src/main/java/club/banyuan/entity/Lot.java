package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

public class Lot {
    @Id
    @Column(name = "lotId")
    private Integer lotid;

    @Column(name = "lotName")
    private String lotname;

    @Column(name = "beginPrice")
    private Double beginprice;

    @Column(name = "floorPrice")
    private Double floorprice;

    @Column(name = "beginTime")
    private Date begintime;

    @Column(name = "endTime")
    private Date endtime;

    private String image;

    private String descript;

    /**
     * @return lotId
     */
    public Integer getLotid() {
        return lotid;
    }

    /**
     * @param lotid
     */
    public void setLotid(Integer lotid) {
        this.lotid = lotid;
    }

    /**
     * @return lotName
     */
    public String getLotname() {
        return lotname;
    }

    /**
     * @param lotname
     */
    public void setLotname(String lotname) {
        this.lotname = lotname;
    }

    /**
     * @return beginPrice
     */
    public Double getBeginprice() {
        return beginprice;
    }

    /**
     * @param beginprice
     */
    public void setBeginprice(Double beginprice) {
        this.beginprice = beginprice;
    }

    /**
     * @return floorPrice
     */
    public Double getFloorprice() {
        return floorprice;
    }

    /**
     * @param floorprice
     */
    public void setFloorprice(Double floorprice) {
        this.floorprice = floorprice;
    }

    /**
     * @return beginTime
     */
    public Date getBegintime() {
        return begintime;
    }

    /**
     * @param begintime
     */
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    /**
     * @return endTime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return descript
     */
    public String getDescript() {
        return descript;
    }

    /**
     * @param descript
     */
    public void setDescript(String descript) {
        this.descript = descript;
    }
}