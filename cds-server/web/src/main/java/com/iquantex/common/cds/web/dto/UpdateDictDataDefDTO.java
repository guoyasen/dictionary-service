package com.iquantex.common.cds.web.dto;


/**
 * 字典子项修改
 */
public class UpdateDictDataDefDTO {
    /**
     * 字典值
     */
    private String value;
    /**
     * 中文翻译
     */
    private String name;
    /**
     * 字典英文值
     */
    private String enName;

    /**
     * 获取字典值
     */
    public String getValue() {
        return this.value;
    }

    /**
     * 设置字典值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取中文翻译
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置字典翻译
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取字典英文值
     */
    public String getEnName() {
        return this.enName;
    }

    /**
     * 设置字典英文值
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
}