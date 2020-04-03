package com.tree.bootroad.v004designpattern.atguigu.principle.p01singleresponsibility;

/**
 * 方法级别的单一职责
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("自行车");

        vehicle.runAir("飞机");

        vehicle.runAir("轮船");
    }

    private static class Vehicle{

        public void run(String vehicle){
            System.out.println(vehicle + " 公路运行....");
        }


        public void runAir(String vehicle){
            System.out.println(vehicle + " 空中运行....");
        }


        public void runSea(String vehicle){
            System.out.println(vehicle + " 大海中运行....");
        }


    }

}


