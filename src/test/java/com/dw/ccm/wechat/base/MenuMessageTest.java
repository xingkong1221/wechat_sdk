package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.menu.ActionButton;
import com.dw.ccm.wechat.base.message.menu.MenuMessage;
import com.dw.ccm.wechat.base.message.menu.SubButton;
import com.dw.ccm.wechat.base.message.menu.ViewButton;
import org.junit.Test;

/**
 * @author xingkong1221
 * @date 2014/12/2
 */
public class MenuMessageTest {

    @Test
    public void main() {
        MenuMessage menuMessage = new MenuMessage();

        ActionButton clickButton = new ActionButton(ActionButton.ButtonType.CLICK, "歌曲", "Today_Music");

        ViewButton viewButton = new ViewButton("搜索", "http://www.baidu.com");

        SubButton subButton = new SubButton();

        ActionButton waitingButton = new ActionButton(ActionButton.ButtonType.SCAN_CODE_WAIT_MSG, "扫码带提示", "selfmenu_0_0");
        ActionButton photoButton = new ActionButton(ActionButton.ButtonType.PIC_SYS_PHOTO, "系统拍照发图", "rselfmenu_1_0");

        subButton.getSubButton().add(waitingButton);
        subButton.getSubButton().add(photoButton);

        menuMessage.getButtonList().add(clickButton);
        menuMessage.getButtonList().add(viewButton);
        menuMessage.getButtonList().add(subButton);

        System.out.println(menuMessage.toJson());
    }
}
