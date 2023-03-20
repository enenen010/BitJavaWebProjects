package com.bit.sts08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	String path="D:\\webspace\\sts08\\up\\";
	
	@GetMapping("/")
	public String index() {
		System.out.println("controller..");
		return "home";
		}
	
	@ResponseBody
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
//	public void upload(@RequestParam("file1") MultipartFile file) {
//	public void upload(@RequestParam MultipartFile file1) {
	public void upload(MultipartFile file1,HttpServletRequest req) throws IOException{
		String msg=System.currentTimeMillis()+"_";
		System.out.println(path+msg+file1.getOriginalFilename());
		File f=new File(path+msg+file1.getOriginalFilename());
		file1.transferTo(f);
	}
	
	@GetMapping("/down")
	public void down(Model model,String fname) {
		model.addAttribute("fname", fname);
;	}
	
	@GetMapping("/load")
	public void download(String fname,HttpServletResponse res) throws FileNotFoundException, IOException {
		File f=new File(path+fname);
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition","attachment; filename="
				+fname.substring(fname.indexOf('_')+1));
		try(
				InputStream is=new FileInputStream(f);
				OutputStream os=res.getOutputStream();
				){
			int su=-1;
			while((su=is.read())!=-1) os.write(su);
		}
	}
	
	@GetMapping("/load/{fname:.+}")
	public void download2(@PathVariable("fname") String fname,HttpServletResponse res) throws FileNotFoundException, IOException {
		File f=new File(path+fname);
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition","attachment; filename="
				+fname.substring(fname.indexOf('_')+1));
		try(
				InputStream is=new FileInputStream(f);
				OutputStream os=res.getOutputStream();
				){
			int su=-1;
			while((su=is.read())!=-1) os.write(su);
		}
	}
}








