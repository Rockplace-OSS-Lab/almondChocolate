#!/bin/bash

APP_NAME=almondchocolate

COMMIT_HASH="$(git show-ref --head | grep -h HEAD | cut -d':' -f2 | head -n 1 | head -c 10)"

./gradlew clean build buildDocker -x test -DdockerImageTags=$APP_NAME_$COMMIT_HASH

docker-compose up --build -d
