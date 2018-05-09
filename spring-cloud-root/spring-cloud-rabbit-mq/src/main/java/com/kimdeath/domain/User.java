package com.kimdeath.domain;

import java.io.Serializable;

/**
 * Created by jiazaibo on 17-2-14.
 */
public class User implements Serializable{
	private static final long serialVersionUID = 3222693625722166705L;
	private String id;
    private String name;
    private String nickName;
    private String descr;
    private String deleted ;

    public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}


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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
