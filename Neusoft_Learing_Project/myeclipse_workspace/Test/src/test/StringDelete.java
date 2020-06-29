package test;

public class StringDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "欢迎来到王者荣耀，敌军还有三秒到达站场碾碎他！";
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
