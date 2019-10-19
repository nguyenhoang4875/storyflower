package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.config.security.CustomUserDetail;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.repositories.UserRepository;
import storysflower.com.storysflower.services.UserService;

import java.util.List;

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

    @Override
    public int countPagination() {
        return userRepository.countPagination();
    }

    @Override
    public List<UserProfileDTO> findAllPagination(int offset, int defaultPagingCustomerSize) {
        List<UserProfileDTO> listUserProfile = userRepository.findAllPagination(offset,defaultPagingCustomerSize);
        for (UserProfileDTO u: listUserProfile) {
            String name =Character.toString(u.getFisrtName().charAt(0)).toUpperCase();
            u.setFisrtName(name+u.getFisrtName().substring(1)+" ");

            String name1 =Character.toString(u.getLastName().charAt(0)).toUpperCase();
            u.setLastName(name1+u.getLastName().substring(1));

        }
        return listUserProfile;
    }
}
