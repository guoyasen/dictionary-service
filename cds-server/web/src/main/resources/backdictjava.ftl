/**
* 数据字典常量定义
* 代码由程序生成,请勿修改该文件
* 如需增加常量,请到数据字典管理哪里增加,并通知相关人员重新生成常量文件
*/
public class DictConstants {
<#list list as data>
    <#if data.comment??>
  // ${data.comment}
    </#if>
    <#list data.fields as field>
    public static final ${field.string?string("String", "Integer")} ${field.identifier} = ${field.string?string("\""+ field.value + "\"", field.value)}; // ${field.annotation}

    </#list>

</#list>
}