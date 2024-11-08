package ex13.ex13_object_tostring_override;

public class GoodsStock {

    String goodsCode;
    int stockNum;
    GoodsStock(String goodsCode, int stockNum) {
        this.goodsCode = goodsCode;
        this.stockNum = stockNum;
    }

    @Override
    public String toString() {
        return "상품코드:" + goodsCode + " 재고수량: " + stockNum;
    }
}
