package Reflect_train;

import java.lang.reflect.Constructor;

public class Test_Constructor {

	/**
	 * author :����ΰ
	 * time :2019/7/9
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//ע������Դ�getDeclaredConstructors(���еĹ��췽��),��getDeclaredConstructor(��ȡĳ��������˽�еģ����췽��)
		//�Լ�getConstructor(Ĭ�ϻ�ȡĳ�����еĹ��췽��) getConstructors(��ȡ���й��еĹ��췽��)֮�䲻ͬ������
		String str = "Reflect_train.Student";
		Class cla = Class.forName(str);
		
		Constructor[] con = cla.getDeclaredConstructors();
		for(Constructor c :con){
			System.out.println(c);
		}
		
		
		//�����޲����Ĺ��췽������������һ��null����дҲ���ԣ�
		//���ص�����������޲ι��캯���������
		Constructor con1 = cla.getConstructor(null);
		System.out.println("con1 = "+con1);
		Object obj = con1.newInstance();

		
		Constructor con2 = cla.getDeclaredConstructor(float.class);
		System.out.println(con2);
		//setAccessible�ǲ��ñ����ƽ�ķ�������ȡ˽�����Ȩ�޵�
		con2.setAccessible(true);
		obj = con2.newInstance(182.2f);
		//System.out.println(182.20);
	}

}
