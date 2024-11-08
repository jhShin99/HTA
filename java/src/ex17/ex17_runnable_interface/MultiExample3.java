package ex17.ex17_runnable_interface;

public class MultiExample3 {

    public static void main(String[] args) {
        //람다
        Thread thread = new Thread(() -> {
                for (char ch = 'a'; ch <= 'z'; ch++)
                    System.out.print(ch);
        }); // 스레드 생성
        thread.start();
        char[] arr = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
    }
}
