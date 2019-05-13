#!/usr/bin/env bash

docker load < service-client.tar
docker load < service-client-api.tar
docker load < service-user-account.tar
docker load < service-repo-retriever.tar
docker load < service-content-scorer.tar
docker load < service-eureka-zuul.tar
docker load < service-eureka-server.tar
