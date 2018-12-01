docker run -d --rm --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:latest

mvn clean install sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dcheckstyle.skip -Dsonar.login=admin -Dsonar.password=admin

