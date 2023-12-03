package uk.co.mrdaly.adventofcode2023._03;

import lombok.Data;
import uk.co.mrdaly.adventofcode2023.util.model.Position;

@Data
public class FoundNumber {
    private String symbol;
    private Position symbolFoundPosition;
    private int number;

    public FoundNumber(String symbol, Position symbolFoundPosition) {
        this.symbol = symbol;
        this.symbolFoundPosition = symbolFoundPosition;
    }
}
