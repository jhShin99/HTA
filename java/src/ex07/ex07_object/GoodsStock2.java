package ex07.ex07_object;

public class GoodsStock2 {

    public String goodsCode;
    public int stockNum;

    public GoodsStock2(String goodsCode, int stockNum){
        this.goodsCode = goodsCode;
        this.stockNum = stockNum;
    }

    public void addStock(int amount) {
        stockNum += amount;
    }

    public int subtractStock(int amount) {
        if (stockNum < amount) {
            return 0;
        } else  {
            stockNum -= amount;
            return stockNum;
        }
    }
}
