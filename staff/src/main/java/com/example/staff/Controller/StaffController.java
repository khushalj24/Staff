package com.example.staff.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.Model.Staff;
import com.example.staff.Service.StaffService;

@RestController
public class StaffController {

	@Autowired
	StaffService ser;
	
	//1
	@GetMapping("allstaff")
	public List<Staff> getstaff() {
		 List<Staff> list = ser.getstaff();
		 return list;
	 }
	//2
	@GetMapping("staffbyid/{staffid}")
	public Staff getstaffbyId(@PathVariable int staffid) {
		Staff staf = ser.getstaffbyId(staffid);
	          return staf;
	}
	//3	
	@PostMapping("insertstaff")
	public String insertstaff(@RequestBody Staff staff) {
		return ser.insertstaff(staff);
	}
	//4
	 @GetMapping("salmore")
	public List<Staff> getsalary() {
		List<Staff> list = ser.getsalary();
		 return list;
	}
	//5
	 @GetMapping("experen")
	 public List<Staff> getexper() {
			List<Staff> list = ser.getexper();
			return list;
		}
	 //===========================
	//6
	 @GetMapping("maxsal")
	 public List<Staff> maxsal() {
			List<Staff> lis = ser.maxsal();
			return lis;
		}
	 @GetMapping("maxsalary")
	 public List<Staff> maxsalary() {
			List<Staff> al = ser.maxsalary();
			return al;
		}
	 //==================================================
	 //7
	 @PostMapping("updatestaff")
	 public String updatestaff(@RequestBody Staff staff) {
		return  ser.updatestaff(staff);
	 }
	 //==============================
	 //8
	 @GetMapping("minexperen")
	 public List<Staff> minexper() {
			List<Staff> lis = ser.minexper();
			return lis;	
		}
	 @GetMapping("minexp")
	 public String minexp() {
			String ss =  ser.minexp();
			return ss;
		}
//=========================================
	 //9
	 @GetMapping("trainers")
	 public List<Staff> gettrainer() {
			List<Staff> li = ser.gettrainer();
			return li;
		}
	//10	
	 @GetMapping("nottrainer")
	 public List<Staff> nottrainer() {
			List<Staff> li = ser.nottrainer();
			return li;
}
	 @GetMapping("salary")
	 public List<Staff> salary(@RequestParam int low , int high) {
		List<Staff> li = ser.salary(low,high);
		 return li;
	 }
	 

	 
	 
	 
 }
