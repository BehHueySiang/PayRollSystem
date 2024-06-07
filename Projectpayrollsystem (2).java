//Project Human Resource Payroll System [Beh Huey Siang (285626) and Vincent Voon Bu Khin (285467)]
import java.util.*;
public class Projectpayrollsystem{
static Scanner scan = new Scanner (System.in);
public static void main(String [] args){

      //Declaration and initialization
      int choice=0, count = 0 , id =0, position = 0, e = 0, p= 0, i;
      double hourwork=0,late = 0, wage=0, overtime=0, commission=0, allowance=0, bonus=0, totalsale=0, payrate=0, gross=0;
      double less = 0, deduction = 0, epf = 0,socso = 0, eis = 0,deductleave=0, netpay = 0;
      char ask = 'Y';
      String name = "Beh", ic= "010414075491", email= "try 123@gmail.com",phone = "01112345678" ; 
      
      // array declaration and initialization
      double validrate [] = {36.06,31.25,24.04,12.02,7.212,5.77};
      double [][] payroll = new double [100][15];
      
             
        //Process, Selection and Calling method
        companyhead(); 
        do{
        int service= 0;
              
               System.out.println("\n**************************************************************");
               System.out.printf("%25s%30s", "1. Employee View  ", "2. Employer View and Edit ");
               System.out.println("\n**************************************************************"); 
               System.out.print("\nPlease select page : ");
               service= scan.nextInt();
                    
              if (service== 1){
                    System.out.printf("\n%30s", "Employee View and Edit\n__________________________\n\n");
                   
                    empview(payroll, name,count, ic,email,phone,choice, p, e, id, hourwork,late, wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay);
                  }
              else if(service==2){
                               System.out.printf("\n%30s", "  Employer View and Edit\n__________________________\n");
                               do {
                                 menu();
                                 System.out.print("Please select the info :"); 
                                 choice=scan.nextInt();
                                 if (choice==0){
                                  System.out.println("Thank you and Bye."); 
                                 break;
                                    }
                                 else{
                                 count = processChoice(  payroll,count,choice,p,e, id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis, deductleave, netpay);// calling processChoice method
                                                      
                                    }
                                 } while ( choice !=0);}
               else {
                   System.out.println("ERROR! Your selection not match! Please try again!");}
                           System.out.print("\n\n\n\n\nDo you want to continue? Y/N or y/n: ");
                            ask = scan.next().charAt(0);
                           
                        }while(ask == 'Y' || ask == 'y');
       System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|| WORK SMART AND WORK HARD ||\n\t\t\t\t\t\t\t\t\t\t\t\t VB COLLECTION SDN BHD CAN SUCCESS YOUR DREAM\n\n=========================================Thank You For Using This Payroll System=========================================");
         
      }//end main
      
//Method
public static void menu(){
         System.out.println("\n::::::::::: MENU ::::::::::::\n"
                   +"1. Add Employee Payroll Info\n"
                   +"2. Display Employee Payroll Info\n"
                   +"3. Remove Employee Payroll Info\n"
                   +"4. Edit Employee Payroll Info\n"
                   +"5. Search And Print Employee Personal Payroll Info\n"
                   +"0. EXIT");
            }//End menu
      public static int processChoice(double [][] payroll,int count, int choice, int p, int e,int id, double hourwork,double late,double wage, 
                                      double overtime,double commission,double allowance,double bonus,double totalsale,double payrate,double gross,
                                      int position, double less, double deduction, double epf, double socso, double eis,double deductleave,double netpay){
       switch(choice){
        case 1: count = addItem( payroll,count,choice,p,e,id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay); break;//calling additem method
        case 2: display( payroll, count,p, e, id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay);break;//calling display method
        case 3: count = removeitem( payroll, count,choice, p, e, id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay);break;//calling removeitem method
        case 4: edititem( payroll, count,choice, p, e, id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay);break;//calling edititem method
        case 5: search(payroll, count,choice, p, e, id, hourwork,late,wage, overtime,commission,allowance,bonus,totalsale, payrate, gross,position,less, deduction, epf, socso, eis,deductleave,netpay);break;//calling search method
        default: System.out.println("Sorry your choice is not in the list. Please choose again.");
        }//switch
        return count;
      }//EndprocessChoice

