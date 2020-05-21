# diamond
diamond application
## Prerequisites
Requires **Java**, **Maven** or **Docker Compose** installed.
## Launch
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. Create `.env` file with env-depending values (e.g.):
```.env
POSTGRES_DB=diamond
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_URL=diamond-postgres
POSTGRES_PORT=5432
```
4. `$ mvn clean install -DskipTests`
5. `$ sudo docker build -t diamond-server .`
6. `$ sudo docker-compose up -d`
7. open [http://localhost:8086/api/v1](http://localhost:8086/api/v1)
## Install
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. `$ sudo mvn clean install`
## Develop
1. Make code changes
2. `$ mvn clean install`
3. `$ sudo docker container rm -f diamond-server`
4. `$ sudo docker container rm -f diamond-postgres`
5. `$ sudo docker build -t diamond-server .`
6. `$ sudo docker-compose up -d`
7. (optional) run tests from diamond-taf-java: `$ mvn clean install -Denv=local -Dscope=smoke`
8. `$ sudo docker login`
9. `$ sudo docker tag diamond-server dzmitrykamarou/diamond-server:v1`
10. `$ sudo docker push dzmitrykamarou/diamond-server:v1`
## Deploy
1. `$ sudo heroku login`
2. `$ sudo heroku container:login`
1. `$ mvn clean install`
4. `$ sudo docker-compose up -d` (optional)
3. `$ sudo heroku container:push web -a diamond-dev`
4. `$ sudo heroku container:release web -a diamond-dev`
