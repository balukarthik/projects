package com.balukarthik.cryptography;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

public class AsymmetricCryptographyTest {

  @Test
    public void testAsymmetricCryptography() 
    {

      try {
        AsymmetricCryptography ac = new AsymmetricCryptography(); 
        PrivateKey privateKey = ac.getPrivate("src/test/resources/KeyPair/privateKey");
      PublicKey publicKey = ac.getPublic("src/test/resources/KeyPair/publicKey");

      String msg = "Cryptography is fun!";
      String encrypted_msg = ac.encryptText(msg, privateKey);
      String decrypted_msg = ac.decryptText(encrypted_msg, publicKey);
      System.out.println("Original Message: " + msg + "\nEncrypted Message: " + encrypted_msg +         "\nDecrypted Message: " + decrypted_msg);

      if(new File("src/test/resources/KeyPair/text.txt").exists()){
        ac.encryptFile(ac.getFileInBytes(new File("src/test/resources/KeyPair/text.txt")), 
                       new File("src/test/output/KeyPair/text_encrypted.txt"), privateKey);
        ac.decryptFile(ac.getFileInBytes(new File("src/test/output/KeyPair/text_encrypted.txt")), 
                       new File("src/test/output/KeyPair/text_decrypted.txt"), publicKey);
      }else{
        System.out.println("Create a file text.txt under folder KeyPair");
      }
      }
      catch (Exception e)
      {
        e.printStackTrace();
        fail("Caught Exception");
      }
    }   
}   
  

