#!/usr/bin/env bash

docker save --output service-client.tar zafer/service-client
docker save --output service-client-api.tar zafer/service-client-api
docker save --output service-user-account.tar zafer/service-user-account
docker save --output service-repo-retriever.tar zafer/service-repo-retriever
docker save --output service-content-scorer.tar zafer/service-content-scorer
docker save --output service-eureka-zuul.tar zafer/service-eureka-zuul
docker save --output service-eureka-server.tar zafer/service-eureka-server
