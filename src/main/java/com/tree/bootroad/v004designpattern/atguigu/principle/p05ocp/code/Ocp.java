package com.tree.bootroad.v004designpattern.atguigu.principle.p05ocp.code;

public class Ocp {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShap(new Rectangle());
        graphicEditor.drawShap(new Circle());

        graphicEditor.drawShap(new OtherShape());
    }

}
