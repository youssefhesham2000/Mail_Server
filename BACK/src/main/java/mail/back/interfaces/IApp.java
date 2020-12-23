package mail.back.interfaces;


 
import mail.back.interfaces.ILinkedList;

public interface IApp {
	/**
	 * i love dr khaled nagi
	* Sign in to the application
	* @param email
	* @param password
	* @return false if the email name not exist
	*/
	public boolean signin(String email, String password);
	
	/**
	* Create new account
	* @param contact
	* @return false if the email name already exist
	*/
	public boolean signup(IContact contact);
	/**
	* This function should be called before reading from the index file
	* and apply the sort and search parameters
	* @param folder currently shown, can be null
	* @param filter to apply search, can be null
	* @param sort to apply sort
	*/
	public void setViewingOptions(IFolder folder);
	/**
	* You should use setViewingOptions function first
	* @param page to handle paging
	* @return list of emails
	*/
	public IMail[] listEmails(int page);
	/**
	* You should use setViewingOptions function first
	* @param mails to be moved to trash
	*/
	public void deleteEmails(ILinkedList mails);
	/**
	* You should use setViewingOptions function first
	* @param mails to be moved
	* @param des the destination folder
	*/
	public void moveEmails(ILinkedList mails, IFolder des,int id);
	/**
	* Send a new email
	* @param email should contain all the information needed
	* sender, list of receivers, list of attachments, email body, ...
	* @return false if something wrong happened like sending to non-existing user.
	*/
	public boolean compose(IMail email);

	void moveEmails(eg.edu.alexu.csd.datastructure.linkedList.cs.Interfaces.ILinkedList mails, IFolder des);

	void moveEmails(eg.edu.alexu.csd.datastructure.linkedList.cs.Interfaces.ILinkedList mails, IFolder des, int id);
}
