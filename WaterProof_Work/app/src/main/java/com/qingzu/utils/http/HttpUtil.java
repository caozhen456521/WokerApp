package com.qingzu.utils.http;

public class HttpUtil {
	// 接口基本地址

	public static final String BASE_HTTP = "http://api.5ifangshui.com/";

	// 三个共用的请求参数
	// "http://192.168.1.9/Service1.asmx/UserRegister"
	public static String TIME = "time";// 时间戳
	// token的生成方式=md5(time+key){time为当前url的unix时间戳，key由客户端和服务端共同约定，暂定为Qdi2015}
	public static String TOKEN = "token";
	public static String SESSIONID = "sessionid";// 登录可以传空，之后传登录返回的
	public static String KEY = "Qdi2015";
	public static String STATUS = "status";
	public static String WebLogonByToken = BASE_HTTP + "/help/WebLogonByToken";
	/**
	 * 按照手机号码检查是否帐号已经被注册
	 */
	public static String CheckByCellPhone = BASE_HTTP
			+ "api/User/CheckByCellPhone/{cellPhone}";

	/**
	 * 获取图形验证码 api/Common/Captcha
	 */
	public static String Captcha = BASE_HTTP + "api/Common/Captcha";

	/**
	 * 获取手机短信验证码,Status==true,表示发送成功 api/User/SMSCode
	 */
	public static String SMSCode = BASE_HTTP + "api/User/SMSCode";

	/**
	 * 注册 - 用户名/密码/短信验证码 api/User/Register/ByPwd
	 */
	public static String RegisterByPwd = BASE_HTTP + "api/User/Register/ByPwd";

	/**
	 * 登录 - 用户名/密码 api/User/Logon/ByPwd
	 */
	public static String Logon = BASE_HTTP + "api/User/Logon/ByPwd";

	/**
	 * 获取广告数据信息列表
	 */
	public static String GetAdvertisementListByPage = BASE_HTTP
			+ "api/Advertisement/ByPage/{Page}/{Size}";

	/**
	 * 登录用户刷新TOKEN
	 */
	public static String RefreshToken = BASE_HTTP + "api/User/RefreshToken";

	/**
	 * 获取七牛上传TOKEN
	 */
	public static String QiniuToken = BASE_HTTP + "api/Common/QiniuToken";

	/**
	 * 当前登录用户提交会员实名认证信息
	 */
	public static String CreateMemberAuthentication = BASE_HTTP
			+ "api/Authentication/CreateMemberAuthentication";

	/**
	 * 当前登录用户获取会员实名认证信息 GET
	 */
	public static String MyMemberAuthentication = BASE_HTTP
			+ "api/Authentication/MyMemberAuthentication";

	/**
	 * 当前登录用户获取自己的用户信息
	 */
	public static String UserInfo = BASE_HTTP + "api/User/UserInfo";

	/**
	 * 当前登录用户更新昵称
	 */
	public static String UpdateNickName = BASE_HTTP + "api/User/UpdateNickName";
	/**
	 * 当前登录用户更新联系人姓名
	 */
	public static String UpdateContactName = BASE_HTTP
			+ "api/User/UpdateContactName";
	/**
	 * 当前登录用户更新联系人电话
	 */
	public static String UpdateContactTel = BASE_HTTP
			+ "api/User/UpdateContactTel";
	/**
	 * 当前登录用户更新联系地址
	 */
	public static String UpdateContactAddress = BASE_HTTP
			+ "api/User/UpdateContactAddress";
	/**
	 * 当前登录用户更新头像
	 */
	public static String UpdatePortrait = BASE_HTTP + "api/User/UpdatePortrait";
	/**
	 * 当前登录用户更新生日
	 */
	public static String UpdateBirthday = BASE_HTTP + "api/User/UpdateBirthday";
	/**
	 * 当前登录用户更新所在地区（请提交[省-市-区县]名称）
	 */
	public static String UpdateRegionIDByNames = BASE_HTTP
			+ "api/User/UpdateRegionIDByNames";
	/**
	 * 根据RegionID获取上级区域(包括本级区域)
	 */
	public static String RegionListByLastID = BASE_HTTP
			+ "api/Region/RegionList/ByLastID/{RegionID}";

	/**
	 * APP主页商品集合信息
	 */
	public static String AppNewsList = BASE_HTTP + "api/News/AppNewsList";

