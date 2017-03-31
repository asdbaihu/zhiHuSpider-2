package com.erinic.zhspider.spider;

import com.erinic.zhspider.dao.UserDetailInfoDao;
import com.erinic.zhspider.extend.QueueNameConstant;
import com.erinic.zhspider.extend.RedisSchedulerExtend;
import com.erinic.zhspider.model.UserDetailInfo;
import com.erinic.zhspider.pipeline.UserDetailInfoDaoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
@Component
public class UserDetailInfoCrawler implements Crawler{

    private final static String START_URL = "";

    @Autowired
    private UserDetailInfoDaoPipeline userDetailInfoDaoPipeline;

    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(300).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
            .setCharset("UTF-8")
            .addCookie("","")
            ;

    public void crawl() {
        OOSpider.create(site,userDetailInfoDaoPipeline , UserDetailInfo.class)
                //.setDownloader(new HttpClientDownloaderExtend("/about"))
                .scheduler(new RedisSchedulerExtend(pool,1, QueueNameConstant.QUEUE_USER_DETAIL_INFO))
                .addUrl(START_URL)
                .thread(4).run();


    }

    public static void main(String[] args) {
        applicationContext.getBean(UserDetailInfoCrawler.class).crawl();
    }

}
