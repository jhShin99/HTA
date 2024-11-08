package ex08.ex08_abstract_method;

public class EmailSender extends MessageSender{

    String senderAddr;
    String emailBody;

    EmailSender(String title, String senderName, String senderAddr, String emailBody) {
        super(title, senderName);
        this.senderAddr = senderAddr;
        this.emailBody = emailBody;
    }

    @Override
    void sendMessage(String recipient) {
        System.out.println("------------------------------");
        System.out.println("제목: " + title);
        System.out.println("보내는 사람: " + senderName + "\n" + "보낸 주소 : " + senderAddr);
        System.out.println("받는 사람: " + recipient);
        System.out.println("내용: " + emailBody);
    }
}
