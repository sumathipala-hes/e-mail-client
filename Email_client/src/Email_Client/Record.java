package Email_Client;

///////////////////////////////////////////////////////////////////////

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Record {
    private static int number_of_recipients = 0;

    public static int getNumber_of_recipients (){
        return number_of_recipients;
    }

    public ArrayList<Recipient> read_file(){
        ArrayList<Recipient> all_recipients = new ArrayList<>();
        try {
            FileReader fr = new FileReader("clientList.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] details_array = line.split("[: ,]+");
                if (Objects.equals(details_array[0], "Official")){
                    Official_recipient temp = new Official_recipient(details_array[1], details_array[2], details_array[3]);
                    all_recipients.add(temp);
                }
                else if (Objects.equals(details_array[0], "Office_friend")) {
                    String sDate = details_array[4];
                    Date bDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                    Office_friend temp = new Office_friend(details_array[1], details_array[2], details_array[3],bDate);
                    all_recipients.add(temp);
                }
                else if(Objects.equals(details_array[0], "Personal")){
                    String sDate = details_array[4];
                    Date bDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                    Personal_friend temp = new Personal_friend(details_array[1], details_array[2], details_array[3],bDate);
                    all_recipients.add(temp);
                }
                number_of_recipients++;
            }
            br.close();
            fr.close();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return all_recipients;
    }

    public void add (String line,ArrayList<Recipient> all_recipients) {
        try {
            // add to the clientList.txt file
            FileWriter source = new FileWriter("clientList.txt", true);
            BufferedWriter writer = new BufferedWriter(source);
            writer.write(line + "\n");
            writer.close();

            // create an object and add to the recipient object list
            String[] details_array = line.split("[: ,]+");
            if (Objects.equals(details_array[0], "Official")) {
                Official_recipient temp = new Official_recipient(details_array[1], details_array[2], details_array[3]);
                all_recipients.add(temp);
            } else if (Objects.equals(details_array[0], "Office_friend")) {
                String sDate = details_array[4];
                Date bDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                Office_friend temp = new Office_friend(details_array[1], details_array[2], details_array[3], bDate);
                Date today = new Date();
                if (bDate.getMonth() == today.getMonth() && bDate.getDate() == today.getDate()){
                    temp.wish();
                }
                all_recipients.add(temp);

            } else if (Objects.equals(details_array[0], "Personal")) {
                String sDate = details_array[4];
                Date bDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
                Personal_friend temp = new Personal_friend(details_array[1], details_array[2], details_array[3], bDate);
                Date today = new Date();
                if (bDate.getMonth() == today.getMonth() && bDate.getDate() == today.getDate()){
                    temp.wish();
                }
                all_recipients.add(temp);

                
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        number_of_recipients++;
    }

}