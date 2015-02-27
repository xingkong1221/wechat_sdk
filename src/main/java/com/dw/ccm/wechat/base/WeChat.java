package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.BaseMessage;
import com.dw.ccm.wechat.base.message.NewsMessage;
import com.dw.ccm.wechat.base.message.VideoMessage;
import com.dw.ccm.wechat.base.message.mass.BaseMassMessage;
import com.dw.ccm.wechat.base.message.response.*;
import com.dw.ccm.wechat.base.message.response.mass.MassResponse;
import com.dw.ccm.wechat.base.message.response.mass.NewsResponse;
import com.dw.ccm.wechat.base.message.response.mass.VideoResponse;
import com.dw.ccm.wechat.base.message.response.template.TemplateResponse;
import com.dw.ccm.wechat.base.message.template.TemplateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信公众平台基础接口
 * 
 * @author xingkong1221
 * @date 2014年5月20日
 * @version 1.0
 */
public interface WeChat {
	
	/**
	 * 微信用户基本信息国家地区语言版本
	 */
	public static List<String> Lang = new ArrayList<String>(Arrays.asList("zh_CN", "zh_TW", "en"));
	
	/**
	 * 上传媒体文件的类型
	 */
	public static List<String> UploadMediaType = new ArrayList<String>(Arrays.asList("image", "voice", "video", "thumb"));
	
	/**
	 * 上传媒体文件的类型企业版
	 */
	public static List<String> UploadMediaTypeCorp = new ArrayList<String>(Arrays.asList("image", "voice", "video", "file"));
	
	/**
	 * 获取access token接口URL
	 */
	public static String TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";
	
	/**
	 * 上传多媒体文件接口URL
	 */
	public static String UPLOAD_MEDIA = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

	/**
	 * 下载多媒体文件接口URL
	 */
	public static String GET_MEDIA = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	
	/**
	 * 发送客服消息接口URL
	 */
	public static String CUSTOM_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";
	
	/**
	 * 创建分组接口URL
	 */
	public static String GROUPS_CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=%S";
	
	/**
	 * 查询所有分组接口URL
	 */
	public static String GET_GROUPS = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=%S";
	
	/**
	 * 查询用户所在分组接口URL
	 */
	public static String GET_GROUP_ID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=%s";
	
	/**
	 * 修改分组名称接口URL
	 */
	public static String UPDATE_GROUP_NAME = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=%s";
	
	/**
	 * 移动用户分组接口URL
	 */
	public static String UPDATE_GROUP_MEMBER = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=%S";
	
	/**
	 * 获取用户基本信息接口URL
	 */
	public static String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";
	
	/**
	 * 获取关注者列表接口URL
	 */
	public static String GET_FOLLOWERS = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";
	
	/**
	 * 创建二维码ticket接口URL
	 */
	public static String CREATE_TICKET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";
	
	/**
	 * 通过ticket换取二维码接口URL
	 */
	public static String GET_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";
	
	/**
	 * 自定义菜单创建接口URL
	 */
	public static String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	
	/**
	 * 自定义菜单查询接口URL
	 */
	public static String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
	
	/**
	 * 自定义菜单删除接口
	 */
	public static String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";
	
	/**
	 * 上传图文消息素材接口URL
	 */
	public static String UPLOAD_NEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=%s";
	
	/**
	 * 根据分组进行群发接口URL
	 */
	public static String SEND_ALL_BY_GROUP = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=%s";
	
	/**
	 * 根据OpenID列表群发接口URL
	 */
	public static String SEND_ALL_BY_OPENID = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=%s";
	
	/**
	 * 上传视频文件接口URL（用户视频消息群发接口）
	 */
	public static String UPLOAD_VIDEO = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=%s";
	
	/**
	 * 设置用户备注名接口
	 */
	public static String UPDATE_REMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s";
	
	/**
	 * 发送模板消息接口
	 */
	public static String SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";
	
	/**
	 * 根据微信公众号的 {@code app_id} 和 {@code app_secret} 获取  {@code access_token}.<br>
	 * {@code access_token} 是公众号的全局唯一票据，公众号调用各接口时都需使用 {@code access_token}
	 * <p>注：该方法为静态方法，无需实例，可直接调用</p>
	 * @param appId 第三方用户唯一凭证
	 * @param appSecret 第三方用户唯一凭证密钥，即appSecret
	 * @return 成功返回 {@code AccessTokenResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public AccessTokenResponse getAccessToken(String appId, String appSecret);
	
	/**
	 * 下载多媒体文件
	 * @param mediaId 媒体文件的 {@code id}
	 * @return 成功返回 {@code DownloadResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public DownloadResponse download(String mediaId);
	
	/**
	 * 上传多媒体文件
	 * @param data 媒体文件数据
	 * @param filename 媒体文件名称
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @return 成功返回 {@code UploadResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public UploadResponse upload(byte[] data, String filename, String type);
	
	/**
	 * 发送客服消息，主要有以下几种消息：<br><ul>
	 * <li>文本消息 <code>TextMessage</code>
	 * <li>图片消息 <code>ImageMessage</code>
	 * <li>语音消息 <code>VoiceMessage</code>
	 * <li>视频消息 <code>VideoMessage</code>
	 * <li>音乐消息 <code>MusicMessage</code>
	 * <li>图文消息 <code>NewsMessage</code></ul>
	 * @param message 客服消息，如 <code>TextMessage</code>, <code>VideoMessage</code> 等
	 * @return 成功返回 <code>CustomResponse</code> 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public CustomResponse sendCustomMessage(BaseMessage message);
	
	/**
	 * 上传图文消息素材
	 * @param message 图文消息对象
	 * @return 成功返回 <code>NewsResponse</code> 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public NewsResponse uploadNews(NewsMessage message);
	
	/**
	 * 上传视频消息素材, 获取支持群发视频消息的 <code>media_id</code>
	 * @param message 视频消息对象
	 * @return 成功返回 <code>VideoResponse</code> 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中
	 */
	public VideoResponse uploadVideo(VideoMessage message);
	
