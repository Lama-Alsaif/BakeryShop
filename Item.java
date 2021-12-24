
package pkg113project;

import java.io.Serializable;

public abstract class Item implements Serializable {

	protected int displayDays ;
	private double price ;

    public void setPrice(double price) { this.price = price; }
	
public Item(double price) {
	
	this.price = price ;
	displayDays = 1; 
	
}// cons 

public Item(Item item) {
	
	displayDays = item.displayDays;
    price = item.price;
    
}//copy constructor 

public String toString() {
return "number of days " + displayDays +"\n price : "+getPrice() ;
}//toString

public abstract Boolean isRotten(); 

public double getPrice() { return price; }


public int getDisplayDays() { return displayDays ; }

public void setDisplayDays(int disTrack) { displayDays = disTrack ; }

}//Item