      public static int addItem(double [][] payroll, int count,int choice, int p, int e,int id, double hourwork,double late, double wage, double overtime,
                                double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position,double less, 
                                double deduction, double epf, double socso, double eis,double deductleave,double netpay ){
             
            // declare and initialize
            int i ;
            int basic [] = {7500, 6500,5000, 2500, 1500,1200};
            double validrate [] = {36.06,31.25,24.04,12.02,7.212,5.77};
            
            //Input Employee payroll data
            System.out.print("Enter Employee ID Number : ");
            id = scan.nextInt();
            
            System.out.print(" 1. Manager \n 2. Assistant Manager\n 3. Senior Executive \n 4. Supervisor\n 5. Senior Promoter \n 6. Promoter \n Enter Employee Position : ");
            position = scan.nextInt(); 
                    
            if (position == 1 || position == 2 || position == 3 || position == 4 ||position == 5 ||position == 6){
            System.out.print("Please enter 0 if no overtime/(LateIn/EarlyOut)/Total Sale/Leave Days!!!\nEnter the Overtime  time in minute (monthly) : ");
            hourwork = scan.nextDouble();
           
            System.out.print("Enter LateIn/EarlyOut in minute  (monthly): ");
            late = scan.nextInt();
              
            System.out.print("Enter Employee Total Sale (monthly): RM ");
            totalsale = scan.nextDouble();
            
            System.out.print("Enter leave days : ");
            int leave = scan.nextInt();
            
            //Selection        
            if (position == 1 ){
                wage = basic[0];
                payrate = validrate[0];
                allowance= 200; }
           else if (position == 2){
                wage = basic[1];
                payrate = validrate[1];
                allowance= 150; }
           else if (position == 3){
                wage = basic[2];
                payrate = validrate[2];
                allowance= 100; }
           else if (position == 4){
                wage = basic[3];
                payrate = validrate[3];
                allowance = 50; }
            else if (position == 5){
                wage = basic[4];
                payrate = validrate[4]; }
             else if (position == 6){
                wage = basic[5];
                payrate = validrate[5]; }  
                    
                    if (totalsale <= 5000 && position != 1&& position != 2){
                         commission = totalsale*0.01;
                         bonus = 0;}
                    else if (totalsale > 5000 && totalsale < 7000 && position != 1&& position != 2){
                         commission = totalsale*0.02;
                         bonus = 0; }
                     else if (totalsale >= 7000&& totalsale <10000 && position != 1&& position != 2){
                         commission = totalsale*0.03;
                         bonus = totalsale*0.03;}
                     else if (totalsale >= 10000 && position != 1&& position != 2){
                         commission = totalsale*0.05;
                         bonus = totalsale*0.03;}
                     else if(totalsale <= 1000){
                          commission = 0;
                          bonus = 0; }
                          
                      //Calculation of Employee payroll     
                      overtime = ((payrate*1.5)*(hourwork/60));
                      deduction = ((payrate*1.2)*(late/60));
                      deductleave = (leave*(payrate*8)) ;   
                      epf = wage * 0.09;
                      socso = wage * 0.03;
                      eis = wage * 0.002;  
                      gross = wage + overtime + commission + allowance + bonus;
                      netpay = gross - epf- deduction- socso- eis - deductleave;
                      
                // Add employee payroll data into payroll array    
                e =0 ;
               if (count<=payroll.length){
                  if (count>=1){
                  e = count;  
                  for ( p=0; p<payroll[e].length; p++) {
                              payroll[e][0] = id ;
                              payroll[e][1] = totalsale;
                              payroll[e][2] = position;
                              payroll[e][3] = wage;
                              payroll[e][4] = overtime;
                              payroll[e][5] = commission;
                              payroll[e][6] = bonus;
                              payroll[e][7] = allowance;
                              payroll[e][8] = gross;
                              payroll[e][9]= deduction;
                              payroll[e][10]= epf;
                              payroll[e][11]= socso;
                              payroll[e][12]= eis;
                              payroll[e][13]= deductleave;
                              payroll[e][14]= netpay;}}
                        
                   else{
                     for ( p=0; p<payroll[e].length; p++) {
                              payroll[e][0] = id ;
                              payroll[e][1] = totalsale;
                              payroll[e][2] = position;
                              payroll[e][3] = wage;
                              payroll[e][4] = overtime;
                              payroll[e][5] = commission;
                              payroll[e][6] = bonus;
                              payroll[e][7] = allowance;
                              payroll[e][8] = gross;
                              payroll[e][9]= deduction;
                              payroll[e][10]= epf;
                              payroll[e][11]= socso;
                              payroll[e][12]= eis;
                              payroll[e][13]= deductleave;
                              payroll[e][14]= netpay;}}
                        count++;
                        }}
            else{
               System.out.println("ERROR! Sorry the position not match! Please try again!");}
                       
                   return count;
                  
        }// End addItem
  
