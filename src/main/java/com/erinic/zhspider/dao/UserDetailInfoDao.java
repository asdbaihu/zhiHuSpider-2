package com.erinic.zhspider.dao;

import com.erinic.zhspider.model.UserBaseInfo;
import com.erinic.zhspider.model.UserDetailInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public interface UserDetailInfoDao extends Mapper<UserDetailInfo> {

    List<UserDetailInfo> getBusinessStatic(Integer selectLimitAmount);

    List<UserDetailInfo> getEmploymentStatic(Integer selectLimitAmount);

    List<UserDetailInfo> getEducationStatic(Integer selectLimitAmount);
}
