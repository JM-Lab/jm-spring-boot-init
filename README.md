jm-spring-boot-init
===================

Spring Boot Template

## version
1.4.3

## Prerequisites:
* Java 8 or later
* [install Project Lombok for IDE](https://projectlombok.org/download.html)

## Installation

    git clone https://github.com/JM-Lab/jm-spring-boot-init.git
    cd jm-spring-boot-init
    git checkout -b 1.4.3 origin/1.4.3
    gradle install
    
## Usage
Set up build.gradle :

    (...)
    compile 'com.github.jm-lab:jm-spring-boot-init:1.4.3'
    (...)

Set up pom.xml :

    (...)
    <dependency>
			<groupId>com.github.jm-lab</groupId>
			<artifactId>jm-spring-boot-init</artifactId>
			<version>1.4.3</version>
	</dependency>
    (...)