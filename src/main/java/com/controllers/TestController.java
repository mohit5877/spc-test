package com.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public String sort(String numberString, Model model) {
		String[] strArr = numberString.split(",");
		int[] intarray = new int[strArr.length];
		int i = 0;
		for (String str : strArr) {
			intarray[i++] = Integer.parseInt(str);
		}
		model.addAttribute("str", sort(intarray));		
		return "sort";
	}

	public String sort(int[] listOfNum) {
		
		int noOfInt = listOfNum.length, temp, noOfPostionChanged = 0;		
		Date date1 = new Date();
		for (int i = 0; i < noOfInt; i++) {
			boolean flag = false;
			for (int j = i + 1; j < noOfInt; j++) {
				if (listOfNum[i] > listOfNum[j]) {
					temp = listOfNum[i];
					listOfNum[i] = listOfNum[j];
					listOfNum[j] = temp;
					flag = true;
				}
			}
			if (flag) {
				noOfPostionChanged++;
			}
		}
		Date date2 = new Date();
		StringBuilder stb = new StringBuilder();
		stb.append("Ascending Order : ");
		for (int i = 0; i < noOfInt; i++) {
			stb.append(listOfNum[i] + ",");
		}
		
		stb.append("<br>");
		stb.append("Total time in seconds : " + ((date2.getTime() - date1.getTime()) / 1000));
		stb.append("<br>");
		stb.append("Number of position changed : " + noOfPostionChanged);
		return stb.toString();
	}

}
