package test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * @author leejalen
 * @Description 测试AES对称加密算法
 * AES算法的密钥长度为128或192或256
 * Blowfish算法的密钥长度为8的整数倍（范围是32-448）
 * Created on 2020/11/16
 */
public class TestAES {

    private static final String ALGORITHM_AES = "AES";

    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

    private static final Integer IVSize=16;

    private static final String SecretKey="debug";

    private static final String Encode="UTF-8";

    private static final int KEY_LENGTH_128_BIT = 128;

    /**
     * 生成密钥
     * */
    public static byte[] getKey() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM_AES);
        keygen.init(KEY_LENGTH_128_BIT);
        SecretKey secretKey = keygen.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 加密
     * @param enfile 要加密的文件
     * @param defile 加密后的文件
     * @param key 密钥
     * @throws Exception
     */
    public static void encrypt(String enfile, String defile, byte[] key) throws Exception {
        // 根据给定的字节数组构造一个密钥。
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM_AES);
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        // 用密钥初始化此 cipher
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, createIV(key));

        FileInputStream in = new FileInputStream(enfile);
        OutputStream out = new FileOutputStream(defile);
        CipherInputStream cin = new CipherInputStream(in, cipher);

        byte[] buffer = new byte[1024];
        int i;
        while ((i = cin.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        out.close();
        cin.close();
    }

    // 解密
    public static void decrypt(String file, String defile, byte[] key) throws Exception {
        // 根据给定的字节数组构造一个密钥。
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM_AES);
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        // 用密钥初始化此 cipher
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, createIV(key));

        byte[] buffer = new byte[1024];
        FileInputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(defile);
        CipherOutputStream cout = new CipherOutputStream(out, cipher);
        int i;
        while ((i = in.read(buffer)) != -1) {
            cout.write(buffer, 0, i);
        }
        cout.close();
        in.close();
    }

    private static IvParameterSpec createIV(byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM_AES);
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

    public static void main(String[] args) {
        /*try {
            byte[] key = getKey();
            for (int i = 0; i < key.length; i++) {
                System.out.println(key[i]);
            }
            System.out.println("================================");
            IvParameterSpec ivParameterSpec = createIV(key);
            byte[] b = ivParameterSpec.getIV();
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            byte[] key = getKey();
            // 文件加密
            encrypt("D:\\testPackage\\test00.txt", "D:\\testPackage\\encrypt\\test10.txt", key);
            System.out.println("加密完成");

            // 文件解密
            decrypt("D:\\testPackage\\encrypt\\test10.txt", "D:\\testPackage\\decrypt\\test10.txt", key);
            System.out.println("解密完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
