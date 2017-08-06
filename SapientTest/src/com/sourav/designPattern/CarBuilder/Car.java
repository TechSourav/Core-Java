package com.sourav.designPattern.CarBuilder;

public class Car implements CarPlan{
	
	private String base;
	private String roof;
	private String doors;
	private String windows;
	private String engine;
	private String wheel;
	private String steering;
	
	@Override
	public void setCarBase(String base) {
		// TODO Auto-generated method stub
		this.base=base;
	}
	@Override
	public void setCarRoof(String roof) {
		// TODO Auto-generated method stub
		this.roof=roof;
	}
	@Override
	public void setCarDoors(String doors) {
		// TODO Auto-generated method stub
		this.doors=doors;
	}
	@Override
	public void setCarWindows(String windows) {
		// TODO Auto-generated method stub
		this.windows=windows;
	}
	@Override
	public void setCarEngine(String engine) {
		// TODO Auto-generated method stub
		this.engine=engine;
	}
	@Override
	public void setCarWheel(String wheel) {
		// TODO Auto-generated method stub
		this.wheel=wheel;
	}
	@Override
	public void setCarSteering(String steering) {
		// TODO Auto-generated method stub
		this.steering=steering;
	}

	public String getBase() {
		return base;
	}
	public String getRoof() {
		return roof;
	}
	public String getDoors() {
		return doors;
	}
	public String getWindows() {
		return windows;
	}
	public String getEngine() {
		return engine;
	}
	public String getWheel() {
		return wheel;
	}
	public String getSteering() {
		return steering;
	}
	
}