	/**
	 * 获取当前登录用户的工程施工队信息
	 */
	public static String MyConstructionTeam = BASE_HTTP
			+ "api/Team/MyConstructionTeam";

	/**
	 * 当前登录用户创建工程施工队信息
	 */
	public static String CreateConstructionTeam = BASE_HTTP
			+ "api/Team/CreateConstructionTeam";

	/**
	 * 当前登录用户发布找天工信息
	 */
	public static String CreateRecruitmentInfo = BASE_HTTP
			+ "api/Recruitment/CreateRecruitmentInfo";

	/**
	 * 当前登录用户编辑找天工信息
	 */
	public static String UpdateRecruitmentInfo = BASE_HTTP
			+ "api/Recruitment/UpdateRecruitmentInfo";

	/**
	 * 当前登录用户发布找天工图片信息
	 */
	public static String CreateRecruitmentPhotoListInfo = BASE_HTTP
			+ "api/Recruitment/CreateRecruitmentPhotoListInfo";

	/**
	 * 根据ID获取找天工信息
	 */
	public static String RecruitmentInfoByID = BASE_HTTP
			+ "api/Recruitment/RecruitmentInfoByID/{ID}";

	/**
	 * 当前登录用户获取积分明细列表信息
	 */
	public static String Integral = BASE_HTTP
			+ "api/Integral/ListByPage/{Page}/{Size}";

	/**
	 * 登录用户 每日签到 提交
	 */
	public static String DailyIntegral = BASE_HTTP + "api/User/DailyIntegral";

	/**
	 * 判断登录用户 每日签到 是否已经完成.Status=true,可以签到，否则，当天已经签到过了。
	 */
	public static String CanAddDailyIntegral = BASE_HTTP
			+ "api/User/CanAddDailyIntegral";

	/**
	 * 当前登录用户获取找天工 数据信息列表
	 */
	public static String MyListByPage = BASE_HTTP
			+ "api/Recruitment/MyListByPage/{Page}/{Size}";

	/**
	 * 当前登录用户找天工信息结束招工
	 */
	public static String EndRecruitmentInfoById = BASE_HTTP
			+ "api/Recruitment/EndRecruitmentInfoById/{ID}";

	/**
	 * 设置推送标签
	 * 
	 */
	public static String PushTags = BASE_HTTP + "api/User/PushTags";
	// api/User/PushTags

	/**
	 * 当前登录用户编辑工程施工队信息
	 */
	public static String UpdateConstructionTeam = BASE_HTTP
			+ "api/Team/UpdateConstructionTeam";

	/**
	 * 获取当前登录用户的施工队队员列表信息
	 */
	public static String ListTeamMember = BASE_HTTP
			+ "api/TeamMember/ListTeamMember";

	/**
	 * 当前登录用户提交工长邀请工人入队记录信息
	 */
	public static String CreateInviteJoinTeam = BASE_HTTP
			+ "api/InviteJoin/CreateInviteJoinTeam";

	/**
	 * 提交防水工程项目信息 视图模型
	 */
	public static String CreateProjectInfo = BASE_HTTP
			+ "api/Project/CreateProjectInfo";

	/**
	 * 当前登录用户获取防水工程项目列表信息
	 */
	public static String ProjectMyList = BASE_HTTP
			+ "api/Project/MyListByPage/{Page}/{Size}";

	/**
	 * 获取防水工程项目信息
	 */
	public static String ProjectInfo = BASE_HTTP
			+ "api/Project/ProjectInfo/{ID}";

	/**
	 * 根据防水工程项目ID取消发布项目
	 */
	public static String UpdateProjectInfoState = BASE_HTTP
			+ "api/Project/UpdateProjectInfoState/{ID}";

	/**
	 * 当前登录用户施工队创建组名信息 POST
	 */
	public static String CreateGroups = BASE_HTTP + "api/Groups/CreateGroups";

	/**
	 * 根据分组编号ID删除施工队分组信息 DELETE
	 */
	public static String DeleteGroupsByID = BASE_HTTP
			+ "api/Groups/DeleteGroupsByID/{Id}";

	/**
	 * 当前登录用户（工长）辞退队员对象实体记录信息 POST
	 */
	public static String LeaveTeamRecordByLeader = BASE_HTTP
			+ "api/Album/LeaveTeamRecordByLeader";

