import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Giris extends JFrame{
	JPanel panel = new JPanel();
    JLabel  label = new JLabel();
    boolean acilim1;
	public Giris(String secim,boolean acilim) throws ClassNotFoundException, SQLException {
		acilim1 = acilim;
		String tabloAdi = null;
        add(panel);
        setSize(800,680);
        setTitle("OBS SİSTEME GİRİŞ ");
        label.setBackground(Color.black);
		label.setIcon(new ImageIcon(new ImageIcon("/Users/user/eclipse-workspace/Yazlab/img/kocaeli-universitesi4428.jpg").getImage().getScaledInstance(866, 650, Image.SCALE_SMOOTH)));
        label.setBounds(0,0,800,600);
        getContentPane().add(label);
        switch(secim) {
        case "YÖNETİCİ":
        	System.out.println(secim);
        	tabloAdi = "yonetici";
        	girisEkran(secim,tabloAdi);
        	break;
        case "ÖĞRENCİ":
        	System.out.println(secim);
        	tabloAdi = "ogrenciler";
        	girisEkran(secim,tabloAdi);
        	break;
        case "HOCA":
        	System.out.println(secim);
        	tabloAdi = "hocalar";
        	girisEkran(secim,tabloAdi);
        	break;
        }
        JLabel bos = new JLabel();
        label.add(bos);
	}
	public void girisEkran(String secim,String tabloAdi){
		JLabel lID = new JLabel(secim+" ID:");
        lID.setFont(new Font("",Font.BOLD,20));
        lID.setBounds(300,220,600,40);
        label.add(lID);
        JTextField tID = new JTextField();
        tID.setFont(new Font("",Font.BOLD,20));
        tID.setBounds(465,220,300,40);
        label.add(tID);
        JLabel lSifre = new JLabel(secim+" ŞİFRE:");
        lSifre.setFont(new Font("",Font.BOLD,20));
        lSifre.setBounds(300,260,600,40);
        label.add(lSifre);
        JTextField tSifre = new JTextField();
        tSifre.setFont(new Font("",Font.BOLD,20));
        tSifre.setBounds(465,260,300,40);
        label.add(tSifre);
        JButton giris = new JButton(secim+" GİRİŞ");
        giris.setFont(new Font("",Font.BOLD,20));
        giris.setBounds(380,300,250,40);
        label.add(giris);
        giris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String Id = tID.getText();
                String Sifre = tSifre.getText();
                String VTid;
                String VTsifre;
                boolean giris = false;
                Jdbc jdbc = new Jdbc();
                try {
					Statement state = jdbc.connectState();
					ResultSet resultSet = state.executeQuery("SELECT * FROM "+tabloAdi);
					while(resultSet.next()){
                        VTid = resultSet.getString(tabloAdi+"_id");
                        VTsifre = resultSet.getString(tabloAdi+"_sifre");
                        if(VTid.equals(Id) && VTsifre.equals(Sifre)){
                        	if(tabloAdi.equals("yonetici")) {
                        		Yonetici hesap = new Yonetici(Id,Sifre,acilim1);
                        		 hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 hesap.setVisible(true);
                                 jdbc.veri("giris", Id, "yonetici");
                        	}
                        	else if(tabloAdi.equals("ogrenciler")) {
                        		Ogrenci hesap = new Ogrenci(Id,Sifre);
                        		 hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 hesap.setVisible(true);
                                 jdbc.veri("giris", Id, "ogrenciler");
                        	}
                        	else if(tabloAdi.equals("hocalar")) {
                        		Hocalar hesap = new Hocalar(Id,Sifre);
                        		 hesap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 hesap.setVisible(true);
                                 jdbc.veri("giris", Id, "hocalar");
                        	}
                        	System.out.println(tabloAdi+" giris yaptınız "+secim);
                            giris = true;
                        }
                    }
                    if(giris==false){
                        JOptionPane.showMessageDialog(panel,"HATALI GİRİŞ-TEKRAR DENEYİNİZ");
                    }
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
	}
}
