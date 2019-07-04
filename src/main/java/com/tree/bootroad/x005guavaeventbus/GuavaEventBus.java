package com.tree.bootroad.x005guavaeventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GuavaEventBus {
    final EventBus eventBus = new EventBus();

    public void biz(){
        eventBus.register(new Object(){

            @Subscribe
            public void lister(Integer a){
                log.info("Integer, param: {}", a);
            }

            @Subscribe
            public void lister(String s){
                log.info("string, param: {}", s);
            }

            @Subscribe
            public String lister(Person person){
                log.info("person, param: {}", person);
                return person.name;
            }

            @Subscribe
            public void lister(DeadEvent obj){
                log.info("DeadEvent, param: {}, source: {}, event: {}", obj, obj.getSource(), obj.getEvent());
            }
        });

        eventBus.post(1);
        eventBus.post("aaa");
        eventBus.post(new StringBuilder("sb"));
        eventBus.post(new Person(18, "nee"));
    }

    @Data
    @AllArgsConstructor
    private class Person{
        private int age;
        private String name;
    }

}
