
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3};
		int [] b = {1,2,4};
		
		for(int i=0;i<a.length;i++){
			int a1 = a[i];
			System.out.println(a1);
			for(int j=0;j<b.length;j++){
				int b1 = b[j];
				if(a1==b1){
					break;
				}else{
					System.out.println(a1+"->"+b1);
					return ;
				}
			}
		}
	}

}
