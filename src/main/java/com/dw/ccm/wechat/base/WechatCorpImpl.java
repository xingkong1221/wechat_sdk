package com.dw.ccm.wechat.base;

import java.util.List;

import org.apache.http.util.Asserts;

import com.dw.ccm.wechat.base.message.menu.MenuMessage;
import com.dw.ccm.wechat.base.message.qy.BaseCorpMessage;
import com.dw.ccm.wechat.base.message.qy.UserMessage;
import com.dw.ccm.wechat.base.message.qy.UserMessage.Type;
import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.dw.ccm.wechat.base.message.response.DownloadResponse;
import com.dw.ccm.wechat.base.message.response.UploadResponse;
import com.dw.ccm.wechat.base.message.response.qy.AccessTokenCorpResponse;
import com.dw.ccm.wechat.base.message.response.qy.DepartCreateResponse;
import com.dw.ccm.wechat.base.message.response.qy.DepartDeleteResponse;
import com.dw.ccm.wechat.base.message.response.qy.DepartListResponse;
import com.dw.ccm.wechat.base.message.response.qy.DepartUpdateResponse;
import com.dw.ccm.wechat.base.message.response.qy.MessageCorpResponse;
import com.dw.ccm.wechat.base.message.response.qy.TagCreateResponse;
import com.dw.ccm.wechat.base.message.response.qy.TagGetResponse;
import com.dw.ccm.wechat.base.message.response.qy.TagUsersAddResponse;
import com.dw.ccm.wechat.base.message.response.qy.TagUsersDeleteResponse;
import com.dw.ccm.wechat.base.message.response.qy.UserGetResponse;
import com.dw.ccm.wechat.base.message.response.qy.UserListResponse;
import com.dw.ccm.wechat.base.utils.HttpUtils;
import com.dw.ccm.wechat.base.utils.JsonUtils;

public class WechatCorpImpl implements WechatCorp {
	
	/**
	 * 接口调用凭证
	 */
	private String accessToken;
	
