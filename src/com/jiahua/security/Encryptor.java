package com.jiahua.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/**
 * Created by yu on 10/12/14.
 */
public class Encryptor {

    public static final String ENCRYPTION_KEY = "jiahua7890123456";

    public static byte[] encrypt(String key, String value)
            throws GeneralSecurityException {

        byte[] raw = key.getBytes(Charset.forName("US-ASCII"));
        if (raw.length != 16) {
            throw new IllegalArgumentException("Invalid key size.");
        }

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec,
                new IvParameterSpec(new byte[16]));
        return cipher.doFinal(value.getBytes(Charset.forName("US-ASCII")));
    }
}
