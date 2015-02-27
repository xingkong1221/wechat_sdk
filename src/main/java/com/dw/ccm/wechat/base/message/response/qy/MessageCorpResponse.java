package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 消息响应对象
 * 
 * @author xingkong1221
 * @date 2014年9月28日
 */
public class MessageCorpResponse extends BaseResponse {

	/**
	 * 无效的用户
	 */
	private String invaliduser;
	
	/**
	 * 无效的部门
	 */
	private String invalidparty;
	
	/**
	 * 无效的标签
	 */
	private String invalidtag;

	public String getInvaliduser() {
		return invaliduser;
	}

	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}

	public String getInvalidparty() {
		return invalidparty;
	}

	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}

	public String getInvalidtag() {
		return invalidtag;
	}

	public void setInvalidtag(String invalidtag) {
		this.invalidtag = invalidtag;
	}
}
