package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("SonySpeak ������");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeak ....�Ҹ� �︰��.");
	}
	public void volumeDown() {
		System.out.println("SonySpeak ....�Ҹ� ������.");
	}
}
