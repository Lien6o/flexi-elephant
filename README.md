# flexi-elephant

基于可靠事件模式和Saga分布式解决方案框架

[toc]

# Futures


# Design

1. 可靠事件模式完整保存了业务生命周期流转节点，溯源
2. 事件模式和循环loop保证事件执行并同步至TC
3. TC负责协调整个服务，作出下一步Sage指令。


## loop
SPI使用

## event
1. getEvent
2. onEvent
