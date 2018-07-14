package rough;

public class C1 implements I1{

	static C1 ref;
	public static void main(String[] args) {
		ref = new C1();
		ref = ref.method1(); 

	}

	public C1 method1() {
		// TODO Auto-generated method stub
		System.out.println("Method 1 of class");
		return this;
	}

}
