package 内部类;

import java.util.List;
import java.util.Objects;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/12/26 15:20
 */
public class UserDTO {

    private List<String> username;

    private String password;

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username=" + username +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