       public static void display(double [][] payroll, int count, int p, int e,int id, double hourwork,double late, double wage, double overtime,
                                  double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position,double less,
                                  double deduction, double epf, double socso, double eis,double deductleave, double netpay){
          
          if (count == 0 )
                  System.out.println("ERROR!! Payroll list is empty! Please try again!");
          else
               head();
         
                for (e = 0; e <count;e++ ){
                    for (p = 0 ; p < payroll[e].length;p++)
                      System.out.printf("%-12.0f", payroll[e][p]);
                      System.out.println();}
   
      }//End display

       public static int removeitem(double [][] payroll, int count,int choice, int p, int e,int id, double hourwork,double late, double wage, double overtime,
                                    double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position,double less, 
                                    double deduction, double epf, double socso, double eis,double deductleave,double netpay) {
             // declaration and initialize
             int i=0,j=0;
             int bil = count;
             boolean delete = false;
             
             //searching data
             if(bil == 0)
                  System.out.println("Sorry! The Payroll list is empty");
             else{
                  System.out.print("Enter Employee ID to delete");
                  id = scan.nextInt();
                  for (e=0; e<bil;e++)
                      for(p=0; p<payroll[e].length; p++)
                        if (payroll[e][0]==id){
                           for(i=e; i< count-1;i++)//delete data
                           for (j=p; j<payroll[i].length; j++)
                           payroll[i][j]=payroll[i+1][j];// Replace row
                           --bil;
                           delete = true;
                           break;
                           }
                         }
                if(delete=false)
                System.out.println("ERROR!  EMPLOYEE ID NOT FOUND \n PLEASE TRY AGAIN");
                return bil;
                
          }//end delete
    
