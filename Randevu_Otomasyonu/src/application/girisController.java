package application;


import java.net.URL;
import java.util.ResourceBundle;

import com.randevuMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;



public class girisController {
	
	public girisController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngiris;

    @FXML
    private Button btnkapat;

    @FXML
    private Button btnkayit;

    @FXML
    private Button btnsifreunut;
    
    @FXML
    private Button geri;

    @FXML
    private AnchorPane scenePane;
  
    @FXML
    private TextField sifre;

    @FXML
    public TextField tcgiris;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btngiris_click(ActionEvent event) {
    	sql="select*from kullanýcý_bilgileri where Tc=? and sifre=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, tcgiris.getText().trim());
    		sorguIfadesi.setString(2,VeritabaniUtil.MD5Sifrele(sifre.getText().trim()));
    		
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next()) {
    			Alert alert=new Alert(AlertType.WARNING);
        		alert.setTitle("Randevu Sistemi");
        		alert.setHeaderText("Uyarý Mesajý...");
        		alert.setContentText("Lütfen bilgilerinizi kontrol ediniz...");
        		alert.showAndWait();
    		}
    		else {
    			//getirilen.getString(1);//Tabloda 1.sutundaki degeri getiriyor.
    			//System.out.println("kId:"+getirilen.getString("kid"));
    			   try{
    			        Stage stage1=new Stage();
    			        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("tanitim.fxml"));
    			        stage1.setScene(new Scene(pane1));
    			        stage1.initStyle(StageStyle.UNDECORATED);
    			        stage1.show();
    			        Stage stage = (Stage) btnkapat.getScene().getWindow();
    			        stage.close();
    			        
    			     }
    			     catch(Exception e){
    			           System.out.println(e.toString());
    			      }
    			    	
    			       
    		}
    		
    	}catch(Exception e) {
    		
    	}
    	
       
    }

    @FXML
    void btnkapat_click(ActionEvent event) {
    	Stage stage = (Stage) btnkapat.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnkayit_click(ActionEvent event) {
    	try{
            Stage stage2=new Stage();
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("kayitol.fxml"));
            stage2.setScene(new Scene(pane2));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

    }

    @FXML
    void btnsifreunut_click(ActionEvent event) {
    	try{
            Stage stage3=new Stage();
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("sifreunuttum.fxml"));
            stage3.setScene(new Scene(pane3));
            stage3.initStyle(StageStyle.UNDECORATED);
            stage3.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

    }
    @FXML
    void geri_click(ActionEvent event) {
    	try{
            Stage stage4=new Stage();
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("girissayfa.fxml"));
            stage4.setScene(new Scene(pane4));
            stage4.initStyle(StageStyle.UNDECORATED);
            stage4.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	Stage stage = (Stage) btnkapat.getScene().getWindow();
        stage.close();

    }
   

    @FXML
    void initialize() {
     
    }

}

