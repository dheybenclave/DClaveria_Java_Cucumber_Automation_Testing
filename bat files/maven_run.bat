REM maven itself uses a batch file so each mvn must be preceded by "call"
REM the -f flag specifies where the pom.xml is found for the project
REM mvn install will save the target output to %userprofile%\.m2\repository ...

SET ENV_PATH=Z:\Automation\JavaCucumber\BDD_HCL\CucumberHCL
cd %ENV_PATH%
call mvn install

pause>nul
