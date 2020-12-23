package mail.back;

import java.util.ArrayList;
import java.util.List;

public class LoggedInUser {
private static LoggedInUser instance=null;
public static LoggedInUser getInstance() {
	if(instance==null) {
		instance=new LoggedInUser();
	}
	return instance;
}
List<User> loggedInUsers =new ArrayList<User>();
public void addLoggedInUser(User newUser) {
	
}
public List<User> getLoggedInUsers() {
	return loggedInUsers;
}
}
