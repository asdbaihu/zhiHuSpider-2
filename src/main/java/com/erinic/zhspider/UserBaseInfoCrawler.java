package com.erinic.zhspider;

import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.model.ZhInfo;
import com.erinic.zhspider.pipeline.UserBaseInfoDaoPipeline;
import com.erinic.zhspider.pipeline.ZhInfoDaoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
@Component
public class UserBaseInfoCrawler {

    @Qualifier("UserBaseInfoDaoPipeline")
    @Autowired
    private UserBaseInfoDaoPipeline userBaseInfoDaoPipeline;

    public void crawl() {
        OOSpider.create(Site.me()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .setCharset("UTF-8")
                .setCycleRetryTimes(5)
                .setRetryTimes(5)
                .setSleepTime(500)
                .addCookie("d_c0","AGCAlv86bwqPTpqFvJevJXYb0WsTBUcCVLA=|1472043241")
                .addCookie("_za","cac22b14-8717-4c77-b236-5d3ff8c4cc4c")
                .addCookie("_zap","ae7e0824-17b1-410d-9d44-68818c4bf997")
                .addCookie("q_c1","9e9f2e96c1174765b39b240fa5e7d3fe|1489578277000|1486736430000")
                .addCookie("r_cap_id","OWQzN2UzZmJkMzVjNDYxYTk4YTc5OTI0MjRmYmMwODc=|1489668418|19a2bf6ab42a70aa1bfc96015ae03ed6df175dee")
                .addCookie("cap_id","ZjhhNDU1NDQ1ZGExNGEzN2EwZmYxZDE5NzA4ZGU5NDk=|1489668418|4a7b8b716efdee37305b8e6df1749e9e8577875b")
                .addCookie("_xsrf","1d9925a54b2d1f005e5c8852362aa12e")
                .addCookie("__utma","51854390.1600670503.1490102081.1490102081.1490102081.1")
                .addCookie("__utmz","51854390.1490102081.1.1.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/question/34544815")
                .addCookie("__utmv","51854390.100-1|2=registration_date=20150915=1^3=entry_date=20150915=1")
                .addCookie("liyungf_tc","AQAAALf8/mLvugMAzhPebzMFn4rB/jA+")
                .addCookie("z_c0","Mi4wQUJETWZrSU50QWdBWUlDV196cHZDaGNBQUFCaEFsVk5hUmZ5V0FDX1RhLUNNWUpmTEZOLURxd0l1a1Ffc3ZJSEZ3|1490618935|838cd855387ffd2f39f8721ac0cdad8dde5d3fa8")
                .setTimeOut(3 * 60 * 1000),userBaseInfoDaoPipeline, UserBaseInfo.class)
                .addUrl("http://www.zhihu.com/people/excited-vczh")
                .thread(5)
                .run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/config/spring-*.xml");
        final UserBaseInfoCrawler zhInfoCrawler = applicationContext.getBean(UserBaseInfoCrawler.class);
        zhInfoCrawler.crawl();
    }
}
