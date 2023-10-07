package Email_Client;

///////////////////////////////////////////////////////////////////////

import java.io.*;

public class serial {
    public static void serialize(SendEmailTLS obj){
        try {
            FileOutputStream fOut = new FileOutputStream("serial.ser",true);
            ObjectOutputStream out= new ObjectOutputStream(fOut);
            out.writeObject(obj);
            out.close();
            fOut.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
}
