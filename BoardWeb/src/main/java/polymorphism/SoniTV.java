package polymorphism;

public class SoniTV  implements TV{

	public SoniTV() {
		System.out.println("sony");
	}
	@Override
	public void powerOn() {
		System.out.println("SonyTV---���� �Ҵ�.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV---���� ����.");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SonyTV---�Ҹ� �ø���.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---�Ҹ� ������.");
	}

}
