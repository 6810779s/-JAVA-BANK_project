package BANK;

import java.util.ArrayList;
import java.util.Scanner;

public class WithDraw {

   Account ac = new Account();
   Scanner scan=new Scanner(System.in);


   public void withDraw(ArrayList<Account> list, ArrayList<Person> pList,int ownNum){ // 출금
      int tmp=0,i=0,a=0;
      int c=0;
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
      System.out.print("출금할 계좌번호:");
      while(!scan.hasNextInt()) {
         scan.next();
         System.err.println("숫자만 입력 가능");
         System.out.print("출금할 계좌번호:");
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
               System.out.print("출금 금액:");
               while(!scan.hasNextInt()) {
                  scan.next();
                  System.err.println("숫자만 입력 가능");
                  System.out.print("출금 금액:");
               }
               int money=scan.nextInt();
               System.out.println();
               
               if(list.get(i).balance<money) {
                  System.out.println("출금할 돈이 부족합니다.");
               }
               else if(list.get(i).balance>0) {
                  System.out.printf("출금 후 잔액:%d원",list.get(i).balance-money);
                  list.get(i).balance-=money;
                  System.out.println();
               }
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