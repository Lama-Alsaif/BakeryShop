
package pkg113project;

public class Sweet extends Item {
 
	
	private String name ;
	
public Sweet(String n , double price) {
	
	super(price);
	name = n ;
	
}

public Sweet(Sweet s) {
	
	super(s);
	name = s.name ;	
}

public String toString() {
	
	
	return super.toString() + " Name : " +name ;
	
}//toString

public Boolean isRotten() {
	
	boolean rotten = false ;
	
	switch(this.name) {
	
	case "Dount" :
		
		if(displayDays > 2) {
		rotten = true ;
		break ; }
		
	case "English cake" :
		
		if(displayDays > 4) {
		rotten = true ;
		break ; }
		
	default : 
		
		if(displayDays > 3)
		rotten = true ;
		
	}// switch
	
	return rotten ;
	
}// is rotten

}
