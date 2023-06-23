package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.randevuMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class tanitimController {
	
	public tanitimController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab gecrandevular;

    @FXML
    private Button randevual;

    @FXML
    private Tab randevularým;

    @FXML
    private Button tcikis;

    @FXML
    private Button tkapat;

    @FXML
    private Button tsifre;
    
    @FXML
    private Button gerigit;
    
    
    @FXML
    private TableColumn<kayýtlar_randevular, String> col_hastane;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_hekim;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_il;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_ilce;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_klinik;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_muayene;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_saat;

    @FXML
    private TableColumn<kayýtlar_randevular, String> col_tarih;

    @FXML
    private TableView<kayýtlar_randevular> tableview_kayýtlar;
    
    
    
    @FXML
    void gerigit_click(ActionEvent event) {
    	try{
            Stage stage4=new Stage();
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("giris.fxml"));
            stage4.setScene(new Scene(pane4));
            stage4.initStyle(StageStyle.UNDECORATED);
            stage4.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	Stage stage = (Stage) tkapat.getScene().getWindow();
        stage.close();
    }

    @FXML
    void randevual_click(ActionEvent event) {
    	try{
            Stage stage1=new Stage();
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("anaform.fxml"));
            stage1.setScene(new Scene(pane1));
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	Stage stage = (Stage) tcikis.getScene().getWindow();
        stage.close();
    }

    @FXML
    void tcikis_click(ActionEvent event) {
    	try{
            Stage stage2=new Stage();
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("giris.fxml"));
            stage2.setScene(new Scene(pane2));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	Stage stage = (Stage) tcikis.getScene().getWindow();
        stage.close();
    }

    @FXML
    void tkapat_click(ActionEvent event) {
    	try{
            Stage stage2=new Stage();
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("girissayfa.fxml"));
            stage2.setScene(new Scene(pane2));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	Stage stage = (Stage) tkapat.getScene().getWindow();
        stage.close();
    }

    @FXML
    void tsifre_click(ActionEvent event) {
    	try{
            Stage stage3=new Stage();
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("sifredegistir.fxml"));
            stage3.setScene(new Scene(pane3));
            stage3.initStyle(StageStyle.UNDECORATED);
            stage3.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

    }
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql2;
    
   
    
    public void degerleriGetir(TableView tablo) {
    	sql2="select *from randevular";
    	ObservableList<kayýtlar_randevular> kayitlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql2);
    	    getirilen=sorguIfadesi.executeQuery();
    	    while(getirilen.next()) {
    	    	kayitlarliste.add(new kayýtlar_randevular(getirilen.getString("il"),getirilen.getString("ilce"),getirilen.getString("klinik"),getirilen.getString("hastane"),getirilen.getString("muayeneyeri"),getirilen.getString("hekim"),getirilen.getString("saat"),getirilen.getString("tarih")));
    	    }
    	    col_il.setCellValueFactory(new PropertyValueFactory<>("il"));
    	    col_ilce.setCellValueFactory(new PropertyValueFactory<>("ilce"));
    	    col_klinik.setCellValueFactory(new PropertyValueFactory<>("klinik"));
    	    col_hastane.setCellValueFactory(new PropertyValueFactory<>("hastane"));
    	    col_muayene.setCellValueFactory(new PropertyValueFactory<>("muayeneyeri"));
    	    col_hekim.setCellValueFactory(new PropertyValueFactory<>("hekim"));
    	    col_saat.setCellValueFactory(new PropertyValueFactory<>("saat"));
    	    col_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    	    tableview_kayýtlar.setItems(kayitlarliste);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    	}
    	
    	
    }

    @FXML
    void initialize() {
    	degerleriGetir(tableview_kayýtlar);
       
    }

}
