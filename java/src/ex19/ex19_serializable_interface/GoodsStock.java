package ex19.ex19_serializable_interface;

import java.io.Serializable;

public class GoodsStock implements Serializable {

    private String code;
    private int num;

    GoodsStock(String code, int num) {
        this.code = code;
        this.num = num;
    }

    void addStock() {
        this.num += num;
    }

    int subtractStock(int num) throws Exception {
        if (this.num < num)
            throw new Exception("재고가 부족합니다.");
        this.num -= num;
        return num;
    }

    public String toString() {
        return "상품 코드:" + code + "\t상품수량: " + num;
    }
}
