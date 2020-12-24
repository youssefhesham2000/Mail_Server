package mail.back.interfaces;

import java.util.List;

import mail.back.Contact;

public interface ISearchCriteria {
	public List<Contact> meetCriteria(Contact[] Contacts, String Criteria);
}
