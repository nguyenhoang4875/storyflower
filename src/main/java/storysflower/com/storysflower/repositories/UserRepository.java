package storysflower.com.storysflower.repositories;

import org.apache.naming.factory.DataSourceLinkFactory;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.model.tables.tables.records.UserRecord;

import java.util.ArrayList;
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
}
