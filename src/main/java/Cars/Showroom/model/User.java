package Cars.Showroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String role; // CUSTOMER, MANAGER, ADMIN

//    public void setPassword(String encode) {
//    }

    public void setPassword(String encode) {
    }

    public CharSequence getPassword() {
        return null;
    }
}