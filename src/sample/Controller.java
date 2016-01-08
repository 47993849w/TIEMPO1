package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {



    public ListView<String> lv2;


    String tem1;

    String tem2;

    public Tab tab1, tab2, tab3, tab4;
    public  Tab tab5;
    public ImageView im;
    public Text m1, e1, n1, v1, v2;
    public ImageView im2;
    public Text m2;
    public Text e2;
    public  Text n2;
    public Text v21;
    public Text v22;
    public ImageView im3;
    public ImageView im5;
    public Text m3;
    public Text e3;
    public  Text n3;
    public Text v31;
    public Text v32;
    public Text m4;
    public Text e4;
    public  Text n4;

    public ImageView im4;
    public Text v41;
    public Text v42;

    public Text des5;
    public Text des1;
    public Text des2;
    public Text des3;
    public Text des4;
    public Text d1;
    public Text fle1;
    public Text fle2;
    public Text m5;
    public Text e5;
    public  Text n5;
    public Text v15;
    public Text v25;
    int temp = 4;
    public ListView<String> lv;
    public ObservableList<String> observableList = FXCollections.observableArrayList();
    public ObservableList<String> observableList2 = FXCollections.observableArrayList();
    public ObservableList<String> observableList3 = FXCollections.observableArrayList();
    public ObservableList<String> observableList4 = FXCollections.observableArrayList();

    public ListView<String> lv3;
    public ListView<String> lv4;
    public MenuButton mod;
    public CheckMenuItem hor;
    public CheckMenuItem dia;


    public TextField tf;
    public CheckMenuItem Barcelona;
    public CheckMenuItem Girona;

    public MenuButton lug;



    String total;
    Calendar cal = new GregorianCalendar();
    //Date d = null;
    //cal.setTime(d);
    int p = cal.get(Calendar.DAY_OF_WEEK);
    String dia2="";
    @FXML
    MenuButton dVist;
    public CheckMenuItem uno;
    public CheckMenuItem dos;
    public CheckMenuItem tres;
    public CheckMenuItem cuatro;
    public CheckMenuItem cinco;
    public CheckMenuItem seis;
    public CheckMenuItem siete;
    public CheckMenuItem ocho;
    public CheckMenuItem temperatura;
    public CheckMenuItem humedad;
    public CheckMenuItem presion;
    public CheckMenuItem viento;
    public MenuButton dat;





    public void initialize() throws IOException, SAXException, ParserConfigurationException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cargando");
        alert.setHeaderText("Cargando");

        alert.show();
        //lug.setText("Barcelona");
        FileReader fileReader = new FileReader("src/sample/preferencias");
        //StringBuilder stringBuffer = new StringBuilder();



        BufferedReader bufferedReader;


        bufferedReader = new BufferedReader(fileReader);

        String text;
        while ((text=bufferedReader.readLine()) != null) {
            String[] text2 = text.split(",");
            lug.setText(text2[0]);
            tf.setText(text2[0]);
            mod.setText(text2[1]);
            //System.out.println(bufferedReader.readLine());
            //textArea1.setText(textArea1.getText() + "\n" + text);
        }
        //mod.setText("Diaria");
        rell(lug.getText(), mod.getText());
        alert.hide();


        Recol recol = new Recol();
        String geogra = tf.getText().replace(" ", "");
        recol.getA(geogra);


        for (int temp2 = 0; temp2 <= 4; temp2++) {
            System.out.println("holaaaaaaaa");


            if (temp2 == 0) {
                tab1.setText("hoy " + recol.getFrom(temp2));
            }
            if (temp2 == 1) {
                tab2.setText("Manana " + recol.getFrom(temp2));
            }
            if (temp2 == 2) {
                tab3.setText(recol.getDia2(temp2)+" " + recol.getFrom(temp2));
            }
            if (temp2 == 3) {
                tab4.setText(recol.getDia2(temp2)+" "+ recol.getFrom(temp2));
            }
        }
    }








    public void ref (javafx.event.ActionEvent actionEvent) throws IOException, SAXException, ParserConfigurationException {

        dia.setSelected(false);
        hor.setSelected(false);

        if (actionEvent.getSource().equals(dia)) {
            mod.setText("Diaria");
            dia.setSelected(true);
            hor.setSelected(false);
            System.out.println("DIARIA");
        }

        if (actionEvent.getSource().equals(hor)) {
            mod.setText("Horaria");
            dia.setSelected(false);
            hor.setSelected(true);
            System.out.println("HORARIA");
        }


        rell(tf.getText().replace(" ", ""), mod.getText());

        ref2(actionEvent);
    }



    public void ref2 (javafx.event.ActionEvent actionEvent) throws IOException, SAXException, ParserConfigurationException {
       // Barcelona.setSelected(false);
       // Girona.setSelected(false);

        if (actionEvent.getSource().equals(Barcelona)){
            Barcelona.setSelected(true);
            Girona.setSelected(false);
            lug.setText("Barcelona,es");
            tf.setText("Barcelona,es");



        }
        else if (actionEvent.getSource().equals(Girona)) {
            Barcelona.setSelected(false);
            Girona.setSelected(true);
            lug.setText("Girona");
            tf.setText("Girona");
        }
        else {
            lug.setText(tf.getText().substring(0, 1).toUpperCase() + tf.getText().substring(1));

            Barcelona.setSelected(false);
            Girona.setSelected(false);
        }
        rell(tf.getText().replace(" ", ""), mod.getText());

    }


    public void rell (String geogra, String tip) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Hola");

        if (tip.equals("Diaria")) {



            lv.setVisible(false);
            lv2.setVisible(false);
            lv3.setVisible(false);
            lv4.setVisible(false);



            Recol recol = new Recol();
            recol.getA(geogra);


            for (int temp2 = 0; temp2 <= 4; temp2++) {
                System.out.println("holaaaaaaaa");


                if (temp2 == 0) {
                    tab1.setText("hoy " + recol.getFrom(temp2));
                    m1.setText(recol.getTem1(temp2) + (char) 0x00B0 + "C");
                    n1.setText(recol.getTem2(temp2));
                    e1.setText(recol.getTiempo(temp2));
                    v1.setText(recol.getVt(temp2));
                    v2.setText(recol.getVellv(temp2));
                    des1.setText("El tiempo para hoy dia "+recol.getTotal(temp2)+" en "+lug.getText()+" es de "+e1.getText()+" con una temperatira máxima de "+m1.getText()+" y una temperatura minima de "+n1.getText()+"  (fuente:OpenWheatherMap)");
                    Image h = new Image("/sample/"+recol.getCodi(0)+".png");
                    im.setImage(h);
                    System.out.println(recol.getCodi(1));
                } else if (temp2 == 1) {
                    tab2.setText("Ma�ana " + recol.getFrom(temp2));
                    m2.setText(recol.getTem1(temp2) + (char) 0x00B0 + "C");
                    n2.setText(recol.getTem2(temp2));
                    e2.setText(recol.getTiempo(temp2));
                    v21.setText(recol.getVt(temp2));
                    v22.setText(recol.getVellv(temp2));
                    Image h = new Image("/sample/"+recol.getCodi(temp2)+".png");
                    im2.setImage(h);
                    des2.setText("El tiempo para manyana dia "+recol.getTotal(temp2)+" en "+lug.getText()+" es de "+e2.getText()+" con una temperatira máxima de "+m2.getText()+" y una temperatura minima de "+n2.getText()+"  (fuente:OpenWheatherMap)");
                }

                //fle2.setText(tem4);


                else if (temp2 == 2) {
                    tab3.setText(recol.getDia2(temp2) +" "+ recol.getFrom(temp2));
                    m3.setText(recol.getTem1(temp2) + (char) 0x00B0 + "C");
                    n3.setText(recol.getTem2(temp2));
                    e3.setText(recol.getTiempo(temp2));
                    v31.setText(recol.getVt(temp2));
                    v32.setText(recol.getVellv(temp2));
                    Image h = new Image("/sample/"+recol.getCodi(temp2)+".png");
                    im3.setImage(h);
                    des3.setText("El tiempo para  el dia "+recol.getTotal(temp2)+" en "+lug.getText()+" es de "+e3.getText()+" con una temperatira máxima de "+m3.getText()+" y una temperatura minima de "+n3.getText()+"  (fuente:OpenWheatherMap)");
                } else if (temp2 == 3) {
                    tab4.setText(recol.getDia2(temp2) +" "+ recol.getFrom(temp2));
                    m4.setText(recol.getTem1(temp2) + (char) 0x00B0 + "C");
                    n4.setText(recol.getTem2(temp2));
                    e4.setText(recol.getTiempo(temp2));
                    v41.setText(recol.getVt(temp2));
                    v42.setText(recol.getVellv(temp2));
                    Image h = new Image("/sample/"+recol.getCodi(temp2)+".png");
                    im4.setImage(h);
                    des4.setText("El tiempo para  el dia "+recol.getTotal(temp2)+" en "+lug.getText()+" es de "+e4.getText()+" con una temperatira máxima de "+m4.getText()+" y una temperatura minima de "+n4.getText()+"  (fuente:OpenWheatherMap)");

                }
                //tab5.setText(recol.getDia2(temp) + recol.getFrom(temp));

                else if (temp2 == 4) {
                    d1.setText(recol.getFrom(temp2));
                    m5.setText(recol.getTem1(temp2) + (char) 0x00B0 + "C");
                    n5.setText(recol.getTem2(temp2));
                    e5.setText(recol.getTiempo(temp2));
                    v15.setText(recol.getVt(temp2));
                    v25.setText(recol.getVellv(temp2));
                    Image h = new Image("/sample/"+recol.getCodi(temp2)+".png");
                    im5.setImage(h);
                    des5.setText("El tiempo para  el dia "+recol.getTotal(temp2)+" en "+lug.getText()+" es de "+e4.getText()+" con una temperatira máxima de "+m4.getText()+" y una temperatura minima de "+n4.getText()+"  (fuente:OpenWheatherMap)");

                }

            }
            tab5.setDisable(false);

        }

        else {

            tab5.setDisable(true);

            Recol recol = new Recol();
            recol.getB(geogra);
            //mod.setText("Horaria");
            //dia.setSelected(false);
            //hor.setSelected(true);
            lv.setVisible(true);
            lv.setVisible(true);
            lv2.setVisible(true);
            lv3.setVisible(true);
            lv4.setVisible(true);


            observableList.setAll("PREVISION HORARIA");
            observableList2.setAll("PREVISION HORARIA");
            observableList3.setAll("PREVISION HORARIA");
            observableList4.setAll("PREVISION HORARIA");

            int hoy = (cal.get(Calendar.DAY_OF_MONTH));
            int i = 0;

            String tiempo;
            String viento;
            String viento2;
            do {

                tem1 = "Maxima:  " +recol.getTem1(i);
                tem2 = "Minima:  " +recol.getTem2(i);
                tiempo = "TIEMPO: " +recol.getTiempo(i);
                viento = "Viento: " + recol.getVellv(i);
                viento2 = "Dirección: " + recol.getVt(i);
                total = recol.getFrom2(i);
                dia2=recol.getDia2(i);

                if (Integer.parseInt(total.substring(0,2))!=hoy+1){
                    observableList.add(tiempo + "\n" + tem1 + "\n" + tem2 + "\n" + viento + viento2 + "\n" + total);
                    lv.setItems(observableList);
                }
                i++;
            }while (Integer.parseInt(total.substring(0,2))==hoy || Integer.parseInt(total.substring(0,2))==hoy-1);


            int h2=i+6;

            for ( int h=i-1; h <= h2; h++) {
                System.out.println(h);
                tem1 = "Maxima:  " +recol.getTem1(h);
                tem2 = "Minima:  " +recol.getTem2(h);
                tiempo = "TIEMPO: " +recol.getTiempo(h);
                viento = "Viento: " + recol.getVellv(h);
                viento2 = "Dirección: " + recol.getVt(h);
                total = recol.getFrom2(h);
                dia2=recol.getDia2(h);
                observableList2.add(tiempo + "\n" + tem1 + "\n" + tem2 + "\n" + viento + viento2 + "\n" + total);
                lv2.setItems(observableList2);

            }
            h2=h2+8;
            for ( int h=i+7; h <= h2; h++) {
                System.out.println(h);
                tem1 = "Maxima:  " +recol.getTem1(h);
                tem2 = "Minima:  " +recol.getTem2(h);
                tiempo = "TIEMPO: " +recol.getTiempo(h);
                viento = "Viento: " + recol.getVellv(h);
                viento2 = "Dirección: " + recol.getVt(h);
                total = recol.getFrom2(h);
                dia2=recol.getDia2(h);

                observableList3.add(tiempo + "\n" + tem1 + "\n" + tem2 + "\n" + viento + viento2 + "\n" + total);
                lv3.setItems(observableList3);

            }
            h2=h2+8;
            for ( int h=i+15; h <= h2; h++) {
                System.out.println(h);
                tem1 = "Maxima:  " +recol.getTem1(h);
                tem2 = "Minima:  " +recol.getTem2(h);
                tiempo = "TIEMPO: " +recol.getTiempo(h);
                viento = "Viento: " + recol.getVellv(h);
                viento2 = "Dirección: " + recol.getVt(h);
                total = recol.getFrom2(h);
                dia2=recol.getDia2(h);

                observableList4.add(tiempo + "\n" + tem1 + "\n" + tem2 + "\n" + viento + viento2 + "\n" + total);
                lv4.setItems(observableList4);

            }
        }



    }


    public void dat(ActionEvent actionEvent){
        cinco.setDisable(false);
        seis.setDisable(false);
        siete.setDisable(false);
        ocho.setDisable(false);

        temperatura.setSelected(false);
        humedad.setSelected(false);
        presion.setSelected(false);

        if (actionEvent.getSource().equals(temperatura))
            dat.setText("Temperatura");
        else if (actionEvent.getSource().equals(humedad))
            dat.setText("humedad (maximo 4 dias)");
        else if (actionEvent.getSource().equals(presion)) {
            dat.setText("presión");
            cinco.setDisable(true);
            seis.setDisable(true);
            siete.setDisable(true);
            ocho.setDisable(true);
        }
        else if (actionEvent.getSource().equals(viento))
            dat.setText("viento");

    }


    public static Stage stage;

    public void lee () throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        stage.setTitle("Preferences");

        Stage primaryStage = Main.stage;
        //Scene scene = new Scene(anchorPane, 800, 600);

        stage.setScene(new Scene(root, 500, 200));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

        stage.show();
        //stage.show();
        //stage.isAlwaysOnTop();
    }

    public void tmas () throws IOException, SAXException, ParserConfigurationException {

        Recol recol = new Recol();
        temp++;
        recol.getA(tf.getText());
        if (temp ==14) {
            temp--;
        }
        d1.setText(recol.getFrom(temp));
        m5.setText(recol.getTem1(temp)+(char) 0x00B0+"C");
        n5.setText(recol.getTem2(temp));
        e5.setText(recol.getTiempo(temp));
        v15.setText(recol.getVt(temp));
        v25.setText(recol.getVellv(temp));
        des5.setText("El tiempo para  el dia "+recol.getTotal(temp)+" en "+lug.getText()+" es de "+e4.getText()+" con una temperatira máxima de "+m3.getText()+" y una temperatura minima de "+n3.getText()+"  (fuente:OpenWheatherMap)");


    }

    public void tmen () throws IOException, SAXException, ParserConfigurationException {

        Recol recol = new Recol();
        recol.getA(tf.getText());
        temp--;
        if (temp==3)
            temp++;
        d1.setText(recol.getFrom(temp));
        m5.setText(recol.getTem1(temp)+(char) 0x00B0+"C");
        n5.setText(recol.getTem2(temp));
        e5.setText(recol.getTiempo(temp));
        v15.setText(recol.getVt(temp));
        v25.setText(recol.getVellv(temp));


        des5.setText("El tiempo para  el dia "+recol.getTotal(temp)+" en "+lug.getText()+" es de "+e4.getText()+" con una temperatira máxima de "+m3.getText()+" y una temperatura minima de "+n3.getText()+"  (fuente:OpenWheatherMap)");

    }


    public void dias(javafx.event.ActionEvent actionEvent){
        uno.setSelected(false);
        dos.setSelected(false);
        tres.setSelected(false);
        cuatro.setSelected(false);
        cinco.setSelected(false);
        seis.setSelected(false);
        siete.setSelected(false);
        ocho.setSelected(false);
        if (actionEvent.getSource().equals(uno)){
            dVist.setText("1");
        }
        else if (actionEvent.getSource().equals(dos)){
            dVist.setText("2");
        }
        else if (actionEvent.getSource().equals(tres)){
            dVist.setText("3");
        }
        else if (actionEvent.getSource().equals(cuatro)){
            dVist.setText("4");
        }
        else if (actionEvent.getSource().equals(cinco)){
            dVist.setText("5");
        }
        else if (actionEvent.getSource().equals(seis)){
            dVist.setText("6");
        }
        else if (actionEvent.getSource().equals(siete)){
            dVist.setText("7");
        }
        else if (actionEvent.getSource().equals(ocho)){
            dVist.setText("8");
        }




    }

    public void ciud() throws IOException, SAXException, ParserConfigurationException {
        Stage stage=new Stage();

        stage.setTitle("Line Chart Sample");
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("DATOS");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series.setName("Dato 1");
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        lineChart.getData().add(series2);

        stage.setScene(scene);
        stage.show();
        String temm;
        String temn;
        String dia = null;

        int num = Integer.parseInt(dVist.getText());
        Recol recol = new Recol();
        recol.getA(tf.getText().replace(" ", ""));
        for (int temp2 = 0; temp2 <= num; temp2++) {

            if (dat.getText().equals("Temperatura")) {

                temm = recol.getTem1(temp2);
                temn = recol.getTem2(temp2);
                dia = recol.getFrom(temp2).substring(0, 2);
                System.out.println(recol.getFrom(temp2).substring(0, 2));

                series.getData().add(new XYChart.Data(dia, Double.parseDouble(temm)));
                series2.getData().add(new XYChart.Data(dia, Double.parseDouble(temn)));
            }

            else if (dat.getText().equals("humedad (maximo 4 dias)")){
                String hum = recol.getHumi(temp2);
                dia = recol.getFrom(temp2).substring(0, 2);
                System.out.println(recol.getFrom(temp2).substring(0, 2));

                series.getData().add(new XYChart.Data(dia, Double.parseDouble(hum)));

            }
            else if (dat.getText().equals("presión")){
                String pres = recol.getPres(temp2);
                dia = recol.getFrom(temp2).substring(0, 2);
                System.out.println(recol.getFrom(temp2).substring(0, 2));

                series.getData().add(new XYChart.Data(dia, Double.parseDouble(pres)));

            }
            else if (dat.getText().equals("viento")){
                Double vie = recol.getVellv2(temp2);
                dia = recol.getFrom(temp2).substring(0, 2);
                System.out.println(recol.getFrom(temp2).substring(0, 2));

                //System.out.println(vie+"HGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGYTFYTU&F&TYYYYYYYY&Tfdd");

                series.getData().add(new XYChart.Data(dia,(vie)));

            }

        }
    }


}


