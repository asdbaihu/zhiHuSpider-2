package com.erinic.zhspider.controller;

import com.erinic.zhspider.model.ZhInfo;
import com.erinic.zhspider.service.ZhInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "list";
    }

    @RequestMapping(value = "/{zhInfoId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("zhInfoId")Integer zhInfoId,
                         ModelMap model){

        if (zhInfoId == null){
            return "redirect:/info/list";
        }
        ZhInfo zhInfo = zhInfoService.findById(zhInfoId);
        if (zhInfo == null){
            return "forward:/info/list";
        }

        model.addAttribute("zhInfo",zhInfo);

        return "detail";
    }
}
