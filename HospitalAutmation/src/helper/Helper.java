package helper;

import javax.swing.JOptionPane;

public class Helper {
	public static void showingMsg(String str) {
		String msg;
		 
		switch(str) {
		case "fill":
			msg= "Xahiş olunur verilənlərin hamsını doldurasınız.";
		    break;
		 default:
		    	msg = str;
		    	
		}
		
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

}
