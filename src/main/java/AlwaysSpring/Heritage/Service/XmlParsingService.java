package AlwaysSpring.Heritage.Service;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Domain.Dto.HeritageDetailDTO;
import AlwaysSpring.Heritage.Domain.Dto.HeritageListDTO;
import AlwaysSpring.Heritage.Repository.HeritageRepository;
import lombok.RequiredArgsConstructor;
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
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class XmlParsingService {

    private final HeritageRepository heritageRepository;


    public void saveList() {
        List<HeritageListDTO> dtos = new ArrayList<>();
        getCulturalHeritage();
        CulturalHeritage one = heritageRepository.findOne(1);
        System.out.println(one.toString());

    }

    public void getCulturalHeritage() {
        String addr = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageUnit=10&pageIndex=1&ccbaCtcd=21";
        try {
            List<HeritageDetailDTO> heritageList = getXmlHeritageList(addr);
            getXmlHeritageDetail(heritageList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getXmlHeritageDetail(List<HeritageDetailDTO> dtoList) throws ParserConfigurationException, IOException, SAXException {
        for (int i = 0; i < dtoList.size(); i++) {
            HeritageDetailDTO dto = dtoList.get(i);
            String url = dto.getUrl();
            Document document = getBuildDocument(url);
            NodeList itemTagList = document.getElementsByTagName("item");
            for (int j = 0; j < itemTagList.getLength(); ++j) {
                Node node = itemTagList.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    CulturalHeritage heritage = new CulturalHeritage();
                    heritage.setCcmaName(getTagValue("ccmaName", element));
                    heritage.setGcodeName(getTagValue("gcodeName", element));
                    heritage.setBcodeName(getTagValue("bcodeName", element));
                    heritage.setMcodeName(getTagValue("mcodeName", element));
                    heritage.setScodeName(getTagValue("scodeName", element));
                    heritage.setCcbaQuan(getTagValue("ccbaQuan", element));
                    heritage.setCcbaAsdt(getTagValue("ccbaAsdt", element));
                    heritage.setCcbaLcad(getTagValue("ccbaLcad", element));
                    heritage.setCcceName(getTagValue("ccceName", element));
                    heritage.setCcbaPoss(getTagValue("ccbaPoss", element));
                    heritage.setCcbaAdmin(getTagValue("ccbaAdmin", element));
                    heritage.setImageUrl(getTagValue("imageUrl", element));
                    heritage.setContent(getTagValue("content", element));
                    int save = heritageRepository.save(heritage);
                    System.out.println(save);
                }
            }
        }


    }

    public List<HeritageDetailDTO> getXmlHeritageList(String url) throws ParserConfigurationException, IOException, SAXException {

        Document document = getBuildDocument(url);

        NodeList itemTagList = document.getElementsByTagName("item");
        List<HeritageDetailDTO> list = new ArrayList<>();

        for (int i = 0; i < itemTagList.getLength(); ++i) {
            Node node = itemTagList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                list.add(new HeritageDetailDTO());
                Element element = (Element) node;
                list.get(i).setCcbaKdcd(getTagValue("ccbaKdcd", element));
                list.get(i).setCcbaAsno(getTagValue("ccbaAsno", element));
                list.get(i).setCcbaCtcd(getTagValue("ccbaCtcd", element));
            }
        }
        return list;
    }

    private Document getBuildDocument(String url) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(url);
        document.getDocumentElement().normalize();
        return document;
    }

    private String getTagValue(String tag, Element element) {
        NodeList list = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node value = (Node) list.item(0);
        if (value == null) {
            return null;
        }
        return value.getNodeValue();
    }
}