       public static void edititem(double [][] payroll, int count,int choice, int p, int e,int id, double hourwork,double late,double wage, double overtime,
                                   double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position,double less, 
                                   double deduction, double epf, double socso, double eis,double deductleave,double netpay) {
                                   
            // declare and initialize                       
            int i ;
            int basic [] = {7500, 6500,5000, 2500, 1500,1200};
            double validrate [] = {36.06,31.25,24.04,12.02,7.212,5.77};
            
               // Search employee payroll data 
               e=count;
               boolean cari = false;
               if (count == 0)
                     System.out.println("Sorry payroll list is empty");
                else{
                    System.out.print("Enter Employee ID To Edit : ");
                    id = scan.nextInt();  
                 
                for (e = 0; e <count;e++ ){
                  for (p = 0 ; p < payroll[e].length;p++) 
                 
                     if (payroll[e][0]== id){
                     
                     // Input data that need to change
                     System.out.print(" 1. Manager \n 2.Assistant Manager\n 3.Senior Executive \n 4. Supervisor\n 5. Senior Promoter \n 6. Promoter \n Enter Employee Position : ");
                     position = scan.nextInt();
                     
                    if (position == 1 || position == 2 || position == 3 || position == 4 ||position == 5 ||position == 6){
                    
                     System.out.print("Please enter 0 if no overtime!!!\nEnter the Overtime  hours in minute (monthly) : ");
                     hourwork = scan.nextDouble();
                     
                     
                     System.out.print("Enter LateIn/EarlyOut in minute  (monthly): ");
                     late =scan. nextInt();
                       
                     System.out.print("Enter Employee Total Sale (monthly): RM ");
                     totalsale = scan.nextDouble();
                     
                      System.out.print("Enter leave day : ");
                      int leave = scan.nextInt();
                             
                     
                     // Selection 
                     if (position == 1 ){
                         wage = basic[0];
                         payrate = validrate[0];
                         allowance= 200; }
                    else if (position == 2){
                          wage = basic[1];
                         payrate = validrate[1];
                         allowance= 150; }
                    else if (position == 3){
                         wage = basic[2];
                         payrate = validrate[2];
                         allowance= 100; }
                    else if (position == 4){
                         wage = basic[3];
                         payrate = validrate[3];
                         allowance = 50; }
                     else if (position == 5){
                          wage = basic[4];
                         payrate = validrate[4]; }
                      else if (position == 6){
                         wage = basic[5];
                         payrate = validrate[5]; }
                         
                             
                             if (totalsale <= 5000 && position != 1&& position != 2){
                                  commission = totalsale*0.01;
                                  bonus = 0;}
                             else if (totalsale > 5000 && totalsale <7000 && position != 1 && position != 2){
                                  commission = totalsale*0.02;
                                  bonus = 0; }
                              else if (totalsale >= 7000 && totalsale < 10000 && position != 1&& position != 2){
                                  commission = totalsale*0.03;
                                  bonus = totalsale*0.03;}
                              else if (totalsale >= 10000 && position != 1&& position != 2){
                                  commission = totalsale*0.05;
                                  bonus = totalsale*0.03;}
                              else if(totalsale <= 1000){
                                   commission = 0;
                                   bonus = 0; }
                                   
                               //Calculation     
                               overtime = ((payrate*1.5)*(hourwork/60));
                               deduction = ((payrate*1.2)*(late/60));
                               deductleave = (leave*(8*payrate));     
                               epf = wage * 0.09;
                               socso = wage * 0.03;
                               eis = wage * 0.002;  
                               gross = wage + overtime + commission + bonus + allowance;
                               netpay = gross - epf- deduction- socso- eis; 
                                                      
                              // change the data in payroll array
                              payroll[e][0] = id ;
                              payroll[e][1] = totalsale;
                              payroll[e][2] = position;
                              payroll[e][3] = wage;
                              payroll[e][4] = overtime;
                              payroll[e][5] = commission;
                              payroll[e][6] = bonus;
                              payroll[e][7] = allowance;
                              payroll[e][8] = gross;
                              payroll[e][9]= deduction;
                              payroll[e][10]= epf;
                              payroll[e][11]= socso;
                              payroll[e][12]= eis;
                              payroll[e][13]= deductleave;
                              payroll[e][14]= netpay;
                              }
                     else{
                         System.out.println("ERROR! Sorry The position not match! Please try again!");}
                             
                              cari = true;
                              break;
                                 }
                              }    
                           if (cari == false)
                              System.out.println("ERROR!  EMPLOYEE ID NOT FOUND!\n PLEASE TRY AGAIN! ");
                          }    
          }//end edititem
    
