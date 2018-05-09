package org.spring.cloud.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinYinNameHelper {

	private final static String BASE_RAND_SEQUENCE = "abcdefghijklmnopqrstuvwxyz1234567890";
	
	/**
	 * 取得应用名称的拼音名称
	 * @param name			应用名称
	 * @param firstOnly		是否仅要首字母
	 * @return
	 */
	public static String getPyName(String name, boolean firstOnly) {
		char [] chs = name.toCharArray();
		StringBuilder pyNameBuilder = new StringBuilder();
		for (char ch : chs) {
			if (isChineseCharater(""+ch)) {
				String [] pyArray = PinyinHelper.toHanyuPinyinStringArray(ch);
				String fr = pyArray[0];
				if (firstOnly) {
					fr = ""+fr.charAt(0);
				} else {
					int frLength = fr.length();
					int endChar = fr.charAt(frLength - 1);
					if (endChar >= 48 && endChar <= 57) {
						fr = fr.substring(0, frLength - 1);
					}
				}
				pyNameBuilder.append(fr);
			} else {
				pyNameBuilder.append(""+ch);
			}
		}
		return pyNameBuilder.toString().toLowerCase();
	}
	
	/**
	 * 取得应用名称的拼音名称
	 * @param name			应用名称
	 * @param firstOnly		是否仅要首字母
	 * @param randLength	随机数长度
	 * @param seperator		名称与随机数之间的分隔符
	 * @return
	 */
	public static String getPyNameWithRandom(String name, boolean firstOnly, int randLength, String seperator) {
		String pyName = getPyName(name, firstOnly);
		String randString = genRandomString(randLength);
		return new StringBuilder(pyName)
				.append(seperator)
				.append(randString)
				.toString();
	}
	
	private static boolean isChineseCharater(String ch) {
		return ch.matches("[\u4e00-\u9fa5]");
	}
	
	
	public static String genRandomString(int length) {
		int seqLength = BASE_RAND_SEQUENCE.length();
		StringBuilder randSequenceBuilder = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			int pos = (int)(Math.random() * seqLength);
			randSequenceBuilder.append(BASE_RAND_SEQUENCE.charAt(pos));
		}
		
		return randSequenceBuilder.toString();
	}
	
}
