package com.tree.bootroad.x008customstarter;

import com.tree.autoconfigure.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ExampleServiceUse {

    @Resource
    private ExampleService exampleService;

    public String wrap(String word){
        String wrap = exampleService.wrap(word);
        log.info("wrap word: {} ========", wrap);
        return wrap;
    }

}
