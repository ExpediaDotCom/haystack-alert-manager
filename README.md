[![Build Status](https://travis-ci.org/ExpediaDotCom/haystack-alerting.svg?branch=master)](https://travis-ci.org/ExpediaDotCom/haystack-alerting)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/ExpediaDotCom/haystack/blob/master/LICENSE)

# haystack-alerting
This repo contains the haystack integration with [adaptive-alerting](https://github.com/ExpediaDotCom/adaptive-alerting) and [alert-manager](https://github.com/ExpediaDotCom/alert-manager) to
store anomalies generated by adaptive-alerting and provide an interface for subscription management for alerting.   


## Building

####
Use the following to clone the repo
* git clone git@github.com:ExpediaDotCom/haystack-alerting.git .

####Prerequisite: 

* Make sure you have Java 1.8
* Make sure you have maven 3.3.9 or higher
* Make sure you have docker 1.13 or higher


Note : For mac users you can download docker for mac to set you up for the last two steps.

####Build

For a full build, including unit tests and integration tests, docker image build, you can run -
```
make all
```

####Integration Test

####Prerequisite:
1. Install docker using Docker Tools or native docker if on mac
2. Verify if docker-compose is installed by running following command else install it.
```
docker-compose

```
3. Add the following entries in `/etc/hosts` :
```
127.0.0.1 kafkasvc
127.0.0.1 wiremock
127.0.0.1 elasticsearch
127.0.0.1 zookeeper
```
4. Build storage backend to run integration test for `anomaly-store`
```
make build_storage_backends
``` 

####Running Integration Tests:
Run the build and integration tests for individual components with
```
make alert-api

```

&&

```
make anomaly_store

```
