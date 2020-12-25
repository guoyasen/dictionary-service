#!/bin/bash

set -e

cd `dirname $0`

# 依赖安装
npm install

# 项目打包
npm run dist

# git log -n 1 | grep -v Author > $MODULE_NAME/commit.info
mv dist/* docker

echo "cds-ui compiled successfully"
