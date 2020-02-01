package com.test03;

import org.springframework.stereotype.Component;

@Component
public class IgTv implements TV {


	@Override
	public void powerOn() {
		System.out.println("IgTv powerOn!!!");

	}

	@Override
	public void powerOff() {
		System.out.println("IgTv powerOff!!!");

	}

	@Override
	public void volumeUp() {
		System.out.println("IgTv volumUp!!!");

	}

	@Override
	public void volumeDown() {
		System.out.println("IgTv volumDown!!!");

	}

}
