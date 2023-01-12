package com.example.staff.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.staff.Model.Staff;

@Repository
public class StaffDao {
    
	@Autowired 
	SessionFactory sf;
	
	public List<Staff> getstaff() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = criteria.list();
		session.close();
		 return list;
	}

	public Staff getstaffbyId(int staffid) {
		Session session = sf.openSession();
		Staff staf = session.get(Staff.class, staffid);
		session.close();
		return staf;
		
	}

	public String insertstaff(Staff staff) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(staff);
		tr.commit();
		session.close();
		return "Data inserted";	
	}
	
	public List<Staff> getsalary() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
	    criteria.add(Restrictions.gt("salary", 20000));
	    List<Staff> list = criteria.list();
	    session.close();
	    return list;
	}
	
	public List<Staff> getexper() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
	    criteria.add(Restrictions.between("experience",10,20));
	    List<Staff> list = criteria.list();
	    session.close();
	    return list;
	}
    //===============================================
	public List<Staff> maxsal() {
	Session session = sf.openSession();
	String query = "select staffid,name,profile,salary,experience from Staff where salary =(select max(salary) from Staff)";
	List<Staff> list = session.createQuery(query).list();
	 session.close();
	return list;
	}
	
	public List<Staff> maxsalary() {
	Session session = sf.openSession();
	Criteria cr = session.createCriteria(Staff.class);
	cr.addOrder(Order.desc("salary"));
	cr.setMaxResults(1);
	List<Staff> lis = cr.list();
	 return lis;
	}
	//==========================================

	public String updatestaff(Staff staff) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(staff);
		tr.commit();
		session.close();
		return "Data updated";	
	}
	//==========================================================
	public List<Staff> minexper() {
	Session session = sf.openSession();
	String query = "select name from Staff where experience =(select min(experience)from Staff)";
	List<Staff> list = session.createQuery(query).list();
	 session.close();
	return list;
	}
	
	
	public String minexp() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Staff.class);
		cr.addOrder(Order.asc("experience"));
		cr.setMaxResults(1);
		List<Staff> lis = cr.list();
		String ss = null;
		for(Staff staff: lis) {
			ss = staff.getName();
		}
		session.close();
		return ss;
	}
	//==========================================
	public List<Staff> gettrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile","trainer"));
		 List<Staff> list = criteria.list();
		    session.close();
		    return list;
	}
	public List<Staff> nottrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile","trainer"));
		 List<Staff> list = criteria.list();
		    session.close();
		    return list;
	}

	public List<Staff> salary(int low, int high) {
	    Session session = sf.openSession();
	    Criteria criteria = session.createCriteria(Staff.class);
	    criteria.add(Restrictions.between("salary", low, high));
		
	    List<Staff> li = criteria.list();
	    return li;
	}
	
	
	
	
}
