import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Ogrenci extends JFrame{
	Boolean deger;
	String secim ;
	String tabloAdi;
	JPanel panel = new JPanel();
	JLabel  label = new JLabel();
	JButton menu = new JButton("ANA MENÜ");
	JButton Nmenu = new JButton("MENÜ");
	JButton transkript = new JButton("TRANSKRİPT OKU");
	JButton ogrenciE = new JButton("ÖĞRENCİ BİLGİ");
	JButton comboB = new JButton("SEÇ");
	JButton hocaE = new JButton("Ders Bilgilendirme");
	JButton ogrenciG = new JButton("ÖĞRENCİ Ders Filtreleme");
	JButton hocaG = new JButton("ALINAN DERSLER");
	JButton sistem = new JButton("ogrenci ilgi alani filtreleme");//sistem ayarları
	//JLabel lId = new JLabel(secim+" ID GİRİNİZ:");
	//JLabel lAd = new JLabel(secim+" AD GİRİNİZ:");
    JLabel lSoy = new JLabel(secim+" SOYAD GİRİNİZ:");
    JLabel lSifre = new JLabel(secim+" SİFRE GİRİNİZ:");
    JLabel lCombo = new JLabel("GÜNCELLEME SEÇİNİZ");
    JLabel lGuncel = new JLabel("GÜNCELLEMEYİ GİRİNİZ");
    JLabel lKim = new JLabel("VERİ ID GİRİNİZ");
    JLabel lSistem = new JLabel("SİSTEM İŞLEMLERİ");
    JLabel lSid = new JLabel("SİLİNECEK"+secim+" ID GİRİNİZ:");
    JLabel lIlgi = new JLabel("İLGİ ALANI GİRİNİZ"); 
    JButton ogrenciT = new JButton("ÖĞRENCİ TALEBİ OLUŞTUR-MESAJ AT");
    JButton gostert= new JButton("verileri ekle");
   // JButton ogrenciS = new JButton("ÖĞRENCİ SİL");
	//JButton hocaS = new JButton("HOCA SİL");
	JButton sistemB = new JButton("GÜN İLERLET");
    JButton ekle = new JButton(secim+" EKLE:");
    JButton filtreleme = new JButton("FİLTRELEME");
    JButton sil = new JButton(secim+" SİL:");
    JButton gonder = new JButton(" DERS EKLE:");
    JButton tarik = new JButton(" ders dokun");
    JTextField tId = new JTextField();
    JTextField tGuncel = new JTextField();
    JTextField tAd = new JTextField();
    JTextField tSoy = new JTextField();
    JTextField tSifre = new JTextField();
    JTextField tKim = new JTextField();
    JTextField tSid = new JTextField();
    JComboBox comboG = new JComboBox();
    JTextArea mesaj =new  JTextArea();
    JLabel mesajver = new JLabel("HOCAYA MESAJ GİRİNİZ:");
    JButton mesajgonder = new JButton("gönder");
    String Kullanici_id;
    String Sifre;
    private String ad;
	private String id;
	private String ort;
	public Ogrenci(String kullanici_id,String sifre) {
		   Kullanici_id = kullanici_id;
		   Sifre = sifre;
	       add(panel);
	       setSize(1000,680);
	       setTitle("OBS OGRENCİ");
	       label.setBackground(Color.black);
	       label.setIcon(new ImageIcon(new ImageIcon("/Users/user/eclipse-workspace/Yazlab/img/kocaeli-universitesi4428.jpg").getImage().getScaledInstance(866, 650, Image.SCALE_SMOOTH)));
	       label.setBounds(0,0,800,600);
	       getContentPane().add(label);
	       menuDon();
	       menu();
	       menu.setFont(new Font("", Font.BOLD, 15));
	       menu.setBounds(0, 0, 150, 20);
		   label.add(menu);
		   Nmenu.setFont(new Font("", Font.BOLD, 15));
	       Nmenu.setBounds(155, 0, 150, 20);
		   label.add(Nmenu);
	       islemYerlesimi();
	       islemSecimi();
	       JLabel bos = new JLabel();
	       label.add(bos);
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public void islemYerlesimi() {
		String tr=null;
		String sql1 = "SELECT ogrenciler_transkript FROM ogrenciler WHERE ogrenciler_id='"+Kullanici_id+"'";
		Jdbc jdbc = new Jdbc();
    	ResultSet resultSet = jdbc.yap3(sql1);
    	try {
			while(resultSet.next()){
			   tr  = resultSet.getString(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	if(tr.equals("yok")) {
		transkript.setFont(new Font("", Font.BOLD, 25));
		transkript.setBounds(240, 100, 300, 40);
		label.add(transkript);}
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
		label.add(hocaE);
		sistem.setFont(new Font("", Font.BOLD, 25));
		sistem.setBounds(240, 300, 300, 40);
		label.add(sistem);
		
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
            	Ogrenci hesap = new Ogrenci(Kullanici_id,Sifre);
       		    hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                hesap.setVisible(true);
            }
        });
	}
	public void islemSecimi() {
		transkript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Pdf pdf = new Pdf();
               try {
				pdf.oku(Kullanici_id,panel);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });
		ogrenciE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ogrenci bilgileri");
                secim = "ÖĞRENCİ";
                tabloAdi = "ogrenciler";
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad",tabloAdi+"_soyad",tabloAdi+"_sifre",tabloAdi+"_transkript","yonetici_id"};
                int satir = 6;
                deger = false;
                islemVisible(deger);
                ekleme(secim,tabloAdi,kolonlar,satir);
     	       // ekleButonu(tabloAdi,kolonlar,satir);
            }
        });
		hocaE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ders Bilgileri");
                secim = "HOCA";
                tabloAdi = "dersler";
                Object[] kolonlar= { tabloAdi+"_id","ogrenciler_id",tabloAdi+"_ad",tabloAdi+"_not"};
                int satir = 4;
                deger = false;
                islemVisible(deger);
                ekleme(secim,tabloAdi,kolonlar,satir);
     	       // ekleButonu(tabloAdi,kolonlar,satir);
            }
        });
		ogrenciG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ogrenci ders filtreleme");
                deger = false;
                tabloAdi = "acilandersler";
                Object[] kolonlar= { "acilanDersler_id","acilanDersler_ad","hocalar_id","acilanDersler_kontenjan"};
                int satir = 4;
                String s1[] = {"mat","dif","fizik","mikroislemci","veri yapiları"};
                islemVisible(deger);    
                derssecim(tabloAdi,s1,kolonlar,satir);
                eklemebir(secim,tabloAdi,kolonlar,satir);
                
                //guncellemeButonu(tabloAdi,kolonlar,satir);
                //ekleButonu(tabloAdi);
            }
        });
		
		
		
			   filtreleme.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent e) {
		        	   deger = false;
		               islemVisible(deger);
		        	   //ogrenciGoruntule();
		        	   dersGoruntuleButonu();
		        	   
		        	   
		        	   
		        	   Jdbc jdbc = new Jdbc();
		                String sql1 = "İNSERT İNTO talepogrenci (talepogrenci_id,"+"acilandersler_id,"+"talepogrenci_durum,"+"talepogrenci_tarih,"+"acilandersler_mesaj)"
		                               + "values ('"+Kullanici_id+"','"+tAd.getText()+"','"+mesaj.getText()+"','"+tSifre.getText()+"'"+null+"')";
		            	jdbc.ekle(sql1);
		            	
		        	   
		        	   
		        	   
		           }
		       });
		
		
		hocaG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 System.out.println("Ders Bilgileri");
                 secim = "HOCA";
                 tabloAdi = "alinandersler";
                 Object[] kolonlar= { tabloAdi+"_id","acilandersler_id","ogrenciler_id","ogrenciler_ad"};
                 int satir = 4;
                 deger = false;
                 islemVisible(deger);
                 ekleme(secim,tabloAdi,kolonlar,satir);
                //ekleButonu(tabloAdi); 
            }
        });
		
		sistem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*System.out.println("Mesaj");
                Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_baslangic",tabloAdi+"_tarih","yonetici_id"};
                int satir = 4;
                tabloAdi = "sistem";
                deger = false;
                islemVisible(deger);
                sistem(tabloAdi,kolonlar,satir);
                mesaj(tabloAdi,kolonlar,satir);
                */
            	
            	 System.out.println("ogrenci ilgi alani filtreleme");
                 deger = false;
                 tabloAdi = "ilgiler";
                 Object[] kolonlar= {"ilgiler_id","ilgiler_ozellik","ogrenciler_id","hocalar_id"};
                 int satir = 4;
                 String s1[] = {"sayisal", "sözel", "esit_agirlik","dil","veri yapiları"};
                 islemVisible(deger);    
                 ilgisecim(tabloAdi,s1,kolonlar,satir);
                 eklemebir(secim,tabloAdi,kolonlar,satir);
            	
            	
            }
        });

	}
	public void islemVisible(Boolean deger) {
		ogrenciE.setVisible(deger);
		hocaE.setVisible(deger);
		ogrenciG.setVisible(deger);
		hocaG.setVisible(deger);
		sistem.setVisible(deger);
		transkript.setVisible(deger);
	}/*
	public void sistem(String tabloAdi,Object[] kolonlar,int satir)  {
		tabloGoster(tabloAdi,kolonlar,satir);
		lSistem.setText("SİSTEM İŞLEMLERİ");
		lSistem.setFont(new Font("",Font.BOLD,15));
		lSistem.setBounds(30,20,200,20);
        label.add(lSistem);
        sistemB.setFont(new Font("", Font.BOLD, 15));
        sistemB.setBounds(30, 45, 200, 20);
		label.add(sistemB);
		mesajver.setBounds(30,190,200,20);
        label.add(mesajver);
		//mesaj.setFont(new Font("", Font.BOLD, 15));
		mesaj.setBounds(50, 100, 50, 20);
		label.add(mesaj);
		mesajgonder.setBounds(30,50,200,20);
		label.add(mesajgonder);
	}
	*/
	public void mesaj(String tabloAdi,Object[] kolonlar,int satir){
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
				}/*
            	
            	*/String sql1 = "UPDATE "+tabloAdi+" SET "+tabloAdi+"_tarih ='" + tarih1 + "' WHERE "+tabloAdi+"_id='1' ";
                //String sql1 = "update sistem set sistem_tarih ='"+tarih1+"' where sistem_baslangic ='"+tarih2+"'";
                System.out.println(sql1);
            	jdbc.update(sql1);
            	tabloGoster(tabloAdi,kolonlar,satir);
            }
        });
	}
	String derstutucu;
	public void derssecim(String tabloAdi,String[] s1,Object[] kolonlar,int satir) {
		tabloGoster1(tabloAdi,kolonlar,satir);
		lCombo.setText("DERS SEÇİNİZ");
		lCombo.setFont(new Font("",Font.BOLD,15));
		lCombo.setBounds(30,20,200,20);
        label.add(lCombo);
        
        ComboBoxModel model = new DefaultComboBoxModel(s1 );
        comboG.setModel(model);
        comboG.setBounds(30,45,200,20);
        label.add(comboG);
        tarik.setBounds(30,80,200,20);
        label.add(tarik);
       
         tarik.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             
            	 derstutucu = (String) comboG.getSelectedItem();
             }
             });
         //burda yaz table row larını yazcan
        
         gonder.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             
            	 eklemeiki(secim,tabloAdi,kolonlar,satir);
             }
             });
         gostert.setBounds(30,350,200,20);
         label.add(gostert);
         String mesaj1=Kullanici_id.toString();
         String talepdurum ="olumlu";
         String taleptarih ="1";
         gostert.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             
            	 Jdbc jdbc = new Jdbc();
                 String sql1 = "INSERT INTO talepogrenci (talepogrenci_id,talepogrenci_mesaj,acilandersler_id,talepogrenci_durum,talepogrenci_tarih) values('"+mesaj1+"','"+mesaj.getText()+"','"+derstutucu+"','"+talepdurum+"','"+taleptarih+"')";
             	jdbc.ekle(sql1);
             
             }
             });
         
         
         
         
       
		mesajver.setBounds(30,190,200,20);
        label.add(mesajver);
		//mesaj.setFont(new Font("", Font.BOLD, 15));
		mesaj.setBounds(30, 250, 200, 20);
		label.add(mesaj);
		String durum;
        durum="olumlu";
		gonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           // mesajtutucu=mesaj.toString();
            	String message = mesaj.getText(); // JTextArea'daki metni al
                System.out.println("Kaydedilen Mesaj: " + message);
                //Hocalar hmesaj = new Hocalar(message);
                
                Jdbc jdbc = new Jdbc();
                String sql1 = "INSERT INTO talepogrenci (talepogrenci_id,talepogrenci_mesaj) values(Kullanici_id,'yeterrrrrr')";
            	jdbc.ekle(sql1);
            	tabloGoster1(tabloAdi,kolonlar,satir);
                //TID BOS SETBOUNDS FALAN YOK ONLARA BAK
            }
            });
		
		gonder.setBounds(30, 280, 100, 40);
		label.add(gonder);
	}
	
	
	
	
	public void ilgisecim(String tabloAdi,String[] s1,Object[] kolonlar,int satir) {
		tabloGoster1(tabloAdi,kolonlar,satir);
		lCombo.setText("ilgi alani SEÇİNİZ");
		lCombo.setFont(new Font("",Font.BOLD,15));
		lCombo.setBounds(30,20,200,20);
        label.add(lCombo);
        ComboBoxModel model = new DefaultComboBoxModel(s1);
        comboG.setModel(model);
        comboG.setBounds(30,45,200,20);
        label.add(comboG);
         //derstutucu = (String) comboG.getSelectedItem();
         filtreleme.setBounds(30,70 , 200, 20);
         label.add(filtreleme);
         tarik.setBounds(30,90,200,20);
         label.add(tarik);
         tarik.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             
            	 derstutucu = (String) comboG.getSelectedItem();
             }
             });
         
         
         gonder.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             
            	 eklemeüc(secim,tabloAdi,kolonlar,satir);
             }
             });
         
         
       /* lGuncel.setText("HOCA SECİNİZ");
        lGuncel.setFont(new Font("",Font.BOLD,15));
        lGuncel.setBounds(30,80,200,20);
        label.add(lGuncel);
        tGuncel.setFont(new Font("",Font.BOLD,15));
        tGuncel.setBounds(30,100,200,20);
        label.add(tGuncel);
        
        tKim.setFont(new Font("",Font.BOLD,15));
        tKim.setBounds(30,145,200,20);
        label.add(tKim);
        comboB.setFont(new Font("", Font.BOLD, 15));
        comboB.setBounds(30, 170, 200, 20);
		label.add(comboB);
		*/
		
		gonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           // mesajtutucu=mesaj.toString();
            	String message = mesaj.getText(); // JTextArea'daki metni al
                System.out.println("Kaydedilen Mesaj: " + message);
                //Hocalar hmesaj = new Hocalar(message);
            }
            });
		
		gonder.setBounds(30, 280, 100, 40);
		label.add(gonder);
	}
	
	
	
	public void dersGoruntuleButonu() {
		   comboG.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   String secim = comboG.getSelectedItem().toString();
	        	   //secim = secim.substring(0, 1);
	        	   //System.out.println(secim);
	        	   //secim = dersListesi.get(Integer.parseInt(secim)).getacilanders_id();
	        	   String tabloAdi="acilandersler";
	        	   String sql = "SELECT * FROM "+tabloAdi+" WHERE acilandersler_ad='"+secim+"'";
	        	   Object[] kolonlar= { tabloAdi+"_id",tabloAdi+"_ad","hocalar_id",tabloAdi+"_kontenjan"};
	               int satir = 4;
	               tabloGoster(sql,kolonlar,satir);
	           }
	       });
	   }
	
	
	
	public void guncellemeButonu(String tabloAdi,Object[] kolonlar,int satir){
		comboB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String guncellenecek = tabloAdi+"_"+comboG.getSelectedItem().toString();
            	Jdbc jdbc = new Jdbc();
            //	statement = connection.createStatement();
              //  rs = statement.executeQuery("SELECT * FROM acilan_dersler WHERE type = 'secim'")
            	//String sql1 = "UPDATE "+tabloAdi+" SET "+guncellenecek.toString()+"='" + tGuncel.getText() + "' WHERE "+tabloAdi+"_id='"+tKim.getText()+"' ";
            	//jdbc.update(sql1);
            	tabloGoster1(tabloAdi,kolonlar,satir);
            }
        });
	}
	public void ekleme(String secim,String tabloAdi,Object[] kolonlar,int satir) {
		
		tabloGoster(tabloAdi,kolonlar,satir);
		
		
	}
