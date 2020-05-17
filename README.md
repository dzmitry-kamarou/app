# diamond
diamond application
## Prerequisites
Requires **Java**, **Maven** or **Docker Compose** installed.
## Launch
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. `$ mvn clean install -DskipTests`
4. `$ sudo docker build -t diamond-server .`
5. `$ sudo docker-compose up -d`
6. open [http://localhost:8086](http://localhost:8086)
## Install
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. `$ sudo mvn clean install`
## Develop
1. Make code changes
2. `$ mvn clean install`
3. `$ sudo docker container rm -f diamond-server`
4. `$ sudo docker build -t diamond-server .`
5. `$ sudo docker-compose up -d`
6. (optional) run tests from diamond-taf-java: `$ mvn clean install -Denv=local -Dscope=smoke`
7. `$ sudo docker login`
8. `$ sudo docker tag diamond-server dzmitrykamarou/diamond-server:v1`
9. `$ sudo docker push dzmitrykamarou/diamond-server:v1`
## Deploy
1. `$ sudo heroku login`
2. `$ sudo heroku container:login`
3. `$ sudo heroku container:push web -a diamond-dev`
4. `$ sudo heroku container:release web -a diamond-dev`
