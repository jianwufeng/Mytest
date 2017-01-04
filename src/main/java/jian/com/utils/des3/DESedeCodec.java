package jian.com.utils.des3;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;

/**
 * Desc: 3DES加密算法 模式“DESede/ECB/PKCS5Padding” Date: 15-5-29 User: 周彬
 */
public class DESedeCodec {

    public static final String KEY_ALGORITHM = "DESede";
    public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 生成密钥
     */
    public static String initkey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(168);
        SecretKey secretKey = kg.generateKey();
        return Base64.encodeBase64String(secretKey.getEncoded());
    }

    /**
     * 转换密钥
     */
    private static Key toKey(byte[] key) throws Exception {
        DESedeKeySpec dks = new DESedeKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    /**
     * 加密数据
     * 
     * @param data 待加密数据
     * @param key 密钥
     * @return 加密后的数据
     */
    public static String encrypt(String data, String key) throws Exception {
        // Key k = toKey(Base64.decodeBase64(key));
        Key k = toKey(key.getBytes(Charsets.UTF_8));// 24位
        // Key k = toKey(key.getBytes()); // 24位
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * 解密数据
     * 
     * @param data 待解密数据
     * @param key 密钥
     * @return 解密后的数据
     */
    public static String decrypt(String data, String key) throws Exception {
        // Key k = toKey(Base64.decodeBase64(key));
        // Key k = toKey(key.getBytes()); // 24位
        Key k = toKey(key.getBytes(Charsets.UTF_8));// 24位
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

    public static void main(String[] args) {
        try {
            // String enStr=encrypt("13811261662", "rk8CPgENsKcHDRoIv2HW0G6nDtC6hiBS");
            String enStr = encrypt("Xingjianhong", "rk8CPgENsKcHDRoIv2HW0G6n");
            System.out.println(enStr);
            // System.out.println(decrypt("mIgUvmW5jQwKxhNgL+DJ4w==", "rk8CPgENsKcHDRoIv2HW0G6nDtC6hiBS"));
            System.out.println(decrypt("t5o2nlJhydWsqSiLXHsF2Q==", "rk8CPgENsKcHDRoIv2HW0G6n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
