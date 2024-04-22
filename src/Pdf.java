import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class Pdf {
	ArrayList<String> ders = new ArrayList();
	ArrayList<String> not = new ArrayList();
	public Pdf() {
		
	}
	void oku(String id,JPanel panel) throws IOException {
    	Jdbc jdbc = new Jdbc();
		File file = new File("/Users/user/eclipse-workspace/Yazlab/27469951216_Transkript copy.pdf");
		PDDocument document;
		document = PDDocument.load(file);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		String[] lines = text.split("\r\n|\r|\n");
		int count=1;
	    for(String temp:lines)
	    {
	        System.out.println(count+" "+temp);
	        if(count==70) {
	            String sql1 = "update ogrenciler set ogrenciler_ort = '"+temp.substring(0,3)+"' where ogrenciler_id = '"+id+"'";
	        	jdbc.update(sql1);
	        	String var = "var";
	        	String sql2 = "update ogrenciler set ogrenciler_transkript = '"+var+"' where ogrenciler_id = '"+id+"' ";
	        	jdbc.update(sql2);
	        }
	        if(count==92 || count==95 || count==98 || count==101) {
	        	ders.add(temp.substring(7));
	        }
            if(count==94 || count==109 || count==100 || count==103) {
	        	not.add(temp.substring(14,16));
	        }
	        count++;
	    }
	    for(String t:ders) {
	    	System.out.println(t);
	    }
	    for(String t:not) {
	    	System.out.println(t);
	    }
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
    	for(int j=0;j<ders.size();j++) {
    		sayac++;
            String sql5 = "insert into dersler(dersler_id,ogrenciler_id,dersler_ad,dersler_not)"
                    + "values ('"+sayac+"','"+id+"','"+ders.get(j)+"','"+not.get(j)+"')";
        	jdbc.ekle(sql5);
    	}
    	 JOptionPane.showMessageDialog(panel,"TRANSKRİPT OKUMASI YAPILDI");
	    
	}
	

}
