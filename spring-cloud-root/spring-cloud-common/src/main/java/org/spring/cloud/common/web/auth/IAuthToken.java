package org.spring.cloud.common.web.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jiazaibo on 17-3-21.
 */
public interface IAuthToken extends Serializable {

     String getAccessToken();
     void setAccessToken(String accessToken);
     String getTokenType();
     void setTokenType(String tokenType);
     Long getExpiresIn();
     void setExpiresIn(Long expiresIn);
     String getRefreshToken();
     void setRefreshToken(String refreshToken);
     String getScope();
     void setScope(String scope);
     long getStartTime();
     void setStartTime(long startTime);


}
