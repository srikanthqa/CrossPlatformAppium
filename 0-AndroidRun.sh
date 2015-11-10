#!/usr/bin/env bash

########################## CHECK DEVICES #############

NOT_PRESENT="List of devices attached"
ADB_FOUND=`adb devices | tail -2 | head -1 | cut -f 1 | sed 's/ *$//g'`

if [[ ${ADB_FOUND} == ${NOT_PRESENT} ]]; then
echo "Android device seems to be missing."
echo "*****************"
echo "********Exiting*********"
exit
else
echo "Android device found. Starting Tests"
echo "*****************"
fi

mkdir logs
mkdir reports
mkdir screenshots

/Applications/android-sdk-macosx/platform-tools/adb uninstall com.shopkick.app
Echo "Old App Uninstalled"

Echo "App Installed"
#adb shell getprop ro.product.model > src/main/resources/local.properties
########################## Start Appium #########################
killall /usr/local/bin/node ; /usr/local/bin/appium > logs/appium.log &

#killall node ; appium

#/usr/local/bin/mvn -Dtest=EmailAuthentication test
#/usr/local/bin/mvn -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication test
#/usr/local/bin/mvn -Dtest=com.qa.shopkick.tests.Authentication.FacebookAuthentication test

/usr/local/bin/mvn -DplatformType='Android' -DplatformVersion='5.0.1' -DdeviceName='GalaxyS5' -DdeviceUDID='null' -Dtest=EmailAuthentication test || echo "BUILD FAILED"> logs/build.status

/Applications/android-sdk-macosx/platform-tools/adb uninstall com.shopkick.app
Echo "Old App Uninstalled"

echo "Update TestLodge"
if [ -s  testLodge_script/testLodge.json ]
then
    /usr/local/bin/mvn -Dtest=QaEmailProcessor test
    echo "Email Sent"
else
    echo "BUILD FAILED"
fi



