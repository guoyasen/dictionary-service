#!/bin/bash

#执行demo
#./portals-helloworld/devops/tools/gen_project.sh <组名> <应用名称全称> <应用名称简写>
#./portals-helloworld/devops/tools/gen_project.sh cicc fi-qcr fcr

#支持的环境
# Windows(git bash)
# Linux
# mac环境存在部分命令不兼容情况

echo "cd $(dirname $0)"
cd $(dirname $0)

#$1 修改目标文件夹名称
project_file_path="../../../portals-helloworld"
#$2 组名
group_name=${1}
#$3 应用名全称
app_name=${2}
#$4 应用名简称
app_name_abbrev=${3}

# --------------------  环境变量
phw_names[0]='phw'                # 应用名称简称(小写)
phw_names[1]="${phw_names[0]^}"   # 应用名称简称(首字母大写)
phw_names[2]="${phw_names[0]^^}"  # 应用名称简称(大写)
phw_names[3]="portals-helloworld" # 应用名全称
phw_names[4]="portals"            # 组名

target_names[0]="${app_name_abbrev}"
target_names[1]="${app_name_abbrev^}"
target_names[2]="${app_name_abbrev^^}"
target_names[3]="${app_name}"
target_names[4]="${group_name}"

#需要过滤的文件或目录名称
filters[0]="target"
filters[1]="idea"
filters[2]="git/"
filters[3]="iml"
filters[4]="log"
filters[5]="md"
filters[6]="mvnw"
filters[7]="node_modules"
filters[8]="dist"
filters[9]="gen_project"

filters_str=""
for ((i = 0; i < ${#filters[@]}; i++)); do
  #  echo "$i:${filters[${i}]}"
  if [ $i -eq 0 ]; then
    filters_str=".*${filters[${i}]}.*"
  else
    filters_str="${filters_str}|.*${filters[${i}]}.*"
  fi
done
#echo "filters_str: ${filters_str}"

# ---------------------  函数区
function read_dir() {
  file_path=${1}
  # shellcheck disable=SC2045
  for file in $(ls $file_path); do
    if [ -d "${file_path}/${file}" ]; then
      local file_old="$file"
      local list_old="$file_path"
      file_filtering ${file}
      local results=$?
      #      echo "results = ${results}"
      if [ $results -eq 0 ]; then
        continue
      fi
      read_dir "$file_path/$file"
      mv_file $list_old $file_old
    else
      #      echo "$file_path/$file"
      mv_file $file_path $file
    fi
  done
}

# $1 文件路径
# $2 目标文件名称
function mv_file() {
  file_path=${1}
  file_name=${2}
  for i in "${!phw_names[@]}"; do
    if [[ ${file_name} =~ ${phw_names[${i}]} ]]; then
      #echo "修改文件名称 ${file_path}/${file_name} ===>>> ${file_path}/${file_name/${phw_names[${i}]}/${target_names[${i}]}}"
      echo "修改文件名称: ${file_name} --> ${file_name/${phw_names[${i}]}/${target_names[${i}]}}"
      # shellcheck disable=SC1073
      mv "${file_path}/${file_name}" "${file_path}/${file_name/${phw_names[${i}]}/${target_names[${i}]}}"
    fi
  done
}

# 文件过滤
function file_filtering() {
  file_name=${1}
  # shellcheck disable=SC2068
  for filter in ${filters[@]}; do
    # shellcheck disable=SC2077
    if [ ${file_name}==$filter ]; then
      return 1
    fi
  done
  return 0
}

# ----------------脚本开始执行的地方
# 参数校验
echo $0
if [[ "${#}" -ne 3 ]]; then
  echo "参数错误"
  echo "├---脚本有四个参数组成:<组名> <应用名称全程> <应用名称简写>"
  echo "└---<${0}>.sh <组名> <应用名称全程> <应用名称简写>"
  exit 1
fi
if [[ ! "${app_name_abbrev}" =~ ^[a-z]{3}$ ]]; then
  echo "应用简写名称格式错误 <${app_name_abbrev}>"
  echo "└---符号规范:三个小写字母"
  exit 1
fi
if [[ ! "${app_name}" =~ ^[a-z]+(-([a-z])+){0,2}$ ]]; then
  echo "应用名全称格式错误 <${app_name}>"
  echo "└---规则:不多于三个单词,单词间隔采用\"-\"隔开,全部小写"
  exit 1
fi
if [[ ! "${group_name}" =~ ^[a-z]+$ ]]; then
  echo "组名格式错误 ${group_name}"
  echo "└---符号规范:一个的单词,全部小写"
  exit 1
fi

## 替换文件内容
echo "file_path: ${project_file_path}"
for i in "${!phw_names[@]}"; do
  echo "开始替换文件内容: ${phw_names[${i}]} --> ${target_names[${i}]}"
  grep -n -r "${phw_names[${i}]}" ${project_file_path} | awk -F ":" '{print $1}' | grep -v -E "${filters_str}" | sort | uniq | xargs -i sed -i "s/${phw_names[${i}]}/${target_names[${i}]}/g" {}
done

##替换目录
read_dir ${project_file_path}
mv_file "." ${project_file_path}
