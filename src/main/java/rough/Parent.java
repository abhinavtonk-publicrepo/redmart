package rough;

public class Parent {
	
	public void m1(){
		System.out.println("Parent m1");
	}
	
	public static Parent method1(){
		System.out.println("Parent Method1");
		
		Child1 c = new Child1();
		Parent p = new Parent();
		
		
		return  c;
	}

}
