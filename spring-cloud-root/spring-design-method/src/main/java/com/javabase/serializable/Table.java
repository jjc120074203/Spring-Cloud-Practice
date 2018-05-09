
package com.javabase.serializable;

import java.io.Serializable;

/**
 * Serializable 就是将对象转换成流对象的过程
 * 
 * @author issuser
 *
 */
public class Table implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4059931215885321658L;
	private int id ;
	private String name;
	private String length;
	
	
	public Table(int id, String name, String length) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	
	

}
