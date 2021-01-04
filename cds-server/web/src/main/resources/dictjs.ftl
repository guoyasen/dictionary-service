/**
* 数据字典常量定义
* 代码由程序生成,请勿修改该文件
* 如需增加常量,请到数据字典管理哪里增加,并通知相关人员重新生成常量文件
*/
export const DICTDATA = {
<#list list as data>
<#if data.appIdAndDictKey??>
    ${data.appIdAndDictKey}: [
    <#list data.jsFieldByDictKeys as jsFieldByDictKey>
        {
            id:${jsFieldByDictKey.string?string("'"+ jsFieldByDictKey.value + "'", jsFieldByDictKey.value)},
            name:'${jsFieldByDictKey.name}'
        },
</#list>
    ],

</#if>
</#list>
};

export const DICT = {
<#list list as data>
  <#if data.comment??>
  // ${data.comment}
  </#if>
<#list data.fields as field>
  ${field.identifier}: ${field.string?string("'"+ field.value + "'", field.value)},  // ${field.annotation}
</#list>

</#list>
};