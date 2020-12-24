package mail.back;

public class Contact {
    private String first_name, last_name;
    private DoubleLinkedList emails;

    public Contact(String first_name, String last_name, DoubleLinkedList emails) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.emails = emails;
    }
    public void setFirstName(String firstName) {
    	this.first_name=firstName;
    }
    public void setlastName(String lastName) {
    	this.last_name=lastName;
    }
    public void setEmails(DoubleLinkedList ema) {
    	this.emails=ema;
    }
    public DoubleLinkedList getEmails() {
    	return this.emails;
    }
    public String getFirstName() {
    	return this.first_name;
    }
    public String getLastName() {
    	return this.last_name;
    }
    
    
}
