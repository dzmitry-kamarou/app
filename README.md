# diamond
diamond application
## Prerequisites
Requires **Java**, **Maven** or **Docker Compose** installed.
## Launch
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. `$ mvn clean install -DskipTests`
4. `$ docker build -t diamond-server .`
5. `$ sudo docker-compose up -d`
6. open [http://localhost:8086](http://localhost:8086)
## Install
1. `$ git clone git@github.com:dzmitry-kamarou/diamond.git`
2. `$ cd diamond`
3. `$ sudo mvn clean install`