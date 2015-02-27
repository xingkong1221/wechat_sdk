package com.dw.ccm.wechat.base.message.response.qy;

import java.util.List;

import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * 获取部门列表返回结果对象
 * 
 * @author xingkong1221
 * @date 2014年9月23日
 */
public class DepartListResponse extends BaseResponse {
	
	/**
	 * 部门列表数据
	 */
	private List<Department> department;
	
	/**
	 * 获取部门列表数据
	 * @return 部门列表数据
	 */
	public List<Department> getDepartment() {
		return department;
	}

	/**
	 * 设置部门列表数据
	 * @param department 部门列表数据
	 */
	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	/**
	 * 部门
	 * 
	 * @author xingkong1221
	 * @date 2014年9月23日
	 */
	public static class Department {
		/**
		 * 部门id
		 */
		private int id;
		
		/**
		 * 部门名称
		 */
		private String name;
		
		/**
		 * 父部门id，根部门为1
		 */
		@SerializedName("parentid")
		private int parentId;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getParentId() {
			return parentId;
		}

		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
	}
}
