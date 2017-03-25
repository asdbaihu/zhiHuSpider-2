package com.erinic.zhspider.service.impl;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import com.erinic.zhspider.service.ZhInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
@Service
public class ZhInfoServiceImpl implements ZhInfoService{

    @Autowired
    private ZhInfoDao zhInfoDao;

    @Override
    public List<ZhInfo> getInfoList(int offset,int limit){
        return zhInfoDao.getInfoLimit(offset,limit);
    }

    @Override
    public ZhInfo findById(int zhInfoId){
        return zhInfoDao.queryById(zhInfoId);
    }
}
