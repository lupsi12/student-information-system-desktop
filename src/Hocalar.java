import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class Hocalar extends JFrame {
	Boolean deger;
    JLabel  label = new JLabel();
    JLabel lGuncel = new JLabel("GÜNCELLEMEYİ GİRİNİZ");
    JLabel lIlgi = new JLabel("İLGİ ALANI GİRİNİZ");
    JLabel lCombo = new JLabel("GÖRÜNTÜLENECEK ÖĞRENCİYİ SEÇİNİZ");
	JButton ogrenciG = new JButton("ÖĞRENCİ GÖRÜNTÜLE");
	JButton hocaB = new JButton("KENDİ BİLGİLERİNİ DEĞİŞTİR-GÖRÜNTÜLE İLGİ ALANI");
	JButton ogrenciT = new JButton("ÖĞRENCİ TALEBİ ONAYLA-REDDET-MESAJ AT");
	JButton formul = new JButton("BÖLÜMDE AÇILAN DERSLERİ LİSTELE-FORMÜL OLUŞTUR");
	JButton talep = new JButton("HARF NOTUNA GÖRE LİSTELE-TALEP OLUŞTUR");
	JButton comboB = new JButton("SEÇ");
	JButton ekle = new JButton("İLGİ EKLE");
	JButton menu = new JButton("ANA MENÜ");
	JButton Nmenu = new JButton("MENÜ");
	JTextField tGuncel = new JTextField();
	JTextField tIlgi = new JTextField();
    JComboBox comboG = new JComboBox();
    String Kullanici_id=null;
    String Sifre = null;
    ArrayList<Ogrenci> ogrenciListesi = new ArrayList();
   public Hocalar(String kullanici_id,String sifre) {
	   Kullanici_id = kullanici_id;
	   Sifre = sifre;
	   JPanel panel = new JPanel();
       add(panel);
       setSize(800,680);
       setTitle("OBS HOCA");
       label.setBackground(Color.black);
	   label.setIcon(new ImageIcon(new ImageIcon("/Users/user/eclipse-workspace/Yazlab/img/kocaeli-universitesi4428.jpg").getImage().getScaledInstance(866, 650, Image.SCALE_SMOOTH)));
       label.setBounds(0,0,800,600);
       getContentPane().add(label);
       islemYerlesimi();
       islemSecimi(kullanici_id);
       menuDon();
       menu();
       menu.setFont(new Font("", Font.BOLD, 15));
       menu.setBounds(0, 0, 150, 20);
	   label.add(menu);
	   Nmenu.setFont(new Font("", Font.BOLD, 15));
       Nmenu.setBounds(155, 0, 150, 20);
	   label.add(Nmenu);
       JLabel bos = new JLabel();
       label.add(bos);
   }
   public void menu() {
		Nmenu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           	Hocalar hesap = new Hocalar(Kullanici_id,Sifre);
      		    hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               hesap.setVisible(true);
           }
       });

	}
   public void islemYerlesimi() {
	    ogrenciG.setFont(new Font("", Font.BOLD, 25));
	    ogrenciG.setBounds(240, 140, 500, 40);
		label.add(ogrenciG);
		hocaB.setFont(new Font("", Font.BOLD, 25));
		hocaB.setBounds(240, 180, 500, 40);
		label.add(hocaB);
		ogrenciT.setFont(new Font("", Font.BOLD, 25));
		ogrenciT.setBounds(240, 220, 500, 40);
		label.add(ogrenciT);
		formul.setFont(new Font("", Font.BOLD, 25));
		formul.setBounds(240, 260, 500, 40);
		label.add(formul);
		talep.setFont(new Font("", Font.BOLD, 25));
		talep.setBounds(240, 300, 500, 40);
		label.add(talep);
	}
   public void islemSecimi(String kullanici_id) {
	   ogrenciG.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   deger = false;
               islemVisible(deger);
        	   ogrenciGoruntule();
        	   ogrenciGoruntuleButonu();
           }
       });
	   hocaB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   deger = false;
               islemVisible(deger);
               String tabloAdi = "hocalar";
               String tabloAdi2 = "ilgiler";
               Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre","yonetici_id"};
               int satir = 5;
               Object[] kolonlar2= { tabloAdi2+"_id",tabloAdi2+"_ozellik","ogrenciler_id","hocalar_id"};
               int satir2 = 4;
        	   guncelleme(kullanici_id);
        	   guncellemeButonu(tabloAdi,kolonlar,satir,kullanici_id);
        	   ilgiEkleButonu(tabloAdi2,kolonlar2,satir2,kullanici_id);
           }
       });
   }
   public void ogrenciGoruntule(){
	   lCombo.setText("GÖRÜNTÜLEYECEĞİNİZ ÖĞRENCİYİ SEÇİNİZ");
	   lCombo.setFont(new Font("",Font.BOLD,15));
	   lCombo.setBounds(30,20,500,20);
       label.add(lCombo);
	   int say = 0;
	   String sql = "SELECT ogrenciler_id,ogrenciler_ad FROM ogrenciler";
	   Jdbc jdbc = new Jdbc();
	   jdbc.yap3(sql);
	   ResultSet resultSet = jdbc.yap3(sql);
   	try {
   		 while (resultSet.next()) {
   			 say = ogrenciListesi.size();
			ogrenciListesi.add(new Ogrenci(Kullanici_id,Sifre));
             ogrenciListesi.get(say).setId(resultSet.getString(1));
             ogrenciListesi.get(say).setAd(resultSet.getString(2));
             System.out.println(ogrenciListesi.get(say).getAd()+" "+ogrenciListesi.get(say).getId());
            }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   	String[] ad_id = new String[ogrenciListesi.size()];
   	for(int i=0;i<ogrenciListesi.size();i++) {
   		ad_id[i] = i+" / "+ogrenciListesi.get(i).getId()+" "+ogrenciListesi.get(i).getAd();
   	}
   	ComboBoxModel model = new DefaultComboBoxModel(ad_id);
    comboG.setModel(model);
    comboG.setBounds(30,45,200,20);
    label.add(comboG);
    comboB.setFont(new Font("", Font.BOLD, 15));
    comboB.setBounds(30, 70, 200, 20);
	label.add(comboB);
   }
   public void ogrenciGoruntuleButonu() {
	   comboB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   String secim = comboG.getSelectedItem().toString();
        	   secim = secim.substring(0, 1);
        	   System.out.println(secim);
        	   secim = ogrenciListesi.get(Integer.parseInt(secim)).getId();
        	   String tabloAdi="ogrenciler";
        	   String sql = "SELECT * FROM "+tabloAdi+" WHERE ogrenciler_id='"+secim+"'";
        	   Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre",tabloAdi+"_transkript","yonetici_id"};
               int satir = 6;
               tabloGoster(sql,kolonlar,satir,20);
               String sql2 = "SELECT * FROM ilgiler WHERE ogrenciler_id='"+secim+"'";
        	   Object[] kolonlar2= { "ilgiler_id","ilgiler_ozellik","ogrenciler_id"};
               int satir2 = 3;
               tabloGoster(sql2,kolonlar2,satir2,250);
               String sql3 = "SELECT * FROM dersler WHERE ogrenciler_id='"+secim+"'";
        	   Object[] kolonlar3= { "dersler_id","dersler_ad","dersler_not","ogrenciler_id"};
               int satir3 = 4;
               tabloGoster(sql3,kolonlar3,satir3,480);
           }
       });
   }
   public void islemVisible(Boolean deger) {
		ogrenciG.setVisible(deger);
		formul.setVisible(deger);
		ogrenciT.setVisible(deger);
		hocaB.setVisible(deger);
		talep.setVisible(deger);
	}
   public void tabloGoster(String sql,Object[] kolonlar,int satir,int y) {
		DefaultTableModel model = new DefaultTableModel();
       Object[] satirlar = new Object[satir];
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setBounds(400, y, 700, 200);
       label.add(scrollPane);
       JTable table = new JTable();
       scrollPane.setViewportView(table);
       model.setColumnIdentifiers(kolonlar);
       model.setRowCount(0);
       Jdbc jdbc = new Jdbc();
       try {
           String query = sql;
           ResultSet res=jdbc.yap3(query);
           while (res.next()) {
               satirlar[0] = res.getString(1);
               satirlar[1] = res.getString(2);
               if(satir>=3)
               satirlar[2] = res.getString(3);
               if(satir>=4)
               satirlar[3] = res.getString(4);
               if(satir>=5) {
               satirlar[4] = res.getString(5);}
               if(satir>=6) {
                   satirlar[5] = res.getString(6);}
               model.addRow(satirlar);
           }
       } catch (Exception e2) {
           // TODO: handle exception
           e2.printStackTrace();
       }
       table.setModel(model);
	}
   public void guncelleme(String kullanici_id) {
	   String tabloAdi = "hocalar";
	   String sql = "SELECT * FROM "+tabloAdi+" WHERE hocalar_id='"+kullanici_id+"'";
       Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre","yonetici_id"};
       int satir = 5;
	   tabloGoster(sql,kolonlar,satir,20);
	   lCombo.setText("GÜNCELLEME SEÇİNİZ");
	   lCombo.setFont(new Font("",Font.BOLD,15));
	   lCombo.setBounds(30,20,200,20);
       label.add(lCombo);
       ComboBoxModel model = new DefaultComboBoxModel(kolonlar);
       comboG.setModel(model);
       comboG.setBounds(30,45,200,20);
       label.add(comboG);
       lGuncel.setText("GÜNCELLEYİNİZ");
       lGuncel.setFont(new Font("",Font.BOLD,15));
       lGuncel.setBounds(30,70,200,20);
       label.add(lGuncel);
       tGuncel.setFont(new Font("",Font.BOLD,15));
       tGuncel.setBounds(30,95,200,20);
       label.add(tGuncel);
       comboB.setFont(new Font("", Font.BOLD, 15));
       comboB.setBounds(30, 120, 200, 20);
	   label.add(comboB);
	   //lIlgi.setText("GÜNCELLEYİNİZ");
	   lIlgi.setFont(new Font("",Font.BOLD,15));
	   lIlgi.setBounds(30,150,200,20);
       label.add(lIlgi);
       tIlgi.setFont(new Font("",Font.BOLD,15));
       tIlgi.setBounds(30,175,200,20);
       label.add(tIlgi);
       ekle.setFont(new Font("", Font.BOLD, 15));
       ekle.setBounds(30, 200, 200, 20);
	   label.add(ekle);
	}
    public void ilgiEkleButonu(String tabloAdi,Object[] kolonlar,int satir,String kullanici_id) {
    	ekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Jdbc jdbc = new Jdbc();
            	int sayac = 0;
            	String sql1 = "SELECT * FROM "+tabloAdi;
            	ResultSet resultSet = jdbc.yap3(sql1);
            	try {
					while(resultSet.next()){
					    sayac  = resultSet.getInt(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	sayac++;
            	System.out.println(sayac);
            	String bos = "-";
            	String sql2 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ozellik,"+"ogrenciler_id,hocalar_id)"
                        + "values ('"+sayac+"','"+tIlgi.getText()+"','"+bos+"','"+kullanici_id+"')";
            	jdbc.ekle(sql2);
            	String sql = "SELECT * FROM "+tabloAdi+" WHERE hocalar_id='"+kullanici_id+"'";
               	tabloGoster(sql,kolonlar,satir,20);
            	
            }
        });
    }
	public void guncellemeButonu(String tabloAdi,Object[] kolonlar,int satir,String kullanici_id){
		comboB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           	String guncellenecek = comboG.getSelectedItem().toString();
           	Jdbc jdbc = new Jdbc();
           	String sql1 = "UPDATE "+tabloAdi+" SET "+guncellenecek.toString()+"='" + tGuncel.getText() + "' WHERE "+tabloAdi+"_id='"+kullanici_id+"' ";
           	jdbc.update(sql1);
           	String sql = "SELECT * FROM "+tabloAdi+" WHERE hocalar_id='"+kullanici_id+"'";
           	tabloGoster(sql,kolonlar,satir,20);
           }
       });
	}
	public void menuDon() {
		menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Basla basla = new Basla();
                basla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                basla.setVisible(true);
            }
        });

	}
	
}






