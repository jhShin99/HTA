package 과제.d0902;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Map<String, Object>> list = dao.select();

        if (list.isEmpty()) {
            System.out.println("조회된 결과가 없습니다.");
        } else {
            System.out.println("번호\t 부서번호\t최고급여\t부서인원수");
            System.out.println("--------------------------------");
            int no = 1;
            for (Map<String, Object> h : list) {
                System.out.println(no++ + "\t" + h.get("부서번호") + "\t\t\t" + h.get("최고급여") + "\t" + h.get("부서인원수"));
            }
        }
    }
}
