package org.spring.cloud.common.utils;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * 通用工具
 * @author jlchenq
 * @since 2016-12-1
 */
public class CommonTools {
	/**
	 * 计算与时间startTime相距addTime长度的时(时间以分为单位)
	 * @param  startTime 始计算时
	 * @param  addTime 时间间隔
	 * @author chenjl
	 * @date 2016-11-21
	 */
	public Date getNextTime(Date startTime, int addTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		c.add(Calendar.MINUTE, addTime);
		return c.getTime();
	}
	/** 
	 * 将一个字符串分解成几个段
	 * @param str
	 *            字符�?
	 * @param segLen
	 *            每段限长
	 * @param segNum
	 *            分解段数
	 * @return 分解后的字串
	 * @author chenjl
	 */
	public static String[] split(String str, int segLen, int segNum) {
		String[] result = new String[segNum];
		if (str == null || str.length() == 0)
			return result;
		byte[] strByte;
		try {
			strByte = str.getBytes("GBK");
		} catch (UnsupportedEncodingException ex) {
			strByte = str.getBytes();
		}
		int pos = 0;
		for (int i = 0; i < segNum; i++) {
			int actLen = ((strByte.length - pos) < segLen) ? (strByte.length - pos) : segLen;
			byte[] b = new byte[actLen];
			System.arraycopy(strByte, pos, b, 0, actLen);
			result[i] = new String(b);
			pos += actLen;
			if (pos >= strByte.length)
				break;
		}
		return result;
	}
	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
	 * @param obj
	 * @return true or false
	 * @author chenjl
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			boolean empty = true;
			for (int i = 0; i < object.length; i++)
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			return empty;
		}
		return false;
	}
	
	/**
	 * 将集合用separator分割成string
	 * @param str
	 * @param separator
	 * @return
	 * @author chenjl
	 */
	public static String list2Str(Set<String> set, String separator) {
		StringBuilder bf=new StringBuilder();
		if(!isNullOrEmpty(set)){
			for (String str : set) {
				bf.append(str);
				bf.append(separator);
			}
		}
		String str="";
		if(!isNullOrEmpty(bf.toString())){
			str=bf.toString().substring(0,bf.toString().length()-1);
		}
		return str;
	}

	/**
	 * 将用separator分隔的String转化为List，如果str中没有separator则返回的List中只str
	 * @param str
	 * @param separator
	 * @return
	 * @author chenjl
	 */
	public static List str2List(String str, String separator) {
		List result = new ArrayList();
		if (str.indexOf(separator) < 0) {
			result.add(str);
		} else {
			String[] strArray = str.split(separator);

			for (int i = 0; i < strArray.length; i++) {
				result.add(strArray[i]);
			}
		}
		return result;
	}
	/**
	 * 	求两个集合的并集(利用HashSet数据源唯一性原则)
	 * @param comparedParams  要比对的数据
	 * @param sourceParams    源数
	 * @return
	 * @author chenjl
	 */
    public static String[] StringUnion (String[] comparedParams, String[] sourceParams){
        Set<String> hs = new HashSet<String>();
        for(String str:comparedParams){
            hs.add(str);
        }
        for(String str:sourceParams){
            hs.add(str);
        }
        String[] result={};
        return hs.toArray(result);
    }

    /**
   * 交集 
   * @description  注意结果集中若使用LinkedList添加，则�?要判断是否包含该元素，否则其中会包含重复的元�?
   * @param comparedParams 要比对的数据
   * @param sourceParams  源数
   * @return
   * @author chenjl
   */
    public static String[] intersect(String[] comparedParams, String[] sourceParams){
        List<String> l = new LinkedList<String>();
        Set<String> common = new HashSet<String>();                  
        for(String str:comparedParams){
            if(!l.contains(str)){
                l.add(str);
            }
        }
        for(String str:sourceParams){
            if(l.contains(str)){
                common.add(str);
            }
        }
        String[] result={};
        return common.toArray(result);
    }
    
    /**
     * 求两个数组的差集   
     * @param comparedParams
     * @param sourceParams
     * @return
     * @author chenjl
     */
    public static String[] substract(String[] comparedParams, String[] sourceParams) {   
        LinkedList<String> list = new LinkedList<String>();   
        for (String str : comparedParams) {   
            if(!list.contains(str)) {   
                list.add(str);   
            }   
        }   
        for (String str : sourceParams) {   
            if (list.contains(str)) {   
                list.remove(str);   
            } 
        }   
        String[] result = {};   
        return list.toArray(result);   
    }   
	
    /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
    	return UUID.randomUUID().toString(); 
    } 
    
    /**
     * 列表
     * @param tempList
     * @param charater 【返回格式】
     * @return
     */
    public static String spiltString(List<String> tempList,String charater){
    	if(!isNullOrEmpty(tempList)){
    		StringBuilder str = new StringBuilder();
    		for (String cityId : tempList) {
    			str.append(cityId+charater);
    		}
    		return str.toString();
    	}
    	return null;
	}
    /**
     * 判断List列表中的值是否一致
     * 
     * @author chenjl
     * @param list
     * @param charater
     * @return
     */
    public  static  boolean JudgeString(List<String> list,String charater){
    	if(!isNullOrEmpty(list)){
    		int listNum=list.size();
    		int temp=0;
    		for (String string : list) {
				if(string.equals(charater)){
					temp++;
				}
			}
    		if(temp==listNum){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 判断List列表中的值是只包含两个参数
     * 
     * @author chenjl
     * @param list
     * @param charater
     * @param charaters
     * @return
     */
    public  static  boolean JudgeStrings(List<String> list,String charater,String charaters){
    	if(!isNullOrEmpty(list)){
    		int listNum=list.size();
    		int temp=0;
    		for (String string : list) {
				if(string.equals(charater)||string.equals(charaters)){
					temp++;
				}
			}
    		if(temp==listNum){
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * 日期转换
     * @author chenjl
     * @param date
     * @param action 1 起始时间 2 终止时间
     * @return
     */
	public static Date convertDate(String date,String formate) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		Date dates =null;
		DateFormat format= new SimpleDateFormat(formate);
			try {
				dates=format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dates;
	}

	 /**
     * 日期转换
     * @author chenjl
     * @param date
     * @param action 0起始时间 1 终止时间
     * @return
     */
	public static Date convertDate(String date, int flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertDate(date,"yyyy-MM-dd"));
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		// 时分秒（毫秒数）
		long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000;
		// 凌晨00:00:00
		cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);
		if (flag == 0) {
			return cal.getTime();
		} else if (flag == 1) {
			// 凌晨23:59:59
			cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000);
		}
		return cal.getTime();
	}
	
	/**
	 *   java.util.Date date-》java.sql.Date
	 * 日期格式转换 
	 * @author chenjl
	 * @param date
	 * @return
	 */
	public  static java.sql.Date ConvertUtilDate( java.util.Date date){
		if(isNullOrEmpty(date)){
			return null;
		}
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * 把Date转为Timestamp 
	 * @param adate
	 * @return
	 */
	public static Timestamp date2Timestamp(Date date) {
		if(isNullOrEmpty(date)){
			return null;
		}
		return new Timestamp(date.getTime());
	}
	/**
	 * StringToTimestamp
	 * 	
     * 日期转换
     * 
	 * @param date
	 * @param action
	 * @return
	 */
	public static Timestamp StringToTimestamp(String date,Integer action){
		if(isNullOrEmpty(date)){
			return null;
		}
		return date2Timestamp(convertDate(date,action));
	}
	/**
	 * 把Timestamp转为 Date
	 * @author chenjl
	 * @param adate
	 * @return
	 */
	public static Date timestampToDate(Timestamp adate){
		if(isNullOrEmpty(adate)){
			return null;
		}
		return new Date(adate.getTime());
	}
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z" };  
  
  
public static String generateShortUuid() {  
    StringBuffer shortBuffer = new StringBuffer();  
    String uuid = UUID.randomUUID().toString().replace("-", "");  
    for (int i = 0; i < 8; i++) {  
        String str = uuid.substring(i * 4, i * 4 + 4);  
        int x = Integer.parseInt(str, 16);  
        shortBuffer.append(chars[x % 0x3E]);  
    }  
    return shortBuffer.toString();  
}  
public static StringBuilder mapToJson(Map<?, ?> map, StringBuilder sb) {  
    if (sb == null) sb = new StringBuilder();  
    sb.append("{");  
    Iterator<?> iter = map.entrySet().iterator();  
    while (iter.hasNext()) {   
        Entry<?, ?> entry = (Entry<?, ?>) iter.next();  
        String key = entry.getKey() != null ? entry.getKey().toString() : "";  
        sb.append("\""+stringToJson(key) + "\":");  
        Object o = entry.getValue();  
        if (o instanceof List<?>) {  
            List<?> l = (List<?>) o;  
            listToJson(l, sb);  
        } else if (o instanceof Map<?, ?>) {  
            Map<?, ?> m = (Map<?, ?>) o;  
            mapToJson(m, sb);  
        } else {  
            String val = entry.getValue() != null ? entry.getValue().toString() : "";  
            sb.append("\"" + stringToJson(val) + "\"");  
        }  
        if (iter.hasNext()) sb.append(",");  
    }  
    sb.append("}");  
    return sb;  
}  
/** 
 * 将list转为json 
 * @param lists 
 * @param sb 
 * @return 
 */  
public static StringBuilder listToJson(List<?> lists, StringBuilder sb) {  
    if (sb == null) sb = new StringBuilder();  
    sb.append("[");  
    for (int i = 0; i < lists.size(); i++) {  
        Object o = lists.get(i);  
        if (o instanceof Map<?, ?>) {  
            Map<?, ?> map = (Map<?, ?>) o;  
            mapToJson(map, sb);  
        } else if (o instanceof List<?>) {  
            List<?> l = (List<?>) o;  
            listToJson(l, sb);  
        } else {  
            sb.append("\"" + o + "\"");  
        }  
        if (i != lists.size() - 1) sb.append(",");  
    }  
    sb.append("]");  
    return sb;  
}  
/** 
 * 将字符串转为json数据 
 * @param str 数据字符串 
 * @return json字符串 
 */  
private static String stringToJson(String str) {    
    StringBuffer sb = new StringBuffer();    
    for (int i = 0; i < str.length(); i++) {    
        char c = str.charAt(i);    
        switch (c) {    
            case '\"':    
                sb.append("\\\"");    
                break;    
            case '\\':    
                sb.append("\\\\");    
                break;    
            case '/':    
                sb.append("\\/");    
                break;    
            case '\b':    
                sb.append("\\b");    
                break;    
            case '\f':    
                sb.append("\\f");    
                break;    
            case '\n':    
                sb.append("\\n");    
                break;    
            case '\r':    
                sb.append("\\r");    
                break;    
            case '\t':    
                sb.append("\\t");    
                break;    
            default:    
                sb.append(c);    
        }    
    }    
    return sb.toString();    
}  

/**
 * 
 * Function: 日期排序
 * 
 * @author chenjl
 * @param a
 * @return
 * @date 2017年6月28日
 * @version 1.1
 */
private Date[] dateSort(Date[] a) {
	int len = a.length;
	for (int i = len - 1; i >= 1; i--) {
		for (int j = 0; j <= i - 1; j++) {
			if (a[j].after((a[j + 1]))) {
				Date temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		}
	}
	return a;
}
}
