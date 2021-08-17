package com.spring.batch.cobertura.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class Decryptor {
	
	public String stringDecrypt(String text,String password)
	{
		BasicTextEncryptor textEncryptor= new BasicTextEncryptor();
		textEncryptor.setPassword(password);
		return textEncryptor.decrypt(text);
	}

}
