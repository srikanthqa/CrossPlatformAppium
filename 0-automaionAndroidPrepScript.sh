#!/bin/sh

#  appium.sh
#  
#
#  Created by Vivek Nyayapathi on 3/4/15.
#
################ SET YOUR CURRENT WORKING DIRECTORY ##########################

MY_HOME=$PWD

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

############################# Install APK ################################################

mkdir logs
mkdir reports
mkdir screenshots

############ remove old files #################

echo "Deleting old apk from build folder"
echo "*****************"
rm -rf Shopkick-release-unsigned.apk
echo "Deleting old apk from Your device"
echo "*****************"

rm -fr logs/Logcat.txt
cat /dev/null > logs/build.status
adb uninstall com.shopkick.app

############ CLean Up Appium  #################

killall /usr/local/bin/node
killall node
############  Downloading the build #################
Echo 'Downloading the build'
echo "*****************"

curl --output APK/Shopkick-release.apk -O http://shopkicks-mac-pro.local:8080/job/Android_trunk/ws/apps/shopkick/android/Shopkick/bin/Shopkick-release.apk

Echo 'Installing APK ....'

adb install -r APK/Shopkick-release.apk
########################## Start Appium #########################
appium --address 0.0.0.0 --port 4723 > logs/appium.log &
########################### Kick off tests ######################################

