package no.hvl.dat100.jplab11.oppgave4;
import java.io.PrintWriter.*;
import java.io.*;
import java.io.FileNotFoundException.*;
import static javax.swing.JOptionPane.*;
import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn){
		 boolean ok = true;
		 FileWriter fw = null;
		 BufferedWriter bw = null;
		 PrintWriter pw = null;
			File fil = new File(mappe + filnavn);
		try {
			fw = new FileWriter(fil, false);
			 bw = new BufferedWriter(fw);		
			 pw = new PrintWriter(bw);
			
			 pw.println(samling.toString());
			 
		 }catch(FileNotFoundException e) {
			ok = false;
			System.out.println("Fant desverre ikke filen");
			return ok;
		}catch(IOException e) {
			ok = false;
			System.out.println("IOException");
		}finally {
			try {
				fw.flush();
				bw.flush();
				pw.flush();
			}catch(IOException e) {
				ok = false;
				System.out.println("Feilmelding!");
			}
		}
		return ok;
	}
}
