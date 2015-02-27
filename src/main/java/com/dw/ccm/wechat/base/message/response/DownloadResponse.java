package com.dw.ccm.wechat.base.message.response;

/**
 * 下载响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class DownloadResponse extends BaseResponse {

	/**
	 * 内容类型
	 */
	protected String contentType;
	
	/**
	 * 内容大小
	 */
	protected String contentLength;
	
	/**
	 * 文件名称
	 */
	private String filename;
	
	/**
	 * 数据
	 */
	private byte[] data;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
