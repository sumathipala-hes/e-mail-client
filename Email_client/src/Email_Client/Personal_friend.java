package Email_Client;

////////////////////////////////////////////////////////////////

import java.io.IOException;
import java.util.Date;

public class Personal_friend extends Recipient implements Birthday_wish{
    private String nick_name;
    private Date birthday;

    public Personal_friend(String name, String nick_name, String email, Date birthday){
        super("Personal", name, email);
        this.nick_name = nick_name;
        this.birthday = birthday;
    }

    public Date get_birthday(){
        return birthday;
    }
    public void wish() throws IOException {

        String email = this.get_email();
        String name = this.get_name();
        String subject ="";
        String content = "Dear " + name + "," + "\n\n" + "Hugs and love on your birthday. Sumathipala H.E.S.";
        SendEmailTLS birthday_wish = new SendEmailTLS(email,subject,content);
        birthday_wish.send_mail();

    }
}
