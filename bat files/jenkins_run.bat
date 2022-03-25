
SET JENKINS_ENV_PATH=C:\Jenkins

cd /D %JENKINS_ENV_PATH% 

call java -jar jenkins.war --enable-future-java  --httpPort=8081

