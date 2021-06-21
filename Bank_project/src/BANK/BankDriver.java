package BANK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankDriver {
   
   public static int selectAdmin() {
      Scanner scan = new Scanner(System.in);
      System.out.println("1.로그인");      
      System.out.println("2.종료");
      System.out.print(">>>");
      while(!scan.hasNextInt()) {
         scan.next();
         System.err.println("숫자만 입력 가능");
         System.out.print(">>>");
      }
      return scan.nextInt();
   }   

   public static int showMenu(int ownNum) {
      Scanner scan = new Scanner(System.in);
      int select;
      while(true) {
         if(ownNum != 0) {
            System.out.println("1.생성");
            System.out.println("2.입금");
            System.out.println("3.출금");
            System.out.println("4.이체");
            System.out.println("5.잔액확인");
            System.out.println("6.삭제");
            System.out.println("7.뒤로");
         }else {
            System.out.println("1.확인");
            System.out.println("2.뒤로");
         }
         System.out.print(">>>");
         while(!scan.hasNextInt()) {
            scan.next();
            System.err.println("숫자만 입력 가능");
            System.out.print(">>>");
         }
         select = scan.nextInt();
         if(ownNum != 0 && (select > 0 && select < 8)) {
            break;
         }else if(ownNum == 0 && (select > 0 && select < 3)) {
            break;
         }
      }
      return select;
   }
   
   public static int login(ArrayList<Person> list) {
      Scanner scan = new Scanner(System.in);
      String id,pw;
      System.out.print("ID : ");
      id = scan.next();
      System.out.print("PW : ");
      pw = scan.next();
      for (int i = 0; i < list.size(); i++) {         
         if(list.get(i).id.equals(id)) {
            if(list.get(i).pw.equals(pw)) {
               return list.get(i).ownNum;
            }
         }
      }
      return -1;
   }
   
   void run() {
      ArrayList<Account> aList = new ArrayList<Account>();
      ArrayList<Person> pList = new ArrayList<Person>();
      int admin,menu,userNum;      
      Account ac;
      Person ps;
      ps = new Person("admin","00","관리자",0);      
      pList.add(ps);
      ps = new Person("kam","12","감달현",1);      
      pList.add(ps);
      ps = new Person("yoo","34","유대균",2);      
      pList.add(ps);
      ps = new Person("jang","56","장은희",3);      
      pList.add(ps);
      
      ac = new Account("감달현",1000,1000000,1);
      aList.add(ac);
      ac = new Account("감달현",1001,2000000,1);
      aList.add(ac);
      ac = new Account("유대근",2000,3000000,2);
      aList.add(ac);
      ac = new Account("유대근",2001,2500000,2);
      aList.add(ac);
      ac = new Account("유대근",2002,200000,2);
      aList.add(ac);
      ac = new Account("장은희",3000,500000,3);
      aList.add(ac);
      
      for (;;) {
         admin = selectAdmin();
         if (admin == 1) {
            userNum = login(pList);
            if(userNum == -1) {
               System.out.println("없는 사용자 입니다.");
               continue;
            }
            for (;;) {
               menu = showMenu(userNum);
               if(userNum == 0) {
                  if (menu == 1) {
                     CheckBalance ck = new CheckBalance();
                     ck.checkBalance(aList, userNum);
                  }else if(menu == 2) {
                     break;
                  }
               }else {
                  if (menu == 1) {
                     aList.add(new CreateAccount().createAccount(pList,userNum));
                  } else if (menu == 2) {
                     Deposit d=new Deposit();
                     d.deposit(aList, pList, userNum);
                  } else if (menu == 3) {
                     WithDraw w=new WithDraw();
                     w.withDraw(aList, pList, userNum);
                  } else if (menu == 4) {
                     System.out.println("계좌이체");
                     new Transfer().transfer(aList, userNum);
                  } else if (menu == 5) {
                     CheckBalance ck = new CheckBalance();
                     ck.checkBalance(aList, userNum);
                  } else if (menu == 6) {
                     System.out.println("계좌삭제");
                     DeleteAccount da = new DeleteAccount();
                     aList.remove(da.deleteAccount(aList, pList, userNum));
                  } else if (menu == 7) {
                     System.out.println("로그아웃");
                     break;
                  }
               }
            }
         } else {
            break;
         }
      }
   }

   public static void main(String[] args) {      
      BankDriver bd = new BankDriver();
      bd.run();
   }
}