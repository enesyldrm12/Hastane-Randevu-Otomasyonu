package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.randevuMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class sifreunuttumController {
	public sifreunuttumController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button kapat;

    @FXML
    private TextField random;
    
    @FXML
    private TextField kontrol;

    @FXML
    private TextField sifre;

    @FXML
    private Button sifredegis;
    
    @FXML
    private Button gericik;

    @FXML
    private TextField sifretekrar;

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
    void gericik_click(ActionEvent event) {
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
    String sql4;
    

    @FXML
    void sifredegis_click(ActionEvent event) {
    	int Tc=tc.getText().length();
    	int Telefon=telefon.getText().length();
    	String Sifre=sifre.getText();
    	String Sifretekrar=sifretekrar.getText();
    	String kon=kontrol.getText();
    	String ran=random.getText();    	

    	if(Tc==11 && Telefon==10 && Sifre!="" && Sifretekrar!="" && Sifre.equals(Sifretekrar) && ran.equals(kon)) {
    		try {
    			sql4="update kullanýcý_bilgileri set sifre=? where Tc=?";
        		sorguIfadesi=baglanti.prepareStatement(sql4);
                sorguIfadesi.setString(1,VeritabaniUtil.MD5Sifrele(sifre.getText().trim()));
                sorguIfadesi.setString(2,tc.getText().trim());
                sorguIfadesi.executeUpdate();
                
                Alert alert=new Alert(AlertType.CONFIRMATION);
        		alert.setTitle("Randevu Sistemi");
        		alert.setHeaderText("Uyarý Mesajý...");
        		alert.setContentText("KAYITI ONAYLIYOR MUSUNUZ?");
        		
        		ButtonType btn1=new ButtonType("EVET");
        		ButtonType btn2=new ButtonType("HAYIR");
        		
        		alert.getButtonTypes().setAll(btn1,btn2);
        		Optional<ButtonType> sonuc=alert.showAndWait();
        		
        		if(sonuc.get()==btn1) {
        			label.setText("DEGÝÞTÝRÝLDÝ...");
        			tc.clear();
        			telefon.clear();
        			sifre.clear();
        			sifretekrar.clear();
        		}
        		
    		}   
    		catch(Exception e) {}
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
    	else if(Sifre.isEmpty() || Sifretekrar.isEmpty()) {
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
    	else if(!(ran.equals(kon))) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("Lütfen sayýsal degeri dogru giriniz...");
    		alert.showAndWait();
    	}
    	
    }
    @FXML
    void initialize() {
    	int a=(int)(Math.random()*100000);
    	
    	random.setText(String.valueOf(a));

    }

}
