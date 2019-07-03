package com.tree.bootroad.x004event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == ContentEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == String.class;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("order receive, source: {}", event.getSource());
    }
}