public void eklemebir(String secim,String tabloAdi,Object[] kolonlar,int satir) {
		
		tabloGoster1(tabloAdi,kolonlar,satir);
		
		
	}
	
public void eklemeiki(String secim,String tabloAdi,Object[] kolonlar,int satir) {
	
	tabloGoster2(tabloAdi,kolonlar,satir);
	
	
}


public void eklemeüc(String secim,String tabloAdi,Object[] kolonlar,int satir) {
	
	
	ilgialanitablotabloGoster3(tabloAdi,kolonlar,satir);
	
}


	public void tabloGoster(String tabloAdi,Object[] kolonlar,int satir) {
		DefaultTableModel model = new DefaultTableModel();
        Object[] satirlar = new Object[satir];
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(300, 20, 700, 400);
        label.add(scrollPane);
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        model.setColumnIdentifiers(kolonlar);
        model.setRowCount(0);
        Jdbc jdbc = new Jdbc();
        try {
			//String kullanici_id1=kullanici_id;
			//Statement state = jdbc.connectState();
            String query = "SELECT * FROM "+tabloAdi+" WHERE ogrenciler_id='"+Kullanici_id+"'";
            //ResultSet res = state.executeQuery(query);
            ResultSet res=jdbc.yap3(query);
            while (res.next()) {
            	//for(int i=0;i<satirSayisi;i++) {
            	//	satirlar[i] = res.getString(i+1);
            	//}
                satirlar[0] = res.getString(1);
                satirlar[1] = res.getString(2);
                satirlar[2] = res.getString(3);
                satirlar[3] = res.getString(4);
                if(satir==5) {
                satirlar[4] = res.getString(5);}
                if(satir==6) {
                    satirlar[5] = res.getString(6);}
                model.addRow(satirlar);
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
        table.setModel(model);
	}
	
	public void tabloGoster1(String tabloAdi,Object[] kolonlar,int satir) {
		DefaultTableModel model = new DefaultTableModel();
        Object[] satirlar = new Object[satir];
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(300, 20, 700, 400);
        label.add(scrollPane);
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        model.setColumnIdentifiers(kolonlar);
        model.setRowCount(0);
        Jdbc jdbc = new Jdbc();
        try {
			//String kullanici_id1=kullanici_id;
			//Statement state = jdbc.connectState();
            String query = "SELECT * FROM "+tabloAdi;//+" WHERE acilandersler_ad="+derstutucu+"'"3-+
            
            
            //ResultSet res = state.executeQuery(query);
            ResultSet res=jdbc.yap3(query);
            while (res.next()) {
            	//for(int i=0;i<satirSayisi;i++) {
            	//	satirlar[i] = res.getString(i+1);
            	//}
                satirlar[0] = res.getString(1);
                satirlar[1] = res.getString(2);
                satirlar[2] = res.getString(3);
                satirlar[3] = res.getString(4);
                if(satir==5) {
                satirlar[4] = res.getString(5);}
                if(satir==6) {
                    satirlar[5] = res.getString(6);}
                model.addRow(satirlar);
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
        table.setModel(model);
	}
	
	public void tabloGoster2(String tabloAdi,Object[] kolonlar,int satir) {
		DefaultTableModel model = new DefaultTableModel();
        Object[] satirlar = new Object[satir];
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(300, 20, 700, 400);
        label.add(scrollPane);
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        model.setColumnIdentifiers(kolonlar);
        model.setRowCount(0);
        Jdbc jdbc = new Jdbc();
        try {
			//String kullanici_id1=kullanici_id;
			//Statement state = jdbc.connectState();
            String query = "SELECT * FROM "+tabloAdi+" WHERE acilandersler_ad='"+derstutucu+"'";
           // String sql = "insert into "+tabloAdi+"("+"talepogrenci_tarih,"+"talepogrenci_durum,"+"talepogrenci_mesaj"+"acilandersler_id)"
             //       + "values ('"+tId.getText()+"','"+tAd.getText()+"','"+tSoy.getText()+"','"+tSifre.getText()+"')";
            
            //ResultSet res = state.executeQuery(query);
            ResultSet res=jdbc.yap3(query);
            while (res.next()) {
            	//for(int i=0;i<satirSayisi;i++) {
            	//	satirlar[i] = res.getString(i+1);
            	//}
                satirlar[0] = res.getString(1);
                satirlar[1] = res.getString(2);
                satirlar[2] = res.getString(3);
                satirlar[3] = res.getString(4);
                if(satir==5) {
                satirlar[4] = res.getString(5);}
                if(satir==6) {
                    satirlar[5] = res.getString(6);}
                model.addRow(satirlar);
                
                
                //
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object value1 = table.getValueAt(selectedRow, 0); // 1. sütun değeri
                    Object value2 = table.getValueAt(selectedRow, 1);
                
                    
                    
                
                }
                String sql1 = "İNSERT İNTO talepogrenci (talepogrenci_id,"+"acilandersler_id,"+"talepogrenci_durum,"+"talepogrenci_tarih,"+"acilandersler_mesaj)"
                        + "values ('"+tId.getText()+"','"+tAd.getText()+"','"+mesaj.getText()+"','"+tSifre.getText()+"'"+null+"')";
     	jdbc.ekle(sql1);
                //
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
        table.setModel(model);
	}
	public void ilgialanitablotabloGoster3(String tabloAdi,Object[] kolonlar,int satir) {
		DefaultTableModel model = new DefaultTableModel();
        Object[] satirlar = new Object[satir];
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(300, 20, 700, 400);
        label.add(scrollPane);
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        model.setColumnIdentifiers(kolonlar);
        model.setRowCount(0);
        Jdbc jdbc = new Jdbc();
        try {
			//String kullanici_id1=kullanici_id;
			//Statement state = jdbc.connectState();
            String query = "SELECT * FROM "+tabloAdi+" WHERE ilgiler_id='"+derstutucu+"'";
           // String sql = "insert into "+tabloAdi+"("+"talepogrenci_tarih,"+"talepogrenci_durum,"+"talepogrenci_mesaj"+"acilandersler_id)"
             //       + "values ('"+tId.getText()+"','"+tAd.getText()+"','"+tSoy.getText()+"','"+tSifre.getText()+"')";
            
            //ResultSet res = state.executeQuery(query);
            ResultSet res=jdbc.yap3(query);
            while (res.next()) {
            	//for(int i=0;i<satirSayisi;i++) {
            	//	satirlar[i] = res.getString(i+1);
            	//}
                satirlar[0] = res.getString(1);
                satirlar[1] = res.getString(2);
                satirlar[2] = res.getString(3);
                satirlar[3] = res.getString(4);
                if(satir==5) {
                satirlar[4] = res.getString(5);}
                if(satir==6) {
                    satirlar[5] = res.getString(6);}
                model.addRow(satirlar);
            }
        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
        table.setModel(model);
	}
	/*
	 public void ogrenciGoruntule(){
		   lCombo.setText("GÖRÜNTÜLEYECEĞİNİZ ÖĞRENCİYİ SEÇİNİZ");
		   lCombo.setFont(new Font("",Font.BOLD,15));
		   lCombo.setBounds(30,20,500,20);
	       label.add(lCombo);
		   int say = 0;
		   String sql = "SELECT acilandersler_id,hocalar_id FROM acilandersler WHERE acilandersler_ad='"+derstutucu+"'";
		   Jdbc jdbc = new Jdbc();
		   jdbc.yap3(sql);
		   ResultSet resultSet = jdbc.yap3(sql);
	  
	   
	   //	ComboBoxModel model = new DefaultComboBoxModel(ad_id);
	    //comboG.setModel(model);
	    //comboG.setBounds(30,45,200,20);
	    //label.add(comboG);
	    comboB.setFont(new Font("", Font.BOLD, 15));
	    comboB.setBounds(30, 70, 200, 20);
		label.add(comboB);
	   }
	*/
}