package org.spring.cloud.common.web.auth;

/**
 * Created by jiazaibo on 17-3-21.
 */
public interface IOAuthHelper {

    boolean isTokenExpired(IAuthToken token);

    IAuthToken refreshToken(String refreshToken);


}
