/*
BakeryFactory.java
05.04.2021
Miro Krpeta
*/
import javax.swing.*;
public class BakeryFactory{
	//variables
	private final int MAX_NUM_ITEMS=5;
	int counter;
	private Bakery[] list;
	//constructor
	public BakeryFactory(){
		list=new Bakery[MAX_NUM_ITEMS];
	}

	//getters
	public Bakery[] getList(){
		return list;
	}

	//methods
	public void addBakery(String a){
		if(counter<MAX_NUM_ITEMS){
			boolean f=true;
			for(Bakery s:list){
				if(a==null||(s!=null && s.getName().equalsIgnoreCase(a))){
				if(a==null){f=false;break;}//if cancel is choosen
				f=false;
				JOptionPane.showMessageDialog(null, "Bakery with that name already exists, please choose a new name.");
				}
			}//check is name original
				if(f){
					list[counter]=new Bakery(a);
					counter++;
					JOptionPane.showMessageDialog(null, "Bakery "+a.toUpperCase()+" is added to the list.");
				}
		}else{JOptionPane.showMessageDialog(null, "Sorry, but maximum number of bakeries is reached!");}
	}//add

	public void sort(){//sort in ascending order-lowest rating first
		Bakery t=null;
		for (int i = 0; i < list.length; i++)
		{
            for (int j = i + 1; j < list.length; j++)
            {
				if(list[i]!=null & list[j]!=null){
					if (list[i]. getAvgRating()> list[j].getAvgRating())
					{
						t=list[i];
						list[i]=list[j];
						list[j]=t;
					}
				}
            }//loop
        }//loop
	}//sort

	public void rateBakery(String a, int b){
		int count=0;
		for(int i=0; i<list.length;i++){
			if(list[i]!=null&&list[i].getName().equalsIgnoreCase(a)){list[i].setRating(b);}
			else{count++;
			}
		}//loop
		if (count==list.length){JOptionPane.showMessageDialog(null, "Sorry but there is no bakery with that name.");}
	}//rate

}//class