	/**
	 * 当前登录用户编辑施工队队员信息 PUT
	 */
	public static String UpdateTeamMember = BASE_HTTP
			+ "api/Groups/UpdateTeamMember";

	/**
	 * 提交施工队服务城市列表信息 POST
	 */
	public static String CreateServeCityList = BASE_HTTP
			+ "api/ServeCity/CreateServeCityList";

	/**
	 * 根据施工队Id获取施工队服务城市信息列表 GET
	 */
	public static String ServeCityInfoByTeamId = BASE_HTTP
			+ "api/ServeCity/ServeCityInfoByTeamId/{TeamId}";

	/**
	 * 获取找天工数据信息列表(根据城市名称) GET
	 */
	public static String InfoListByCityName = BASE_HTTP
			+ "api/Recruitment/InfoListByCityName/{CityName}/{Page}/{Size}";

	/**
	 * 当前登录用户工人/工长获取承接天工订单列表信息 GET
	 */
	public static String WorkerListByPage = BASE_HTTP
			+ "api/Order/WorkerListByPage/{Page}/{Size}";

	/**
	 * 当前登录用户老板获取承接天工订单列表信息 GET
	 */
	public static String LeaderListByPage = BASE_HTTP
			+ "api/Order/LeaderListByPage/{Page}/{Size}";

	/**
	 * 当前登录用户工人/工长请求创建承接天工订单 POST
	 */
	public static String CreateInfoOrder = BASE_HTTP
			+ "api/Order/CreateInfoOrder";

	/**
	 * 当前登录用户工人/工长根据StateId获取承接天工订单列表信息 GET
	 */
	public static String WorkerListByStateId = BASE_HTTP
			+ "api/Order/WorkerListByStateId/{Page}/{Size}?StateId={StateId}";

	/**
	 * 当前登录用户老板根据StateId获取承接天工订单列表信息 GET
	 */
	public static String LeaderListByStateId = BASE_HTTP
			+ "api/Order/LeaderListByStateId/{Page}/{Size}?StateId={StateId}";

	/**
	 * 提醒老板信息推送 PUT
	 */
	public static String RemindBossById = BASE_HTTP
			+ "api/Order/RemindBossById/{ID}";

	/**
	 * 提交申请成为VIP付费会员记录
	 */
	public static String CreateVIPApply = BASE_HTTP
			+ "api/VIPApply/CreateVIPApply";

	/**
	 * 获取问题列表数据信息
	 */
	public static String QuestionsListByPage = BASE_HTTP
			+ "api/Questions/ListByPage/{Page}/{Size}";

	/**
	 * 根据ClassId获取问题列表数据信息
	 */
	public static String QuestionsListByClassId = BASE_HTTP
			+ "api/Questions/ListByClassId/{ClassId}/{Page}/{Size}";

	/**
	 * 获取所有分类列表
	 */
	public static String ClassIdList = BASE_HTTP
			+ "api/QuestionsClass/ClassIdList";

	/**
	 * 根据QuestionsId获取答案列表数据信息
	 */
	public static String AnswersListByQuestionsId = BASE_HTTP
			+ "api/Answers/ListByQuestionsId/{QuestionsId}/{Page}/{Size}";

	/**
	 * 当前登录用户对答案数据信息进行点赞
	 */
	public static String AnswersInfoByLikeCount = BASE_HTTP
			+ "api/Answers/AnswersLike/{ID}";

	/**
	 * 当前登录用户对答案数据信息取消点赞
	 */
	public static String AnswersInfoByCancelLikeCount = BASE_HTTP
			+ "api/Answers/AnswersCancelLike/{ID}";

	/**
	 * 根据关键字查询获取问题列表数据信息
	 */
	public static String QuestionsListByKeyWord = BASE_HTTP
			+ "api/Questions/ListByKeyWord/{KeyWord}/{Page}/{Size}";

	/**
	 * 当前登录用户提交评论信息
	 */
	public static String CreateComments = BASE_HTTP
			+ "api/Comments/CreateComments";

	/**
	 * 根据信息类型和信息ID获取评论列表
	 */
	public static String CommentsPageList = BASE_HTTP
			+ "api/Comments/ListByTypeIDInfoID/{TypeID}/{InfoID}/{Page}/{Size}";

