package mail.back;


import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import eg.edu.alexu.csd.datastructure.linkedList.cs.Interfaces.ILinkedList;
import mail.back.interfaces.IContact;
import mail.back.interfaces.IFolder;
import mail.back.interfaces.IMail;
public class App implements mail.back.interfaces.IApp {

	
	
	public Folder folder;
	LoggedInUser LoggedInUser;
	public DoubleLinkedList currentlyLoadedEmails;
	
	public App() {
		folder = new Folder("inbox");
		
	}
	
	
	@Override
	public Object signin(String email, String password) {
		if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			return false;
		}
		User user = FolderManagerBIN.getUser(email);
		if(user == null) {
			return false;
		}
		
		
		if (password.contentEquals("")) {
			return false;
		}
		else if(!(user.password).equals(password)) {
			return false;
		}
		else {
			LoggedInUser.addLoggedInUser(user,user.id);
			return user.id;
		}
	}

	@Override
	public boolean signup(IContact contact) {
		User user = (User)contact;
		String email = (String)user.emails.get(0);
		
		
		if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
		{
			return false;
		}else if(FolderManagerBIN.getUser(email)!=null)
		{
			return false;
		}
		
		else if(user.password.length() < 8)
		{
			return false;
		}
		else
		{
			user.saveToFileSystem();
		}
		return true;
	}

	//@Override
	/*public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		currentlyLoadedEmails = Email.readUserEmails(loggedInUser.getID(), folder);

		if(filter != null)
			Filter.filter(currentlyLoadedEmails, (FilterComp)filter);
		SortingTemp.quickSort(currentlyLoadedEmails,(ISort) sort);
		
		this.folder = (Folder) folder;
		this.filter = (FilterComp) filter;
		this.sort = (sortComparator) sort;
	}*/

	/*@Override
	public IMail[] listEmails(int page) {
		Email[] emails = new Email[10];
		
		for(int i = 0;i < 10 && 10*page + i < currentlyLoadedEmails.size();i++)
			emails[i] = (Email)currentlyLoadedEmails.get(10*page+i);
		return emails;
	}*/
	// this requires updating the index file from outside this function in the source folder
	
	@Override
	public void moveEmails(ILinkedList mails, IFolder des,int id) {
		DoubleLinkedList emails = Email.readEmails();
		for(int i = 0; i < mails.size();i++)
		{
			Email m = ((Email)mails.get(i));
			int oldID = m.id;
			m.id = m.calculateEmailID();
			emails.add(m);
			/// huissien ..to do
			// move the id from  
			//
			String srcPath = "./Users/" + id + "/" + folder.type + "/" + oldID + "/";
			String destPath = "./Users/" + id + "/" + ((Folder)des).type + "/" + m.id + "/";
			new File(destPath).mkdirs();
			String files[] = new File(srcPath).list();
			for(String file: files)
			{
				try {
					Files.move(new File(srcPath + file).toPath(), new File(destPath+file).toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			new File(srcPath).delete();
		}
		//Email.saveEmail(); we need to implement new fn to save the linked list after deleting them from the folders linked list
	}

	@Override
	public boolean compose(IMail email) {
		
		return false;
	}


	@Override
	public void setViewingOptions(IFolder folder) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteEmails(mail.back.interfaces.ILinkedList mails) {
		// TODO Auto-generated method stub
		
	}


	


	@Override
	public IMail[] listEmails(int page) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void moveEmails(mail.back.interfaces.ILinkedList mails, IFolder des, int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		// TODO Auto-generated method stub
		
	}
	

}
