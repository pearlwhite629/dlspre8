package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Purpose;
import com.example.demo.entity.PurposeExample;
import com.example.demo.entity.Rsv;
import com.example.demo.form.RsvForm;
import com.example.demo.mapper.PurposeMapper;
import com.example.demo.mapper.RsvMapper;

@Controller
public class IndexController {
	@Autowired
	RsvMapper rsvMapper;
	@Autowired
	PurposeMapper purposeMapper;
	
	public RsvForm createForm() {
		return new RsvForm();
	}

//	@GetMapping("/reserve")
//	public String reserve(Model model) {
//		Reserve reserve = reserveMapper.selectByPrimaryKey(1);
//		model.addAttribute("msg", reserve.getMenu());
//		return "reserve";
//	}
	@GetMapping("/signup")
	public String getSignUp(Model model) {
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(Model model) {
		return "redirect:/login";
	}
	
	@GetMapping("login")
	public String getLogin(Model model) {
		return "login/login";
	}	
	@PostMapping("login")
	public String postLogin(Model model) {
		return "redirect:/rsv";
	}
	
	@RequestMapping("/rsv")
	public String rsv(RsvForm rsvForm, Model model) {
		
		PurposeExample purposeExample = new PurposeExample();
		purposeExample.setOrderByClause("id");
		List<Purpose> purposeList = purposeMapper.selectByExample(purposeExample);
		model.addAttribute("purposes", purposeList);
		
		return "rsv";
	}
	@RequestMapping("/confirm")
	public String confirm(RsvForm rsvForm, Model model) {
		return "confirm";
	}
	@RequestMapping("/menu")
	public String menu(RsvForm rsvForm, Model model) {
		return "menu";
	}
	@RequestMapping("/save")
	public String save(RsvForm rsvForm, Model model) {
//		contactテーブルに登録するために、フォームの情報としてContactクラスのインスタンスを生成します。
		Rsv rsv = new Rsv();
		
//		フォームの情報をセットしていきます。
//		rsv.setDateDay(rsvForm.getDate_day());
//		rsv.setCountHeads(rsvForm.getCount_heads());
//		rsv.setMenu(rsvForm.getMenu());
		rsv.setDate(rsvForm.getDate_day());
		rsv.setTime(rsvForm.getDate_time());
		rsv.setCountHeads(rsvForm.getCount_heads());
		rsv.setPurpose(rsvForm.getPurpose());

		rsvMapper.insert(rsv);

		return "complete";
//		return "redirect:/rsv";
	}
}
