package ex07.ex07_object;

public class Saram4 {
    //필드(멤버변수)
    String name;
    double height;
    double weight;
    int age;

    //생성자
    public Saram4(String name, double weight){
        this.name = name;
        this.weight = weight;
    }
    //메서드
    public void eat() {
        System.out.println(name + "(이)가 밥을 먹는다.");
    }


    //메서드
    public void walk() {
        System.out.println(name + "(이)가 걷기전 몸무게는 " + weight + "입니다.");
    }

    //메서드
    public void sesu() {
        System.out.println(name + "(이)가 세수한다.");
    }
}
