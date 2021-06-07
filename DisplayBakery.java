/*
DisplayBakery.java
06.04.2021
Miro Krpeta
2 –Display all the items
4–Display all the ratings for a given item
5–Calculate and display the average rating for each item
6-Display  the  worst  item  based  on  the  average rating
*/
import javax.swing.*;
public class DisplayBakery{
	//variables
	private int counter;
	//default constructor

	//methods
	public void displayAll(BakeryFactory a){//display all bakeries we have added or display message
		String s="";
		counter=0;
		for(int i=0;i<a.getList().length;i++){
			if(a.getList()[i]!=null){
				s+=a.getList()[i].getName().toUpperCase()+"\n";
			}else{
				counter++;
			}
		}//loop
		if(counter==a.getList().length){counter=0;JOptionPane.showMessageDialog(null, "Ops, sorry but looks like there is no bakery in our list yet!");}else{JOptionPane.showMessageDialog(null, "We have following bakeries in our bakery list:\n"+s);}
	}//display all

	public void displayRatings(BakeryFactory a, String b){
		counter=0;
		int counterB=0;
		boolean handy=false;
		String s="Following are ratings for bakery ";
		for(int i=0;i<a.getList().length;i++){
			if(a.getList()[i]!=null&&a.getList()[i].getName().equalsIgnoreCase(b)){//if bakery in the list
				s+=a.getList()[i].getName().toUpperCase()+":\n";
				for(int j=0;j<a.getList()[i].getRatingArray().length;j++){//get ratings array
					if(a.getList()[i].getRatingArray()[j]!=0){//if there is a rating
					s+=a.getList()[i].getRatingArray()[j]+"\n";
					}else{counter++;}
				}
				if(counter==a.getList()[i].getRatingArray().length){//if there is no ratings for that bakery
					handy=true;
					JOptionPane.showMessageDialog(null, "Sorry but there are no ratings available for bakery "+a.getList()[i].getName().toUpperCase());
				}
			}else{
			counterB++;
			}
		}//loop
		if(counterB==a.getList().length){//if cant find bakery with that name
			JOptionPane.showMessageDialog(null, "Sorry but we can't find bakery with that name!");
		}
		else if(handy){}//do nothing if no ratings
		else{JOptionPane.showMessageDialog(null, s);}
	}//display ratings for bakery

	public void displayAvgRating(BakeryFactory a){
		String s="******Average ratings for all available bakeries******\n";
		counter=0;
		for(int i=0;i<a.getList().length;i++){
			if(a.getList()[i]!=null){//if we have bakery in the list
				if(a.getList()[i].getAvgRating()!=0.0){//if bakery has average rating
					s+=String.format("%s - %.2f\n",a.getList()[i].getName().toUpperCase(),a.getList()[i].getAvgRating());
				}else{
					s+=String.format("%s - NO RATINGS YET\n",a.getList()[i].getName().toUpperCase());
				}
			}else{
				counter++;
			}
		}//loop
		if(counter==a.getList().length){counter=0;JOptionPane.showMessageDialog(null, "Sorry but no bakeries added yet!");//if no bakeries yet
		}else{JOptionPane.showMessageDialog(null, s);}
	}//avg ratings

	public void displayWorst(BakeryFactory a){
		String s="******Bakery with the lowest average rating******\n";
		counter=0;
		a.sort();
		for(int i=0;i<a.getList().length;i++){//need to show one with lowest not one with no rating
			if(a.getList()[i]!=null&&a.getList()[i].getAvgRating()!=0.0){
				s+=a.getList()[i].getName().toUpperCase();
				break;//first rating>0 is lowest as min rating is 1
			}else{
				counter++;
			}
		}//loop
		if(counter==a.getList().length){
			JOptionPane.showMessageDialog(null, "Sorry but no bakery was rated yet.");
		}else{JOptionPane.showMessageDialog(null, s);};
	}//worst
}//class