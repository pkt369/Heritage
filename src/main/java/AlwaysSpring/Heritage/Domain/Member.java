package AlwaysSpring.Heritage.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String name;

    public static Member createMember(String email, String password, String name) {
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.name = name;

        return member;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
