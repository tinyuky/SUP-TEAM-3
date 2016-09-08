package com.websystique.springsecurity.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.websystique.springsecurity.model.FileBucket;
import com.websystique.springsecurity.model.Product;
import com.websystique.springsecurity.service.ProductService;
import com.websystique.springsecurity.util.FileValidator;

@Controller
public class HelloWorldController {
	private static String location = System.getProperty("user.dir");

	private static String UPLOAD_LOCATION = location;

	@Autowired
	FileValidator fileValidator;

	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@Autowired
	ProductService productService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		List<Product> users = productService.findAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Product product = new Product();
		FileBucket fileBucket = new FileBucket();
		model.addAttribute("employee", product);
		model.addAttribute("fileBucket", fileBucket);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid FileBucket fileBucket, BindingResult resultfile, ModelMap model)
			throws IOException {

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be
		 * implementing custom @Unique annotation and applying it on field [ssn]
		 * of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 * 
		 */
		Product employee = new Product();
		if (resultfile.hasErrors()) {
			return "registration";
		}
		if (fileBucket.getFile().getSize() != 0) {
			FileCopyUtils.copy(fileBucket.getFile().getBytes(),
					new File(UPLOAD_LOCATION, fileBucket.getFile().getOriginalFilename()));
			employee.setHinh(UPLOAD_LOCATION + "\\" + fileBucket.getFile().getOriginalFilename());		
		}
		
		try {
			employee.setTen(new String(fileBucket.getTen().getBytes("ISO-8859-1"), "UTF-8"));
			employee.setDiachi(new String(fileBucket.getDiachi().getBytes("ISO-8859-1"), "UTF-8"));
			employee.setSdt(fileBucket.getSdt());
			employee.setGia1(fileBucket.getGia1());
			employee.setGia2(fileBucket.getGia2());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		productService.Add(employee);


		return "redirect:/admin";
	}

	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		productService.Delete(id);
		return "redirect:/admin";
	}

	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable int id, ModelMap model) {
		Product product = productService.findById(id);
		FileBucket fileBucket = new FileBucket();
		fileBucket.setTen(product.getTen());
		fileBucket.setDiachi(product.getDiachi());
		fileBucket.setSdt(product.getSdt());
		fileBucket.setGia1(product.getGia1());
		fileBucket.setGia2(product.getGia2());
		model.addAttribute("fileBucket", fileBucket);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.POST)
	public String updateProduct(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,
			@PathVariable int id) throws IOException {

		if (result.hasErrors()) {
			return "registration";
		}
		 
		Product employee = new Product();
		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "registration";
		}
		if (fileBucket.getFile().getName() != "") {
			FileCopyUtils.copy(fileBucket.getFile().getBytes(),
					new File(UPLOAD_LOCATION, fileBucket.getFile().getOriginalFilename()));
			employee.setHinh(UPLOAD_LOCATION + "\\" + fileBucket.getFile().getOriginalFilename());
		}

		try {
			employee.setTen(new String(fileBucket.getTen().getBytes("ISO-8859-1"), "UTF-8"));
			employee.setDiachi(new String(fileBucket.getDiachi().getBytes("ISO-8859-1"), "UTF-8"));
			employee.setSdt(fileBucket.getSdt());
			employee.setGia1(fileBucket.getGia1());
			employee.setGia2(fileBucket.getGia2());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		productService.updateProduct(employee);

		model.addAttribute("success", "Cơ sở " + employee.getTen() + " chỉnh sửa thành công");
		model.addAttribute("loggedinuser", getPrincipal());

		return "registrationsuccess";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}