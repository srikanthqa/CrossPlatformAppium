#!/usr/bin/env bash
########################## CHECK DEVICES #############
# Setup Starting a new Gradle Daemon for this build (subsequent builds will be faster).
touch ~/.gradle/gradle.properties && echo "org.gradle.daemon=true" >> ~/.gradle/gradle.properties

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

adb uninstall com.shopkick.app
Echo "Old App Uninstalled"
Echo "App Installed"
#adb shell getprop ro.product.model > src/main/resources/local.properties
########################## Start Appium #########################

killall node ; appium > logs/appium.log &
#killall node ; appium

#mvn -Dtest=EmailAuthentication test
#mvn -Dtest=com.qa.shopkick.tests.Authentication.EmailAuthentication test
#mvn -Dtest=com.qa.shopkick.tests.Authentication.FacebookAuthentication test

gradle -Dtest.single=EmailAuthentication test --info || echo "BUILD FAILED"> logs/build.status

#mvn -DplatformType='Android' -DplatformVersion='5.0.1' -DdeviceName='GalaxyS5' -DdeviceUDID='null' -Dtest=EmailAuthentication test || echo "BUILD FAILED"> logs/build.status

adb uninstall com.shopkick.app
Echo "Old App Uninstalled"

echo "Update TestLodge"
if [ -s  testLodge_script/testLodge.json ]
then
    -Dtest.single=QaEmailProcessor test
    echo "Email Sent"
else
    echo "BUILD FAILED"
fi