        public static void search (double [][] payroll, int count,int choice, int p, int e,int id, double hourwork,double late, double wage, double overtime,
                                   double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position,double less, 
                                   double deduction, double epf, double socso, double eis,double deductleave,double netpay){
               
                 int i=0,j=0; 
                 
                 //search employee data   
                 boolean cari = false;
                 if (count == 0)
                        System.out.println("Sorry! Payroll list is empty");
                 else{
                     System.out.print("Enter Employee ID to search employee personal payroll info : ");
                     id = scan.nextInt();
                      System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t==============================================================\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t VB Collection Sdn. Bhd \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t==============================================================");
                      System.out.printf("\n%85s\n%85s\n%85s\n","=================================","Employee Personal Payroll Info","================================="); 
                     for (e=0; e<count;e++){
                       for(p=0; p<payroll[e].length; p++)
                           if (payroll[e][p] == id){     
                              cari= true;
                              
                              //Print employee data that search by user
                              head();
                              for(p=0; p<payroll[e].length; p++)
                              System.out.printf("%-12.0f",payroll[e][p]);
                              System.out.println();
                              break;
                              }
                            }
                            if (cari == false )
                              System.out.println("Sorry your Employee ID is not in the payroll list");
                             }
                      
         }//End  search 
         
      public static void empview ( double [][] payroll,String name,  int count, String ic, String email,
                                  String phone, int choice, int p, int e,int id, double hourwork,double late,double wage, double overtime,
                                  double commission,double allowance,double bonus,double totalsale,double payrate,double gross,int position, 
                                  double less, double deduction, double epf, double socso, double eis,double deductleave,double netpay ){
  
            int i=0,j=0;   
            
                 // Search employee personal payroll information and input employee personal detail 
                 boolean cari = false;
                 if (count == 0)
                        System.out.println("Sorry! Payroll list is empty");
                 else{
                     System.out.print("Enter Employee Name         : ");
                     name = scan.next()+scan.nextLine();        
                     
                     System.out.print("Enter Employee IC Number    : ");
                     ic = scan.next()+scan.nextLine();  
                    
                     System.out.print("Enter Employee Email        : ");
                     email = scan.next()+scan.nextLine();  
                       
                     System.out.print("Enter Employee Phone Number :  ");
                     phone = scan.next()+scan.nextLine(); 
                     
                     System.out.print("Enter Employee ID           : ");
                     id = scan.nextInt();
                      System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t==============================================================\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t VB Collection Sdn. Bhd \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t==============================================================");
                      System.out.printf("\n%85s\n%85s\n%85s\n","=================================","Employee Personal Payroll Info","================================="); 
                     for (e=0; e<count;e++){
                       for(p=0; p<payroll[e].length; p++)
                           if (payroll[e][p] == id){     
                              cari= true;
                              
                              //print the employee personal payroll info
                              head();
                              for(p=0; p<payroll[e].length; p++)
                              System.out.printf("%-12.0f",payroll[e][p]);
                              System.out.println();
                                 System.out.print("\n\n\nEmployee Name        : " + name);
                                 System.out.print("\nEmployee IC Number   : " + ic);
                                 System.out.print("\nEmployee Email       : " + email);
                                 System.out.print("\nEmployee Phone Number: " + phone); 
                              break;
                              }
                            }
                            if (cari == false )
                              System.out.println("Sorry your Employee ID is not in the payroll list");
                             }  
                    
       }//End empview
       
      // build Header method
      public static void head(){
         System.out.println("\n====================================================================================================================================================================================="); 
         System.out.printf("%70s%70s\n","GROSS PAY","GROSS DEDUCT");
         System.out.println("=====================================================================================================================================================================================");
         System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n","Emp ID","Total sale","Position |"," Wage","Overtime","Commission","  Bonus","Allowance","Gross  |","Deduction","  EPF", "SOCSO", " EIS","Leave ","Netpay");
         System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n","    "," RM","       |","RM","RM"," RM","  RM","RM","RM   |","  RM","RM","RM","RM","RM","RM") ;
         System.out.println("=====================================================================================================================================================================================");
         }//End head
         
      public static void companyhead(){
         System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~WECLOME~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("==============================================================\n\t\t\t\t\t\t VB Collection Sdn. Bhd \n\t\t\t\t\t\t\t PayRoll System \n==============================================================");
         
          }//End companyhead
                     
}//End Class