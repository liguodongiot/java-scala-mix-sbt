package scalacookbook.chapter05;

/**
 * Created by liguodong on 2016/9/12.
 */
public class StockInfo {

    String symbol;
    double currentPrice;
    double bidPrice;

    public StockInfo(String symbol, double currentPrice, double bidPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.bidPrice = bidPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }
}
