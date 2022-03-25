
SET JENKINS_ENV_PATH=C:\Jenkins

CD /D "%JENKINS_ENV_PATH%"

echo e055a4d157e52a84ea06a2958fcd7b7fbb200ac5b33468a88f56001a6019e35c > secret-file
java -jar agent.jar -jnlpUrl http://localhost:8081/computer/DheoClaveria/jenkins-agent.jnlp -secret @secret-file -workDir "C:\Jenkins"