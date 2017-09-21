# hxqh-api

## Introduction

* An example project based on SpringBoot integrated with oauth2 ( token persisted on mysql ), swagger2, restful API, druid, mybatis ( generator and pagehelper included).

## Features

### druid

* see http://localhost:8080/druid/login.html
* username root and password root is same as mysql database

### mybatis generator

* run mvn mybatis-generator:generate

### swagger

* see http://localhost:8080/swagger-ui.html

### oauth2

* use curl http://localhost:8080/oauth/token -X POST -u client:security -d "grant_type=password&username=admin&password=admin" to get access token, for example : 69aaaeb8-49c2-410d-8253-ad6c003c6091
* then we can use curl -X PUT -H "Authorization: Bearer 69aaaeb8-49c2-410d-8253-ad6c003c6091" --header "Content-Type: application/json" -d "{ \"newPassword\": \"new\", \"oldPassword\": \"admin\"}" "http://localhost:8080/user/password" to modify password
* also curl http://localhost:8080/user/1 -X DELETE -H "Authorization: Bearer 69aaaeb8-49c2-410d-8253-ad6c003c6091" to access other authenticated url
