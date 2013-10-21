
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		double y;
		x=2;
		y=x+3/2;
		System.out.println(x);
		System.out.println(y);
		
		Singleton t1 = Singleton.getInstance();
		Singleton t2 = Singleton.getInstance();
		System.out.println(t1==t2);
		
	}

}