	/**
	 * 当前登录用户提交问题答案信息
	 */
	public static String CreateAnswersInfo = BASE_HTTP
			+ "api/Answers/CreateAnswersInfo";

	/**
	 * 当前登录用户发布问题数据信息
	 */
	public static String CreateQuestionsInfo = BASE_HTTP
			+ "api/Questions/CreateQuestionsInfo";

	/**
	 * 当前登录用户提交意见反馈信息
	 */
	public static String CreateOpinionFeedback = BASE_HTTP
			+ "api/Opinion/CreateOpinionFeedback";

	/**
	 * 当前登录用户获取自己提交的反馈信息
	 */
	public static String OpinionFeedbackList = BASE_HTTP
			+ "api/Opinion/OpinionFeedbackList";
	/**
	 * 当前登录用户编辑承接天工订单 PUT
	 */
	public static String UpdateInfoOrder = BASE_HTTP
			+ "api/Order/UpdateInfoOrder";

	/**
	 * 当前登录用户创建派遣施工人员信息 POST
	 */
	public static String CreateDispatchMember = BASE_HTTP
			+ "api/Dispatch/CreateDispatchMember";

	/**
	 * 当前登录用户结束承接天工订单 PUT
	 */
	public static String EndInfoOrder = BASE_HTTP
			+ "api/Order/EndInfoOrder/{ID}";

	/**
	 * 当前登录用户(老板)开始天工订单 PUT
	 */
	public static String StartInfoOrder = BASE_HTTP
			+ "api/Order/StartInfoOrder/{ID}";

	/**
	 * 当前登录用户(老板)确认天工订单 PUT
	 */
	public static String PassInfoOrder = BASE_HTTP
			+ "api/Order/PassInfoOrder/{ID}";

	/**
	 * 当前登录用户根据ID删除承接天工订单信息 DELETE
	 */
	public static String DeleteInfoOrderByID = BASE_HTTP
			+ "api/Order/DeleteInfoOrderByID/{ID}";

	/**
	 * 根据ID获取订单信息 GET
	 */
	public static String OrderInfoByID = BASE_HTTP
			+ "api/Order/OrderInfoByID/{ID}";

	/**
	 * 根据ID获取工程施工队信息 GET
	 */
	public static String ConstructionTeamByID = BASE_HTTP
			+ "api/Team/ConstructionTeamByID/{ID}";

	/**
	 * 当前登录用户创建施工队被评价记录信息 POST
	 */
	public static String CreateConstructionTeamAppraise = BASE_HTTP
			+ "api/Appraise/CreateConstructionTeamAppraise";

	/**
	 * 当前登录用户评价老板信息 POST
	 */
	public static String CreateAppraiseInfo = BASE_HTTP
			+ "api/RecruitmentAppraise/CreateAppraiseInfo";

	/**
	 * 按照用户ID获取用户信息 GET
	 */
	public static String UserInfoByID = BASE_HTTP
			+ "api/User/UserInfoByID/{userID}";

	/**
	 * 当前登录用户老板评价工人工长评价信息 POST
	 */
	public static String WorkAppraiseCreateAppraiseInfo = BASE_HTTP
			+ "api/WorkAppraise/CreateAppraiseInfo";

	/**
	 * 当前登录用户根获取干活次数
	 */
	public static String MyFindWorkInfo = BASE_HTTP
			+ "api/FindWork/MyFindWorkInfo";

	/**
	 * 获取工程施工队列表信息
	 */
	public static String ConstructionTeamList = BASE_HTTP
			+ "api/Team/ConstructionTeamList/{Page}/{Size}";

	// Team/MyJoinTeamList
	/**
	 * 当前登录用户获取自己加入的施工队列表
	 */
	public static String MyJoinTeamList = BASE_HTTP + "api/Team/MyJoinTeamList";

	/**
	 * 
	 * 根据施工队ID获取施工队或个人工程案例、工程案例相册
	 */
	public static String ProjectCaseListByTeamId = BASE_HTTP
			+ "api/ProjectCase/ProjectCaseListByTeamId/{TeamId}/{Page}/{Size}";
	/**
	 * GET api/ProjectCase/ListProjectCaseByMemberId/{MemberId}/{Page}/{Size}
	 * 根据会员ID获取个人工程案例、工程案例相册
	 */

