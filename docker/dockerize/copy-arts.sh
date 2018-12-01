#!/usr/bin/env sh

cd "$(dirname "$0")"

cp ../../target/igt-spring-trening-1.0-SNAPSHOT.jar igt-spring-trening.jar
cp -r ../../target/dependencies .
mkdir snapshot-dependencies
mv dependencies/*-SNAPSHOT.jar snapshot-dependencies/
