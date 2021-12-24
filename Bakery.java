
package pkg113project;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Bakery {
    
        private String Name ;
	private String Location ;
	private double Area ;
	private int numItems ;
	private int numSweets ;
	private Item[] items ;
	
public Bakery (String name , String loc , double area , int size) {
	
	Name = name ;
	Location = loc ;
	Area = area ;
	items = new Item[size];
	numItems =0 ;
	numSweets=0;
	
}
	
public boolean AddItem(Item item) {
	
	if(numItems < items.length )	{
		
		if(item instanceof Sweet) {
			
			if(numSweets <=  items.length * 0.90 ) {
			items[numItems++] = new Sweet((Sweet)item);
			numSweets++;
			} else {
			JOptionPane.showMessageDialog(null,"cannot add more Sweets");
			}
		}
		
		if(item instanceof Bread)
		items[numItems++] = new Bread((Bread)item);
		
		
		JOptionPane.showMessageDialog(null,"Item has been added");
		return true ;
		
	} else { 
	JOptionPane.showMessageDialog(null,"cannot add more Items");
    return false ;  }
	
}// add

public boolean removeItem(int loc) {
	
	if(loc < numItems && loc >= 0 )  
    {
      for(int j = loc ; j < numItems -1 ; j++)   
      items[j] = items[j+1];
     
      numItems-- ; 
      items[numItems] = null ; 
      return true; 
    }
    return false ; 
    
}


public void DailyCheck() {
	
	for(int i=0 ; i < items.length ; i++ )
	{
		
		items[i].setDisplayDays(items[i].getDisplayDays() + 1 ) ;
		if(items[i].isRotten())
		removeItem(i);
	}
	
}// DailyCheck

public String storeAllSweet() {
	
	String string = "";
	
	if(numSweets > 0 ) {
	
	double TotalPrice  = 0 ; 
	string = "Name=" + Name + ", numSweets=" + numSweets + "\n" ;
	       
	       for(int i = 0 ; i < numItems ; i++)
	       {
	           if(items[i] instanceof Sweet)
	           {
	             TotalPrice +=  items[i].getPrice() ;
	             removeItem(i) ; 
	           }//if
	       }// for
	       
	   numSweets = 0 ; 
	   string = string + " Total price : " + TotalPrice + "\n"; 
	    
	
	}else {
		
	JOptionPane.showMessageDialog(null, "no sweet in the");

	}
	
      
	return string ;
	
	
}//store All Sweet

public String toString() {
	
	String str = "Name :"+ Name + "\nLocation : " +Location 
			+ "\nArea :" + Area + "\n Number of Items : " 
			+ numItems +"\nNumber of Items : "+ numSweets ;
	
	for(int i = 0; i < items.length ; i++) {
	str +=items[i].toString();
	}
	return str ;
	
}//toString

// self added methods

public void saveBakery() {;} // append 

public Bakery[] loadBakery() throws  IOException, ClassNotFoundException , FileNotFoundException {
	
	
	int count = 0 ; 
	boolean x = true ;
	Bakery[]  bakery = new Bakery[100];
	
        File file ;
        FileInputStream FOS ;
        ObjectInputStream OIS  ;
        
	try {

	
	file = new File("Baked.dat");
	FOS  = new FileInputStream (file);
	OIS  = new ObjectInputStream (FOS);
	

	while(x)
	bakery[count++] = (Bakery) OIS.readObject(); 
	
	OIS.close();
	}catch(EOFException e ) {
	x = false ;
	}
	
	return bakery;
	
	
}// 

    public String getName() { return Name; }

    public String getLocation() { return Location; }

    public double getArea() { return Area; }
    
    public int getNumItems() { return numItems; }

    //public int getNumSweets() { return numSweets; }

    //public Item[] getItems() { return items; }

    public void setName(String Name) { this.Name = Name; }

    public void setLocation(String Location) { this.Location = Location; }

    public void setArea(double Area) { this.Area = Area; }

}// end of class
