public class SingletonTest {
	//�����һ����ͨ���ԡ�
	int value;
	//ʹ�þ�̬�����ౣ������һ��ʵ����
	private static SingletonTest instance;

	//������˽�л���������౻���ʵ����
	private SingletonTest() {
		System.out.println("����ִ�й�������");
	}

	//�ṩ��̬���������ظ����ʵ����
	public static SingletonTest getInstance() {
		//ʵ������ʵ��ǰ���ȼ������ʵ���Ƿ����
		if (instance == null) {
			//��������ڣ����½�һ��ʵ����
			instance = new SingletonTest();
		}
		//���ظ���ĳ�Ա����:�����ʵ����
		return instance;
	}

	//�����ṩ����ͨ����value��setter��getter����
	public int getValue() {
		return value;
	}

	public void setValue(int values) {
		this.value = value;
	}

	public static void main(String[] args) {
		SingletonTest t1 = SingletonTest.getInstance();
		SingletonTest t2 = SingletonTest.getInstance();
		t2.setValue(9);
		System.out.println(t1 == t2);
	}
}
