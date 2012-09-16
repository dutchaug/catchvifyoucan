#! /usr/bin/env bash

if [ $# -ne 2 ]
then
    echo "usage `basename $0` <gameId> <playerId>"
    exit
fi

curl -v -X PUT http://localhost:8080/catchvifyoucan-grails-server/api/game/$1/$2?format=json
