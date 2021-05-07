import java.util.ArrayList;
import java.util.Scanner;





public class Main {
	   public  static void main_menu() {
			 
			
			System.out.println("Enter the elemnts of universal set.\n"
					+ "\"-1\" is used as end of input.\r\n" + 
					"");
			Inputs.get_universe();
			System.out.println("Enter the number of sets required");
			Inputs.get_setsNo();
			System.out.println("Enter the elemnts of each set seperated by \"-1\"");
			Inputs.get_sets();
			main_oper();
			}
	   
		 public  static void main_oper() {
			 Scanner input = new Scanner(System.in);
			String menu="====================================================================\r\n"
					+"chose one of these operations:- \r\n"
					+ "1_ Union of two sets \r\n"
					+ "2_ Intersection of two sets \r\n"
					+ "3_ Complement of a set\r\n"
					+ "4_ Back to start\r\n";
			System.out.println(menu);
			int num=input.nextInt();
			do {
				if(num!=1&&num!=2&&num!=3&&num!=4) { System.out.println("Invalid number pleas enter anther one"	);
				num=input.nextInt();}
				else {break;}
			} while (true);
			
			if(num==1){
				System.out.println("enter the number of two subsets");
			
				int set1=input.nextInt();
				int set2=input.nextInt();
			if(set1<0||set1>Logic.setsNo||set2<0||set2>Logic.setsNo) {
				System.out.println("invalid subset");
				 main_oper();
			}
				ArrayList<String> u = new ArrayList<String>();
				u= Logic.get_union(Logic.sets[set1-1], Logic.sets[set2-1]);
				System.out.println(u);
				  main_oper();
			}
			if(num==2 ){
			    System.out.println("enter the number of two subsets");
			    int set1=input.nextInt();
			    int set2=input.nextInt();
				if(set1<0||set1>Logic.setsNo||set2<0||set2>Logic.setsNo) {
					System.out.println("invalid subset");
					 main_oper();
				}
			    ArrayList<String> n = new ArrayList<String>();
			    n= Logic.get_intersection(Logic.sets[set1-1], Logic.sets[set2-1]);
			    System.out.println(n);
			    main_oper();}
			if(num==3){
				System.out.println("enter the number of subset");
			    int set1=input.nextInt();
				if(set1<0||set1>Logic.setsNo) {
					System.out.println("invalid subset");
					 main_oper();
				}
				ArrayList<String> com = new ArrayList<String>();
			    com=Logic.get_complement(Logic.sets[set1-1]);
			    System.out.println(com);
			    main_oper();}
			if(num==4) {main_menu();}
	 
	        }
			
		
	   
	public static void main(String[] args) {
		main_menu();
 }
}