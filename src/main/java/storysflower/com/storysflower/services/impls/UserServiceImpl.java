package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.config.security.CustomUserDetail;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.repositories.UserRepository;
import storysflower.com.storysflower.services.UserService;

/**
 * @author ntynguyen
 */

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public  CustomUserDetail getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal()  instanceof CustomUserDetail)) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        return (CustomUserDetail) principal;
    }

    @Override
    public boolean registerNewUserAccount(UserProfileDTO userProfileDTO) {
        return userRepository.registerNewUserAccount(userProfileDTO);
    }
}
