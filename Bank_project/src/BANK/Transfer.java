package BANK;
import java.util.ArrayList;
import java.util.Scanner;

public class Transfer {
	
   public void transfer(ArrayList<Account> account, int ownNum) {
      Scanner scan = new Scanner(System.in);
      int tmp, tran = 0, my = 0, tranmoney = 0,cnt=0;
      Boolean collectName = false;
      System.out.println("계좌확인");
      
      for (int i = 0; i < account.size(); i++) {
         if (ownNum == account.get(i).ownNum) {
            if(cnt==0) System.out.println(account.get(i).name+"님의 계좌 리스트");
            System.out.println("계좌번호 : " + account.get(i).accountNumber + ", 잔액 : "+ account.get(i).balance + "원");
            cnt++;
         }
      }
      for (;;) {
         System.out.print("이체진행하실 계좌번호를 입력하세요 : ");
           while(!scan.hasNextInt()) {
                  scan.next();
                  System.err.println("숫자만 입력 가능");
                  System.out.print("이체진행하실 계좌번호를 입력하세요 : ");
               }
         tmp = scan.nextInt();
         for (int i = 0; i < account.size(); i++) {
            if (tmp == account.get(i).accountNumber) {
               collectName = true;
               my = i;
            }
         }
         if (collectName) {
            break;
         } else {
            System.out.println("일치하는 계좌가 없습니다.");
         }
      }

      // 이체 진행계좌 선택

      collectName = false;

      for (;;) {
         System.out.print("이체하실 계좌번호를 입력하세요 : ");
          while(!scan.hasNextInt()) {
                  scan.next();
                  System.err.println("숫자만 입력 가능");
                  System.out.print("이체하실 계좌번호를 입력하세요 : ");
               }
         tmp = scan.nextInt();
         for (int i = 0; i < account.size(); i++) {
            if (tmp == account.get(i).accountNumber) {
               collectName = true;
               tran = i;
            }

         }
         if (collectName) {
            break;
         } else {
            System.out.println("일치하는 계좌가 없습니다.");
         }
      } // 이체하는계좌 선택
      for (;;) {

         System.out.print("이체 하실 금액을 입력하세요 : ");
          while(!scan.hasNextInt()) {
                  scan.next();
                  System.err.println("숫자만 입력 가능");
                  System.out.print("이체 하실 금액을 입력하세요 : ");
               }
         tranmoney = scan.nextInt();
         if (account.get(my).balance >= tranmoney) {
            account.get(my).balance -= tranmoney;
            account.get(tran).balance += tranmoney;
            break;
         } else {
            System.out.println("잔액이 부족합니다.");
         }

      }

   }
}