package org.spring.cloud.common.utils;

/**
 * 加密解密
 * @author jlchenq
 *
 */
public interface Coder {
	
	/**
	 * 加密
	 * @param data
	 * @return
	 */
	public String encode(byte[] data);
	
	/**
	 * 解密
	 * @param string
	 * @return
	 */
	public byte[] decode(String string);

}
