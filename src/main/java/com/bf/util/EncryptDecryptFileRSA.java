package com.bf.util;

import org.apache.commons.io.FileUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.security.*;
class MyRSACipher {
    public static KeyPair getRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        return kp;
    }
    public static byte[] encryptFile(byte[] inputBytes, PublicKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(inputBytes);
    }
    public static byte[] decryptFile(byte[] inputBytes, PrivateKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(inputBytes);
    }
}
public class EncryptDecryptFileRSA {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String fileToEncrypt = "D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\Encrypt-Decrypt-File-RSA\\original-file";
        String encryptedFile = "D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\Encrypt-Decrypt-File-RSA\\file-after-encryption";
        String decryptedFile = "D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\Encrypt-Decrypt-File-RSA\\file-after-decryption";
        // Generate a key-pair
        KeyPair keyPari = MyRSACipher.getRSAKeyPair();
        PublicKey publicKey = keyPari.getPublic();
        PrivateKey privatekey = keyPari.getPrivate();
        File file = new File(fileToEncrypt);
        byte[] dataBytes = FileUtils.readFileToByteArray(file);
        // Encrypt the file
        String algo = "RSA/ECB/PKCS1Padding";
        byte[] encryptedBytes = MyRSACipher.encryptFile(dataBytes, publicKey, algo);
        file = new File(encryptedFile);
        FileUtils.writeByteArrayToFile(file, encryptedBytes);
        System.out.println("Encrypted file : " + encryptedFile);
        // Decrypt the file
        byte[] decryptedBytes = MyRSACipher.decryptFile(encryptedBytes, privatekey, algo);
        file = new File(decryptedFile);
        FileUtils.writeByteArrayToFile(file, decryptedBytes);
        System.out.println("Decrypted file : " + decryptedFile);
    }
}