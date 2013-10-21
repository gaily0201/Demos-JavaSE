package com.zyg.junit.patterns.command;

import java.util.ArrayList;
import java.util.List;
/**
 * ����ͨ������,���ǾͿ���ֱ�ӵ���������Command
 * ,����ʹ��Commandģʽ,����Ҫ�����Ƿ�װ����,�ӵ��ں���List��ȥ:
 * @author Administrator
 *
 */
public class Producer {
	public static List produceRequests() {

		List queue = new ArrayList();
		queue.add(new Engineer());
		queue.add(new Politician());
		queue.add(new Programmer());
		return queue;
	}
}
