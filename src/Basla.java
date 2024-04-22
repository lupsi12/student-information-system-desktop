import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Basla extends JFrame {
	public Basla() {
		JPanel panel = new JPanel();
		add(panel);
		setSize(800, 680);
		setTitle("OBS SİSTEME BAŞLA");
		JLabel label = new JLabel();
		label.setBackground(Color.black);
		label.setIcon(new ImageIcon(new ImageIcon("/Users/user/eclipse-workspace/Yazlab/img/kocaeli-universitesi4428.jpg").getImage().getScaledInstance(866, 650, Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 1000, 800);
		getContentPane().add(label);
		JButton yonetici = new JButton("YÖNETİCİ");
		yonetici.setFont(new Font("", Font.BOLD, 25));
		yonetici.setBounds(333, 220, 200, 40);
		label.add(yonetici);
		JButton ogrenci = new JButton("ÖĞRENCİ");
		ogrenci.setFont(new Font("", Font.BOLD, 25));
		ogrenci.setBounds(333, 260, 200, 40);
		label.add(ogrenci);
		JButton hoca = new JButton("HOCA");
		hoca.setFont(new Font("", Font.BOLD, 25));
		hoca.setBounds(333, 300, 200, 40);
		label.add(hoca);
		Jdbc jdbc = new Jdbc();
        boolean ne = jdbc.dagitimYap();
        System.out.println(ne);
        if(ne==true) {
        	ogrenci.setVisible(false);
        	hoca.setVisible(false);
        }
		yonetici.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						String secim = "YÖNETİCİ";
						Giris giris;
						try {
							giris = new Giris(secim,ne);
							giris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // * işaretine basıldığına programın arka planda durmasını sağlar
							giris.setVisible(true); // görünürlüğünü true yapar framenin
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}yonetici.setEnabled(false);
					}
				});
			}
		});
		ogrenci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						String secim = "ÖĞRENCİ";
						Giris giris;
						try {
							giris = new Giris(secim,ne);
							giris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // * işaretine basıldığına programın arka planda durmasını sağlar
						giris.setVisible(true); // görünürlüğünü true yapar framenin
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						ogrenci.setEnabled(false);
					}
				});
			}
		});
		hoca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						String secim = "HOCA";
						Giris giris;
						try {
							giris = new Giris(secim,ne);
							giris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // * işaretine basıldığına programın arka planda durmasını sağlar
							giris.setVisible(true); // görünürlüğünü true yapar framenin
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						hoca.setEnabled(false);
					}
				});
			}
		});
		JLabel bos = new JLabel();
		label.add(bos);
	}
}