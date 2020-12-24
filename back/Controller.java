package eg.edu.alexu.csd.mailServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
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
import io.netty.handler.codec.http.HttpHeaders;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class Controller {
	
	
	@PostMapping ("compose")
	public void compose(@RequestBody email e ) {
		
	}
	@PostMapping ("saveDraft/{userId}")
	public void compose(@RequestBody email e ,@PathVariable int userID ) {
		
	}	
	
	
	@PostMapping ("signUp")
	public int SignUP( ) {
		
		// return id 
		return 66;
	}

	@GetMapping("signIn/{email}/{pass}")
	public String getIDAndSignIN(@PathVariable String email,@PathVariable String pass) {
		
		/// return user Id + random session number
		/// return error if user not registered
	 return null;
	}	
	
	@GetMapping("userState/{userID}")
	public String isUserSignedIn(@PathVariable int userID) {
		
		/// return yes if signed
		/// else  return no
	 return null;
	}	
	
	
	@GetMapping("getEmails/{userID}/{folderName}/{pageNo}")
	public List<emails> getEmails(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable int pageNo) {
		
		
	  return null;
	}	
	
	@GetMapping("sort/{userID}/{folderName}/{sortType}")
	public List<emails> sort(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable String sortType) {
		
		
	  return null;
	}	
	
	@GetMapping("search/{userID}/{folderName}/{searchType}")
	public List<emails> search(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable  String searchType) {
		
		
	  return null;
	}	
	
	@GetMapping("filter/{userID}/{folderName}/{filterType}")
	public List<emails> filter(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable  String filterType) {
		
		
	  return null;
	}
	
	
	
	
	@GetMapping("getOneEmail/{userID}/{folderName}/{emailID}")
	public email getOneEmail(@PathVariable int userID ,@PathVariable String folderName ,@PathVariable int emailID) {
		
		
	  return null;
	}	
	
	@GetMapping("getFolders/{userID}")
	public List<String> getFolders(@PathVariable int userID) {
		
		
	  return null;
	}	
	
	
	@GetMapping("getContacts/{userID}")
	public List<Contact> getContacts(@PathVariable int userID) {
		
		
	  return null;
	}
	
	@PutMapping("updateContact/{userID}")
	
	/////
	///   the front send list of Contact of lenght 2
	  //    index 0  old contact
	//      index 1  updatedContact    
	public void renameFolder(@PathVariable int userID, @RequestBody List <Contact> l) {
			
		
	}
	
	
	@PutMapping("addContact/{userID}")
	
	public void renameFolder(@PathVariable int userID, @RequestBody Contact c) {
			
		
	}
	
	@GetMapping("sortContacts/{userID}")
	public List<Contact> sortContacts(@PathVariable int userID) {
		
		
	  return null;
	}
	@GetMapping("searchContacts/{userID}/{contactName}")
	public List<Contact> searchContacts(@PathVariable int userID, @PathVariable  String contactName ) {
		
		
	  return null;
	}
	
	@PutMapping("renameFolder/{userID}/{oldName}/{newName}")
	public void renameFolder(@PathVariable int userID, @PathVariable String oldName,@PathVariable String newName) {
			
		
	}
	
	
	@PutMapping("addFolder/{userID}/{name}")
	public void addFolder(@PathVariable int userID, @PathVariable String name) {
		
		
		
	}
	
	@DeleteMapping("removeFolder/{userID}/{name}")
	public void removeFolder(@PathVariable int userID, @PathVariable String name) {
		
		
		
	}
	
	@DeleteMapping("deleteEmails/{userID}/{folderName}")
	public void addFolder(@PathVariable int userID, @PathVariable String folderName,@RequestBody List<Integer> EmailIDs ) {
		
			
	}
	@PutMapping("moveEmails/{userID}/{folderName}")
	public void moveEmails(@PathVariable int userID, @PathVariable String folderName,@RequestBody List<Integer> EmailIDs ) {
		
			
	}
	

	

	
	
	
	//////////
	//  delete file in path: "attachments\\" +name
	///
	@DeleteMapping("deleteAttachment/{name}")
	public void deleteAttachment(@PathVariable String name) {
		// delete the file  from the directory "attachments\"
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
	
	  @PostMapping("/upload" )
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
