package com.erinic.zhspider.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.Id;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
@TargetUrl("https://www.zhihu.com/question/\\d+")
@HelpUrl("https://www.zhihu.com/topic/19551556/top-answers\\?page=\\d+")
public class ZhInfo implements AfterExtractor{

    @Id
    private Integer id;

    @ExtractBy("//h1[@class='QuestionHeader-title']/html()")
    private String title;

    @ExtractBy("//div[@class='RichContent RichContent--unescapable']/div[@class='RichContent-inner']/html()")
    private String content;

    @ExtractBy("//div[@class='AuthorInfo-content']/div[@class='AuthorInfo-title']//a[@class='UserLink-link']/html()")
    private String author;

    @ExtractBy("//div[@class='AuthorInfo']/div[@class='AuthorInfo-content']/div[@class='RichText AuthorInfo-badge']/html()")
    private String summary;

    @ExtractBy("//div[@class='AnswerItem-extraInfo']/span[@class='Voters']/button[@class='Button Button--plain']/html()/regex('[1-9]\\d*')")
    private Integer agree;

    private Integer attention;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getContent() {
        if (content != null){
            content.replace("noscript","");
        }
        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }


    @Override
    public void afterProcess(Page page) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }
}
