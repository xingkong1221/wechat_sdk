package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 创建标签返回对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class TagCreateResponse extends BaseResponse {
	
	/**
	 * 标签编号
	 */
	public String tagid;

	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
}
