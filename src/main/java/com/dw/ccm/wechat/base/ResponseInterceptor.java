package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 响应消息拦截器
 *
 * @author xingkong1221
 * @date 2014/12/5
 */
public interface ResponseInterceptor {

    /**
     * 处理调用微信接口响应的消息
     *
     * @param response 接口调用响应消息
     * @param weChat 微信公众平台接口
     * @return 返回 {@code true}， 重新调用接口, 返回 {@code false}， 继续执行
     */
    public boolean handle(BaseResponse response,  WeChat weChat);
}
