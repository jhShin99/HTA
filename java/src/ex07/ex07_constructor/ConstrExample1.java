package ex07.ex07_constructor;

import ex07.ex07_object.GoodsStock2;

public class ConstrExample1 {

    public static void main(String[] args) {
        GoodsStock2 obj = new GoodsStock2("52135", 200);

        System.out.println("상품코드:" + obj.goodsCode);
        System.out.println("재고수량:" + obj.stockNum);

        System.out.println("=====obj.addStock(10000) 후=====");
        obj.addStock(1000);

        System.out.println("상품코드:" + obj.goodsCode);
        System.out.println("재고수량:" + obj.stockNum);

        System.out.println("=====obj.subtractStock(500) 후=====");
        obj.subtractStock(500);

        System.out.println("상품코드:" + obj.goodsCode);
        System.out.println("재고수량:" + obj.stockNum);
    }
}
