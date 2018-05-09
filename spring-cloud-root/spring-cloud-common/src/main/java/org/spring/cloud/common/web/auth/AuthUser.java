package org.spring.cloud.common.web.auth;

import java.io.Serializable;

/**
 * Created by jzbmufeng on 2017/3/14.
 */
public class AuthUser implements Serializable {
    private String id;
    private String name;
    private String sessionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
