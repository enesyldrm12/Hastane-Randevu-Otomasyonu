package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;
import com.randevuMySQL.Util.VeritabaniUtil;


public class kayitolController {
	
	public kayitolController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button kapat;

    @FXML
    private Button kayýtol;
    
    @FXML
    private Button gerigit;

    @FXML
    private TextField sifre;

    @FXML
    private TextField sifretekrar;

    @FXML
    private TextField soyad;
    
    @FXML
    private TextField ad;

    @FXML
    private TextField tc;

    @FXML
    private TextField telefon;
    
    @FXML
    private Label label;
   
    @FXML
    void kapat_click(ActionEvent event) {
    	Stage stage = (Stage) kapat.getScene().getWindow();
        stage.close();
    }
    
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
    	Stage stage = (Stage) kapat.getScene().getWindow();
        stage.close();


    }
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql2;

    @FXML
    void kayýtol_click(ActionEvent event) {
 
    	int Tc=tc.getText().length();
    	int Ad=ad.getText().length();
    	int Soyad=soyad.getText().length();
    	int Telefon=telefon.getText().length();
    	String Sifre=sifre.getText();
    	String Sifretekrar=sifretekrar.getText();
    	
    	if(Tc==11 && Telefon==10 && Ad!=0 && Soyad!=0 && Sifre!="" && Sifretekrar!="" && Sifre.equals(Sifretekrar)) {

        	sql2="insert into kullanýcý_bilgileri(Tc,ad,soyad,sifre,telefon) values(?,?,?,?,?)";
        	try {
        		sorguIfadesi=baglanti.prepareStatement(sql2);
        		sorguIfadesi.setString(1, tc.getText());
        		sorguIfadesi.setString(2, ad.getText().trim());
        		sorguIfadesi.setString(3, soyad.getText().trim());
        		sorguIfadesi.setString(4, VeritabaniUtil.MD5Sifrele(sifre.getText().trim()));
        		sorguIfadesi.setString(5, telefon.getText());
       
        	    sorguIfadesi.executeUpdate();
     
        	}
        	catch(Exception e) {
        		
        	}
    		Alert alert=new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("KAYITI ONAYLIYOR MUSUNUZ?");
    		
    		ButtonType btn1=new ButtonType("EVET");
    		ButtonType btn2=new ButtonType("HAYIR");
    		
    		alert.getButtonTypes().setAll(btn1,btn2);
    		Optional<ButtonType> sonuc=alert.showAndWait();
    		
    		if(sonuc.get()==btn1) {
    			label.setText("KAYDEDÝLDÝ...");
    			tc.clear();
    			ad.clear();
    			soyad.clear();
    			telefon.clear();
    			sifre.clear();
    			sifretekrar.clear();
    			
    		}
    		
    	}
    	
    	else if(Tc!=11) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("TC KÝMLÝK NUMARANIZI KONTROL EDÝNÝZ.11 HANELÝ OLMALIDIR.");
    		alert.showAndWait();
    	}
    	else if(Telefon !=10) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("Telefon numaranýzý kontrol edin ve baþýnda 0 olmadan giriniz...");
    		alert.showAndWait();
    	}
    	else if(Ad==0||Soyad==0||Sifre.isEmpty()||Sifretekrar.isEmpty()) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("Lütfen Boþ Alanlarý Doldurunuz...");
    		alert.showAndWait();
    	}
    	else if(!(Sifre.equals(Sifretekrar))) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("Þifre ve Þifre tekrar kontrol ediniz...");
    		alert.showAndWait();
    	}
    	
    }

    @FXML
    void initialize() {
       

    }

}
