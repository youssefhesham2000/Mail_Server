package mail.back;

import java.util.ArrayList;
import java.util.List;

import mail.back.interfaces.ISearchCriteria;

public class EmailSearchCriteria implements ISearchCriteria {

	@Override
	public List<Contact> meetCriteria(Contact[] Contacts, String Criteria) {
		// TODO Auto-generated method stub
		String Email=Criteria;
		List<Contact> returnedMails =new ArrayList<Contact>();
		for( Contact contact:Contacts) {
			DoubleLinkedList emails=contact.getEmails();
			for( int i=0;i<emails.size();i++) {
			if (((String) emails.get(i)).equalsIgnoreCase(Email)) {
				returnedMails .add(contact);
			}
		}
		return returnedMails;
	}
		return null;
	}

}
