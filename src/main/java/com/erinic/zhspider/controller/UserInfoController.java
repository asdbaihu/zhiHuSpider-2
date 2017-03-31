package com.erinic.zhspider.controller;

import com.alibaba.fastjson.JSON;
import com.erinic.zhspider.dao.UserBaseInfoDao;
import com.erinic.zhspider.dao.UserDetailInfoDao;
import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.model.UserDetailInfo;
import com.erinic.zhspider.model.extend.BarInfoData;
import com.erinic.zhspider.model.extend.NameValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/3/27.
 */
@Controller
public class UserInfoController {

    @Autowired
    private UserBaseInfoDao userBaseInfoDao;

    @Autowired
    private UserDetailInfoDao userDetailInfoDao;

    @RequestMapping("/zhihu")
    public String showPage(ModelMap model) {
        System.out.println("----------");
        model.put("test", "test");
        return "zhihu";

    }

    @RequestMapping(value = "getAmount/{type}")
    public @ResponseBody
    Integer getAmountByType(@PathVariable String type){
        Integer result = 0;
        if(type.equals("base")){
            UserBaseInfo record = new UserBaseInfo();
            result = userBaseInfoDao.selectCount(record);
            System.out.println("基本信息人数    "+result );
        }
        else{
            UserDetailInfo record2 = new UserDetailInfo();
            result = userDetailInfoDao.selectCount(record2);
            System.out.println("详细信息人数     "+result);
        }
        return result;
    }

    @RequestMapping(value = "searchByName")
    public  @ResponseBody
    List<UserBaseInfo> searchByName(@RequestParam(value = "name",  required = true)String name){
        Example example1 = new Example(UserBaseInfo.class);
        example1.selectProperties("userName","coverPicture","education","company","summary");
        example1.createCriteria().andLike("userName", name);
        List<UserBaseInfo> result = (List<UserBaseInfo>) userBaseInfoDao.selectByExample(example1);
        System.out.println("查找昵称为"+name+"结果为 "+ JSON.toJSONString(result));
        return result;
    }
    @RequestMapping("getGenderInfo")
    public @ResponseBody List<NameValue> getGenderInfo(){
        List<NameValue> results = new ArrayList<NameValue>();

        UserDetailInfo record4 = new UserDetailInfo();
        record4.setSex("Icon Icon--male");
        Integer man = userDetailInfoDao.selectCount(record4);

        UserDetailInfo record5 = new UserDetailInfo();
        record5.setSex("Icon Icon--female");
        Integer girl = userDetailInfoDao.selectCount(record5);

        Example example = new Example(UserDetailInfo.class);
        example.createCriteria().andIsNull("gender");
        Integer unknow = userDetailInfoDao.selectCountByExample(example);

        results.add(new NameValue("男",man));
        results.add(new NameValue("女",girl));
        results.add(new NameValue("未知",unknow));

        System.out.println(JSON.toJSONString(results));
        return results;
    }

    @RequestMapping("getLocationInfo")
    public @ResponseBody BarInfoData getLocationInfo(){
        List<UserBaseInfo> result =  userBaseInfoDao.getLocationStatic(10);
        System.out.println("人群地域分布"+JSON.toJSONString(result));
        String[] sxAxis = new String[result.size()];
        Integer[] yAxis = new Integer[result.size()];
        for(int i=0;i<result.size();i++){
//            sxAxis[i] = result.get(i).getLocation();
            yAxis[i]  = result.get(i).getItemResultAmount();
        }
        BarInfoData data = new BarInfoData(yAxis,sxAxis);
        data.setsXAxis(sxAxis);
        data.setyAxis(yAxis);
        System.out.println(JSON.toJSONString(data));
        return data;
    }

    @RequestMapping("getBusinessStatic")
    public @ResponseBody BarInfoData getBusinessStatic(){
        List<UserDetailInfo> result =  userDetailInfoDao.getBusinessStatic(10);
        System.out.println("人群行业分布"+JSON.toJSONString(result));
        String[] sxAxis = new String[result.size()];
        Integer[] yAxis = new Integer[result.size()];
        for(int i=0;i<result.size();i++){
            sxAxis[i] = result.get(i).getCompany();
            yAxis[i]  = result.get(i).getItemResultAmount();
        }
        BarInfoData data = new BarInfoData(yAxis,sxAxis);
        data.setsXAxis(sxAxis);
        data.setyAxis(yAxis);
        System.out.println(JSON.toJSONString(data));
        return data;
    }

    @RequestMapping("getEducationStatic")
    public @ResponseBody BarInfoData getEducationStatic(){
        List<UserDetailInfo> result =  userDetailInfoDao.getEducationStatic(10);
        System.out.println("人群受教育程度分布"+JSON.toJSONString(result));
        String[] sxAxis = new String[result.size()];
        Integer[] yAxis = new Integer[result.size()];
        for(int i=0;i<result.size();i++){
            sxAxis[i] = result.get(i).getEducation();
            yAxis[i]  = result.get(i).getItemResultAmount();
        }
        BarInfoData data = new BarInfoData(yAxis,sxAxis);
        data.setsXAxis(sxAxis);
        data.setyAxis(yAxis);
        System.out.println(JSON.toJSONString(data));
        return data;
    }

	/*@RequestMapping("getEmploymentStatic")
	public @ResponseBody BarInfoData getEmploymentStatic(){
		List<UserDetailInfo> result =  userDetailInfoMapper.getEmploymentStatic(10);
 		System.out.println("人群身份分布"+JSON.toJSONString(result));
 		String[] sxAxis = new String[result.size()];
 		Integer[] yAxis = new Integer[result.size()];
 		for(int i=0;i<result.size();i++){
 			sxAxis[i] = result.get(i).getEmployment();
 			yAxis[i]  = result.get(i).getItemResultAmount();
 		}
 		BarInfoData data = new BarInfoData(yAxis,sxAxis);
 		data.setsXAxis(sxAxis);
 		data.setyAxis(yAxis);
 		System.out.println(JSON.toJSONString(data));
 		return data;
	}*/

    @RequestMapping("getEmploymentStatic")
    public @ResponseBody List<NameValue>  getEmploymentStatic(){
        List<UserDetailInfo> result =  userDetailInfoDao.getEmploymentStatic(10);
        List<NameValue>  data = new ArrayList<NameValue>();
        for(UserDetailInfo item:result){
           NameValue re = new NameValue(item.getCompany(), item.getItemResultAmount());
            data.add(re);
        }
        System.out.println(JSON.toJSONString(data));
        return data;
    }

    enum Gender{
        female,male,unknow
    }
    public int geAmountByGender(String gender){
        UserDetailInfo record = new UserDetailInfo();
        if(gender.equals(Gender.female.toString()))
            record.setSex(Gender.female.toString());
        else if(gender.equals(Gender.male.toString()))
            record.setSex(Gender.male.toString());
        else
            record.setSex(null);

        return userDetailInfoDao.selectCount(record);
    }
}
