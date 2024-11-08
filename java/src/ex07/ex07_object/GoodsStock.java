package ex07.ex07_object;

public class GoodsStock {

    String goodsCode;
    int stockNum;

    public GoodsStock(){}

    void addStock(int amount) {
        stockNum += amount;
    }

    int subtractStock(int amount) {
        if (stockNum < amount) {
            return 0;
        } else  {
            stockNum -= amount;
            return stockNum;
        }
    }
}
