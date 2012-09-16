#! /usr/bin/env bash

if [ $# -ne 4 ]
then
    echo "usage `basename $0` <gameId> <playerId> <latitude> <longitude>"
    exit
fi

curl -v -X POST -d "format=json&latitude=$3&longitude=$4"  http://localhost:8080/catchvifyoucan-grails-server/api/game/$1/$2
