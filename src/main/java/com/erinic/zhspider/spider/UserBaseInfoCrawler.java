package com.erinic.zhspider.spider;

import com.erinic.zhspider.extend.QueueNameConstant;
import com.erinic.zhspider.extend.RedisSchedulerExtend;
import com.erinic.zhspider.extend.RedisSchedulerExtend2;
import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.pipeline.UserBaseInfoDaoPipeline;
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
public class UserBaseInfoCrawler implements Crawler{

    private final static String START_URL = "http://www.zhihu.com/people/excited-vczh";
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
                .setTimeOut(3 * 60 * 1000),userBaseInfoDaoPipeline, UserBaseInfo.class)
                .scheduler(new RedisSchedulerExtend2(pool,1))
                .addUrl(START_URL)
                .thread(5)
                .run();
    }

    public static void main(String[] args) {
        applicationContext.getBean(UserBaseInfoCrawler.class).crawl();
    }
}
