package com.erinic.zhspider.service;

import com.erinic.zhspider.dao.ZhInfoDao;
import com.erinic.zhspider.model.ZhInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Service
public interface ZhInfoService {

    List<ZhInfo> getInfoList(int offset,int limit);

    ZhInfo findById(int zhInfoId);
}
