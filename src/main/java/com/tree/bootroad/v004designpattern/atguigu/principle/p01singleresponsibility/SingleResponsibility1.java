package com.tree.bootroad.v004designpattern.atguigu.principle.p01singleresponsibility;

public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("自行车");

        vehicle.run("飞机");
    }

    private static class Vehicle{

        public void run(String vehicle){
            System.out.println(vehicle + " 公路运行....");
        }

    }
}



