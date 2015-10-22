#!/usr/bin/env bash



killall node

adb uninstall com.shopkick.app
adb install -r APK/Shopkick_debug_qa*.apk

########################## Start Appium #########################
appium
########################### Kick off tests ######################################
