package BANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckBalance {
   public void checkBalance(ArrayList<Account> list, int ownNum){      
      Collections.sort(list);      
      for (Account account : list) {
         if(account.ownNum == ownNum || ownNum == 0) {
            System.out.println(account.name+"님의 계좌번호 : " + account.accountNumber + ", 잔액 : " + account.balance + "원");
         }
      }
   }
}