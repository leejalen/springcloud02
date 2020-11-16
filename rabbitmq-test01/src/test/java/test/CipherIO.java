package test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

/**
 * @author leejalen
 * @Description
 * Created on 2020/11/16
 */
public class CipherIO {

    private static final String Algorithm = "AES"; // 定义 加密算法,可用DES,DESede,Blowfish

    private static final String CIPHER_ALGORITHM_CBC = "AES/ECB/PKCS5Padding";
    // static {
    // Security.addProvider(new com.sun.crypto.provider.SunJCE());
    // }

    // 生成密钥, 注意此步骤时间比较长
    public static byte[] getKey() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
        keygen.init(128);
        /*keygen.init(new SecureRandom());*/
        SecretKey deskey = keygen.generateKey();
        return deskey.getEncoded();
    }

    /**
     * 加密
     *
     * @param enfile
     *            要加密的文件
     * @param defile
     *            加密后的文件
     * @param key
     *            密钥
     * @throws Exception
     */
    public static void encode(String enfile, String defile, byte[] key)
            throws Exception {
        // 秘密（对称）密钥(SecretKey继承(key))
        // 根据给定的字节数组构造一个密钥。
        SecretKey deskey = new SecretKeySpec(key, Algorithm);
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作
        Cipher c = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        // 用密钥初始化此 cipher
        c.init(Cipher.ENCRYPT_MODE, deskey);

        byte[] buffer = new byte[1024];
        FileInputStream in = new FileInputStream(enfile);
        OutputStream out = new FileOutputStream(defile);

        CipherInputStream cin = new CipherInputStream(in, c);
        int i;
        while ((i = cin.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        out.close();
        cin.close();
    }

    // 解密
    public static void decode(String file, String defile, byte[] key)
            throws Exception {

        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        SecretKey deskey = new SecretKeySpec(key, Algorithm);
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作
        Cipher c = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        // 用密钥初始化此 cipher
        c.init(Cipher.ENCRYPT_MODE, deskey);

        byte[] buffer = new byte[1024];
        FileInputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(defile);
        CipherOutputStream cout = new CipherOutputStream(out, c);
        int i;
        while ((i = in.read(buffer)) != -1) {
            cout.write(buffer, 0, i);
        }
        cout.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {
        byte[] key = getKey();
        System.out.println("生成" +  key.length + "位密钥");
        for (int i = 0; i < key.length; i++) {
            System.out.println(key[i]);
        }
        // 字节数必须是8的整数倍
        /*byte[] key = new byte[] { 49, 38, -88, -75, 103, -50, 94, -92 }; */
        // 文件加密
        encode("D:\\testPackage\\test00.txt", "D:\\testPackage\\encrypt\\test10.txt", key);
        System.out.println("加密完成");
        // 文件解密
        decode("D:\\testPackage\\encrypt\\test10.txt", "D:\\testPackage\\decrypt\\test10.txt", key);
        System.out.println("解密完成");
    }
}
