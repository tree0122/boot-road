package com.tree.bootroad.x004event;

import org.springframework.context.ApplicationEvent;

public class ContentEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ContentEvent(Object source) {
        super(source);
    }
}
