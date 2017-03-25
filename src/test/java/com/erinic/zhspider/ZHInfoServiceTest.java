package com.erinic.zhspider;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import com.erinic.zhspider.service.ZhInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class ZHInfoServiceTest {

    @Autowired
    private ZhInfoService zhInfoService;



    @Test
    public void testAll(){
        List<ZhInfo> zhInfos = zhInfoService.getInfoList(1,3);
        for (ZhInfo zhInfo : zhInfos){
            System.out.println(zhInfo);
        }
    }
}
