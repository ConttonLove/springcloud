package com.dtl.common.encrypt;

import java.security.MessageDigest;

/**
 * Created by linjun on 2017/2/20 0020.
 */
public class MD5Util {

    public static boolean validPasswd(String oriPass, String pass) {
        return MD5Util.getMD5(oriPass).equals(pass);
    }


    /***
     * MD5加码 生成32位md5码
     */
    public static String getMD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        int s1 = charArray.length;
        for (int i = 0; i < s1; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        int s2 = md5Bytes.length;
        for (int i = 0; i < s2; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
}
