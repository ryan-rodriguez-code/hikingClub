package hikingProgram;

import java.util.ArrayList;
import java.util.Arrays;
//class used to hold a list of all hiking trips.
public class HikerList {
	private ArrayList<Hiker> hikers = new ArrayList<Hiker>();
//method used to ask for user input on what the user wants to manipulate/ view the list.
	public void run() {
		while(true) {
			String input = JOP.in("What do you want to do: Press 1 to add a hiker, Press 2 display the entire list, Press 3 to display total hike duration by hiker, Press 4 to display total hike duration by location, Press 5 to remove hiker, Press 6 to remove location, Click cancel to exit.");
			String[] options = {"1", "2", "3", "4", "5", "6"};
			while(JOP.waitUntil(input, options)) {
				input = JOP.in("What do you want to do: Press 1 to add a hiker, Press 2 display the entire list, Press 3 to display total hike duration by hiker, Press 4 to display total hike duration by location, Press 5 to remove hiker, Press 6 to remove location, Click cancel to exit.");
			}
			
			if(input.equals("1")) {
				this.add();
			}
			else if(input.equals("2")) {
				this.displayEntireList();
			}
			else if(input.equals("3")) {
				this.displayDurationByHiker();
			}
			else if(input.equals("4")) {
				this.displayDurationByLocation();
			}
			else if(input.equals("5")) {
				this.removeHiker();
			}
			else if(input.equals("6")) {
				this.removeLocation();
			}
		}
	}
//checks to see if the String s is a int.
	private boolean isInt(String s) {
		for(int i = 0; i < s.length(); i++) {
			if((int)s.charAt(i) < 48 || (int)s.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
//prints the names of Hikers in the list.
	private String hikersString() {
		String s = "";
		boolean canAdd = false;
		
		for(int i = 0; i < this.hikers.size(); i++) {
			for(int j = i + 1; j < this.hikers.size(); j++) {
				if(this.hikers.get(i).getHikerName().equals(this.hikers.get(j).getHikerName())) {
					canAdd = false;
					break;
				}
				canAdd = true;
			}
			if(canAdd) {
				s += this.hikers.get(i).getHikerName() + ", ";
			}
		}
		
		return s;
	}
//prints the locations of Hikers from the list.
	private String locationsString() {
		String s = "";
		boolean canAdd = false;
		
		for(int i = 0; i < this.hikers.size(); i++) {
			for(int j = i + 1; j < this.hikers.size(); j++) {
				if(this.hikers.get(i).getLocation().equals(this.hikers.get(j).getLocation())) {
					canAdd = false;
					break;
				}
				canAdd = true;
			}
			if(canAdd) {
				s += this.hikers.get(i).getLocation() + ", ";
			}
		}
		
		return s;
	}
//crates new Hiker object from user input and adds it to the list.
	private void add() {
		String hikerName = JOP.in("What is the hiker's name: ");
		while(hikerName == null) {hikerName = JOP.in("What is the hiker's name: ");}
		String location = JOP.in("What is the location's name: ");
		while(location == null) {location = JOP.in("What is the location's name: ");}
		String durationS = JOP.in("What is the duration of the hike: ");
		while(durationS == null || !this.isInt(durationS)) {durationS = JOP.in("What is the duration of the hike: ");}
		int duration = Integer.parseInt(durationS);
		
		this.hikers.add(new Hiker(hikerName, location, duration));
	}
//displays all the information on the list of Hikers.
	private void displayEntireList() {
		String[] names = new String[this.hikers.size()];
		for(int i = 0; i < this.hikers.size(); i++) {
			names[i] = this.hikers.get(i).getHikerName() + i;
		}
		Arrays.sort(names);
		
		String s = "";
		for(int j = 0; j < names.length; j++) {
			int i = Integer.parseInt("" + names[j].charAt(names[j].length() - 1));
			s += "Hiker: " + this.hikers.get(i).getHikerName() + " Location: " + this.hikers.get(i).getLocation() + " Duration: " + this.hikers.get(i).getDuration() + "\n";
		}
		JOP.msg(s);
	}
//displays the duration each Hiker has traveled.
	private void displayDurationByHiker() {
		String hikerName = JOP.in("What is the hiker's name (press enter to leave): \n" + this.hikersString());
		while(hikerName == null || this.hikersString().indexOf(hikerName) == -1) {hikerName = JOP.in("What is the hiker's name (press enter to leave): \n" + this.hikersString());}
		
		int sum = 0;
		for(int i = 0; i < this.hikers.size(); i++) {
			if(this.hikers.get(i).getHikerName().equals(hikerName)) {
				sum += this.hikers.get(i).getDuration();
			}
		}
		
		JOP.msg("Hiker: " + hikerName + " Duration: " + sum);
	}
//displayus the duration of a hike by location.
	private void displayDurationByLocation() {
		String location = JOP.in("What is the location's name (press enter to leave): \n" + this.locationsString());
		while(location == null || this.locationsString().indexOf(location) == -1) {location = JOP.in("What is the location's name (press enter to leave): \n" + this.locationsString());}
		
		int sum = 0;
		for(int i = 0; i < this.hikers.size(); i++) {
			if(this.hikers.get(i).getLocation().equals(location)) {
				sum += this.hikers.get(i).getDuration();
			}
		}
		
		JOP.msg("Location: " + location + " Duration: " + sum);
	}
//removes a specific hiker from the list.
	private void removeHiker() {
		String hikerName = JOP.in("What is the hiker's name (press enter to leave): \n" + this.hikersString());
		while(hikerName == null || this.hikersString().indexOf(hikerName) == -1) {hikerName = JOP.in("What is the hiker's name (press enter to leave): \n" + this.hikersString());}
		
		for(int i = 0; i < this.hikers.size(); i++) {
			if(hikerName.equals(this.hikers.get(i).getHikerName())) {
				this.hikers.remove(i);
			}
		}
	}
//removes a specific location from the list.
	private void removeLocation() {
		String location = JOP.in("What is the location's name (press enter to leave): \n" + this.locationsString());
		while(location == null || this.locationsString().indexOf(location) == -1) {location = JOP.in("What is the location's name (press enter to leave): \n" + this.locationsString());}
		
		for(int i = 0; i < this.hikers.size(); i++) {
			if(location.equals(this.hikers.get(i).getLocation())) {
				this.hikers.remove(i);
			}
		}
	}
}
