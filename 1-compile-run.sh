#!/bin/sh

Echo "Running 0startAppiumServer.sh"
./0-automaionAndroidPrepScript.sh
#Build
mv clean build
#Run Tests

mvn -DplatformType='Android' -Dtest=com.qa.shopkick.tests.SmokeSuiteTwo test