# Все о Maven
**Maven** – это специальный “фреймворк” для управления сборкой проектов. Он стандартизирует 3 вещи:
+ Описание проекта;
+ Сценарии сборки проектов;
+ Зависимости между библиотеками

**Maven** использует единый файл конфигурации - `pom.xml` ("помник")

## Структура Maven-проекта
Структура (архетип) Maven-проекта выбирается в зависимости от задач. Все доступные архетипы можно посмотреть
на [официальном сайте Maven](https://maven.apache.org/archetypes/index.html). Вот несколько популярных:
+ maven-archetype-quickstart - именно этот архетип используется IDEA при создании Maven-проекта (или SpringInitializr проекта)
+ maven-archetype-plugin
+ maven-archetype-site
+ maven-archetype-webapp

### Структура папок в архетипе "maven-archetype-quickstart":  
+ src
  + main
    + java
    + resources
  + test
    + java
    + resources
+ target
+ `pom.xml`


## Структура pom.xml
Пример структуры помника
```xml
<!-- Стандартные заголовки XML и информация о namespaces, имеет отношение только к XML, но не к Maven -->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
  
  <!-- Хэдер помника -->
  <modelVersion>4.0.0</modelVersion>
  <groupId>example.com</groupId>
  <artifactId>example</artifactId>
  <version>1.0-SNAPSHOT</version>

  <!-- Очень краткое описание, от какого проекта этот помник -->
  <description>Project description</description>

  <!-- Переменные помника. Используются для вынесения каких-то параметров, -->
  <!-- которые либо часто встречаются, либо должны находиться в одном месте -->
  <!-- для более простого контроля их изменений. Например, версии плагинов и зависимостей -->
  <properties>
    <java.version>11</java.version>
    <junit.version>5.2</junit.version>
    <project.artifactId>new-app</project.artifactId>
    <maven.compiler.source>1.13</maven.compiler.source>
    <maven.compiler.target>1.15</maven.compiler.target>
  </properties>
  
  <!-- Зависимости проекта - библиотеки, используемые исходным кодом -->
  <!-- Содержат groupId, artifactId и version -->
  <dependencies>
    
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.6</version>
    </dependency>
    
  </dependencies>
  
  
  <!-- Репозитории, хранящие зависимости -->
  <repositories>
    
    <repository>
      <id>public-javarush-repo</id>
      <name>Public JavaRush Repository</name>
      <url>http://maven.javarush.com</url>
    </repository>

    <repository>
      <id>private-javarush-repo</id>
      <name>Private JavaRush Repository</name>
      <url>http://maven2.javarush.com</url>
    </repository>
    
  </repositories>
  
  <!-- Секция билда -->
  <build>
    <!-- Плагины - расширения функционала сборки проекта Maven'ом, не относятся к исходному коду -->
    <!-- Так же как и dependencies содержат groupId, artifactId и version -->
    <!-- Репозитории для плагинов обозначаются pluginRepositories -->
    <plugins>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-checkstyle-plugin</artifactId>
        <version>2.6</version>
      </plugin>

    </plugins>
  </build>

</project>
```