	public static String ListProjectCaseByMemberId = BASE_HTTP
			+ "api/ProjectCase/ListProjectCaseByMemberId/{MemberId}/{Page}/{Size}";
	/**
	 * APP主页商品外链集合信息
	 */
	public static String AppNewsUrl = BASE_HTTP + "api/News/AppNewsUrl";

	// api/FindWork/UpdateFindWorkInfo

	/**
	 * 当前登录用户根编辑工人工长详细信息
	 */
	public static String UpdateFindWorkInfo = BASE_HTTP
			+ "api/FindWork/UpdateFindWorkInfo";

	/**
	 * 当前登录用户获取施工队或个人工程案例信息
	 */
	public static String ProjectCase = BASE_HTTP
			+ "api/ProjectCase/ListByPage/{Page}/{Size}";
	// 当前登录用户获取施工队或个人工程案例、工程案例相册
	// GET api/ProjectCase/MyListProjectCase/{Page}/{Size}

	/**
	 * 当前登录用户获取施工队或个人工程案例、工程案例相册
	 */
	public static String MyListProjectCase = BASE_HTTP
			+ "api/ProjectCase/MyListProjectCase/{Page}/{Size}";

	/**
	 * 当前登录用户创建施工队/个人工程案例相册信息
	 */
	public static String CreateProjectCase = BASE_HTTP
			+ "api/Album/CreateProjectCase";

	/**
	 * 获取用户是否有新消息
	 */
	public static String NewMessage = BASE_HTTP
			+ "api/MemberMessage/HasNewMsg/{bizType}";

	/**
	 * 获取我的消息列表
	 */
	public static String MemberMessage = BASE_HTTP
			+ "api/MemberMessage/MyMsgList/{bizType}/{page}/{pageSize}";

	/**
	 * 用户删除单条消息
	 */
	public static String DeleteSingle = BASE_HTTP
			+ "api/MemberMessage/Delete/{msgID}";

	/**
	 * 根据问题ID获取问题详细信息
	 */
	public static String QuestionsInfoByID = BASE_HTTP
			+ "api/Questions/QuestionsInfoByID/{ID}";

	/**
	 * 用户更新单条消息的已读状态 - 根据消息ID更新状态
	 */
	public static String SetReaded = BASE_HTTP
			+ "api/MemberMessage/SetReaded/{msgID}";

	/**
	 * 用户通过短信验证码 重置密码并重新登录
	 */
	public static String UserResetPwdBySMSModel = BASE_HTTP
			+ "api/User/ResetPwd/BySMS";

	/**
	 * 根据数据Id获取招天工图片信息 GET
	 */
	public static String PhotoByInfoID = BASE_HTTP
			+ "api/Recruitment/PhotoByInfoID/{InfoID}";

	/**
	 * 当前登录用户获取施工材料列表信息
	 */
	public static String ConstructionMaterialList = BASE_HTTP
			+ "api/Common/ConstructionMaterialList";

	/**
	 * 当前登录用户施工队的申请加入施工队记录列表信息 GET
	 */
	public static String MyListJoin = BASE_HTTP
			+ "api/Join/MyListJoin/{Page}/{Size}";

	/**
	 * 当前登录用户工人工长通过组员的加入施工队申请 PUT
	 */
	public static String PassApplyJoinTeam = BASE_HTTP
			+ "api/Join/PassApplyJoinTeam/{MemberId}";

	/**
	 * 当前登录用户工人工长拒绝工人的加入施工队申请申请 PUT
	 */
	public static String NoPassApplyJoinTeam = BASE_HTTP
			+ "api/Join/NoPassApplyJoinTeam/{MemberId}";
	/**
	 * 提交工人申请加入施工队记录 视图模型
	 */
	public static String CreateApplyJoinTeam = BASE_HTTP
			+ "api/Join/CreateApplyJoinTeam";

	/**
	 * 当前登录用户获取发布问题列表数据信息
	 */
	public static String MyQuestionsListByPage = BASE_HTTP
			+ "api/Questions/MyListByPage/{Page}/{Size}";

	/**
	 * 当前登录用户设置最佳答案信息 PUT
	 */
	public static String AnswersSetInfo = BASE_HTTP
			+ "api/Answers/AnswersSetInfo";

