#! /usr/bin/env bash

echo "Creating a game"

curl -v -X POST -d "format=json" http://localhost:8080/catchvifyoucan-grails-server/api/game
