#!/bin/sh

Echo "0-automaionAndroidPrepScript.sh"

#./0-automaionAndroidPrepScript.sh

#Build
mvn clean compile
#Run Tests

mvn -e -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication#Test1_LoginWrongEmailAccount test
#mvn -DplatformType='Android' -DplatformVersion='4.4.2' -DdeviceName='GalaxyS5' -DdeviceUDID='null' -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication test

############ Going to Uninstall the app
#adb uninstall com.shopkick.app