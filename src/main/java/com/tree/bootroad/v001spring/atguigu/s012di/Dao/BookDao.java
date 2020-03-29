package com.tree.bootroad.v001spring.atguigu.s012di.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    private String label = "1";

    public void setLabel(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }

}
