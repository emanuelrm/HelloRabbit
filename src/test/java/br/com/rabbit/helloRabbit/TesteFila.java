package br.com.rabbit.helloRabbit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class TesteFila {
	
	@BeforeClass
	public static void iniciarConsumidor() {
		Recv recv = new Recv();
		recv.receberMensagemFila();
	}

	@Test
	public void enviarMensagem() {
		Send send = new Send();
		assertEquals(Boolean.TRUE, send.enviarMensagemFila("Teste"));
	}
	
	@Test
	public void iniciarOutroConsumidor() {
		Recv recv2 = new Recv();
		recv2.receberMensagemFila();
	}
	
	@Test
	public void enviarOutraMensagem() {
		Send send = new Send();
		assertEquals(Boolean.TRUE, send.enviarMensagemFila("Teste1"));
	}
	
//	@Test
//	public void enviarMensagens() {
//		Send send = new Send();
//		
//		System.out.println(new Date());
//		
//		for (int i = 0; i < 100000; i++) {
//			assertEquals(Boolean.TRUE, send.enviarMensagemFila("Teste" + i));
//		}
//		
//		System.out.println(new Date());
//	}
}
