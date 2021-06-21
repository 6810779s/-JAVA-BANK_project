package BANK;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
   String id;
   String pw;
   String name;
   int ownNum;
   
   public Person() {
      
   }
   
   public Person(String id, String pw, String name, int ownNum) {
      this.id = id;
      this.pw = pw;
      this.name = name;
      this.ownNum = ownNum;
   }
}