package com.bit.boot13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot13.model.DeptVo;
import com.bit.boot13.utils.JwtUtil;

@RestController
@RequestMapping("/")
public class ApiController {
	@Autowired
	JwtUtil jwtUtil;
	
	@GetMapping("/token")
	public String token() {
		return jwtUtil.createJwt();
	}
	
	@GetMapping("/api/dept")
	public ResponseEntity<?> getList(){
		return ResponseEntity.ok().body(
			List.of(
				DeptVo.builder().deptno(111).dname(null).loc("dd").build()
				,DeptVo.builder().deptno(111).dname(null).loc("dd").build()
				,DeptVo.builder().deptno(111).dname(null).loc("dd").build()
					));
	}
}
