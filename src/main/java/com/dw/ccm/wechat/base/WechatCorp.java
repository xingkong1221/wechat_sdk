package com.dw.ccm.wechat.base;

import java.util.List;

import com.dw.ccm.wechat.base.message.menu.MenuMessage;
import com.dw.ccm.wechat.base.message.qy.BaseCorpMessage;
import com.dw.ccm.wechat.base.message.qy.UserMessage;
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

/**
 * 微信企业号接口
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public interface WechatCorp {

	/** 获取AccessToken */
	public static final String ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%S&corpsecret=%S";
	
	/** 创建部门 */
	public static final String CREATE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%s";
	
	/** 更新部门 */
	public static final String UPDATE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=%s";
	
	/** 删除部门 */
	public static final String DELETE_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%s&id=%s";
	
	/** 获取部门列表 */
	public static final String LIST_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s";
	
	/** 创建成员 */
	public static final String CREATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%s";
	
	/** 更新成员 */
	public static final String UPDATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=%s";
	
	/** 删除成员 */
	public static final String DELETE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%s";
	
	/** 获取成员 */
	public static final String GET_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=%s&userid=%s";
	
	/** 获取部门成员 */
	public static final String LIST_USER= "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=%s&department_id=%s&fetch_child=%s&status=%s";
	
	/** 创建标签 */
	public static final String CREATE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=%s";
	
	/** 更新标签名字 */
	public static final String UPDATE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=%s";
	
	/** 删除标签 */
	public static final String DELETE_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=%s&tagid=%s";
	
	/** 获取标签成员 */
	public static final String GET_TAG = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=%s&tagid=%s";
	
	/** 增加标签成员 */
	public static final String ADD_TAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=%s";
	
	/** 删除标签成员 */
	public static final String DELETE_TAGUSERS = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=%s";
	
	/** 上传媒体文件 */
	public static final String UPLOAD_MEDIA = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";
	
	/** 获取媒体文件 */
	public static final String DOWNLOAD_MEDIA = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	
	/** 发送消息 */
	public static final String SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
	
	/** 创建应用菜单 */
	public static final String CREATE_MENU = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=%s&agentid=%s";
	
	/**
	 * 获取AccessToken
	 * @param corpId 企业Id
	 * @param corpSecret 管理组的凭证密钥
	 * @return 获取到的AccessTokenCorpResponse对象
	 */
	public AccessTokenCorpResponse getAccessToken(String corpId, String corpSecret);
	
	/**
	 * 创建部门
	 * @param name 部门名称。长度限制为1~64个字符
	 * @param parentId 父亲部门id。根部门id为1
	 * @param order 在父部门中的次序。从1开始，数字越大排序越靠后
	 * @return 返回包含新创建部门的编号信息
	 */
	public DepartCreateResponse createDepartment(String name, String parentId, String order);
	
	/**
	 * 更新部门
	 * @param id 部门id
	 * @param name 更新的部门名称。长度限制为0~64个字符。修改部门名称时指定该参数
	 * @param parentId 父亲部门id。根部门id为1
	 * @param order 在父部门中的次序。从1开始，数字越大排序越靠后
	 * @return 更新结果
	 */
	public DepartUpdateResponse updateDepartment(int id, String name, String parentId, String order);
	
	/**
	 * 删除部门
	 * @param id 部门id（注：不能删除根部门；不能删除含有子部门、成员的部门）
	 * @return 删除结果
	 */
	public DepartDeleteResponse deleteDepartment(int id);
	
	/**
	 * 获取部门列表
	 * @return 部门列表
	 */
	public DepartListResponse listDepartment();
	
	/**
	 * 创建成员
	 * @param userMessage 用户资料
	 * @return 创建成员结果
	 */
	public BaseResponse createUser(UserMessage userMessage);
	
	/**
	 * 更新成员
	 * @param userMessage 用户资料
	 * @return 更新结果
	 */
	public BaseResponse updateUser(UserMessage userMessage);
	
	/**
	 * 删除成员
	 * @param userId 员工UserID
	 * @return 删除结果
	 */
	public BaseResponse deleteUser(String userId);
	
	/**
	 * 获取成员
	 * @param userId 员工UserID
	 * @return 成员信息
	 */
	public UserGetResponse getUser(String userId);
	
	/**
	 * 获取部门成员
	 * @param departmentId 获取的部门id
	 * @param fetchChild 1/0：是否递归获取子部门下面的成员
	 * @param status 0获取全部员工，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加
	 * @return 部门成员列表信息
	 */
	public UserListResponse listUser(int departmentId, int fetchChild, int status);
	
	/**
	 * 创建标签
	 * @param tagName 标签名称
	 * @return 标签id信息
	 */
	public TagCreateResponse createTag(String tagName);
	
	/**
	 * 更新标签名字
	 * @param tagId 标签ID
	 * @param tagName 标签名称。最长64个字符
	 * @return 标签名称更新结果
	 */
	public BaseResponse updateTag(int tagId, String tagName);
	
	/**
	 * 删除标签
	 * @param tagId 标签ID
	 * @return 删除标签结果
	 */
	public BaseResponse deleteTag(int tagId);
	
	/**
	 * 获取标签成员
	 * @param tagId 标签ID
	 * @return 标签成员结果
	 */
	public TagGetResponse getTag(int tagId);
	
	/**
	 * 增加标签成员
	 * @param tagId 标签ID
	 * @param userIdList 企业员工ID列表
	 * @return 增加标签成员结果 
	 */
	public TagUsersAddResponse addTagUsers(int tagId, List<String> userIdList);
	
	/**
	 * 删除标签成员
	 * @param tagId 标签ID
	 * @param userIdList 企业员工ID列表
	 * @return 删除标签成员结果
	 */
	public TagUsersDeleteResponse deleteTagUsers(int tagId, List<String> userIdList);
	
	/**
	 * 上传多媒体文件
	 * @param data 媒体文件数据
	 * @param filename 媒体文件名称
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @return 成功返回 {@code UploadResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public UploadResponse upload(byte[] data, String filename, String type);
	
	/**
	 * 下载多媒体文件
	 * @param mediaId 媒体文件的 {@code id}
	 * @return 成功返回 {@code DownloadResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public DownloadResponse download(String mediaId);
	
	/**
	 * 发送企业消息
	 * @param message 消息对象
	 * @return 发送结果
	 */
	public MessageCorpResponse sendMessage(BaseCorpMessage message);
	
	/**
	 * 创建应用菜单
	 * @param agentId 企业应用的id
	 * @param message 菜单
	 * @return 创建结果
	 */
	public BaseResponse createMenu(int agentId, MenuMessage message);
}
