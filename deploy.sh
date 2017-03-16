#!/bin/bash

./gradlew clean build buildDocker -x test

docker-compose up --build -d
