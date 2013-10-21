package com.zyg.classy;

public class ColorPoint extends Point {
	private final String color;

	ColorPoint(int x, int y, String color) {
		super(x, y); // 2. Chain to Point constructor
		this.color = color; // 5. Initialize blank final-Too late
	}

	protected String makeName() {
		// 4. Executes before subclass constructor body!
		return super.makeName() + ":" + color;
	}

	public static void main(String[] args) {
		// 1. Invoke subclass constructor
		System.out.println(new ColorPoint(4, 2, "purple"));
	}
}

/*class Point {
	protected final int x, y;
	private final String name; // Cached at construction time

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		name = makeName(); // 3. Invoke subclass method
	}

	protected String makeName() {
		return "[" + x + "," + y + "]";
	}

	public final String toString() {
		return name;
	}
}*/

//不太好的解决方法:惰性初始化
class Point {
	protected final int x, y;
	private String name; // Lazily initialized

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		// name initialization removed
	}

	protected String makeName() {
		return "[" + x + "," + y + "]";
	}

	// Lazily computers and caches name on first use
	public final synchronized String toString() {
		if (name == null)
			name = makeName();
		return name;
	}
}