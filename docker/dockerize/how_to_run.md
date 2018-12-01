mvn clean install -DskipTests -Dsonar.skip -Dcheckstyle.skip

Budujemy:
```
./build-image.sh
```

Uruchoamiamy:
```
docker run --name igt-jar igt-spring-trening:latest
```

Jeśli chcemy się zalogować:
```
docker exec -it igt-jar sh
```