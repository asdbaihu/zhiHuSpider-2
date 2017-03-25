package com.erinic.zhspider.dao;

import com.erinic.zhspider.model.ZhInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
public interface ZhInfoDao extends Mapper<ZhInfo>{

    List<ZhInfo> getInfoLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    ZhInfo queryById(Integer zhInfoId);

//    int getAmountByReocordItem(ZhInfo record);
}
