#!/usr/bin/env bash

cd service-repo-retriever
mvn clean install
docker build -t zafer/service-repo-retriever:latest .
cd ..

####
cd service-content-scorer
mvn clean install
docker build -t zafer/service-content-scorer:latest .
cd ..

cd service-user-account
mvn clean install
docker build -t zafer/service-user-account:latest .
cd ..

####
cd service-client-api
mvn clean install
docker build -t zafer/service-client-api:latest .
cd ..

####
cd client
docker build -t zafer/service-client:latest .
cd..

docker image prune

#docker-machine ip
#docker stop $(docker ps -a -q)
#docker rm $(docker ps -a -q)
