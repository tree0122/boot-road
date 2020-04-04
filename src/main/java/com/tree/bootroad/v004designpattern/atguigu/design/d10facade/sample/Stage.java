package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite.HomeTheaterFacade;

public class Stage {

    public static void main(String[] args) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.ready();
        facade.play();

        facade.end();
    }

}
