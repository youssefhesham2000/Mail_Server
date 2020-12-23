package mail.back;
import mail.back.Email;
public interface Filter {
	public Email[] meetCriteria(Email[] Emails);
}
