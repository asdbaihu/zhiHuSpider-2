package com.erinic.zhspider.dao;

import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.model.ZhInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {
        "classpath*:config/spring-mvc.xml" ,
        "classpath*:config/spring-mybatis.xml"
})
public class UserInfoDaoTest {

    @Autowired
    private UserBaseInfoDao userBaseInfoDao;

    @Test
    public void test() {
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setUserName("test1");
        try {
            final int add = userBaseInfoDao.insertSelective(userBaseInfo);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testAll(){
//        List<ZhInfo> zhInfos = zhInfoDao.getInfoLimit(1,3);
//        for (ZhInfo zhInfo : zhInfos){
//            System.out.println(zhInfo);
//        }
//    }
//
    @Test
    public void testFindById(){
        UserBaseInfo userBaseInfo = userBaseInfoDao.queryById(1);

            System.out.println(userBaseInfo);

    }
}
