package com.lucene.zyg.test;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasChildFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

public class XingZuo {
	public static void main(String[] args) {
		try {
			while (true) {
				String output;
				String str = "http://astro.sina.com.cn/pc/west/frame0_";
				String input = javax.swing.JOptionPane
						.showInputDialog("测试网址http://astro.sina.com.cn/pc/west/frame0_7.html\n"
								+ "输入0到11之间的数字\n"
								+ "0代表白羊座\n1代表金牛座\n2代表双子座\n3代表巨蟹座\n4代表狮子座\n5代表处女座"
								+ "\n6代表天秤座\n7代表天蝎座\n8代表射手座\n9代表魔羯座\n10代表水瓶座\n11代表双鱼座");
				str += input + ".html";

				Parser parser = new Parser(str);
				parser.setEncoding("gb2312");
				NodeFilter filter = new AndFilter(new TagNameFilter("span"),
						new HasChildFilter(new TagNameFilter("em")));
				NodeList nodeList = parser.parse(filter);
				Node node = nodeList.elementAt(0);

				// System.out.println(node.toHtml());//<span>射手座<em>11/23 -
				// 12/21</em></span>
				// System.out.println(node.getFirstChild().toHtml());//射手座
				// System.out.println(node.getFirstChild().getNextSibling().getNextSibling().toHtml());//11/23
				// - 12/21
				// System.out.println(node.getChildren().elementAt(0).toHtml());//射手座
				// System.out.println(node.getChildren().elementAt(1).toHtml());//<em>
				// System.out.println(node.getChildren().elementAt(2).toHtml());//11/23
				// - 12/21
				// System.out.println(node.getChildren().elementAt(3).toHtml());//</em>

				String title = node.getFirstChild().toHtml()
						+ " "
						+ node.getFirstChild().getNextSibling()
								.getNextSibling().toHtml();
				// System.out.println(title);
				output = title + "\n";
				filter = new AndFilter(new NodeFilter[] {
						new TagNameFilter("div"),
						new HasAttributeFilter("class", "tab"),
						new HasChildFilter(new TagNameFilter("h4")) });

				parser.reset();
				nodeList = parser.parse(filter);
				int num;
				for (int i = 0; i < 4; i++) {
					node = nodeList.elementAt(i);
					// System.out.print(node.getChildren().elementAt(0).getFirstChild().toHtml()+":");
					output += node.getChildren().elementAt(0).getFirstChild()
							.toHtml()
							+ ":";
					output += node.getChildren().elementAt(1).getChildren()
							.size()
							+ "\n";
				}
				
				for (int i = 4; i < nodeList.size() - 1; i++) {

					// System.out.println(node.getChildren().elementAt(1).getFirstChild().toHtml());
					node = nodeList.elementAt(i);
					output += node.getChildren().elementAt(0).getFirstChild()
							.toHtml()
							+ ":";
					output += node.getChildren().elementAt(1).getFirstChild()
							.toHtml()
							+ "\n";
				}

				filter = new AndFilter(new TagNameFilter("div"),
						new HasAttributeFilter("class", "lotconts"));
				parser.reset();
				nodeList = parser.parse(filter);
				node = nodeList.elementAt(0);
				// System.out.print(node.getFirstChild().toHtml());
				// System.out.println(node.getChildren().elementAt(2).toHtml());
				output += node.getFirstChild().toHtml()
						+ node.getChildren().elementAt(2).toHtml() + "\n";
				javax.swing.JOptionPane.showMessageDialog(null, output, "结果",
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
