package cn.edu.jit.wdnv.java.sims.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author abel
 * @date 2022/3/9
 * @apinote MD5加密
 */
public interface  Encryptor {

  static String bytetoString(byte[] digest) {

        String str = "";
        String tempStr = "";
        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            }
            else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();

    }
    static String MD5Encrypt(String inStr) {

        MessageDigest md = null;
        String outStr = null;
        try {

            md = MessageDigest.getInstance("MD5");        //可以选中其他的算法如SHA
            byte[] digest = md.digest(inStr.getBytes());
            //返回的是byte[]，要转化为String存储比较方便
            outStr = bytetoString(digest);
        }
        catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }


}
