package com.msts.hostel.util;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordUtil {

    private static final String secretKey = "I AM SUPER HERO";
    private static final String salt = KeyGenerators.string().generateKey();

    public static String stringBase64Encoder(String value) {
        return Base64.getEncoder().encodeToString(
                value.getBytes(StandardCharsets.UTF_8));
    }

    public static String stringBase64Decoder(String encodedString) {
        byte[] decodedByteArray = Base64.getDecoder().decode(encodedString);
        return new String(decodedByteArray);
    }

    public static String encryptPassword(String password) {
        TextEncryptor encryptor = Encryptors.text(secretKey, salt);
        return encryptor.encrypt(password);
    }

    public static String decryptPassword(String encryptedPassword) {
        TextEncryptor decryptor = Encryptors.text(secretKey, salt);
        return decryptor.decrypt(encryptedPassword);
    }
}
