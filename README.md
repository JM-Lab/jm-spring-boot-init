jm-spring-boot-init
===================

Spring Boot Template

## version
1.3.4

## Prerequisites:
* Java 8 or later
* [install Project Lombok for IDE](https://projectlombok.org/download.html)

## Installation

    git clone https://github.com/JM-Lab/jm-spring-boot-init.git
    cd jm-spring-boot-init
    git checkout -b java8-1.3.4 origin/java8-1.3.4
    gradle install
    
## Usage
Set up build.gradle :

    (...)
    compile ('com.github.jm-lab:jm-spring-boot-init:1.3.4')
    (...)

Set up pom.xml :

    (...)
    <dependency>
			<groupId>com.github.jm-lab</groupId>
			<artifactId>jm-spring-boot-init</artifactId>
			<version>1.3.4</version>
	</dependency>
    (...)