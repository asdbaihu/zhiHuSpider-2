package com.erinic.zhspider.controller;

import com.erinic.zhspider.model.ZhInfo;
import com.erinic.zhspider.service.ZhInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
@Controller
@RequestMapping("/info")
public class ZhInfoController {

    @Autowired
    private ZhInfoService zhInfoService;

    @RequestMapping("/list")
    public String getList(ModelMap model){
        List<ZhInfo> list = zhInfoService.getInfoList(1,3);
        model.put("list",list);
        return "zhihu";
    }
}