	/**
	 * 根据分组群发消息
	 * @param message 群发消息对象
	 * @return 返回一个 <code>MassResponse</code> 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中
	 */
	public MassResponse sendMassMessageByGroup(BaseMassMessage message);
	
	/**
	 * 根据 <code>OpenId</code> 群发消息
	 * @param message 群发消息对象
	 * @return 返回一个 <code>MassResponse</code> 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中
	 */
	public MassResponse sendMassMessageByOpenId(BaseMassMessage message);
	
	/**
	 * 为微信公众帐号创建一个分组
	 * @param name 分组名称
	 * @return 返回 <code>GroupResponse</code> 对象，若分组创建产生错误，错误信息也会包含在该对象中
	 */
	public GroupResponse createGroup(String name);
	
	/**
	 * 查询微信公众帐号所有的分组
	 * @return 返回 <code>GroupResponse</code> 对象，若查询分组过程中产生错误，错误信息也会包含在该对象中
	 */
	public GroupResponse getGroups();
	
	/**
	 * 查询用户所在分组
	 * @param openId 用户的 {@code open_id}
	 * @return 返回 <code>GroupResponse</code> 对象，若查询用户所在分组过程中产生错误，错误信息也会包含在该对象中
	 */
	public GroupResponse getGroupId(String openId);
	
	/**
	 * 修改分组名称
	 * @param id 分组id，由微信分配
	 * @param name 分组名字（30个字符以内）
	 * @return 返回 <code>GroupResponse</code> 对象，若在修改分组名称的过程中产生错误，错误信息也会包含在该对象中
	 */
	public GroupResponse updateGroupName(Long id, String name);
	
	/**
	 * 移动用户分组
	 * @param openId 用户唯一标识符(用户 {@code open_id})
	 * @param id 分组id
	 * @return 返回 <code>GroupResponse</code> 对象，若在移动用户分组过程中产生错误，错误信息也会包含在该对象中
	 */
	public GroupResponse updateGroupMember(String openId, Long id);
	
	/**
	 * 获取微信公众号关注用户的基本信息
	 * @param openId 普通用户的标识，对当前公众号唯一
	 * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return 返回一个 <code>UserInfoResponse</code> 对象，若在获取用户基本信息的过程中产生错误，错误信息也会包含在该对象中
	 */
	public UserInfoResponse getUserInfo(String openId, String lang);
	
	/**
	 * 获取关注者列表
	 * @param nextOpenId 第一个拉取的 {@code open_id}，不填默认从头开始拉取
	 * @return 返回一个 <code>FollowersResponse</code> 对象，若在获取关注者列表的过程中产生错误，错误信息也会包含在该对象中
	 */
	public FollowersResponse getFollowers(String nextOpenId);
	
	/**
	 * 为微信公众帐号创建自定义菜单
	 * @param raw <code>JSON</code> 格式的菜单数据
	 * @return 返回一个 <code>MenuResponse</code> 对象，若在菜单创建的过程中产生错误，错误信息也会包含在该对象中
	 */
	public MenuResponse createMenu(String raw);
	
	/**
	 * 查询微信公众号的自定义菜单
	 * @return 返回一个 <code>MenuResponse</code> 对象，若在查询自定义菜单的过程中产生错误，错误信息也会包含在该对象中
	 */
	public MenuResponse getMenu();
	
	/**
	 * 删除微信公众号的自定义菜单
	 * @return 返回一个 <code>MenuResponse</code> 对象，若在删除自定义菜单的过程中产生错误，错误信息也会包含在该对象中
	 */
	public MenuResponse deleteMenu();
	
	/**
	 * 创建二维码 {@code ticket} 
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param expireSeconds 该二维码有效时间，以秒为单位，最大不超过1800，为 {@code null} 则创建永久二维码
	 * @return 返回一个 <code>TicketResponse</code> 对象，若在创建二维码 {@code ticket} 的过程中产生错误，错误信息也会包含在该对象中
	 */
	public TicketResponse createTicket(Integer sceneId, Integer expireSeconds);
	
	/**
	 * 通过 {@code ticket} 换取二维码地址
	 * @param ticket 二维码 {@code ticket} 
	 * @return 二维码图片地址
	 */
	public String getQrCode(String ticket);
	
	/**
	 * 更新用户备注名
	 * 
	 * @param openId 用户唯一标志
	 * @param remark 备注名
	 * @return 接口调用结果
	 */
	public BaseResponse updateRemark(String openId, String remark);
	
	/**
	 * 发送模板消息
	 * @param message 模板消息
	 * @return 发送结果
	 */
	public TemplateResponse sendTemplate(TemplateMessage message);

	/**
	 * 设置接口调用凭证
	 *
	 * @param accessToken 接口调用凭证
	 */
	public void setAccessToken(String accessToken);
}
