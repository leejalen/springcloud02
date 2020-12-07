package test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/16
 */
public class TestAES02 {

    private static final String ALGORITHM_AES = "AES";

    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

    private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS7Padding";

    private static final Integer IVSize = 16;

    private static final String SecretKey = "debug";

    private static final String Encode = "UTF-8";

    private static final int KEY_LENGTH_128_BIT = 128;

    /**
     * 生成密钥
     */
    private static Key createKey() {
        try {
            // 构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_AES);
            // 生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(KEY_LENGTH_128_BIT);
            // 产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
            // key转换,根据字节数组生成AES密钥
            return new SecretKeySpec(keyBytes, ALGORITHM_AES);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CipherInputStream encrypt(String inFilePath, Key key) {
        CipherInputStream cIn = null;
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.ENCRYPT_MODE, key, createIV(key));

            FileInputStream in = new FileInputStream(inFilePath);
            cIn = new CipherInputStream(in, cipher);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return cIn;
    }

    private static CipherOutputStream decrypt(String outFilePath, Key key) {
        CipherOutputStream cOut = null;
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.DECRYPT_MODE, key, createIV(key));

            FileOutputStream out = new FileOutputStream(outFilePath);
            cOut = new CipherOutputStream(out, cipher);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return cOut;
    }

    public static void outEncryptFile(Key key, String inFilePath, String encryptFilePath){
        CipherInputStream cIn = encrypt(inFilePath, key);
        try {
            System.out.println(cIn.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(encryptFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i;
        byte[] buffer = new byte[1024];
        try {
            while ((i = cIn.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            cIn.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("加密完成");
    }

    public static void outDecryptFile(Key key, String inFilePath, String decryptFilePath){
        CipherOutputStream cOut = decrypt(decryptFilePath, key);
        FileInputStream in = null;

        try {
            in = new FileInputStream(inFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i;
        byte[] buffer = new byte[1024];
        try {
            while ((i = in.read(buffer)) != -1) {
                cOut.write(buffer, 0, i);
            }
            cOut.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("解密完成");
    }

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

    public static void main(String[] args) throws IOException {
        Key key = createKey();
        String inFilePath = "D:\\testPackage\\test00.txt";
        String encryptFilePath = "D:\\testPackage\\encrypt\\test10.txt";
        String decryptFilePath = "D:\\testPackage\\decrypt\\test10.txt";

        File file = new File(encryptFilePath);
        long length = file.length();
        System.out.println("文件长度" + length);
//
//        InputStream fileInputStream = new FileInputStream(inFilePath);
//        System.out.println("文件流长度" + fileInputStream.available());
//
        CipherInputStream cipherInputStream = encrypt(inFilePath, key);

        System.out.println("加密后文件流长度" + cipherInputStream.available());
//
//        String keyStr1 = Base64.getEncoder().encodeToString(key.getEncoded());
//        System.out.println(keyStr1);
//
//        String keyStr2 = new BASE64Encoder().encode(key.getEncoded());
//        System.out.println(keyStr2);
        /*outEncryptFile(key, inFilePath, encryptFilePath);*/

        /*outDecryptFile(key, encryptFilePath, decryptFilePath);*/
    }
}
