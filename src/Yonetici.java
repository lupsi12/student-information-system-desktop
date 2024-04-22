import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Yonetici extends JFrame{
	Boolean deger;
	String secim ;
	String tabloAdi;
	JPanel panel = new JPanel();
	JLabel  label = new JLabel();
	JButton rastgele = new JButton("RASTGELE ATAMA");
	JButton notOrt = new JButton("NOT ORTALAMASINA GÖRE ATAMA");
	JButton derseGore = new JButton("DERSE GÖRE ATAMA");
	JButton ogrenciE = new JButton("ÖĞRENCİ EKLE");
	JButton ogrenciE2 = new JButton("10 RANDOM ÖĞRENCİ EKLE");
	JButton comboB = new JButton("SEÇ");
	JButton hocaE = new JButton("HOCA EKLE");
	JButton ogrenciG = new JButton("ÖĞRENCİ GÜNCELLE");
	JButton hocaG = new JButton("HOCA GÜNCELLE");
	JButton sistem = new JButton("SİSTEM AYARLARI");
	JButton ogrenciS = new JButton("ÖĞRENCİ SİL");
	JButton hocaS = new JButton("HOCA SİL");
	JButton menu = new JButton("ANA MENÜ");
	JButton Nmenu = new JButton("MENÜ");
	JButton ilgi = new JButton("İLGİ EKLE");
	JButton sistemB = new JButton("GÜN İLERLET");
    JButton ekle = new JButton(secim+" EKLE:");
    JButton Dekle = new JButton("DERS EKLE");
    JButton sil = new JButton(secim+" SİL:");
	JLabel lId = new JLabel(secim+" ID GİRİNİZ:");
	JLabel lAd = new JLabel(secim+" AD GİRİNİZ:");
    JLabel lSoy = new JLabel(secim+" SOYAD GİRİNİZ:");
    JLabel lSifre = new JLabel(secim+" SİFRE GİRİNİZ:");
    JLabel lCombo = new JLabel("GÜNCELLEME SEÇİNİZ");
    JLabel lGuncel = new JLabel("GÜNCELLEMEYİ GİRİNİZ");
    JLabel lKim = new JLabel("VERİ ID GİRİNİZ");
    JLabel lSistem = new JLabel("SİSTEM İŞLEMLERİ");
    JLabel lSid = new JLabel("SİLİNECEK"+secim+" ID GİRİNİZ:");
    JLabel lIlgi = new JLabel("İLGİ GİRİNİZ");
    JLabel lDers = new JLabel("DERS SEÇİNİZ");
    JTextField tIlgi = new JTextField();
    JTextField tId = new JTextField();
    JTextField tGuncel = new JTextField();
    JTextField tAd = new JTextField();
    JTextField tSoy = new JTextField();
    JTextField tSifre = new JTextField();
    JTextField tKim = new JTextField();
    JTextField tSid = new JTextField();
    JComboBox comboG = new JComboBox();
    JComboBox comboD = new JComboBox();
    ArrayList<Ogrenci> ogrenciListesi = new ArrayList();
    String Id=null;
    String Sifre = null;
    boolean acilim1;
	public Yonetici(String id,String sifre,boolean acilim) {
		acilim1 = acilim;
		Id = id;
		Sifre = sifre;
	       add(panel);
	       setSize(1000,680);
	       setTitle("OBS YÖNETİCİ");
	       label.setBackground(Color.black);
		   label.setIcon(new ImageIcon(new ImageIcon("/Users/user/eclipse-workspace/Yazlab/img/kocaeli-universitesi4428.jpg").getImage().getScaledInstance(866, 650, Image.SCALE_SMOOTH)));
	       label.setBounds(0,0,800,600);
	       getContentPane().add(label);
	       islemSecimi();
	       menuDon();
	       menu();
	       menu.setFont(new Font("", Font.BOLD, 15));
	       menu.setBounds(0, 0, 150, 20);
		   label.add(menu);
		   Nmenu.setFont(new Font("", Font.BOLD, 15));
	       Nmenu.setBounds(155, 0, 150, 20);
		   label.add(Nmenu);
		   if(acilim1 == true) {
			   islemYerlesimi2();
		   }
		   else {
			   islemYerlesimi();
		   }
	       JLabel bos = new JLabel();
	       label.add(bos);
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
	public void menu() {
		Nmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Yonetici hesap = new Yonetici(Id,Sifre,acilim1);
       		    hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                hesap.setVisible(true);
            }
        });
	}
	public void islem2() {
	}
	public void islemYerlesimi2() {
		rastgele.setFont(new Font("", Font.BOLD, 25));
		rastgele.setBounds(240, 140, 300, 40);
		label.add(rastgele);
		notOrt.setFont(new Font("", Font.BOLD, 25));
		notOrt.setBounds(240, 180, 300, 40);
		label.add(notOrt);
		derseGore.setFont(new Font("", Font.BOLD, 25));
		derseGore.setBounds(240, 220, 300, 40);
		label.add(derseGore);
	}
	public void islemYerlesimi() {
		ogrenciE.setFont(new Font("", Font.BOLD, 25));
		ogrenciE.setBounds(240, 140, 300, 40);
		label.add(ogrenciE);
		hocaE.setFont(new Font("", Font.BOLD, 25));
		hocaE.setBounds(240, 180, 300, 40);
		label.add(hocaE);
		ogrenciG.setFont(new Font("", Font.BOLD, 25));
		ogrenciG.setBounds(240, 220, 300, 40);
		label.add(ogrenciG);
		hocaG.setFont(new Font("", Font.BOLD, 25));
		hocaG.setBounds(240, 260, 300, 40);
		label.add(hocaG);
		sistem.setFont(new Font("", Font.BOLD, 25));
		sistem.setBounds(240, 300, 300, 40);
		label.add(sistem);
		ogrenciS.setFont(new Font("", Font.BOLD, 25));
		ogrenciS.setBounds(240, 340, 300, 40);
		label.add(ogrenciS);
		hocaS.setFont(new Font("", Font.BOLD, 25));
		hocaS.setBounds(240, 380, 300, 40);
		label.add(hocaS);
	}
	public void islemSecimi() {
		ogrenciE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("oğrenci eklencek");
                secim = "ÖĞRENCİ";
                tabloAdi = "ogrenciler";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre",tabloAdi+"_transkript","yonetici_id",tabloAdi+"_ort"};
                int satir = 7;
                deger = false;
                islemVisible(deger);
                ekleme(secim,tabloAdi,kolonlar,satir);
     	        ekleButonu(tabloAdi,kolonlar,satir);
     	        ogrenciE2.setFont(new Font("",Font.BOLD,15));
    	        ogrenciE2.setBounds(30,300,200,20);
    	        label.add(ogrenciE2);
     	        randomEkle(tabloAdi,kolonlar,satir);
     	        ogrenciGoruntuleButonu(tabloAdi);
     	        String tabloAdi2 ="ilgiler";
     	        Object[] kolonlar2= { tabloAdi2+"_id",tabloAdi2+"_ozellik","ogrenciler_id","hocalar_id"};
                int satir2 = 4;
     	        ilgiEkleButonu(tabloAdi,kolonlar2,satir2,Id);
            }
        });
		hocaE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hoca eklencek");
                secim = "HOCA";
                tabloAdi = "hocalar";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre","yonetici_id"};
                int satir = 5;
                deger = false;
                islemVisible(deger);
                ekleme(secim,tabloAdi,kolonlar,satir);
     	        ekleButonu(tabloAdi,kolonlar,satir);
     	        ogrenciGoruntuleButonu(tabloAdi);
     	       String tabloAdi2 ="ilgiler";
    	        Object[] kolonlar2= { tabloAdi2+"_id",tabloAdi2+"_ozellik","ogrenciler_id","hocalar_id"};
               int satir2 = 4;
     	        ilgiEkleButonu(tabloAdi,kolonlar2,satir2,Id);
     	       ders();
     	      dersEkleButonu(tabloAdi,kolonlar2,satir2,Id);
            }
        });
		ogrenciG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("oğrenci güncelleme");
                deger = false;
                tabloAdi = "ogrenciler";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre",tabloAdi+"_transkript","yonetici_id"};
                int satir = 6;
                String s1[] = { "ogrenciler_id", "ogrenciler_ad", "ogrenciler_soyad", "ogrenciler_sifre","ogrenciler_transkript","yonetici_id"};
                islemVisible(deger);
                guncelleme(tabloAdi,s1,kolonlar,satir);
                guncellemeButonu(tabloAdi,kolonlar,satir);
                //ekleButonu(tabloAdi);
            }
        });
		hocaG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hoca güncelleme");
                deger = false;
                tabloAdi = "hocalar";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre","yonetici_id"};
                int satir = 5;
                String s1[] = { "hocalar_id", "hocalar_ad", "hocalar_soyad", "hocalar_sifre","yonetici_id"};
                islemVisible(deger);
                guncelleme(tabloAdi,s1,kolonlar,satir);
                guncellemeButonu(tabloAdi,kolonlar,satir);
                //ekleButonu(tabloAdi);
            }
        });
		sistem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sistem");
                tabloAdi = "sistem";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_baslangic",tabloAdi+"_tarih","yonetici_id",tabloAdi+"_talepSuresi",tabloAdi+"_hocaTalebi",tabloAdi+"_kontenjan",tabloAdi+"_dagitim"};
                int satir = 8;
                tabloAdi = "sistem";
                deger = false;
                islemVisible(deger);
                String s1[] = { "sistem_id", "sistem_baslangic", "sistem_tarih", "yonetici_id","sistem_talepsuresi", "sistem_hocatalebi", "sistem_kontenjan", "sistem_dagitim"};
                sistem(tabloAdi,s1,kolonlar,satir);
                sistemButonu(tabloAdi,kolonlar,satir);
                guncellemeButonu(tabloAdi,kolonlar,satir);
            }
        });
		ogrenciS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("oğrenci silme");
                secim = "ÖĞRENCİ";
                tabloAdi = "ogrenciler";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre",tabloAdi+"_transkript","yonetici_id"};
                int satir = 6;
                deger = false;
                islemVisible(deger);
                silme(secim,tabloAdi,kolonlar,satir);
                silmeButonu(tabloAdi,kolonlar,satir);
            }
        });
		hocaS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hoca güncelleme");
                secim = "HOCA";
                tabloAdi = "hocalar";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre","yonetici_id"};
                int satir = 5;
                deger = false;
                islemVisible(deger);
                silme(secim,tabloAdi,kolonlar,satir);
                silmeButonu(tabloAdi,kolonlar,satir);
            }
        });
		rastgele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deger = false;
                islemVisible(deger);
                rastegeleAtama();
            }
        });
		notOrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deger = false;
                islemVisible(deger);
                notOrtAtama();
            }
        });
		derseGore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deger = false;
                islemVisible(deger);
                derseGoreAtama();
            }
        });
	}
	public void rastegeleAtama() {
		int say = 0;
		   String sql = "SELECT ogrenciler_id,ogrenciler_ort FROM ogrenciler";
		   Jdbc jdbc = new Jdbc();
		   jdbc.yap3(sql);
		   ResultSet resultSet = jdbc.yap3(sql);
	   	try {
	   		 while (resultSet.next()) {
	   			 say = ogrenciListesi.size();
				 ogrenciListesi.add(new Ogrenci(Id,Sifre));
	             ogrenciListesi.get(say).setId(resultSet.getString(1));
	             ogrenciListesi.get(say).setOrt(resultSet.getString(2));
	             System.out.println(ogrenciListesi.get(say).getOrt()+" "+ogrenciListesi.get(say).getId());
	            }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	   	acilanaYerleştir(ogrenciListesi);
		duzelt();
	}
	public void acilanaYerleştir(ArrayList<Ogrenci> ogrenci) {
		   int say = 0;
		   ArrayList<Integer> acilanId = new ArrayList<>();
	   	   ArrayList<Integer> kontenjan = new ArrayList<>();
		   String sql = "SELECT acilandersler_id,acilandersler_kontenjan FROM acilandersler";
		   Jdbc jdbc = new Jdbc();
		   jdbc.yap3(sql);
		   ResultSet resultSet = jdbc.yap3(sql);
	   	   try {
	   		 while (resultSet.next()) {
	   			 say = acilanId.size();
				 acilanId.add(resultSet.getInt(1));
				 kontenjan.add(resultSet.getInt(2));
	             System.out.println(acilanId.get(say)+" acilannnn  ssjsjssdj "+kontenjan.get(say));
	            }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	   	   /*
	   	   String sql2 = "SELECT acilandersler_id,ogrenciler_id FROM alilandersler";
		   jdbc.yap3(sql2);
		   ResultSet resultSet2 = jdbc.yap3(sql2);
	   	   try {
	   		 while (resultSet2.next()) {
	            }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			*/
	   	int sayac = 0;
    	String sql3 = "SELECT * FROM alinandersler";
    	ResultSet resultSet4 = jdbc.yap3(sql3);
    	try {
			while(resultSet4.next()){
			    sayac  = resultSet4.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	   int atama = 0;
	   	   while(atama!=acilanId.size()) {
	   		   for(int i=0;i<kontenjan.get(atama);i++){
	   			   sayac++;
	   			String sql2 = "insert into alinandersler(alinandersler_id,acilandersler_id,ogrenciler_id)"
                        + "values ('"+sayac+"','"+acilanId.get(atama)+"','"+ogrenciListesi.get(i).getId()+"')";
	   			kontenjan.set(atama, kontenjan.get(atama)-1);
            	jdbc.ekle(sql2);
	   		   }
	   		String sql1 = "update acilandersler set acilandersler_kontenjan = '"+kontenjan.get(atama)+"' where acilandersler_id = '"+acilanId.get(atama)+"'";
	    	jdbc.update(sql1);
	   		   atama++;
	   	   }
	   	   
	}
	public void notOrtAtama() {
		int say = 0;
		   String sql = "SELECT ogrenciler_id FROM ogrenciler";
		   Jdbc jdbc = new Jdbc();
		   jdbc.yap3(sql);
		   ResultSet resultSet = jdbc.yap3(sql);
	   	try {
	   		 while (resultSet.next()) {
	   			 say = ogrenciListesi.size();
				 ogrenciListesi.add(new Ogrenci(Id,Sifre));
	             ogrenciListesi.get(say).setId(resultSet.getString(1));
	            }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	   	acilanaYerleştir(ogrenciListesi);
		duzelt();
	}
	public void derseGoreAtama() {
		duzelt();
	}
	public void duzelt() {
		Jdbc jdbc = new Jdbc();
        String sql1 = "update sistem set sistem_dagitim = true where yonetici_id = '"+Id+"'";
        System.out.println(sql1);
    	jdbc.update(sql1);
	}
	public void islemVisible(Boolean deger) {
		ogrenciE.setVisible(deger);
		hocaE.setVisible(deger);
		ogrenciG.setVisible(deger);
		hocaG.setVisible(deger);
		sistem.setVisible(deger);
		ogrenciS.setVisible(deger);
		hocaS.setVisible(deger);
		rastgele.setVisible(deger);
		notOrt.setVisible(deger);
		derseGore.setVisible(deger);
	}
	public void sistem(String tabloAdi,String[] s1,Object[] kolonlar,int satir)  {
		String sql4 = "SELECT * FROM "+tabloAdi;
    	tabloGoster(sql4,tabloAdi,kolonlar,satir,20);
		lSistem.setText("SİSTEM İŞLEMLERİ");
		lSistem.setFont(new Font("",Font.BOLD,15));
		lSistem.setBounds(30,20,200,20);
        label.add(lSistem);
        sistemB.setFont(new Font("", Font.BOLD, 15));
        sistemB.setBounds(30, 45, 200, 20);
		label.add(sistemB);
		lCombo.setText("GÜNCELLEME SEÇİNİZ");
		lCombo.setFont(new Font("",Font.BOLD,15));
		lCombo.setBounds(30,70,200,20);
        label.add(lCombo);
        ComboBoxModel model = new DefaultComboBoxModel(s1);
        comboG.setModel(model);
        comboG.setBounds(30,95,200,20);
        label.add(comboG);
        lGuncel.setText("GÜNCELLEYİNİZ");
        lGuncel.setFont(new Font("",Font.BOLD,15));
        lGuncel.setBounds(30,120,200,20);
        label.add(lGuncel);
        tGuncel.setFont(new Font("",Font.BOLD,15));
        tGuncel.setBounds(30,145,200,20);
        label.add(tGuncel);
        comboB.setFont(new Font("", Font.BOLD, 15));
        comboB.setBounds(30, 170, 200, 20);
		label.add(comboB);
	}
	public void sistemButonu(String tabloAdi,Object[] kolonlar,int satir){
		sistemB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String guncellenecek = tabloAdi+"_tarih";
            	Jdbc jdbc = new Jdbc();
            	String sql = "SELECT "+tabloAdi+"_tarih FROM "+tabloAdi;
            	String tarih1 = null;
            	String tarih2 =null;
            	ResultSet resultSet = jdbc.yap3(sql);
            	try {
            		 while (resultSet.next()) {
                      tarih1  = resultSet.getString(1); // sütun sırası
					   System.out.println(tarih1);
					   tarih2 = tarih1;
                     }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localdGunu = LocalDate.parse(tarih1, formatter);
                System.out.println(localdGunu);
                tarih1 = localdGunu.plusDays(5).toString();
                System.out.println(tarih1);
            	String sql1 = "UPDATE "+tabloAdi+" SET "+tabloAdi+"_tarih ='" + tarih1 + "' WHERE "+tabloAdi+"_id='1' ";
                //String sql1 = "update sistem set sistem_tarih ='"+tarih1+"' where sistem_baslangic ='"+tarih2+"'";
                System.out.println(sql1);
            	jdbc.update(sql1);
            	String sql4 = "SELECT * FROM "+tabloAdi;
            	tabloGoster(sql4,tabloAdi,kolonlar,satir,20);
                jdbc.veri("sistem_guncelleme", Id, "yonetici");
            }
        });
	}
	public void guncelleme(String tabloAdi,String[] s1,Object[] kolonlar,int satir) {
		String sql4 = "SELECT * FROM "+tabloAdi;
    	tabloGoster(sql4,tabloAdi,kolonlar,satir,20);
		lCombo.setText("GÜNCELLEME SEÇİNİZ");
		lCombo.setFont(new Font("",Font.BOLD,15));
		lCombo.setBounds(30,20,200,20);
        label.add(lCombo);
        ComboBoxModel model = new DefaultComboBoxModel(s1);
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
        lKim.setText("VERİ ID GİRİNİZ");
        lKim.setFont(new Font("",Font.BOLD,15));
        lKim.setBounds(30,120,200,20);
        label.add(lKim);
        tKim.setFont(new Font("",Font.BOLD,15));
        tKim.setBounds(30,145,200,20);
        label.add(tKim);
        comboB.setFont(new Font("", Font.BOLD, 15));
        comboB.setBounds(30, 170, 200, 20);
		label.add(comboB);
	}
	public void guncellemeButonu(String tabloAdi,Object[] kolonlar,int satir){
		comboB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String guncellenecek = comboG.getSelectedItem().toString();
            	System.out.println(guncellenecek);
            	//System.out.println(guncellenecek+" guncelle");
            	Jdbc jdbc = new Jdbc();
            	String kim = tKim.getText();
            	if(tabloAdi.equals("sistem")){
            		kim = "1";
            	}
            	String sql1 = "UPDATE "+tabloAdi+" SET "+guncellenecek.toString()+"='" + tGuncel.getText() + "' WHERE "+tabloAdi+"_id='"+kim+"' ";
            	jdbc.update(sql1);
            	String sql = "SELECT * FROM "+tabloAdi;
            	tabloGoster(sql,tabloAdi,kolonlar,satir,20);
                jdbc.veri(tabloAdi+"_guncelleme", Id, "yonetici");
            }
        });
	}
	public void ekleme(String secim,String tabloAdi,Object[] kolonlar,int satir) {
		//String bir = tabloAdi+"_id,"+tabloAdi+"_ad,"+tabloAdi+"_soyad,"+tabloAdi+"_sifre";
		//String iki = "SELECT * FROM "+tabloAdi;
		//sqlTablosu(bir,4,label,iki);
		String sql = "SELECT * FROM "+tabloAdi;
    	tabloGoster(sql,tabloAdi,kolonlar,satir,20);
		lId.setText(secim+" ID GİRİNİZ:");
		lId.setFont(new Font("",Font.BOLD,15));
		lId.setBounds(30,20,400,20);
        label.add(lId);
        tId.setFont(new Font("",Font.BOLD,15));
        tId.setBounds(30,45,200,20);
        label.add(tId);
        lAd.setText(secim+" AD GİRİNİZ:");
        lAd.setFont(new Font("",Font.BOLD,15));
        lAd.setBounds(30,70,400,20);
        label.add(lAd);
        tAd.setFont(new Font("",Font.BOLD,15));
        tAd.setBounds(30,95,200,20);
        label.add(tAd);
        lSoy.setText(secim+" SOYAD GİRİNİZ:");
        lSoy.setFont(new Font("",Font.BOLD,15));
        lSoy.setBounds(30,120,400,20);
        label.add(lSoy);
        tSoy.setFont(new Font("",Font.BOLD,15));
        tSoy.setBounds(30,145,200,20);
        label.add(tSoy);
        lSifre.setText(secim+" SİFRE GİRİNİZ:");
        lSifre.setFont(new Font("",Font.BOLD,15));
        lSifre.setBounds(30,170,400,20);
        label.add(lSifre);
        tSifre.setFont(new Font("",Font.BOLD,15));
        tSifre.setBounds(30,195,200,20);
        label.add(tSifre);
        ekle.setText(secim+" EKLE:");
        ekle.setFont(new Font("",Font.BOLD,15));
        ekle.setBounds(30,220,200,20);
        label.add(ekle);
        comboGoruntule(tabloAdi);
        lIlgi.setFont(new Font("",Font.BOLD,15));
        lIlgi.setBounds(30,420,400,20);
        label.add(lIlgi);
        tIlgi.setFont(new Font("",Font.BOLD,15));
        tIlgi.setBounds(30,455,200,20);
        label.add(tIlgi);
        ilgi.setFont(new Font("", Font.BOLD, 15));
        ilgi.setBounds(30, 490, 200, 20);
		label.add(ilgi);
	}
	public void ders() {
		lDers.setFont(new Font("",Font.BOLD,15));
		lDers.setBounds(30,530,200,20);
	    label.add(lDers);
	    String s1[] = { "diferansiyel", "mantik", "cebir", "programlama","algoritma","nesne","veritabani", "sistem", "olasilik", "elektronik","siyaset","hukuk"};
	    ComboBoxModel model1 = new DefaultComboBoxModel(s1);
	    comboD.setModel(model1);
	    comboD.setBounds(30,555,200,20);
	    label.add(comboD);
	    Dekle.setFont(new Font("", Font.BOLD, 15));
	    Dekle.setBounds(30, 580, 200, 20);
		label.add(Dekle);
	}
	public void dersEkleButonu(String tabloAdi2,Object[] kolonlar,int satir,String kullanici_id) {
    	Dekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String secim = comboG.getSelectedItem().toString();
            	secim = secim.substring(0, secim.indexOf(" /"));
	            secim = ogrenciListesi.get(Integer.parseInt(secim)).getId();
            	String secim2 = comboD.getSelectedItem().toString();
            	Jdbc jdbc = new Jdbc();
            	int sayac = 0;
            	String tabloAdi ="acilandersler";
            	Object[] kolonlar2 = { tabloAdi+"_id",tabloAdi+"_ad","hocalar_id",tabloAdi+"_kontenjan"};
                int satir2 = 4;
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
            	String sql3 = "SELECT sistem_kontenjan FROM sistem";
            	String adet = null;
            	ResultSet resultSet3 = jdbc.yap3(sql3);
            	try {
					while(resultSet3.next()){
					    adet  = String.valueOf(resultSet3.getInt(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	sayac++;
            	String bos = "-";
            	String sql2 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ad,hocalar_id,"+tabloAdi+"_kontenjan)"
                        + "values ('"+sayac+"','"+secim2+"','"+secim+"','"+adet+"')";
            	jdbc.ekle(sql2);
            	String sql = "SELECT * FROM "+tabloAdi+" WHERE "+tabloAdi2+"_id='"+secim+"'";
               	tabloGoster(sql,tabloAdi,kolonlar2,satir2,480);
                jdbc.veri(tabloAdi+"_ekleme", Id, "yonetici");
            }
        });
	}
	public void comboGoruntule(String TabloAdi){
		   lCombo.setText("GÖRÜNTÜLEMEYİ SEÇİNİZ");
		   lCombo.setFont(new Font("",Font.BOLD,15));
		   lCombo.setBounds(30,330,500,20);
	       label.add(lCombo);
		   int say = 0;
		   String sql = "SELECT "+tabloAdi+"_id,"+tabloAdi+"_ad FROM "+tabloAdi;
		   Jdbc jdbc = new Jdbc();
		   jdbc.yap3(sql);
		   ResultSet resultSet = jdbc.yap3(sql);
	   	try {
	   		 while (resultSet.next()) {
	   			 say = ogrenciListesi.size();
				ogrenciListesi.add(new Ogrenci(Id,Sifre));
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
	    comboG.setBounds(30,355,200,20);
	    label.add(comboG);
	    comboB.setFont(new Font("", Font.BOLD, 15));
	    comboB.setBounds(30, 390, 200, 20);
		label.add(comboB);
	   }
	public void ogrenciGoruntuleButonu(String tabloAdi) {
		   comboB.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   String secim = comboG.getSelectedItem().toString();
	        	   secim = secim.substring(0, secim.indexOf(" /"));
	        	   System.out.println(secim);
	        	   secim = ogrenciListesi.get(Integer.parseInt(secim)).getId();
	        	   String tabloAdi1=tabloAdi;
	               String tabloAdi2="ilgiler";
	               String sql2 = "SELECT * FROM "+tabloAdi2+" WHERE "+tabloAdi+"_id='"+secim+"'";
	        	   Object[] kolonlar2= { "ilgiler_id","ilgiler_ozellik",tabloAdi+"_id"};
	               int satir2 = 3;
	               tabloGoster(sql2,tabloAdi2,kolonlar2,satir2,250);
	               if(tabloAdi.equals("ogrenciler")) {
	            	   String sql = "SELECT * FROM "+tabloAdi1+" WHERE "+tabloAdi1+"_id='"+secim+"'";
		        	   Object[] kolonlar= { tabloAdi1+"_id",tabloAdi1+"_ad",tabloAdi1+"_soyad",tabloAdi1+"_sifre",tabloAdi1+"_transkript","yonetici_id",tabloAdi1+"_ort"};
		               int satir = 7;
		               tabloGoster(sql,tabloAdi1,kolonlar,satir,20);
	               String tabloAdi3="dersler";
	               String sql3 = "SELECT * FROM "+tabloAdi3+" WHERE "+tabloAdi+"_id='"+secim+"'";
	        	   Object[] kolonlar3= { "dersler_id",tabloAdi+"_id","dersler_ad","dersler_not"};
	               int satir3 = 4;
	               tabloGoster(sql3,tabloAdi3,kolonlar3,satir3,480);}
	               if(tabloAdi.equals("hocalar")) {
	            	   String sql = "SELECT * FROM "+tabloAdi1+" WHERE "+tabloAdi1+"_id='"+secim+"'";
		        	   Object[] kolonlar= { tabloAdi1+"_id",tabloAdi1+"_ad",tabloAdi1+"_soyad",tabloAdi1+"_sifre","yonetici_id"};
		               int satir = 5;
		               tabloGoster(sql,tabloAdi1,kolonlar,satir,20);
		               String tabloAdi3="acilandersler";
		               String sql3 = "SELECT * FROM "+tabloAdi3+" WHERE "+tabloAdi+"_id='"+secim+"'";
		        	   Object[] kolonlar3= { tabloAdi3+"_id",tabloAdi3+"_ad","hocalar_id",tabloAdi3+"_kontenjan"};
		               int satir3 = 4;
		               tabloGoster(sql3,tabloAdi3,kolonlar3,satir3,480);}
	               Jdbc jdbc = new Jdbc();
	               jdbc.veri(tabloAdi+"_goruntuleme", Id, "yonetici");
	               }
	       });
	   }
	public void randomEkle(String tabloAdi,Object[] kolonlar,int satir) {
		ogrenciE2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String[] isimler = {
                        "Ahmet", "Ayşe", "Mustafa", "Zeynep", "Emir", "Elif", "Ali", "Melis", "Mert", "Ece",
                        "Yusuf", "Deniz", "Berkay", "Aslı", "Burak", "Selin", "Can", "İpek", "Furkan", "Zehra",
                        "Ege", "Ezgi", "Kerem", "Ceren", "Oğuz", "Elif Nur", "Umut", "Zara", "Bartu", "Ela",
                        "Berke", "Mira", "Arda", "Yağmur", "Efe", "Naz", "Tolga", "Sude", "Bora", "Duru",
                        "Efehan", "İlayda", "Okan", "Su", "Emre", "Derya", "Berfin", "Eren", "Simay", "Alperen"
                };
            	String[] soyadlar = {
            			"ŞEN","KANDEMİR","ÇEVİK","ERKURAN","TÜTEN","ÖZTÜRK","YÜZBAŞIOĞLU","VURAL","YÜCEL","SÖNMEZ",
            			"ERTEKİN","DEDE","UYANIK","ASLAN","AKBULUT","ORHON","UZ","YAVUZ","ERDEM","KULAÇ","KAYA","SELVİ",
            			"AKPINAR","ABACIOĞLU","ÇAY","IŞIK","ÖZER","ÖZDEMİR","ÖZTÜRK","TAHTACI"
            	};
            	String[] dersler = {
            			"Tarih", "Edebiyat", "Kimya","Matematik", "Fizik"," Coğrafya", "Biyoloji", "İngilizce", "Din Kültürü", "İnkılap"
            			};
            	String[] not = {
            			"AA","BA","BB","CB","CC","DC"
            	};
            	Jdbc jdbc = new Jdbc();
            	int sayac = 0;
            	String sql = "SELECT * FROM dersler";
            	ResultSet resultSet = jdbc.yap3(sql);
            	try {
					while(resultSet.next()){
					    sayac  = resultSet.getInt(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	int randomIndex=0,randomIndex2=0,randomIndex3=0,randomIndex4=0,randomIndex5=0;
            	String ek = "100";
            	String id = null;
            	String ders = null;
            	String nott = null;
            	String sifre = "123";
            	Random random = new Random();
            	for (int i = 0; i < 10; i++) {
                    randomIndex = random.nextInt(isimler.length);
                    randomIndex2 = random.nextInt(soyadlar.length);
                    randomIndex3 = random.nextInt(999-100) + 100;
                    id = String.valueOf(randomIndex3)+ek;
                    ek = String.valueOf(Integer.parseInt(ek)+1);
                	int bir = random.nextInt(5);
                	int iki = random.nextInt(10);
                	int uc = random.nextInt(10);
                	String ort = null;
                	String ne = "var";
                	ort = String.valueOf(bir)+"."+String.valueOf(iki)+String.valueOf(uc);
                    String randomIsim = isimler[randomIndex];
                    String randomSoy = soyadlar[randomIndex2];
                	String sql1 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ad,"+tabloAdi+"_soyad,"+tabloAdi+"_sifre,"+tabloAdi+"_transkript,yonetici_id,"+tabloAdi+"_ort)"
                            + "values ('"+id+"','"+randomIsim+"','"+randomSoy+"','"+sifre+"','"+ne+"',0,'"+ort+"')";
                	jdbc.ekle(sql1);
                	for(int j=0;j<2;j++) {
                		sayac++;
                		randomIndex4 = random.nextInt(dersler.length);
                        randomIndex5 = random.nextInt(not.length);
                        ders = dersler[randomIndex4];
                        nott = not[randomIndex5];
                        String sql5 = "insert into dersler(dersler_id,ogrenciler_id,dersler_ad,dersler_not)"
                                + "values ('"+sayac+"','"+id+"','"+ders+"','"+nott+"')";
                    	jdbc.ekle(sql5);
                	}
                }
            	String sql4 = "SELECT * FROM "+tabloAdi;
            	tabloGoster(sql4,tabloAdi,kolonlar,satir,20);
                jdbc.veri(tabloAdi+"_ekleme", Id, "yonetici");
            }
        });
	}
	public void silme(String secim,String tabloAdi,Object[] kolonlar,int satir) {
		String sql = "SELECT * FROM "+tabloAdi;
    	tabloGoster(sql,tabloAdi,kolonlar,satir,20);
		lSid.setText("SİLİNECEK "+secim+" ID GİRİNİZ:");
		lSid.setFont(new Font("",Font.BOLD,15));
		lSid.setBounds(30,20,400,20);
        label.add(lSid);
        tSid.setFont(new Font("",Font.BOLD,15));
        tSid.setBounds(30,45,200,20);
        label.add(tSid);
        sil.setText(secim+" SİL:");
        sil.setFont(new Font("",Font.BOLD,15));
        sil.setBounds(30,70,200,20);
        label.add(sil);
	}
	public void silmeButonu(String tabloAdi,Object[] kolonlar,int satir){
		sil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//System.out.println(guncellenecek+" guncelle");
            	Jdbc jdbc = new Jdbc();
            	String sql1 = "DELETE FROM " +tabloAdi+ " WHERE "+tabloAdi+"_id='"+tSid.getText()+"' ";
            	jdbc.sil(sql1);
            	String sql = "SELECT * FROM "+tabloAdi;
            	tabloGoster(sql,tabloAdi,kolonlar,satir,20);
                jdbc.veri(tabloAdi+"_silme", Id, "yonetici");
            }
        });
	}
	public void tabloGoster(String sql,String tabloAdi,Object[] kolonlar,int satir,int y) {
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
                    if(satir>=7) {
                    satirlar[6] = res.getString(7);}
                    if(satir>=8) {
                    satirlar[7] = res.getString(8);}
                model.addRow(satirlar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        table.setModel(model);
	}
	
	public void ekleButonu(String tabloAdi,Object[] kolonlar,int satir){
		ekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Random random = new Random();
            	int bir = random.nextInt(5);
            	int iki = random.nextInt(10);
            	int uc = random.nextInt(10);
            	String ort = null;
            	String ne = "var";
            	ort = String.valueOf(bir)+"."+String.valueOf(iki)+String.valueOf(uc);
            	Jdbc jdbc = new Jdbc();
            	String sql1 = null;
            	if(tabloAdi.equals("ogrenciler")) {
            	sql1 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ad,"+tabloAdi+"_soyad,"+tabloAdi+"_sifre,"+tabloAdi+"_transkript,yonetici_id,"+tabloAdi+"_ort)"
                        + "values ('"+tId.getText()+"','"+tAd.getText()+"','"+tSoy.getText()+"','"+tSifre.getText()+"','"+ne+"',0,'"+ort+"')";}
            	else {
            	sql1 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ad,"+tabloAdi+"_soyad,"+tabloAdi+"_sifre,yonetici_id)"
                        + "values ('"+tId.getText()+"','"+tAd.getText()+"','"+tSoy.getText()+"','"+tSifre.getText()+"',0)";}
            	
            	jdbc.ekle(sql1);
            	String sql = "SELECT * FROM "+tabloAdi;
            	tabloGoster(sql,tabloAdi,kolonlar,satir,20);
            	String[] dersler = {
            			"Tarih", "Edebiyat", "Kimya","Matematik", "Fizik"," Coğrafya", "Biyoloji", "İngilizce", "Din Kültürü", "İnkılap"
            			};
            	String[] not = {
            			"AA","BA","BB","CB","CC","DC"
            	};
            	int sayac = 0;
            	String sql2 = "SELECT * FROM dersler";
            	ResultSet resultSet = jdbc.yap3(sql2);
            	try {
					while(resultSet.next()){
					    sayac  = resultSet.getInt(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	if(tabloAdi.equals("ogrenciler")){
            	int randomIndex4=0,randomIndex5=0;
            	String id = null;
            	String ders = null;
            	String nott = null;
            	for(int j=0;j<2;j++) {
            		sayac++;
            		randomIndex4 = random.nextInt(dersler.length);
                    randomIndex5 = random.nextInt(not.length);
                    ders = dersler[randomIndex4];
                    nott = not[randomIndex5];
                    String sql5 = "insert into dersler(dersler_id,ogrenciler_id,dersler_ad,dersler_not)"
                            + "values ('"+sayac+"','"+tId.getText()+"','"+ders+"','"+nott+"')";
                	jdbc.ekle(sql5);
            	}
            	}
            	jdbc.veri(tabloAdi+"_ekleme", Id, "yonetici");
            }
        });
	}
	public void ilgiEkleButonu(String tabloAdi2,Object[] kolonlar,int satir,String kullanici_id) {
    	ilgi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String secim = comboG.getSelectedItem().toString();
            	secim = secim.substring(0, secim.indexOf(" /"));
	            System.out.println(secim);
	       	    secim = ogrenciListesi.get(Integer.parseInt(secim)).getId();
            	Jdbc jdbc = new Jdbc();
            	int sayac = 0;
            	String tabloAdi = "ilgiler";
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
            	if(tabloAdi2.equals("hocalar")) {
            	String sql2 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ozellik,"+"ogrenciler_id,hocalar_id)"
                        + "values ('"+sayac+"','"+tIlgi.getText()+"','"+bos+"','"+secim+"')";
            	jdbc.ekle(sql2);}
            	if(tabloAdi2.equals("ogrenciler")) {
                	String sql2 = "insert into "+tabloAdi+"("+tabloAdi+"_id,"+tabloAdi+"_ozellik,"+"ogrenciler_id,hocalar_id)"
                            + "values ('"+sayac+"','"+tIlgi.getText()+"','"+secim+"','"+bos+"')";
                	jdbc.ekle(sql2);}
            	String sql = "SELECT * FROM "+tabloAdi+" WHERE "+tabloAdi2+"_id='"+secim+"'";
               	tabloGoster(sql,tabloAdi,kolonlar,satir,250);
                jdbc.veri(tabloAdi+"_ekleme", Id, "yonetici");
            }
        });
    }
	
}
