package com.kimdeath.configuration.auth;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.spring.cloud.common.constant.ExceptionConstants;
import org.spring.cloud.common.exception.CIBaseException;
import org.spring.cloud.common.web.auth.IAuthToken;
import org.spring.cloud.common.web.auth.IOAuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * IAM SDK Helper Class
 */
@Component
public class IamOAuthHelper implements IOAuthHelper {

    private static final String REFRESH_TOKEN_GRANT_TYPE="refresh_token";

    @Value("${iam.server.url}")
    private String authServerUrl;

    @Value("${iam.auth.clientId}")
    private String clientId;

    @Value("${iam.auth.clientSecret}")
    private String clientSecret;

    @Value("${iam.callback.url}${iam.callback.path.login}")
    private String iamCallback;

    @Value("${iam.server.path.login}")
    private String loginPath;

    @Value("${iam.server.path.accessToken}")
    private String accessTokenPath;

    @Value("${iam.server.path.userInfo}")
    private String userInfoPath;

    @Value("${iam.server.path.refreshToken}")
    private String refreshTokenPath;
    
    @Value("${iam.server.path.register}")
    private String registerPath;
    
    @Value("${iam.server.path.logout}")
    private String logoutPath;

    @Value("${iam.callback.url}${iam.callback.path.logout}")
    private String logoutCallback;

    @Value("${iam.server.path.resetPassword}")
    private String resetPasswordPath;
    
    @Value("${iam.server.path.sendPhone}")
    private String sendPhonePath;
    
    @Value("${iam.server.path.sendEmail}")
    private String sendEmailPath;
    
    @Value("${iam.server.path.updPhone}")
    private String updPhonePath;
    
    @Value("${iam.server.path.updEmail}")
    private String updEmailPath;
    
    @Value("${iam.server.path.identifyInfo}")
    private String identifyInfoPath;
    
    @Value("${iam.server.path.upload}")
    private String uploadPath;
    
    @Value("${iam.server.path.getImage}")
    private String getImagePath;

    private String loginUrl;

    private String accessTokenUrl;

    private String userInfoUrl;

    private String refreshTokenUrl;
    
    private String registerUrl;

    private String resetPasswordUrl;
    
    private String sendPhoneUrl;
    
    private String sendEmailUrl;
    
    private String updPhoneUrl;
    
    private String updEmailUrl;
    
    private String identifyInfoUrl;
    
    private String uploadUrl;
    
    private String getImageUrl;
    
