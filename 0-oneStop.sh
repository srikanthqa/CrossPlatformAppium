#!/usr/bin/env bash

mkdir logs
mkdir reports
mkdir screenshots

adb uninstall com.shopkick.app
Echo "Old App Uninstalled"

#adb install -r Shopkick_debug_qa_e80a4cd5f375938343f5a8f91d51763b6339c89f.apk
Echo "App Installed"
adb shell getprop ro.product.model > src/main/resources/local.properties
########################## Start Appium #########################
killall node ; appium > logs/appium.log &

#killall node ; appium

mvn -Dtest=TestRunner test
#mvn -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication test
#mvn -Dtest=com.qa.shopkick.tests.Authentication.FacebookAuthentication test

#mvn -DplatformType='Android' -DplatformVersion='5.0.1' -DdeviceName='GalaxyS5' -DdeviceUDID='null' -Dtest=*Authentication test