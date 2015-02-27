package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 增加标签成员相应对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class TagUsersAddResponse extends BaseResponse{
	
	/**
	 * 不在权限内的员工ID列表，以“|”分隔
	 */
	private String invalidlist;

	public String getInvalidlist() {
		return invalidlist;
	}

	public void setInvalidlist(String invalidlist) {
		this.invalidlist = invalidlist;
	}
	
}
