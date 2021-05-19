package AlwaysSpring.Heritage.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * ccmaName 문화재종목
 * gcodeName 문화재분류
 * bcodeName 문화재분류2
 * mcodeName 문화재분류3
 * scodeName 문화재분류4
 * ccbaQuan 수량
 * ccbaAsdt 지정(등록일)
 * ccbaLcad 소재지 상세
 * ccceName 시대
 * ccbaPoss 소유자
 * ccbaAdmin 관리자
 * imageUrl 메인노출이미지URL
 * content 내용
 * ccbaMnm1 문화재명
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class CulturalHeritage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heritage_id")
    private Long id;

    private String ccmaName;
    private String gcodeName;
    private String bcodeName;
    private String mcodeName;
    private String scodeName;
    private String ccbaQuan;
    private String ccbaAsdt;
    private String ccbaPoss;
    private String ccbaAdmin;
    private String ccceName;
    private String ccbaLcad;
    private String imageUrl;
    private String ccbaMnm1;

    @Column(length = 5000)
    private String content;

    @Override
    public String toString() {
        return "CulturalHeritage{" +
                "id=" + id +
                ", ccmaName='" + ccmaName + '\'' +
                ", gcodeName='" + gcodeName + '\'' +
                ", bcodeName='" + bcodeName + '\'' +
                ", mcodeName='" + mcodeName + '\'' +
                ", scodeName='" + scodeName + '\'' +
                ", ccbaQuan='" + ccbaQuan + '\'' +
                ", ccbaAsdt='" + ccbaAsdt + '\'' +
                ", ccbaPoss='" + ccbaPoss + '\'' +
                ", ccbaAdmin='" + ccbaAdmin + '\'' +
                ", ccceName='" + ccceName + '\'' +
                ", ccbaLcad='" + ccbaLcad + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", ccbaMnm1='" + ccbaMnm1 + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
