Cross Platform Appium-JUnit-Project Using Maven
---

#Update to JAVA 8 

# Install Gradle (2.7)
# Install Homebrew : http://brew.sh/
 ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# get node.js
 brew install node

# get appium
 npm install -g appium

# get appium client
 npm install wd

You will then need to start appium, eg:

sh 0-AndroidRun.sh

#To compile and run all tests, run:

    gradle clean compile
    gradle test

#To run a single test, run:

gradle -Dtest=EmailAuthentication test

# Good idea to follow

# Check out the code from Stash
https://github.com/nrvivek23/CrossPlatformAppium.git

#Download Android Studio ... It has IDE and Android SDK and Command Prompt

# Import the code as a Gradle project
