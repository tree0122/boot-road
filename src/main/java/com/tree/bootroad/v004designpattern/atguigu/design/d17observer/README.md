# 观察者模式
基本介绍:
1. 对象之间是多对一的方案
1. 被依赖对象是 Subject, 依赖对象是 Observer
1. Subject通知Observer变化
1. Subject是一的一方, Observer是多的一方

注意事项和细节:
1. 优点:
    - 以集合方式管理用户(Observer), 包括注册 移除 通知
    - 增加观察者时, 不用去修改 Subject