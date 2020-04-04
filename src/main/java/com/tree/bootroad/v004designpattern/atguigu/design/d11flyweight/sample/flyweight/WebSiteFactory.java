package com.tree.bootroad.v004designpattern.atguigu.design.d11flyweight.sample.flyweight;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {

    private Map<String, WebSite> pool = new HashMap<>();

    public WebSite getWebsite(String type){
        if (!pool.containsKey(type)){
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    public int webSiteCount(){
        return pool.size();
    }

}
