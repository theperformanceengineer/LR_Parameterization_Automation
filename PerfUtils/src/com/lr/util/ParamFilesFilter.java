package com.lr.util;

import java.io.*;

public class ParamFilesFilter implements FileFilter
{
	  private final String  ext_Prm = new String (".prm");
	  private final String  ext_Dat = new String (".dat");	  

	  public boolean accept(File file)
	  {	    
	     // if (file.getName().toLowerCase().endsWith(cextensions)&&(!((file.getName().startsWith("combined"))||(file.getName().startsWith("pre")))))
	      if (file.getName().toLowerCase().endsWith(ext_Prm)||file.getName().toLowerCase().endsWith(ext_Dat))	    	  
	      {
	        return true;
	      }
	      
	    return false;
	  }
	}