    @Autowired
    private RestTemplate iamRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        this.setLoginUrl();
        this.setAccessTokenUrl();
        this.setUserInfoUrl();
        this.setRefreshTokenUrl();
        this.setRegisterUrl();
        this.setResetPasswordUrl();
        this.setSendPhoneUrl();
        this.setSendEmailUrl();
        this.setUpdPhoneUrl();
        this.setUpdEmailUrl();
        this.setIdentifyInfoUrl();
        this.setUploadUrl();
        this.setGetImageUrl();
    }


    public IAMOAuth2Token getAccessToken(String code) {
        IAMOAuth2TokenParams params = new IAMOAuth2TokenParams();
//        params.setGrantType("authorization_code");
//        params.setClientId(this.clientId);
//        params.setClientSecret(this.clientSecret);
//        params.setCode(code);
//        params.setRedirectUri(this.iamCallback);
//
//        @SuppressWarnings("unchecked")
//		Map<String, Object> resMap = this.iamRestTemplate.postForObject(this.accessTokenUrl, params, HashMap.class);
//        int retCode = (Integer)resMap.get("retCode");
//        if (retCode != 0) throw new RuntimeException((String)resMap.get("message"));
//
//        Object object = resMap.get("result");
        
        IAMOAuth2Token token = new IAMOAuth2Token();
        
        token.setStartTime(new Date().getTime());

        return token;
    }

    public IAMUser getUser(String accessToken) {

        String url =  String.format("%s?access_token=%s&format=json", this.userInfoUrl, accessToken);
        @SuppressWarnings("unchecked")
		Map<String, Object> resMap = this.iamRestTemplate.getForObject(url, HashMap.class);
        int retCode = (Integer)resMap.get("retCode");
        if (retCode != 0) throw new RuntimeException((String)resMap.get("message"));
        Object object = resMap.get("result");
        return this.objectMapper.convertValue(object, IAMUser.class);
    }


    public IAMOAuth2Token extractToken(String token) {
        byte [] bytes = Base64.getDecoder().decode(token);
        IAMOAuth2Token authToken = null;
        try {
            authToken = this.objectMapper.readValue(bytes, IAMOAuth2Token.class);
        } catch (IOException e) {
            throw new RuntimeException("token解析错误");
        }
        return authToken;
    }

    public IAuthToken refreshToken(String refreshToken) {
        RefreshTokenParam param = new RefreshTokenParam();
        param.setClientId(this.clientId);
        param.setClientSecret(this.clientSecret);
        param.setGrantType(REFRESH_TOKEN_GRANT_TYPE);
        param.setRedirectUri(this.iamCallback);
        param.setRefreshToken(refreshToken);

        @SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.refreshTokenUrl, param, HashMap.class);

        int retCode = (Integer)resultMap.get("retCode");

        if (retCode != 0) throw new RuntimeException((String)resultMap.get("message"));
        Object result = resultMap.get("result");

        return this.objectMapper.convertValue(result, IAMOAuth2Token.class);

    }
    
    public Map<String, Object> checkUser(String name, String password) {
		String url = String.format(
				"%s?grant_type=password&username=%s&password=%s&client_id=%s&client_secret=%s&scope=all_info",
				this.accessTokenUrl, name, password, this.clientId, this.clientSecret);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> oAuthResponse = this.iamRestTemplate.getForObject(url, Map.class);
		int retCode = (Integer)oAuthResponse.get("retCode");
		if (retCode == 4402) {
    		throw new CIBaseException(ExceptionConstants.CSVR_USERNAME_OR_PWD_ERROR_EXCEPTION);
    	}else if(retCode == 4403){
    		throw new CIBaseException(ExceptionConstants.CSVR_NOT_FIND_ACCOUNT_ERROR_EXCEPTION);
    	}
		return oAuthResponse;
	}
    
    public boolean registry(String username, String password, String verifiedCode) {
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("username", username);
    	params.put("password", password);
    	params.put("code", verifiedCode);
    	params.put("source", "mircoservices");
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.registerUrl, params, HashMap.class);
    	
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_IAM_REQISTRY_EXCEPTION + (String)resultMap.get("message"));
    	}
    	
    	return true;
    }

    /**
     * 重置密码
     * @param username
     * @param password
     * @return
     */
    public boolean resetPwd(String username,String password) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("username", username);
    	params.put("password", password);
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.resetPasswordUrl, params, HashMap.class);
    	
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_REST_PWD_EXCEPTION + (String)resultMap.get("message"));
    	}
    	return true;
	}
    
    /**
     * 修改手机号
     * @param accessToken
     * @param phone
     * @return
     */
    public boolean updPhone(String accessToken,String phone) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("access_token", accessToken);
    	params.put("phone", phone);
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.updPhoneUrl, params, HashMap.class);
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_IAM_UPD_PHONE_EXCEPTION + (String)resultMap.get("message"));
    	}
    	return true;
	}
    
    /**
     * 修改邮箱
     * @param accessToken
     * @param email
     * @return
     */
    public boolean updEmail(String accessToken,String email) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("access_token", accessToken);
    	params.put("email", email);
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.updEmailUrl, params, HashMap.class);
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_IAM_UPD_EMAIL_EXCEPTION + (String)resultMap.get("message"));
    	}
    	return true;
	}
    
    /**
     * 获取用户头像
     * @param accessToken
     * @param email
     * @return
     */
    public String getImage(String accessToken) {
    	String imgUrl = null;
        String url =  String.format("%s?access_token=%s", this.getImageUrl, accessToken);
 		@SuppressWarnings("unchecked")
 		Map<String, Object> resultMap = this.iamRestTemplate.getForObject(url,HashMap.class);
 		int retCode = (Integer)resultMap.get("retCode");
 		if (retCode == 4402) {
 			throw new CIBaseException(ExceptionConstants.CSVR_NOT_FIND_IMAGE_EXCEPTION + (String)resultMap.get("message"));
 		}
 		
 		@SuppressWarnings("unchecked")
	 	Map<String, Object> rstMap = (Map<String, Object>) resultMap.get("result");
 		if (rstMap != null && rstMap.get("url") != null) {
 			imgUrl = rstMap.get("url").toString();
 		}
		return imgUrl; 		
 	}
    
    /**
     * 
     * @param accessToken
     * @param email
     * @return
     */
    public boolean identifyInfo(String accessToken, IdentifyAccountInfoDTO identifyDTO) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("access_token", accessToken);
    	params.put("auth_type", identifyDTO.getAuthType());
    	params.put("auth_real_name",identifyDTO.getAuthRealName());
    	
    	params.put("auth_sex",identifyDTO.getAuthSex());
    	params.put("auth_birthday", "");
    	params.put("auth_id_card", identifyDTO.getAuthIdCard());
    	
    	params.put("auth_id_card_expire", "");
    	params.put("auth_id_card_front", "");
    	params.put("auth_id_card_back", "");
    	
    	params.put("auth_phone", identifyDTO.getAuthPhone());
    	params.put("auth_code", identifyDTO.getAuthCode());
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.identifyInfoUrl, params, HashMap.class);
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_IAM_IDENTIFY_INFO_EXCEPTION + (String)resultMap.get("message"));
    	}
    	return true;
	}
    
    public Map<String, Object> uploadFile(String accessToken, MultipartFile file, String type){
    	MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<String, Object>();
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    	FileSystemResource fileResource = null;
    	String localPath = "D:\\";
    	String fileName = file.getOriginalFilename();
    	String filetype =fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null; 
    	String path = "";
    	if (!file.isEmpty() && null!=file.getOriginalFilename()) {
            try {
                byte[] bytes = file.getBytes();
                File fileFl =new File(localPath);    
                if("GIF".equals(filetype.toUpperCase())||"PNG".equals(filetype.toUpperCase())||"JPG".equals(filetype.toUpperCase())){
                	//如果文件夹不存在则创建    
                	if(!fileFl.exists()&& !fileFl.isDirectory()){       
                		fileFl.mkdir();
                	}
                	//获取文件导入路径
                	path = localPath + File.separator +file.getOriginalFilename();
                	File tempFile = new File(path);
                	if(tempFile.exists()){
                		tempFile.delete();
                	}
                	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));  
                	stream.write(bytes);
                	stream.close();
                	
                	// 转存文件到指定的路径
                    fileResource = new FileSystemResource(new File(path));
                }else {
               		throw new CIBaseException(ExceptionConstants.CSVR_UPLOAD_TYPE_EXCEPTION);
                }
                
            }catch(IOException e){
         	   throw new CIBaseException(ExceptionConstants.CSVR_UPLOAD_FILE_PATH_EXCEPTION +" "+ e.getMessage());
            }
        }else {
     	   throw new CIBaseException(ExceptionConstants.CSVR_UPLOAD_FILE_UNKNOWN);//0x001066=无法识别的文件格式
        }      
    	
    	multipartRequest.add("access_token", accessToken);
    	multipartRequest.add("upload_file", fileResource);
    	multipartRequest.add("type", type);

    	HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multipartRequest, headers);
 
         
    	@SuppressWarnings("unchecked") 
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.uploadUrl, requestEntity, HashMap.class);
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode == 0) {
    		File tempFile = new File(path); //删除文件
    		if(tempFile.exists()){
        		tempFile.delete();
        	}
    	}
    	return resultMap;
    }
        
    /**
     * 发送短信
     * @param mobiles
     * @return
     */
    public String sendPhone(String mobiles) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("mobiles", mobiles);
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.sendPhoneUrl, params, HashMap.class);
    	
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_SEND_PHONE_EXCEPTION + (String)resultMap.get("message"));
    	}
    	@SuppressWarnings("unchecked")
		Map<String, Object> rstMap = (Map<String, Object>) resultMap.get("result");
    	return rstMap.get("sms_code").toString();
	}

    /**
     * 发送邮件
     * @param email 
     * @return
     */
    public String sendEmail(String email) {
		Map<String, String> params = new HashMap<String, String>();
    	params.put("email", email);
    	
    	@SuppressWarnings("unchecked")
		Map<String, Object> resultMap = this.iamRestTemplate.postForObject(this.sendEmailUrl, params, HashMap.class);
    	
    	int retCode = (Integer)resultMap.get("retCode");
    	if (retCode != 0) {
    		throw new CIBaseException(ExceptionConstants.CSVR_SEND_EMAIL_EXCEPTION + (String)resultMap.get("message"));
    	}
    	@SuppressWarnings("unchecked")
		Map<String, Object> rstMap = (Map<String, Object>) resultMap.get("result");
    	return rstMap.get("email_code").toString();
	}
    
    public boolean isTokenExpired(IAuthToken token) {
        long startTime = token.getStartTime();
        long expireIn = token.getExpiresIn();
        long nowTime = new Date().getTime();
        // 如果少于5分钟的到期时间，则认为token已到期
        return (nowTime - startTime) / 1000 - expireIn > 300;
    }

    public String compressTokenWithBase64(IAuthToken token) {
        String json = null;
        try {
            json = this.objectMapper.writeValueAsString(token);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new String(Base64.getEncoder().encode(json.getBytes()));
    }

    private void setLoginUrl() {
        this.loginUrl = String.format("%s?client_id=%s&response_type=code&redirect_uri=%s&scope=all_info",
                this.getFullUrl(this.authServerUrl, this.loginPath),
                this.clientId,
                this.iamCallback);
    }

    private void setAccessTokenUrl() {
        this.accessTokenUrl = this.getFullUrl(this.authServerUrl, this.accessTokenPath);
    }


    private void setUserInfoUrl() {
        this.userInfoUrl = this.getFullUrl(this.authServerUrl, this.userInfoPath);
    }

    private void setRefreshTokenUrl() {
        this.refreshTokenUrl = this.getFullUrl(this.authServerUrl, this.refreshTokenPath);
    }
    
    private void setRegisterUrl() {
        this.registerUrl = this.getFullUrl(this.authServerUrl, this.registerPath);
    }

    private void setResetPasswordUrl() {
        this.resetPasswordUrl = this.getFullUrl(this.authServerUrl, this.resetPasswordPath);
    }
    
    private void setSendPhoneUrl() {
        this.sendPhoneUrl = this.getFullUrl(this.authServerUrl, this.sendPhonePath);
    }
    
    private void setSendEmailUrl() {
    	this.sendEmailUrl = this.getFullUrl(this.authServerUrl, this.sendEmailPath);
    }

    private void setUpdPhoneUrl() {
        this.updPhoneUrl = this.getFullUrl(this.authServerUrl, this.updPhonePath);
    }
    
    private void setUpdEmailUrl() {
    	this.updEmailUrl = this.getFullUrl(this.authServerUrl, this.updEmailPath);
    }
    
    private void setIdentifyInfoUrl() {
    	this.identifyInfoUrl = this.getFullUrl(this.authServerUrl, this.identifyInfoPath);
    }
    
    private void setUploadUrl() {
    	this.uploadUrl = this.getFullUrl(this.authServerUrl, this.uploadPath);
    }
    
    private String getFullUrl(String url, String path) {
        return new StringBuilder(url).append(path).toString();
    }

    public String getLoginUrl() {
        return loginUrl;
    }
    
    private void setGetImageUrl() {
    	this.getImageUrl = this.getFullUrl(this.authServerUrl, this.getImagePath);
    }


}
