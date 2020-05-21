#!/bin/bash
URL=http://localhost:8086/api/v1/healthcheck
mvn clean install
docker container rm -f diamond-server
docker container rm -f diamond-postgres
docker build -t diamond-server .
docker-compose up -d
printf 'Waiting response'
until curl --output /dev/null --silent --head --fail $URL; do
  printf '.'
  sleep 1
done
printf 'done\n'
echo $URL
