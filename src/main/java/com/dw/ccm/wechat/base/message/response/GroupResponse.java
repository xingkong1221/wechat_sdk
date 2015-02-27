package com.dw.ccm.wechat.base.message.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * 创建分组响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class GroupResponse extends BaseResponse {

	/**
	 * 公众平台分组信息
	 */
	private Group group;
	
	/**
	 * 公众平台分组信息列表
	 */
	private List<Group> groups;
	
	/**
	 * 用户所属的groupid
	 */
	@SerializedName("groupid")
	private String groupId;
	
	public static class Group {
		
		/**
		 * 分组id，由微信分配
		 */
		private Integer id;
		
		/**
		 * 分组名字，UTF8编码
		 */
		private String name;
		
		/**
		 * 分组内用户数量
		 */
		private Integer count;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
