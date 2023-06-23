package application;

public class kayýtlar_randevular {
	private String il;
	private String ilce;
	private String klinik;
	private String hastane;
	private String muayeneyeri;
	private String hekim;
	private String saat;
	private String tarih;
	
	kayýtlar_randevular(String il,String ilce,String klinik,String hastane,String muayeneyeri,String hekim,String saat,String tarih){
		this.il=il;
		this.ilce=ilce;
		this.klinik=klinik;
		this.hastane=hastane;
		this.muayeneyeri=muayeneyeri;
		this.hekim=hekim;
		this.saat=saat;
		this.tarih=tarih;
		
	}
	
	
	
	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getKlinik() {
		return klinik;
	}

	public void setKlinik(String klinik) {
		this.klinik = klinik;
	}

	public String getHastane() {
		return hastane;
	}

	public void setHastane(String hastane) {
		this.hastane = hastane;
	}

	public String getMuayeneyeri() {
		return muayeneyeri;
	}

	public void setMuayeneyeri(String muayeneyeri) {
		this.muayeneyeri = muayeneyeri;
	}

	public String getHekim() {
		return hekim;
	}

	public void setHekim(String hekim) {
		this.hekim = hekim;
	}

	public String getSaat() {
		return saat;
	}

	public void setSaat(String saat) {
		this.saat = saat;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	

}
