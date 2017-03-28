#!/bin/bash

eval $(docker-machine env db)
env | grep DOCKER

docker-compose -f docker-mysql.yml up -d