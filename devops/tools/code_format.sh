#!/bin/sh

APP_PATH=$(cd `dirname $0`/../../; pwd)
APP_NAME=`echo $APP_PATH | awk -F "/" '{print $NF}'`
cd $APP_PATH

cd cds-server
mvn clean compile


