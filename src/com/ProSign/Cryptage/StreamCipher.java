package  com.ProSign.Cryptage;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.*;
public class StreamCipher
{
        private final static String cleSecrete = "ilovejava";
        private final static String algorythme = "RC4";
        private final static Key cle = new SecretKeySpec(cleSecrete.getBytes(), algorythme);

   /*     public static void main(String[] args)
        {
                String texteCrypte = encrypte("javatropbien");
                //System.out.println(texteCrypte); //imprime "Äj•y§„ :Õ°Äó"

                String texteEnClair = decrypte(texteCrypte);
                //System.out.println(texteEnClair); //imprime "javatropbien"
        }/*/

        public static String encrypte(String texteEnClair)
        {
            Provider sunJce=new com.sun.crypto.provider.SunJCE();
            Security.addProvider(sunJce);
                Cipher cipher = null;
                try
                {
                        cipher = Cipher.getInstance(algorythme,sunJce);
                }
                catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                catch (NoSuchPaddingException e) {
                    e.printStackTrace();}

                try
                {
                        cipher.init(Cipher.ENCRYPT_MODE, cle);
                }
                catch (InvalidKeyException e) {e.printStackTrace();}

                byte[] texteCrypte = null;
                try
                {
                        texteCrypte = cipher.doFinal(texteEnClair.getBytes());
                }
                catch (IllegalBlockSizeException e) {e.printStackTrace();}
                catch (BadPaddingException e) {e.printStackTrace();}

                return new String(texteCrypte);
        }

        public static String decrypte(String texteCrypte)
        {
                Cipher cipher = null;
                try
                {
                        cipher = Cipher.getInstance(algorythme);
                }
                catch (NoSuchAlgorithmException e) {e.printStackTrace();}
                catch (NoSuchPaddingException e) {e.printStackTrace();}

                try
                {
                        cipher.init(Cipher.DECRYPT_MODE, cle);
                }
                catch (InvalidKeyException e) {e.printStackTrace();}

                byte[] texteEnClair = null;

                try
                {
                        texteEnClair = cipher.doFinal(texteCrypte.getBytes());
                }
                catch (IllegalBlockSizeException e)	{e.printStackTrace();}
                catch (BadPaddingException e) {e.printStackTrace();}

                return new String(texteEnClair);
        }
}
