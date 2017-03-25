package com.erinic.zhspider.pipeline;

import com.erinic.zhspider.dao.UserBaseInfoDao;
import com.erinic.zhspider.model.UserBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by asus on 2017/3/25.
 */
@Component("UserBaseInfoDaoPipeline")
public class UserBaseInfoDaoPipeline implements PageModelPipeline<UserBaseInfo> {

    @Autowired
    private UserBaseInfoDao userBaseInfoDao;

    @Override
    public void process(UserBaseInfo userBaseInfo, Task task) {
        userBaseInfoDao.insertSelective(userBaseInfo);
    }
}
