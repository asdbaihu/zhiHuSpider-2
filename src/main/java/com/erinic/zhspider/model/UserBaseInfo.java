package com.erinic.zhspider.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;

import javax.persistence.Id;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class UserBaseInfo {

    @Id
    private Integer id;

    @ExtractBy("//h1[@class='ProfileHeader-title']/span[1]/html()")
    private String userName;

    @ExtractBy("//h1[@class='ProfileHeader-title']/span[2]/html()")
    private String summary;

    @ExtractBy("//div[@class='ProfileHeader-info']/div[1]/text()")
    private String company;

    @ExtractBy("//div[@class='Card']/div[@class='ProfileHeader-wrapper']//img/@src")
    private String coverPicture;

    @ExtractBy("//div[@class='ProfileHeader-info']/div[2]/text()")
    private String education;

    @ExtractBy("//div[@class='ProfileHeader-info']/div[2]/div[4]/svg/@class")
    private String sex;

    @ExtractBy("//div[@class='NumberBoard FollowshipCard-counts']/a[1]/html()/regex('[1-9]\\d*')")
    private Integer attention;

    @ExtractBy("//div[@class='NumberBoard FollowshipCard-counts']/a[2]/html()/regex('[1-9]\\d*')")
    private Integer batt;

    @ExtractBy("//div[@class='ProfileMain-header']/ul[@role='tablist']/li[2]/a/html()/regex('[1-9]\\d*')")
    private Integer answer;

    @ExtractBy("//div[@class='ProfileMain-header']/ul[@role='tablist']/li[3]/a/html()/regex('[1-9]\\d*')")
    private Integer link;

    @ExtractBy("//div[@class='ProfileMain-header']/ul[@role='tablist']/li[4]/a/html()/regex('[1-9]\\d*')")
    private Integer question;

    @ExtractBy("//div[@class='ProfileMain-header']/ul[@role='tablist']/li[5]/a/html()/regex('[1-9]\\d*')")
    private Integer favorite;

    @ExtractBy("//div[@class='Profile-sideColumnItems']/div[2]/html()/regex('[1-9]\\d*+\\s次赞同')/regex('[1-9]\\d*')")
    private Integer like;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getBatt() {
        return batt;
    }

    public void setBatt(Integer batt) {
        this.batt = batt;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getLink() {
        return link;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
