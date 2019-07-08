/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author SHABAAN
 */
public class Encryption {

    private static SecretKeySpec spec;
    private static byte[] key;

    public void encryption(int cipherMode, String key, File inputFile, File outputFile){
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            
            byte[] outputBytes = cipher.doFinal(inputBytes);
            
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
            
            inputStream.close();
            outputStream.close();
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | FileNotFoundException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void setKey(String mkey) {
        MessageDigest msg = null;
        
        try {
            key = mkey.getBytes("UTF-8");
            msg = MessageDigest.getInstance("SHA-1");
            key = msg.digest(key);
            key = Arrays.copyOf(key, 16);
            spec = new SecretKeySpec(key, "AES"); //advance encryption standard

            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String Encrypt(String strToEncypt, String secret) {
        try {
            setKey(secret);
            Cipher cp = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cp.init(Cipher.ENCRYPT_MODE, spec);

            return Base64.getEncoder().encodeToString(cp.doFinal(strToEncypt.getBytes("UTF-8")));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String Decrypt(String strToDecrypt, String secret){
        try {
            setKey(secret);
            Cipher cp = Cipher .getInstance("AES/ECB/PKCS5PADDING");
            cp.init(Cipher.DECRYPT_MODE, spec);
            return new String(cp.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public static void main(String[] args) {

        final String SecretKey = "&()(:hdhdhhydobafhu%^";
        String origianlString =  "Maseno Maseno Maseno";
        //String encryptedString = Encrypt(origianlString,SecretKey);
        
        //String decryptedString = Decrypt(encryptedString, SecretKey);
        
        //System.out.println(encryptedString);
        //System.out.println(decryptedString);
        
        String publicKey = "hdhdhhydobafhu%^";
        File inputFile = new File("src/database/MessageChat.db");
        File encrptedFile = new File("src/database/MessageChat.db.enc");
        File dencrptedFile = new File("src/database/MessageChat.db");
        
        Encryption encryption = new Encryption();
        encryption.encryption(Cipher.ENCRYPT_MODE, publicKey, inputFile, encrptedFile);
        encryption.encryption(Cipher.DECRYPT_MODE, publicKey, encrptedFile, dencrptedFile);
    }
}
