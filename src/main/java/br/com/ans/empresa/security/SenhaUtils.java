package br.com.ans.empresa.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
	/**
	 * Gera um hash usando BCrypt.
	 * Classes estáticas podem ser chamadas a qualquer momento.
	 * 
	 * @param senha
	 * @return
	 */
	public static String gerarBCryit(String senha) {
		
		if(senha == null) {
			
			return senha;
			
		}
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	}
	
	/**
	 * Verifica se a senha é válida.
	 * 
	 * @param senha
	 * @param senhaEncoded
	 * @return
	 */
	public static boolean senhaValida(String senha, String senhaEncoded) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(senha, senhaEncoded);
		
	}

}