	/**
	 * 实例化微信企业好接口对象
	 * @param accessToken 接口调用凭证
	 */
	public WechatCorpImpl(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public AccessTokenCorpResponse getAccessToken(String corpId,
			String corpSecret) {
		Asserts.notBlank(corpId, "企业Id不能为空");
		Asserts.notBlank(corpSecret, "管理组的凭证密钥不能为空");
		String url = String.format(WechatCorp.ACCESS_TOKEN, corpId, corpSecret);
		return HttpUtils.get(url, AccessTokenCorpResponse.class);
	}


	@Override
	public DepartCreateResponse createDepartment(String name, String parentId,
			String order) {
		Asserts.notBlank(name, "部门名称不能为空");
		Asserts.check(name.length() <= 64, "部门名称长度限制为1~64个字符");
		Asserts.notBlank(parentId, "父亲部门id不能为空");
		String url = String.format(CREATE_DEPARTMENT, accessToken);
		String json = "{\"name\": \"%s\",\"parentid\": \"%s\",\"order\": \"%s\"}";
		String raw = String.format(json, name, parentId, order);
		return HttpUtils.post(url, raw, DepartCreateResponse.class);
	}


	@Override
	public DepartUpdateResponse updateDepartment(int id, String name,
			String parentId, String order) {
		Asserts.notNull(id, "部门id不能为空");
		if (name != null) {
			Asserts.check(name.length() <= 64, "更新的部门名称长度限制为0~64个字符");
		}
		String url = String.format(UPDATE_DEPARTMENT, accessToken);
		String json = "{\"id\": %s,\"name\": \"%s\",\"parentid\": \"%s\",\"order\": \"%s\"}";
		String raw = String.format(json, id, name, parentId, order);
		return HttpUtils.post(url, raw, DepartUpdateResponse.class);
	}


	@Override
	public DepartDeleteResponse deleteDepartment(int id) {
		Asserts.notNull(id, "部门id");
		String url = String.format(WechatCorp.DELETE_DEPARTMENT, accessToken, id);
		return HttpUtils.get(url, DepartDeleteResponse.class);
	}

	@Override
	public DepartListResponse listDepartment() {
		String url = String.format(WechatCorp.LIST_DEPARTMENT, accessToken);
		return HttpUtils.get(url, DepartListResponse.class);
	}


	@Override
	public BaseResponse createUser(UserMessage userMessage) {
		Asserts.notNull(userMessage, "用户资料对象不能为空");
		String url = String.format(WechatCorp.CREATE_USER, accessToken);
		return HttpUtils.post(url, userMessage.toJson(Type.create), BaseResponse.class);
	}


	@Override
	public BaseResponse updateUser(UserMessage userMessage) {
		Asserts.notNull(userMessage, "用户资料对象不能为空");
		String url = String.format(WechatCorp.UPDATE_USER, accessToken);
		return HttpUtils.post(url, userMessage.toJson(Type.update), BaseResponse.class);
	}


	@Override
	public BaseResponse deleteUser(String userId) {
		Asserts.notBlank(userId, "员工UserID不能为空");
		String url = String.format(WechatCorp.DELETE_USER, accessToken, userId);
		return HttpUtils.get(url, BaseResponse.class);
	}


	@Override
	public UserGetResponse getUser(String userId) {
		Asserts.notBlank(userId, "员工UserID不能为空");
		String url = String.format(WechatCorp.GET_USER, accessToken, userId);  
		return HttpUtils.get(url, UserGetResponse.class);
	}


	@Override
	public UserListResponse listUser(int departmentId, int fetchChild,
			int status) {
		Asserts.notNull(departmentId, "部门id不能为空");
		String url = String.format(WechatCorp.LIST_USER, accessToken, departmentId, fetchChild, status);
		return HttpUtils.get(url, UserListResponse.class);
	}

	@Override
	public TagCreateResponse createTag(String tagName) {
		Asserts.notNull(tagName, "标签信息不能为空");
		String json = "{\"tagname\": \"%s\"}";
		String raw = String.format(json, tagName);
		String url = String.format(WechatCorp.CREATE_TAG, accessToken);
		return HttpUtils.post(url, raw, TagCreateResponse.class);
	}

	@Override
	public BaseResponse updateTag(int tagId, String tagName) {
		Asserts.notNull(tagId, "标签ID不能为空");
		if (tagName != null) {
			Asserts.check(tagName.length() <= 64, "标签名称最长64个字符");
		}
		String json = "{\"tagid\": \"%s\",\"tagname\": \"%s\"}";
		String raw = String.format(json, tagId, tagName);
		String url = String.format(WechatCorp.UPDATE_TAG, accessToken);
		return HttpUtils.post(url, raw, BaseResponse.class);
	}

	@Override
	public BaseResponse deleteTag(int tagId) {
		Asserts.notNull(tagId, "标签ID不能为空");
		String url = String.format(WechatCorp.DELETE_TAG, accessToken, tagId);
		return HttpUtils.get(url, BaseResponse.class);
	}

	@Override
	public TagGetResponse getTag(int tagId) {
		Asserts.notNull(tagId, "标签ID不能为空");
		String url = String.format(WechatCorp.GET_TAG, accessToken, tagId);
		return HttpUtils.get(url, TagGetResponse.class);
	}

	@Override
	public TagUsersAddResponse addTagUsers(int tagId, List<String> userIdList) {
		Asserts.notNull(tagId, "标签ID不能为空");
		Asserts.notNull(userIdList, "企业员工ID列表不能为空");
		String json = "{\"tagid\": \"%s\",\"userlist\":%s}";
		String raw = String.format(json, tagId, JsonUtils.toJson(userIdList));
		String url = String.format(WechatCorp.ADD_TAGUSERS, accessToken);
		return HttpUtils.post(url, raw, TagUsersAddResponse.class);
	}

	@Override
	public TagUsersDeleteResponse deleteTagUsers(int tagId,
			List<String> userIdList) {
		Asserts.notNull(tagId, "标签ID不能为空");
		Asserts.notNull(userIdList, "企业员工ID列表不能为空");
		String json = "{\"tagid\": \"%s\",\"userlist\":%s}";
		String raw = String.format(json, tagId, JsonUtils.toJson(userIdList));
		String url = String.format(WechatCorp.DELETE_TAGUSERS, accessToken);
		return HttpUtils.post(url, raw, TagUsersDeleteResponse.class);
	}

	@Override
	public UploadResponse upload(byte[] data, String filename, String type) {
		Asserts.check(data.length > 0, "媒体文件数据不能为空！");
		Asserts.notBlank(filename, "媒体文件名称不能为空！");
		Asserts.notBlank(type, "媒体文件类型不能为空！");
		Asserts.check(WeChat.UploadMediaType.contains(type), "上传多媒体文件，文件类型不合法： " + type);
		String url = String.format(WechatCorp.UPLOAD_MEDIA, accessToken, type);
		return HttpUtils.upload(url, data, filename);
	}

	@Override
	public DownloadResponse download(String mediaId) {
		Asserts.notBlank(mediaId, "媒体文件id不能为空！");
		String url = String.format(WechatCorp.DOWNLOAD_MEDIA, accessToken, mediaId);
		return HttpUtils.download(url);
	}

	@Override
	public MessageCorpResponse sendMessage(BaseCorpMessage message) {
		Asserts.notNull(message, "消息不能为空");
		String url = String.format(WechatCorp.SEND_MESSAGE, accessToken);
		String raw = JsonUtils.toJson(message);
		return HttpUtils.post(url, raw, MessageCorpResponse.class);
	}

	@Override
	public BaseResponse createMenu(int agentId, MenuMessage message) {
		Asserts.notNull(agentId, "企业应用的id不能为空");
		Asserts.notNull(message, "菜单不能为空");
		String url = String.format(WechatCorp.CREATE_MENU, accessToken, agentId);
		String raw = JsonUtils.toJson(message);
		return HttpUtils.post(url, raw, BaseResponse.class);
	}

	
	
	
	
	

}
