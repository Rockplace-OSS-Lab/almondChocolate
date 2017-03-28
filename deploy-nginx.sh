#!/bin/bash

eval $(docker-machine env web)
env | grep DOCKER

docker-compose -f docker-nginx.yml up --build -d