	/**
	 * 搜索问题列表 GET
	 */
	public static String QuestionsSearch = BASE_HTTP
			+ "api/Questions/Search?Keyword={Keyword}&ClassID={ClassID}&SortType={SortType}&Page={Page}&Size={Size}";

	/**
	 * 当前登录用户编辑招天工图片列表信息 post
	 */
	public static String UpdateRecruitmentPhotoListInfo = BASE_HTTP
			+ "api/Recruitment/UpdateRecruitmentPhotoListInfo";

	/**
	 * 根据MemberID获取BossInfo数据信息 get
	 */
	public static String BossInfoByMemberID = BASE_HTTP
			+ "api/BossInfo/BossInfoByMemberID/{MemberID}";

	/**
	 * 根据订单ID获取派遣施工人员信息 GET
	 */
	public static String DispatchMemberByInfoOrderId = BASE_HTTP
			+ "api/Dispatch/DispatchMemberByInfoOrderId/{InfoOrderId}";

	/**
	 * 当前登陆用户更新角色信息 PUT
	 */
	public static String UpdateUserRole = BASE_HTTP + "api/User/UpdateUserRole";

	/**
	 * 商城订单外链集合 GET
	 */
	public static String MallOrderUrl = BASE_HTTP + "api/Order/MallOrderUrl";

	/**
	 * 当前登录用户获取施工部位列表信息
	 */
	public static String ConstructionPositionList = BASE_HTTP
			+ "api/Common/ConstructionPositionList";

	/**
	 * 当前登录用户工长确认工程订单 PUT
	 */
	public static String PassProjectPushRecord = BASE_HTTP
			+ "api/PushRecord/PassProjectPushRecord/{ProjectId}";

	/**
	 * 当前登录用户工长拒绝工程订单 PUT
	 */
	public static String NoPassProjectPushRecord = BASE_HTTP
			+ "api/PushRecord/NoPassProjectPushRecord/{ProjectId}";

	/**
	 * 当前登录用户获取推送给施工队记录列表信息 get
	 */
	public static String ProPushListByPage = BASE_HTTP
			+ "api/PushRecord/MyListByPage/{Page}/{Size}";
	/**
	 * 根据ID获取工程信息推送给施工队记录信息 get
	 */
	public static String PushRecordInfo = BASE_HTTP
			+ "api/PushRecord/PushRecordInfo/{ID}";

	/**
	 * 当前登录用户根据ID删除施工队/个人工程案例信息 DELETE
	 */
	public static String DeleteCase = BASE_HTTP + "api/ProjectCase/{ID}";

	/**
	 * 根据InfoId和InfoType获取分机号信息
	 */
	public static String ExtensionNumberByInfoIdandInfoType = BASE_HTTP
			+ "api/ExtensionBindRecord/ExtensionBindRecordByInfoIdandInfoType/{InfoId}/{InfoType}";

	/**
	 * 当前登录用户获取vip服务项列表信息 GET
	 */
	public static String VIPServiceItemList = BASE_HTTP
			+ "api/VIPServiceItem/VIPServiceItemList";

	/**
	 * 创建付费会员VIP会员服务项需求信息 POST
	 */
	public static String CreateVIPDemandInfo = BASE_HTTP
			+ "api/VIPDemandInfo/CreateVIPDemandInfo";

	/**
	 * 当前登录用户（工人）离开施工队对象实体记录信息
	 */
	public static String LeaveTeamRecordByWorker = BASE_HTTP
			+ "api/Album/LeaveTeamRecordByWorker";
	/**
	 * 当前登录用户(工人)获取受邀请入队记录列表信息 get
	 */
	public static String BeInviteJoinList = BASE_HTTP
			+ "api/InviteJoin/BeInviteJoinList/{Page}/{Size}";

	/**
	 * 当前登录用户(工人)接受施工队入队邀请put
	 */
	public static String PassInviteJoinById = BASE_HTTP
			+ "api/InviteJoin/PassInviteJoinById/{Id}";

	/**
	 * 当前登录用户(工人)拒绝施工队入队邀请put
	 */
	public static String NoPassInviteJoinById = BASE_HTTP
			+ "api/InviteJoin/NoPassInviteJoinById/{Id}";

