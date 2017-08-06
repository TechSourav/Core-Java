package com.sourav.designPattern.CarBuilder;

public interface CarPlan {
	
	public void setCarBase(String base);
	public void setCarRoof(String roof);
	public void setCarDoors(String doors);
	public void setCarWindows(String windows);
	public void setCarEngine(String engine);
	public void setCarWheel(String wheel);
	public void setCarSteering(String steering);

}
