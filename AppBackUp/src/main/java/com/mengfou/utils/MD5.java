package com.mengfou.utils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author 梦否
 * @date 2022/05/06 12:25
 */
public class MD5 {
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) resultSb.append(byteToHexString(value));
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 返回大写MD5
     *
     * @param origin
     * @return
     */
    private static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ignored) {
        }
        assert resultString != null;
        return resultString.toUpperCase();
    }

    //MD5加盐
    public static String MD5EncodeUtf8(String origin) {
        origin = origin + PropertiesUtil.getProperty("salt", "");
        return MD5Encode(origin);
    }


    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

}
