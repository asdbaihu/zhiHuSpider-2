package com.erinic.zhspider.dao;

import com.erinic.zhspider.model.ZhInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
public interface ZhInfoDao {

    @Insert("INSERT ignore INTO zh_info (`title`,`content`,`author`,`summary`,`agree`,`attention`)  VALUES (#{title},#{content},#{author},#{summary},#{agree},#{attention})")
    int insertInfo(ZhInfo zhInfo);
}
