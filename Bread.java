
package pkg113project;


public class Bread extends Item {

	private String type ;
	
public Bread(String t , double price ) {
	
	super(price);
	type = t ;
	
}//cons

public Bread(Bread b) {
	
	super(b);
	type = b.type;
	
}//

public String toString() {
	
	
	return super.toString() + "\n Type : " +type ;
	
}//

public Boolean isRotten() {
	
	boolean rotten = false ;
	
	switch(this.type) {
	
	case "Arabic" :
		
		if(displayDays > 3) {
		rotten = true ;
		break ;}
		
	case "Toast" :
		
		if(displayDays > 5) {
		rotten = true ;
		break;}
		
	default : 
		
		if(displayDays > 4) 
		rotten = true ;	
		
	}// switch
	
	return rotten ;
	
}// is rotten

}