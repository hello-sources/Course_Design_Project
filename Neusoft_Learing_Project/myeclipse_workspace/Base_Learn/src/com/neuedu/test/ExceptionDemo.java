package com.neuedu.test;

public class ExceptionDemo extends Object{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		java.lang.Object obj;
		Exception ex;//堆，栈（动态）
		try{
			int i = 0;
			i = i / 0;//数学异常
			System.out.println(i); 
		}catch(ArithmeticException e){   
			e.printStackTrace();
		}catch(NullPointerException e){
			
		}catch(NumberFormatException e){
			
		}finally{
			int i = 0;
			if(i == 0){
				throw new Exception("不是合法数据!");
			}
			System.out.print("hello");
		}
	}

}
