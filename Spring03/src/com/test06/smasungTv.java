package com.test06;

public class smasungTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("Samsung tv power on!");

	}

	@Override
	public void powerOff() {
		System.out.println("Samsung tv power off!");

	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung tv volume up!");

	}

	@Override
	public void volumeDown() {
		System.out.println("Samsung tv volume down!");

	}

}
