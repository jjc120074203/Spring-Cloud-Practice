package org.spring.cloud.common.web.auth;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jzbmufeng on 2017/2/23.
 */
public class AuthUserContext {

    private static final String AUTH_USER_KEY = "X-AUTHUSER-KEY";
    private static final String AUTH_TOKEN_KEY = "X-AUTH-TOKEY-KEY";

    public static final Logger logger = LoggerFactory.getLogger(AuthUserContext.class);
//    private final ThreadLocal<AuthUser> authUserLocal = new ThreadLocal<>();
    private final ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

//    private final static Object locker = new Object();

    private static volatile AuthUserContext authUserContext = null;

    private IOAuthHelper oauthHelper;

    public AuthUserContext(IOAuthHelper oAuthHelper) {
        this.oauthHelper = oAuthHelper;
        authUserContext = this;
    }

    public static AuthUserContext getContext() {
        return authUserContext;
    }

    public AuthUserContext withRequest(HttpServletRequest request) {
        this.requestLocal.set(request);
        return this;
    }

    public void setAuthUser(AuthUser user) {
        this.getSession().setAttribute(AUTH_USER_KEY, user);
    }

    public AuthUser getAuthUser() {
        AuthUser authUser = (AuthUser)this.getSesstionAttribute(AUTH_USER_KEY);
        return authUser;
    }


    public void setSessionAttribute(String attrName, Serializable value) {
        if (AUTH_USER_KEY.equals(attrName)
                || AUTH_TOKEN_KEY.equals(attrName)) {
            throw new RuntimeException("You cann't rewrite an attribute used by system.");
        }
        this.getSession().setAttribute(attrName, value);
    }

    public void setAuthToken(IAuthToken authToken) {
        this.getSession().setAttribute(AUTH_TOKEN_KEY, authToken);
    }

    public IAuthToken getAuthToken() {
        IAuthToken token = (IAuthToken) this.getSession().getAttribute(AUTH_TOKEN_KEY);
        if (this.oauthHelper.isTokenExpired(token)) {
            synchronized (token) {
                if (this.oauthHelper.isTokenExpired(token)) {
                    token = this.oauthHelper.refreshToken(token.getRefreshToken());
                    this.setAuthToken(token);
                }
            }
        }
        return token;
    }

    public Object getSesstionAttribute(String attrName) {
        return this.getSession().getAttribute(attrName);
    }


    private HttpSession getSession() {
        return this.requestLocal.get().getSession();
    }

    public String getAuthUserKey() {
        return this.getSession().getId();
    }


    public void logout() {
        this.getSession().invalidate();
    }




//    /**
//     * 从Session中获取属性值
//     * @param attrName
//     * @return
//     */
//    public Object getSessionAtrribute(String attrName) {
//        Object retattr = null;
//        CISession ciSession = this.getSession(false);
//        if (ciSession == null) return null;
//        retattr = ciSession.get(attrName);
//        return retattr;
//    }
//
//    /**
//     * 在Session中保存属性值，autocommit为自动保存，否则设置多个属性后tonging保存
//     * @param attrName
//     * @param value
//     * @param autocommit
//     * @return
//     */
//    public boolean setSessionAttribute(String attrName, Object value ,boolean autocommit) {
//        boolean retflag = true;
//        CISession ciSession = this.getSession(true);
//        if(ciSession==null) return false;
//        ciSession.put(attrName, value);
//        this.ciSessionLocal.set(ciSession);
//        if(autocommit) {
//            commitSession();
//        }
//        return retflag;
//    }
//    public boolean commitSession(){
//        boolean retflag = false;
//        if (null == this.redisSessionRepository) {
//            throw new CIBaseException("redisSessionRepository object not found! Please set the redisSessionRepository before use the CISession object!");
//        }
//        CISession ciSession = this.ciSessionLocal.get();
//        try {
//            redisSessionRepository.saveSession(ciSession);
//        }catch (Exception ex){
//            logger.error("Session 保存失败！");
//        }
//        return retflag;
//    }
//
//    public void setRedisSessionRepository(RedisSessionRepository redisSessionRepository) {
//        this.redisSessionRepository = redisSessionRepository;
//    }
//
//    private CISession getSession(boolean createnew) throws CIBaseException {
//        if (null == this.redisSessionRepository) {
//            throw new CIBaseException("redisSessionRepository object not found! Please set the redisSessionRepository before use the CISession object!");
//        }
//        CISession s = (CISession) ciSessionLocal.get();
//        try {
//            if (s == null) {
//                if (this.getAuthUser() != null) {
//                    s = redisSessionRepository.getSession(this.getAuthUser(), createnew);
//                    ciSessionLocal.set(s);
//                }
//            }
//        } catch (Exception ex) {//TODO:相应的异常
//            throw new CIBaseException("获取Session失败", ex);
//        }
//        return s;
//    }
}
