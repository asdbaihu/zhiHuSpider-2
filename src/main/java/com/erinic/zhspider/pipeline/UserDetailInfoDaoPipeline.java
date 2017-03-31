package com.erinic.zhspider.pipeline;

import com.erinic.zhspider.dao.UserBaseInfoDao;
import com.erinic.zhspider.dao.UserDetailInfoDao;
import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.model.UserDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by asus on 2017/3/25.
 */
@Component("UserDetailInfoDaoPipeline")
public class UserDetailInfoDaoPipeline implements PageModelPipeline<UserDetailInfo> {

    @Autowired
    private UserDetailInfoDao userDetailInfoDao;

    @Override
    public void process(UserDetailInfo userDetailInfo, Task task) {
        userDetailInfoDao.insertSelective(userDetailInfo);
    }
}
