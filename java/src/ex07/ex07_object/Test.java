package ex07.ex07_object;

public class Test {
    public static void main(String[] args) {
        GoodsStock obj = new GoodsStock();
        obj.goodsCode = "52135";
        obj.stockNum = 200;

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
