### Profile

 @Profile: 写在配置类上, 仅指定的环境时, 整个配置类里的所有bean才生效
 1. Spring根据当前环境, 动态的激活和切换一系列组件
 1. 指定组件在哪个环境下能注册到容器; 不指定, 任何环境下都能注册到容器
    - 加了环境标示的bean, 只有这个环境下能被注册到容器. 默认为default
    - vm参数(-Dspring.profiles.active=dev), 可命令行指定环境标识
    - 代码的方式, context创建时指定其环境标识