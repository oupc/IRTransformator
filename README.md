# IRTransformator
Convert AST to IR for Java

这个项目基于JDT，目前也只是打算将JDT中的AST->IR。

用IR建立控制流分析、数据流分析都要比基于语法树建立简单很多。

希望该项目能帮到各位。

----
结构的定义：
1.      load x = a.y
2.      store a.x = y
3.      assignement x=y


