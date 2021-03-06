package CH9;
/****************** Exercise 15 *****************
 * Create a class with a non-default constructor
 * (one with arguments) and no default constructor
 * (no "no-arg" constructor). Create a second class
 * with a method that returns a reference to
 * an object of the first class. Create the object
 * you return by making an anonymous inner
 * class inherit from the first class.
 ***********************************************/

class NoDefault{
	private int i;
	public NoDefault(int i){
		this.i = i;
	}
	public void f(){
		System.out.println("NoDefault.f");
	}
}

class Second{
	public NoDefault get1(int i){
		return new NoDefault(i){};
	}
	public NoDefault get2(int i){
		return new NoDefault(i){
			public void f(){
				System.out.println("Second.get2.f");
			}
		};
	}
}


