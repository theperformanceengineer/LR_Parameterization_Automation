package com.lr.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;

public class AutomateParameterization 
{
	static int counter=0;
	String fileName1;
	Scanner sc1;
	File sourceFolder,f2;
	File paramFiles[];

// Pass source and destination Loadrunner script folder paths	
public void copyParamFilesFromSource(String sFolder,String dFolder)
	{
		
		File sourceFolder=new File(sFolder);
		File destFolder=new File(dFolder);
		
			if (!((sourceFolder.isDirectory())&&(destFolder.isDirectory())))
			{
				System.out.println("Please enter valid Source and Destination Script Directories");
			}
		
			else
			{
				paramFiles=sourceFolder.listFiles(new ParamFilesFilter());	
				System.out.println("PRM & Dat files in Source Directory :");
				
				for (int i=0;i<paramFiles.length;i++)
				{
					System.out.println(paramFiles[i].getName());	
					String sourceAbsPath=(paramFiles[i].getAbsolutePath());					
					String destAbsPath=(dFolder+"\\"+paramFiles[i].getName());					
					Path source =Paths.get(sourceAbsPath);
					Path destination=Paths.get(destAbsPath);
						try {
								Path dest=	Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
								
								System.out.println("Files Copied to Destination folder :"+dest.toString());					

								if (dest.toString().endsWith(".prm")||dest.toString().endsWith(".PRM"))
								{
									System.out.println("Inside .prm check");		
									int parts=destination.getNameCount();
									String scriptFolder=destination.getName((parts-2)).toString();																										
									Path renamed=Files.move(destination, Paths.get(dFolder.toString()+"\\"+scriptFolder.toString()+".prm"),StandardCopyOption.REPLACE_EXISTING);																	
									System.out.println("destFile Abs Path after renaming:"+renamed.toString());
								}
							} catch (IOException e) 
							{								
								e.printStackTrace();
							}	
				}
			}	
			System.out.println("All .dat files and param files have been copied to the folder :"+ dFolder);
			System.out.println("Data files have been copied and .prm file has been renamed to the destination script folder name");
	}

public static void main (String args[]) throws Exception
	{
		//String s="C:\\LR\\LRUtils\\WebHttpHtml3";		
		//String d="C:\\LR\\LRUtils\\WebHttpHtml4";
		
		AutomateParameterization obj=new AutomateParameterization();
		obj.copyParamFilesFromSource(args[0],args[1]);
		System.out.println("-------------Done----------------");	
		
	}
}