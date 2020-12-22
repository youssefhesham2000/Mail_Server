package mail.back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    @PostMapping("/test") 
    @CrossOrigin ( origins = "*" )
    
    public String show ( @RequestBody request r  ) throws Exception {
        return "test" ;
    }
}
