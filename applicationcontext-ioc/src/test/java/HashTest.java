import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : Vander
 * @date :   2020/12/13
 * @description :
 */
public class HashTest {

    @Test
    public void testHashBySHA1() {
        String str = "20200520113120256123456789012345";
        try {
            //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            //信息摘要是安全的单向哈希函数，它接收 任意大小的数据，并输出固定长度的哈希值。
            //MessageDigest 对象开始被初始化。
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            //通过使用 update 方法处理数据
            mDigest.update(str.getBytes());
            //调用 digest 方法之一完成哈希计算同时将Byte数组转换成16进制
            byte[] resultBytes = mDigest.digest();
            int result = resultBytes[0] & 0x1;
            System.out.println(result);
            System.out.println(bytesToHexString(resultBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHashByMD5() {
        String str = "emwmnlalwrasfieldfgnglsfngwunglt";
        try {
            //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            //信息摘要是安全的单向哈希函数，它接收 任意大小的数据，并输出固定长度的哈希值。
            //MessageDigest 对象开始被初始化。
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            //通过使用 update 方法处理数据
            mDigest.update(str.getBytes());
            //调用 digest 方法之一完成哈希计算同时将Byte数组转换成16进制
            byte[] resultBytes = mDigest.digest();
            System.out.println(bytesToHexString(resultBytes));//ff787814a62990c0f77cbb31f2a27d79
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串转换为十六进制形式
     *
     * @param bytes 待转换字符串数组
     * @return 转换后的十六进制字符串
     */
    public static String bytesToHexString(byte[] bytes) {
        byte tb;
        char low;
        char high;
        char tmpChar;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            tb = bytes[i];
            tmpChar = (char) ((tb >>> 4) & 0x000f);
            if (tmpChar >= 10) {
                high = (char) (('a' + tmpChar) - 10);
            } else {
                high = (char) ('0' + tmpChar);
            }
            str.append(high);
            tmpChar = (char) (tb & 0x000f);
            if (tmpChar >= 10) {
                low = (char) (('a' + tmpChar) - 10);
            } else {
                low = (char) ('0' + tmpChar);
            }
            str.append(low);
        }
        return str.toString();
    }

}
