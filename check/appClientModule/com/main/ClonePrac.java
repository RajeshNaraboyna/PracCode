package com.main;

public class ClonePrac implements Cloneable{

	   public long               start;
	   public long               end;
	   public long               totalTime;
	   public String             totalTimenew         = null;
	   public long               batchtotalTime;
	   public String             batchtotalTimenew    = null;
	   
	   
	   
	public ClonePrac() {
		super();
	}

	public ClonePrac(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected ClonePrac clone() throws CloneNotSupportedException {
		ClonePrac clonePrac= new ClonePrac();
		clonePrac.start = this.start;
		clonePrac.end = this.end;
		return clonePrac;
	}
	
	
	@Override
	public String toString() {
		return this.start+" "+this.end;
	}
	public static void main(String[] arg) throws CloneNotSupportedException {
		ClonePrac clonePrac = new ClonePrac(121212l, 123213l);
		ClonePrac clonePracClone = clonePrac.clone();
		System.out.println(clonePrac);
		System.out.println(clonePracClone);
		System.out.println(clonePracClone==clonePrac);
	}
	
}
