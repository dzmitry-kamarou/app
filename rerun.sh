#!/bin/bash
# Uncomment next string first time:
# groupadd docker
URL=http://localhost:8086/api/v1/healthcheck
mvn clean install
docker container rm -f diamond-server
docker container rm -f diamond-postgres
docker build -t diamond-server .
docker-compose up -d
seconds=20
printf 'Waiting response'
until curl --output /dev/null --silent --head --fail $URL || ((seconds < 0)); do
  printf "."
  sleep 1
  ((seconds--))
done
printf 'done\n'
echo $URL
