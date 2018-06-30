package com.sourav.java.Thread;

public class ThreeThreadSynchronization {

	  public static State currentState = State.ONE;
	  public static Object lockObject = new Object();

	  public static void main(String[] args) {
	    Thread t1 = new Thread(new MyRunnable(State.ONE));
	    Thread t2 = new Thread(new MyRunnable(State.TWO));
	    Thread t3 = new Thread(new MyRunnable(State.THREE));
	    t1.start();
	    t2.start();
	    t3.start();

	  }

	}

	class MyRunnable implements Runnable {

	  State allowedState;

	  public MyRunnable(State allowedState) {
	    this.allowedState = allowedState;
	  }

	  @Override
	  public void run() {
	    for (int i = 0; i < 10; i++) {
	      synchronized (ThreeThreadSynchronization.lockObject) {

	        while (allowedState != ThreeThreadSynchronization.currentState) {
	          try {
	            ThreeThreadSynchronization.lockObject.wait();
	          } catch (InterruptedException e) {
	            e.printStackTrace();
	          }
	        }

	        System.out.println(Thread.currentThread().getName() +" : "+ allowedState.getVal());
	        ThreeThreadSynchronization.currentState = ThreeThreadSynchronization.currentState.nextState();
	        ThreeThreadSynchronization.lockObject.notifyAll();
	      }
	    }

	  }

	}

	enum State {
	  ONE(1) {
	    @Override
	    public State nextState() {
	      return TWO;
	    }

	  },
	  TWO(2) {
	    @Override
	    public State nextState() {
	      return THREE;
	    }
	  },
	  THREE(3) {
	    @Override
	    public State nextState() {
	      return ONE;
	    }
	  };

	  private int val;

	  State(int val) {
	    this.val = val;
	  }

	  public abstract State nextState();

	  public int getVal() {
	    return val;
	  }
	}