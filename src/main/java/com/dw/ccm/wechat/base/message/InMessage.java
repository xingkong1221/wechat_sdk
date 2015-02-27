package com.dw.ccm.wechat.base.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信服务器推送的消息对象（包括所有字段）
 * 
 * @author xingkong1221
 * @date 2014年5月9日
 */
public class InMessage {

	/**
	 * 开发者微信号
	 */
	@XStreamAlias("ToUserName")
	private String toUserName;
	
	/**
	 * 发送方帐号（一个OpenID）
	 */
	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	/**
	 * 消息创建时间 （整型）
	 */
	@XStreamAlias("CreateTime")
	private Long createTime;
	
	/**
	 * 消息类型
	 */
	@XStreamAlias("MsgType")
	private String msgType;
	
	/**
	 * 文本消息内容
	 */
	@XStreamAlias("Content")
	private String content;
	
	/**
	 * 图片链接
	 */
	@XStreamAlias("PicUrl")
	private String picUrl;
	
	/**
	 * 图片消息媒体 {@code id}，可以调用多媒体文件下载接口拉取数据。
	 */
	@XStreamAlias("MediaId")
	private String mediaId;
	
	/**
	 * 语音格式，如 {@code amr}，{@code speex} 等
	 */
	@XStreamAlias("Format")
	private String format;
	
	/**
	 * 视频消息缩略图的媒体 {@code id}，可以调用多媒体文件下载接口拉取数据
	 */
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;
	
	/**
	 * 地理位置维度
	 */
	@XStreamAlias("Location_X")
	private Double locationX;
	
	/**
	 * 地理位置经度
	 */
	@XStreamAlias("Location_Y")
	private Double locationY;
	
	/**
	 * 地图缩放大小
	 */
	@XStreamAlias("Scale")
	private Integer scale;
	
	/**
	 * 地理位置信息
	 */
	@XStreamAlias("Label")
	private String label;
	
	/**
	 * 消息标题
	 */
	@XStreamAlias("Title")
	private String title;

	/**
	 * 消息描述
	 */
	@XStreamAlias("Description")
	private String description;
	
	/**
	 * 消息链接
	 */
	@XStreamAlias("Url")
	private String url;
	
	/**
	 * 消息 {@code id}，64位整型
	 */
	@XStreamAlias("MsgId")
	private Long msgId;

	/**
	 * 消息 {@code id} (专用模板消息编号)
	 */
	@XStreamAlias("MsgID")
	private Long msgID;
	
	/**
	 * 事件类型
	 */
	@XStreamAlias("Event")
	private String event;
	
	/**
	 * 事件KEY值
	 */
	@XStreamAlias("EventKey")
	private String eventKey;
	
	/**
	 * 二维码的 {@code ticket}，可用来换取二维码图片
	 */
	@XStreamAlias("Ticket")
	private String ticket;
	
	/**
	 * 地理位置纬度
	 */
	@XStreamAlias("Latitude")
	private Double latitude;
	
	/**
	 * 地理位置经度
	 */
	@XStreamAlias("Longitude")
	private Double longitude;
	
	/**
	 * 地理位置精度
	 */
	@XStreamAlias("precision")
	private Double Precision;
	
	/**
	 * 语音识别结果，{@code UTF-8} 编码
	 */
	@XStreamAlias("Recognition")
	private String recognition;
	
	/**
	 * 群发消息返回的结果:<ul>
	 * <li><code>send success</code>
	 * <li><code>send fail</code>
	 * <li><code>err(num)</code></ul>
	 * <p>但{@code send success} 时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败。
	 * <p>{@code err(num)} 是审核失败的具体原因，可能的情况如下：<ul>
	 * <li>err(10001)	//涉嫌广告
	 * <li>err(20001)	//涉嫌政治
	 * <li>err(20004)	//涉嫌社会
	 * <li>err(20002)	//涉嫌色情
	 * <li>err(20006)	//涉嫌违法犯罪
	 * <li>err(20008)	//涉嫌欺诈
	 * <li>err(20013)	//涉嫌版权
	 * <li>err(22000)	//涉嫌互推(互相宣传)
	 * <li>err(21000)	//涉嫌其他</ul>
	 */
	@XStreamAlias("Status")
	private String status;
	
	/**
	 * <code>group_id</code> 下粉丝数；或者 <code>openid_list</code> 中的粉丝数
	 */
	@XStreamAlias("TotalCount")
	private Long totalCount;
	
	/**
	 * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上<br>
	 * <pre><code>FilterCount = SentCount + ErrorCount</code></pre>
	 */
	@XStreamAlias("FilterCount")
	private Long filterCount;
	
	/**
	 * 发送成功的粉丝数
	 */
	@XStreamAlias("SentCount")
	private Long sentCount;
	
	/**
	 * 发送失败的粉丝数
	 */
	@XStreamAlias("ErrorCount")
	private Long errorCount;

    /*应用编号*/
    @XStreamAlias("AgentID")
    private String agentId;

    /**
     * 获取缓存键值
     * @return 缓存键值
     */
    public String cacheKey() {
        return msgType.equals("event") ? getFromUserName() + getCreateTime() : getMsgId().toString() ;
    }

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public Double getLocationX() {
		return locationX;
	}

	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}

	public Double getLocationY() {
		return locationY;
	}

	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getPrecision() {
		return Precision;
	}

	public void setPrecision(Double precision) {
		Precision = precision;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getFilterCount() {
		return filterCount;
	}

	public void setFilterCount(Long filterCount) {
		this.filterCount = filterCount;
	}

	public Long getSentCount() {
		return sentCount;
	}

	public void setSentCount(Long sentCount) {
		this.sentCount = sentCount;
	}

	public Long getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Long errorCount) {
		this.errorCount = errorCount;
	}

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

	public Long getMsgID() {
		return msgID;
	}

	public void setMsgID(Long msgID) {
		this.msgID = msgID;
	}
}
