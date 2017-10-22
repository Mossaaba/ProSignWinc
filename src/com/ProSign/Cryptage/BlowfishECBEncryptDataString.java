package  com.ProSign.Cryptage;


import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import sun.misc.*;

public class BlowfishECBEncryptDataString
{
    static public class EncryptionException extends Exception
    {
        private EncryptionException(String text, Exception chain)
        {
            super(text, chain);
        }
    }

    private static final String ALGORITHM = "Blowfish";

    public BlowfishECBEncryptDataString(byte[] keyBytes, String characterEncoding) throws EncryptionException
    {
        assert (keyBytes != null) && (keyBytes.length == 8);
        assert (characterEncoding != null);

        try
        {
            SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM);
            this.characterEncoding = characterEncoding;
            this.encryptCipher = Cipher.getInstance(ALGORITHM + "/ECB/PKCS5Padding", "SunJCE");
            this.encryptCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
            this.decryptCipher = Cipher.getInstance(ALGORITHM + "/ECB/PKCS5Padding", "SunJCE");
            this.decryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
        }
        catch (Exception e)
        {
            throw new EncryptionException("Problem constucting " + this.getClass().getName(), e);
        }
    }

    synchronized public String encrypt(String dataString) throws EncryptionException
    {
        assert dataString != null;

        try
        {
            byte[] dataStringBytes = dataString.getBytes(characterEncoding);
            byte[] encryptedDataStringBytes = this.encryptCipher.doFinal(dataStringBytes);
            String encodedEncryptedDataString = this.base64Encoder.encode(encryptedDataStringBytes);
            return encodedEncryptedDataString;
        }
        catch (Exception e)
        {
            throw new EncryptionException("Problem encrypting string", e);
        }
    }

    synchronized public String decrypt(String encodedEncryptedDataString) throws EncryptionException
    {
        try
        {
            byte[] encryptedDataStringBytes = this.base64Decoder.decodeBuffer(encodedEncryptedDataString);
            byte[] dataStringBytes = this.decryptCipher.doFinal(encryptedDataStringBytes);
            String dataString = new String(dataStringBytes, characterEncoding);
            return dataString;
        }
        catch (Exception e)
        {
            throw new EncryptionException("Problem decrypting string", e);
        }
    }

 /*   public static void main(String[] args)
    {
        try
        {
            // Make sure SUN are a valid provider
            Security.addProvider(new com.sun.crypto.provider.SunJCE());

            // This could be read from a file.
            final byte[] keyBytes = "01234567".getBytes("ASCII");

            // Data string encrypt agent that assumes the data string is only ASCII characters
            BlowfishECBEncryptDataString dataStringEncryptAgent = new BlowfishECBEncryptDataString(keyBytes, "UTF-8");

            // Get the data string to encrypt from the command line
            String dataString = (args.length == 0)? "The quick brown fox jumps over the lazy dog." : args[0];
            //System.out.println("Data string ....................[" + dataString + "]");

            String encodedEncryptedDataString = dataStringEncryptAgent.encrypt(dataString);
            //System.out.println("Encoded encrypted data string ..[" + encodedEncryptedDataString + "]");

            String recoveredDataString = dataStringEncryptAgent.decrypt(encodedEncryptedDataString);
            //System.out.println("Recovered data string ..........[" + recoveredDataString + "]");
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }*/

    private String characterEncoding;
    private Cipher encryptCipher;
    private Cipher decryptCipher;
    private BASE64Encoder base64Encoder = new BASE64Encoder();
    private BASE64Decoder base64Decoder = new BASE64Decoder();
}

