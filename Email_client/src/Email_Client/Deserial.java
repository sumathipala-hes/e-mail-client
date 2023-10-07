package Email_Client;

///////////////////////////////////////////////////////

import java.io.*;
import java.util.LinkedList;

public class Deserial {

     public static LinkedList<SendEmailTLS> mailList=new LinkedList();
    public static void deserialize(String date){
        try {
            FileInputStream fileIn = new FileInputStream("serial.ser");
            ObjectInputStream inObj=null;
            SendEmailTLS email = null;
            do {
                try {
                    try {
                        inObj = new ObjectInputStream(fileIn);
                        email = (SendEmailTLS) inObj.readObject();

                    }catch(EOFException ef){break;}
                    if (date.equals(email.getDate())) {
                        System.out.println("To:- " + email.getMailAddress());
                        System.out.println("Subject:-" + email.getSubject());
                        System.out.println("Content:- " + email.getContent());
                    }
                }
                catch(EOFException io){
                    io.printStackTrace();
                    break;
                }
                catch(NullPointerException ne){break;}

            } while (email != null);
            inObj.close();
            fileIn.close();
        }
        catch(IOException i){
            i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException cls){
            cls.printStackTrace();;
            return;
        }
    }

    public static void makelinkedlist(){
        try {
            FileInputStream fileIn = new FileInputStream("serial.ser");
            ObjectInputStream inObj=null;
            SendEmailTLS email = null;
            do {
                try {
                    try {
                        inObj = new ObjectInputStream(fileIn);
                        email = (SendEmailTLS) inObj.readObject();
                        mailList.add(email);

                    }catch(EOFException ef){break;}

                }
                catch(EOFException io){
                    io.printStackTrace();
                    break;
                }
                catch(NullPointerException ne){break;}

            } while (email != null);
            inObj.close();
            fileIn.close();
        }
        catch(IOException i){
            //i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException cls){
            cls.printStackTrace();
            return;
        }catch(NullPointerException ne){return;}
    }
}
