package com.ProSign.Cryptage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author xavier
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cryptage
{
        private Key clef;
        private String cle;
        private byte[] passwordInBytes;

        public Cryptage(String cle)
        {
                try
                {
                        //passwordInBytes = cle.getBytes("ISO-8859-2");
                        //passwordInBytes = cle.getBytes("UTF8");
                        passwordInBytes = cle.getBytes("ISO-8859-2");
                        clef=new SecretKeySpec(passwordInBytes,"Blowfish");

                } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }

        public byte[] getSecretKeyInBites()
        {
                return clef.getEncoded();
        }

        public byte[] cryptageString(String txt)
        {
                return cryptageByte(txt.getBytes());
        }
        public byte[] cryptageByte(byte[] txt)
        {
                try
                {
                        Cipher cipher=Cipher.getInstance("Blowfish");

                        cipher.init(Cipher.ENCRYPT_MODE,clef);
                        return cipher.doFinal(txt);
                }
                catch (Exception e)
                {
                        return null;
                }

        }
        public byte[] decryptageInByte(byte[] txt)
        {
                try
                {
                        Cipher cipher=Cipher.getInstance("Blowfish");
                        cipher.init(Cipher.DECRYPT_MODE,clef);
                        return cipher.doFinal(txt);
                }
                catch (Exception e)
                {
                        //System.out.println(e);
                        return null;
                }

        }



        public String decryptageInString(byte[] txt)
        {
                return new String(decryptageInByte(txt));
        }


        public static byte[] toBytes(String object){
              java.io.ByteArrayOutputStream baos = new
              java.io.ByteArrayOutputStream();
              try{
              java.io.ObjectOutputStream oos = new
              java.io.ObjectOutputStream(baos);
              oos.writeObject(object);
              }catch(java.io.IOException ioe){
              java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE,
              ioe.getMessage());
              }
              return baos.toByteArray();
              }


              public static Object toObject(byte[] bytes){
Object object = null;
try{
object = new java.io.ObjectInputStream(new
java.io.ByteArrayInputStream(bytes)).readObject();
}catch(java.io.IOException ioe){
java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE,
ioe.getMessage());
}catch(java.lang.ClassNotFoundException cnfe){
java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE,
cnfe.getMessage());
}
return object;
}

}
