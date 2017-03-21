package com.erinic.zhspider.pipeline;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/16 0016.
 */
@Component("ZhInfoDaoPipeline")
public class ZhInfoDaoPipeline implements PageModelPipeline<ZhInfo> {

    @Resource
    private ZhInfoDao zhInfoDao;

    @Override
    public void process(ZhInfo zhInfo, Task task) {
        zhInfoDao.insertInfo(zhInfo);
    }
}
