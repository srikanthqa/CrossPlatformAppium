#!/usr/bin/env bash

mkdir logs
mkdir reports
mkdir screenshots

adb uninstall com.shopkick.app
Echo 'Installing APK ....'
adb install -r APK/Shopkick_debug_qa*.apk
########################## Start Appium #########################
killall node ; appium > logs/appium.log &
#killall node ; appium --address 0.0.0.0 --port 4723 > logs/appium.log &
########################### Kick off tests ######################################

mvn -e -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication#Test1_LoginWrongEmailAccount test