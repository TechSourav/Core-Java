package com.sourav.JDK8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CalculationServiceSupplier {
	
	/*private ICalculationService addition;
	private ICalculationService subs;
	private ICalculationService multi;
	
	private void taskCalculateExpressions(int x, int y) {
		addition = new AdditionCalculationService();
		subs = new SubstructionCalculationService();
		multi = new MultiplicationCalculationService();
		ExecutorService ex= Executors.newFixedThreadPool(3);
		CompletableFuture<Integer> result1= CompletableFuture.supplyAsync(()-> 	addition.calculate(x, y),ex);
		CompletableFuture<Integer> result2= CompletableFuture.supplyAsync(()-> 	subs.calculate(x, y),ex);
		CompletableFuture<Integer> result3= CompletableFuture.supplyAsync(()-> 	multi.calculate(x, y),ex);
		List<CompletableFuture<Integer>> lst = new ArrayList<>();
		lst.add(result1);
		lst.add(result2);
		lst.add(result3);
		for(CompletableFuture<Integer> task: lst) {
			task.whenComplete((result, exception)
	                -> 
	                {
	                    if (exception == null)
	                    {
	                        System.out.println(result);
	                    } else
	                    {
	                        task.completeExceptionally(exception);
	                        System.out.println(exception.getMessage());
	                    }
	        });
		}
		ex.shutdown();
	}*/
	
	public static void main(String[] args) {
		CalculationServiceSupplier cs = new CalculationServiceSupplier();
		List<String> tasks = new ArrayList<>();
		tasks.add("add");
		tasks.add("multi");
		tasks.add("subs");
		cs.taskCalculateExpressions(tasks,20,10);
	}
	
	private void taskCalculateExpressions(List<String> tasks, int x, int y) {
		CalculationService calc= new CalculationService();
		ExecutorService ex= Executors.newFixedThreadPool(3);
		List<CompletableFuture<Integer>> results= tasks.stream().map((task)->CompletableFuture.supplyAsync(()-> calc.execute(task,x,y),ex)).collect(Collectors.toList()); 
		CompletableFuture<List<Integer>> lst=CompletableFuture.allOf(results.toArray(new CompletableFuture[results.size()])).thenApply((result) ->  results.stream()
																													  .map(CompletableFuture::join)
																													  .collect(Collectors.toList()));
		
		try {
			lst.get().stream().forEach(System.out::println);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ex.shutdown();
	}

}
