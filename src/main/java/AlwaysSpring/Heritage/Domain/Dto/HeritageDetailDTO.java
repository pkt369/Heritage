package AlwaysSpring.Heritage.Domain.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeritageDetailDTO {
    private String ccbaKdcd;
    private String ccbaAsno;
    private String ccbaCtcd;
    private String ccbaMnm1;

    public HeritageDetailDTO() {
    }

    public String getUrl() {
        return "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd;
    }

    @Override
    public String toString() {
        return "HeritageDetailDTO{" +
                "ccbaKdcd='" + ccbaKdcd + '\'' +
                ", ccbaAsno='" + ccbaAsno + '\'' +
                ", ccbaCtcd='" + ccbaCtcd + '\'' +
                '}';
    }
}
