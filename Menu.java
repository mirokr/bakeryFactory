/*
Menu.java
05.04.2021
Miro Krpeta
1 –Add an item
2 –Display all the items
3–Add a rating for a given item
4–Display all the ratings for a given item
5–Calculate and display the average rating for each item
6–Display  the  worst  item  based  on  the  average rating .
7–Exit application
*/
import javax.swing.*;
public class Menu{
  //variables
  private BakeryFactory factory;
  private DisplayBakery display;
  private String menuList;
  //constructor
  public Menu(){
	  factory=new BakeryFactory();
	  menuList="MENU:\n1-Add bakery\n2-Display all bakeries\n3-Add a rating for bakery\n4-Display all the ratings for particular bakery\n5-Calculate and display the average rating for each bakery\n6-Display  the  worst  bakery  based  on  the  average rating\n7-Exit\n";
	  display=new DisplayBakery();
  }
  public static void main(String[]args){
	  int count=0;
	  JOptionPane.showMessageDialog(null, "*********Welcome to the bakery rating application*********\nPlease note:\n-You can add 5 different bakeries\n-You can give 3 ratings to each bakery");
	  Menu menu=new Menu();
	  while(true){
		try{int a=Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuList+"\nEnter your choice:"));
		  if(a==7){
			  JOptionPane.showMessageDialog(null, "Thank you for your time, have a nice day!");
			  break;
			}
		  else if(a==1){
			  String s=JOptionPane.showInputDialog(null, "Please input name for bakery to be added:");
			  menu.factory.addBakery(s);
		  }
		  else if(a==2){
			  menu.display.displayAll(menu.factory);
		  }
		  else if(a==3){
			  String b=JOptionPane.showInputDialog(null, "Please input name of the bakery you want to rate:");
			  int s=0;
		   try{s=Integer.parseInt(JOptionPane.showInputDialog(null, "Please input new rating, number from 1 to 5 please:"));
		   }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Please input a number from 1 to 5!");continue;}
			  if(s==1||s==2||s==3||s==4||s==5){menu.factory.rateBakery(b,s);}
			  else{JOptionPane.showMessageDialog(null, "Wrong rating input!");}
		  }
		  else if(a==4){
			  String b=JOptionPane.showInputDialog(null, "Please input name of the bakery you need ratings for:");
			  menu.display.displayRatings(menu.factory,b);
		  }
		  else if(a==5){
			  menu.display.displayAvgRating(menu.factory);
		  }
		  else if(a==6){
			  menu.display.displayWorst(menu.factory);
		  }
		}catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Please input a number from 1 to 7!");}
	  }//loop

  }//main

}//class