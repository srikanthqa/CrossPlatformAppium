#!/usr/bin/env bash

echo "Update TestLodge"
if [ -s  testLodge_script/testLodge.json ]
then
    mvn -Dtest=QaEmailProcessor test
    echo "Email Sent"
else
    echo "BUILD FAILED"
fi
