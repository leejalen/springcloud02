package test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/16
 */
public class TestAES01 {

    private static final String ALGORITHM_AES = "AES";

    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

    private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";

    private static final Integer IVSize=16;

    private static final String SecretKey="debug";

    private static final String Encode="UTF-8";

    private static final int KEY_LENGTH_128_BIT = 128;

    private static IvParameterSpec createIV(Key key) {
        SecretKey secretKey = (SecretKey)key;
        StringBuffer sb = new StringBuffer(IVSize);
        sb.append(secretKey);
        if (sb.length()>IVSize){
            sb.setLength(IVSize);
        }
        if (sb.length()<IVSize){
            while (sb.length()<IVSize){
                sb.append("0");
            }
        }
        byte[] data=null;
        try {
            data=sb.toString().getBytes(Encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new IvParameterSpec(data);
    }

    public static byte[] encrypt(String data, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(data.getBytes());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private static byte[] decrypt(byte[] result, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private static Key createKey() {
        try {
            // 生成key
            KeyGenerator keyGenerator;
            // 构造密钥生成器，指定为AES算法,不区分大小写
            keyGenerator = KeyGenerator.getInstance("AES");
            // 生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(128);
            // 产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
            // key转换,根据字节数组生成AES密钥
            return new SecretKeySpec(keyBytes, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String data = "hello Test symmetric encry";
        Key key = createKey();
        byte[] encryData = encrypt(data, key);
        System.out.println("encryData = " + new String(encryData));
        byte[] decryData = decrypt(encryData, key);
        System.out.println("decryData = " + new String(decryData));
    }
}
