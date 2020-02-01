package com.test07;

public class IgTv implements TV {
	
	public IgTv() {
		System.out.println("Ig Tv 생성!");
	}
	

	@Override
	public void powerOn() {
		System.out.println("IgTv powerOn!!");

	}

	@Override
	public void powerOff() {
		System.out.println("IgTv powerDown!!");

	}

	@Override
	public void volumeUp() {
		System.out.println("IgTv volume UP!!");

	}

	@Override
	public void volumeDown() {
		System.out.println("IgTv volume down!!");

	}

}
