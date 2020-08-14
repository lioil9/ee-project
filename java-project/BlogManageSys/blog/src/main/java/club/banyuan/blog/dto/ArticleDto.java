package club.banyuan.blog.dto;

import club.banyuan.blog.entity.TagEntity;

import java.sql.Timestamp;
import java.util.List;

public class ArticleDto {

  private Long id;
  private String title;
  private String mdContent;
  private String htmlContent;
  private String summary;
  private Long cid;
  private Long uid;
  private Timestamp publishDate;
  private Timestamp editTime;
  private Integer state;
  private Integer pageView;
  private String nickname;
  private String cateName;
  private List<TagEntity> tags;
  private String[] dynamicTags;

  public String[] getDynamicTags() {
    return dynamicTags;
  }

  public void setDynamicTags(String[] dynamicTags) {
    this.dynamicTags = dynamicTags;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMdContent() {
    return mdContent;
  }

  public void setMdContent(String mdContent) {
    this.mdContent = mdContent;
  }

  public String getHtmlContent() {
    return htmlContent;
  }

  public void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Long getCid() {
    return cid;
  }

  public void setCid(Long cid) {
    this.cid = cid;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public Timestamp getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Timestamp publishDate) {
    this.publishDate = publishDate;
  }

  public Timestamp getEditTime() {
    return editTime;
  }

  public void setEditTime(Timestamp editTime) {
    this.editTime = editTime;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Integer getPageView() {
    return pageView;
  }

  public void setPageView(Integer pageView) {
    this.pageView = pageView;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getCateName() {
    return cateName;
  }

  public void setCateName(String cateName) {
    this.cateName = cateName;
  }

  public List<TagEntity> getTags() {
    return tags;
  }

  public void setTags(List<TagEntity> tags) {
    this.tags = tags;
  }
}
