package com.paper.question.common.util;

import com.paper.question.common.base.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 */
public class Md5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class);


    /**
     * 字符串md5值，默认32位，大写
     * null：加密失败
     */
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] byteData = md.digest();

            return getMd5(byteData);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("计算Md5值出错", e);
            throw new SystemException(e);
        }
    }

    /**
     * 字符串md5值，16位，大写
     * null：加密失败
     */
    public static String md5_16(String input) {
        String md5 = md5(input);
        return getMd5_16(md5);
    }

    /**
     * 文件md5值，32位，大写
     * null：加密失败
     */
    public static String file2md5(InputStream inputStream) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] dataBytes = new byte[1024];
            int nread;
            while ((nread = inputStream.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }

            byte[] mdbytes = md.digest();

            return getMd5(mdbytes);
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.error("计算Md5值出错", e);
            throw new SystemException(e);
        }
    }

    /**
     * 文件md5值，16位，大写
     * null：加密失败
     */
    public static String file2md5_16(InputStream inputStream) {
        String md5 = file2md5(inputStream);
        return getMd5_16(md5);
    }

    private static String getMd5_16(String md5) {
        return md5.substring(8, 24);
    }

    private static String getMd5(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
