#!/usr/bin/env bash

mkdir logs
mkdir reports
mkdir screenshots

adb uninstall com.shopkick.app
Echo "App Uninstalled"
########################## Start Appium #########################
#killall node ; appium > logs/appium.log &
#killall node ; appium --address 0.0.0.0 --port 4723 > logs/appium.log &
########################### Kick off tests ######################################
#sleep 2
#mvn clean compile
mvn -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication test
#mvn -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication#Test1_LoginWrongEmailAccount test



#python testLodge_script/testrail_reporter.py -p "Avery Automation" -s SmokeTests testLodge_script/testLodge.json