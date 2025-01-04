package src.com.codinginterview.capco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static class Quote {
        private String symbol;
        private BigDecimal closingPrice;

        public Quote(String symbol, BigDecimal closingPrice) {
            this.symbol = symbol;
            this.closingPrice = closingPrice;
        }

        public String getSymbol() {
            return symbol;
        }

        public BigDecimal getClosingPrice() {
            return closingPrice;
        }
    }

    static class Position {
        private String accountId;
        private String symbol;
        private long numShares;

        public Position(String accountId, String symbol, long shares) {
            this.accountId = accountId;
            this.symbol = symbol;
            this.numShares = shares;
        }

        public String getAccountId() {
            return accountId;
        }

        public String getSymbol() {
            return symbol;
        }

        public long getNumberOfShares() {
            return numShares;
        }
    }

    static class PositionSvc {
        private List<Position> positions;

        public PositionSvc() {
            this.positions = new ArrayList<>();
            this.positions.add(new Position("286ea600", "WMT", 10));
            this.positions.add(new Position("286ea600", "MCD", 5));
            this.positions.add(new Position("b94092a0", "WMT", 15));
            this.positions.add(new Position("4810b949", "MCD", 12));
            this.positions.add(new Position("3a8f7d92", "WMT", 8));
            this.positions.add(new Position("87d928a2", "MCD", 25));
        }

        public List<Position> getAllPositions() {
            return positions;
        }
    }

    static class QuoteSvc {
        private List<Quote> previousCloseQuotes;

        public QuoteSvc() {
            this.previousCloseQuotes = new ArrayList<>();
            this.previousCloseQuotes.add(new Quote("WMT", new BigDecimal("141.15")));
            this.previousCloseQuotes.add(new Quote("MCD", new BigDecimal("211.79")));
            this.previousCloseQuotes.add(new Quote("PBCT", new BigDecimal("10.86")));
            this.previousCloseQuotes.add(new Quote("PEP", new BigDecimal("138.33")));
            this.previousCloseQuotes.add(new Quote("ROP", new BigDecimal("449.45")));
            this.previousCloseQuotes.add(new Quote("MS", new BigDecimal("66.77")));
            this.previousCloseQuotes.add(new Quote("XOM", new BigDecimal("38.88")));
        }

        public List<Quote> getAllPreviousClose() {
            return previousCloseQuotes;
        }
    }

    /*public void main(String[] args) throws Exception {
            PositionSvc positionSvc = new PositionSvc();
            QuoteSvc quoteSvc = new QuoteSvc();

            // Fetch all positions and quotes
            List<Position> positions = positionSvc.getAllPositions();
            List<Quote> quotes = quoteSvc.getAllPreviousClose();

            // Create a map for quick lookup of stock prices
            Map<String, BigDecimal> stockPrices = new HashMap<>();
            for (Quote quote : quotes) {
                stockPrices.put(quote.getSymbol(), quote.getClosingPrice());
            }

            // Map to store account total values
            Map<String, BigDecimal> accountValues = new HashMap<>();

            // Process each position
            for (Position position : positions) {
                BigDecimal stockPrice = stockPrices.get(position.getSymbol());
                if (stockPrice == null) {
                    System.out.println("Invalid symbol: " + position.getSymbol());
                    continue;
                }

                BigDecimal totalValue = stockPrice.multiply(BigDecimal.valueOf(position.getNumberOfShares()));
                accountValues.compute(position.getAccountId(), (accountId, currentValue) ->
                        (currentValue == null ? BigDecimal.ZERO : currentValue).add(totalValue));
            }

            // Sort accounts by total value in descending order
            List<Map.Entry<String, BigDecimal>> sortedAccounts = new ArrayList<>(accountValues.entrySet());
            sortedAccounts.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Print the sorted accounts and their total values
            sortedAccounts.forEach(entry ->
                    System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue())
            );
        }*/

    public static void main(String args[]) throws Exception {
        // Initialize services
        PositionSvc positionSvc = new PositionSvc();
        QuoteSvc quoteSvc = new QuoteSvc();

        // Create a map to hold account totals
        Map<String, BigDecimal> accountTotals = new HashMap<>();

        // Retrieve all positions and quotes
        List<Position> positions = positionSvc.getAllPositions();
        List<Quote> quotes = quoteSvc.getAllPreviousClose();

        // Create a map for quick quote lookup
        Map<String, BigDecimal> quoteMap = new HashMap<>();
        for (Quote quote : quotes) {
            quoteMap.put(quote.getSymbol(), quote.getClosingPrice());
        }

        // Calculate total value for each account
        for (Position position : positions) {
            BigDecimal price = quoteMap.get(position.getSymbol());
            if (price != null) {
                BigDecimal value = price.multiply(BigDecimal.valueOf(position.getNumberOfShares()));
                accountTotals.merge(position.getAccountId(), value,
                        BigDecimal::add);
            }
        }

        // Sort accounts by total value in descending order
        accountTotals.entrySet().stream()
                .sorted(Map.Entry.<String,
                        BigDecimal>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

}
