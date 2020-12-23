package mail.back;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.cs.Classes.SinglyLinked;
import mail.back.interfaces.IFolder;
import mail.back.interfaces.IMail;

public class Email implements IMail, Serializable
{
	int id;
	int priority;
	String subject;
	String body;
	LocalDateTime date;
	int senderID;
	String senderEmail;
	int receiverID;
	String receiverEmail;
	SinglyLinked attachments;
	
	/**
	 * 
	 * @param subject
	 * @param body
	 * @param senderID
	 * @param senderEmail
	 * @param receiverID
	 * @param receiverEmail
	 * @param numOfAttachements
	 * @param priority
	 */
	public Email(String subject, String body, int senderID, String senderEmail,
			int receiverID, String receiverEmail, SinglyLinked attachments, int priority) 
	{

		
		this.subject = subject;
		this.body = body;
		this.date = LocalDateTime.now();
		this.receiverID = receiverID;
		this.receiverEmail = receiverEmail;
		this.senderID = senderID;
		this.senderEmail = senderEmail;
		this.attachments = attachments;
		this.priority = priority;
	}
	
	
	public String getSubject(){
		return subject;
	}
	
	public String getSender(){
		return senderEmail;
	}
	public String getReceiver(){
		return receiverEmail;
	}
	public String getBody(){
		return body;
	}
	public LocalDateTime getDate(){
		return date;
	}
	public SinglyLinked getAttachments() {
		return attachments;
	}
	
	public static void DeleteTrash(int userID)
	{		
		String folders[] = Folder.listFolders(userID);
		for(String folder: folders)
		{
			String path = "./Users/" + userID + "/" + folder + "/index.json";
			DoubleLinkedList emails = (DoubleLinkedList)FolderManagerBIN.ReadObjectFromFile(path);
			for(int i = 0; i < emails.size();i++)
			{
				Email m = (Email)emails.get(i);
				LocalDateTime now = LocalDateTime.now();
				LocalDateTime emailDate = m.date;
				if(now.compareTo(emailDate.plusDays(30)) >= 0)
				{
					String emailPath = "./Users/" + userID + "/" + folder + "/" + m.id;
					File index = new File(emailPath);
					String files[] = index.list();
					for(String s: files)
					{
						File currentFile = new File(index.getPath(), s);
						currentFile.delete();
					}
					index.delete();
					emails.remove(i--);
				}
			}
			FolderManagerBIN.WriteObjectToFile(emails, path);
		}
	}
	
	
	/*
	 * Send Logic: call this function with the sender id and "Sent" folder
	 * Receive Logic: call this function with the Receiver id and "inbox" folder
	 */
	
	
	int calculateEmailID()
	{
		
		int id;
		//User user = FolderManagerBIN.getUser(userID);
		DoubleLinkedList emails = readEmails();
		
		
		for (int i = 0;i < emails.size();i++)
			System.out.print(((Email)emails.get(i)).subject);
		
		
		
		id=emails.size();
		
		System.out.println(id);
		return id;
	}
	
	public void saveEmail()
	{
		DoubleLinkedList emails = readEmails();
		
		
		for (int i = 0;i < emails.size();i++)
			System.out.print(((Email)emails.get(i)).subject);
		
		
		
		
		
		//ID the email object
		
		this.id = calculateEmailID();

		User sender = FolderManagerBIN.getUser(senderID);
		User receiver = FolderManagerBIN.getUser(receiverID);
		
		sender.folders.get(1).add(this.id);
		receiver.folders.get(0).add(this.id);
		
		emails.add(this);
		String path = "./Emails/emails.json";
		FolderManagerBIN.WriteObjectToFile(emails, path);
		//remember to save index of email in users
	}
	
	/**
	 * 
	 * @param userID
	 * @param Folder object, its type will be used (inbox, sent, trash ..)
	 * @return DoubleLinkedList of the Email objects inside the folder
	 */
	public static DoubleLinkedList readEmails()
	{
		
		String path = "./Emails/emails.json";
		DoubleLinkedList emails = (DoubleLinkedList) FolderManagerBIN.ReadObjectFromFile(path);
		if (emails == null)
			return new DoubleLinkedList();
		
		return emails;
	}
	
	
	
}
