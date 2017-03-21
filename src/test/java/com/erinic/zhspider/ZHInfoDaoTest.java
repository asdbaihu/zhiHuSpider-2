package com.erinic.zhspider;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class ZHInfoDaoTest {
    @Resource
    private ZhInfoDao zhInfoDao;

    @Ignore
    @Test
    public void test() {
        ZhInfo zhInfo = new ZhInfo();
        zhInfo.setTitle("test");
        try {
            final int add = zhInfoDao.insertInfo(zhInfo);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
