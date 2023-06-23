package application;



import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.randevuMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;

public class anaformController {
	public anaformController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private Button btncikis;
    
    @FXML
    private Button kapat;
    
    @FXML
    private Button sifredegistir;
    
    @FXML
    private ComboBox<String> hastane;

    @FXML
    private ComboBox<String> hekim;

    @FXML
    private ComboBox<String> il;

    @FXML
    private ComboBox<String> ilce;

    @FXML
    private ComboBox<String> klinik;

    @FXML
    private ComboBox<String> muayeneyeri;
    
    

    @FXML
    private Button randevuAl;

    @FXML
    private Button gericik;
    
    @FXML
    private TextField tc;
    
    @FXML
    private Spinner<Integer> spin1;

    @FXML
    private Spinner<Integer> spin2;
    
    @FXML
    private Label label;
    
    @FXML
    void kapat_click(ActionEvent event) {
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
    	Stage stage = (Stage) btncikis.getScene().getWindow();
        stage.close();
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
    void btncikis_click(ActionEvent event) {
    	try{
            Stage stage1=new Stage();
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("giris.fxml"));
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.setScene(new Scene(pane1));
            stage1.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
                
            }
    	Stage stage = (Stage) btncikis.getScene().getWindow();
        stage.close();

    }
    @FXML
    void sifredegistir_click(ActionEvent event) {
    	try{
            Stage stage1=new Stage();
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("sifredegistir.fxml"));
            stage1.setScene(new Scene(pane1));
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

    }
    
