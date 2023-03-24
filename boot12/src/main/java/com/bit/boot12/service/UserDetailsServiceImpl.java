package com.bit.boot12.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bit.boot12.domain.EmpRepo;
import com.bit.boot12.model.EmpVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	final EmpRepo empRepo;
	final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		EmpVo bean=empRepo.findByEname(ename).getEntity();
//		return User.builder()
//				.username(bean.getEname())
//				.password(passwordEncoder.encode(String.valueOf(bean.getEmpno())))
//				.authorities("USER")
//				.build();
		
		//추가적인 정보를 받아내기위해 DB에서 (주어지는 User로는 DB정보 mgr등 못가져옴 getter가 없어서
		//user를 상속해서 getter을 구현하자!!
		return new UserDetailsImpl(
				//기존에 있던 부분 유저명, 비번, 권한
				bean.getEname()
				,passwordEncoder.encode(String.valueOf(bean.getEmpno()))
				,List.of(new SimpleGrantedAuthority("USER"))
				//새로 추가한 정보!!
				,bean.getJob()
				,bean.getHiredate()
				,bean.getMgr()
				);
	}

}
