package com.tree.bootroad.v004designpattern.atguigu.design.d11flyweight.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d11flyweight.sample.flyweight.WebSite;
import com.tree.bootroad.v004designpattern.atguigu.design.d11flyweight.sample.flyweight.WebSiteFactory;

public class Stage {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite newsWebSite = factory.getWebsite("news");
        newsWebSite.use();

        WebSite blogWebSite = factory.getWebsite("blog");
        blogWebSite.use();
    }

}
