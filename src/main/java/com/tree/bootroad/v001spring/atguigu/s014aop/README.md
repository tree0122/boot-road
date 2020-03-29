### AOP
使用步骤:
1. 导入aop模块, Spring AOP (Spring-aspects)
1. 定义一个业务逻辑类; 需求是在业务运行时, 打印日志
1. 定义一个日志切面类; 切面类里面的方法, 动态感知业务逻辑的运行
    - @Before: 前置通知, 目标方法前
    - @After: 后置通知, 目标方法结束后(无论正常 异常)
    - @AfterReturning: 目标方法正常返回后通知
    - @AfterThrowing: 目标方法异常通知
    - @Around: 环绕通知, 手动目标方法运行(ProceedingJoinPoint.proceed())
1. 定义切面类的方法何时运行(通知注解)
1. 将切面类和业务类, 都交给容器
1. 指定切面类(@Aspect)
1. 给配置类添加@EnableAspectJAutoProxy, 开启基于注解的AOP

主要三步:
1. 将业务组件和切面组件加入容器, 并告诉Spring哪个是切面
1. 在切面组件的每个通知方法上, 标注通知注解, 告诉Spring何时何地运行(切点表达式)
1. 开启基于注解的AOP模式