package hikingProgram;

import javax.swing.JOptionPane;
//class used to handle JOptionPane elements more easier.
public class JOP {
//used to show text to the user. displays the String parameter.
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
//returns the user input to the question given in the String parameter.
	public static String in(String msg){
		return JOptionPane.showInputDialog(msg);
	}
//returns false if the input is in the String[] options true otherwise.
//if the input is null then the program ends.
//used to run infinite loop until user enters correct information into input.
	public static boolean waitUntil(String input, String[] options) {
		if(input == null) {
			System.exit(0);
		}
		
		for(int i = 0; i < options.length; i++) {
			if(input.equals(options[i])) {
				return false;
			}
		}
		return true;
	}
}
