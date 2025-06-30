package com.roadmap.beginnerproblems.logic_building;

public class IfElseIf {
   public void studentGrade(int marks) {
      if (marks >= 90) {
         System.out.println("Grade A");
      } else if (marks >= 70) {
         System.out.println("Grade B");
      } else if (marks >= 50) {
         System.out.println("Grade C");
      } else if (marks >= 35) {
         System.out.println("Grade D");
      } else {
         System.out.println("Fail");
      }
   }
}