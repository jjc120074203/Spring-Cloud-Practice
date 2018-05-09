package com.kimdeath.configuration.auth;

import java.util.Map;

/**
 * Created by jiazaibo on 17-2-13.
 */
public class IAMUser {

    private String name;
    private String opneid;
    private String phone;
    private String id;
    private String source;
    private String type;
    private String email;
    private String target;
    private Map<String, String> extra; //扩展信息：认证信息

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOpneid() {
        return opneid;
    }
    public void setOpneid(String opneid) {
        this.opneid = opneid;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
	public Map<String, String> getExtra() {
		return extra;
	}
	public void setExtra(Map<String, String> extra) {
		this.extra = extra;
	}

}
