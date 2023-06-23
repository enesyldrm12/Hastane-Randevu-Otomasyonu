package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class sifredegistirController {
	public sifredegistirController() {
		baglanti=VeritabaniUtil.Baglan();
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button degistir;


    @FXML
    private Button gerigit;

    @FXML
    private Button kapat;

    @FXML
    private TextField kontrol;

    @FXML
    private TextField random;

    @FXML
    private TextField sifre;

    @FXML
    private TextField sifretekrar;

    @FXML
    private TextField tc;
    
    @FXML
    private Label label;

    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql5;

    @FXML
    void degistir_click(ActionEvent event) {
    	int Tc=tc.getText().length();
    	String Sifre=sifre.getText();
    	String Sifretekrar=sifretekrar.getText();
    	
    	if(Tc==11  && Sifre!="" && Sifretekrar!="" && Sifre.equals(Sifretekrar)) {
    		try {
    			sql5="update kullanýcý_bilgileri set sifre=? where Tc=?";
        		sorguIfadesi=baglanti.prepareStatement(sql5);
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
        			sifre.clear();
        			sifretekrar.clear();
        			kontrol.clear();
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
    	

    }
    
    
    
    @FXML
    void gerigit_click(ActionEvent event) {
    	try{
            Stage stage4=new Stage();
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("tanitim.fxml"));
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

    @FXML
    void kapat_click(ActionEvent event) {
    	Stage stage = (Stage) kapat.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        int a=(int)(Math.random()*100000);
    	random.setText(String.valueOf(a));
    }

}
