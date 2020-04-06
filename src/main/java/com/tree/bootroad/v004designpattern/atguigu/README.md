# 设计模式
### 设计模式的目的
1. 代码重用性: 相同代码不多次重复编写
1. 可读性: 编程规范性, 便于阅读和理解
1. 可扩展性: 新增功能时, 很方便
1. 可靠性: 新增功能时, 对原来功能没有影响
1. 程序高内聚 低耦合: 模块内部很紧密, 模块直接耦合很低

### 七大设计原则
1. [单一职责](./principle/p01singleresponsibility/README.md)  
    - 定义: 对于类来说, 一个类应该只负责一项职责.  
    - 使用: 如果一个类A负责功能1和功能2, 当功能1的需求变化时, 影响功能2, 则A应该拆分为2个类A1和A2
1. [接口隔离](./principle/p02interfacesegregation/README.md)   
    - 定义: 客户端不应该依赖它不需要的接口, 即类对其他类的依赖应建立在最小的接口上
1. [依赖倒置](./principle/p03inversion/README.md) 
    - 定义: 
        1. 高层模块不应该依赖低层模块, 二者都应该依赖其他抽象
        1. 抽象不应该依赖细节, 细节应该依赖抽象
        1. 中心思想是面向接口编程
    - 设计理念:
        - 细节多变性
        - 抽象稳定
        - 抽象目的是制定好规范, 细节交给实现完成
1. [里氏替换](./principle/p04liskow/README.md) 
    - 背景
        - 继承, 父类实现好的方法, 可能被子类进行修改
        - 父类方法的变更, 可能影响其所有子类
    - 定义
        - 所有引用基类的地方必须能透明的使用其子类的对象
        - 使用继承时, 子类中尽量不重写父类方法
        - 继承实际上让父子类耦合增强, 适当情况下, 可聚合 组合 依赖解决问题
    - 解决方法
        - 将原来的父类和子类都继承一个更通俗的基类
        - 原有的继承关系去掉, 采用依赖 聚合 组合等关系代替
1. [开闭原则(ocp)](./principle/p05ocp/README.md) 
    - 最继承 最重要的设计原则
    - 软件的实体如类 模块 和函数, 对扩展开放(提供方), 对修改关闭(使用方). 抽象构建框架, 实现扩展细节
    - 需要变化时, 尽量扩展软件的行为来实现变化, 而不是通过修改已有的代码来实现变化
    - 其他的原则和设计模式, 他们的目的就是遵循开闭原则
1. 迪米特法则
    - 一个对象应该对其他对象保持最少的了解
    - 类与类关系越密切, 耦合度越大
    - 迪米特法则又叫最少知道原则, 即对依赖的类知道的越少越好
    - 简单的定义, 只与直接的朋友通讯
    - 直接朋友: 
        - 成员变量 方法参数 方法返回值 都是直接的朋友
        - 陌生的类最好不要以局部变量形式出现在类的内部
1. 合成复用
    - 尽量使用合成/聚合的方式, 而不使用继承

### 23种设计模式  
创建型:
1. [singleton(单例)](./design/d01singleton/README.md)   
    - 设计层面, 采取一定的方法保证整个系统中, 对某个类只存在一个对象实例
    - 该类只提供一个取得其对象实例的方法
1. [Factory(简单工厂/工厂方法)](./design/d02factory/README.md)    
1. [AbstractFactory(抽象工厂)](./design/d03abstractfactory/README.md)    
1. [prototype(原型)](./design/d04prototype/README.md)   
1. [builder(建造者)](./design/d05builder/README.md)   
 
结构型:
1. [adapter(适配器)](./design/d06adapter/README.md) 
1. [bridge(桥接)](./design/d07bridge/README.md) 
1. [decorator(装饰)](./design/d08decorator/README.md) 
1. [composite(组合)](./design/d09composite/README.md) 
1. [facade(外观)](./design/d10facade/README.md) 
1. [flyweight(享元)](./design/d11flyweight/README.md) 
1. [proxy(代理)](./design/d12proxy/README.md) 
 
行为型:
1. [template(模板)](./design/d13template/README.md) 
1. [command(命令)](./design/d14command/README.md) 
1. [visitor(访问者)](./design/d15visitor/README.md) 
1. [iterator(迭代器)](./design/d16iterator/README.md) 
1. [observer(观察者)](./design/d17observer/README.md) 
1. [mediator(中介者)](./design/d18mediator/README.md) 
1. [memento(备忘录)](./design/d19memento/README.md) 
1. [interpreter(解释器)](./design/d20interpreter/README.md) 
1. [state(状态)](./design/d21state/README.md) 
1. [strategy(策略)](./design/d22strategy/README.md) 
1. [chain(责任链)](./design/d23chain/README.md) 