package test;

public class StringDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "��ӭ����������ҫ���о��������뵽��վ����������";
		StringBuilder builder = new StringBuilder(S);
		System.out.println(builder.length());
		System.out.println(builder);
		for(int i = 0;i <S.length();i++){
			for(int j = 0;j < S.length();j++){
				if(S.charAt(i) == S.charAt(j)){
					builder.deleteCharAt(j);
				}
			}
		}
		System.out.println(builder);
		System.out.print(builder.length());
	}

}
