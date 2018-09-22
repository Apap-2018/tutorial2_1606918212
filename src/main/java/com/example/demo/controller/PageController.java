package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model) {
//		model.addAttribute("name",name);
//		return "challenge";
//	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath (@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model) {		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		String hm = "hm";
		int intA = Integer.parseInt(a);
		if (intA > 1) {
			for (int i = 0; i < intA-1; i++) {
				hm += 'm';
			}
		}
		hm += " ";	
		String kata = hm;
		int intB = Integer.parseInt(b);
		if (intB > 1) {
			for (int i = 0; i < intB-1; i++) {
				kata += hm;
			}
		}
		
		model.addAttribute("kata", kata);
		return "generator";
	}

}
