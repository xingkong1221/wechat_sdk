package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.menu.*;
import com.dw.ccm.wechat.base.message.response.MenuResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author xingkong1221
 * @date 2014/12/2
 */
public class MenuMessageTest {

    @Test
    public void test() {

        WeChat weChat = WeChatHelper.getWeChat(WeChatHelper.getAccessToken("wxd2bff322d0c25d5f", "5383aade955f01939562613bef7a2c44").getAccessToken());


        MenuMessage menuMessage = new MenuMessage();

        ButtonGroup firstGroup = new ButtonGroup("集合1");
        firstGroup.addButton(new ClickButton("今日歌曲", "TODAY_MUSIC"));
        firstGroup.addButton(new ViewButton("百度一下", "http://www.baidu.com"));
        firstGroup.addButton(new ScanCodeWaitMsgButton("扫码推消息", "SCAN_CODE_MSG_0001"));
        firstGroup.addButton(new PicSysPhotoButton("我要拍照片", "PIC_SYS_PHOTO_0001"));

        ScanCodePushButton secondButton = new ScanCodePushButton("我要扫码", "SCAN_CODE_00001");

        ButtonGroup thirdGroup = new ButtonGroup("集合2");
        thirdGroup.addButton(new PicPhotoOrAlbumButton("从相册中选", "PIC_ALBUM_0001"));
        thirdGroup.addButton(new PicWeiXinButton("微信相册", "PIC_WEIXIN_0001"));
        thirdGroup.addButton(new LocationSelectButton("上报地理位置","LOCATION_SELECT_00001"));

        menuMessage.addButton(firstGroup).addButton(secondButton).addButton(thirdGroup);

        System.out.println(menuMessage.toJson());

        MenuResponse response = weChat.createMenu(menuMessage.toJson());
        Assert.assertTrue(response.getErrCode() == 0);
    }
}
