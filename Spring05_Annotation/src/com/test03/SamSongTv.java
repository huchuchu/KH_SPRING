package com.test03;

import org.springframework.stereotype.Component;

@Component
public class SamSongTv implements TV {
	


	@Override
	public void powerOn() {
		System.out.println("samsongTv powerOn!!!");

	}

	@Override
	public void powerOff() {
		System.out.println("samsongTv powerOff!!!");

	}

	@Override
	public void volumeUp() {
		System.out.println("samsongTv volumeUp!!!");

	}

	@Override
	public void volumeDown() {
		System.out.println("samsongTv volumeDown!!!");

	}

}
