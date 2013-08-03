package CH6;
/****************** Exercise 11 *****************
 * Modify Detergent.java so it uses delegation.
 ***********************************************/

class DetergentDelegation{
	private Cleanser cleanser = new Cleanser();
	public void append(String a){
		cleanser.append(a);
	}
	public void dilute(){
		cleanser.dilute();
	}
	public void apply(){
		cleanser.apply();
	}
	public String toString(){
		return cleanser.toString();
	}
	public void scrub(){
		append(" DetergentDelegation.scrub()");
        cleanser.scrub();
	}
	public void foam(){
		append("foam()");
	}
	public static void main(String[] args){
		DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
	}
}
public class E11_Delegation {
    public static void main(String[] args) {
      DetergentDelegation.main(args);
    }
  }