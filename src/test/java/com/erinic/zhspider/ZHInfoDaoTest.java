package com.erinic.zhspider;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {
        "classpath*:config/spring-mvc.xml" ,
        "classpath*:config/spring-mybatis.xml"
})
public class ZHInfoDaoTest {

    @Autowired
    private ZhInfoDao zhInfoDao;

    @Test
    public void test() {
        ZhInfo zhInfo = new ZhInfo();
        zhInfo.setTitle("test1");
        try {
            final int add = zhInfoDao.insertSelective(zhInfo);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAll(){
        List<ZhInfo> zhInfos = zhInfoDao.getInfoLimit(1,3);
        for (ZhInfo zhInfo : zhInfos){
            System.out.println(zhInfo);
        }
    }

    @Test
    public void testFindById(){
        ZhInfo zhInfo = zhInfoDao.queryById(1);

            System.out.println(zhInfo);

    }
}
