package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

public class Endlot {
    @Id
    @Column(name = "endlotId")
    private Integer endlotid;

    @Column(name = "lotId")
    private Integer lotid;

    @Column(name = "userId")
    private Integer userid;

    @Column(name = "beginTime")
    private Date begintime;

    @Column(name = "endTime")
    private Date endtime;

    @Column(name = "beginPrice")
    private Double beginprice;

    @Column(name = "endPrice")
    private Double endprice;

    /**
     * @return endlotId
     */
    public Integer getEndlotid() {
        return endlotid;
    }

    /**
     * @param endlotid
     */
    public void setEndlotid(Integer endlotid) {
        this.endlotid = endlotid;
    }

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
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
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
     * @return endPrice
     */
    public Double getEndprice() {
        return endprice;
    }

    /**
     * @param endprice
     */
    public void setEndprice(Double endprice) {
        this.endprice = endprice;
    }
}