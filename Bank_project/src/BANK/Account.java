package BANK;

import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Comparable<Account>{
   String name;
   int accountNumber;
   int balance;
   int ownNum;
   
   public Account() {
      
   }
   
   public Account(String name, int accountNumber, int balance, int ownNum) {
      this.name = name;
      this.accountNumber = accountNumber;
      this.balance = balance;
      this.ownNum = ownNum;
   }
   
   public boolean passwordCheck(ArrayList<Person> pList, int ownNum) {
      Scanner scan = new Scanner(System.in);
      System.out.print("패스워드 확인 : ");
      String pw = scan.next();
      for(Person p:pList) {
         if(p.ownNum == ownNum) {
            if(p.pw.equals(pw)) {
               System.out.println("패스워드 확인 성공");
               return true;
            }else {
               System.out.println("패스워드 확인 실패");
            }
         }
      }
      return false;
   }
   
   @Override
   public int compareTo(Account o) {
      if(this.ownNum < o.ownNum) {
         return -1;
      }else if(this.ownNum > o.ownNum) {
         return 1;
      }
      return 0;
   }
}