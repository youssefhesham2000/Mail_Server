package mail.back.interfaces;

import java.util.List;

import mail.back.Email;

public interface Criteria {
public List<Email> meetCriteria(Email[] Emails, String Criteria);
}
