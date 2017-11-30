package com.balukarthik.cryptography;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class GenerateKeysTest 
{
  @Test
    public void testGenerateKeys() 
    {
      GenerateKeys gk;
      try 
      {
        gk = new GenerateKeys(1024);
        gk.createKeys();
        gk.writeToFile("src/test/output/KeyPair/publicKey", gk.getPublicKey().getEncoded());
        gk.writeToFile("src/test/output/KeyPair/privateKey", gk.getPrivateKey().getEncoded());
      } catch (NoSuchAlgorithmException | NoSuchProviderException e) 
      {
        System.err.println(e.getMessage());
      } catch (IOException e) 
      {
        System.err.println(e.getMessage());
      }   
    }   
}
