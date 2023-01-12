package com.example.staff.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staff.Dao.StaffDao;
import com.example.staff.Model.Staff;

@Service
public class StaffService {

	 @Autowired
	 StaffDao dao;
	 
	 public List<Staff> getstaff() {
		 List<Staff> list = dao.getstaff();
		 return list;
	 }

	public Staff getstaffbyId(int staffid) {
	  Staff staf = dao.getstaffbyId(staffid);
		return staf;
	}

	public String insertstaff(Staff staff) {
	return	dao.insertstaff(staff);
		
	}
	 
	public List<Staff> getsalary() {
		List<Staff> list = dao.getsalary();
		 return list;
	
	}
	
	public List<Staff> getexper() {
		List<Staff> list = dao.getexper();
		return list;
	}
	//=====================================
	public List<Staff> maxsal() {
		List<Staff> lis = dao.maxsal();
		return lis;
	}
	
	public List<Staff> maxsalary() {
		List<Staff> al = dao.maxsalary();
		return al;
	}
	
//=========================================
	public String updatestaff(Staff staff) {
	return 	dao.updatestaff(staff);	
	}
	//================================
	public List<Staff> minexper() {
		List<Staff> lis = dao.minexper();
		return lis;	
	}
	
	public String minexp() {
		String ss =  dao.minexp();
		return ss;
	}
	//=================================
	public List<Staff> gettrainer() {
		List<Staff> li = dao.gettrainer();
		return li;
	}
	
	public List<Staff> nottrainer() {
		List<Staff> li = dao.nottrainer();
		return li;
	}

	public List<Staff> salary(int low, int high) {
	List<Staff> li = dao.salary(low,high);
		return li;
	}
	
	
	
	
	
	
	
}
