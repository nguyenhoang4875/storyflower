package storysflower.com.storysflower.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.model.tables.tables.User;
import storysflower.com.storysflower.model.tables.tables.records.UserRecord;

import java.util.Collections;
import java.util.List;

import static storysflower.com.storysflower.model.tables.Tables.USER_ROLE;
import static storysflower.com.storysflower.model.tables.tables.User.USER;

/**
 * @author ntynguyen
 */
@Component
public class UserRepository {
    @Autowired
    private DSLContext dslContext;

    public UserRecord findByEmail(String email){
        System.out.println(USER.EMAIL);
        return dslContext.fetchOne(USER, USER.EMAIL.eq(email));
    }

    public List<SimpleGrantedAuthority> getAuthority(String email){
        return dslContext.select(USER_ROLE.ROLE)
                .from(USER_ROLE)
                .join(USER).on(USER.EMAIL.eq(USER_ROLE.EMAIL))
                .where(USER.EMAIL.eq(email))
                .fetchInto(SimpleGrantedAuthority.class);
    }

    public boolean registerNewUserAccount(UserProfileDTO userProfileDTO) {
        return dslContext.insertInto(USER)
                .set(USER.FIRSTNAME, userProfileDTO.getFisrtName())
                .set(USER.LASTNAME, userProfileDTO.getLastName())
                .set(USER.EMAIL,userProfileDTO.getEmail())
                .set(USER.PASSWORD, userProfileDTO.getPassword())
                .execute()>0;
    }
    public int countPagination(){
        return dslContext.selectCount()
                .from(USER)
                .fetchOne(0, Integer.class);
    }

  /*  public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<UserProfileDTO> listUserProfile =userRepository.findAllPagination(0,2);
        System.out.println("size"+listUserProfile.size());




    }*/

    public List<UserProfileDTO> findAllPagination(int offset, int defaultPagingCustomerSize) {
        List<UserProfileDTO> listUserProfile = dslContext
                .select(USER.ID, USER.FIRSTNAME, USER.LASTNAME, USER.EMAIL, USER.PASSWORD, USER.IMAGE_ID)
                .from(USER)
                .orderBy(USER.ID)
                .limit(offset, defaultPagingCustomerSize)
                .fetchInto(UserProfileDTO.class);
        return  listUserProfile.size()==0? Collections.emptyList() : listUserProfile;
    }
}
