package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker  implements Speaker{

	public AppleSpeaker() {
		System.out.println("AppleSpeak ������");
	}
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker �Ҹ� �︰��.");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker �Ҹ� ������.");
	}

}
