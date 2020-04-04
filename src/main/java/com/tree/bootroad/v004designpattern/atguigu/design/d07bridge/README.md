# 桥接模式(也叫包装器Wrapper)
基本介绍
1. 将抽象和实现放在两个不同的类层次, 使两个层次可以独立改变
1. 属于最小设计原则, 通过封装 聚合及继承等行为让不同的类承担不同职责
1. 主要特点是, 把抽象和行为实现分离开来, 保证各部门的独立性及功能扩展

原理说明:
1. Client: 桥接模式的调用者
1. Abstraction: 维护Implementor(它的实现), 两者聚合关系, Abstraction是桥接类
1. RefinedAbstraction: Abstraction的子类
1. ConcreteImplementor: 行为的具体实现类

注意事项和细节:
1. 抽象和实现的分离, 极大提高系统灵活性, 有助于系统分层设计
1. 对于系统的高层部分, 只需知道抽象部分和实现部分的接口即可, 其他部分由具体的业务完成
1. 桥接模式替代多层继承方案, 可减少子类的个数, 降低系统的管理和维护成本
1. 桥接模式增加了系统的理解和设计难度, 由于聚合关联建立在抽象层, 需要针对抽象层进行设计和编程
1. 桥接模式要求正确识别系统的两个独立变化的维度, 因此其使用范围有一定局限性

应用场景:
1. 对应不希望使用继承, 或因继承导致系统类数量剧增
1. 常见场景:
    - JDBC驱动
    - 银行转账
        - 转账分类: 网上 柜台 ATM
        - 用户分类: 普通用户 银卡用户 金卡用户
    - 消息管理
        - 消息类型: 即时消息 延时消息
        - 消息分类: 手机短信 邮件消息 QQ消息...