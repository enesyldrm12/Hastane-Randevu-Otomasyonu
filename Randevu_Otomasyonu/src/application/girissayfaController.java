package application;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class girissayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MediaView mediaview;

   
    @FXML
    private Button play;
    
    @FXML
    private Button kapat;
    
    @FXML
    private Button randevu;

    @FXML
    private Button retry;
    
    @FXML
    private Button pause;
    
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;
    
    @FXML
    private Pane antibiyotikp;
    
    @FXML
    private Pane elyýkamap;

   
    
    @FXML
    void btn1_click(ActionEvent event) {
    	elyýkamap.setVisible(false);
    	antibiyotikp.setVisible(true);
    	
    	

    }

    @FXML
    void btn2_click(ActionEvent event) {
    	elyýkamap.setVisible(true);
    	antibiyotikp.setVisible(false);
    	
    	

    }

    @FXML
    void kapat_click(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void randevu_click(ActionEvent event) {
    	try{
            Stage stage1=new Stage();
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("giris.fxml"));
            stage1.setScene(new Scene(pane1));
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	
    	Stage stage = (Stage) kapat.getScene().getWindow();
        stage.close();

    }
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    
    
    @FXML
    void playmedia(ActionEvent event) {
    	mediaPlayer.play();
    	play.setVisible(false);
    	pause.setVisible(true);
    	
    }
    @FXML
    void pausemedia(ActionEvent event) {
    	mediaPlayer.pause();
    	pause.setVisible(false);
    	play.setVisible(true);
    }

    @FXML
    void retrymedia(ActionEvent event) {
    	mediaPlayer.seek(Duration.seconds(0.0));

    }

    @FXML
    void initialize() {
       file= new File("sigara.mp4");
       media=new Media(file.toURI().toString());
       mediaPlayer=new MediaPlayer(media);
       mediaview.setMediaPlayer(mediaPlayer);
       
       
       pause.setVisible(false);
       antibiyotikp.setVisible(false);
       

    }
    

}
