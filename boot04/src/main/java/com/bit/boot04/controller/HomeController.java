package com.bit.boot04.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.bit.boot04.model.DeptVo;
import com.bit.boot04.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class HomeController {
   private final DeptService deptService;

   @GetMapping
   public List<?> home() {
      return deptService.selectAll();
   }

   @PostMapping
   public ResponseEntity<?> add(@ModelAttribute("bean") DeptVo bean) {
      try {
         deptService.insertOne(bean);
      } catch (Exception e) {
         return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok().build();
   }

   @GetMapping("/{deptno}")
   public ResponseEntity<?> detail(@PathVariable int deptno) {
      DeptVo bean = deptService.selectOne(deptno);
      if (bean != null)
         return ResponseEntity.ok(bean);
      return ResponseEntity.notFound().build();
   }
   
   @PutMapping("/{deptno}")
//   public ResponseEntity<?> edit(@ModelAttribute("bean") DeptVo bean){
   public ResponseEntity<?> edit(@RequestBody DeptVo bean, HttpServletRequest req) throws URISyntaxException{
      if(deptService.updateOne(bean)>0) {
         RestTemplate template = new RestTemplate();
         URI url =  new URI(req.getRequestURL().toString());         // Resttemplate를 이용해 컨트롤러에서 또 다른 접속을 만들어냄
         RequestEntity param = new RequestEntity(HttpMethod.GET, url);
         return template.exchange( param, DeptVo.class);
         }
      return ResponseEntity.notFound().build();
         
   }
   
   
   //delete는 attribute나 reqbody로 값이 안받아짐
   @DeleteMapping("/{deptno}")
   public ResponseEntity<?> delete(@PathVariable("deptno") int deptno){
      if(deptService.deleteOne(deptno)>0)
         return ResponseEntity.ok().build();
      return ResponseEntity.internalServerError().build();
   }
   
//   @GetMapping
//   public ResponseEntity<?> index(){
//      log.debug("index");
//
////      if(true)
////      return ResponseEntity.ok(DeptVo.builder().deptno(1111).dname("testet").loc("test").build());
//      return ResponseEntity.status(HttpStatus.OK).body(DeptVo.builder().deptno(1111).dname("testet").loc("test").build());
//   }
//   
}