    @FXML
    void il_click(ActionEvent event) {
    	 int a=il.getSelectionModel().getSelectedIndex();
    	ilce.getItems().clear();
    	if(a==0) {
    		String[] dizi0= {"ALADA�","CEYHAN","�UKUROVA","FEKE","�MAMO�LU","KARA�SALI","KARATA�","KOZAN","POZANTI","SA�MBEYL�","SARI�AM","SEYHAN","TUFANBEYL�","YUMURTALIK","Y�RE��R"};
       	   ilce.getItems().addAll(dizi0);
    	}
    	else if(a==1) {
    		String[] dizi1= {"BESN�","�EL�KHAN","GERGER","G�LBA�I","KAHTA","MERKEZ","SAMSAT","S�NC�K","TUT"};
       	   ilce.getItems().addAll(dizi1);
    	}
    	else if(a==2) {
    		String[] dizi2= {"BA�MAK�I","BAYAT","BOLVAD�N","�AY","�OBANLAR","DAZKIRI","D�NAR","EM�RDA�","EVC�LER","HOCALAR","�HSAN�YE","�SCEH�SAR","KIZIL�REN","MERKEZ","SANDIKLI","S�NANPA�A","SULTANDA�I","�UHUT"};
       	   ilce.getItems().addAll(dizi2);
    	}
    	else if(a==3) {
        	String[] dizi3= {"D�YAD�N","DO�UBAYAZIT","ELE�K�RT","HAMUR","MERKEZ","PATNOS","TA�LI�AY","TUTAK"};
           	ilce.getItems().addAll(dizi3);
        }
    	else if(a==4) {
        	String[] dizi4= {"A�A��REN","ESK�L","G�LA�A�","G�ZELYURT","MERKEZ","ORTAK�Y","SARIYAH��","SULTANHANI"};
           	ilce.getItems().addAll(dizi4);
        }
    	else if(a==5) {
        	String[] dizi5= {"G�YN�CEK","G�M��HACIK�Y","HAMAM�Z�","MERKEZ","MERZ�FON","SULUOVA","TA�OVA"};
           	ilce.getItems().addAll(dizi5);
        }
    	else if(a==6) {
        	String[] dizi6= {"AKYURT","ALTINDA�","AYA�","BALA","BEYPAZARI","�AMLIDERE","�ANKAYA","�UBUK","ELMADA�","ET�MESGUT","EVREN","G�LBA�I","G�D�L","HAYMANA","KAHRAMANKAZAN","KALEC�K","KE���REN","KIZILCAHAMAM","MAMAK","NALLIHAN","POLATLI","PURSAKLAR","S�NCAN","�EREFL�KO�H�SAR","YEN�MAHALLE"};
           	ilce.getItems().addAll(dizi6);
        }
    	else if(a==7) {
        	String[] dizi7= {"AKSEK�","AKSU","ALANYA","DEMRE","D��EMEALTI","ELMALI","F�N�KE","GAZ�PA�A","G�NDO�MU�","�BRADI","KA�","KEMER","KEPEZ","KONYAALTI","KORKUTEL�","KUMLUCA","MANAVGAT","MURATPA�A","SER�K"};
           	ilce.getItems().addAll(dizi7);
        }
    	else if(a==8) {
        	String[] dizi8= {"�ILDIR","DAMAL","G�LE","HANAK","MERKEZ","POSOF"};
           	ilce.getItems().addAll(dizi8);
        }
    	else if(a==9) {
        	String[] dizi9= {"ARDANU�","ARHAV�","BOR�KA","HOPA","KEMALPA�A","MERKEZ","MURGUL","�AV�AT","YUSUFEL�"};
           	ilce.getItems().addAll(dizi9);
        }
    	else if(a==10) {
        	String[] dizi10= {"BOZDO�AN","BUHARKENT","��NE","D�D�M","EFELER","GERMENC�K","�NC�RL�OVA","KARACASU","KARPUZLU","KO�ARLI","K��K","KU�ADASI","KUYUCAK","NAZ�LL�","S�KE","SULTANH�SAR","YEN�PAZAR"};
           	ilce.getItems().addAll(dizi10);
        }
    	else if(a==11) {
        	String[] dizi11= {"ALTIEYL�L","AYVALIK","BALYA","BANDIRMA","B�GAD��","BURHAN�YE","DURSUNBEY","EDREM�T","ERDEK","G�ME�","G�NEN","HAVRAN","�VR�ND�","KARES�","KEPSUT","MANYAS","MARMARA","SAVA�TEPE","SINDIRGI","SUSURLUK"};
           	ilce.getItems().addAll(dizi11);
        }
    	else if(a==12) {
        	String[] dizi12= {"AMASRA","KURUCA��LE","MERKEZ","ULUS"};
           	ilce.getItems().addAll(dizi12);
        }
    	else if(a==13) {
        	String[] dizi13= {"BE��R�","GERC��","HASANKEYF","KOZLUK","MERKEZ","SASON"};
           	ilce.getItems().addAll(dizi13);
        }
    	else if(a==14) {
        	String[] dizi14= {"AYDINTEPE","DEM�R�Z�","MERKEZ"};
           	ilce.getItems().addAll(dizi14);
        }
    	else if(a==15) {
        	String[] dizi15= {"BOZ�Y�K","G�LPAZARI","�NH�SAR","MERKEZ","OSMANEL�","PAZARYER�","S���T","YEN�PAZAR"};
           	ilce.getItems().addAll(dizi15);
        }
    	else if(a==16) {
        	String[] dizi16= {"ADAKLI","GEN�","KARLIOVA","K��I","MERKEZ","SOLHAN","YAYLADERE","YED�SU"};
           	ilce.getItems().addAll(dizi16);
        }
    	else if(a==17) {
        	String[] dizi17= {"AD�LCEVAZ","AHLAT","G�ROYMAK","H�ZAN","MERKEZ","MUTK�","TATVAN"};
           	ilce.getItems().addAll(dizi17);
        }
    	else if(a==18) {
        	String[] dizi18= {"D�RTD�VAN","GEREDE","G�YN�K","KIBRISCIK","MENGEN","MERKEZ","MUDURNU","SEBEN","YEN��A�A"};
           	ilce.getItems().addAll(dizi18);
        }
    	else if(a==19) {
        	String[] dizi19= {"A�LASUN","ALTINYAYLA","BUCAK","�AVDIR","�ELT�K��","G�LH�SAR","KARAMANLI","KEMER","MERKEZ","TEFENN�","YE��LOVA"};
           	ilce.getItems().addAll(dizi19);
        }
    	else if(a==20) {
        	String[] dizi20= {"B�Y�KORHAN","GEML�K","G�RSU","HARMANCIK","�NEG�L","�ZN�K","KARACABEY","KELES","KESTEL","MUDANYA","MUSTAFAKEMALPA�A","N�L�FER","ORHANEL�","ORHANGAZ�","OSMANGAZ�","YEN��EH�R","YILDIRIM"};
           	ilce.getItems().addAll(dizi20);
        }
    	else if(a==21) {
        	String[] dizi21= {"AYVACIK","BAYRAM��","B�GA","BOZCAADA","�AN","ECEABAT","EZ�NE","GEL�BOLU","G�K�EADA","LAPSEK�","MERKEZ","YEN�CE"};
           	ilce.getItems().addAll(dizi21);
        }
    	else if(a==22) {
        	String[] dizi22= {"ATKARACALAR","BAYRAM�REN","�ERKE�","ELD�VAN","ILGAZ","KIZILIRMAK","KORGUN","KUR�UNLU","MERKEZ","ORTA","�ABAN�Z�","YAPRAKLI"};
           	ilce.getItems().addAll(dizi22);
        }
    	else if(a==23) {
        	String[] dizi23= {"ALACA","BAYAT","BO�AZKALE","DODURGA","�SK�L�P","KARGI","LA��N","MEC�T�Z�","MERKEZ","O�UZLAR","ORTAK�Y","OSMANCIK","SUNGURLU","U�URLUDA�"};
           	ilce.getItems().addAll(dizi23);
        }
    	else if(a==24) {
        	String[] dizi24= {"ACIPAYAM","BABADA�","BAKLAN","BEK�LL�","BEYA�A�","BOZKURT","BULDAN","�AL","�AMEL�","�ARDAK","��VR�L","G�NEY","HONAZ","KALE","MERKEZEFEND�","PAMUKKALE","SARAYK�Y","SER�NH�SAR","TAVAS"};
           	ilce.getItems().addAll(dizi24);
        }
    	else if(a==25) {
        	String[] dizi25= {"BA�LAR","B�SM�L","�ERM�K","�INAR","��NG��","D�CLE","E��L","ERGAN�","HAN�","HAZRO","KAYAPINAR","KOCAK�Y","KULP","L�CE","S�LVAN","SUR","YEN��EH�R"};
           	ilce.getItems().addAll(dizi25);
        }
    	else if(a==26) {
        	String[] dizi26= {"AK�AKOCA","CUMAYER�","��L�ML�","G�LYAKA","G�M��OVA","KAYNA�LI","MERKEZ","YI�ILCA"};
           	ilce.getItems().addAll(dizi26);
        }
    	else if(a==27) {
        	String[] dizi27= {"ENEZ","HAVSA","�PSALA","KE�AN","LALAPA�A","MER��","MERKEZ","S�LO�LU","UZUNK�PR�"};
           	ilce.getItems().addAll(dizi27);
        }
    	else if(a==28) {
        	String[] dizi28= {"A�IN","ALACAKAYA","ARICAK","BASK�L","KARAKO�AN","KEBAN","KOVANCILAR","MADEN","MERKEZ","PALU","S�VR�CE"};
           	ilce.getItems().addAll(dizi28);
        }
    	else if(a==29) {
        	String[] dizi29= {"�AYIRLI","�L��","KEMAH","KEMAL�YE","MERKEZ","OTLUKBEL�","REFAH�YE","TERCAN","�Z�ML�"};
           	ilce.getItems().addAll(dizi29);
        }
    	
    	else if(a==30) {
        	String[] dizi31= {"A�KALE","AZ�Z�YE","�AT","HINIS","HORASAN","�SP�R","KARA�OBAN","KARAYAZI","K�PR�K�Y","NARMAN","OLTU","OLUR","PALAND�KEN","PAS�NLER","PAZARYOLU","�ENKAYA","TEKMAN","TORTUM","UZUNDERE","YAKUT�YE"};
           	ilce.getItems().addAll(dizi31);
        }
    	else if(a==31) {
        	String[] dizi32= {"ALPU","BEYL�KOVA","��FTELER","G�NY�Z�","HAN","�N�N�","MAHMUD�YE","M�HALGAZ�","M�HALI��IK","ODUNPAZARI","SARICAKAYA","SEY�TGAZ�","S�VR�H�SAR","TEPEBA�I"};
           	ilce.getItems().addAll(dizi32);
        }
    	else if(a==32) {
        	String[] dizi33= {"ARABAN","�SLAH�YE","KARKAMI�","N�Z�P","NURDA�I","O�UZEL�","�AH�NBEY","�EH�TKAM�L","YAVUZEL�"};
           	ilce.getItems().addAll(dizi33);
        }
    	else if(a==33) {
        	String[] dizi34= {"ALUCRA","BULANCAK","�AMOLUK","�ANAK�I","DEREL�","DO�ANKENT","ESP�YE","EYNES�L","G�RELE","G�CE","KE�AP","MERKEZ","P�RAZ�Z","�EB�NKARAH�SAR","T�REBOLU","YA�LIDERE"};
           	ilce.getItems().addAll(dizi34);
        }
    	else if(a==34) {
        	String[] dizi35= {"KELK�T","K�SE","K�RT�N","MERKEZ","��RAN","TORUL"};
           	ilce.getItems().addAll(dizi35);
        }
    	else if(a==35) {
        	String[] dizi36= {"�UKURCA","DEREC�K","MERKEZ","�EMD�NL�","Y�KSEKOVA"};
           	ilce.getItems().addAll(dizi36);
        }
    	else if(a==36) {
        	String[] dizi37= {"ALTIN�Z�","ANTAKYA","ARSUZ","BELEN","DEFNE","D�RTYOL","ERZ�N","HASSA","�SKENDERUN","KIRIKHAN","KUMLU","PAYAS","REYHANLI","SAMANDA�","YAYLADA�I"};
           	ilce.getItems().addAll(dizi37);
        }
    	else if(a==37) {
        	String[] dizi38= {"ARALIK","KARAKOYUNLU","MERKEZ","TUZLUCA"};
           	ilce.getItems().addAll(dizi38);
        }
    	else if(a==38) {
        	String[] dizi39= {"AKSU","ATABEY","E��RD�R","GELENDOST","G�NEN","KE��BORLU","MERKEZ","SEN�RKENT","S�T��LER","�ARK�KARAA�A�","ULUBORLU","YALVA�","YEN��ARBADEML�"};
           	ilce.getItems().addAll(dizi39);
        }
    	else if(a==39) {
        	String[] dizi40= {"ADALAR","ARNAVUTK�Y","ATA�EH�R","AVCILAR","BA�CILAR","BAH�EL�EVLER","BAKIRK�Y","BA�AK�EH�R","BAYRAMPA�A","BE��KTA�","BEYKOZ","BEYL�KD�Z�","BEYO�LU","B�Y�K�EKMECE","�ATALCA","�EKMEK�Y","ESENLER","ESENYURT","EY�PSULTAN","FAT�H","GAZ�OSMANPA�A","G�NG�REN","KADIK�Y","KA�ITHANE","KARTAL","K���K�EKMECE","MALTEPE","PEND�K","SANCAKTEPE","SARIYER","S�L�VR�","SULTANBEYL�","SULTANGAZ�","��LE","���L�","TUZLA","�MRAN�YE","�SK�DAR","ZEYT�NBURNU"};
           	ilce.getItems().addAll(dizi40);
        }
    	else if(a==40) {
        	String[] dizi41= {"AL�A�A","BAL�OVA","BAYINDIR","BAYRAKLI","BERGAMA","BEYDA�","BORNOVA","BUCA","�E�ME","���L�","D�K�L�","FO�A","GAZ�EM�R","G�ZELBAH�E","KARABA�LAR","KARABURUN","KAR�IYAKA","KEMALPA�A","KINIK","K�RAZ","KONAK","MENDERES","MENEMEN","NARLIDERE","�DEM��","SEFER�H�SAR","SEL�UK","T�RE","TORBALI","URLA"};
           	ilce.getItems().addAll(dizi41);
        }
    	else if(a==41) {
        	String[] dizi42= {"AF��N","ANDIRIN","�A�LAYANCER�T","DULKAD�RO�LU","EK�N�Z�","ELB�STAN","G�KSUN","NURHAK","ON�K��UBAT","PAZARCIK","T�RKO�LU"};
           	ilce.getItems().addAll(dizi42);
        }
    	else if(a==42) {
        	String[] dizi43= {"EFLAN�","ESK�PAZAR","MERKEZ","OVACIK","SAFRANBOLU","YEN�CE"};
           	ilce.getItems().addAll(dizi43);
        }
    	else if(a==43) {
        	String[] dizi44= {"AYRANCI","BA�YAYLA","ERMENEK","KAZIMKARABEK�R","MERKEZ","SARIVEL�LER"};
           	ilce.getItems().addAll(dizi44);
        }
    	else if(a==44) {
        	String[] dizi45= {"AKYAKA","ARPA�AY","D�GOR","KA�IZMAN","MERKEZ","SARIKAMI�","SEL�M","SUSUZ"};
           	ilce.getItems().addAll(dizi45);
        }
    	else if(a==45) {
        	String[] dizi46= {"ABANA","A�LI","ARA�","AZDAVAY","BOZKURT","C�DE","�ATALZEYT�N","DADAY","DEVREKAN�","DO�ANYURT","HAN�N�","�HSANGAZ�","�NEBOLU","K�RE","MERKEZ","PINARBA�I","SEYD�LER","�ENPAZAR","TA�K�PR�","TOSYA"};
           	ilce.getItems().addAll(dizi46);
        }
    	else if(a==46) {
        	String[] dizi47= {"AKKI�LA","B�NYAN","DEVEL�","FELAH�YE","HACILAR","�NCESU","KOCAS�NAN","MEL�KGAZ�","�ZVATAN","PINARBA�I","SARIO�LAN","SARIZ","TALAS","TOMARZA","YAHYALI","YE��LH�SAR"};
           	ilce.getItems().addAll(dizi47);
        }
    	else if(a==47) {
        	String[] dizi48= {"BAH�ILI","BALI�EYH","�ELEB�","DEL�CE","KARAKE��L�","KESK�N","MERKEZ","SULAKYURT","YAH��HAN"};
           	ilce.getItems().addAll(dizi48);
        }
    	else if(a==48) {
        	String[] dizi49= {"BABAESK�","DEM�RK�Y","KOF�AZ","L�LEBURGAZ","MERKEZ","PEHL�VANK�Y","PINARH�SAR","V�ZE"};
           	ilce.getItems().addAll(dizi49);
        }
    	else if(a==49) {
        	String[] dizi50= {"AK�AKENT","AKPINAR","BOZTEPE","���EKDA�I","KAMAN","MERKEZ","MUCUR"};
           	ilce.getItems().addAll(dizi50);
        }
    	else if(a==50) {
        	String[] dizi51= {"ELBEYL�","MERKEZ","MUSABEYL�","POLATEL�"};
           	ilce.getItems().addAll(dizi51);
        }
    	else if(a==51) {
        	String[] dizi52= {"BA��SKELE","�AYIROVA","DARICA","DER�NCE","D�LOVASI","GEBZE","G�LC�K","�ZM�T","KANDIRA","KARAM�RSEL","KARTEPE","K�RFEZ"};
           	ilce.getItems().addAll(dizi52);
        }
    	else if(a==52) {
        	String[] dizi53= {"AHIRLI","AK�REN","AK�EH�R","ALTINEK�N","BEY�EH�R","BOZKIR","C�HANBEYL�","�ELT�K","�UMRA","DERBENT","DEREBUCAK","DO�ANH�SAR","EM�RGAZ�","ERE�L�","G�NEYSINIR","HAD�M","HALKAPINAR","H�Y�K","ILGIN","KADINHANI","KARAPINAR","KARATAY","KULU","MERAM","SARAY�N�","SEL�UKLU","SEYD��EH�R","TA�KENT","TUZLUK�U","YALIH�Y�K","YUNAK"};
           	ilce.getItems().addAll(dizi53);
        }
    	else if(a==53) {
        	String[] dizi54= {"ALTINTA�","ASLANAPA","�AVDARH�SAR","DOMAN��","DUMLUPINAR","EMET","GED�Z","H�SARCIK","MERKEZ","PAZARLAR","S�MAV","�APHANE","TAV�ANLI"};
           	ilce.getItems().addAll(dizi54);
        }
    	else if(a==54) {
        	String[] dizi55= {"AK�ADA�","ARAPG�R","ARGUVAN","BATTALGAZ�","DARENDE","DO�AN�EH�R","DO�ANYOL","HEK�MHAN","KALE","KULUNCAK","P�T�RGE","YAZIHAN","YE��LYURT"};
           	ilce.getItems().addAll(dizi55);
        }
    	else if(a==55) {
        	String[] dizi56= {"AHMETL�","AKH�SAR","ALA�EH�R","DEM�RC�","G�LMARMARA","G�RDES","KIRKA�A�","K�PR�BA�I","KULA","SAL�HL�","SARIG�L","SARUHANLI","SELEND�","SOMA","�EHZADELER","TURGUTLU","YUNUSEMRE"};
           	ilce.getItems().addAll(dizi56);
        }
    	else if(a==56) {
        	String[] dizi57= {"ARTUKLU","DARGE��T","DER�K","KIZILTEPE","MAZIDA�I","M�DYAT","NUSAYB�N","�MERL�","SAVUR","YE��LL�"};
           	ilce.getItems().addAll(dizi57);
        }
    	else if(a==57) {
        	String[] dizi58= {"AKDEN�Z","ANAMUR","AYDINCIK","BOZYAZI","�AMLIYAYLA","ERDEML�","G�LNAR","MEZ�TL�","MUT","S�L�FKE","TARSUS","TOROSLAR","YEN��EH�R"};
           	ilce.getItems().addAll(dizi58);
           	
        }
    	else if(a==58) {
        	String[] dizi60= {"BODRUM","DALAMAN","DAT�A","FETH�YE","KAVAKLIDERE","K�YCE��Z","MARMAR�S","MENTE�E","M�LAS","ORTACA","SEYD�KEMER","ULA","YATA�AN"};
           	ilce.getItems().addAll(dizi60);
        }
    	else if(a==59) {
        	String[] dizi61= {"BULANIK","HASK�Y","KORKUT","MALAZG�RT","MERKEZ","VARTO"};
           	ilce.getItems().addAll(dizi61);
        }
    	else if(a==60) {
        	String[] dizi62= {"ACIG�L","AVANOS","DER�NKUYU","G�L�EH�R","HACIBEKTA�","KOZAKLI","MERKEZ","�RG�P"};
           	ilce.getItems().addAll(dizi62);
        }
    	else if(a==61) {
        	String[] dizi63= {"ALTUNH�SAR","BOR","�AMARDI","��FTL�K","MERKEZ","ULUKI�LA"};
           	ilce.getItems().addAll(dizi63);
        }
    	else if(a==62) {
        	String[] dizi64= {"AKKU�","ALTINORDU","AYBASTI","�AMA�","�ATALPINAR","�AYBA�I","FATSA","G�LK�Y","G�LYALI","G�RGENTEPE","�K�ZCE","KABAD�Z","KABATA�","KORGAN","KUMRU","MESUD�YE","PER�EMBE","ULUBEY","�NYE"};
           	ilce.getItems().addAll(dizi64);
        }
    	else if(a==63) {
        	String[] dizi65= {"BAH�E","D�Z���","HASANBEYL�","KAD�RL�","MERKEZ","SUMBAS","TOPRAKKALE"};
           	ilce.getItems().addAll(dizi65);
        }
    	else if(a==64) {
        	String[] dizi66= {"ARDE�EN","�AMLIHEM��N","�AYEL�","DEREPAZARI","FINDIKLI","G�NEYSU","HEM��N","�K�ZDERE","�Y�DERE","KALKANDERE","MERKEZ","PAZAR"};
           	ilce.getItems().addAll(dizi66);
        }
    	else if(a==65) {
        	String[] dizi67= {"ADAPAZARI","AKYAZI","AR�F�YE","ERENLER","FER�ZL�","GEYVE","HENDEK","KARAP�R�EK","KARASU","KAYNARCA","KOCAAL�","PAMUKOVA","SAPANCA","SERD�VAN","S���TL�","TARAKLI"};
           	ilce.getItems().addAll(dizi67);
        }
        else if(a==66) {
        	String[] dizi68= {"19","ALA�AM","ASARCIK","ATAKUM","AYVACIK","BAFRA","CAN�K","�AR�AMBA","HAVZA","�LKADIM","KAVAK","LAD�K","SALIPAZARI","TEKKEK�Y","TERME","VEZ�RK�PR�","YAKAKENT"};
           	ilce.getItems().addAll(dizi68);
        }
        else if(a==67) {
        	String[] dizi69= {"BAYKAN","ERUH","KURTALAN","MERKEZ","PERVAR�","��RVAN","T�LLO"};
           	ilce.getItems().addAll(dizi69);
        }
        else if(a==68) {
        	String[] dizi70= {"AYANCIK","BOYABAT","D�KMEN","DURA�AN","ERFELEK","GERZE","MERKEZ","SARAYD�Z�","T�RKEL�"};
           	ilce.getItems().addAll(dizi70);
        }
        else if(a==69) {
        	String[] dizi71= {"AKINCILAR","ALTINYAYLA","D�VR���","DO�AN�AR","GEMEREK","G�LOVA","G�R�N","HAF�K","�MRANLI","KANGAL","KOYULH�SAR","MERKEZ","SU�EHR�","�ARKI�LA","ULA�","YILDIZEL�","ZARA"};
           	ilce.getItems().addAll(dizi71);
        }
        else if(a==70) {
        	String[] dizi72= {"AK�AKALE","B�REC�K","BOZOVA","CEYLANPINAR","EYY�B�YE","HALFET�","HAL�L�YE","HARRAN","H�LVAN","KARAK�PR�","S�VEREK","SURU�","V�RAN�EH�R"};
           	ilce.getItems().addAll(dizi72);
        }else if(a==71) {
        	String[] dizi73= {"BEYT���EBAP","C�ZRE","G��L�KONAK","�D�L","MERKEZ","S�LOP�","ULUDERE"};
           	ilce.getItems().addAll(dizi73);
        }
        else if(a==72) {
        	String[] dizi74= {"�ERKEZK�Y","�ORLU","ERGENE","HAYRABOLU","KAPAKLI","MALKARA","MARMARAERE�L�S�","MURATLI","SARAY","S�LEYMANPA�A","�ARK�Y"};
           	ilce.getItems().addAll(dizi74);
        }
        else if(a==73) {
        	String[] dizi75= {"ALMUS","ARTOVA","BA���FTL�K","ERBAA","MERKEZ","N�KSAR","PAZAR","RE�AD�YE","SULUSARAY","TURHAL","YE��LYURT","Z�LE"};
           	ilce.getItems().addAll(dizi75);
        }
        else if(a==74) {
        	String[] dizi76= {"AK�AABAT","ARAKLI","ARS�N","BE��KD�Z�","�AR�IBA�I","�AYKARA","DERNEKPAZARI","D�ZK�Y","HAYRAT","K�PR�BA�I","MA�KA","OF","ORTAH�SAR","S�RMENE","�ALPAZARI","TONYA","VAKFIKEB�R","YOMRA"};
           	ilce.getItems().addAll(dizi76);
        }
        else if(a==75) {
        	String[] dizi77= {"�EM��GEZEK","HOZAT","MAZG�RT","MERKEZ","NAZIM�YE","OVACIK","PERTEK","P�L�M�R"};
           	ilce.getItems().addAll(dizi77);
        }
        else if(a==76) {
        	String[] dizi78= {"BANAZ","E�ME","KARAHALLI","MERKEZ","S�VASLI","ULUBEY"};
           	ilce.getItems().addAll(dizi78);
        }
        else if(a==77) {
        	String[] dizi79= {"BAH�ESARAY","BA�KALE","�ALDIRAN","�ATAK","EDREM�T","ERC��","GEVA�","G�RPINAR","�PEKYOLU","MURAD�YE","�ZALP","SARAY","TU�BA"};
           	ilce.getItems().addAll(dizi79);
        }
        else if(a==78) {
        	String[] dizi80= {"ALTINOVA","ARMUTLU","�INARCIK","��FTL�KK�Y","MERKEZ","TERMAL"};
           	ilce.getItems().addAll(dizi80);
        }
        else if(a==79) {
        	String[] dizi81= {"AKDA�MADEN�","AYDINCIK","BO�AZLIYAN","�ANDIR","�AYIRALAN","�EKEREK","KADI�EHR�","MERKEZ","SARAYKENT","SARIKAYA","SORGUN","�EFAATL�","YEN�FAKILI","YERK�Y"};
           	ilce.getItems().addAll(dizi81);
        }
        else if(a==80) {
        	String[] dizi82= {"ALAPLI","�AYCUMA","DEVREK","ERE�L�","G�K�EBEY","K�L�ML�","KOZLU","MERKEZ"};
           	ilce.getItems().addAll(dizi82);
        }
    	
    }
   
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql6;
    @FXML
    void randevuAlClick(ActionEvent event) {
    	
    	int g=tc.getText().length();
    	int a=il.getSelectionModel().getSelectedIndex();
    	int b=ilce.getSelectionModel().getSelectedIndex();
    	int c=klinik.getSelectionModel().getSelectedIndex();
    	int d=hastane.getSelectionModel().getSelectedIndex();
    	int e=muayeneyeri.getSelectionModel().getSelectedIndex();
    	int f=hekim.getSelectionModel().getSelectedIndex();
        String value = date.getValue().toString();
    	String spinn1=spin1.getValue().toString() ;
    	String spinn2=spin2.getValue().toString() ;
    	
    	if(a<0 | b<0 | c<0 | d<0 |e<0 | f<0|g<0| value==null) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyar� Mesaj�...");
    		alert.setContentText("L�tfen Bo� Alan B�rakmay�n�z...");
    		alert.showAndWait();
    		
    	}
    	else if(g!=11) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyar� Mesaj�...");
    		alert.setContentText("TC K�ML�K NUMARANIZI KONTROL ED�N�Z.11 HANEL� OLMALIDIR.");
    		alert.showAndWait();
    		
    	}
    	else {
    		sql6="insert into randevular(Tc,il,ilce,klinik,hastane,muayeneyeri,hekim,saat,tarih) values(?,?,?,?,?,?,?,?,?)";
        	try {
        		sorguIfadesi=baglanti.prepareStatement(sql6);
        		sorguIfadesi.setString(1, tc.getText().trim());
        		sorguIfadesi.setString(2, il.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(3, ilce.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(4, klinik.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(5, hastane.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(6, muayeneyeri.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(7, hekim.getSelectionModel().getSelectedItem().trim());
        		sorguIfadesi.setString(8, spinn1+":"+spinn2+":00");
        		sorguIfadesi.setString(9,value);
        	    sorguIfadesi.executeUpdate();
        	    
        	    Alert alert1=new Alert(AlertType.CONFIRMATION);
        		alert1.setTitle("Randevu Sistemi");
        		alert1.setHeaderText("Randevuyu Onayl�yor Musunuz?");
        		alert1.setContentText("�L: "+il.getSelectionModel().getSelectedItem()+"\n"+"�L�E: "+ilce.getSelectionModel().getSelectedItem()+ "\n"+"HASTAHANE: "+hastane.getSelectionModel().getSelectedItem()+"\n" +"KL�N�K: " +klinik.getSelectionModel().getSelectedItem()+"\n"+"MUAYENE YER�: "+muayeneyeri.getSelectionModel().getSelectedItem()+"\n"+"HEK�M: " +hekim.getSelectionModel().getSelectedItem()+" Hoca \n"+"TAR�H: "+ value +"\n" +"SAAT: "+ spinn1+":"+spinn2);  
        		ButtonType btn1=new ButtonType("EVET");
        		ButtonType btn2=new ButtonType("HAYIR");
        		alert1.getButtonTypes().setAll(btn1,btn2);
        		Optional<ButtonType> sonuc2=alert1.showAndWait();
        		
        		if(sonuc2.get()==btn1) {
        			label.setText("KAYDED�LD�...");
        			tc.clear();
        		    il.getSelectionModel().clearSelection();
        		    ilce.getSelectionModel().clearSelection();
        		    hastane.getSelectionModel().clearSelection();
        		    klinik.getSelectionModel().clearSelection();
        		    muayeneyeri.getSelectionModel().clearSelection();
        		    hekim.getSelectionModel().clearSelection();
        		    date.setValue(null);			
        		}
     
        	}
        	catch(Exception e1) {
        		System.out.print("hata!");
        		
        	}
    	}

    }
    
   

    @FXML
    void initialize() {
    	
       il.setPromptText("Se�iniz...");
       String[] iller= {"ADANA", "ADIYAMAN", "AFYONKARAH�SAR", "A�RI", "AKSARAY", "AMASYA", "ANKARA", "ANTALYA", "ARDAHAN", "ARTV�N", "AYDIN", "BALIKES�R", "BARTIN", "BATMAN", "BAYBURT", "B�LEC�K", "B�NG�L", "B�TL�S", "BOLU", "BURDUR", "BURSA", "�ANAKKALE", "�ANKIRI", "�ORUM", "DEN�ZL�", "D�YARBAKIR", "D�ZCE", "ED�RNE", "ELAZI�", "ERZ�NCAN", "ERZURUM", "ESK��EH�R", "GAZ�ANTEP", "G�RESUN", "G�M��HANE", "HAKKAR�", "HATAY", "I�DIR", "ISPARTA", "�STANBUL", "�ZM�R", "KAHRAMANMARA�", "KARAB�K", "KARAMAN", "KARS", "KASTAMONU", "KAYSER�", "KIRIKKALE", "KIRKLAREL�", "KIR�EH�R", "K�L�S", "KOCAEL�", "KONYA", "K�TAHYA", "MALATYA", "MAN�SA", "MARD�N", "MERS�N", "MU�LA", "MU�", "NEV�EH�R", "N��DE", "ORDU", "OSMAN�YE", "R�ZE", "SAKARYA", "SAMSUN", "S��RT", "S�NOP", "S�VAS", "�ANLIURFA", "�IRNAK", "TEK�RDA�", "TOKAT", "TRABZON", "TUNCEL�", "U�AK", "VAN", "YALOVA", "YOZGAT", "ZONGULDAK"};
       il.getItems().addAll(iller);
       ilce.setPromptText("Se�iniz...");
      
       muayeneyeri.setPromptText("Se�iniz...");
       String[] muayene= {"Muayene 1","Muayene 2","Muayene 3"};
       muayeneyeri.getItems().addAll(muayene);
       
       klinik.setPromptText("Se�iniz...");
       String[] klinikler= {"ALGOLOJ�","BESLENME VE D�YET","BEY�N VE S�N�R CERRAH�S�","�OCUK ALERJ�S�","�OCUK CERRAH�S�","�OCUK ENDOKR�NOLOJ�S�","�OCUK ENFEKS�YON","�OCUK G���S HASTALIKLARI","�OCUK HEMATOLOJ�S�","�OCUK KARD�YOLOJ�S�","�OCUK METABOL�ZMA,�OCUK NEFROLOJ�S�,�OCUK N�ROLOJ�S�","�OCUK PS�K�YATR�S�","�OCUK SA�LI�I VE HASTALIKLARI","�OCUK �ROLOJ�S�,DERMATOLOJ� (C�LD�YE)","ENDOKR�NOLOJ� VE METABOL�ZMA","ENFEKS�YON HASTALIKLARI","F�Z�KSEL TIP VE REHAB�L�TASYON","GASTROENTEROLOJ�","GELENEKSEL VE TAMAMLAYICI TIP(GETAMER)","GENEL CERRAH�","GER�ATR�","G���S CERRAH�S�","G���S HASTALIKLARI","G�Z HASTALIKLARI","HEMATOLOJ�","�� HASTALIKLARI","KADIN HASTALIKLARI VE DO�UM","KALP VE DAMAR CERRAH�S�","KARD�YOLOJ�","KEM�K YO�UNLU�U �L��M�","KULAK-BURUN-BO�AZ HASTALIKLARI","NEFROLOJ�","N�ROLOJ�","ORTOPED� VE TRAVMATOLOJ�","PLAST�K REKONSTR�KT�F VE ESTET�K CERRAH�","PS�K�YATR�","RADYASYON ONKOLOJ�S�","TIBB� GENET�K","TIBB� PATOLOJ�","�ROLOJ�"};
       klinik.getItems().addAll(klinikler);
       
      hastane.setPromptText("Se�iniz...");
       String hast[]= {"A DEVLET HASTANES�","A �ZEL HASTANES�","B DEVLET HASTANES�","B �ZEL HASTANES�","C DEVLET HASTANES�","C �ZEL HASTANES�"};
       hastane.getItems().addAll(hast);
       
       hekim.setPromptText("Se�iniz...");
       String doktor[]= {"Ali","Veli","Ahmet","Mehmet","Mahmut","Kemal"};
       hekim.getItems().addAll(doktor);
       
       SpinnerValueFactory<Integer> clock=new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17,1);
       spin1.setValueFactory(clock);
       
       SpinnerValueFactory<Integer> minute=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50,00,10);
       spin2.setValueFactory(minute);
       
       
       
    }
};
       
       
    	   
       
    

