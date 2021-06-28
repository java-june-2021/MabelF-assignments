package com.codingdojo.displaydate.displaydatecontrollers;


import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controller render links no view to view links

@Controller
public class DisplayDateController {
	// This will be on localhost:8080
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String stringDate = sdf.format(new Date());
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		String stringDate2 = sdf2.format(new Date());
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("MMMM");
		String stringDate3 = sdf3.format(new Date());
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy");
		String stringDate4 = sdf4.format(new Date());
		
		model.addAttribute("datestring", stringDate+ ", the "+stringDate2 +" of " + stringDate3 + ", " + stringDate4);
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa"); //Lowercase h is the 12-hour clock
		String stringDate = sdf.format(new Date());
		
		model.addAttribute("timestring", stringDate);
		return "time.jsp";
	}

}


