import java.lang.*;
import java.util.*;
class student{
public int id;
protected String name;
public void getdata(){
	Scanner s=new Scanner(System.in);
	System.out.println("\nENTER NAME OF A STUDENT : \t");
	name=s.nextLine();
	System.out.println("\nENTER ENROLLMENT NUMBER : \t");
	id=s.nextInt();
}

int s_id(){return id;}
}
class checkDate extends student
{ 

	static int MAX_VALID_YR = 9999; 
	static int MIN_VALID_YR = 1800; 

	// Returns true if 
	// given year is valid. 
	 boolean isLeap(int year) 
	{ 
		return (((year % 4 == 0) && 
				(year % 100 != 0)) || 
				(year % 400 == 0)); 
	} 

	// Returns true if given 
	// year is valid or not. 
	boolean isValidDate(int d,int m,int y) 
	{ 
		// If year, month and day 
		// are not in given range 
		if (y > MAX_VALID_YR || 
			y < MIN_VALID_YR) 
			return false; 
		if (m < 1 || m > 12) 
			return false; 
		if (d < 1 || d > 31) 
			return false; 

		// Handle February month 
		// with leap year 
		if (m == 2) 
		{ 
			if (isLeap(y)) 
				return (d <= 29); 
			else
				return (d <= 28); 
		} 

		// Months of April, June, 
		// Sept and Nov must have 
		// number of days less than 
		// or equal to 30. 
		if (m == 4 || m == 6 || 
			m == 9 || m == 11) 
			return (d <= 30); 

		return true; 
	} 
} 

class attend extends checkDate{

private int n;
private int count;
public float per;
public int month,day,year;
attend()
{
n=0;
count=0;
per=0;
getdata();
getattendance();
}
void display(){
	System.out.println("STUDENT NAME :\t"+name);
	System.out.println("STUDENT ID :\t"+s_id());
	System.out.println("DATE OF ATTENDANCE\t"+month+"/"+day+"/"+year);
	System.out.println("ATTENDANCE PERCENTAGE\t"+per+"%");

}

public void getattendance(){
Scanner s=new Scanner(System.in);
int valid,k,a;

System.out.println("-----ENTER A DATE :----- \nENTER MONTH : \t");
month=s.nextInt();
System.out.println("\nENTER DAY : \t");
day=s.nextInt();
System.out.println("\n ENTER YEAR : \t");
year=s.nextInt();
System.out.println("ENTERED DATE : (MM/DD//YYYY)"+month+"/"+day+"/"+year);
if(isValidDate(day,month,year)){                                                             //1st if loop
System.out.println("\n\t\tENTERED DATE IS VALID...!! NOW ENTER ATTENDANCE DETAILS");
System.out.println("\nENTER NUMBER OF PERIOD IN A DAY (MAX 7)\t"); 
n=s.nextInt();
if(n>7)
{                                                                                             //2nd if loop
System.out.println("\nsorry! maximum limit is 7\n");
}                                                                                             //end of 2nd if loop
else
{                                                                                              //1st else loop
for(k=1;k<n+1;k++)
{                                                                                               //for loop
System.out.print("\nENTER '1' FOR PRESENT OR '0' FOR ABSENT\n"+k+"  PERIOD"+"\t");
a=s.nextInt();
if(a==1)
{                                                                                                   //3rd if loop
count++;
System.out.print("\nUPDATED AS A PRESENT...");
}                                                                                                    //end of 3rd if loop
else if(a==0)
{                                                                                                    //1st else if loop
System.out.print("\n UPDATED AS ABSENT...");
}                                                                                                       //end of 1st else if loop
else
{                                                                                                         //2nd else loop                                                                                                  
System.out.print("\nInvalid input\n");
break;
}                                                                                                             //end of 2nd else loop
}                                                                                                            //end of for loop
per=cal_pr();  //calculates percentage of attendance
}                                                                                                          //end of 1st if loop
}                                                                                                              //end of 1st else loop
else
{                                                                                                        //start
System.out.println("\t\t ### ENTERED DATE IS NOT VALID ###");                                                                                                     
}                                                                                                         //end
//menu();
}                                                                                                           //end of getattendance method
public void list(){											//displays all records
display();
}
public float cal_pr()
{
per=(float)count/n*100;
return per;
}
void status()  //shows whether attendance is lower or higher than 75%
      {
	Scanner s=new Scanner(System.in);
	System.out.println("\nStudent id :"+s_id());
	  if(per>=75)  //shows status of attendance
	  {
		System.out.print("Atendance percentage is greater than 75%\n");
	  }
	  else
	  {
		System.out.print("DETAINED...!! Attendance percentage is lower than 75%\n");
	  }

}
}                                                                 //end of class
class t1{
static void title()  //prints title of project
{
	System.out.print("\n\n\n\n");
	System.out.print("\t\t    ------------------------------\n");
	System.out.print("\t\t    |ATTENDANCE MANAGEMENT SYSTEM|\n");
	System.out.print("\t\t    ------------------------------\n");
}
static void loginpage()  //ask user for password and username
{
  Scanner s=new Scanner(System.in);
  String username;
  String password;
  String u1="admin";
  String p1="pass@123";
  int try1 = 0;
  int true1 = 1;
  do
  {
    System.out.print("\n");
    System.out.print("\t\t");
    System.out.print("Username: \t");
    username=s.nextLine();
    System.out.print("\t\t");
    System.out.print("\n");
    System.out.print("\t\t");
    System.out.print("Password: \t");
    password=s.nextLine();
    if((username.equals(u1)) && (password.equals(p1)))
      {
	System.out.print("\n");
	System.out.print("\t\t");
	System.out.print("You are given accessed to the system!\n\n");
	menu();  /*allows user to choose operation*/
	true1 =0;
      }
      else  /*allows user to enter invalid username and password for 4 times only and exits on 5 times */
      {
	try1 = try1+1;
	System.out.print("\n");
	System.out.print("\t\t");
	System.out.print("No. of attempts remain: "+(3-try1));
	if(try1>=3)
	{
	  System.out.print("\n");
	  System.out.print("\t\t");
	  System.out.print("No permission to enter the system!") ;
	  System.exit(0);
      }
  } 
 }while(true1==1);

}
static void menu()  //ask user for their choice of operation
{
Scanner s=new Scanner(System.in);
int j;
System.out.print("ENTER TOTAL NUMBER OF STRENGTH OF CLASS\t");
int total=s.nextInt();
attend[] a=new attend[total];

  System.out.print("\n\n");
  System.out.print("\t\t");
	for(j=0;j<total;j++){
	a[j]=new attend();
}

 int input,choice;
do{
  
  System.out.print("\n\n");
  System.out.print("\t\t");
  System.out.print(" 1. List Records\n\n");
  System.out.print("\t\t");
  System.out.print(" 2. Status of attendance\n\n");
  System.out.print("\t\t");
  System.out.print(" 3. Exit\n\n");
  System.out.print("Choose options:[1/2/3]:");
  input=s.nextInt();
  switch(input)
  {
    case 1:
for(j=0;j<total;j++){
      a[j].list();
	}
 break;
    case 2:
for(j=0;j<total;j++){
      a[j].status();
	}
    break;
    case 3: 
    System.exit(0);
    break;
    default:
    {
      System.out.print(" Invalid input!");
      System.out.print("\n");
    }
  }
System.out.print("\nEnter 0 to regain the menu\t");
choice=s.nextInt();
}while(choice==0);
  }
public static void main(String args[]){
title();  //displays title
loginpage();  //shows loginpage
}
}
