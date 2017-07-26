# Springboot API

REST API built with Java, SpringBoot, MongoDB, Maven, & SpringInitializr 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

#### Java JDK & JRE
[Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install Java JRE & JDK
* Add JAVA_HOME environment variable : C:\Program Files\Java\jdk{version}

#### Maven
[Download & Install](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) Maven
* Add C:\Program Files\MongoDB\Server\{version}\bin environment variable to path
* Create C:\data\db empty folder to house data

### Additional Dependencies
#### MongoDB Data (optional)
This library allows seamless integration with MongoDB
``` 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

#### MongoDB Data (optional)
This library allows generation of REST-ful API's given an interface object
``` 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```

#### Lombok (optional)
[Lombok](https://projectlombok.org/) is a tool that makes writing classes in Java much easier and less verbose. To import this library, include the following dependency in your pom.xml

``` 
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.18</version>
    <scope>provided</scope>
</dependency>
```

## Install & Run
To run from the terminal, make sure the following is in the properties tag :

```
<start-class>springbootapi.todo.SpringbootApiApplication</start-class>
```

Run the app

```
$ mvn spring-boot:run
```

## Todo List
The example on this repository provides GET/PUT/POST/DELETE functionality for a simple todoList.

[TodoList Docs](docs/todo.md)

## Authors
**Alex Batis**  | [GitHub](https://github.com/alexbatis) | [LinkedIn](https://www.linkedin.com/in/alexander-batis-3a202b101/)

## License

This project is licensed under the [MIT License](https://en.wikipedia.org/wiki/MIT_License).

