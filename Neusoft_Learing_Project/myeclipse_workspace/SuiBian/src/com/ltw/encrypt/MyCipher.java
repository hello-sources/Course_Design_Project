package com.ltw.encrypt;

import java.security.*;
import javax.crypto.*;
import sun.misc.*;

public class MyCipher {	
	/**
	 * @param str 根据字符串设置密钥
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
	 * @param plaintexts明码数组
	 * @param str任意字符串，用于内部生成密钥
	 * @return 根据密钥返回明码数组
	 */
	private byte[] getEncrypt(byte[] plaintexts,String str) {
		Key key=getKeyt(str);
		byte[] ciphertexts = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			//利用加密模式和密钥初始化
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
	 * @param plaintext明文（明码）
	 * @param str任意字符串，用于内部生成密钥
	 * @return 返回加密后的密文（暗码）
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
	 * @param ciphertexts密文数组 
	 * @param str任意字符串，用于内部生成密钥
	 * @return 根据密钥返回密文数组
	 */
	private byte[] decrypt(byte[] ciphertexts,String str) {
		Key key=getKeyt(str);
		Cipher cipher;
		byte[] plaintexts = null;
		try {
			cipher = Cipher.getInstance("DES");			
			//利用解密模式和密钥初始化			
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
	 * @param ciphertext密文（暗码）
	 * @param str任意字符串，用于内部生成密钥
	 * @param      一定要与加密时的生成密钥的字符串一致，否则出现异常
	 * @return 返回解密后的明文（明码）    
	 */
	public String decrypt(String ciphertext,String str) {
		String plaintext = "";
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] bytes = base64De.decodeBuffer(ciphertext);
			byte[] ciphers = decrypt(bytes,str);
			plaintext = new String(ciphers, "UTF8");
		} catch (Exception e) {
			System.out.println(e.getMessage()+" 空指针异常！");
		}
		return plaintext;
	}
}