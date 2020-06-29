package test;

public class Builder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("StringBuilder");
		StringBuilder si = builder.delete(5, 5);
		System.out.println(si);
		StringBuilder s2 = builder.delete(5, 10);
		System.out.print(s2);
	}

}
