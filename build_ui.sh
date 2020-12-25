#/bin/sh

set -e

cd `dirname $0`
package_target_dir=cds-server/web/src/main/resources/static
cd cds-ui
npm config set sass_binary_site https://npm.taobao.org/mirrors/node-sass/
npm --registry http://10.116.18.70:8081/content/groups/npm-quantex-group/ install
npm run dist
cd ../

rm -rf $package_target_dir/cds
mv cds-ui/dist  $package_target_dir/cds
