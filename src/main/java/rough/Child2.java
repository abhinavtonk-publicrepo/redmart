package rough;

public class Child2 extends Parent{
	
	public Child2 method3(){
		System.out.println("Method3 Child 2");
		
		return this;
	}
	
	public static void main(String[] args) {
		/*Child1 child1 = new Child1();
		
		child1.method1();*/
		
		/*Child1 c =   (Child1) method1();
		c.m1();*/
		
		Parent p = method1();
		p.m1();
		
		/*Child1 cp = (Child1) new Parent();
		cp.m1();*/
		
	}

}
