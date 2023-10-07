package Email_Client;

//////////////////////////////////////////////////////////////////////

import java.io.IOException;
import java.util.*;

public class Office_friend extends Recipient implements Birthday_wish{
    private String designation;
    private Date birthday;

    public Office_friend(String name, String email, String designation, Date birthday){
        super("Office_friend", name, email);
        this.designation = designation;
        this.birthday = birthday;
    }

    public Date get_birthday(){
        return birthday;
    }

    public void wish() throws IOException {

        String email = this.get_email();
        String name = this.get_name();
        String subject ="";
        String content = "Dear " + name + "," + "\n\n" + "Wish you a Happy Birthday. Sumathipala H.E.S.";

        SendEmailTLS birthday_wish = new SendEmailTLS(email, subject, content);
        birthday_wish.send_mail();



    }
}
