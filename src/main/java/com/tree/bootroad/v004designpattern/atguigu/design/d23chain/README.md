# 责任链模式
基本介绍: 
1. 为请求创建了一个接受者对象的链, 对请求发送者和接受者进行解耦
1. 每个接受者包含另一个接受者, 如果当前接受者不能处理, 那么把请求交给下个接受者

原理图:
1. Handler: 抽象的请求处理者
1. ConcreteHandler: 具体的处理者, 负责处理请求, 如果不能处理, 交给下个处理器
1. Request: 表示一个请求

注意事项和细节:
1. 将请求和处理分开, 实现解耦
1. 简化对象, 对象不需要指定链的结构
1. 性能会受影响, 特别是链比较长的时候, 需要控制链的最大节点数量
1. 调试不方便, 类似递归
1. 最佳应用场景: 有多个对象可以处理同一个请求时
    - 多级请求
    - 请假/加薪等审批六朝
    - 拦截器等