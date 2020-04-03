1. **自定义starter**  
    - starter: 
           
        - 场景所需要的依赖  
        - 如何编写自动配置
            ```java
               @Configuration // 指定是配置类
               @ConditionalOnXXX // 使配置类生效的条件
               @AutoConfigureAfter // 配置类顺序
               @EnableConfigurationProperties // 配置类顺序
               public class AutoConfig{
                   @Bean // 容器添加组件
                   public Object(){
                       return new Object();
                   }
               }
            ```
        - 自动配置类生效  
            将需要启动时加载的自动配置类, 配置在 META-INF/spring.factories, 如:  
            org.springframework.boot.autoconfigure.EnableAutoConfiguration=...AutoConfig
        
    - 编写模式  
        - starter模块是一个空jar, 仅提供辅助依赖管理
        - 另起一个自动配置模块
        - starter依赖自动配置
        - 使用时只需引入starter
        - 推荐命名: 
            - spring-boot-starter-web: 官方
            - mybatis-spring-boot-starter: 自定义