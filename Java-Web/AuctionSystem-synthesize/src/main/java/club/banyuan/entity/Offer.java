package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

public class Offer {
    @Id
    @Column(name = "offerId")
    private Integer offerid;

    private Integer userid;

    @Column(name = "offerTime")
    private Date offertime;

    private Double price;

    private Integer lotid;

    /**
     * @return offerId
     */
    public Integer getOfferid() {
        return offerid;
    }

    /**
     * @param offerid
     */
    public void setOfferid(Integer offerid) {
        this.offerid = offerid;
    }

    /**
     * @return userid
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
     * @return offerTime
     */
    public Date getOffertime() {
        return offertime;
    }

    /**
     * @param offertime
     */
    public void setOffertime(Date offertime) {
        this.offertime = offertime;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return lotid
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
}