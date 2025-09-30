package upce.nnpda.semA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upce.nnpda.semA.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String password;

    public User toUser(){
        return new User(username, email, password);
    }
}
