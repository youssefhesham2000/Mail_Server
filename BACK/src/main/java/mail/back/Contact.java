package mail.back;

public class Contact {
    String first_name, last_name;
    DoubleLinkedList emails;

    public Contact(String first_name, String last_name, DoubleLinkedList emails) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.emails = emails;
    }
}
