package com.ltw.encrypt;

import java.security.*;
import javax.crypto.*;
import sun.misc.*;

public class MyCipher {	
	/**
	 * @param str �����ַ���������Կ
	 */
	private Key getKeyt(String str) {
		Key keyt=null;
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(str.getBytes()));
			keyt = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyt;
	}
	/**
	 * @param plaintexts��������
	 * @param str�����ַ����������ڲ�������Կ
	 * @return ������Կ������������
	 */
	private byte[] getEncrypt(byte[] plaintexts,String str) {
		Key key=getKeyt(str);
		byte[] ciphertexts = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			//���ü���ģʽ����Կ��ʼ��
			cipher.init(Cipher.ENCRYPT_MODE, key);
			ciphertexts = cipher.doFinal(plaintexts);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return ciphertexts;
	}
	/**
	 * @param plaintext���ģ����룩
	 * @param str�����ַ����������ڲ�������Կ
	 * @return ���ؼ��ܺ�����ģ����룩
	 */
	public String encrypt(String plaintext,String str) {
		String ciphertext = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] plaintexts = plaintext.getBytes("UTF8");
			byte[] ciphers = getEncrypt(plaintexts,str);
			ciphertext = base64en.encode(ciphers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ciphertext;
	}

	/**
	 * @param ciphertexts�������� 
	 * @param str�����ַ����������ڲ�������Կ
	 * @return ������Կ������������
	 */
	private byte[] decrypt(byte[] ciphertexts,String str) {
		Key key=getKeyt(str);
		Cipher cipher;
		byte[] plaintexts = null;
		try {
			cipher = Cipher.getInstance("DES");			
			//���ý���ģʽ����Կ��ʼ��			
			cipher.init(Cipher.DECRYPT_MODE, key);
			plaintexts = cipher.doFinal(ciphertexts);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			cipher = null;
		}
		return plaintexts;
	}
    
	/**
	 * @param ciphertext���ģ����룩
	 * @param str�����ַ����������ڲ�������Կ
	 * @param      һ��Ҫ�����ʱ��������Կ���ַ���һ�£���������쳣
	 * @return ���ؽ��ܺ�����ģ����룩    
	 */
	public String decrypt(String ciphertext,String str) {
		String plaintext = "";
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] bytes = base64De.decodeBuffer(ciphertext);
			byte[] ciphers = decrypt(bytes,str);
			plaintext = new String(ciphers, "UTF8");
		} catch (Exception e) {
			System.out.println(e.getMessage()+" ��ָ���쳣��");
		}
		return plaintext;
	}
}