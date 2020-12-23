package mail.back;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import mail.back.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class Controller {
	static App app = new App();	
	
	@PostMapping ("signUP")
	public boolean SignUP(@PathVariable String first_Name, @PathVariable String last_Name, @PathVariable String Email, @PathVariable String pass) {
		User user = new User(first_Name, first_Name, Email, pass);
		if ( app.signup(user) )
			return true;
		else
			return false;
	}

	@GetMapping("signin/{email}/{pass}")
	public Object getIDAndSignIN(@PathVariable String email,@PathVariable String pass) {
		/// return error if user not registereddsd
		Object signOutput= app.signin(email, pass);
		if((boolean)signOutput)
		return signOutput;
		else
			return false;	 
	}	
	
	
	@GetMapping("getEmails/{userID}/{folderName}/{pageNo}")
	public List<Email> getEmails(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable int pageNo) {
		
		
	  return null;
	}	
	
	
	@GetMapping("getFolders/{userID}")
	public List<String> getFolders(@PathVariable int userID) {
		
		
	  return null;
	}	
	
	
	@GetMapping("getContacts/{userID}")
	public List<Contact> getContacts(@PathVariable int user_ID) {
	  User user = FolderManagerBIN.getUser(user_ID);
	  List<Contact> contacts = new ArrayList();
	  for ( int i=0; i<user.contactsIDs.size(); i++){
		User temp_1 = FolderManagerBIN.getUser((int) user.contactsIDs.get(i));
		Contact temp_2 = new Contact(temp_1.firstName, temp_1.lastName, temp_1.emails);
		contacts.add(temp_2);
	  }
	  return contacts;
	}
	
	@PutMapping("renameFolder/{userID}/{oldName}/{newName}")
	public void renameFolder(@PathVariable int userID, @PathVariable String oldName,@PathVariable String newName) {
			
		
	}
	
	
	@PutMapping("addFolder/{userID}/{name}")
	public void addFolder(@PathVariable int userID, @PathVariable String name) {
		
		
		
	}
	
	
	@DeleteMapping("deleteEmails/{userID}/{folderName}")
	public void addFolder(@PathVariable int userID, @PathVariable String folderName,@RequestBody List<Integer> EmailIDs ) {
		
			
	}
	
	
	@DeleteMapping("removeFolder/{userID}/{name}")
	public void removeFolder(@PathVariable int userID, @PathVariable String name) {
		
		
		
	}
	
	
	
	//////////
	//  delete file in path: "attachments\\" +name
	///
	@DeleteMapping("deleteAttachment/{name}")
	public void deleteAttachment(@PathVariable String name) {
		
	}
	
	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
		File file=new File("attachments\\"+fileName) ; 
		InputStreamResource resource = null;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		    return ResponseEntity.ok()
		            .contentLength(file.length())
		            .contentType(MediaType.APPLICATION_OCTET_STREAM)
		            .body(resource);
		    
	}
	
	  @PostMapping("/upload/{userID}/{emailID}" )
	  public void fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	 
		  		try {
				// read and write the file to the selected location-
				byte[] bytes = file.getBytes();
				Path path = Paths.get("attachments\\" + file.getOriginalFilename());
				/// making a file like the one that was uploaded 
				Files.write(path, bytes);

			} catch (IOException e) {
				e.printStackTrace();
		}

		}
}