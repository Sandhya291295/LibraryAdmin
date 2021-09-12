

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProjectLibrary {
	

	private static Connection conn;
	private static Statement stmnt;
	private static ResultSet res;
	private static PreparedStatement pstmnt;
	private static CallableStatement prepcall;

	
	public static void main(String[] args) throws SQLException, IOException {
		
		System.out.println("\n");
		System.out.printf("%100s\n","~~~~~~~~~~~~~~~~~~~~~~~~~WELCOME~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%100s\n","|~~~~~~~~~~~~~~~|                          |~~~~~~~~~~~~|");
		System.out.printf("%100s\n","|                                                       |");
		System.out.printf("%110s\n","---------------------------            TO           ---------------------------");
	   System.out.println("           __________________________                                                                    __________________________");
		
	    System.out.println("          |                                  ___ ___  ___ ___              ___  ___   __  ___                                      |");
		System.out.println("          |                                  |_  | _| |__ |  |  ___  |   | |__| | _| |__| | _| |__|                                |");
		System.out.println("          |                                  |   | |_ |__ |__|       |__ | |__| | |_ |  | | |_   |                                 |");
		System.out.println("          |__________________________--------------------------------------------------------------------__________________________|");
	System.out.println("                                         ");
		
	Date date=new Date();
	SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
	String format = sf.format(date);
	Date date1=new Date();
	SimpleDateFormat sf1=new SimpleDateFormat("hh:mm:ss");
	String format1 = sf1.format(date1);


	//System.out.println(format+" "+format1);
	System.out.println("\n");
	System.out.println("         *********************               *******************************************************                ********************");
	System.out.print("         ");
	for(int i=0;i<format.length();i++) {
		System.out.print(String.format("%2s",format.charAt(i)));
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	String s=" NATIONAL FRED LIBRARY";
	System.out.print("               ");
	for(int i=0;i<s.length();i++) {
		System.out.print(String.format("%2s",s.charAt(i)));		
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.print("                              ");
	for(int i=0;i<format1.length();i++) {
		System.out.print(String.format("%2s",format1.charAt(i)));
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
//	System.out.println("\n");
	System.out.print("\n");
	System.out.println("         *********************               *******************************************************                ********************");

       Scanner sc=new Scanner(System.in);

		sc=new Scanner(System.in);
		System.out.println("    ");
		System.out.print("                    ");
		
		name();
		
		String url="jdbc:mysql://Localhost:3306/octjdbc";
		String user="root";
		String password="root";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			choice();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn,pstmnt,res,stmnt);
		}
		
		}
	private static void name() {
        Scanner sc=new Scanner(System.in);
		System.out.println("\n");
		System.out.printf("%55s","PLEASE ENTER YOUR NAME TO PROCEED ====>");
		String name=sc.next();
		System.out.println("\n");
		if(name.length()>=3 && name.length()<=15) {
			System.out.printf("%55s %10s",name.toUpperCase()," ,  LOGIN ACCESSED, CARRY ON!!");
		}
		else {
			System.out.printf("%55s","Name must hold 3-15 characters");
			name();
		}
	}
      
	public static void choice() {
		Scanner sc=new Scanner(System.in);
    	System.out.println("\n");
   		System.out.println("                                   => 1. Display Book Details");
   		System.out.println("                                   => 2. Add new book from User");//preparestatement
   		System.out.println("                                   => 3. Add multiple books User");//use batch file from user
   		System.out.println("                                   => 4. Update Book Details by price/Author name/Book Name");//from user
   		System.out.println("                                   => 5. Delete all Duplicate books and retain one with maximum price ");//user
   		System.out.println("                                   => 6. Increment Price of particular category by 30%");
   		System.out.println("                                   => 7. Decrement Price of particular category by 30%");
   		System.out.println("                                   => 8. If book price is >=200 and <=300 give discount 10%");
   		System.out.println("                                   => 9. If book price is >=300 and <=500 give discount 15%");
   		System.out.println("\n");
		System.out.println("select your choice to proceed");
		int choice=sc.nextInt();
		try {
		switch(choice) {
		case 1:display();
		break;
		case 2:newbook();
		break;
		case 3:multibook();
		break;
		case 4:updetails();
		break;
		case 5:duplicate();
		break;
		case 6:inc();
		break;
		case 7:dec();
		break;
		case 8:disten();
		break;
		case 9:disfif();
		break;
		default:System.out.println("Enter the correct choice");
		choice();
		}
		}catch(Exception e) {
			System.out.println("Enter the correct choice");
			choice();
		}
	}
	
	private static void display() {
    	Scanner sc=new Scanner(System.in);
   String sql="select * from library";
   try {
	stmnt = conn.createStatement();
	res = stmnt.executeQuery(sql);
	System.out.println("\n");
           System.out.println("                         __________________________________________________________________________________________________________________");
	       System.out.println(String.format("%25s %-5s| %-50s| %-20s| %-20s| %-10s|","|","Sl.no","Book_Name","Category","Author_Name","Price"));
	       System.out.println("                        |__________________________________________________________________________________________________________________|");
	   
	 
	 while(res.next()==true) {
		   System.out.println(String.format("%25s %-5s| %-50s| %-20s| %-20s| %-10s|","|",res.getInt("id"),res.getString("Book_name"),res.getString("Category"),
				   res.getString("Author_name"),res.getInt("Price")));
	   }
	       System.out.println("                        |__________________________________________________________________________________________________________________|");
      
	  System.out.println("Do you want to select other choices"+"\n"+"1.Choices"+"\n"+"2.LogOff"+"\n"+"        Select your choice");     
      int choice=sc.nextInt();
      switch(choice) {
      case 1:choice();
      break;
      case 2:System.out.println(".........................................LOGGING OFF............................................");
      break;
      default:System.out.println("Try again!! with correct choice");
      
      
      }
   
   
   } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
	private static void newbook() {
	
		
		try{
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Bookname?");
		String bookn=sc.nextLine();
		
		System.out.println("Enter the Category?");
		String cat=sc.nextLine();
		
		System.out.println("Enter the Authorname?");
		String aname=sc.nextLine();
		
		System.out.println("Enter the Price?");
		int pri=sc.nextInt();
		
	String sql="insert into `library` (`book_name`,`category`,`author_name`,`price`) values(?,?,?,?)";
		
			pstmnt = conn.prepareStatement(sql);
			pstmnt.setString(1, bookn);
			pstmnt.setString(2, cat);
			pstmnt.setString(3, aname);
			pstmnt.setInt(4, pri);
			int i = pstmnt.executeUpdate();
			System.out.println("\n");
	        System.out.println(i+" book information updated successfully");
	        display();
		} catch (SQLException e) {
			System.out.println("Enter the information correctly");
			newbook();
		}
		
	}
	
	private static void multibook() {
		
		try{
			Scanner sc=new Scanner(System.in);
			System.out.println("How many book details you want to enter");
			int no=sc.nextInt();
//			System.out.println("Enter the book_name,category,author_name,price in CSV format");
//		     String s[]=null;
		     while(no!=0) {
		    	 Scanner sc1=new Scanner(System.in);
		    	 System.out.println("Enter the book_name?");
		    	 String bookn=sc1.nextLine();
		    	 System.out.println("Enter the category?");
		    	 String cat=sc1.nextLine();
		    	 System.out.println("Enter the author_name?");
		    	 String aname=sc1.nextLine();
		    	 System.out.println("Enter the price?");
		    	 int pri=sc1.nextInt();
		    	 String sql="insert into `library` (`book_name`,`category`,`author_name`,`price`) values(?,?,?,?)";
					pstmnt = conn.prepareStatement(sql);
					pstmnt.setString(1, bookn);
					pstmnt.setString(2, cat);
					pstmnt.setString(3, aname);
					pstmnt.setInt(4, pri);
					pstmnt.addBatch(sql);
					 int[] arr = pstmnt.executeBatch();
					System.out.println(arr+" rows updated successfully");
					   no--;
		 }
		     
		 
		    
			 
			
		     display();
//			for(int k=1; k<=no; k++) {
//				Scanner sc1=new Scanner(System.in);
//				System.out.println("Enter "+k+" Details");
//				String details=sc1.nextLine();
//				s=details.split(",");
//				String bookn=s[0];
//				String cat=s[1];
//				String aname=s[2];
//				int pri=Integer.parseInt(s[3]);
//				String sql="insert into `library` (`book_name`,`category`,`author_name`,`price`) values(?,?,?,?)";
//				pstmnt = conn.prepareStatement(sql);
//				pstmnt.setString(1, bookn);
//				pstmnt.setString(2, cat);
//				pstmnt.setString(3, aname);
//				pstmnt.setInt(4, pri);
//				pstmnt.addBatch();
//				 int[] arr = pstmnt.executeBatch();
//				   for(int x:arr) {
//					  System.out.println(x+" book information updated successfully");
//					  x++;
//				   }
//		       }
						
		}catch(Exception e) {
				System.out.println("Enter the correct details");
				multibook();
			}
	}

	private static void updetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to Update details of Price using "+"\n"+"1.Author Name   "+"OR"+"   2.Book Name"+"\n"+
	                                                         "Select your choice");
		try {
			int choice=sc.nextInt();
			
			
			if(choice==1) {
				Scanner sc1=new Scanner(System.in);
				
				 System.out.println("Enter the Author_name ");
				 String an=sc1.nextLine();
				 
				System.out.println("Enter the price to be updated");
				int pr=sc1.nextInt();
			  
				String sql="update `library` set `price`=`price`+? where `author_name`=? ";
			    pstmnt = conn.prepareStatement(sql);
				pstmnt.setInt(1, pr);
				pstmnt.setString(2, an);
				int i1 = pstmnt.executeUpdate();
			    System.out.println("\n");
				 System.out.println(i1+" book information updated successfully");
				
		        }
		
		     else if(choice==2) {
		    	 Scanner sc1=new Scanner(System.in);
		    	 System.out.println("Enter the Book_name ");
				 String bn=sc1.nextLine();
			     System.out.println("Enter the price to be updated");
			     int pr=sc1.nextInt();
			 
		        String sql="update `library` set `price`=`price`+? where `book_name`=? ";
				 pstmnt = conn.prepareStatement(sql);
				    pstmnt.setInt(1, pr);
					pstmnt.setString(2, bn);
					int i = pstmnt.executeUpdate();
					System.out.println("\n");
			        System.out.println(i+" book information updated successfully");
		     }
		      else {
			System.out.println("Enter the correct choice");
			updetails();
		}
			}catch(Exception e) {
			System.out.println("Enter correct choice to update");
			updetails();
		}
	}
	
	private static void duplicate() {

		try {
			stmnt = conn.createStatement();
			String sql="delete l1 from `library` l1,`library` l2 where l1.`book_name`=l2.`book_name` "
					+ "AND l1.`price`<l2.`price`";
			stmnt.executeUpdate(sql);
			display();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void inc() {
		
		 try {
			 Scanner sc1=new Scanner(System.in);
				
				 prepcall = conn.prepareCall("{call.increment(?)}");
				 System.out.println("Enter the category for which price has to be increased?");
					String cat=sc1.nextLine();
					prepcall.setString(1, cat);
					prepcall.execute();
					display();
//			 stmnt = conn.createStatement();
//			 res = stmnt.executeQuery("select `category` from `library`");
//			  prepcall = conn.prepareCall("{call.increment(?)}");
//			 res.next();
//			 String s=res.getString("category");
//				 if(cat.equalsIgnoreCase(s)) {
//					  System.out.println("sdfjhk,fh,h");
//					
//						prepcall.setString(1, cat);
//					    prepcall.execute();
//					    prepcall.getResultSet();
//					    display();
//				  }

			 
		} catch (SQLException e) {
	      System.out.println("Enter the correct info");
	      inc();
		}
		}
	
	private static void dec() {
		
		try {
			 Scanner sc1=new Scanner(System.in);
				
			 prepcall = conn.prepareCall("{call.decrement(?)}");
			 System.out.println("Enter the category for which price has to be decreased?");
				String cat=sc1.nextLine();
				prepcall.setString(1, cat);
				prepcall.execute();
				display();
//			Scanner sc1=new Scanner(System.in);
//			System.out.println("Enter the category for which price has to be decreased?");
//			String cat=sc1.nextLine();
//			 stmnt = conn.createStatement();
//			 res = stmnt.executeQuery("select `category` from `library`");
//		  while(res.next()) {
//			  String c=res.getString("category");
//			  if(cat.equals(c)) {
//			 prepcall = conn.prepareCall("{call.decrement(?)}");
//		     prepcall.setString(1,cat);
//			prepcall.execute();
//			res = prepcall.getResultSet();
//			display();
			  
		} catch (SQLException e) {
	      System.out.println("Enter the correct info");
	      dec();
		}
	}
	
	private static void disten() {
             
		try {
			  ArrayList a= new ArrayList();
			stmnt = conn.createStatement();
			 res=stmnt.executeQuery("select * from `library` where `price` between 200 and 300");
             res.next();
     		 String sql="update `library` set `price`=`price`-(`price`*(0.10)) where `price` between 200 and 300";
				  int i = stmnt.executeUpdate(sql);
				  System.out.println(i+" modifications done successfully!!!");
					display();
			
			
		} catch (SQLException e) {
			System.out.println("Enter correct info");
			disten();
		}
		
	}
	
	 private static void disfif() {
		
      try {
    
		stmnt = conn.createStatement();
		res=stmnt.executeQuery("select `price` from `library` where `price` between 300 and 500");
		res.next();
	
          String sql1="update `library` set `price`=`price`-(`price`*(0.15)) where `price` between 300 and 500";
			int i1 = stmnt.executeUpdate(sql1);
			System.out.println(i1+" modifications done successfully!!!");
			display();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 }

	private static void close(Connection conn, PreparedStatement pstmnt, ResultSet res,Statement stmnt) throws SQLException, IOException {
	    if(conn!=null) {
	    	conn.close();
	    }
	    if(pstmnt!=null) {
	    	pstmnt.close();
	    }
	    if(stmnt!=null) {
	    	stmnt.close();
	    }
	    if(res!=null) {
	    	res.close();
	    }
	 
	}



	

}
