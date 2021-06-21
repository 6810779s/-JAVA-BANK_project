package BANK;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteAccount {
   public int deleteAccount(ArrayList<Account> list, ArrayList<Person> pList, int ownNum){
      Scanner scan = new Scanner(System.in);
      Account ac = new Account();
      int check,count=1;
      boolean pwCheck = false;
      ArrayList<Integer> indexList = new ArrayList<Integer>();
      while(true) {         
         for(int i=0;i<list.size();i++) {
            if(list.get(i).ownNum == ownNum) {
               System.out.println(count+". 계좌번호 : " + list.get(i).accountNumber + ", 잔액 : " + list.get(i).balance + "원");
               indexList.add(i);
               count++;
            }
         }
         System.out.print("삭제할 계좌 선택 >>>");
         while(!scan.hasNextInt()) {
            scan.next();
            System.err.println("숫자만 입력 가능");
            System.out.print("삭제할 계좌 선택 >>>");
         }
         check = scan.nextInt();
         if(check > 0 && check < count) {
            pwCheck = ac.passwordCheck(pList,ownNum);
            if(pwCheck) {
               System.out.println("선택 계좌 삭제를 완료하였습니다.");
               break;
            }else {
               count=1;   // 계좌 index 초기화
            }
         }else {
            count=1;
            System.out.println("선택 범위를 벗어났습니다.");
         }
      }
      return indexList.get(check-1);
   }
}