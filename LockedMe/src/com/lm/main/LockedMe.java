package com.lm.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LockedMe {

	static LockedMe lm = null;
	String projDir = null;
	final static String ETC = "etc";
	List<String> files;
	
	private LockedMe(String projDir) {
		this.projDir = projDir;
		
        File dir = new File(this.projDir);
      //Creating the directory
        if(!dir.exists()) {
        	if(!dir.mkdir()){
                System.out.println("Problem in creating directory.");
            }
        }
        
		
		this.files = new ArrayList<String>();
		
		
		File folder = new File(projDir);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    this.files.add(listOfFiles[i].getName());
		  } 
		}
		Collections.sort(this.files, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}
	
	public String getProjDir() {
		return projDir;
	}

	public void setProjDir(String projDir) {
		this.projDir = projDir;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public static LockedMe getInstance() {
		if(lm == null) {
			throw new IllegalStateException("LockedMe app is not initialized");
		}
		return lm;
	}
	
	public static void createInstance() {
		if(lm == null) {
			lm = new LockedMe(System.getProperty("user.dir") + "/" + ETC);
		}
	}

	public List<String> getFiles() {
		// TODO Auto-generated method stub
		return this.files;
	}
}
