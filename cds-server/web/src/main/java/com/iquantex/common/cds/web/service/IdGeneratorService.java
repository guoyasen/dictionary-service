package com.iquantex.common.cds.web.service;


/**
 * @Author wangpb
 * @Date 2020/11/2
 * @Description
 **/
public interface IdGeneratorService {

    /**
     *  随机生成id
     * @return
     */
    String nextId();

    /**
     *  生成模型id
     * @param tradeDate 交易日
     * @return
     */
    String nextId(Long tradeDate);

}
