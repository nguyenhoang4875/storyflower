package storysflower.com.storysflower.services;

import storysflower.com.storysflower.config.security.CustomUserDetail;
import storysflower.com.storysflower.dto.UserProfileDTO;

/**
 * @author ntynguyen
 */
public interface UserService {
    public CustomUserDetail getUser();

    public boolean registerNewUserAccount(UserProfileDTO userProfileDTO);
}
