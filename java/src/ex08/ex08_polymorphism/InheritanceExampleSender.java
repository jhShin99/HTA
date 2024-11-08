package ex08.ex08_polymorphism;

public class InheritanceExampleSender {

    public static void main(String[] args) {
        EmailSender obj1 = new EmailSender("생일을 축하합니다", "고객센터","admin@khshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
        SMSSender obj2 = new SMSSender("생일을 축하합니다", "고객센터", "064-123-45675", "10% 할인쿠폰이 발행되었습니다.");

        send(obj1, "hatman@yeyeye.com");
        send(obj1, "stickman@hahaha,com");
        send(obj2, "010-000-0000");

    }

    static void send(MessageSender obj, String recipient) {
        obj.sendMessage(recipient);
    }
}
