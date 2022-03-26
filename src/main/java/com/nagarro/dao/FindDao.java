package com.nagarro.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Tshirts;
import com.opencsv.exceptions.CsvValidationException;

@Component
public class FindDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void readData(Tshirts details) throws IOException, CsvValidationException {
		Transaction t=null;
		try {
		Session ss=sessionFactory.openSession();
		t=ss.beginTransaction();
		ss.save(details);
		t.commit();
		ss.close();
		}
		catch(Exception e){
			if(t!=null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}
	@Transactional
	public void truncate() {
		Session ss=sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		try {
		Query q=ss.createQuery("delete from Tshirts");
		q.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		t.commit();
		ss.close();
		}
	}
	@Transactional
	public List<Tshirts> getResult(String clr, String size, String gen, String sortBy) {
		Transaction t=null;
		try {
		Session ss=sessionFactory.openSession();
		t=ss.beginTransaction();
		Query query=null;
		if(sortBy.equals("Price")) 
			query = ss.createQuery("from Tshirts where color=:clr and size=:size and gender=:gen order by price");
		else if(sortBy.equals("Rating"))
			query = ss.createQuery("from Tshirts where color=:clr and size=:size and gender=:gen order by rating");
		else
			query = ss.createQuery("from Tshirts where color=:clr and size=:size and gender=:gen order by price,rating ");
		query.setParameter("clr", clr);
		query.setParameter("size", size);
		query.setParameter("gen", gen);
		List<Tshirts> l=query.list();
		t.commit();
		ss.close();
		return l;
		} 
		catch(Exception e) {
			if(t!=null) {
				t.rollback();
		}
			e.printStackTrace();
		}

		return null;

	}
}
