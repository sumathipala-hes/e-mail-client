package Email_Client;

//////////////////////////////////////////////////////////////////////

public class Official_recipient extends Recipient{
    private String designation;

    public Official_recipient( String name, String email, String designation ){
        super("official", name, email);
        this.designation = designation;
    }

}
