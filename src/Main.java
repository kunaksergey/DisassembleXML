import di.Been;
import di.Option;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import shape.Pane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sa on 11.03.16.
 */
public class Main {
    private final String path = "config.xml";
    public Map<String, Been> beenMap;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Main main = new Main();
        main.beenMap = new HashMap<>();
        main.context(main.getPath());
        //    Class<Pane> =Class.forName();Тест

    }

    private void context(String path) throws ParserConfigurationException, SAXException, IOException {
        Document document = loadXMLFromFile(path);
        Element root = document.getDocumentElement();
        NodeList been = root.getElementsByTagName("been");
        beenMap = parseBeen(been);
        System.out.println(beenMap);


    }

    private Map<String, Been> parseBeen(NodeList beens) {
        Map<String, Been> beensMap = new HashMap<>();
        String name;
        String className;
        Been been;
        for (int i = 0; i < beens.getLength(); i++) {
            name = beens.item(i).getAttributes().getNamedItem("name").toString();
            className = beens.item(i).getAttributes().getNamedItem("class").toString();
            been = new Been();
            been.setName(name);
            been.setClassName(className);
            been.setOptions(parseOptions(beens.item(i).getChildNodes()));
            beensMap.put(name, been);
        }
        return beensMap;
    }

    private List<Option> parseOptions(NodeList options) {
        List<Option> optionsList = new ArrayList<>();
        String name;
        Node node;
        for (int i = 0; i < options.getLength(); i++) {
            node = options.item(i);
            if ("option".equals(node.getNodeName())) {
                Option option = new Option();
                name = node.getAttributes().getNamedItem("name").toString();
                option.setName(name);
                optionsList.add(option);
            }
        }
        return optionsList;
    }

    public String getPath() {
        return path;
    }

    public static Document loadXMLFromFile(String path) throws SAXException, ParserConfigurationException {
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            return builder.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
