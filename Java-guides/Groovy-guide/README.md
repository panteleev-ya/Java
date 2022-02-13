# Гайд на Groovy
## Нет примитивных типов
Все переменные - объекты, без исключения. Примитивы сразу же упакованы в классы-обертки (даже при том, что у вас может 
быть `int x` - он на самом деле является `Integer x`)
## Строки как в Python
В Groovy можно определить "java-строку" или "groovy-строку". В первом случае строка должна быть в одинарных кавычках, а 
во втором - в двойных. Преимущество "groovy-строк" в том, что в них можно вставлять параметры. А еще можно создавать 
многострочные строки. Примеры:
```python
javaString = 'java'
groovyString = "${javaString}"
j = '${javaString}' 
bigGroovyString = """
    ${javaString}
    ${groovyString}
    ${j}
    ${2 + 2}
"""

println bigGroovyString
```
Будет выведено
```python
java
java
${javaString}
4
```
Строки можно складывать и умножать на число
## Словари и списки как в Python
```commandline
groovy:000> a = [1, 3, 5]
===> [1, 3, 5]
groovy:000> b = [1: true, 0: false]
===> {1=true, 0=false}
```
## Диапазоны как в Ruby
```commandline
groovy:000> a = "1234567890"
===> 1234567890
groovy:000> a[0..4]
===> 12345
groovy:000> a[-1..0]
===> 0987654321
groovy:000> a[1, 3, 5]
===> 246
groovy:000> b = 1..5
===> 1..5
groovy:000> a[b]
===> 23456
```
## Циклы как в Java
```java
for (i in 0..9) { 
    print i 
}

for (int i = 0; i < 10; i++) {
    print i
}

for (Integer i : 0..9) { 
    print i 
}
```
## Функции как в Python
```python
def functionA(argA) {
    print ArgA
}

int functionB(int argB) {
    print argB
    return argB
}

String fuctionC() {
    "Hello World"
}
```
## Больше по теме
[Статья на Хабре](https://habr.com/ru/post/122127/)  
[Википедия](https://ru.wikipedia.org/wiki/Groovy)