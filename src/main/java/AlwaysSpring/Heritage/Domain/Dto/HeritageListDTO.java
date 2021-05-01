package AlwaysSpring.Heritage.Domain.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class HeritageListDTO {
    private int totalCnt;
    private int pageUnit;
    private int pageIndex;
    private int sn;
    private int no;
    private String ccmaName;
    private int crltsnoNm;
    private String ccbaMnm1;
    private String ccbaMnm2;
    private String ccbaCtcdNm;
    private String ccsiName;
    private String ccbaAdmin;
    private String ccbaKdcd;
    private String ccbaCtcd;
    private String ccbaAsno;
    private String ccbaCncl;
    private String ccbaCpno;
    private String longitude;
    private String latitude;

    public HeritageListDTO() {
    }

    public HeritageListDTO(int totalCnt, int pageUnit, int pageIndex, int sn, int no, String ccmaName, int crltsnoNm, String ccbaMnm1, String ccbaMnm2, String ccbaCtcdNm, String ccsiName, String ccbaAdmin, String ccbaKdcd, String ccbaCtcd, String ccbaAsno, String ccbaCncl, String ccbaCpno, String longitude, String latitude) {
        this.totalCnt = totalCnt;
        this.pageUnit = pageUnit;
        this.pageIndex = pageIndex;
        this.sn = sn;
        this.no = no;
        this.ccmaName = ccmaName;
        this.crltsnoNm = crltsnoNm;
        this.ccbaMnm1 = ccbaMnm1;
        this.ccbaMnm2 = ccbaMnm2;
        this.ccbaCtcdNm = ccbaCtcdNm;
        this.ccsiName = ccsiName;
        this.ccbaAdmin = ccbaAdmin;
        this.ccbaKdcd = ccbaKdcd;
        this.ccbaCtcd = ccbaCtcd;
        this.ccbaAsno = ccbaAsno;
        this.ccbaCncl = ccbaCncl;
        this.ccbaCpno = ccbaCpno;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setDate(String name) {

    }
}
