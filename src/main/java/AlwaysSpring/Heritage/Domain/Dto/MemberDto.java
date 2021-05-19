package AlwaysSpring.Heritage.Domain.Dto;

import AlwaysSpring.Heritage.Domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String name;

    public Member toEntity() {
        return Member.createMember(email, password, name);
    }
}
