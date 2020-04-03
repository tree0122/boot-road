package com.tree.bootroad.v004designpattern.atguigu.principle.p01singleresponsibility;

/**
 * 类级别的单一职责
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        roadVehicle.run("自行车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

        SeaVehicle seaVehicle = new SeaVehicle();
        seaVehicle.run("boat");
    }

    private static class RoadVehicle {
        public void run(String vehicle){
            System.out.println(vehicle + " 公路运行....");
        }
    }

    private static class AirVehicle {
        public void run(String vehicle){
            System.out.println(vehicle + " 空中运行....");
        }
    }

    private static class SeaVehicle {
        public void run(String vehicle){
            System.out.println(vehicle + " 大海运行....");
        }
    }

}


