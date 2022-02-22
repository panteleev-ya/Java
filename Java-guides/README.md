# Гайд по Java
## Оглавление
+ [Архитектура проекта](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#архитектура-проекта)
+ [Примитивные типы данных](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#примитивные-типы-данных)
+ [Как устроена Java](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#как-устроена-java)
+ [Базовый синтаксис](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#базовый-синтаксис)
  + [Переменные примитивных типов данных](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Переменные-примитивных-типов-данных)
  + [Все остальные переменные](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Все-остальные-переменные)
    + [Константы](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Константы)
    + [Ключевое слово var](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Ключевое-слово-var)
  + [Условные операторы](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Условные-операторы)
  + [Циклы](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Циклы)
    + [`while`](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#while)
    + [`do..while`](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#dowhile)
    + [`for`](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#for)
    + [`for each..`](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#for-each)
  + [Пользовательский ввод и вывод в консоль](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Пользовательский-ввод-и-вывод-в-консоль)
    + [Создание сканнера](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Создание-сканнера)
    + [Задать разделитель для вводимых данных](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Задать-разделитель-для-вводимых-данных)
    + [Использование сканнера](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Использование-сканнера)
  + [Массивы](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Массивы)
    + [Создание массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Создание-массива)
    + [Свойства массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Свойства-массива)
    + ["Неровные массивы"](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Неровные-массивы)
    + [Вывод массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Вывод-массива)
    + [Сравнение массивов](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Сравнение-массивов)
    + [Заполнение массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Заполнение-массива)
    + [Копирование массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Копирование-массива)
    + [Сортировка массива](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Сортировка-массива)
  + [Строки](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Строки)
    + [Создание новой строки](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Создание-новой-строки)
    + [Полезные методы строк](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Полезные-методы-строк)
    + [Сравнение строк](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Сравнение-строк)
    + [Поиск префикса и суффикса](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Поиск-префикса-и-суффикса)
    + [Поиск подстрок](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Поиск-подстрок)
    + [Регулярные выражения](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Регулярные-выражения)
  + [Функции](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Функции)
    + [Модификаторы прав доступа](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Модификаторы-прав-доступа)
    + [`static` или не `static`](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#static-или-не-static)
    + [Исключения](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Исключения)
  + [Классы](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Классы)
    + [Создание класса](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Создание-класса)
    + [Наследование](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Наследование)
    + [Импорт класса](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Импорт-класса)
  + [Псевдослучайные числа в Java](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Псевдослучайные-числа-в-Java)
  + [Другое](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Другое)
    + [Паузы в программе](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Паузы-в-программе)
    + [Побитовые операции](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Побитовые-операции)
    + [Работа с флагами](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Работа-с-флагами)
    + [Простое шифрование](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Простое-шифрование)
    + [Другие системы счисления](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#Другие-системы-счисления)
## Архитектура проекта
Проект на Java состоит из пакетов. Пакеты состоят из классов, а классы - из методов. Для запуска проекта необходимо иметь 
класс (например, Main) и метод main внутри него.
```java
public class Main {
    public static void main(String[] args) {
    }
}
```
Причем имя пакета - путь от **_корня программы_** к папке с классами. Например, если путь к файлу (классу) `Solution.java` - 
`\com\javarush\tasks\Solution.java`, то имя пакета - `com.javarush.tasks`.  
**Корнем программы** является папка `src`. Если есть папка `С:\...\ projectname\src\ com\javarush\tasks\`, то название 
пакета будет - `com.javarush.tasks`.  
Каждый файл в пакете должен содержать следующий код
```java
package имя-пакета;

public class Имя-класса
{

}
```
## Как устроена Java
### Переменные - объекты
Все переменные в Java являются объектами (кроме примитивов, но и у них есть классы-обертки)
### StringPool
Все строковые переменные (класс `String`) хранятся в специальном `StringPool`, причем в одном экземпляре. То есть при
создании двух строк с одинаковыми литералами (с одинаковым наполнением) их ссылки на место в `StringPool` будут равны 
(`a.intern() == b.intern()` - true), но сами переменные, хранящие ссылки, не будут равны (`a == b` - false).
## Базовый синтаксис
### Переменные
Создать переменную и задать ей значение:  
`Type name = value;`, `value` указывать необязательно  
Пример:  
```java
double number = 12.0;
String str = new String("this is string");
int[] array = new int[10];
```
#### Переменные примитивных типов данных
Всего в Java существует 8 примитивных типов данных
+ Целые числа
  + `byte` (8 bit - 1 byte)
  + `short` (16 bit - 2 byte)
  + `int` (32 bit - 4 byte)
  + `long` (64 bit - 8 byte), доступно указание `l`/`L` - `600L`
+ Числа с плавающей точкой
  + `float` (32 bit - 4 byte), обязательно указание `f`/`F` - `3.14f`
  + `double` (64 bit - 8 byte), доступно указание `d`/`D` - `2.71d`
+ Логический тип
  + `bool` (32 bit - 4 byte)
+ Символьный тип
  + `char` (16 bit - 2 byte)  
  Один и тот же символ может быть представлен как:
    + 1078 - индекс символа в таблице UTF-8
    + 'ж' - значение символа, сам символ
    + '\u0436' - шестнадцатеричная форма Unicode этого символа
#### Остальные переменные
Все переменные, которые не относятся к примитивным типам данных, являются объектами каких-либо классов и хранят в себе 
ссылку на этот объект. Примеры: массив, `String`.
#### Классы-обертки
У каждого **_примитива_** есть **_класс-обертка_**. То есть, 
есть возможность создать переменную, которая также будет хранить ссылку на объект, но сам объект по сути будет примитивом. 
Полезно тогда, когда надо передать в другую область видимости именно ссылку на объект, а не значение примитива. То есть, 
когда надо изменять конкретный объект, а не создавать новый с тем же значением.  
Такие классы содержат полезные методы и константы.  
`Integer`:
+ Константы
  1. `Integer.MAX_VALUE` - Максимальное значение типа `int`
  2. `Integer.MIN_VALUE` - Минимальное значение типа `int`
+ Методы
  1. `String Integer.toHexString(int)` - Возвращает строковое шестнадцатеричное представление числа
  2. `String Integer.toBinaryString(int)` - Возвращает строковое двоичное представление числа
  3. `String Integer.toOctalString(int)` - Возвращает строковое восьмеричное представление числа
  4. `Integer Integer.parseInt(String)` - Возвращает число, полученное из строки

`Double`:
+ Константы
  1. `double Double.NEGATIVE_INFINITY` - Минус бесконечность
  2. `double Double.POSITIVE_INFINITY` - Плюс бесконечность
  3. `int Double.MIN_EXPONENT` - Минимальное значение экспоненты (2x)
  4. `int Double.MAX_EXPONENT` - Максимальное значение экспоненты (2x)
  5. `double Double.MIN_VALUE` - Минимальное значение типа double
  6. `double Double.MAX_VALUE` - Максимальное значение типа double
+ Методы
  1. `String Double.toHexString(double)` - Возвращает строковое шестнадцатеричное представление числа
  2. `boolean Double.isInfinite(double)` - Проверяет, является ли переданное число бесконечностью.
  3. `boolean Double.isNaN(double)` - Проверяет, является ли переданное число NaN
  4. `Double Double.parseDouble(String)` - Возвращает число, полученное из строки

`Character`
+ Методы
  1. `Character.isAlphabetic(int)` - Проверяет, является ли символ символом алфавита
  2. `Character.isLetter(char)` - Является ли символ буквой
  3. `Character.isDigit(char)` - Является ли символ цифрой
  4. `Character.isSpaceChar(char)` - Является ли символ пробелом, символом переноса строки или смены параграфа
  5. `Character.isWhitespace(char)` - Является ли символ разделителем: пробел, tab, и т.д.
  6. `Character.isLowerCase(char)` - Символ в нижнем регистре (строчные буквы)
  7. `Character.isUpperCase(char)` - Символ в верхнем регистре (заглавные буквы)
  8. `Character.toLowerCase(char)` - Преобразует символ в нижний регистр
  9. `Character.toUpperCase(char)` - Преобразует символ в верхний регистр
#### Константы
Для объявления константы используется ключевое слово `final`.  
Оно также используется для методов и классов. `final`-метод нельзя переопределить, а от `final`-класса нельзя наследоваться
#### Ключевое слово var
`var` позволяет не указывать явно тип данных создаваемой переменной, когда это **_очевидно_**. Уточним: очевидно это 
должно быть компилятору (только если переменной сразу же присваивается значение). Применимо в следующих случаях:
1. При создании нового экземпляра класса  
```java
var theLongestNameYouCanEverImagine = new TheLongestNameYouCanEverImagine();
```
2. В заголовке цикла
```java
for (var i = 1; i < 10; i++){
    //здесь что-то интересное происходит
}
var a = 2; // тип переменной a — int 
var b = 2L; // тип переменной b — long 
var c = 2F; // тип переменной c — float 
var d = 2D; // тип переменной d — double 
var e = (short) 2; //тип переменной e — short
```
Подробнее про `var` - [ссылка на статью](https://skillbox.ru/media/base/klyuchevoe-slovo-var-v-java/)
### Условные операторы
1. `if`
```java
if (statement) {
    do
}
```
2. `switch case..`
```java
int variable = 3;
switch (variable) {
    case 0:
        System.out.println("Zero");
        break;
    case 1:
        System.out.println("One");
        break;
    case 2:
        System.out.println("Two");
        break;
    case 3:
        System.out.println("Three");
        break;
    default:
        System.out.println("Other");
        break;
}
```
Улучшенная версия `switch case..`
```java
var snResult = user.setName(name);
if (snResult != 0) {
    switch (snResult) {
        case -1 -> {
            System.out.println("Имя не может быть null.");
            System.out.println("Еще одно действие.");
        }
        case -2 -> System.out.println("Имя не может быть пустым.");
        case -3 -> System.out.println("Имя не может содержать цифры.");
        default -> System.out.println("Неизвестная ошибка.");
    }
}
```
### Циклы
В Java есть несколько видов циклов:
#### `while`
```java
while (expression) {
     statement(s)
} 
```
#### `do..while`
```java
do {
     statement(s)
} while (expression);
```
#### `for`
```java
for (initialization; termination; increment) {
    statement(s)
}
```
Здесь:  
+ `initialization` — выражение, которое инициализирует выполнение цикла. Исполняется только раз в начале цикла.  
+ `termination` — `boolean` выражение, которое регулирует окончание выполнения цикла. Цикл прервется, когда оно станет `false`.  
+ `increment` — выражение, которое исполняется после каждой итерации цикла.
#### `for each..`
```java
for (Type var : vars) {
    statement(s)
}
```
Здесь:
+ `vars` - итерируемый объект
+ `Type var` - переменная, в которую будет записываться каждый объект, входящий в `vars`.  
При этом `Type` должен совпадать с типом данных объекта `vars`
### Пользовательский ввод
Ввод данных из консоли происходит через `System.in`, а вывод - через `System.out`
Работа с вводом данных в Java организована через класс `Scanner`, находящийся в `java.util.Scanner`
#### Создание сканнера
```java
import java.util.Scanner

Scanner scanner_name = new Scanner(data_source)

// Сканнер нужно обязательно закрывать после окончания работы с ним (аналогично файлу)
scan.close();
```
Источником данных (`data_source`) может быть не только консоль (`System.in`), но и, например, строка.
#### Задать разделитель для вводимых данных
```java
scanner.useDelimiter("string")
```
Метод принимает один аргумент типа `String` - по этой строке ввод будет разделяться на вводимые объекты  
Также есть возможность передавать не простую строку, а [паттерн](https://www.javatpoint.com/post/java-scanner-usedelimiter-method#:~:text=The%20useDelimiter()%20is%20a,Scanner%20useDelimiter(Pattern%20pattern)%20Method)
#### Использование сканнера
+ `scanner.nextLine()` - считывает строку целиком  
Аналогичные функции есть для следующих классов: `Int`, `Byte`, `Short`, `Long`, `Float`, `Double`
+ `scanner.hasNext()` - - проверяет, есть ли дальше на вводе хоть что-нибудь
+ `scanner.hasNextLine()` - проверяет, есть ли дальше на вводе строка данных  
Аналогичные функции есть для следующих классов: `Int`, `Byte`, `Short`, `Long`, `Float`, `Double`
### Массивы
#### Создание массива
`Type[] name = new Type[size];`, где `type` - тип данных или класс  
Пример:  
```java
int[] a = new int[10];
int n = 100;
int[] b = new int[n];
int[] c = { 0, 10, -2 };
```

При присвоении новому массиву значения старого - на самом деле будет скопирован указатель на место в памяти, а не сама память.  
Пример:
```java
int[] a = new int[10];
a[2] = 4;
a[7] = 9;
int[] b = a;
```
Что происходит? Выделяется память под `10` элементов типа `int` (`new int[10]`), указатель на выделенную память 
записывается в переменную `a`, а затем создается переменная `b`, в которую также записывается указатель (`int[] b = a;`)

#### Свойства массива
`array.length` - размер массива
#### "Неровные массивы"
При создании двумерного массива необязательно указывать вторую размерность. Тогда будет создан лишь массив массивов, 
без выделения памяти заранее. Пример:
```java
int[][] matrix = new int[2][];
matrix[0] = new int[10];
matrix[1] = new int[50];
```
Получился двумерный массив (список списков), у которого первая строка (первый элемент списка списков) имеет длину 10, 
а вторая - 50.
#### Вывод массива
Массивы можно выводить как в C++
```java
int[] array = {1, 2, 3};
for (int i = 0; i < n; i++) {
    System.out.print(array[i]);
    System.out.print(' ');
}
System.out.print('\n');

// 1 2 3 \n
```
Но также их можно выводить как списки в Python - с помощью `Arrays.toString()`
```java
int[] array = new int[n];
String array_out = Arrays.toString(array);  // "[1, 2, 3]"
System.out.println(array_out);

// [1, 2, 3]\n
```
Чтобы выводить в таком виде многомерные массивы - используйте `Arrays.deepToString()`
```java
Integer[] array = {1, 2, 3};
String str = Arrays.deepToString(array);  // "[1, 2, 3]"

int[][] array = { {1, 1}, {2, 2}, {3, 3} };
String str = Arrays.deepToString(array);  // "[[1, 1], [2, 2], [3, 3]]"

int[][][] array = { {{1, 2, 3}, {1}}, {{}} };
String str = Arrays.deepToString(array);  // "[[[1, 2, 3], [1]], [[]]]"
```
#### Сравнение массивов
Одномерных
```java
int[] x1 = {1, 2, 3};
int[] x2 = {1, 2, 3};
boolean a = (x1 == x2);             // false (ссылки не равны)
boolean b = (x1.equals(x2));        // false (ссылки не равны)
boolean c = Arrays.equals(x1, x2);  // true  (содержимое массивов равно)
```
Многомерных
```java
int[][] x1 = {{1, 2, 3}, {4, 5, 6}};
int[][] x2 = {{1, 2, 3}, {4, 5, 6}};
boolean a = x1.equals(x2);              // false (ссылки не равны)
boolean b = Arrays.equals(x1, x2);      // false (ссылки не равны)
boolean c = Arrays.deepEquals(x1, x2);  // true (содержимое массивов равно)
```
#### Заполнение массива
```java
int[] x = new int[100];
// Заполняет "x" целиком числом 999
Arrays.fill(x, 999);
// x = [999, 999, 999, ... , 999]

// indexes: 0  1  2  3  4  5  6  7  8  9
int[] y = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
// Заполняет "y" в диапазоне [3, 7) числом 999
Arrays.fill(y, 3, 7, 999);
// indexes: 0  1  2  3    4    5    6    7  8  9
//     y = [1, 2, 3, 999, 999, 999, 999, 8, 9, 10]
```
#### Копирование массива
Например, нам нужен массив побольше (или поменьше), но с теми же значениями
```java
int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // x.length = 10

int[] x2 = Arrays.copyOf(x, 5);          // "[1, 2, 3, 4, 5]"
int[] x3 = Arrays.copyOf(x, 15);         // "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0]"
int[] x4 = Arrays.copyOfRange(x, 5, 10); // "[6, 7, 8, 9, 10]"
int[] x5 = Arrays.copyOfRange(x, 5, 15); // "[6, 7, 8, 9, 10, 0, 0, 0, 0, 0]"
```
#### Сортировка массива
```java
int[] x = {11, -2, 3, 0, 999, -20, 8, -20, 99, -20};

Arrays.sort(x);       // "[-20, -20, -20, -2, 0, 3, 8, 11, 99, 999]"
Arrays.sort(x, 4, 8); // "[11, -2, 3, 0, -20, -20, 8, 999, 99, -20]"
```
### Строки
За строки в Java отвечает класс String. В переменной этого класса хранится адрес на выделенную память под строку 
(аналогично массиву). Объект String является неизменяемым (_immutable_). То есть при любых операциях над строкой, 
которые изменяют эту строку, фактически будет создаваться **новая строка**.
#### Создание новой строки
```java
String str1 = "";
String str2 = "aghjfoljsu";
String str3 = new String(char[]{'a', 'g', 'h', 'j', 'f', 'o', 'l, 'j', 's', 'u'});
```
#### Полезные методы строк
1. `int length()` - Возвращает количество символов в строке.
2. `boolean isEmpty()` - Проверяет, что строка == пустая строка.
3. `boolean isBlank()` - Проверяет, что в строке — только whitespace-символы: пробел, tab, enter и т.п.
4. `char charAt(int index)` - Возвращает символ, который стоит на index-позиции в строке.
5. `int indexOf(char ch)` - Возвращает индекс символа `ch` в строке (необязательно его первое вхождение), если его  
вообще нет в строке - возвращает `-1`.
6. `char[] toCharArray()` - Возвращает массив символов (копию), из которых состоит строка.
7. `String[] split(String regex)` - разделяет строку по разделителю `regex` на массив подстрок.
8. `String join(CharSequence delimiter, elements)` - собирает строку из массива подстрок `elements`, добавляя между ними 
строки-разделители `CharSequence`.
9. `String intern()` - Помещает строку в пул `StringPool`.
10. `replace(char oldChar, char newChar)` - заменяет все `oldChar` в строке на `newChar`
#### Сравнение строк
1. `boolean equals(String str)` - Строки считаются равными, если все их символы совпадают.
2. `boolean equalsIgnoreCase(String str)` - Сравнивает строки, игнорируя регистр (размер) букв
3. `int compareTo(String str)` - Сравнивает строки лексикографически. Возвращает 0, если строки равны. Число меньше нуля, 
если текущая строка меньше строки-параметра. Число больше нуля, если текущая строка больше строки-параметра. Аналогичен 
`strcmp` из С
4. `int compareToIgnoreCase(String str)` - то же, что и предыдущий, но без учета регистра
5. `boolean regionMatches(int toffset, String str, int offset, int len)` - Сравнивает части строк
#### Поиск префикса и суффикса
1. `boolean startsWith(String prefix)` - Проверяет, что текущая строка начинается со строки `prefix`
2. `boolean endsWith(String suffix)` - Проверяет, что текущая строка заканчивается на строку `suffix`
#### Поиск подстрок
1. `int indexOf(String str)` - Ищет строку str в текущей строке. Возвращает индекс первого символа встретившийся строки
2. `int indexOf(String str, int index)` - Ищет строку str в текущей строке, пропустив index первых символов. Возвращает 
индекс найденного вхождения
3. `int lastIndexOf(String str)` - Ищет строку str в текущей строке с конца. Возвращает индекс первого вхождения
4. `int lastIndexOf(String str, int index)` - Ищет строку str в текущей строке с конца, пропустив index первых символов
#### Регулярные выражения
`boolean matches(String regex)` - Проверяет, что текущая строка совпадает с шаблоном, заданным регулярным выражением
#### Получение новых строк
Все эти методы не перезаписывают строку, а возвращают новую
1. `String substring(int beginIndex, int endIndex)` - Возвращает подстроку, заданную интервалом символов `[beginIndex; endIndex - 1]`
2. `String repeat(int count)` - Повторяет текущую строку n раз
3. `String replace(char oldChar, char newChar)` - Заменяет в строке все символы `oldChar` на символы `newChar`
4. `String replaceFirst(String regex, String replacement)` - Заменяет в текущей строке подстроку, заданную регулярным выражением
5. `String replaceAll(String regex, String replacement)` - Заменяет в текущей строке все подстроки, совпадающие с регулярным выражением.
6. `String toLowerCase()` - Преобразует строку к нижнему регистру
7. `String toUpperCase()` - Преобразует строку к верхнему регистру
8. `String trim()` - Удаляет все пробелы в начале и конце строки
#### Разделение строк
Для простого разделения строки по конкретной строке (или символу) подойдет `.split(String s)`, но если разделителей 
несколько (пробел, enter, точка, tab, и т.д.) - удобнее пользоваться классом `StringTokenizer`. В конструктор нужно 
передать разделяемую строку (`String string`) и строку из символов-разделителей (`String delimiters`).
```java
StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
// Токенами считаются подстроки - части строки между разделителями
while (tokenizer.hasMoreTokens()) {  // пока еще есть подстроки
   String token = tokenizer.nextToken();  // получить следующую подстроку
   System.out.println(token);
}
```
Либо более реальный вариант
```java
StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
int count = tokenizer.countTokens();  // получаем количество подстрок
String[] tokens = new String[count];  // выделяем под все память
for (int i = 0; i < count; i++) {
    tokens[i] = tokenizer.nextToken();  // собираем их все в массив
}
```
#### "Форматирование" строк
Чтобы не писать
```java
String output = "User = {name: " + name + ", age:" + age + " years, friend: " + friend+", weight: " + weight + " kg.}"
```
В Java есть метод `String.format(шаблон, параметры)`. Пример использования:  
```java
String output = String.format("User = {name: %s, age: %d years, friend: %s, weight: %d kg.}, name, age, friend, weight);
```  
Оба варианта сгенерируют одну и ту же строку, только второй вариант намного более читабелен, чем первый.  
Список спец. символов и их обозначений для `String.format()`:
1. `%s` - `String`-переменная
2. `%d` - целое число: `byte`, `short`, `int`, `long`
3. `%f` - вещественное число: `float`, `double`
4. `%b` - `boolean`-переменная
5. `%c` - `char`-переменная
6. `%%` - Символ `%`

В случае необходимости использовать один и тот же параметр несколько раз, либо использовать параметры в другом порядке - 
вместо обычного `%d` нужно написать `%3$d`, где `3$` будет означать 3-й параметр (счет идет с 1, а не с 0).
#### Изменяемые строки (StringBuilder)
Сам тип `String` - неизменяемый, но если постоянно создавать новые строки неудобно или неэффективно - стоит использовать 
изменяемые строки (класс `StringBuilder`).
```java
StringBuilder имя = new StringBuilder(строка);  // создать изменяемую строку на основе существующей String
StringBuilder имя = new StringBuilder();  // пустая изменяемая строка
```
Полезные методы:
1. `StringBuilder append(obj)`  
Преобразовывает переданный объект в строку и добавляет к текущей строке
2. `StringBuilder insert(int index, obj)`  
Преобразовывает переданный объект в строку и вставляет в текущую строку по индексу
3. `StringBuilder replace(int start, int end, String str)`  
Заменяет часть строки, заданную интервалом `start..end` на переданную строку
4. `StringBuilder deleteCharAt(int index)`  
Удаляет из строки символ под номером `index`
5. `StringBuilder delete(int start, int end)`  
Удаляет из строки символы, заданные интервалом
6. `int indexOf(String str, int index)`  
Ищет подстроку в текущей строке
7. `int lastIndexOf(String str, int index)`  
Ищет подстроку в текущей строке с конца
8. `char charAt(int index)`  
Возвращает символ строки по его индексу
9. `String substring(int start, int end)`  
Возвращает подстроку, заданную интервалом
10. `StringBuilder reverse()`  
Разворачивает строку задом наперед
11. `void setCharAt(int index, char)`  
Изменяет символ строки, заданный индексом на переданный
12. `int length()`  
Возвращает длину строки в символах
### Функции
В Java "функции" не могут существовать отдельно от классов - только внутри них. То есть функций в Java нет - есть только
методы. По большей части не отличаются от методов класса в C++
#### Модификаторы прав доступа
------------------------------ Доступ из...  
Модификаторы -------- Любого класса --- Класса-наследника --- Своего пакета --- Своего класса  
`public` ------------------ Есть ----------------- Есть ------------------------ Есть ---------------- Есть  
`protected` -------------- Нет ------------------ Есть ------------------------ Есть ---------------- Есть  
без модификатора ---- Нет ------------------ Нет -------------------------- Есть ---------------- Есть  
`private` ----------------- Нет ------------------ Нет -------------------------- Нет ----------------- Есть  

В отличие от С++, в Java существует еще один модификатор доступа "без модификатора" или "модификатор по умолчанию":  
1. Модификатор `private` - доступ к методу есть только внутри класса этого метода.  
2. Модификатор по умолчанию - доступ к методу есть у всего пакета (но не за его пределами).  
3. Модификатор `protected` - доступ к методу есть у классов-наследников и у всего пакета (но не за его пределами).
4. Модификатор `public` - доступ к методу есть везде и у всех
#### Static или не static
`static` - модификатор, означающий привязку метода (или переменной) к классу.  
В случае с переменной - статическая переменная будет общей для всего класса, а нестатическая - будет принадлежать 
конкретному объекту. Например, у каждого яблока переменная `weight` отличается по значению (не `static`), а переменная 
`shape` - для всех одинаковая (`static`).  
В случае с методом - статический метод принадлежит классу (то есть, может обращаться только к статическим переменным - 
переменным класса), а нестатический - к любым. Таким образом, статический метод можно вызвать не создавая объект класса.
#### Исключения
### Классы
#### Теория классов в Java
1. Все классы в Java наследуются от класса `Object`. Подробнее в разделе [базового наследования](https://github.com/SmartOven/Java-projects/tree/main/Java-guides#базовое-наследование)  
2. Для каждого класса автоматически создается "статический объект" - объект, который хранит в себе все статические переменные. 
Даже если у класса не было создано ни одного объекта или нет ни одной статической переменной - он все равно создается.
#### Создание класса
Базовый синтаксис объявления класса также обязан содержать информацию о пакете, в котором создан класс
```java
package имя-пакета;

public class Имя-класса {
}
```
#### Конструкторы
Объект класса всегда создается при помощи конструктора. Если у класса нет конструкторов, то к нему автоматически добавляется 
конструктор "по умолчанию". При этом во время инициализации объекта сначала создаются все переменные класса, а потом уже 
вызывается конструктор. И еще одно замечание: если класс наследован от другого класса, то сначала инициализируются 
переменные родителя и вызывается конструктор родителя, а потом уже инициализируются переменные наследника и вызывается 
конструктор наследника.  
Для передачи в конструктор родителя параметров используется метод `super`:
```java
public class Car {
    public Car(String type) {
        System.out.println("Привет. Я " + type);
    }
}

public class ElectricCar extends Car {
    String type = "ElectricCar";
    public ElectricCar() {
        super(this.type);
    }
}
```
#### Наследование
Наследование осуществляется через ключевое слово `extends`
```java
public class Human extends Terran {
}
```
#### Базовое наследование
Любой класс в Java на самом деле наследуется от класса `Object`, хоть это нигде и не указано. Это дает им, например, такие 
методы как:
1. `boolean equals(Object obj)` - Сравнивает текущий объект и переданный объект
2. `int hashCode()` - Возвращает hash-code текущего объекта
3. `Class<?> getClass()` - Возвращает название класса объекта
4. `String toString()` - Возвращает `НазваниеКласса.НазваниеОбъекта@ХэшКодОбъекта`
#### Переопределение методов
Чтобы переопределить существующий метод (то есть метод, который класс унаследовал от родителя), нужно написать декоратор `@Override`.  
Для примера разберем одно из самых полезных переопределений - переопределение метода `Object.equals(obj)`.
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Iphone iphone = (Iphone) o;
    return price == iphone.price && Objects.equals(model, iphone.model) && Objects.equals(color, iphone.color);
}
```
#### Получение информации о классе объекта
Если у нас есть какой-то объект и мы хотим узнать его класс - можно вызвать метод `obj.getClass()`. Также информацию о 
классе можно получить и у самого класса - `Class.class`. Например, нам необходимо проверить является ли объект машиной:
```java
public boolean isCar(Object obj) {
    if (obj.getClass() == Car.class) {
        return true;
    }
    return false;
}
```
#### Вложенные и внутренние классы
Вложенные классы могут быть статическими (вложенные классы), а могут быть обычными (внутренние).
1. Внутренние классы помогают упростить работу основного класса - класса, в который они "вложены".
2. Вложенные классы могут быть использованы вне основного класса, если имеют модификатор `public`
Вложенные (`static`) классы на самом деле совсем не статические, а самые обычные. А нужны они для группировки классов в 
"модули" и для получения возможности обращаться из них к `private static`-переменным основного класса.

### Обработка исключений (try-catch-finally + throw)
Исключения в Java - это объекты класса исключений (какого-то из, но все они наследованы от класса `Throwable`)
Схема работы исключения: когда оно "выбрасывается"/срабатывает - текущий метод, в котором оно было поймано, сразу же 
завершается, также завершается метод, вызвавший данный и так далее по цепочке пока не будет завершен метод `main` и 
программа окончательно не остановится. 
#### try-catch
`try-catch` - это блок перехвата исключений. Позволяет прекратить аварийное завершение методов. То есть, если мы хотим 
"попробовать" что-то выполнить и в случае ошибки хотим самостоятельно ее обработать (и не завершать выполнение программы 
при этом) - используем блок `try-catch`. Блоков `catch` может быть несколько. Синтаксис использования:
```java
try {
   код, где может возникнуть ошибка
}
catch(ТипИсключения1 имя) {
   код обработки исключения
}
catch(ТипИсключения2 имя) {
   код обработки исключения
}
...
```
Иерархия классов-исключений, наследующихся от `Throwable`:
+ Error
  + OutOfMemoryError
  + StackOverFlowError
  + LinkageError
+ Exception
  + IOException
    + FileNotFoundException
    + SocketException
  + RuntimeException
    + ArithmeticException
    + IllegalArgumentException
      + NumberFormatException
    + IndexOutOfBoundsException
      + ArrayIndexOutOfBoundsException

Порядок обработки исключений в `catch` важен в случае, когда мы хотим по-разному обработать два класса исключений, один 
из которых является родителем другого. Пример: хотим по-разному обработать `NumberFormatException` и `IllegalArgumentException`,
где второй класс - родитель первого => сначала нужно проверить первое исключение, а потом уже второе.

#### throw
Часто имеет смысл отдавать ("выбрасывать") исключение обратно после его перехвата. Например, перехватить `NumberFormatException`, 
чтобы сообщить возможную причину ошибки пользователю (например, `System.out.printf("возможно, вы имели в виду %d?%n", (int)floatNumber)`), 
а потом вернуть исключение обратно Java-машине, чтобы она вывела свою информацию и завершила работу программы.  
Делается это через оператор `throw ошибка`:
```java
try {
   int d = 2/0;
} catch (Exception except) {
   System.out.println("Перехватили исключение");
   throw except;
}
```
Можно "выбрасывать" свои исключения - для этого надо просто создать объект исключения и использовать `throw`, например так:
```java
try {
   throw new RuntimeException();  // Создали свое исключение и выбросили его
} catch (Exception except) {
   System.out.println("Перехватили исключение");
   throw except;
}
```
#### finally
Блок `finally` выполняется независимо от наличия пойманного исключения - все равно будет выполнен. Даже если исключение 
возникло и не было обработано. Выглядит этот блок так:
```java
finally {
   код, который нужно выполнить в любом случае
}
```
#### Checked-исключения и Unchecked-исключения
Все классы исключений в Java делятся на `checked` и `unchecked`. Различаются они тем, что для `checked`-исключений есть
особые правила, которым лучше не следовать - поэтому `checked`-исключения нужно оборачивать в `unchecked`, а уже потом 
доставать из "обертки" и обрабатывать как `checked`.  

Запаковка в `RuntimeException`:
```java
// Методы, выбрасывающие checked-исключения
public static void readFile(String filePath) throws FileNotFoundException {
    // код метода
}
public static void writeFile(String filePath) throws FileSystemException {
    // код метода
}

// Запаковка выбрасываемых checked-исключений этими методами
public void copyFile(String sourceFile, String destinationFile) {
    try {
        readFile(sourceFile);
        writeFile(destinationFile);
    } catch (FileNotFoundException | FileSystemException e) {
        throw new RuntimeException(e);
    }
}
```
Обработка исключения, запакованного в `RuntimeException` (распаковка)
```java
try {
   // код где мы запаковали checked исключение в RuntimeException
} catch (RuntimeException e) {
   Throwable cause = e.getCause();
   if (cause instanceof FileNotFoundException) {
      FileNotFoundException exp = (FileNotFoundException) cause;
      // код по обработке FileNotFoundException
   } else if (cause instanceof FileSystemException) {
      FileSystemException exp = (FileSystemException) cause;
      // код по обработке FileSystemException
   } else {
      // код по обработке всех остальных видов исключений, если такие есть
   }
}
```
#### Создание собственных классов исключений
```java
class ИмяКласса extends RuntimeException {
    // код
}
```
### Псевдослучайные числа в Java
Случайные числа можно получать из метода `Math.random()` - он возвращает случайное `double` в диапазоне `[0; 1)`.  
Получение случайных целых чисел в диапазоне `[x; y]` и `[x; y)`:
```java
public static int generateNumber1(int x, int y) {
    return (int) (Math.random() * (y - x + 1) + x);
}  // [x; y]

public static int generateNumber2(int x, int y) {
    return (int) (Math.random() * (y - x) + x);
}  // [x; y)
```
Также в Java есть специальный класс `Random`, объекты которого хранят в себе последовательности псевдослучайных чисел.  
Примеры:
```java
Random r = new Random();      // создаем объект класса Random
float f = r.nextFloat();      // получаем случайный float в диапазоне [0; 1)
double d = r.nextDouble();    // получаем случайный double в диапазоне [0; 1)
int i = r.nextInt(6) + 1;     // получаем случайный int в диапазоне [0; 6) (=> [0; 5]), прибавляем 1 (=> [1; 6])
int i = r.nextInt();          // int в диапазоне всех возможных значений int
long l = r.nextLong();        // аналогично предыдущему, только с long
boolean b = r.nextBoolean();  // аналогично предыдущему, только с boolean (собственно, либо true, либо false)

byte[] buffer = new byte[1000];
nextBytes(buffer);            // заполняет переданный массив байтов случайными данными


double g = r.nextGaussian();  // аналогично r.nextDouble(), только случайность неравномерна - она распределяется
                              // по графику нормального распределения. То есть чаще будут выпадать числа
                              // близкие к 0.50, а числа, близкие к 0.00 и 0.99 почти не будут встречаться
```
### Коллекции
В Java коллекции бывают в широком и в узком смысле. В широком - все классы, отображающие наборы переменных, а в узком - 
классы, реализующие интерфейс `Collection`. Те же классы, которые в широком смысле являются коллекциями, а в узком - нет, 
называются контейнерами. Для простоты будем называть и коллекции, и контейнеры - коллекциями, имея ввиду широкий смысл определения.  
Существует множество коллекций, но все их можно разделить на типы:
1. `List`
   1. `ArrayList` - Список
   2. `LinkedList` - Связный список
   3. `Vector` - Вектор
   4. `Stack` - Стэк
2. `Set` - Множество
   1. `HashSet`
   2. `TreeSet`
   3. `LinkedHashSet`
3. `Queue` - Очередь
   1. `PriorityQueue`
   2. `ArrayDeque`
4. `Map` - Словарь (или карта)
   1. `HashMap`
   2. `TreeMap`
   3. `HashTable`

#### List
Вид коллекций `List` реализует список в каком-то из его вариантов. Например, список элементов, который всегда отсортирован, 
или список элементов, которые не имеют индексов, но имеют ссылки на предыдущего и следующего соседей (`.prev()` и `.next()`).
#### Set
Вид коллекций `Set` реализует множество - неупорядоченный набор из элементов, каждый из которых уникален. Основные методы: 
Добавить элемент - `add(element)`, Удалить элемент - `remove(element)` и Проверить наличие элемента - `contains(element)`.
#### Queue
Вид коллекций `Queue` реализует очередь. Работает как список, только с одним правилом: "первый вошел - первый вышел".
#### Map
Вид коллекций `Map` реализует структуру словаря, где каждому **_уникальному ключу_** соответствует **_одно единственное значение_**. 
При этом значение может быть и просто `int`, и массив `int[]`, и даже вложенный словарь - ограничений нет. В данной коллекции
уникальный ключ - это аналог индекса элемента в обычном массиве.
#### Класс ArrayList
Создание объекта - `ArrayList<Тип> имя = new ArrayList<Тип>();`  
Полезные методы:
1. `void add(тип value)` - Добавляет в список переданный элемент
2. `void add(int index, тип value)` - Добавляет элемент в определенное место списка.
3. `тип get(int index)` - Возвращает элемент, который находится под номером index
4. `void set(int index, тип value)` - Меняет значение элемента с номером index на value
5. `тип remove(int index)` - Удаляет элемент под номером index. Возвращает удаленный элемент.
6. `тип remove(тип value)` - Удаляет элемент: нужно передать сам элемент в список. Если таких элементов несколько, будет удален первый из них.
7. `void clear()` - Очищает список — удаляет все элементы из списка.
8. `boolean contains(тип value)` - Проверяет, содержится ли в списке элемент value.
9. `boolean isEmpty()` - Проверяет, пустой список или нет. Равна ли длина списка нулю.
10. `int size()` - Возвращает размер списка — количество элементов списка.
11. `тип[] toArray(тип[] array)` - Возвращает массив, содержащий те же элементы, что и список. Массив нужно передать в метод.
#### Класс HashMap
Методы:
1. `void put(ТКлюч key, ТЗначение value)` - Добавляет в коллекцию пару (key, value)
2. `ТЗначение get(ТКлюч key)` - Возвращает значение по ключу.
3. `boolean containsKey(ТКлюч key)` - Проверяет наличие ключа в коллекции
4. `boolean containsValue(ТЗначение value)` - Проверяет наличие значения в коллекции
5. `ТЗначение remove(ТКлюч key)` - Удаляет элемент из коллекции
6. `void clear()` - Очищает коллекцию: удаляет все элементы
7. `int size()` - Возвращает количество пар элементов в коллекции
8. `Set<ТКлюч> keySet()` - Возвращает множество ключей коллекции
9. `Collection<ТЗначение> values()` - Возвращает множество элементов коллекции
10. `Set<Map.Entry<TКлюч, TЗначение>> entrySet()` - Возвращает все значения коллекции в виде множества (Set) пар (Map.Entry).
#### Итератор
Итератор - класс, созданный для "перебора" всех элементов коллекции без повторения. Создание итератора: `Iterator<Тип> it = имя.iterator();`
```java
// Создаем ArrayList
ArrayList<Integer> arrayListInteger = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Создаем итератор для ArrayList
Iterator<Integer> integerIterator = arrayListInteger.iterator();

// Выводим все элементы ArrayList используя итератор
while (integerIterator.hasNext()) {
    System.out.println(integerIterator.next());
}
```
Методы итератора:
1. `Тип next()` - Возвращает очередной элемент коллекции
2. `boolean hasNext()` - Проверяет, есть ли еще не пройденные элементы
3. `void remove()` - Удаляет текущий элемент коллекции

Более простой (и одновременно - неявный) способ использования итератора - цикл `for each..`
```java
// Создаем ArrayList
ArrayList<Integer> arrayListInteger = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Выводим все элементы ArrayList НЕЯВНО используя итератор
for (var i: arrayListInteger) {
    System.out.println(i);
}
```
Минусом цикла `for each..` является невозможность удалять элементы коллекции внутри него. Для удаления элементов коллекции
по итератору придется использовать его явным образом. Пример:
```java
Iterator<String> it = set.iterator();
while (it.hasNext()) {
   String str = it.next();
   if (str.equals("Hello"))
       it.remove();
}
```
Но и это не обязательно, можно скопировать коллекцию в другой объект и, проходясь по нему и находя необходимые значения в 
копии - удалять их из оригинала
```java
// Создаем ArrayList
ArrayList<String> list = new ArrayList<>(Arrays.asList("Hello", "world!"));

// Копируем ArrayList
ArrayList<String> listCopy = new ArrayList(list);

for (String str: listCopy) {
   if (str.equals("Hello"))
      list.remove(str);
}
```
#### Класс Collections
Методы:
1. `addAll(colls, e1, e2, e3, ..)` - Добавляет в коллекцию colls элементы e1, e2, e3,...
2. `fill(list, obj)` - Заменяет в переданном списке все элементы на obj
3. `nCopies(n, obj)` - Возвращает список, состоящий из n копий объекта obj 
4. `replaceAll(list, oldVal, newVal)` - Заменяет в списке list все значения oldVal на newVal
5. `copy(dest, src)` - Копирует все элементы из списка src в список dest
6. `reverse(list)` - Разворачивает список задом наперед
7. `sort(list)` - Сортирует список в порядке возрастания
8. `rotate(list, n)` - Циклично сдвигает элементы списка list на n элементов
9. `shuffle(list)` - Случайно перемешивает элементы списка
10. `min(colls)` - Находит минимальный элемент коллекции colls
11. `max(colls)` - Находит максимальный элемент коллекции colls
12. `frequency(colls, obj)` - Определяет, сколько раз элемент obj встречается в коллекции colls
13. `binarySearch(list, key)` - Ищет элемент key в отсортированном списке, возвращает индекс. 
14. `disjoint(colls1, colls2)` - Возвращает true, если у коллекций нет общих элементов
### Работа с файлами
Работа с файлами в Java происходит с помощью нескольких классов, один из которых - `Path`. Объекты этого класса хранят 
лишь путь к файлу/директории, поэтому для создания объекта необязательно передавать путь к существующему файлу/директории - 
достаточно лишь указать валидный путь.
#### Класс Path
Создание объекта класса `Path`:
```java
// Путь к файлу
Path file = Path.of("c:\\projects\\note.txt");

// Путь к директории
Path directory = Path.of("c:\\projects\\");
```
Методы класса `Path`:
1. `Path getParent()` - Возвращает родительскую директорию
2. `Path getFileName()` - Возвращает имя файла (или директории) без пути к нему
3. `Path getRoot()` - Возвращает корневую директорию из пути
4. `boolean isAbsolute()` - Проверяет, что текущий путь — абсолютный
5. `Path toAbsolutePath()` - Преобразует путь в абсолютный
6. `Path normalize()` - Убирает шаблоны в имени директории.
7. `Path resolve(Path other)` - Строит новый абсолютный путь из абсолютного и относительного.
8. `Path relativize(Path other)` - Получает относительный путь из двух абсолютных путей.
9. `boolean startsWith(Path other)` - Проверяет, что текущий путь начинается с пути
10. `boolean endsWith(Path other)` - Проверяет, что текущий путь заканчивается на путь
11. `int getNameCount()` - Дробит путь на части с помощью разделителя `/`. Возвращает количество частей.
12. `Path getName(int index)` - Дробит путь на части с помощью разделителя `/`. Возвращает часть по ее номеру.
13. `Path subpath(int beginIndex, int endIndex)` - Дробит путь на части с помощью разделителя `/`. Возвращает часть пути,
заданную интервалом.
14. `File toFile()` - Преобразует объект `Path` в устаревший объект `File`
15. `URI toUri()` - Преобразует объект `Path` в объект типа `URI`

#### Класс Files
`Files` - утилитарный класс для работы с файлами (через класс `Path`) в Java. Вот список его методов:
1. `Path createFile(Path path)` - Создает новый файл с путем path
2. `Path createDirectory(Path path)` - Создает новую директорию
3. `Path createDirectories(Path path)` - Создает несколько директорий
4. `Path createTempFile(prefix, suffix)` - Создает временный файл
5. `Path createTempDirectory(prefix)` - Создает временную директорию
6. `void delete(Path path)` - Удаляет файл или директорию, если она пуста
7. `Path copy(Path src, Path dest)` - Копирует файл
8. `Path move(Path src, Path dest)` - Перемещает файл
9. `boolean isDirectory(Path path)` - Проверяет, что путь — это директория, а не файл
10. `boolean isRegularFile(Path path)` - Проверяет, что путь — это файл, а не директория
11. `boolean exists(Path path)` - Проверяет, что объект по заданному пути существует
12. `long size(Path path)` - Возвращает размер файла
13. `byte[] readAllBytes(Path path)` - Возвращает все содержимое файла в виде массива байт
14. `String readString(Path path)` - Возвращает все содержимое файла в виде строки
15. `List<String> readAllLines(Path path)` - Возвращает все содержимое файла в виде списка строк
16. `Path write(Path path, byte[])` - Записывает в файл массив байт
17. `Path writeString(Path path, String str)` - Записывает в файл строку
18. `DirectoryStream<Path> newDirectoryStream(Path dir)` - Возвращает коллекцию файлов (и поддиректорий) из заданной 
директории

#### Получение директорий и файлов, находящихся в данной директории
Для этого в Java используется поток `DirectoryStream`, у которого есть итератор - а, следовательно, можно перебрать все 
полученные пути внутри `for each..`. Также не стоит забывать, что это **поток** - его надо закрывать при помощи `close()`, 
либо использовать внутри `try`-with-resources.
```java
// Создаем путь к директории (current)
Path path = Path.of("c:\\windows");

// Получаем (и выводим на экран по одному) все пути до вложенных директорий и файлов (в директории current)
try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
   for (Path path : files)
      System.out.println(path);
}
```
### Работа с сетью
Работа с сетью в Java происходит при помощи класса `URL`. Этот класс - аналог класса `Path`, только вместо путей к 
ресурсам в файловой системе он хранит пути к ресурсам в интернете. Скачивание файла из интернета по ссылке:
```java
URL url = new URL("https://javarush.ru");
InputStream input = url.openStream();

byte[] buffer = input.readAllBytes();
String str = new String(buffer);
System.out.println(str);
```
Класс `URLConnection` позволяет как-то еще работать с сетью, но на JavaRush про сети написано паршиво, так что тут 
не будет написано вообще ничего =)
### Работа с датами
Можно просто через устаревший класс `Date`, но лучше через `Calendar`.
```java
// Создать календарь (дата, дата + время, дата + время + миллисекунды)
Calendar calendar1 = new GregorianCalendar(год, месяц, день);
Calendar calendar2 = new GregorianCalendar(год, месяц, день, часы, минуты, секунды);
Calendar calendar3 = new GregorianCalendar(год, месяц, день, часы, минуты, секунды, миллисекунды);

// Текущая дата
Calendar calendar4 = Calendar.getInstance();

// Фрагменты даты: ERA, YEAR, MONTH, DAY_OF_MONTH, DAY_OF_WEEK, HOUR, MINUTE, SECOND

// Получение отдельных фрагментов даты
int название = calendar.get(Calendar.фрагмент);


// Задать отдельные фрагменты даты
calendar.set(Calendar.фрагмент, значение);

// Константы календаря: дни недели (Calendar.FRIDAY), месяца (Calendar.JANUARY)

// "Увеличение" или "уменьшение" даты
calendar.add(Calendar.фрагмент, значение); // фрагменты: YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, SECOND
```
### Другое
#### Паузы в программе
1. Либо `Thread.sleep(миллисекунды, наносекунды);`  
2. Либо `TimeUnit.DAYS.sleep(число);`.  
Варианты функции: `NANOSECONDS`, `MICROSECONDS`, `MILLISECONDS`, `SECONDS`, `MINUTES`, `HOURS`, `DAYS`
#### Побитовые операции
1. `&` - AND
2. `|` - OR
3. `^` - XOR
4. `~` - NOT
5. `<<` - побитовый сдвиг влево (умножение на 2)
6. `>>` - побитовый сдвиг вправо (деление на 2, не меняет знак числа)
7. `>>>` - тоже побитовый сдвиг вправо, но число становится положительным, если оно было отрицательным
#### Перечисления (enum)
Перечисления в Java на этапе компиляции преобразуются в обычные классы, в которых есть:
1. Константы - все возможные значения перечисления
2. Статические методы - методы `values()`, `ordinal()`, `toString()`, `valueOf(string)` и другие

Поэтому в перечисление можно добавлять не только различные значения, но и свои методы.  
Создание перечисления:
```java
enum Day {
   MONDAY,
   TUESDAY,
   WEDNESDAY,
   THURSDAY,
   FRIDAY,
   SATURDAY,
   SUNDAY;
}
```
Базовые методы перечислений:
1. `Day[] days = Day.values()` - возвращает массив значений типа `Day` (название перечисления)
2. `Day.MONDAY.ordinal()` - возвращает порядковый номер значения в перечислении. В отличие от С++ в Java необходимо 
вызывать этот метод для работы со значениями enum как с `int`
3. `Day.MONDAY.toString()` - преобразует имя значения в строку и вернет ее
4. `Day.valueOf("MONDAY")` - преобразует строку в значение перечисления `Day` (если такое есть) и вернет его

Добавление своих методов в перечисления:
```java
enum Day {
   MONDAY,
   TUESDAY,
   WEDNESDAY,
   THURSDAY,
   FRIDAY,
   SATURDAY,
   SUNDAY;

   public static List<Day> asList() {
      ArrayList<Day> list = new ArrayList<Day>();
      Collections.addAll(list, values());
      return list;
   }
}
```
#### Лямбда-выражения
Лямбда-выражения нужны для реализации анонимной функции в классе, реализующем интерфейс компаратора. Без лямбда-функций 
пришлось бы создавать новый класс, имплементировать его от интерфейса `Comporator` и переопределять в нем метод `compare`.
Лямбда-выражения позволяют опустить почти весь код, кроме одной строчки, в которой будет список аргументов функции и 
одна единственная команда в этой функции. Выглядит это так:
```java
// Лямбда-функция сравнения длин строк
(String s1, String s2) -> s1.length() - s2.length;

// То же самое - типы данных можно опустить
(s1, s2) -> s1.length() - s2.length;
```
Это имеет смысл, когда компаратор используется лишь единожды. Когда он используется в нескольких местах - имеет смысл 
создать класс.
#### Работа с флагами
Это способ хранения большого количества `true`/`false` значений в одном целом числе. Способ основан на том, что эти
"переменные" - это биты числа по порядку. Например, `int` может хранить 32 таких "флага", а `long` - 64.  
Основные операции:
1. **Установка флага**  
Чтобы установить определенный (i-ый) бит в `1` - нужно выполнить **_побитовое ИЛИ_** между исходным числом и числом, 
состоящим только из одной 1 в i-ом разряде:  
`0b00001010 | 0b00000100 = 0b00001110` => `a | (1 << i)`
2. **Сброс флага**  
Чтобы сбросить определенный (i-ый) бит в `0` - нужно выполнить **_побитовое И_** между исходным числом и числом, 
состоящим только из одного 0 в i-ом разряде:  
`0b00001010 & 0b11111101 = 0b00001000` => `a & ~(1 << i)`
3. **Проверка флага**  
Чтобы проверить i-ый флаг - нужно сравнить исходное число с результатом установки данного флага: если они совпадают, то 
флаг уже был установлен, а если не совпадают - флаг не был установлен.  
`if ( (0b00001010 & 0b00001000) == 0b00001000 )` => `(a & (1 << i)) == (1 << i)`
#### Простое шифрование
Самый простой способ зашифровать числовые данные
1. Придумываем число (пароль)
2. Применяем XOR (исключающее ИЛИ) между числом и "паролем" => получаем "зашифрованное" число  
`результат = оригинальное число ^ пароль;`
3. Передаем получателю и "зашифрованное" число, и "пароль"
4. Получатель применяет XOR с "паролем" к "зашифрованному" числу => получает исходное число  
`оригинальное число = результат ^ пароль;`
#### Другие системы счисления
Для задания целого числа в восьмеричной системе счисления - нужно написать `0` перед числом
```java
int x = 015;   // = 13
int x = 025;   // = 21
int x = 0123;  // = 83
```
Для задания целого числа в двоичной системе счисления - нужно написать `0b` перед числом
```java
int x = 0b100;         // = 4
int x = 0b1111;        // = 15
int x = 0b1111000111;  // = 967
```
Для задания целого числа в шестнадцатеричной системе счисления - нужно написать `0x` перед числом
```java
int x = 0x1;    // = 1
int x = 0xF;    // = 15
int x = 0x1F;   // = 31
int x = 0xFFF;  // = 4095
```
#### Контракты
Java-программисты договорились о некоторых правилах: "что-то" обязательно должно быть "таким". Все такие правила называются 
**контрактами**. Вот некоторые контракты в Java:
1. Создаешь класс - переопределяешь `equals()` и `hashCode()`. Это нужно, например, для корректной работы коллекций с
пользовательскими классами

#### StackTrace
Стэк-трейс - цепочка вызванных методов в программе. Откуда мы его получим - ту цепочку методов он нам и выдаст. Полезно, 
например, в случае, когда тяжело понять, где именно было "выброшено" исключение. Получение стэк-трейса:
```java
// Получение текущего потока
Thread current = Thread.currentThread();

// Получение цепочки вызванных методов в виде массива из этих методов
StackTraceElement[] methods = current.getStackTrace();
```
Каждый элемент этой цепочки является объектом класса `StackTraceElement`. Его полезные методы:
1. `String getClassName()` - Возвращает имя класса
2. `String getMethodName()` - Возвращает имя метода
3. `String getFileName()` - Возвращает имя файла (в одном файле может быть много классов)
4. `int getLineNumber()` - Возвращает номер строки в файле, в которой был вызов метода
5. `String getModuleName()` - Возвращает имя модуля (может быть null)
6. `String getModuleVersion()` - Возвращает версию модуля (может быть null)

#### Работа с внешними ресурсами
Внешние ресурсы - все ресурсы, выходящие за пределы Java-машины (ресурсы ОС, в основном - файлы)
Правильная работа с файлами: открыть, поработать, проверить наличие ошибок (вызов исключений), закрыть (освободить ресурс)  
Все это делает блок `try`-with-resources:
```java
// Открыть файл, записать в него "Hi, there!", закрыть файл (даже если будет выброшено исключение)
try (FileOutputStream output = new FileOutputStream(path)) {
   output.write("Hi, there!");
}
```
Переменных в блоке инициализации `try` может быть несколько, их нужно указывать через `;`. Блоки `catch` тоже могут 
присутствовать.