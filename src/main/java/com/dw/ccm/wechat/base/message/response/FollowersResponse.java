package com.dw.ccm.wechat.base.message.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 关注者列表响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月9日
 */
public class FollowersResponse extends BaseResponse {

	/**
	 * 关注该公众账号的总用户数
	 */
	private Long total;
	
	/**
	 * 拉取的OPENID个数，最大值为10000
	 */
	private Integer count;
	
	/**
	 * 列表数据，OPENID的列表
	 */
	private Data data;
	
	/**
	 * 拉取列表的后一个用户的OPENID
	 */
	@SerializedName("next_openid")
	private String nextOpenId;
	
	public class Data {

		@SerializedName("openid")
		private List<String> openId;

		public List<String> getOpenId() {
			return openId;
		}

		public void setOpenId(List<String> openId) {
			this.openId = openId;
		}
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getNextOpenId() {
		return nextOpenId;
	}

	public void setNextOpenId(String nextOpenId) {
		this.nextOpenId = nextOpenId;
	}
}
