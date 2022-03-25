
SET JSON_ENV_PATH=%USERPROFILE%

cd /D %JSON_ENV_PATH%	
call json-server --watch Z:\Automation\JavaCucumber\BDD_HCL\CucumberHCL\src\main\resources\TestData\json\db.json
