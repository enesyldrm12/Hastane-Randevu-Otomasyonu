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
    		String[] dizi0= {"ALADAÐ","CEYHAN","ÇUKUROVA","FEKE","ÝMAMOÐLU","KARAÝSALI","KARATAÞ","KOZAN","POZANTI","SAÝMBEYLÝ","SARIÇAM","SEYHAN","TUFANBEYLÝ","YUMURTALIK","YÜREÐÝR"};
       	   ilce.getItems().addAll(dizi0);
    	}
    	else if(a==1) {
    		String[] dizi1= {"BESNÝ","ÇELÝKHAN","GERGER","GÖLBAÞI","KAHTA","MERKEZ","SAMSAT","SÝNCÝK","TUT"};
       	   ilce.getItems().addAll(dizi1);
    	}
    	else if(a==2) {
    		String[] dizi2= {"BAÞMAKÇI","BAYAT","BOLVADÝN","ÇAY","ÇOBANLAR","DAZKIRI","DÝNAR","EMÝRDAÐ","EVCÝLER","HOCALAR","ÝHSANÝYE","ÝSCEHÝSAR","KIZILÖREN","MERKEZ","SANDIKLI","SÝNANPAÞA","SULTANDAÐI","ÞUHUT"};
       	   ilce.getItems().addAll(dizi2);
    	}
    	else if(a==3) {
        	String[] dizi3= {"DÝYADÝN","DOÐUBAYAZIT","ELEÞKÝRT","HAMUR","MERKEZ","PATNOS","TAÞLIÇAY","TUTAK"};
           	ilce.getItems().addAll(dizi3);
        }
    	else if(a==4) {
        	String[] dizi4= {"AÐAÇÖREN","ESKÝL","GÜLAÐAÇ","GÜZELYURT","MERKEZ","ORTAKÖY","SARIYAHÞÝ","SULTANHANI"};
           	ilce.getItems().addAll(dizi4);
        }
    	else if(a==5) {
        	String[] dizi5= {"GÖYNÜCEK","GÜMÜÞHACIKÖY","HAMAMÖZÜ","MERKEZ","MERZÝFON","SULUOVA","TAÞOVA"};
           	ilce.getItems().addAll(dizi5);
        }
    	else if(a==6) {
        	String[] dizi6= {"AKYURT","ALTINDAÐ","AYAÞ","BALA","BEYPAZARI","ÇAMLIDERE","ÇANKAYA","ÇUBUK","ELMADAÐ","ETÝMESGUT","EVREN","GÖLBAÞI","GÜDÜL","HAYMANA","KAHRAMANKAZAN","KALECÝK","KEÇÝÖREN","KIZILCAHAMAM","MAMAK","NALLIHAN","POLATLI","PURSAKLAR","SÝNCAN","ÞEREFLÝKOÇHÝSAR","YENÝMAHALLE"};
           	ilce.getItems().addAll(dizi6);
        }
    	else if(a==7) {
        	String[] dizi7= {"AKSEKÝ","AKSU","ALANYA","DEMRE","DÖÞEMEALTI","ELMALI","FÝNÝKE","GAZÝPAÞA","GÜNDOÐMUÞ","ÝBRADI","KAÞ","KEMER","KEPEZ","KONYAALTI","KORKUTELÝ","KUMLUCA","MANAVGAT","MURATPAÞA","SERÝK"};
           	ilce.getItems().addAll(dizi7);
        }
    	else if(a==8) {
        	String[] dizi8= {"ÇILDIR","DAMAL","GÖLE","HANAK","MERKEZ","POSOF"};
           	ilce.getItems().addAll(dizi8);
        }
    	else if(a==9) {
        	String[] dizi9= {"ARDANUÇ","ARHAVÝ","BORÇKA","HOPA","KEMALPAÞA","MERKEZ","MURGUL","ÞAVÞAT","YUSUFELÝ"};
           	ilce.getItems().addAll(dizi9);
        }
    	else if(a==10) {
        	String[] dizi10= {"BOZDOÐAN","BUHARKENT","ÇÝNE","DÝDÝM","EFELER","GERMENCÝK","ÝNCÝRLÝOVA","KARACASU","KARPUZLU","KOÇARLI","KÖÞK","KUÞADASI","KUYUCAK","NAZÝLLÝ","SÖKE","SULTANHÝSAR","YENÝPAZAR"};
           	ilce.getItems().addAll(dizi10);
        }
    	else if(a==11) {
        	String[] dizi11= {"ALTIEYLÜL","AYVALIK","BALYA","BANDIRMA","BÝGADÝÇ","BURHANÝYE","DURSUNBEY","EDREMÝT","ERDEK","GÖMEÇ","GÖNEN","HAVRAN","ÝVRÝNDÝ","KARESÝ","KEPSUT","MANYAS","MARMARA","SAVAÞTEPE","SINDIRGI","SUSURLUK"};
           	ilce.getItems().addAll(dizi11);
        }
    	else if(a==12) {
        	String[] dizi12= {"AMASRA","KURUCAÞÝLE","MERKEZ","ULUS"};
           	ilce.getItems().addAll(dizi12);
        }
    	else if(a==13) {
        	String[] dizi13= {"BEÞÝRÝ","GERCÜÞ","HASANKEYF","KOZLUK","MERKEZ","SASON"};
           	ilce.getItems().addAll(dizi13);
        }
    	else if(a==14) {
        	String[] dizi14= {"AYDINTEPE","DEMÝRÖZÜ","MERKEZ"};
           	ilce.getItems().addAll(dizi14);
        }
    	else if(a==15) {
        	String[] dizi15= {"BOZÜYÜK","GÖLPAZARI","ÝNHÝSAR","MERKEZ","OSMANELÝ","PAZARYERÝ","SÖÐÜT","YENÝPAZAR"};
           	ilce.getItems().addAll(dizi15);
        }
    	else if(a==16) {
        	String[] dizi16= {"ADAKLI","GENÇ","KARLIOVA","KÝÐI","MERKEZ","SOLHAN","YAYLADERE","YEDÝSU"};
           	ilce.getItems().addAll(dizi16);
        }
    	else if(a==17) {
        	String[] dizi17= {"ADÝLCEVAZ","AHLAT","GÜROYMAK","HÝZAN","MERKEZ","MUTKÝ","TATVAN"};
           	ilce.getItems().addAll(dizi17);
        }
    	else if(a==18) {
        	String[] dizi18= {"DÖRTDÝVAN","GEREDE","GÖYNÜK","KIBRISCIK","MENGEN","MERKEZ","MUDURNU","SEBEN","YENÝÇAÐA"};
           	ilce.getItems().addAll(dizi18);
        }
    	else if(a==19) {
        	String[] dizi19= {"AÐLASUN","ALTINYAYLA","BUCAK","ÇAVDIR","ÇELTÝKÇÝ","GÖLHÝSAR","KARAMANLI","KEMER","MERKEZ","TEFENNÝ","YEÞÝLOVA"};
           	ilce.getItems().addAll(dizi19);
        }
    	else if(a==20) {
        	String[] dizi20= {"BÜYÜKORHAN","GEMLÝK","GÜRSU","HARMANCIK","ÝNEGÖL","ÝZNÝK","KARACABEY","KELES","KESTEL","MUDANYA","MUSTAFAKEMALPAÞA","NÝLÜFER","ORHANELÝ","ORHANGAZÝ","OSMANGAZÝ","YENÝÞEHÝR","YILDIRIM"};
           	ilce.getItems().addAll(dizi20);
        }
    	else if(a==21) {
        	String[] dizi21= {"AYVACIK","BAYRAMÝÇ","BÝGA","BOZCAADA","ÇAN","ECEABAT","EZÝNE","GELÝBOLU","GÖKÇEADA","LAPSEKÝ","MERKEZ","YENÝCE"};
           	ilce.getItems().addAll(dizi21);
        }
    	else if(a==22) {
        	String[] dizi22= {"ATKARACALAR","BAYRAMÖREN","ÇERKEÞ","ELDÝVAN","ILGAZ","KIZILIRMAK","KORGUN","KURÞUNLU","MERKEZ","ORTA","ÞABANÖZÜ","YAPRAKLI"};
           	ilce.getItems().addAll(dizi22);
        }
    	else if(a==23) {
        	String[] dizi23= {"ALACA","BAYAT","BOÐAZKALE","DODURGA","ÝSKÝLÝP","KARGI","LAÇÝN","MECÝTÖZÜ","MERKEZ","OÐUZLAR","ORTAKÖY","OSMANCIK","SUNGURLU","UÐURLUDAÐ"};
           	ilce.getItems().addAll(dizi23);
        }
    	else if(a==24) {
        	String[] dizi24= {"ACIPAYAM","BABADAÐ","BAKLAN","BEKÝLLÝ","BEYAÐAÇ","BOZKURT","BULDAN","ÇAL","ÇAMELÝ","ÇARDAK","ÇÝVRÝL","GÜNEY","HONAZ","KALE","MERKEZEFENDÝ","PAMUKKALE","SARAYKÖY","SERÝNHÝSAR","TAVAS"};
           	ilce.getItems().addAll(dizi24);
        }
    	else if(a==25) {
        	String[] dizi25= {"BAÐLAR","BÝSMÝL","ÇERMÝK","ÇINAR","ÇÜNGÜÞ","DÝCLE","EÐÝL","ERGANÝ","HANÝ","HAZRO","KAYAPINAR","KOCAKÖY","KULP","LÝCE","SÝLVAN","SUR","YENÝÞEHÝR"};
           	ilce.getItems().addAll(dizi25);
        }
    	else if(a==26) {
        	String[] dizi26= {"AKÇAKOCA","CUMAYERÝ","ÇÝLÝMLÝ","GÖLYAKA","GÜMÜÞOVA","KAYNAÞLI","MERKEZ","YIÐILCA"};
           	ilce.getItems().addAll(dizi26);
        }
    	else if(a==27) {
        	String[] dizi27= {"ENEZ","HAVSA","ÝPSALA","KEÞAN","LALAPAÞA","MERÝÇ","MERKEZ","SÜLOÐLU","UZUNKÖPRÜ"};
           	ilce.getItems().addAll(dizi27);
        }
    	else if(a==28) {
        	String[] dizi28= {"AÐIN","ALACAKAYA","ARICAK","BASKÝL","KARAKOÇAN","KEBAN","KOVANCILAR","MADEN","MERKEZ","PALU","SÝVRÝCE"};
           	ilce.getItems().addAll(dizi28);
        }
    	else if(a==29) {
        	String[] dizi29= {"ÇAYIRLI","ÝLÝÇ","KEMAH","KEMALÝYE","MERKEZ","OTLUKBELÝ","REFAHÝYE","TERCAN","ÜZÜMLÜ"};
           	ilce.getItems().addAll(dizi29);
        }
    	
    	else if(a==30) {
        	String[] dizi31= {"AÞKALE","AZÝZÝYE","ÇAT","HINIS","HORASAN","ÝSPÝR","KARAÇOBAN","KARAYAZI","KÖPRÜKÖY","NARMAN","OLTU","OLUR","PALANDÖKEN","PASÝNLER","PAZARYOLU","ÞENKAYA","TEKMAN","TORTUM","UZUNDERE","YAKUTÝYE"};
           	ilce.getItems().addAll(dizi31);
        }
    	else if(a==31) {
        	String[] dizi32= {"ALPU","BEYLÝKOVA","ÇÝFTELER","GÜNYÜZÜ","HAN","ÝNÖNÜ","MAHMUDÝYE","MÝHALGAZÝ","MÝHALIÇÇIK","ODUNPAZARI","SARICAKAYA","SEYÝTGAZÝ","SÝVRÝHÝSAR","TEPEBAÞI"};
           	ilce.getItems().addAll(dizi32);
        }
    	else if(a==32) {
        	String[] dizi33= {"ARABAN","ÝSLAHÝYE","KARKAMIÞ","NÝZÝP","NURDAÐI","OÐUZELÝ","ÞAHÝNBEY","ÞEHÝTKAMÝL","YAVUZELÝ"};
           	ilce.getItems().addAll(dizi33);
        }
    	else if(a==33) {
        	String[] dizi34= {"ALUCRA","BULANCAK","ÇAMOLUK","ÇANAKÇI","DERELÝ","DOÐANKENT","ESPÝYE","EYNESÝL","GÖRELE","GÜCE","KEÞAP","MERKEZ","PÝRAZÝZ","ÞEBÝNKARAHÝSAR","TÝREBOLU","YAÐLIDERE"};
           	ilce.getItems().addAll(dizi34);
        }
    	else if(a==34) {
        	String[] dizi35= {"KELKÝT","KÖSE","KÜRTÜN","MERKEZ","ÞÝRAN","TORUL"};
           	ilce.getItems().addAll(dizi35);
        }
    	else if(a==35) {
        	String[] dizi36= {"ÇUKURCA","DERECÝK","MERKEZ","ÞEMDÝNLÝ","YÜKSEKOVA"};
           	ilce.getItems().addAll(dizi36);
        }
    	else if(a==36) {
        	String[] dizi37= {"ALTINÖZÜ","ANTAKYA","ARSUZ","BELEN","DEFNE","DÖRTYOL","ERZÝN","HASSA","ÝSKENDERUN","KIRIKHAN","KUMLU","PAYAS","REYHANLI","SAMANDAÐ","YAYLADAÐI"};
           	ilce.getItems().addAll(dizi37);
        }
    	else if(a==37) {
        	String[] dizi38= {"ARALIK","KARAKOYUNLU","MERKEZ","TUZLUCA"};
           	ilce.getItems().addAll(dizi38);
        }
    	else if(a==38) {
        	String[] dizi39= {"AKSU","ATABEY","EÐÝRDÝR","GELENDOST","GÖNEN","KEÇÝBORLU","MERKEZ","SENÝRKENT","SÜTÇÜLER","ÞARKÝKARAAÐAÇ","ULUBORLU","YALVAÇ","YENÝÞARBADEMLÝ"};
           	ilce.getItems().addAll(dizi39);
        }
    	else if(a==39) {
        	String[] dizi40= {"ADALAR","ARNAVUTKÖY","ATAÞEHÝR","AVCILAR","BAÐCILAR","BAHÇELÝEVLER","BAKIRKÖY","BAÞAKÞEHÝR","BAYRAMPAÞA","BEÞÝKTAÞ","BEYKOZ","BEYLÝKDÜZÜ","BEYOÐLU","BÜYÜKÇEKMECE","ÇATALCA","ÇEKMEKÖY","ESENLER","ESENYURT","EYÜPSULTAN","FATÝH","GAZÝOSMANPAÞA","GÜNGÖREN","KADIKÖY","KAÐITHANE","KARTAL","KÜÇÜKÇEKMECE","MALTEPE","PENDÝK","SANCAKTEPE","SARIYER","SÝLÝVRÝ","SULTANBEYLÝ","SULTANGAZÝ","ÞÝLE","ÞÝÞLÝ","TUZLA","ÜMRANÝYE","ÜSKÜDAR","ZEYTÝNBURNU"};
           	ilce.getItems().addAll(dizi40);
        }
    	else if(a==40) {
        	String[] dizi41= {"ALÝAÐA","BALÇOVA","BAYINDIR","BAYRAKLI","BERGAMA","BEYDAÐ","BORNOVA","BUCA","ÇEÞME","ÇÝÐLÝ","DÝKÝLÝ","FOÇA","GAZÝEMÝR","GÜZELBAHÇE","KARABAÐLAR","KARABURUN","KARÞIYAKA","KEMALPAÞA","KINIK","KÝRAZ","KONAK","MENDERES","MENEMEN","NARLIDERE","ÖDEMÝÞ","SEFERÝHÝSAR","SELÇUK","TÝRE","TORBALI","URLA"};
           	ilce.getItems().addAll(dizi41);
        }
    	else if(a==41) {
        	String[] dizi42= {"AFÞÝN","ANDIRIN","ÇAÐLAYANCERÝT","DULKADÝROÐLU","EKÝNÖZÜ","ELBÝSTAN","GÖKSUN","NURHAK","ONÝKÝÞUBAT","PAZARCIK","TÜRKOÐLU"};
           	ilce.getItems().addAll(dizi42);
        }
    	else if(a==42) {
        	String[] dizi43= {"EFLANÝ","ESKÝPAZAR","MERKEZ","OVACIK","SAFRANBOLU","YENÝCE"};
           	ilce.getItems().addAll(dizi43);
        }
    	else if(a==43) {
        	String[] dizi44= {"AYRANCI","BAÞYAYLA","ERMENEK","KAZIMKARABEKÝR","MERKEZ","SARIVELÝLER"};
           	ilce.getItems().addAll(dizi44);
        }
    	else if(a==44) {
        	String[] dizi45= {"AKYAKA","ARPAÇAY","DÝGOR","KAÐIZMAN","MERKEZ","SARIKAMIÞ","SELÝM","SUSUZ"};
           	ilce.getItems().addAll(dizi45);
        }
    	else if(a==45) {
        	String[] dizi46= {"ABANA","AÐLI","ARAÇ","AZDAVAY","BOZKURT","CÝDE","ÇATALZEYTÝN","DADAY","DEVREKANÝ","DOÐANYURT","HANÖNÜ","ÝHSANGAZÝ","ÝNEBOLU","KÜRE","MERKEZ","PINARBAÞI","SEYDÝLER","ÞENPAZAR","TAÞKÖPRÜ","TOSYA"};
           	ilce.getItems().addAll(dizi46);
        }
    	else if(a==46) {
        	String[] dizi47= {"AKKIÞLA","BÜNYAN","DEVELÝ","FELAHÝYE","HACILAR","ÝNCESU","KOCASÝNAN","MELÝKGAZÝ","ÖZVATAN","PINARBAÞI","SARIOÐLAN","SARIZ","TALAS","TOMARZA","YAHYALI","YEÞÝLHÝSAR"};
           	ilce.getItems().addAll(dizi47);
        }
    	else if(a==47) {
        	String[] dizi48= {"BAHÞILI","BALIÞEYH","ÇELEBÝ","DELÝCE","KARAKEÇÝLÝ","KESKÝN","MERKEZ","SULAKYURT","YAHÞÝHAN"};
           	ilce.getItems().addAll(dizi48);
        }
    	else if(a==48) {
        	String[] dizi49= {"BABAESKÝ","DEMÝRKÖY","KOFÇAZ","LÜLEBURGAZ","MERKEZ","PEHLÝVANKÖY","PINARHÝSAR","VÝZE"};
           	ilce.getItems().addAll(dizi49);
        }
    	else if(a==49) {
        	String[] dizi50= {"AKÇAKENT","AKPINAR","BOZTEPE","ÇÝÇEKDAÐI","KAMAN","MERKEZ","MUCUR"};
           	ilce.getItems().addAll(dizi50);
        }
    	else if(a==50) {
        	String[] dizi51= {"ELBEYLÝ","MERKEZ","MUSABEYLÝ","POLATELÝ"};
           	ilce.getItems().addAll(dizi51);
        }
    	else if(a==51) {
        	String[] dizi52= {"BAÞÝSKELE","ÇAYIROVA","DARICA","DERÝNCE","DÝLOVASI","GEBZE","GÖLCÜK","ÝZMÝT","KANDIRA","KARAMÜRSEL","KARTEPE","KÖRFEZ"};
           	ilce.getItems().addAll(dizi52);
        }
    	else if(a==52) {
        	String[] dizi53= {"AHIRLI","AKÖREN","AKÞEHÝR","ALTINEKÝN","BEYÞEHÝR","BOZKIR","CÝHANBEYLÝ","ÇELTÝK","ÇUMRA","DERBENT","DEREBUCAK","DOÐANHÝSAR","EMÝRGAZÝ","EREÐLÝ","GÜNEYSINIR","HADÝM","HALKAPINAR","HÜYÜK","ILGIN","KADINHANI","KARAPINAR","KARATAY","KULU","MERAM","SARAYÖNÜ","SELÇUKLU","SEYDÝÞEHÝR","TAÞKENT","TUZLUKÇU","YALIHÜYÜK","YUNAK"};
           	ilce.getItems().addAll(dizi53);
        }
    	else if(a==53) {
        	String[] dizi54= {"ALTINTAÞ","ASLANAPA","ÇAVDARHÝSAR","DOMANÝÇ","DUMLUPINAR","EMET","GEDÝZ","HÝSARCIK","MERKEZ","PAZARLAR","SÝMAV","ÞAPHANE","TAVÞANLI"};
           	ilce.getItems().addAll(dizi54);
        }
    	else if(a==54) {
        	String[] dizi55= {"AKÇADAÐ","ARAPGÝR","ARGUVAN","BATTALGAZÝ","DARENDE","DOÐANÞEHÝR","DOÐANYOL","HEKÝMHAN","KALE","KULUNCAK","PÜTÜRGE","YAZIHAN","YEÞÝLYURT"};
           	ilce.getItems().addAll(dizi55);
        }
    	else if(a==55) {
        	String[] dizi56= {"AHMETLÝ","AKHÝSAR","ALAÞEHÝR","DEMÝRCÝ","GÖLMARMARA","GÖRDES","KIRKAÐAÇ","KÖPRÜBAÞI","KULA","SALÝHLÝ","SARIGÖL","SARUHANLI","SELENDÝ","SOMA","ÞEHZADELER","TURGUTLU","YUNUSEMRE"};
           	ilce.getItems().addAll(dizi56);
        }
    	else if(a==56) {
        	String[] dizi57= {"ARTUKLU","DARGEÇÝT","DERÝK","KIZILTEPE","MAZIDAÐI","MÝDYAT","NUSAYBÝN","ÖMERLÝ","SAVUR","YEÞÝLLÝ"};
           	ilce.getItems().addAll(dizi57);
        }
    	else if(a==57) {
        	String[] dizi58= {"AKDENÝZ","ANAMUR","AYDINCIK","BOZYAZI","ÇAMLIYAYLA","ERDEMLÝ","GÜLNAR","MEZÝTLÝ","MUT","SÝLÝFKE","TARSUS","TOROSLAR","YENÝÞEHÝR"};
           	ilce.getItems().addAll(dizi58);
           	
        }
    	else if(a==58) {
        	String[] dizi60= {"BODRUM","DALAMAN","DATÇA","FETHÝYE","KAVAKLIDERE","KÖYCEÐÝZ","MARMARÝS","MENTEÞE","MÝLAS","ORTACA","SEYDÝKEMER","ULA","YATAÐAN"};
           	ilce.getItems().addAll(dizi60);
        }
    	else if(a==59) {
        	String[] dizi61= {"BULANIK","HASKÖY","KORKUT","MALAZGÝRT","MERKEZ","VARTO"};
           	ilce.getItems().addAll(dizi61);
        }
    	else if(a==60) {
        	String[] dizi62= {"ACIGÖL","AVANOS","DERÝNKUYU","GÜLÞEHÝR","HACIBEKTAÞ","KOZAKLI","MERKEZ","ÜRGÜP"};
           	ilce.getItems().addAll(dizi62);
        }
    	else if(a==61) {
        	String[] dizi63= {"ALTUNHÝSAR","BOR","ÇAMARDI","ÇÝFTLÝK","MERKEZ","ULUKIÞLA"};
           	ilce.getItems().addAll(dizi63);
        }
    	else if(a==62) {
        	String[] dizi64= {"AKKUÞ","ALTINORDU","AYBASTI","ÇAMAÞ","ÇATALPINAR","ÇAYBAÞI","FATSA","GÖLKÖY","GÜLYALI","GÜRGENTEPE","ÝKÝZCE","KABADÜZ","KABATAÞ","KORGAN","KUMRU","MESUDÝYE","PERÞEMBE","ULUBEY","ÜNYE"};
           	ilce.getItems().addAll(dizi64);
        }
    	else if(a==63) {
        	String[] dizi65= {"BAHÇE","DÜZÝÇÝ","HASANBEYLÝ","KADÝRLÝ","MERKEZ","SUMBAS","TOPRAKKALE"};
           	ilce.getItems().addAll(dizi65);
        }
    	else if(a==64) {
        	String[] dizi66= {"ARDEÞEN","ÇAMLIHEMÞÝN","ÇAYELÝ","DEREPAZARI","FINDIKLI","GÜNEYSU","HEMÞÝN","ÝKÝZDERE","ÝYÝDERE","KALKANDERE","MERKEZ","PAZAR"};
           	ilce.getItems().addAll(dizi66);
        }
    	else if(a==65) {
        	String[] dizi67= {"ADAPAZARI","AKYAZI","ARÝFÝYE","ERENLER","FERÝZLÝ","GEYVE","HENDEK","KARAPÜRÇEK","KARASU","KAYNARCA","KOCAALÝ","PAMUKOVA","SAPANCA","SERDÝVAN","SÖÐÜTLÜ","TARAKLI"};
           	ilce.getItems().addAll(dizi67);
        }
        else if(a==66) {
        	String[] dizi68= {"19","ALAÇAM","ASARCIK","ATAKUM","AYVACIK","BAFRA","CANÝK","ÇARÞAMBA","HAVZA","ÝLKADIM","KAVAK","LADÝK","SALIPAZARI","TEKKEKÖY","TERME","VEZÝRKÖPRÜ","YAKAKENT"};
           	ilce.getItems().addAll(dizi68);
        }
        else if(a==67) {
        	String[] dizi69= {"BAYKAN","ERUH","KURTALAN","MERKEZ","PERVARÝ","ÞÝRVAN","TÝLLO"};
           	ilce.getItems().addAll(dizi69);
        }
        else if(a==68) {
        	String[] dizi70= {"AYANCIK","BOYABAT","DÝKMEN","DURAÐAN","ERFELEK","GERZE","MERKEZ","SARAYDÜZÜ","TÜRKELÝ"};
           	ilce.getItems().addAll(dizi70);
        }
        else if(a==69) {
        	String[] dizi71= {"AKINCILAR","ALTINYAYLA","DÝVRÝÐÝ","DOÐANÞAR","GEMEREK","GÖLOVA","GÜRÜN","HAFÝK","ÝMRANLI","KANGAL","KOYULHÝSAR","MERKEZ","SUÞEHRÝ","ÞARKIÞLA","ULAÞ","YILDIZELÝ","ZARA"};
           	ilce.getItems().addAll(dizi71);
        }
        else if(a==70) {
        	String[] dizi72= {"AKÇAKALE","BÝRECÝK","BOZOVA","CEYLANPINAR","EYYÜBÝYE","HALFETÝ","HALÝLÝYE","HARRAN","HÝLVAN","KARAKÖPRÜ","SÝVEREK","SURUÇ","VÝRANÞEHÝR"};
           	ilce.getItems().addAll(dizi72);
        }else if(a==71) {
        	String[] dizi73= {"BEYTÜÞÞEBAP","CÝZRE","GÜÇLÜKONAK","ÝDÝL","MERKEZ","SÝLOPÝ","ULUDERE"};
           	ilce.getItems().addAll(dizi73);
        }
        else if(a==72) {
        	String[] dizi74= {"ÇERKEZKÖY","ÇORLU","ERGENE","HAYRABOLU","KAPAKLI","MALKARA","MARMARAEREÐLÝSÝ","MURATLI","SARAY","SÜLEYMANPAÞA","ÞARKÖY"};
           	ilce.getItems().addAll(dizi74);
        }
        else if(a==73) {
        	String[] dizi75= {"ALMUS","ARTOVA","BAÞÇÝFTLÝK","ERBAA","MERKEZ","NÝKSAR","PAZAR","REÞADÝYE","SULUSARAY","TURHAL","YEÞÝLYURT","ZÝLE"};
           	ilce.getItems().addAll(dizi75);
        }
        else if(a==74) {
        	String[] dizi76= {"AKÇAABAT","ARAKLI","ARSÝN","BEÞÝKDÜZÜ","ÇARÞIBAÞI","ÇAYKARA","DERNEKPAZARI","DÜZKÖY","HAYRAT","KÖPRÜBAÞI","MAÇKA","OF","ORTAHÝSAR","SÜRMENE","ÞALPAZARI","TONYA","VAKFIKEBÝR","YOMRA"};
           	ilce.getItems().addAll(dizi76);
        }
        else if(a==75) {
        	String[] dizi77= {"ÇEMÝÞGEZEK","HOZAT","MAZGÝRT","MERKEZ","NAZIMÝYE","OVACIK","PERTEK","PÜLÜMÜR"};
           	ilce.getItems().addAll(dizi77);
        }
        else if(a==76) {
        	String[] dizi78= {"BANAZ","EÞME","KARAHALLI","MERKEZ","SÝVASLI","ULUBEY"};
           	ilce.getItems().addAll(dizi78);
        }
        else if(a==77) {
        	String[] dizi79= {"BAHÇESARAY","BAÞKALE","ÇALDIRAN","ÇATAK","EDREMÝT","ERCÝÞ","GEVAÞ","GÜRPINAR","ÝPEKYOLU","MURADÝYE","ÖZALP","SARAY","TUÞBA"};
           	ilce.getItems().addAll(dizi79);
        }
        else if(a==78) {
        	String[] dizi80= {"ALTINOVA","ARMUTLU","ÇINARCIK","ÇÝFTLÝKKÖY","MERKEZ","TERMAL"};
           	ilce.getItems().addAll(dizi80);
        }
        else if(a==79) {
        	String[] dizi81= {"AKDAÐMADENÝ","AYDINCIK","BOÐAZLIYAN","ÇANDIR","ÇAYIRALAN","ÇEKEREK","KADIÞEHRÝ","MERKEZ","SARAYKENT","SARIKAYA","SORGUN","ÞEFAATLÝ","YENÝFAKILI","YERKÖY"};
           	ilce.getItems().addAll(dizi81);
        }
        else if(a==80) {
        	String[] dizi82= {"ALAPLI","ÇAYCUMA","DEVREK","EREÐLÝ","GÖKÇEBEY","KÝLÝMLÝ","KOZLU","MERKEZ"};
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
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("Lütfen Boþ Alan Býrakmayýnýz...");
    		alert.showAndWait();
    		
    	}
    	else if(g!=11) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("Randevu Sistemi");
    		alert.setHeaderText("Uyarý Mesajý...");
    		alert.setContentText("TC KÝMLÝK NUMARANIZI KONTROL EDÝNÝZ.11 HANELÝ OLMALIDIR.");
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
        		alert1.setHeaderText("Randevuyu Onaylýyor Musunuz?");
        		alert1.setContentText("ÝL: "+il.getSelectionModel().getSelectedItem()+"\n"+"ÝLÇE: "+ilce.getSelectionModel().getSelectedItem()+ "\n"+"HASTAHANE: "+hastane.getSelectionModel().getSelectedItem()+"\n" +"KLÝNÝK: " +klinik.getSelectionModel().getSelectedItem()+"\n"+"MUAYENE YERÝ: "+muayeneyeri.getSelectionModel().getSelectedItem()+"\n"+"HEKÝM: " +hekim.getSelectionModel().getSelectedItem()+" Hoca \n"+"TARÝH: "+ value +"\n" +"SAAT: "+ spinn1+":"+spinn2);  
        		ButtonType btn1=new ButtonType("EVET");
        		ButtonType btn2=new ButtonType("HAYIR");
        		alert1.getButtonTypes().setAll(btn1,btn2);
        		Optional<ButtonType> sonuc2=alert1.showAndWait();
        		
        		if(sonuc2.get()==btn1) {
        			label.setText("KAYDEDÝLDÝ...");
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
    	
       il.setPromptText("Seçiniz...");
       String[] iller= {"ADANA", "ADIYAMAN", "AFYONKARAHÝSAR", "AÐRI", "AKSARAY", "AMASYA", "ANKARA", "ANTALYA", "ARDAHAN", "ARTVÝN", "AYDIN", "BALIKESÝR", "BARTIN", "BATMAN", "BAYBURT", "BÝLECÝK", "BÝNGÖL", "BÝTLÝS", "BOLU", "BURDUR", "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENÝZLÝ", "DÝYARBAKIR", "DÜZCE", "EDÝRNE", "ELAZIÐ", "ERZÝNCAN", "ERZURUM", "ESKÝÞEHÝR", "GAZÝANTEP", "GÝRESUN", "GÜMÜÞHANE", "HAKKARÝ", "HATAY", "IÐDIR", "ISPARTA", "ÝSTANBUL", "ÝZMÝR", "KAHRAMANMARAÞ", "KARABÜK", "KARAMAN", "KARS", "KASTAMONU", "KAYSERÝ", "KIRIKKALE", "KIRKLARELÝ", "KIRÞEHÝR", "KÝLÝS", "KOCAELÝ", "KONYA", "KÜTAHYA", "MALATYA", "MANÝSA", "MARDÝN", "MERSÝN", "MUÐLA", "MUÞ", "NEVÞEHÝR", "NÝÐDE", "ORDU", "OSMANÝYE", "RÝZE", "SAKARYA", "SAMSUN", "SÝÝRT", "SÝNOP", "SÝVAS", "ÞANLIURFA", "ÞIRNAK", "TEKÝRDAÐ", "TOKAT", "TRABZON", "TUNCELÝ", "UÞAK", "VAN", "YALOVA", "YOZGAT", "ZONGULDAK"};
       il.getItems().addAll(iller);
       ilce.setPromptText("Seçiniz...");
      
       muayeneyeri.setPromptText("Seçiniz...");
       String[] muayene= {"Muayene 1","Muayene 2","Muayene 3"};
       muayeneyeri.getItems().addAll(muayene);
       
       klinik.setPromptText("Seçiniz...");
       String[] klinikler= {"ALGOLOJÝ","BESLENME VE DÝYET","BEYÝN VE SÝNÝR CERRAHÝSÝ","ÇOCUK ALERJÝSÝ","ÇOCUK CERRAHÝSÝ","ÇOCUK ENDOKRÝNOLOJÝSÝ","ÇOCUK ENFEKSÝYON","ÇOCUK GÖÐÜS HASTALIKLARI","ÇOCUK HEMATOLOJÝSÝ","ÇOCUK KARDÝYOLOJÝSÝ","ÇOCUK METABOLÝZMA,ÇOCUK NEFROLOJÝSÝ,ÇOCUK NÖROLOJÝSÝ","ÇOCUK PSÝKÝYATRÝSÝ","ÇOCUK SAÐLIÐI VE HASTALIKLARI","ÇOCUK ÜROLOJÝSÝ,DERMATOLOJÝ (CÝLDÝYE)","ENDOKRÝNOLOJÝ VE METABOLÝZMA","ENFEKSÝYON HASTALIKLARI","FÝZÝKSEL TIP VE REHABÝLÝTASYON","GASTROENTEROLOJÝ","GELENEKSEL VE TAMAMLAYICI TIP(GETAMER)","GENEL CERRAHÝ","GERÝATRÝ","GÖÐÜS CERRAHÝSÝ","GÖÐÜS HASTALIKLARI","GÖZ HASTALIKLARI","HEMATOLOJÝ","ÝÇ HASTALIKLARI","KADIN HASTALIKLARI VE DOÐUM","KALP VE DAMAR CERRAHÝSÝ","KARDÝYOLOJÝ","KEMÝK YOÐUNLUÐU ÖLÇÜMÜ","KULAK-BURUN-BOÐAZ HASTALIKLARI","NEFROLOJÝ","NÖROLOJÝ","ORTOPEDÝ VE TRAVMATOLOJÝ","PLASTÝK REKONSTRÜKTÝF VE ESTETÝK CERRAHÝ","PSÝKÝYATRÝ","RADYASYON ONKOLOJÝSÝ","TIBBÝ GENETÝK","TIBBÝ PATOLOJÝ","ÜROLOJÝ"};
       klinik.getItems().addAll(klinikler);
       
      hastane.setPromptText("Seçiniz...");
       String hast[]= {"A DEVLET HASTANESÝ","A ÖZEL HASTANESÝ","B DEVLET HASTANESÝ","B ÖZEL HASTANESÝ","C DEVLET HASTANESÝ","C ÖZEL HASTANESÝ"};
       hastane.getItems().addAll(hast);
       
       hekim.setPromptText("Seçiniz...");
       String doktor[]= {"Ali","Veli","Ahmet","Mehmet","Mahmut","Kemal"};
       hekim.getItems().addAll(doktor);
       
       SpinnerValueFactory<Integer> clock=new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17,1);
       spin1.setValueFactory(clock);
       
       SpinnerValueFactory<Integer> minute=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50,00,10);
       spin2.setValueFactory(minute);
       
       
       
    }
};
       
       
    	   
       
    

