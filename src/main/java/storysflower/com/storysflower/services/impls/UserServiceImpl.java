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
    public List<UserProfileDTO> findAll() {
        List<UserProfileDTO> listUserProfile = userRepository.findAll();
        for (UserProfileDTO u: listUserProfile) {
            String f = Character.toString(u.getFisrtName().charAt(0)).toUpperCase();
            u.setFisrtName(f+u.getFisrtName().substring(1));
            String l = Character.toString(u.getLastName().charAt(0)).toUpperCase();
            u.setLastName(l+u.getLastName().substring(1));
        }
        return listUserProfile;
    }

    @Override
    public UserProfileDTO findCustomerById(Long id) {
        return userRepository.findCustomerById(id);
    }

    @Override
    public String getFullNameById(Long id) {
        UserProfileDTO userProfileDTO = findCustomerById(id);
        String f = Character.toString(userProfileDTO.getFisrtName().charAt(0)).toUpperCase();
        userProfileDTO.setFisrtName(f+userProfileDTO.getFisrtName().substring(1));
        String l = Character.toString(userProfileDTO.getLastName().charAt(0)).toUpperCase();
        userProfileDTO.setLastName(l+userProfileDTO.getLastName().substring(1));

        return userProfileDTO.getFisrtName()+" "+userProfileDTO.getLastName();
    }
}
