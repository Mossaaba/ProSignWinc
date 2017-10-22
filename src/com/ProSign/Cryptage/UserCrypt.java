package com.ProSign.Cryptage;

 
import java.util.List;
import java.security.Security;


public class UserCrypt {
    public UserCrypt() {
    }

    public String DeCryptage(String user) 
    {
        String usercrypt = "";

        try {
            // Make sure SUN are a valid provider
            Security.addProvider(new com.sun.crypto.provider.SunJCE());

            // This could be read from a file.
            final byte[] keyBytes = "wincesolution".getBytes("ASCII");

            // Data string encrypt agent that assumes the data string is only ASCII characters
            BlowfishECBEncryptDataString dataStringEncryptAgent = new BlowfishECBEncryptDataString(keyBytes, "UTF-8");

            // Get the data string to encrypt from the command line


            usercrypt = dataStringEncryptAgent.decrypt(user);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return usercrypt;
    }



    public String Cryptage(String user) {
       String usercrypt = "";

       try
                        {
                            // Make sure SUN are a valid provider
                            Security.addProvider(new com.sun.crypto.provider.SunJCE());

                            // This could be read from a file.
                            final byte[] keyBytes = "wincesolution".getBytes("ASCII");

                            // Data string encrypt agent that assumes the data string is only ASCII characters
                            BlowfishECBEncryptDataString dataStringEncryptAgent = new BlowfishECBEncryptDataString(keyBytes, "UTF-8");

                            // Get the data string to encrypt from the command line



                             usercrypt = dataStringEncryptAgent.encrypt(user);


                        }
                        catch (Exception e)
                        {
                            e.printStackTrace(System.out);
        }


       return usercrypt;
   }



}
