package org.spring.cloud.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * Description:订单号生成工具 ,生成非重复订单号，
 *    理论上限1毫秒1000个，可扩展
 * </p>
 * 
 * @author chenjl
 * @date 2017-03-09
 * @version 1.0
 */
public class CodeNumBuilder {
	
	/** 
     * 锁对象，可以为任意对象 
     */  
    private static Object lockObj = "lockerOrder"; 
    
    private static long orderNumCount = 0L;
    
    /** 
     * 每毫秒生成订单号数量最大值 
     */  
    private static int maxPerMSECSize=1000; 
    
    /** 
     * 生成非重复订单号，理论上限1毫秒1000个，可扩展 
     * @param headCode  拼接名称yyyyMMddHHmmssSSS
     * @param 长度格式  严格按照改 
     */  
    public  static String makeOrderNum(String headCode,String timePattern) {  
    	   // 最终生成的订单号  
        String finOrderNum = "";  
    	try {  
            synchronized (lockObj) {  
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒  
                long nowLong = Long.parseLong(new SimpleDateFormat(timePattern).format(new Date()));  
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万  
                if (orderNumCount >=maxPerMSECSize) {  
                    orderNumCount = 0L;  
                }  
                //组装订单号  
                String countStr=maxPerMSECSize +orderNumCount+"";  
                finOrderNum=nowLong+countStr.substring(1);  
                orderNumCount++;  
                return headCode+finOrderNum;
                // Thread.sleep(1000);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            return finOrderNum;
        }  
    }  
}
