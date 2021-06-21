package BANK;

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Deposit {   
//   Account ac=new Account();
//   Scanner scan=new Scanner(System.in);
//
//   public void deposit(ArrayList<Account> list, int ownNum){
//      int tmp=0,i=0,cnt=0;
//      for (int j = 0; j < list.size(); j++) {
//         if (ownNum == list.get(j).ownNum) {
//            if(cnt==0) System.out.println(list.get(j).name+"님의 계좌 리스트");
//            System.out.println("계좌번호 : " + list.get(j).accountNumber + ", 잔액 : "+ list.get(j).balance + "원");
//            cnt++;
//         }
//      }
//      System.out.println("입금할 계좌번호:");
//      int accountNumber=scan.nextInt();
//      for(;;) {
//         for(i=0;i<list.size();i++) {
//            if(list.get(i).accountNumber==accountNumber) {
//               tmp=1;
//               ac.balance=list.get(i).balance;
//               break;
//            }//if(list.get(i).accountNumber==accountNumber)   
//            else {
//               tmp=2;
//            }
//         }
//
//         if(tmp==1) {
//            System.out.print("입금 금액:");
//            int money=scan.nextInt();
//            System.out.println();
//
//            System.out.printf("입금 후 잔액:%d원",list.get(i).balance+money);
//            list.get(i).balance+=money;
//            System.out.println();
//
//            break;
//         }//if(tmp==1)
//         else {
//            System.out.println("없는 계좌번호 입니다.");
//            break;
//         }
//      }//for(;;)
//   }
//
//}

import java.util.ArrayList;
import java.util.Scanner;

public class Deposit {   
   Account ac=new Account();
   Scanner scan=new Scanner(System.in);

   public void deposit(ArrayList<Account> list, ArrayList<Person> pList,int ownNum){
      int tmp=0,i=0,c=0,a=0;
      boolean pwCheck = false;
      System.out.println("계좌확인");
      for(a=0;a<list.size();a++) {
         if(list.get(a).ownNum==ownNum){
            
            if(c==0) {
               System.out.printf("%s님의 계좌 리스트",list.get(a).name);
            }
            
            System.out.println();
            System.out.printf("계좌번호 : %d, 잔액 : %d원",list.get(a).accountNumber,list.get(a).balance);
            c++;
         }
      }
      System.out.println();
      System.out.print("입금할 계좌번호:");
      while(!scan.hasNextInt()) {
         scan.next();
         System.err.println("숫자만 입력 가능");
         System.out.print("입금할 계좌번호:");
      }
      int accountNumber=scan.nextInt();
      pwCheck = ac.passwordCheck(pList,ownNum);
      if(pwCheck) {
         for(;;) {
            for(i=0;i<list.size();i++) {
               if(list.get(i).accountNumber==accountNumber) {
                  tmp=1;
                  
                  ac.balance=list.get(i).balance;
                  break;
                  
               }//if(list.get(i).accountNumber==accountNumber)   
               else {
                  tmp=2;
               }
            }
            
            if(tmp==1) {
               System.out.print("입금 금액:");
               while(!scan.hasNextInt()) {
                  scan.next();
                  System.err.println("숫자만 입력 가능");
                  System.out.print("입금 금액:");
               }
               int money=scan.nextInt();
               System.out.println();            
               
               System.out.printf("입금 후 잔액:%d원",list.get(i).balance+money);
               list.get(i).balance+=money;
               System.out.println();
               
               break;
            }//if(tmp==1)
            
            else {
               System.out.println("없는 계좌번호 입니다.");
               break;
            }
            
         }//for(;;)
      }
   }

}