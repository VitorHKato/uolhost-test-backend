package vitor.kato.uolhost_backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodinameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private List<String> avengersCodinameList = new ArrayList<>();
    private List<String> justiceLeagueCodinameList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct                                      // Toda vez que a aplicação roda, esse método é rodado
    public void loadJsonData() {
        try{
            String codinameResponse = restTemplate.getForObject(
                    env.getProperty("avengers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codinameResponse);

            ArrayNode avengers = (ArrayNode) jsonNode.get("vingadores");

            // Pega o "codiname" de cada nó do Json e adiciona na lista
            for(JsonNode item: avengers) {
                this.avengersCodinameList.add(item.get("codiname").asText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));

            NodeList codinameList = document.getElementsByTagName("codiname");

            for (int i = 0; i < codinameList.getLength(); i++) {
                Element codinameElement = (Element) codinameList.item(i);
                String codiname = codinameElement.getTextContent();
                this.justiceLeagueCodinameList.add(codiname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
