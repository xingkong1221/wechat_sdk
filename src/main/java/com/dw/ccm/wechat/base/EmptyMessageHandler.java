package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.InMessage;
import com.dw.ccm.wechat.base.message.PassiveMessage;

/**
 * 空微信消息处理器
 *
 * @author xingkong1221
 * @date 2014/11/18
 */
public abstract class EmptyMessageHandler implements MessageHandler {

    @Override
    public boolean preHandle(InMessage inMessage, PassiveMessage outMessage) {
        return true;
    }

    @Override
    public void handleTextMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleImageMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleVoiceMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleVideoMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleLocationMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleLinkMsg(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleSubscribeEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleUnsubscribeEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleScanEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleLocationEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleClickEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleViewEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void handleTemplatesendjobfinishEvent(InMessage inMessage, PassiveMessage outMessage) {

    }

    @Override
    public void postHandle(InMessage inMessage, PassiveMessage outMessage) {

    }
}
