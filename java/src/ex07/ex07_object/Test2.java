package ex07.ex07_object;

public class Test2 {
    public static void main(String[] args) {
        GoodsStock2 obj = new GoodsStock2("52135", 200);

        print(obj);

        System.out.println("=====obj.addStock(10000) 후=====");
        obj.addStock(1000);

        print(obj);

        System.out.println("=====obj.subtractStock(500) 후=====");
        obj.subtractStock(500);

        print(obj);

    }

    public static void print(GoodsStock2 obj)  {
        System.out.println("상품코드:" + obj.goodsCode);
        System.out.println("재고수량:" + obj.stockNum);
    }
}
