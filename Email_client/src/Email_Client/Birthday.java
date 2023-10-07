package Email_Client;

///////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Birthday {

    private ArrayList<Recipient> all_recipients = new ArrayList<>();
    public Birthday(ArrayList<Recipient> all_recipients){
        this.all_recipients = all_recipients;
    }
    public ArrayList<Recipient> get_birthday_list( Date date){
        ArrayList<Recipient> birthday_list= new ArrayList<>();
        for (Recipient recipient: all_recipients) {               // Travers through all recipient object and return the
            String recipient_type = recipient.get_type();         // recipient list who have birthday on the given date
            Date birthday;
            if (Objects.equals(recipient_type, "Office_friend")) {
                Office_friend office_friend = (Office_friend) recipient;
                birthday = office_friend.get_birthday();
            } else if (Objects.equals(recipient_type, "Personal")) {
                Personal_friend personal_friend = (Personal_friend) recipient;
                birthday = personal_friend.get_birthday();
            } else {
                continue;
            }

            if (birthday.getMonth() == date.getMonth() && birthday.getDate() == date.getDate()) {
                birthday_list.add(recipient);
            }
        }
        return  birthday_list;
    }

}
