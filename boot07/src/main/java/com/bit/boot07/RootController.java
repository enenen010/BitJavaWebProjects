package com.bit.boot07;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;

import com.bit.boot07.config.EchoHandler;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RootController {
	
	final WebSocketHandler webSocketHandler;

	@GetMapping("/ex01")
	public String ex01(HttpSession session,String id) throws Exception {
		session.setAttribute("user", "admin");
		session.setAttribute("sid", session.getId());
		System.out.println("컨트롤러 실행");
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(HttpSession session) throws IOException {
		System.out.println("2 controller sessionID:"+session.getId());
		Map<String, WebSocketSession> list = null;
		list=((EchoHandler)webSocketHandler).getList();
		
		//ex: 메일이 온것을 나에게 알려주는(서버에서 원할때 보내는 메시지)
		list.get(session.getId()).sendMessage(new TextMessage("나한테 전송"));
		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03(HttpSession session) {
		session.invalidate();
		return "ex03";
	}
}
