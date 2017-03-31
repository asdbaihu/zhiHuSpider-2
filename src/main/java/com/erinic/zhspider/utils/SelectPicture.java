package com.erinic.zhspider.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class SelectPicture {

    public static String parse(String content){
        Element element = Jsoup.parse(content);
        Elements imgs = element.select("img");
        for (Element img : imgs){
            img.attr("src",img.attr("data-original"));
        }
        return element.html();
    }

}
