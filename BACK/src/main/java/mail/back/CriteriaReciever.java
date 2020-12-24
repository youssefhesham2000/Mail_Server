package mail.back;

import java.util.ArrayList;
import java.util.List;

import mail.back.interfaces.Criteria;

public class CriteriaReciever implements Criteria {

	@Override
	public List<Email> meetCriteria(Email[] Emails, String Criteria) {
		// TODO Auto-generated method stub
		String reciever=Criteria;
		List<Email> returnedMails =new ArrayList<Email>();
		for( Email email:Emails) {
			if (email.getReceiver().equalsIgnoreCase(reciever)) {
				returnedMails .add(email);
			}
		}
		return returnedMails;
	}

	
}