package ex21.ex21_stream_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {
    public static void main(String[] args) {
        //7명에 대한 job을 나타냅니다.
        List<String> myList = Arrays.asList("CLERK", "SALESMAN", "MANAGER", "ANALYST", "PRESIDENT", "ANALYST");

        //1. job에 대한 인원 수 구하기 - 리스트 크기 구하기
        long size = myList.stream().count();
        System.out.println(size + "명");

        //2. job의 종류를 중복 제거하고 출력
        List<String> job_list = myList.stream().distinct().toList();
        System.out.println(job_list);
//        job_list.add("king"); // 오류 발생

        //3. job의 종류를 중복 제거 후 오름차순 정렬 출력
        List<String> job_list2 = myList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(job_list2);
        job_list2.add("king");
        System.out.println(job_list2.toString());

        //4.job의 갯수 구하기
        long job_size = myList.stream().distinct().count();
        System.out.println(job_size);
    }
}
