package com.zyg.junit.patterns.command;

import java.util.ArrayList;
import java.util.List;
/**
 * 按照通常做法,我们就可以直接调用这三个Command
 * ,但是使用Command模式,我们要将他们封装起来,扔到黑盒子List里去:
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
