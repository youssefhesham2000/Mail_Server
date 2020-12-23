package mail.back;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;






public class FolderManagerBIN {

	public FolderManagerBIN() {
	    
	}
		
	public static void initProgramDirectories()
	{
		new File("./Users").mkdirs();
	}
	
	public static User getUser(int id)
	{
		DoubleLinkedList users = getUsers();
		for(int i = 0; i < users.size();i++)
		{
			User user = (User)users.get(i);
			if (user.getID() == id)
				return user;
		}
		return null;
	}
	
	public static User getUser(String email)
	{
		DoubleLinkedList users = getUsers();
		for(int i = 0; i < users.size();i++)
		{
			User user = (User)users.get(i);
			for (int j = 0;j < user.emails.size();j++) {
				String userEmail = (String) user.emails.get(j);
				if (userEmail.equals(email))
					return user;
			}
		}
		return null;
	}
	
	public static void WriteObjectToFile(Object serObj, String path) {
        Gson GsonStr = new GsonBuilder().setPrettyPrinting().create();
        String JsonStr = GsonStr.toJson(serObj);
        try {
			Files.write(Paths.get(path), JsonStr.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
    }
	
	
	public static DoubleLinkedList ReadObjectFromFile(String path)
	{
		DoubleLinkedList s = null;
		try
		{
			Gson gson = new GsonBuilder().create();
        	String input = Files.readString(Paths.get(path));
        	s = gson.fromJson(input, new TypeToken<DoubleLinkedList>() {
        }.getType());
		}catch(Exception e)
		{
			new File(path);
		}
		return s;
	}
	
		
	
	public static void saveUsersLinkedList(DoubleLinkedList users)
	{
		WriteObjectToFile(users, "./Users/usersIndex.json");
	}
	
	/**  
	 * @return a DoublyLinkedList of all the users User objects
	 */
	public static DoubleLinkedList getUsers() 
	{
		DoubleLinkedList d = (DoubleLinkedList)ReadObjectFromFile("./Users/usersIndex.json");
		if(d == null)
			return new DoubleLinkedList();
		return d;
	}
	
	public static void addNewUser(User newUser) {
		DoubleLinkedList users = getUsers();
		
		//TODO compare every email in the new user with all the emails of the other users
		for (int i = 0;i < users.size();i++) {
			User user = (User) users.get(i);
			for (int j = 0;j < user.emails.size();j++) {
				if (((String)newUser.emails.get(0)).equals((String)user.emails.get(j))){
					return;
				}
			}
		}
		
		users.add(newUser);
		saveUsersLinkedList(users);
	}
	
	/**
	 * 
	 * @param updatedUser
	 * the user has to exist
	 */
	public static void updateUser (User updatedUser) {
		DoubleLinkedList users = getUsers();
		for (int i = 0;i < users.size();i++) {
			User user = (User) users.get(i);
			if (updatedUser.getID() == user.getID()) {
				users.set(i, updatedUser);
				saveUsersLinkedList(users);
				return;
			}
		}
		
	}
	public static void printUsers() {
		DoubleLinkedList arr = getUsers();
		
		for (int i = 0;i < arr.size();i++) {
			User user = (User) arr.get(i);
			System.out.println("---------------------------------------");
			System.out.println("Id = " + user.id);
			
			DoubleLinkedList emails = user.emails;
			String password = user.password;

			for (int j = 0;j < emails.size() && emails.get(j) != null;j++)
				System.out.println("Email : " + emails.get(j) + ", pass : " + password);
		}
		System.out.println("........................................");
	}
	
}
