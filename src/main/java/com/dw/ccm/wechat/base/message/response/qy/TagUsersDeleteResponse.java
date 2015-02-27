package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 删除标签成员相应对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class TagUsersDeleteResponse extends BaseResponse {
	
	/**
	 * 不在权限内的或者非法的员工ID列表，以“|”分隔
	 */
	public String invalidlist;

	public String getInvalidlist() {
		return invalidlist;
	}

	public void setInvalidlist(String invalidlist) {
		this.invalidlist = invalidlist;
	}
	
}
