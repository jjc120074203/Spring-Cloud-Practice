package org.spring.cloud.common.constant;

import org.spring.cloud.common.exception.CIBaseException;

/**
 * Created by xiaoman on 17-3-3.
 * 异常常量定义类
 * 具体格式：字符串“0x”+模块码（3位16进制数）+错误码（3位16进制数），例如0x001001
 * 为了便于扩展，每增加一个错误常量数字加3
 */
public class ExceptionConstants {

    /**
     * 获取下一个递增的模块编码或者3位字符串的错误码
     * @param hexCurModuleCode [0x1-0xffd]
     * @param increase
     * @return
     */
    public static String retriveCodeStr(int hexCurModuleCode,int increase){
        String mcode = "";
        if(hexCurModuleCode>=0xFFD || hexCurModuleCode<= 0) {
            throw new CIBaseException("The code is out of range [0x001-0xFFD] ");
        }
        int nextcode = hexCurModuleCode +increase;
        try {
            mcode = Integer.toHexString(nextcode);
            int nlen = mcode.length();
            for(int i=0;i<(3-nlen);i++){
                mcode ="0"+mcode;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            mcode = "";
        }
        return mcode;
    }

    /**
     * 获取当前模块的下一个错误码
     * @param modulecode  0x001
     * @param subErrcode  0x01d
     * @return
     */
    public static String getNextErrCode(int modulecode,int subErrcode){
        String nextCode ="err";
        nextCode = retriveCodeStr(modulecode,0) + retriveCodeStr(subErrcode,3);
        return nextCode;
    }
    //##############################################
    //开发者门户Open Service	csvr  cable-services		0x001
    public final static String CSVR_DEMO_EXCEPTION = "0x001001=输入参数格式错误";
    public final static String CSVR_PARAMS_IS_EMPTY = "0x001009=输入参数为空";
    public final static String CSVR_SAVE_APPORDER_EXCEPTION= "0x001010=保存申请记录单失败"; 
    public final static String CSVR_UPDATE_APPORDER_EXCEPTION= "0x001011=更新申请记录单失败"; 
    public final static String CSVR_APPLCATION_INFO_EXCEPTION= "0x001040=服务信息异常"; 
    public final static String CSVR_APPLCATION_INFO_STATUS_EXCEPTION= "0x001041=服务信息状态不满足申请下架条件"; 
    public final static String CSVR_SAVE_ORDERLOG_EXCEPTION= "0x001042=保存信息申请单信息错误";
    public final static String CSVR_UPDATE_APPLICATION_EXCEPTION= "0x001043=服务状态更新错误";
    public final static String CSVR_IAM_REQISTRY_EXCEPTION = "0x001003=iam 注册失败，原因： ";
    public final static String CSVR_NOT_FIND_USERNAME_EXCEPTION = "0x001004=用户名不能为空";
    public final static String CSVR_PICTURE_VILD_ERROR_EXCEPTION = "0x001007=验证码输入有误！";
    public final static String CSVR_NOT_FIND_PWD_EXCEPTION = "0x00100A=密码不能为空";
    public final static String CSVR_NOT_FIND_ACCOUNTTYPE_EXCEPTION = "0x00100D=账号类型不能为空";
    public final static String CSVR_AUTH_FAIL_EXCEPTION = "0x001010=账号不存在或密码有误！";
    public final static String CSVR_ACOUNT_REGISTERED_EXCEPTION = "0x001013=该账号已经被注册";
    public final static String CSVR_ACOUNT_NOT_REGISTERED_EXCEPTION = "0x001016=此账号不存在！";
    public final static String CSVR_GET_CODE_EXCEPTION = "0x001019=获取验证码异常";
    public final static String CSVR_VALIDATE_CODE_EXCEPTION = "0x00101C=校验验证码异常";
    public final static String CSVR_NOT_FIND_CODE_EXCEPTION = "0x00101F=获取验证码失败";
    public final static String CSVR_NOT_CODE_EXCEPTION = "0x001022=验证码不能为空";
    public final static String CSVR_NOT_FIND_PHONE_EXCEPTION = "0x001025=手机号不能为空";
    public final static String CSVR_SEND_PHONE_EXCEPTION = "0x001028=IAM发送短信失败";
    public final static String CSVR_SEND_EMAIL_EXCEPTION = "0x00102B=IAM发送邮件失败";
    public final static String CSVR_NOT_FIND_GETTYPE_EXCEPTION = "0x00102F=获取验证码方式不能为空";
    public final static String CSVR_IAM_UPD_PHONE_EXCEPTION = "0x001032=IAM修改手机号失败";
    public final static String CSVR_IAM_UPD_EMAIL_EXCEPTION = "0x001035=IAM修改邮箱失败";
    public final static String CSVR_NOT_FIND_EMAIL_EXCEPTION = "0x001038=邮箱不能为空";
    public final static String CSVR_IAM_IDENTIFY_INFO_EXCEPTION = "0x00103B=实名认证失败";
    public final static String CSVR_UPLOAD_EXCEPTION = "0x00103E=上传附件失败";
    public final static String CSVR_CREATE_QR_EXCEPTION = "0x001027=二维码创建失败";
    public final static String CSVR_REST_PWD_EXCEPTION = "0x001035=IAM重置密码失败";
    public final static String CSVR_PWD_ERROR_EXCEPTION = "0x00103B=密码错误";
    public final static String CSVR_NOT_FIND_IMAGE_EXCEPTION = "0x100000=access_token过期";
    public final static String CSVR_USERNAME_OR_PWD_ERROR_EXCEPTION = "0x00103E=用户名或密码错误";
    public final static String CSVR_NOT_FIND_ACCOUNT_ERROR_EXCEPTION = "0x001042=该账号不存在";
    public final static String CSVR_NOT_PHONE_CODE_EXCEPTION = "0x001045=手机验证码不能为空";
    public final static String CSVR_NOT_EMAIL_CODE_EXCEPTION = "0x001048=邮箱验证码不能为空";
    
    public final static String CSVR_UPLOAD_TYPE_EXCEPTION = "0x001051=只能上传图片类型(png/gif/jpg),请重新选择";
    public final static String CSVR_UPLOAD_FILE_EXCEPTION = "0x001054=文件类型错误,请重新选择";
    public final static String CSVR_UPLOAD_FILE_PATH_EXCEPTION = "0x001057=文件路径找不到,请重新选择";
    public final static String CSVR_UPLOAD_FILE_ERROR_EXCEPTION = "0x001058=文件上传失败，请联系客服人员";
    public final static String CSVR_UPLOAD_FILE_RELEASE_OVERFLOW_EXCEPTION = "0x001059=工程的发布包达到上限,不能超过4个";
    public final static String CSVR_BATCH_UPDATE_CLICKNUM_EXCEPTION = "0x001060=批量更新点击量没有成功，请联系系统人员";
    public final static String CSVR_DEL_PROJECT_NOT_SUCCESS_EXCEPTION = "0x001061=该工程下存在打包文件，无法删除！";
    public final static String CSVR_NOT_ACCOUNT_EXCEPTION = "0x001064=无效的用户";
    public final static String CSVR_NOT_ENABLED_ACCOUNT_EXCEPTION = "0x001067=该账号已经被禁用";
    public final static String CSVR_UPLOAD_AVATAR_OVER_MAX_SIZE = "0x001068=头像文件大小不能超过2M";
    public final static String CSVR_NET_TIME_OUT = "0x001071=网络连接超时";
    public final static String CSVR_CATEGORY_IS_EMPTY = "0x001072=分类类别为空";
    public final static String CSVR_CURRENTPAGE_IS_EMPTY = "0x001074=当前页数为空";
    public final static String CSVR_PAGESIZE_IS_EMPTY = "0x001077=每页记录数为空";
    public final static String CSVR_TAGIDCITY_IS_EMPTY = "0x00107A=城市分类为空";
    public final static String CSVR_TAGIDINDUSTRY_IS_EMPTY = "0x00107C=行业分类为空";
    public final static String CSVR_APIIDS_IS_EMPTY = "0x00107F=API编号为空";
    public final static String CSVR_ACCESS_TOKEN_IS_EMPTY = "0x001073=用户token为空";
    public final static String CSVR_DUPLICATE_NICKNAME = "0x001065=该昵称已被占用";
    public final static String CSVR_UPLOAD_FILE_UNKNOWN = "0x001066=无法识别的文件格式";
    
    public final static String CSVR_COMPANY_IDENTIFY_INFO_IS_EMPTY = "0x001081=企业认证信息为空";
    public final static String CSVR_COMPANY_LOGO_IS_EMPTY = "0x001083=企业logo为空";
    public final static String CSVR_COMPANY_BUSINESS_LICENSE_IS_EMPTY = "0x001085=企业营业执照为空";
    public final static String CSVR_COMPANY_PROPOSER_WARRANT_IS_EMPTY = "0x001087=企业申请人授权书为空";
    public final static String CSVR_COMPANY_PROPOSER_ID_NO_FRONT_IS_EMPTY = "0x001089=企业申请人身份证正面为空";
    public final static String CSVR_COMPANY_PROPOSER_ID_NO_BACK_IS_EMPTY = "0x00108A=企业申请人身份证反面为空";
    
    
    //##############################################
    //开发者门户和移动端用户服务	svc-user	usr	0x00D
    public final static String USR_DEMO_EXCEPTION = "0x00D001=输入参数格式错误";

    public final static String USR_NOT_ACCOUNT_EXCEPTION = "0x00D004=account对象不能为空";
    public final static String USR_NOT_ACCOUNT_ID_EXCEPTION = "0x00D007=账号ID不能为空";
    public final static String USR_NOT_ACCOUNTLABLE_EXCEPTION = "0x00D00A=accountLables对象不能为空";
    public final static String USR_NOT_ACCOUNTLABLE_ID_EXCEPTION = "0x00D00D=lableId不能为空";
    public final static String USR_NOT_ACCOUNTPROPERTY_EXCEPTION = "0x00D010=accountProperties对象不能为空";
    public final static String USR_NOT_ACCOUNTPROPERTY_ID_EXCEPTION = "0x00D013=propertyId不能为空";
    public final static String PHONE_AND_EMAIL_NOT_ALL_EMPTY_EXCEPTION = "0x00D016=手机号和密码不能同时为空";
    public final static String USR_NOT_FIND_USERNAEM_EXCEPTION = "0x00D019=用户名不能为空";
    public final static String USR_NOT_EXISTS_EXCEPTION = "0x00D021=账号不存在";

    public final static String USR_NOT_HOBBY_EXCEPTION = "0x00D01C=hobby对象不能为空";
    public final static String USR_NOT_HOBBY_ID_EXCEPTION = "0x00D01F=hobbyID不能为空";
    public final static String USR_NOT_REALNAMEAUTHORDERLOG_EXCEPTION = "0x00D022=realnameAuthOrderLog对象不能为空";
    public final static String USR_NOT_REALNAMEAUTHORDERLOG_ID_EXCEPTION = "0x00D025=realnameAuthOrderLogID不能为空";
    
    public final static String UPDATE_USR_INFO_EXCEPTION = "0x00D027=更新账户信息失败";
    
    public final static String USR_NOT_REALNAMEAUTHORDER_EXCEPTION = "0x00D02A=实名验证对象不能为空";
    
    public final static String REALNAMEAUTHORDER_ID_NOT_EXISTS_EXCEPTION = "0x00D02D=实名验证id不能为空";
    
    public final static String REALNAMEAUTHORDER_USERID_NOT_EXISTS_EXCEPTION = "0x00D030=实名验证userid不能为空";
    public final static String USR_NOT_FIND_PHONE_EXCEPTION = "0x00D033=手机号不能为空";
    public final static String USR_NOT_FIND_EMAIL_EXCEPTION = "0x00D036=邮箱不能为空";
    public final static String USR_STATUS_NOT_EMPITY_EXCEPTION = "0x00D039=启用禁用状态不能为空";
    
    public final static String USR_USERID_IS_EMPTY = "0x00D040=自定义标签列表查询用户ID为空";
    
    public final static String COM_NOT_MESSAGE_EXCEPTION = "0x00D042= 消息管理不能为空";
    public final static String COM_NOT_MESSAGE_ID_EXCEPTION = "0x00D045= 修改消息状态时ID为空";
    public final static String COMPANY_IDENTIFY_INFO_IS_EMPTY = "0x00d048=企业认证信息为空";
    public final static String USERNAME_OR_PHONE_IS_EMPTY = "0x00d04A=用户名或手机号为空";
    public final static String USER_ID_IS_EMPTY = "0x00D04C=查询用户详情时用户ID不能为空"; 
    public final static String NO_REMARK_FOR_ACCESS_DENY = "0x00D04F=审核不通过时备注不能为空";
    
    //##############################################
    // svc-service
    public final static String SERVICE_PROJECT_NAME_NOT_EMPTY = "0x01C001=服务工程名不能为空";
    public final static String SERVICE_PROJECT_UPDATING_NOT_SUCCESS = "0x01C002=服务工程编辑失败";
    public final static String SERVICE_PROJECT_NAME_EXISTED = "0x01C003=服务工程名已存在";
    public final static String SERVICE_PROJECT_CREATING_NOT_SUCCESS = "0x01C004=服务工程创建失败";
    public final static String SERVICE_PROJECT_PACKAGE_CREATING_NOT_SUCCESS = "0x01C005=服务发布包创建失败";
    
    public final static String SERVICE_APPLICATIONORDERLOG_IS_EMPTY = "0x01C006=参数数据为空";
    
    public final static String SERVICE_CATEGORY_INFO_IS_EMPTY = "0x01C008=服务分类数据不存在";
    
    public final static String SERVICE_CHANNEL_SAVE_OR_UPDATE_ERROR = "0x01C012=渠道新增或者编辑失败";
    public final static String SERVICE_CHANNEL_IDS_NOT_EMPTY = "0x01C013=传入的渠道列表为空";
    public final static String SERVICE_PROJECT_SAVE_OR_UPDATE_ERROR_NOTEXISTS = "0x01C014=更新项目失败，项目不存在！";
    public final static String SERVICE_IS_RECOMMEND_EXCEPTION = "0x01C016=当前服务已经被推荐到开发者门户，请取消推荐状态。";
    public final static String SERVICE_INDEX_LOG_INVAILD_PARAM = "0x01C015=参数数据为空";
    
    public final static String SERVICE_PROJECT_VERSION_NAME_EXISTED = "0x01C017=服务工程分支名称已存在";
    public final static String SERVICE_PROJECT_ID_ISEMPTY = "0x01C019=服务工程ID不能为空";
    public final static String SERVICE_PROJECT_VERSION_NAME_ISEMPTY = "0x01C020=服务工程分支名称不能为空";
    public final static String SERVICE_PROJECT_VERSION_ID_ISEMPTY = "0x01C023=服务工程分支id不能为空";
    public final static String SERVICE_PROJECT_VERSION_ISEMPTY = "0x01C025=服务工程分支不能为空";
    public final static String SERVICE_PROJECT_GIT_CREATE_EXCEPTION = "0x01C027=服务工程分支创建用户git仓库失败";
    public final static String SERVICE_PROJECT_GIT_DELETE_EXCEPTION = "0x01C029=服务工程分支git仓库分支删除失败";
    public final static String SERVICE_PROJECT_VERSION_ISNULL = "0x01C031=服务工程该分支不存在";
    
    //##############################################
    //组件服务	svc-component 	com	   0x022 

    public final static String COM_NOT_COMPONENT_ID_EXCEPTION = "0x022001=组件compId不能为空";
    public final static String COM_NOT_COMPONENT_EXCEPTION = "0x022004=组件component对象不能为空";
    public final static String COM_NOT_CATEGORY_EXCEPTION = "0x022007=分类category对象不能为空";
    public final static String COM_NOT_CATEGORY_PARENT_EXCEPTION = "0x02200A=该组件分类存在子类，不能删除";
    public final static String COM_NOT_CATEGORY_COMP_EXCEPTION = "0x02200D=该分类存在组件数据，不能删除";
    public final static String COM_NOT_CATEGORY_ID_EXCEPTION= "0x022010=分类categoryId对象不能为空";
    public final static String COM_NOT_ORDER_ID_EXCEPTION = "0x022013=审核orderId不能为空";
    public final static String COM_NOT_ORDER_EXCEPTION = "0x022016=审核order对象不能为空";
    public final static String COM_IS_RECOMMEND_EXCEPTION = "0x022017=当前组件已经被推荐到开发者门户，请取消推荐状态。";
    public final static String COM_NOT_PROJECT_ID_EXCEPTION = "0x022019=组件工程projectId不能为空";
    public final static String COM_NOT_PROJECT_EXCEPTION = "0x02201C=组件工程project对象不能为空";
    public final static String COM_NOT_SUBSCRIPTION_EXCEPTION = "0x02201F=订阅组件对象subscription不能为空";
    public final static String COM_NOT_SUBSCRIPTION_MY_EXCEPTION = "0x022022=该组件为自己所属，不需要订阅";
    public final static String COM_SUBSCRIPTION_EXCEPTION = "0x022023=该组件已订阅，不需要重新订阅";
    public final static String COM_NOT_SUBSCRIPTION_ID_EXCEPTION = "0x022025=订阅组件Id不能为空";
    public final static String COM_NOT_COMP_ID_EXCEPTION = "0x022028=发布组件Id不能为空";
    public final static String COM_NOT_MYCOMP_ID_EXCEPTION = "0x02202B=私有组件Id不能为空";
    public final static String COM_NOT_ORDERLOG_ID_EXCEPTION = "0x02202E=审核日志Id不能为空";
    public final static String COM_NOT_ORDERLOG_EXCEPTION = "0x022031=审核日志不能为空";
    public final static String COM_NOT_PROJECT_NAME_EXCEPTION = "0x022034=组件工程名称不能为空";
    public final static String COM_NOT_PROJECT_DUPL_NAME_EXCEPTION = "0x022037=已经存在该工程名称";
    public final static String COM_NOT_COMPONENT_NAME_EXCEPTION = "0x02203A=组件名称不能为空";
    public final static String COM_NOT_COMPONENT_DUPL_NAME_EXCEPTION  = "0x02203D=已经存在该组件名称";
    public final static String COM_PROJECT_COMP_EXCEPTION = "0x022040=该组件已存在，请删除后，再保存为私有";
    public final static String COM_PROJECT_COMP_STATUS_EXCEPTION  = "0x022043=该组件已存在，且正在审核中，请下架后，删除，再更新";
    public final static String COM_NOT_VERSION_EXCEPTION  = "0x022046=组件版本不能为为空";
    public final static String COM_NOT_DESCRIPTION_EXCEPTION  = "0x022049=组件说明不能为为空";
    public final static String COM_NOT_SOLDOUTREASON_EXCEPTION  = "0x02204C=下架原因不能为空";
    public final static String COM_NOT_ORDER_AUDIT_STATUS_EXCEPTION  = "0x02204F=组件审核状态不能为空";
    public final static String COM_NOT_ORDER_AUDIT_REASON_EXCEPTION  = "0x022052=组件状态审核不通过，原因不能为空";
    public final static String COM_NOT_ORDER_TYPE_EXCEPTION  = "0x022055=审核中申请类型不能为空";
    public final static String COM_NOT_CATEGORY_NAME_EXCEPTION  = "0x022058=分类名称不能为空";
    public final static String COM_NOT_PROJECT_ICON_EXCEPTION = "0x022061=组件图标上传失败";
    public final static String COM_NOT_COMPONENT_UPLOAD_FILE = "0x022064=组件附件上传失败";
    public final static String COM_NOT_PROJECT_COMP = "0x022065=该工程已发布过组件，不能删除，请先删除组件再删除工程";
    public final static String COM_EMPTY_EXCEPTION = "0x022066=该组件状态已发生改变，请退出刷新重试";
    
    //推荐位、广告位
    public final static String COM_NOT_SUB_PLACE_EXCEPTION = "0x022070=推荐位/广告位对象不能为空";
    public final static String COM_NOT_SUB_PLACE_ID_EXCEPTION = "0x022071=推荐位/广告位id不能为空";
    public final static String COM_NOT_SUB_CHARGE_CATEGORY_EXCEPTION = "0x022072=收费标准不能为空";
    public final static String COM_NOT_SUB_CHARGE_SUM_EXCEPTION = "0x022073=收费金额不能为空";
    public final static String COM_NOT_SUB_TYPE_EXCEPTION = "0x022074=推荐位/广告位类型不能为空";
    public final static String COM_NOT_COMP_SER_ID_EXCEPTION = "0x022074=组件/服务id不能为空";
    public final static String COM_NOT_PAY_START_DATE_EXCEPTION = "0x022077=购买日期开始日期不能为空";
    public final static String COM_NOT_PAY_END_DATE_EXCEPTION = "0x022078=购买日期结束日期不能为空";
    public final static String COM_NOT_START_END_DATE_EXCEPTION = "0x022079=购买日期结束日期不能小于开始日期";
    public final static String COM_NOT_PAY_COMPANY_EXCEPTION = "0x022080=购买企业不能为空";
    public final static String COM_NOT_PAY_USER_EXCEPTION = "0x022081=购买人不能为空";
    public final static String COM_NOT_PHONE_EXCEPTION = "0x022082=联系电话不能为空";
    public final static String COM_NOT_SUB_STATUS_EXCEPTION = "0x022083=状态不能为空";
    public final static String COM_NOT_DATE_OVERLAP_EXCEPTION = "0x022084=录入的时间与已排期的时间有重叠，操作失败";
    public final static String COM_NOT_SUB_PLACE_PAY_EXCEPTION = "0x022085=排期对象不能为空";
    public final static String COM_NOT_SUB_PLACE_PAY_ID_EXCEPTION = "0x022086=排期id不能为空";

    public final static String COM_NOT_SUB_PLACE_PAY_UPLOAD_EXCEPTION = "0x022089=推荐位图标上传失败";
    public final static String COM_NOT_SUB_PLACE_PAY_BANNER_UPLOAD_EXCEPTION = "0x022092=广告位图片上传失败";
    //##############################################
    
    //##############################################
    //后台账号 svc-backuser		0x010
    public final static String ERR_0X010001  = "0x010001=帐号ID不能为空";
    public final static String ERR_0X010003  = "0x010003=帐号ID不存在";
    public final static String ERR_0X010005  = "0x010005=帐号名不能为空";
    public final static String ERR_0X010007  = "0x010007=员工姓名不能为空";
    public final static String ERR_0X010009  = "0x010009=初始密码不能为空";
    public final static String ERR_0X01000B  = "0x01000B=员工编号不能为空";
    public final static String ERR_0X01000C  = "0x01000C=角色名称不能为空";
    public final static String ERR_0X01000D  = "0x01000D=绑定角色不能为空";
    public final static String ERR_0X01000E  = "0x01000E=角色名称已存在";
    public final static String ERR_0X01000F  = "0x01000F=角色不存在";
    public final static String ERR_0X010010  = "0x010010=联系电话不能为空";
    public final static String ERR_0X010012  = "0x010012=密码不符合规则";
    public final static String ERR_0X010014  = "0x010014=帐号已存在";
    public final static String ERR_0X010016  = "0x010016=帐号ID已为启用";
    public final static String ERR_0X010018  = "0x010018=修改人ID不能为空";
    public final static String ERR_0X01001A  = "0x01001A=角色ID不能为空";
    public final static String ERR_0X01001C  = "0x01001C=角色ID不存在";
    public final static String ERR_0X01001E  = "0x01001E=ID对应的角色已为启用";
    public final static String ERR_0X010020  = "0x010020=ID对应的角色已为停用";
    public final static String ERR_0X010021  = "0x010021=权限ID不存在";
    public final static String ERR_0X010022  = "0x010022=用户未登录";
    public final static String ERR_0X010023  = "0x010023=该用户没有站点信息";
    public final static String ERR_0X010024  = "0x010024=账号名重复";
    public final static String ERR_0X010027  = "0x010027=账号已为禁用";
    public final static String ERR_0X010028  = "0x010028=邮箱不能为空";
    public final static String ERR_0X01002A  = "0x01002A=启用停用状态不能为空";
    public final static String ERR_0X01002B  = "0x01002B=邮箱不能为空";
    public final static String ERR_0X01002C  = "0x01002C=启停状态不能为空";
    public final static String ERR_0X01002D  = "0x01002D=内置角色不能修改";
  //##############################################
     
    
    //##############################################
    //开发者门户后台账号 svc-cablesysbackuser		0x037
    public final static String ERR_0x037001  = "0x037001=帐号ID不能为空";
    public final static String ERR_0x037003  = "0x037003=帐号ID不存在";
    public final static String ERR_0x037005  = "0x037005=帐号名不能为空";
    public final static String ERR_0x037007  = "0x037007=员工姓名不能为空";
    public final static String ERR_0x037009  = "0x037009=初始密码不能为空";
    public final static String ERR_0x03700B  = "0x03700B=员工编号不能为空";
    public final static String ERR_0x03700C  = "0x03700C=角色名称不能为空";
    public final static String ERR_0x03700D  = "0x03700D=绑定角色不能为空";
    public final static String ERR_0x03700E  = "0x03700E=角色名称已存在";
    public final static String ERR_0x03700F  = "0x03700F=角色不存在";
    public final static String ERR_0x037010  = "0x037010=联系电话不能为空";
    public final static String ERR_0x037012  = "0x037012=密码不符合规则";
    public final static String ERR_0x037014  = "0x037014=帐号已存在";
    public final static String ERR_0x037016  = "0x037016=帐号ID已为启用";
    public final static String ERR_0x037018  = "0x037018=修改人ID不能为空";
    public final static String ERR_0x03701A  = "0x03701A=角色ID不能为空";
    public final static String ERR_0x03701C  = "0x03701C=角色ID不存在";
    public final static String ERR_0x03701E  = "0x03701E=ID对应的角色已为启用";
    public final static String ERR_0x037020  = "0x037020=ID对应的角色已为停用";
    public final static String ERR_0x037021  = "0x037021=权限ID不存在";
    public final static String ERR_0x037022  = "0x037022=用户未登录";
    public final static String ERR_0x037024  = "0x037024=角色描述不能为空";
    public final static String ERR_0x037026  = "0x037026=角色状态不能为空";
    public final static String ERR_0x037028  = "0x037028=修改人ID不能为空";
    public final static String ERR_0x03702A  = "0x03702A=创建人ID不能为空";
    public final static String ERR_0x03702B  = "0x03702B=名称不能重复";
    public final static String ERR_0x03702C  = "0x03702C=账号状态不能为空";
    public final static String ERR_0x03702D  = "0x03702D=权限ID不能为空";
    public final static String ERR_0x03702E  = "0x03702E=账号或密码错误";
    public final static String ERR_0x037030  = "0x037030=角色名称不能重复";
    public final static String ERR_0x037032  = "0x037032=角色已关联账号";
    
    public final static String ERR_0x037034  = "0x037034=消息模板对象不能为空";
    public final static String ERR_0x037036  = "0x037036=消息模板ID不能为空";
    public final static String ERR_0x037038  = "0x037034=消息记录对象不能为空";
    public final static String ERR_0x03703A  = "0x037036=消息记录ID不能为空";
    
  //##############################################
    
    //#####################################################
    // svc-files
    public final static String FILE_PARAM_ISBLANK_EXCEPTION = "0x016001=参数不能为空";
    public final static String FILE_DATABASE_EXCEPTION = "0x016003=数据库操作异常";
    public final static String FILE_S3_EXCEPTION = "0x016005=文件服务器操作异常";
    
    //##############################################
    //服务运营模块 svc-opbase		0x028
    public final static String ERR_0X028001	= "0x028001=ID不能为空";
    public final static String ERR_0X028002	= "0x028002=用户未登录";
    public final static String ERR_0X028005	= "0x028005=站点ID不能为空";
    public final static String ERR_0X028007	= "0x028007=站点名称不能为空";
    public final static String ERR_0X028009	= "0x028009=站点状态不能为空";
    public final static String ERR_0X02800A	= "0x02800A=分类ID不能为空";
    public final static String ERR_0X02800B	= "0x02800B=站点状态不合法(必须值为0或1)";
    public final static String ERR_0X02800E = "0x02800E=站点简介不能为空";
    public final static String ERR_0X02800F	= "0x02800F=关联关系不存在";
    public final static String ERR_0X028011	= "0x028011=状态已为启用";
    public final static String ERR_0X028015	= "0x028015=状态已为停用";
    public final static String ERR_0X02801A	= "0x02801A=别称不能为空";
    public final static String ERR_0X02801F	= "0x02801F=启停状态不能为空";
    public final static String ERR_0X028021	= "0x028021=标签类别ID不能为空";
    public final static String ERR_0X028025	= "0x028025=标签分组ID不能为空";
    public final static String ERR_0X02802A	= "0x02802A=场景ID不能为空";
    public final static String ERR_0X02802F	= "0x02802F=区块名称不能为空";
    public final static String ERR_0X028031	= "0x028031=关联区块模板ID不能为空";
    public final static String ERR_0X028035	= "0x028035=前台是否显示不能为空";
    public final static String ERR_0X02803A	= "0x02803A=区块ID不能为空";
    public final static String ERR_0X02803F	= "0x02803F=记录不存在";
    public final static String ERR_0X028041	= "0x028041=请先移除区块和分类的绑定关系";
    public final static String ERR_0X028045	= "0x028045=请先移除区块和服务的关联关系";
    public final static String ERR_0X02804A	= "0x02804A=请先移除区块和道路绑定";
    public final static String ERR_0X02804F	= "0x02804F=区块启用状态不能删除";
    public final static String ERR_0X028051	= "0x028051=街道名称不能为空";
    public final static String ERR_0X028055	= "0x028055=道路索引是否有效不能为空";
    public final static String ERR_0X02805A	= "0x02805A=请先移除道路和区块的绑定关系";
    public final static String ERR_0X02805F	= "0x02805F=模板ID不能为空";
    public final static String ERR_0X028061	= "0x028061=城市站点ID不能为空";
    public final static String ERR_0X028065	= "0x028065=模板分类不能为空";
    public final static String ERR_0X02806A	= "0x02806A=区块色彩风格不能为空";
    public final static String ERR_0X02806F	= "0x02806F=排序不能为空";
    public final static String ERR_0X028071	= "0x028071=名称已存在";
    public final static String ERR_0X02807A	= "0x02807A=场景名称不能为空";
    public final static String ERR_0X02807F	= "0x02807F=使用中的模板不能删除";
    public final static String ERR_0X028081	= "0x028081=使用中的模板分类不能删除";
    public final static String ERR_0X028085	= "0x028085=已绑定到发布到本站点下服务的分类不能停用";
    public final static String ERR_0X02808A	= "0x02808A=已绑定到站点下的场景或区块的分类不能停用";
    public final static String ERR_0X02808F = "0x02808F=站点下场景名称不能重复";
    public final static String ERR_0X028091	= "0x02809F=同一场景下区块名称不能重复";
    public final static String ERR_0X028095	= "0x02809F=同一场景下街道名称不能重复";
    public final static String ERR_0X02809A	= "0x02809A=道路下的一个位置只能绑定一个区块";
    public final static String ERR_0X02809F	= "0x02809F=一个区块只能绑定到一条街道上";
    public final static String ERR_0X0280A1	= "0x0280A1=启动失败，上一次的同步还没执行完";
    public final static String ERR_0X0280A5	= "0x0280A5=同步类型不能为空";
    public final static String ERR_0X0280AA	= "0x0280AA=基础平台城市ID为空";
    public final static String ERR_0X0280AF	= "0x0280AF=文件不能为空";
    public final static String ERR_0X0280B1	= "0x0280B1=上传文件关联条目ID不能为空";
    public final static String ERR_0X0280B5	= "0x0280B5=模块未定义此类型文件";
    public final static String ERR_0X0280BA	= "0x0280BA=上传文件名字不能为空";
    public final static String ERR_0X0280BF	= "0x0280BF=远程文件服务接口调用异常";
    public final static String ERR_0X0280C1	= "0x0280C1=文件本地存储异常";
    public final static String ERR_0X0280C5	= "0x0280C5=file.access_path变量未设置";
    public final static String ERR_OXO280CA = "0x0280CA=同步控制表中无基础平台记录";
    public final static String ERR_OXO280CF = "0x0280CF=基础平台记录正在同步中";
    public final static String ERR_OXO280D1 = "0x0280D1=网络连接超时";
    public final static String ERR_0X0280D5 = "0x0280D5=用户ID不能为空";
    public final static String ERR_0X0280DA = "0x0280DA=个性化场景名称不能为空";
    public final static String ERR_0X0280DF = "0x0280DF=个性化场景ID不能为空";
    public final static String ERR_0X0280E1 = "0x0280E1=服务ID不能为空";
    public final static String ERR_0X0280E5 = "0x0280E5=创建个性化场景失败";
    public final static String ERR_0X0280EA = "0x0280EA=更新个性化场景失败";
    public final static String ERR_0X0280EF = "0x0280EF=个性化场景中添加服务失败";
    public final static String ERR_0X0280F1 = "0x0280F1=个性化场景中更新服务失败";
    public final static String ERR_0X0280F5	= "0x0280F5=标签ID不能为空";
    public final static String ERR_0X028101	= "0x028101=推荐位置名称不能为空";
    public final static String ERR_0X028102	= "0x028102=推荐位置描述不能为空";
    public final static String ERR_0X028105	= "0x028105=区块位置ID不能为空";
    public final static String ERR_0X02810A	= "0x02810A=推荐位置ID不能为空";
    public final static String ERR_0X028111	= "0x028111=服务推荐位置重复,同一场景区块区块位置只参对应一个服务推荐位";
    public final static String ERR_0X028115	= "0x028115=广告链接不能为空";
    public final static String ERR_0X028118	= "0x028118=推荐位置默认图片不能为空";
    public final static String ERR_0X02811A	= "0x02811A=服务ID不能为空";
    public final static String ERR_0X02811F	= "0x02811F=起始时间不能为空";
    public final static String ERR_0X028121	= "0x028121=结束时间不能为空";
    public final static String ERR_0X028125	= "0x028125=同一推荐位置不能同时出现多个服务";
    public final static String ERR_0X02812A	= "0x02812A=同一服务不能同时出现在不同推荐位";
    public final static String ERR_0X02812F	= "0x02812F=推荐ID不能为空";
    public final static String ERR_0X028131	= "0x028131=修改人名称查询异常";
    public final static String ERR_0X028133	= "0x028133=场景不存在";
    public final static String ERR_0X028135	= "0x028135=场景所属分类为空";
    public final static String ERR_0X028137	= "0x028137=模板不存在";
    public final static String ERR_0X028139	= "0x028139=服务入口位置不能为空";
    public final static String ERR_0X02813A	= "0x02813A=服务入口图片或服务入口描述为空";
    public final static String ERR_0X02813C	= "0x02813C=已关联场景的模板不允许修改";
    public final static String ERR_0X02813D	= "0x02813D=服务入口位置不能为空";
    public final static String ERR_0X02813E	= "0x02813E=场景模板不能为空";
    public final static String ERR_0X02813F	= "0x02813F=区块背景图片不能为空";
    public final static String ERR_0X028141	= "0x028141=未找到对应模板分类";
    public final static String ERR_0X028142 = "0x028142=请先删除场景和分类的绑定关系";
    public final static String ERR_0X028143 = "0x028143=请指定删除哪个场景";
    public final static String ERR_0X028145	= "0x028145=父级记录不存在";
    public final static String ERR_0X028147	= "0x028147=排序值必须为有效数值";
    public final static String ERR_0X028149	= "0x028149=名称和描述不能同时为空";
    public final static String ERR_0X02814A	= "0x02814A=属性标签ID不能为空";
    public final static String ERR_0X028151	= "0x028151=名称不能为空";
    public final static String ERR_0X028153	= "0x028153=启停状态必须为有效数值";
    public final static String ERR_0X028157	= "0x028157=站点下属性标签ID不能重复";
    public final static String ERR_0X028159	= "0x028159=当前属性标签ID或其子类下已绑定用户";
    public final static String ERR_0X028160	="0x028160=请指定删除哪个街道";
    public final static String ERR_0X028162	="0x028162=排序字段必须是数值";
    public final static String ERR_0X028164 ="0x028164=A侧区域已绑定街道";
    public final static String ERR_0X028166 ="0x028166=B侧区域已绑定街道";
    public final static String ERR_0X028168 ="0x028168=请指定删除哪个街道";
    public final static String ERR_0X028170 ="0x028170=只能删除当前场景下的街道,而街道[ID:%s]不属于当前场景";
    public final static String ERR_0X028172 ="0x028172=请指定街道所属场景";
    public final static String ERR_0X028174 ="0x028174=站点图片不能为空";
    public final static String ERR_0X028176 ="0x028176=反馈内容不能为空";
    public final static String ERR_0X028178 ="0x028178=起始时间不能大于结束时间";
    public final static String ERR_0X02817A ="0x02817A=反馈标题不能为空";
    public final static String ERR_0X02817C ="0x02817C=问题关于不能为空";
    public final static String ERR_0X02817F ="0x02817F=用户反馈ID不能为空";
    public final static String ERR_0X028181 ="0x028181=管理员ID不能为空";
    public final static String ERR_0X028183 ="0x028183=回复内容不能为空";
    public final static String ERR_0X028185 ="0x028185=当前页不能为空或是零";
    public final static String ERR_0X028187 ="0x028187=每页显示条数不能为空或是零";
    public final static String ERR_0X028189 ="0x028189=GitUser不能为空";
    public final static String ERR_0X02818A ="0x02818A=更新或删除时id不能为空";
    public final static String ERR_0X02818C ="0x02818C=GitUserPro不能为空";
    
    
    //##############################################
    
    //##############################################
    //移动端Open Service quant-services	qsvr	0x00A
    public final static String QSVR_NOT_FIND_USERNAME = "0x00A001=用户名为空";
    public final static String QSVR_NOT_FIND_PASSWORD = "0x00A005=密码为空";
    public final static String QSVR_NOT_FIND_VERIFYCODE = "0x00A00A=验证码为空";
    public final static String QSVR_VERIFYCODE_ERROR = "0x00A00F=验证码检验失败";
    public final static String QSVR_NOT_FIND_LOGINTYPE = "0x00A011=登录类型为空";
    public final static String QSVR_LOGIN_FAILED = "0x00A015=用户认证失败";
    public final static String QSVR_NOT_FIND_USER = "0x00A01A=无效用户信息";
    public final static String QSVR_PASSWORD_ERROR_EXCEPTION = "0x00A01F=用户密码错误";
    public final static String QSVR_NOT_FIND_GETTYPE_EXCEPTION = "0x00A021=获取验证码方式不能为空";
    public final static String QSVR_ACOUNT_REGISTERED_EXCEPTION = "0x00A025=该账号已经被注册";
    public final static String QSVR_ACOUNT_NOT_REGISTERED_EXCEPTION = "0x00A02A=该账号未注册";
    public final static String QSVR_NOT_FIND_CODE_EXCEPTION = "0x00A02F=获取验证码失败";
    public final static String ERR_0x00A031 = "0x00A031=token刷新失败";
    public final static String ERR_0x00A035 = "0x00A035=登录信息有问题，请重新登录";
    public final static String QSVR_USER_EXISTED = "0x00A03A=用户已注册";
    public final static String QSVR_IAM_IDENTIFY_INFO_FAILED = "0x00A03D=姓名与身份证号码不匹配";
    public final static String ERR_0X00A041 = "0x00A041=消息ID不能为空";
    public final static String ERR_0X00A044 = "0x00A044=消息记录不存在";
    public final static String ERR_0X00A047 = "0x00A047=邮箱已存在";
    
    //##############################################
    //搜索服务  svc-search	src	0x013
    public final static String SRC_APP_INDEX_CREATING_FAILURE = "0x013001=添加服务索引失败。 ";
    public final static String SRC_APP_INDEX_DELETING_FAILURE = "0x013002=删除服务索引失败。 ";
    public final static String SRC_APP_INDEX_UPDATING_FAILURE = "0x013003=更新服务索引失败。 ";
    public final static String SRC_COMP_INDEX_CREATING_FAILURE = "0x013004=添加组件索引失败。 ";
    public final static String SRC_COMP_INDEX_DELETING_FAILURE = "0x013005=删除组件索引失败。 ";
    public final static String SRC_COMP_INDEX_UPDATING_FAILURE = "0x013006=更新组件索引失败。 ";
    //##############################################
    
    //##############################################
    //链城运营后台系统Open Service	csysvr	0x004
    public final static String CSYSVR_INDEX_TYPE_EXISTS = "0x007001=索引已存在！";
    public final static String ACCOUNT_IS_NOT_EXIST = "0x007003=管理员账号不存在";
    public final static String FEEDBACK_ID_IS_NOT_EMPTY = "0x007005=反馈ID不能为空";
    public final static String CSYSVR_NET_TIME_OUT = "0x007007=网络连接超时";

    //##############################################
    
    //##############################################
    //开发者门户后台系统Open Service psvr	0x007
    public final static String ERR_0X007001 = "0x007001=推荐位置默认图片不能为空 ";
    public final static String ERR_0X007002 = "0X007002=服务上架审核失败，请联系系统人员！";
    public final static String ERR_0X007003 = "0X007003=服务下架审核失败，请联系系统人员！";
    public final static String ERR_0X007004 = "0X007004=更新服务点击量失败，请联系系统人员！";

    //##############################################
    
    //##############################################
    //Rabbit MQ
    public final static String ERR_0XFFFFFF = "0xFFFFFF= rabbit mq 模板实例为null！ ";
    public final static String ERR_0XFFFFFE = "0xFFFFFE= 非法的消息类型 ";
   
    //##############################################
    //Pilot-Article
    public final static String COM_NOT_ARTICLE_EXCEPTION = "0x008001=文章对象不能为空！ ";
    public final static String COM_NOT_DELETEARTICLE_ID_EXCEPTION = "0x008004=删除文章Id不能为空！ ";
    public final static String COM_NOT_DELETEARTICLE_IDS_EXCEPTION = "0x008007=批量删除文章ID不能为空！ ";
    public final static String COM_NOT_ARTICLE_ID_EXCEPTION = "0x00800A=文章ID不能为空！ ";
    public final static String COM_NOT_ARTICLE_NAME_EXCEPTION = "0x00800D=文章标题不能为空！ ";
    public final static String COM_NOT_ARTICLE_DUPL_NAME_EXCEPTION = "0x008010=文章标题不能重复！ ";
    //##############################################
    //Pilot-Agreement
    public final static String COM_NOT_AGREEMENT_EXCEPTION = "0x008013=Agreement对象不能为空！ ";
    public final static String COM_NOT_AGREEMENT_ID_EXCEPTION = "0x008016=AgreementId不能为空！ ";
    public final static String COM_NOT_CITYSITE_ID_EXCEPTION= "0x008019=城市站点Id不能为空！ ";
    public final static String COM_NOT_AGREEMENT_NAME_EXCEPTION= "0x00801C=Agreement名字不能为空！ ";
    public final static String ERR_0X008020= "0x008020=文章分类不能为空 ";
    public final static String ERR_0X008023= "0x008023=文章内容不能为空 ";
    public final static String ERR_0X008026= "0x008026=文章不存在";
    public final static String ERR_0X008029= "0x008029=文章站点不能为空";
    public final static String ERR_0X00802C= "0x00802C=已发布的文章不能删除";
    public final static String ERR_0X00802F= "0x00802F=记录不存在";
    //##############################################
    //##############################################
    //##############################################
    //ide-server 0x043
    public final static String ERR_0X043001 = "0x043001=用户ID不能为空 ";
	public final static String ERR_0X043002 = "0x043002=工程ID不能为空 ";
	public final static String ERR_0X043003 = "0x043003=分支名称不能为空 ";
	public final static String ERR_0X043004 = "0x043004=指定GIT仓库已存在";
	public final static String ERR_0X043005 = "0x043005=文件未找到";
	public final static String ERR_0X043006 = "0x043006=切换分支失败";
	public final static String ERR_0X043007 = "0x043007=GIT仓库不存在";
	public final static String ERR_0X043008 = "0x043008=删除指定分支失败";
	public final static String ERR_0X043009 = "0x043009=删除指定工程失败";
	public final static String ERR_0X043010 = "0x043010=上传文件失败";
	public final static String ERR_0X04301A = "0x04301A=保存用户privatekey失败";
	public final static String ERR_0X04301B = "0x04301B=保存用户publickey失败";
	public final static String ERR_0X04301C = "0x04301C=保存文件失败";
	public final static String ERR_0X04301D = "0x04301D=创建新分支失败";
	public final static String ERR_0X04301E = "0x04301E=指定分支不存在";
	public final static String ERR_0X04301F = "0x04301F=拉取代码失败";
    
    public static void main(String[] args) {
        String next =getNextErrCode(0x111,0xFFF);
        System.out.println(next);
    }
}
