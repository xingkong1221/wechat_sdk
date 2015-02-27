package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 创建部分返回结果对象
 * 
 * @author xingkong1221
 * @date 2014年9月23日
 */
public class DepartCreateResponse extends BaseResponse {
	
	/**
	 * 创建的部门id
	 */
	private int id;

	/**
	 * 获取创建的部门id
	 * @return 创建的部门id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置创建的部门id
	 * @param id 创建的部门id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
