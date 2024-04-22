import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Jdbc {
	public Jdbc() {
		
	}
	private final String url = "jdbc:postgresql://localhost:5432/Son";
	private final String user = "postgres";
	private final String pass = "123456";
	private Connection conn;
	static Statement st;
	public Statement connectState() throws SQLException, ClassNotFoundException {
		if(this.conn == null || this.conn.isClosed()) {
        conn = DriverManager.getConnection(url, user, pass);
        }
        System.out.println("Java JDBC bağlantısı başarıyla gerçekleşti. connectDeneme");
        Statement ifade = conn.createStatement();
        return ifade;
    }
	public ResultSet yap3(String s) {//toblo bilgileri için kullanılır resultset döndürür
		ResultSet myRs = null;
		try {
			Jdbc jdbc = new Jdbc();
			Statement state;
			state = jdbc.connectState();
			myRs = state.executeQuery(s);
		}

		catch (Exception a) {
			System.err.println("Hata ! ");
			System.err.println(a.getMessage());
		}
		return myRs;
	}
	public void ekle(String sql_sorgu){
		try {
			Jdbc jdbc = new Jdbc();
			Statement state;
			state = jdbc.connectState();
			state.executeUpdate(sql_sorgu);
			System.out.println("eklendi ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void update(String sql_sorgu) {
		try {
			Jdbc jdbc = new Jdbc();
			Statement state;
			state = jdbc.connectState();
			state.executeUpdate(sql_sorgu);
			System.out.println("guncellendi ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static void sil(String sql_sorgu) {
		try {
			Jdbc jdbc = new Jdbc();
			Statement state;
			state = jdbc.connectState();
			state.executeUpdate(sql_sorgu);
			System.out.println("silindi ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void veri(String islem,String Id,String hangisayfa) {
		Jdbc jdbc = new Jdbc();
		int sayac = 0;
		String sql1 = "SELECT * FROM islemler";
    	ResultSet resultSet = jdbc.yap3(sql1);
    	try {
			while(resultSet.next()){
			    sayac  = resultSet.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	String sql3 = "SELECT sistem_tarih FROM sistem";
    	String adet = null;
    	ResultSet resultSet3 = jdbc.yap3(sql3);
    	try {
			while(resultSet3.next()){
			    adet  = String.valueOf(resultSet3.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	sayac++;
    	String bos = "_";
    	String sql=null;
    	if(hangisayfa.equals("yonetici")) {
    	sql = "insert into islemler (islemler_id,islemler_bilgi,islemler_tarih,ogrenciler_id,hocalar_id,yonetici_id)"
                + "values ('"+sayac+"','"+islem+"','"+adet+"','"+bos+"','"+bos+"','"+Id+"')";}
    	if(hangisayfa.equals("hocalar")) {
        	sql = "insert into islemler (islemler_id,islemler_bilgi,islemler_tarih,ogrenciler_id,hocalar_id,yonetici_id)"
                    + "values ('"+sayac+"','"+islem+"','"+adet+"','"+bos+"','"+Id+"','"+bos+"')";}
    	if(hangisayfa.equals("ogrenciler")) {
        	sql = "insert into islemler (islemler_id,islemler_bilgi,islemler_tarih,ogrenciler_id,hocalar_id,yonetici_id)"
                    + "values ('"+sayac+"','"+islem+"','"+adet+"','"+Id+"','"+bos+"','"+bos+"')";}
    	jdbc.ekle(sql);
	}
	public boolean dagitimYap() {
		boolean sonuc = false;
		boolean dagitim = false;
		Jdbc jdbc = new Jdbc();
		String sql1 = "SELECT * FROM sistem WHERE yonetici_id='0'";
    	ResultSet resultSet = jdbc.yap3(sql1);
    	String tarih1 = null;
    	String tarih2 =null;
    	String sure = null;
    	try {
			while(resultSet.next()){
			   tarih1  = resultSet.getString(2);
			   tarih2  = resultSet.getString(3);
			   sure  = resultSet.getString(5);
			   dagitim = resultSet.getBoolean(8);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localdGunu = LocalDate.parse(tarih1, formatter);
        LocalDate localdGunu2 = LocalDate.parse(tarih2, formatter);
        long diff = ChronoUnit.DAYS.between(localdGunu, localdGunu2);
        System.out.println(diff+" "+sure+" "+dagitim+" "+sonuc);
        if(diff>=Integer.parseInt(sure) && dagitim==false)
        	sonuc = true;
        System.out.println(diff+" "+sure+" "+dagitim+" "+sonuc);
    	return sonuc;
	}
}

