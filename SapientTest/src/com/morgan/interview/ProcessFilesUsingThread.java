package com.morgan.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProcessFilesUsingThread {

	public static void main(String[] args){
		


	    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

	    ReadThread reader = new ReadThread(queue);
	    WriteThread writer = new WriteThread(queue);

	    new Thread(reader).start();
	    new Thread(writer).start();

	  
		
	}	
	
}

class ReadThread implements Runnable{

	BlockingQueue<String> bq;
	ReadThread(BlockingQueue<String> q){
		this.bq=q;
	}
	
	@Override
	public void run() {
	  BufferedReader br = null;
	  try{
		  
		  br = new BufferedReader(new FileReader(new File("./inputFile.txt")));
		  String buffer = null;
		  while(br.readLine()!=null){
			  bq.put(buffer);
		  }
		  bq.put("EOF");
		  
	  }catch (FileNotFoundException e) {

          e.printStackTrace();
      } catch (IOException e) {

          e.printStackTrace();
      } catch(InterruptedException e){

      }finally{
          try {
              br.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

		
		
	}
	
	
	
}



class WriteThread implements Runnable{

	BlockingQueue<String> bq;
	WriteThread(BlockingQueue<String> q){
		this.bq=q;
	}
	@Override
	public void run() {
	   PrintWriter  writer = null;
	   try{
		   writer = new PrintWriter("outputFile.txt");
		   while(true){
			   String buffer= bq.take();
			   if(buffer=="EOF"){
				   break;
			   }
			   writer.println(buffer);
		   }
		   
		   
	   }catch (FileNotFoundException e) {

	        e.printStackTrace();
	    } catch(InterruptedException e){

	    }finally{
	        writer.close();
	   
		
	}
	}	
}

