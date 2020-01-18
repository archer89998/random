package org.random.automation.data;


import java.util.HashMap;
import java.util.Map;

public class DiceResultHolder {

    private static Map<Integer, Integer> diceResults = new HashMap<>();

    public static void create(int numberOfDice) {
        if (!diceResults.isEmpty()) {
            diceResults.clear();
        }
        for (int i = 0; i < numberOfDice * 6; i++) {
            diceResults.put(i + 1, 0);
        }
    }

    public static void addDiceResult(Integer diceResult) {
        Integer previousNumberOfRolls = diceResults.get(diceResult);
        diceResults.put(diceResult, previousNumberOfRolls + 1);
    }

    public static Map<Integer, Integer> get() {
        return diceResults;
    }
}
