
public class Singleton {
	 private static Singleton single = new Singleton();
	  private Singleton(){}
	  public static Singleton getInstance(){
	    return single;
	  }
}
