package com.dw.ccm.wechat.base.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * 微信API响应结果基础对象<br>
 * 包含<code>errCode</code>, <code>errMsg</code>两个基本字段
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class BaseResponse {

	/**
	 * 错误代码
	 */
	@SerializedName("errcode")
	private Integer errCode;
	
	/**
	 * 错误信息
	 */
	@SerializedName("errmsg")
	private String errMsg;
	
	/**
	 * 检查是否有错误信息
	 * @return 如果有错误信息，返回<code>true</code>，反之返回<code>false</code>
	 */
	public boolean hasError() {
		return errCode == null ? false : errCode != 0;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

    @Override
    public String toString() {
        return "接口调用出错{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
