package BANK;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateAccount {
   Scanner scan = new Scanner(System.in);

   public Account createAccount(ArrayList<Person> list, int ownNum) {
      Account create = new Account();
      System.out.println("계좌생성");
      System.out.print("생성하실 계좌번호를 입력하세요(숫자만) : ");
      while (!scan.hasNextInt()) {
         scan.next();
         System.err.println("숫자만 입력 가능");
         System.out.print("생성하실 계좌번호를 입력하세요(숫자만) : ");
      }
      create.accountNumber = scan.nextInt();
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).ownNum == ownNum) {
            create.name = list.get(i).name;
            break;
         }
      }
      System.out.print("초기 입금액을 입력하세요 : ");
      while (!scan.hasNextInt()) {
         scan.next();
         System.err.println("숫자만 입력 가능");
         System.out.print("초기 입금액을 입력하세요 : ");
      }
      create.balance = scan.nextInt();

      create.ownNum = ownNum;
      return create;

   }
}