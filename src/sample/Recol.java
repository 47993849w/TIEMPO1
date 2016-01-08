package sample;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by 47993849w on 20/11/15.
 */
public class Recol  {
    public  String tem1;
    public  String tem2;
    public  String tiempo;
    public  String vellv;
    public  String vt;
    public  String total;
    public String pres;




    public  String dia2="";
    public  String tem3;
    public  String tem4;
    public  String from;
    public  String hm;
    public  Document  doc;
    private String codi;
    public String humi;


    public void c() throws IOException, SAXException, ParserConfigurationException {

        //Si queremos usar el xml estatico-->
        // String inputFile = new String("forecast.xml");
        //

        //ListView<String> list = new ListView<String>();


        File outputFile = new File("xml.xml");


        URL xmlURL = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Barcelona,es&units=metric&lang=sp&cnt=15&mode=xml&APPID=946990d16bf270450d5633215cff60ae");
        InputStream xml = xmlURL.openStream();


        //Protocolo de entrada
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(xml);
        doc.getDocumentElement().normalize();

        //normalizar

        NodeList sitio = doc.getElementsByTagName("location");
        Element ciutat = (Element) sitio.item(0);
        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");







        Image h = new Image("/sample/32.png");






    }

    public void c2() throws IOException, SAXException, ParserConfigurationException {

        //Si queremos usar el xml estatico-->
        // String inputFile = new String("forecast.xml");
        //

        //ListView<String> list = new ListView<String>();


        File outputFile = new File("xml.xml");



        String ciu="q=Barcelona,es";
        URL xmlURL = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?"+ciu+"&units=metric&lang=sp&cnt=15&mode=xml&APPID=946990d16bf270450d5633215cff60ae");
        InputStream xml = xmlURL.openStream();


        //Protocolo de entrada
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(xml);
        doc.getDocumentElement().normalize();

        //normalizar

        NodeList sitio = doc.getElementsByTagName("location");
        Element ciutat = (Element) sitio.item(0);
        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");
    }

    public void getA(String geogra) throws ParserConfigurationException, SAXException, IOException {
        //Si queremos usar el xml estatico-->
        // String inputFile = new String("forecast.xml");
        //

        //ListView<String> list = new ListView<String>();


        File outputFile = new File("xml.xml");


        URL xmlURL = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+geogra+"&units=metric&lang=sp&cnt=15&mode=xml&APPID=946990d16bf270450d5633215cff60ae");
        System.out.println(xmlURL);
        InputStream xml = xmlURL.openStream();


        //Protocolo de entrada
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(xml);
        doc.getDocumentElement().normalize();

        //normalizar

        NodeList sitio = doc.getElementsByTagName("location");
        Element ciutat = (Element) sitio.item(0);
        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");







        Image h = new Image("/sample/32.png");

    }

    public void getB(String geogra) throws ParserConfigurationException, SAXException, IOException {
        URL xmlURL = new URL("http://api.openweathermap.org/data/2.5/forecast/?q="+geogra +"&lang=sp&mode=xml&APPID=946990d16bf270450d5633215cff60ae");
        System.out.println(xmlURL);
        InputStream xml = xmlURL.openStream();


        //Protocolo de entrada
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(xml);

        //normalizar
        doc.getDocumentElement().normalize();
        NodeList sitio = doc.getElementsByTagName("location");
        Element ciutat = (Element) sitio.item(0);
        System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        //NodeList prev = doc.getElementsByTagName("time");
    }


    public String getFrom(int temp) throws ParserConfigurationException, SAXException, IOException

    {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        from = (time.getAttribute("day"));
        String ao = from.substring(0, 4);
        String mes = from.substring(5, 7);
        String dia = from.substring(8, 10);
        total = dia+"/" + mes +"/"+ ao;
        return total;
    }

    public String getFrom2(int temp) throws ParserConfigurationException, SAXException, IOException

    {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        from = (time.getAttribute("from"));
        String ao = from.substring(0, 4);
        String mes = from.substring(5, 7);
        String dia = from.substring(8, 10);
        String hor = from.substring(11,16);
        total = dia+"/" + mes +"/"+ ao+"-"+hor;
        return total;
    }





    public String getTem1(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        tem1 = (time.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("max").getNodeValue());
        return tem1;
    }

    public String getTem2(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        tem2 = (time.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("min").getNodeValue());

        return tem2;
    }

    public String getHumi(int temp) throws ParserConfigurationException, SAXException, IOException {

        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        humi = (time.getElementsByTagName("humidity").item(0).getAttributes().getNamedItem("value").getNodeValue());

        return humi;
    }

    public String getPres(int temp) throws ParserConfigurationException, SAXException, IOException {
        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        pres = (time.getElementsByTagName("pressure").item(0).getAttributes().getNamedItem("value").getNodeValue());

        return pres;
    }


    public String getTiempo(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;
        tiempo = (time.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("name").getNodeValue());
        tiempo = tiempo.substring(0, 1).toUpperCase() + tiempo.substring(1);
        return tiempo;
    }

    public String getVellv(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        Double mph = Double.parseDouble(time.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("mps").getNodeValue());
        Double kmh = mph * 3.6;
        DecimalFormat df = new DecimalFormat("#0.00"); //Formateamos los decimales
        String numeroConFormato = df.format(kmh);
        vellv = (numeroConFormato + "kmh" + "\n");
        return vellv;
    }

    public double getVellv2(int temp) throws ParserConfigurationException, SAXException, IOException {


        double vellv2;
        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;

        Double mph = Double.parseDouble(time.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("mps").getNodeValue());
        Double kmh = mph * 3.6;
        //DecimalFormat df = new DecimalFormat("#0.00"); //Formateamos los decimales
        //vellv2 = Double.parseDouble(df.format(kmh));

        return kmh;
    }

    public String getVt(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;
        vt = (time.getElementsByTagName("windDirection").item(0).getAttributes().getNamedItem("code").getNodeValue());
        return vt;
    }

    public String getTotal(int temp) throws ParserConfigurationException, SAXException, IOException {


        //System.out.println("La previson es de: " + ciutat.getElementsByTagName("name").item(0).getTextContent());
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;
        return total;
    }



    public String getDia2(int temp) {
         Calendar cal = new GregorianCalendar();
          int p = cal.get(Calendar.DAY_OF_WEEK);

        if (temp == 0)
            p = p;
        else if (temp == 1)
            p = p + 1;
        else if (temp == 2)
            p = p + 2;
        else if (temp == 3)
            p = p + 3;


        if (p == 1 || p == 8)
            dia2 = "Domingo";
        else if (p == 2 || p == 9)
            dia2 = "Lunes";
        else if (p == 3 || p == 10)
            dia2 = "Martes";
        else if (p == 4 || p == 11)
            dia2 = "Miercoles";
        else if (p == 5 || p == 12)
            dia2 = "Jueves";
        else if (p == 6 || p == 13)
            dia2 = "Viernes";
        else if (p == 7 || p == 14)
            dia2 = "Sabado";

        return dia2;
    }

    public String getTem3() {
        return tem3;
    }

    public String getTem4() {
        return tem4;
    }

    public String getFrom() {
        return from;
    }

    public String getHm() {
        return hm;
    }

    public String getCodi(int temp){
        NodeList prev = doc.getElementsByTagName("time");

        Element time = (Element) prev.item(temp);
        Element timea = null;
        codi = (time.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("var").getNodeValue());
        return codi;
    }

}
