package AlwaysSpring.Heritage.Domain.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeritageDetailDTO {
    private String ccbaKdcd;
    private String ccbaAsno;
    private String ccbaCtcd;
    private String ccbaCpno;
    private String longitude;
    private String latitude;
    private String ccmaName;
    private String gcodeName;
    private String bcodeName;
    private String mcodeName;
    private String scodeName;
    private String ccbaQuan;
    private String ccbaAsdt;
    private String ccbaLcad;
    private String ccceName;
    private String ccbaPoss;
    private String ccbaAdmin;
    private String imageUrl;
    private String content;

    public HeritageDetailDTO(String ccbaKdcd, String ccbaAsno, String ccbaCtcd, String ccbaCpno, String longitude, String latitude, String ccmaName, String gcodeName, String bcodeName, String mcodeName, String scodeName, String ccbaQuan, String ccbaAsdt, String ccbaLcad, String ccceName, String ccbaPoss, String ccbaAdmin, String imageUrl, String content) {
        this.ccbaKdcd = ccbaKdcd;
        this.ccbaAsno = ccbaAsno;
        this.ccbaCtcd = ccbaCtcd;
        this.ccbaCpno = ccbaCpno;
        this.longitude = longitude;
        this.latitude = latitude;
        this.ccmaName = ccmaName;
        this.gcodeName = gcodeName;
        this.bcodeName = bcodeName;
        this.mcodeName = mcodeName;
        this.scodeName = scodeName;
        this.ccbaQuan = ccbaQuan;
        this.ccbaAsdt = ccbaAsdt;
        this.ccbaLcad = ccbaLcad;
        this.ccceName = ccceName;
        this.ccbaPoss = ccbaPoss;
        this.ccbaAdmin = ccbaAdmin;
        this.imageUrl = imageUrl;
        this.content = content;
    }
}
