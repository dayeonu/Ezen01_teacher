package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV  implements TV {
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("LgTV ������");
	}
	public LgTV(Speaker speaker, int price) {
		System.out.println("LgTV ������");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�." + " ���� :  " + price);
		
	}

	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}

	public void volumeUp() {
		System.out.println("LgTV---�Ҹ� �ø���.");
	}

	public void volumeDown() {
		System.out.println("LgTV---�Ҹ� ������.");
	}
}
