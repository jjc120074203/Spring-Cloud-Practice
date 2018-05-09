package org.spring.cloud.common.utils;

/**
 * 生成手机验证码
 * @author husong
 *
 */
public class StringHandleUtils
{
    /**
     * 生成随机字符串
     * 
     * @param position 字符串位数
     * @param type 生成类型 0、数字+字母 1、字母 2、数字
     * @return
     */
    public static String generationStringRadom(Integer position, int type)
    {
        if (null == position || position <= 0)
        {
            position = 4;
        }
        if (type > 2 || type < 0)
        {
            type = 0;
        }
        String result = "";
        for (int i = 0; i < position; i++)
        {
            int intVal = 0;
            double random = Math.random();
            if (type == 0)
            {
                if (((int) (random * 10) % 2) > 0)
                {
                    intVal = (int) (Math.random() * 26 + 97);
                }
                else
                {
                    intVal = (int) (Math.random() * 10 + 48);
                }
            }
            else if (type == 1)
            {
                intVal = (int) (Math.random() * 26 + 97);
            }
            else if (type == 2)
            {
                intVal = (int) (Math.random() * 10 + 48);
            }

            result = result + (char) intVal;
        }
        return result;
    }

//    public static void main(String[] args)
//    {
//        System.out.println(StringHandleUtils.generationStringRadom(6, 0));
//    }
}
