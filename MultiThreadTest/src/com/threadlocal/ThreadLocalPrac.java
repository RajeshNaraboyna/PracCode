package com.threadlocal;

public class ThreadLocalPrac {

	private static ThreadLocal<ThreadLocalPrac> threadLocal = new ThreadLocal<ThreadLocalPrac>() {
		@Override
		protected ThreadLocalPrac initialValue() {
			return new ThreadLocalPrac("Stringstr");
		}
	};

	public ThreadLocalPrac(String prac) {
		super();
		this.prac = prac;
	}

	public String prac = "Some String";

	public String getPrac() {
		return prac;
	}

	public static void main(String[] arg) {
		System.out.println(threadLocal.get().getPrac());
	}

}
