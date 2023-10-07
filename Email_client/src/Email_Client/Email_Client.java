package Email_Client;

// Index No: 200629N
// Sumathipala H.E.S.

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Email_Client {

    public static void main(String[] args) throws IOException {

        Record client_list = new Record();
        ArrayList<Recipient> all_recipients = client_list.read_file(); // Read the client_list.txt file and crete objects for every recipient


        Deserial.makelinkedlist();
        String date2="";
        try {
            date2 = Deserial.mailList.getLast().getDate();

        }catch(NoSuchElementException nse){date2="";}


        Birthday birthday = new Birthday(all_recipients);  // List of recipients who have birthday on today.
        Date today = new Date();
        ArrayList<Recipient> birthday_list_for_today = birthday.get_birthday_list(today);

        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date today2=new Date();
        String today1=(formatter.format(today2));

        if(!(date2.equals(today1))) {
            for (Recipient recipient : birthday_list_for_today) {    // Wish for all th recipients in the birthday list for today

                if (Objects.equals(recipient.get_type(), "Office_friend")) {
                    Office_friend office_friend = (Office_friend) recipient;     // Birthday wish for office friends
                    office_friend.wish();
                } else if (Objects.equals(recipient.get_type(), "Personal")) {
                    Personal_friend personal_friend = (Personal_friend) recipient;    // Birthday wish for personal friends
                    personal_friend.wish();
                }
            }
        }


        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        while(true) {
            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays on an specific date\n"
                    + "4 - Printing out details of all the emails sent on an specific date\n"
                    + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();


            switch (option) {
                case 1 -> {
                    // input format - Official: nimal,nimal@gmail.com,ceo
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file

                    System.out.println("Enter type: name,email,position (Official: nimal,nimal@gmail.com,ceo)");
                    String recipient = scanner.next();
                    client_list.add(recipient, all_recipients);
                }
                case 2 -> {
                    // input format - email, subject, content
                    // code to send an email
                    System.out.println("Enter details(email, subject, content)\n");
                    String mail = scanner.next();
                    String[] mail_details = mail.split(", ");
                    String email = mail_details[0];
                    String subject = mail_details[1];
                    String content = mail_details[2];
                    //sender.send_mail(email, subject, content);
                    SendEmailTLS emailTLS = new SendEmailTLS(email, subject, content);
                    emailTLS.send_mail();
                }
                case 3 -> {
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date

                    System.out.println("Enter date(yyyy/MM/dd)");
                    String sDate = scanner.next();
                    try {
                        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                        ArrayList<Recipient> birthday_list = birthday.get_birthday_list(date1);
                        for (Recipient i : birthday_list) {
                            System.out.println(i.get_type() + ": " + i.get_name());
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    System.out.println("Enter date(yyyy/MM/dd)");
                    String date = scanner.next();
                    Deserial.deserialize(date);
                }
                case 5 ->
                    // code to print the number of recipient objects in the application
                        System.out.println("Total number of recipients: " + Record.getNumber_of_recipients());
            }

            System.out.println("DO you want other service \n Yes- 1 No-0");
            int temp=scanner.nextInt();
            if(temp==0){break;}
        }



    }
}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
