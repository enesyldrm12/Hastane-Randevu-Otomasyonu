package com.randevuMySQL.Util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;



public class VeritabaniUtil {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/kullanýcýlar","root","");
			return conn;
		} catch(Exception e){
			System.out.println(e.getMessage().toString());
			return null;
		}
		
		
	}
	
	public static String MD5Sifrele(String Sifre) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] sifrelenmis=md.digest(Sifre.getBytes());
			BigInteger no=new BigInteger(1,sifrelenmis);
			
			String hashIcerik=no.toString();
			while(hashIcerik.length()<32) {
				hashIcerik="0"+hashIcerik;
			}
			return hashIcerik;
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
