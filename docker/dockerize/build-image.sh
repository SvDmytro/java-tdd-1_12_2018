#!/usr/bin/env sh

cd "$(dirname "$0")"

mvn package -f ../../pom.xml -Dmaven.test.skip -Dsonar.skip -Dcheckstyle.skip

./copy-arts.sh

docker build -t igt-spring-trening .

rm -r igt-spring-trening.jar dependencies snapshot-dependencies