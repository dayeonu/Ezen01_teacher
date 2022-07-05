package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	//@Autowired
	//@Qualifier("appleSpeaker")
	@Resource(name="sony")
	private Speaker speaker;
	//private Speaker sp = new AppleSpeaker(); 
	private int  price;
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeakerȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("setPriceȣ��");
		this.price = price;
	}
	
	public SamsungTV() {
		System.out.println("samsungTV ������(default)");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("samsungTV ������(1��)");
		this.speaker  = speaker;
	}
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("samsungTV ������(2��)");
		this.speaker  = speaker;
		this.price  = price;
	}
	public void powerOn() {
		System.out.print("SamsungTV---���� �Ҵ�.");
		speaker.volumeUp();
	}
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}

	public void volumeUp() {
		System.out.println("SamsungTV---�Ҹ� �ø���.");
	}

	public void volumeDown() {
		System.out.println("SamsungTV---�Ҹ� ������.");
	}
}
