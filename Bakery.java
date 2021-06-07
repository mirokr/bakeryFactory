/*
Bakery.java
05.04.2021
Miro Krpeta
*/
import javax.swing.*;
public class Bakery{
	//variables
	private String name;
	private final int MAX_NUM_RATINGS=3;
	private double avgRating;
	private int counter;
	private int[]ratingArray;
	//constructor
	public Bakery(String a){
		this.name=a;
		ratingArray=new int[MAX_NUM_RATINGS];
	}//other variables are instantiated to their default values, int/double to 0
	//setters & getters
	public void setName(String a){this.name=a;}//if bakery changes name

	public String getName(){return name;}

	public int[] getRatingArray(){return ratingArray;}

	public double getAvgRating(){
		int c=0;
		double d=0.0;
		for(int i:ratingArray){//get average if any rating, else return 0
			if(i!=0){d+=i;c++;}
		}
		if(c!=0){avgRating=d/c; return avgRating;}
		return avgRating;
	}
	//methods
	public void setRating(int a){
		if(counter<MAX_NUM_RATINGS){
			ratingArray[counter]=a;
			counter++;
			JOptionPane.showMessageDialog(null, "New Rating for "+name.toUpperCase()+ " bakery is added.");
		}else{
			JOptionPane.showMessageDialog(null, "Sorry, this bakery was already rated "+MAX_NUM_RATINGS+" times.");
		}
	}
}//class