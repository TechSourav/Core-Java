package com.sourav.java.SortingSearching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExternalSort {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length>2){
			System.out.println("Please provide input and output file names..");
		}
		String inputFile = args[0];
		String outputFile = args[1];
		
		List<File>fl = sortInBatch(new File(inputFile));
		//mergeSortFiles(fl,outputFile);
	}
	private static long estimateBestSizeOfBlock(File f){
		long len=f.length();
		final int maxTempFiles = 1024;
		long blockSize= len/maxTempFiles;
		long freeMem= Runtime.getRuntime().freeMemory();
		if(blockSize<freeMem/2)
			blockSize=freeMem/2;
		else{
			if(blockSize>=freeMem)
				System.err.println("We expect to run out of memory. ");
		}
		return blockSize;
	}
	public static List<File> sortInBatch(File f) throws IOException{
		List<File> files = new ArrayList<File>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		long blockSize = estimateBestSizeOfBlock(f);
		
		try{
			List<String> tmpList = new ArrayList<String>();
			String line ="";
			try{
				while(line!=null){
					long currentBlockSize=0;
					while((currentBlockSize<blockSize) && ((line=br.readLine())!=null)){
						tmpList.add(line);
						currentBlockSize += line.length();
					}
					files.add(sortAndSave(tmpList));
					tmpList.clear();
				}
			}catch(EOFException excp){
				if(tmpList.size()>0){
					files.add(sortAndSave(tmpList));
					tmpList.clear();
				}
			}
		}finally{
			br.close();
		}
		
		   return files;
	}

	public static File sortAndSave(List<String> tmp) throws IOException{
		Collections.sort(tmp);
		File newTmpFile= File.createTempFile("","");
		newTmpFile.deleteOnExit();
		BufferedWriter bw = new BufferedWriter(new FileWriter(newTmpFile));	
		try{
			for(String s: tmp){
				bw.write(s);
				bw.newLine();
			}
		}finally{
			bw.close();
		}
		return newTmpFile;
		
	}
	
	public static void mergeSortFiles(File fl, String outputFile){
		
		
		
	}
	
	class BinaryFileBuffer{
		
	}
	
}



