package com.erinic.zhspider.pipeline;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;


/**
 * Created by Administrator on 2017/3/16 0016.
 */
@Component("ZhInfoDaoPipeline")
public class ZhInfoDaoPipeline implements PageModelPipeline<ZhInfo> {

    @Autowired
    private ZhInfoDao zhInfoDao;

    @Override
    public void process(ZhInfo zhInfo, Task task) {
        zhInfoDao.insertSelective(zhInfo);
    }
}
