package com.zyg.junit.patterns.command;

import java.util.Iterator;
import java.util.List;
/**
 * �������������List�к�,�Ѿ�ʧȥ�����������,�Ժ���ȡ��
 * ,Ҳ�����޷��ֱ��˭��Engineer ˭��Programmer��,��������ε���Commandģʽ:
 * @author Administrator
 *
 */
public class TestCommand {
	public static void main(String[] args) {
		List queue = Producer.produceRequests();
		for (Iterator it = queue.iterator(); it.hasNext();)
			// ȡ��List�ж���,��������������ȷ��,ֻ�ܱ�֤һ��������100%��ȷ,
			// ���������ǽӿ�Command��"����".����ǿ��ת������Ϊ�ӿ�Command
			((Command) it.next()).execute();
	}
}