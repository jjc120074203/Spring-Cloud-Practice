package org.spring.cloud.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xiaoman on 17-3-12.
 */
public class CookieUtil {
    public static String getCookieValue(Cookie[] cookies, String cookieName,
                                        String defaultValue) {
        if (null == cookies)
            return "";
        for (int i = 0, size = cookies.length; i < size; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName()))
                return cookie.getValue();
        }
        return defaultValue;
    }

    public static String getCookieValue(HttpServletRequest request,
                                        String cookieName, String defaultValue) {
        return getCookieValue(request.getCookies(), cookieName, defaultValue);
    }

    public static void setCookie(CIHttpCookie cookie,
                                 HttpServletResponse httpResponse) {
        if (httpResponse != null) {
            cookie.writeResponse(httpResponse);
        }
    }

    public static void clearCookie(Cookie[] cookies, String cookieName,
                                   HttpServletResponse httpResponse) {
        if (null != cookies) {
            for (int i = 0, size = cookies.length; i < size; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName()))
                    cookie.setMaxAge(0);
                if (httpResponse != null) {
                    httpResponse.addCookie(cookie);
                }
            }
        }
    }

    public static void clearCookie(HttpServletRequest request,
                                   String cookieName, HttpServletResponse httpResponse) {
        clearCookie(request.getCookies(), cookieName, httpResponse);
    }

    public static String getIPAddr(HttpServletRequest request){
        try {
            String ipAddress = null;
            //ipAddress = this.getRequest().getRemoteAddr();
            ipAddress = request.getHeader("x-forwarded-for");
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("X-Real-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if(ipAddress.equals("127.0.0.1")){
                    //根据网卡取本机配置的IP
                    InetAddress inet=null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {

                    }
                    ipAddress= inet.getHostAddress();
                }

            }
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
                if(ipAddress.indexOf(",")>0){
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
                }
            }
            return ipAddress;
        } catch (Exception e) {
            return "";
        }
    }
}
