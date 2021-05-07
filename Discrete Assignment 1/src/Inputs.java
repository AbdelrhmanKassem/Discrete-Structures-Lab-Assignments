import java.util.ArrayList;
import java.util.Scanner;


public class Inputs {
	static Scanner input = new Scanner(System.in);

	
	public static ArrayList<String> get_universe(){
		int dup_check=0;
		String nextline = input.nextLine();
		while(!nextline.equals("-1")){
			dup_check=0;
			for (int i=0;i<Logic.universe.size();i++) {
				if (!nextline.equals(Logic.universe.get(i)))
					dup_check++;}
			if (dup_check==Logic.universe.size())
				Logic.universe.add(nextline);
				
			nextline = input.nextLine();
		}
		

		return Logic.universe;
	}
	
	public static int get_setsNo () {
		Logic.setsNo = input.nextInt();
		return Logic.setsNo;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> [] get_sets (){
		Logic.sets = new ArrayList[Logic.setsNo];
		String nextline = "";
		for (int i=0;i<Logic.setsNo;i++) {
			Logic.sets[i] = new ArrayList<String>();
			int dup_check=0;
			
			
			while(!nextline.equals("-1")){
				dup_check=0;
				for (int j=0;j<Logic.sets[i].size();j++) {
					if (!nextline.equals(Logic.sets[i].get(j)))
						dup_check++;
				}
					if (dup_check==Logic.sets[i].size() && in_universe(nextline))
						Logic.sets[i].add(nextline);
					
				
				nextline = input.nextLine();
			}
		
		


		}
		
		return Logic.sets;
	}
	
	private static boolean in_universe (String s) {
		for (int i=0;i<Logic.universe.size();i++) {
			if (s.equals(Logic.universe.get(i)))
				return true;
		}
		return false;
	}

}
