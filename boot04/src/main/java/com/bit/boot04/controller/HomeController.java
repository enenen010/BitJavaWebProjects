package com.bit.boot04.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.boot04.model.DeptVo;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		// Tbody, hearder, httpstatus 매개변수  제네릭으로 설정한게 body의 자료형 그래서 Tbody: 
//		ResponseEntity resp=new ResponseEntity<>("성공",HttpStatus.OK);
//		ResponseEntity resp=new ResponseEntity<>(new ArrayList(),HttpStatus.OK);
		
		// ?: 인스턴스의 제네릭을 따라가겠다
//		if(true)
//		return new ResponseEntity<DeptVo>(
//			DeptVo.builder().deptno(1111).dname("tester").loc("test").build(),HttpStatus.OK);
//		return ResponseEntity.ok(
//			DeptVo.builder().deptno(1111).dname("tester").loc("test").build());
		return ResponseEntity.status(HttpStatus.OK).body(
			DeptVo.builder().deptno(1111).dname("tester").loc("test").build());
	}
}
