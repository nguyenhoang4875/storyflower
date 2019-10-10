package storysflower.com.storysflower.dto;

/**
 * @author ntynguyen
 */
public class UserProfileDTO {
    private String fisrtName;
    private String lastName;
    private String email;
    private String password;
    private Long imageID;

    public UserProfileDTO() {
    }

    public static UserProfileDTO create(){
        return new UserProfileDTO();
    };

    public UserProfileDTO(String fisrtName, String lastName, String email, String password) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserProfileDTO(String fisrtName, String lastName, String email, String password, Long imageID) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.imageID = imageID;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }
}
