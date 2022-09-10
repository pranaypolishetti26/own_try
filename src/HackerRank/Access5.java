package HackerRank;


abstract class Access4 {
	public void show() {
		System.out.println("hello world");
	}
	abstract void show1();
}

public class Access5 extends Access4{
	void show1() {
		System.out.println("it is showing ");
	}
	public static void main(String[] args) {
		Access5 obj = new Access5();
		obj.show();
		
	}
}

interface implementme{
	void pranay();
	void bunty();
	void amulya();
	void ammu();
}

interface implementmetoo{
	void charan();
	void pavan();
	void raj();
}

class Name implements implementme,implementmetoo{

	@Override
	public void pranay() {
		System.out.println("pranay");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bunty() {
		System.out.println("bunty");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void amulya() {
		System.out.println("amulya");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ammu() {
		System.out.println("ammu");
		// TODO Auto-generated method stub
		
	}
	public void classMethod() {
		System.out.println("i am from class");
	}

	@Override
	public void charan() {
		System.out.println("charan");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pavan() {
		System.out.println("pavan");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void raj() {
		System.out.println("raj");
		// TODO Auto-generated method stub
		
	}
	
}


abstract class Dummy{
	abstract void  srikanth();
	void nihal() {
		System.out.println("nihal");
	}
}
class NotDummy extends Dummy{

	@Override
	void srikanth() {
		System.out.println("srikanth");
		// TODO Auto-generated method stub
		
	}
	
}