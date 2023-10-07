package Email_Client;
//////////////////////////////////////////////////////////////////////////////

public abstract class Recipient {
    private String type;
    private String name;
    private   String email;

    public Recipient(String type, String name, String email){
        this.type = type;
        this.name = name;
        this.email = email;
    }


    public String get_type(){
        return type;
    }

    public  String get_name(){
        return name;
    }

    public  String get_email(){
        return email;
    }

}
