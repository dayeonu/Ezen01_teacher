package polymorphism;

public class SoniTV  implements TV{

	@Override
	public void powerOn() {
		System.out.println("SoniTV---���� �Ҵ�.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SoniTV---���� ����.");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SoniTV---�Ҹ� �ø���.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SoniTV---�Ҹ� ������.");
	}

}
