package Email_Client;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

    public class SendEmailTLS implements Serializable {
        String date;
        String email;
        String subject;
        String content;
        public SendEmailTLS(String to, String subject,String content){
            DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
            Date today=new Date();
            this.date = (formatter.format(today));

            this.email=to;
            this.content=content;
            this.subject=subject;

        }

        public  void send_mail() {



            final String username = "user@gmail.com";  // use your email
            final String password = "app password";     // use app password for your e-mail

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("user@gmail.com")); //// use your email
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject(subject);
                message.setText(content);

                Transport.send(message);

                serial.serialize(this);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        public String getDate(){return date;}
        public String getMailAddress(){return email;}
        public String getSubject(){return subject;}
        public String getContent(){return content;}

    }
