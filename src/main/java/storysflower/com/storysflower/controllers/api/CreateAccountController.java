package storysflower.com.storysflower.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import storysflower.com.storysflower.dto.ApiResponse;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.exceptions.ApiException;
import storysflower.com.storysflower.services.UserService;

/**
 * @author ntynguyen
 */
@RestController
@RequestMapping("api/createaccount")
public class CreateAccountController {
    @Autowired
    UserService userService;

    @GetMapping
    public Object handleCreateAccount(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        if (userService.registerNewUserAccount(new UserProfileDTO(firstName, lastName, email, password))) {
            return ApiResponse.success("Create account successfull!");
        }
        return new ApiException(HttpStatus.BAD_REQUEST, "Something went wrong! Please try again");
    }
}
