package storysflower.com.storysflower.services;

import storysflower.com.storysflower.config.security.CustomUserDetail;
import storysflower.com.storysflower.dto.UserProfileDTO;

import java.util.List;

/**
 * @author ntynguyen
 */
public interface UserService {
    public CustomUserDetail getUser();

    int countPagination();

    public boolean registerNewUserAccount(UserProfileDTO userProfileDTO);

    List<UserProfileDTO> findAll();

    UserProfileDTO findCustomerById(Long id);

    String getFullNameById(Long id);
}
