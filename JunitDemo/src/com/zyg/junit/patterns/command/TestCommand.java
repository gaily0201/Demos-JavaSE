package com.zyg.junit.patterns.command;

import java.util.Iterator;
import java.util.List;
/**
 * 这三个命令进入List中后,已经失去了其外表特征,以后再取出
 * ,也可能无法分辨出谁是Engineer 谁是Programmer了,看下面如何调用Command模式:
 * @author Administrator
 *
 */
public class TestCommand {
	public static void main(String[] args) {
		List queue = Producer.produceRequests();
		for (Iterator it = queue.iterator(); it.hasNext();)
			// 取出List中东东,其他特征都不能确定,只能保证一个特征是100%正确,
			// 他们至少是接口Command的"儿子".所以强制转换类型为接口Command
			((Command) it.next()).execute();
	}
}