	/**
	 * 获取同城工人工长数据信息列表get
	 */
	public static String FindWorkByPage = BASE_HTTP
			+ "api/FindWork/ByPage/{CityName}/{Page}/{Size}";

	/**
	 * 当前登录用户根据会员ID提交邀请工人入队记录信息post
	 */
	public static String CreateInviteJoinTeamByMemberID = BASE_HTTP
			+ "api/InviteJoin/CreateInviteJoinTeamByMemberID";

	/**
	 * 
	 * 当前登录用户(工长)获取邀请工人入队记录列表信息(分页)get
	 */
	public static String InviteJoinListByPage = BASE_HTTP
			+ "api/InviteJoin/ListByPage/{Page}/{Size}";

	/**
	 * 
	 * 当前登录用户根据ID删除工长邀请入施工队记录 delete
	 */
	public static String DeleteInviteJoinTeamRecordByID = BASE_HTTP
			+ "api/InviteJoin/DeleteInviteJoinTeamRecordByID/{ID}";

	/**
	 * 
	 * 登录 - 用户名/短信验证码 post
	 */

	public static String LogonBySMS = BASE_HTTP + "api/User/Logon/BySMS";

	/**
	 * 微信 根据订单编码获取订单内商品详细信息 GET
	 */
	public static String MallOrderFormByOrderCode = BASE_HTTP
			+ "api/MallOrder/MallOrderFormByOrderCode/{OrderCode}";

	/**
	 * 支付宝 根据订单编码获取订单内商品详细信息 GET
	 */
	public static String MallALipayOrderStringByOrderCode = BASE_HTTP
			+ "api/Pay/MallALipayOrderStringByOrderCode/{OrderCode}";

	/**
	 * 
	 * 按类别获取通知 get
	 */
	public static String Information = BASE_HTTP
			+ "api/Common/InformationByPage/{TypeId}/{State}/{Page}/{Size}";

	/**
	 * 
	 * 获取同城推荐工人数据信息列表 get
	 */
	public static String FindWorkByNum = BASE_HTTP
			+ "api/FindWork/ByNum/{CityName}/{Num}/{Start}";

	/**
	 * 获取同城推荐工人数据信息列表（分页）
	 */

	public static String FindWork = BASE_HTTP
			+ "api/FindWork/ByCityName/{Id}/{CityName}/{Page}/{Size}";

	/**
	 * 
	 * 当前登录用户获取找天工 接单人数据信息列表 get
	 */
	public static String RecruitmentMember = BASE_HTTP
			+ "api/Recruitment/RecruitmentForMemberListByID/{Id}/{Page}/{Size}";

	/**
	 * 
	 * 根据会员ID获取工人工长详细信息 get
	 */
	public static String WorkerDetail = BASE_HTTP
			+ "api/FindWork/FindWorkInfoByMemberId/{MemberId}";

	/**
	 * 
	 * 当前登录用户老板请求创建承接天工订单 post
	 */
	public static String CreateInfoOrderByLeader = BASE_HTTP
			+ "api/Order/CreateInfoOrderByLeader";

	/**
	 * 
	 * 根据所在城市获取工程施工队列表信息
	 */
	public static String ConstructionTeamListByCityName = BASE_HTTP
			+ "api/Team/ConstructionTeamListByCityName/{CityName}/{Page}/{Size}";

	/**
	 * 微信 统一下单
	 */
	public static String payUnifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 当前登录用户修改找活数据[工作状态]为空闲或者忙碌
	 */
	public static String UpdateFindWorkState = BASE_HTTP
			+ "api/FindWork/UpdateFindWorkState/{State}";
	/**
	 * GET 获取用户消息中心数据
	 */
	public static String GetMyMemberMsg = BASE_HTTP
			+ "api/MemberMessage/GetMyMemberMsg/{topMsgCount}";

	/**
	 * GET 当前登录用户老板获取订单列表数量信息
	 */
	public static String LeaderOrderCount = BASE_HTTP
			+ "api/Order/LeaderOrderCount";

	/**
	 * GET 当前登录用户工人/工长获取订单列表数量信息
	 */
	public static String WorkerOrderCount = BASE_HTTP
			+ "api/Order/WorkerOrderCount";

	public static String mywallet = "http://m.5ifangshui.com/dashboard/integrallog/mywallet";
	public static String create = "http://m.5ifangshui.com/dashboard/dulou/create";

}
