package kr.co.rland.web.aop;

public class DefaultCalculator implements Calculator {

	private int x;
	private int y;
	
	
	public DefaultCalculator() {}
	
	public DefaultCalculator(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public int plus() {
		// TODO Auto-generated method stub
		int result = x+y;
		return result;
	}

	@Override
	public int sub() {
		// TODO Auto-generated method stub
		int result = x-y;
		return result;
	}

	@Override
	public int multi() {
		// TODO Auto-generated method stub
		int result = x*y;
		return result;
	}

	

	
	
	
	
	
	
}
