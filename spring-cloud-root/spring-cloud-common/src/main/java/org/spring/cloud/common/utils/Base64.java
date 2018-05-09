package org.spring.cloud.common.utils;


/**
 * 加密解密方法
 * @author jlchenq
 *
 */
public final class Base64 {
	private static final Base64Coder coder = new Base64Coder();

	public static String encode(String enCode) {
		byte[]  enCodeBytes =enCode.getBytes();
		return coder.encode(enCodeBytes);
		
	}
	public static String encodeByte(byte[]  enCodeBytes ) {
		return coder.encode(enCodeBytes);
	}
	public static String decodeByte(byte[]  enCodeBytes ) {
		return new String(enCodeBytes);
	}
	public static String decode(String s) {
		return new String (coder.decode(s));
	}
}
