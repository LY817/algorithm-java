package org.ly817.learn.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author LY
 * @date 2021/08/26 10:50
 * <p>
 * Description:
 */
public class HmacHashTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("SHA-256","/11/11w/we2e"));
    }


    public static String hash(String algorithm, String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHexString(messageDigest.digest());
    }
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length);
        byte[] var3 = bytes;
        int var4 = bytes.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte aByte = var3[var5];
            String temp = Integer.toHexString(255 & aByte);
            if (temp.length() < 2) {
                sb.append(0);
            }

            sb.append(temp);
        }

        return sb.toString();
    }
}
