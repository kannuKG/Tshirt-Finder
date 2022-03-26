package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import com.nagarro.dao.FindDao;
import com.nagarro.model.Tshirts;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class FindService {

	@Autowired
	FindDao findDao;
	
	public List<Tshirts> getSearchResult(String clr, String size, String gen,String sortBy) throws CsvValidationException, IOException {
		return findDao.getResult(clr,size,gen,sortBy);
	}
	
	public void readData() throws CsvValidationException, IOException {
			File folder=new File("C:\\Users\\kanishkgusain\\eclipse-workspace\\SpringAssignment\\Files");
			File[] files=folder.listFiles();
			for(File f:files) {
				if(f.getName().endsWith("csv")) {
					FileReader fr=new FileReader(f);
					CSVReader cr=new CSVReader(fr);
					String[] ar=cr.readNext();
					while((ar=cr.readNext())!=null) {	//reading csv data and parsing it to object
						Tshirts t=new Tshirts();
						t.setID(ar[0]);
						t.setName(ar[1]);
						t.setColor(ar[2]);
						t.setGender(ar[3]);
						t.setSize(ar[4]);
						t.setPrice(Float.parseFloat(ar[5]));
						t.setRating(Float.parseFloat(ar[6]));
						t.setAvailability(ar[7]);
						findDao.readData(t);
					}
				}
			}
	}
	
	public void truncateData() {
		findDao.truncate();
	}
}
