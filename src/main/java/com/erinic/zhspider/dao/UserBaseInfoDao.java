package com.erinic.zhspider.dao;

import com.erinic.zhspider.model.UserBaseInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public interface UserBaseInfoDao extends Mapper<UserBaseInfo> {

    int getAmountByReocordItem(UserBaseInfo record);

    List<UserBaseInfo> getList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    UserBaseInfo queryById(Integer userBaseInfoId);
}
