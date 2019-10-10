package storysflower.com.storysflower.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import storysflower.com.storysflower.dto.NotFoundException;
import storysflower.com.storysflower.exceptions.ApiException;

/**
 * @author ntynguyen
 */
@RestController
@RequestMapping("api/login")
public class LoginRestController {
    @GetMapping()
    public String getLoginPage(){
       throw new NotFoundException();
    }

}
