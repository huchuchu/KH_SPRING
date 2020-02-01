package com.test07;

public class SamsungTv implements TV {
	
	
	public SamsungTv() {
		System.out.println("SamsungTv 생성!!");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTv powerOn!!");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTv powerDown!!");

	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTv volume UP!!");

	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTv volume down!!");

	}

}
