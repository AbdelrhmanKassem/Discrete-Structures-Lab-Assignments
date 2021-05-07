import java.util.ArrayList;


public class Logic {
	public static int setsNo;
	public static ArrayList<String> universe = new ArrayList<String>();
	public static ArrayList<String> [] sets;
	
	public static ArrayList<String> get_union(ArrayList<String> set1, ArrayList<String> set2){
		ArrayList<String> union = new ArrayList<String>();
		for (int i=0;i<set1.size();i++) {
			union.add(set1.get(i));
		}
		boolean found = false;
		for (int i=0;i<set2.size();i++) {
			found = false;
			for (int j=0;j<set1.size();j++) {
				if (set2.get(i).equals(set1.get(j))) {
					found = true;
				}
				
			}
			if (!found)
				union.add(set2.get(i));
		}

		return union;
	}
	
	
	
	public static ArrayList<String> get_intersection(ArrayList<String> set1, ArrayList<String>set2){
		ArrayList<String> intersection = new ArrayList<String>();
		for (int i=0;i<set1.size();i++) {
			for (int j=0;j<set2.size();j++) {
				if (set1.get(i).equals(set2.get(j))) {
					intersection.add(set1.get(i));
				}
			}
		}

		return intersection;
	}
	
	
	
	public static ArrayList<String> get_complement(ArrayList<String> set){
		ArrayList<String> complement = new ArrayList<String>();
		 boolean found;
     for(int i=0;i<universe.size();i++) {
    	found=false;
    	 for (int j=0;j<set.size();j++) {
    		 if (universe.get(i).equals(set.get(j))) {
					found=true;
					break;}
    	 }
    	 if(!found) {complement.add(universe.get(i));}
     } 
		return complement;
   }
	
}
