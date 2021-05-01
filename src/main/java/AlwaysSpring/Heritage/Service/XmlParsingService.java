package AlwaysSpring.Heritage.Service;

import AlwaysSpring.Heritage.Domain.Dto.HeritageListDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlParsingService {


    public void saveList() {
        List<HeritageListDTO> dtos = new ArrayList<>();
        List<String> list = getXmlHeritage();
        for (int i = 0; i < list.size(); i++) {


        }
    }

    public List<String> getXmlHeritage() {
        List<String> data = new ArrayList<>();
        String addr = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageUnit=100&pageIndex=1";
        try {
            URL url = new URL(addr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setConnectTimeout(10000);
            http.setUseCaches(false);

            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                data.add(line);
            }
            br.close();
            http.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void bindingList(HeritageListDTO dto, String one) {
        if (one.charAt(0) != '<') {
            return;
        }
        int cutIndex = one.indexOf('>');
        String name = one.substring(1, cutIndex - 1);
        int endIndex = one.substring(cutIndex+2).indexOf('>');
        String cut = one.substring(cutIndex+2, endIndex-1);

        switch (name) {
            case "sn":
                dto.setSn();
            case "no":
            case "ccmaName":
            case "crltsnoNm":
            case "ccbaMnm1":
            case "ccbaMnm2":
            case "ccbaCtcdNm":
            case "ccsiName":
            case "ccbaAdmin":
            case "ccbaKdcd":
            case "ccbaCtcd":
            case "ccbaAsno":
            case "ccbaCncl":
            case "ccbaCpno":
            case "longitude":
            case "latitude":
        }
    }
}
