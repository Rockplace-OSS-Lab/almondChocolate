#!/bin/bash

eval $(docker-machine env was)
env | grep DOCKER

./gradlew clean build buildDocker -x test

docker-compose -f docker-tomcat.yml up -d