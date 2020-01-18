package org.random.automation.roll;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.random.automation.data.DiceResultHolder;
import org.random.automation.rest.RestGet;
import org.random.automation.util.MapUtil;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.random.automation.data.ConfigurationHolder.setConfigurationData;

public class RollDiceTest {

    private final static String DICE_PATH = "/dice";
    private final static String DICE_NUMBER_PARAMETER_PATH = "/?num=%s";
    private final static String ENV_PROPERTIES = "env";

    @BeforeAll
    static void initConfiguration() {
        setConfigurationData(System.getProperty("env"));
    }

    @ParameterizedTest
    @MethodSource("deviationDiceData")
    void deviationDiceTest(int diceNumber, int rollNumber, double expectedDeviation) {
        DiceResultHolder.create(diceNumber);
        String path = DICE_PATH + String.format(DICE_NUMBER_PARAMETER_PATH, diceNumber);
        for (int i = 0; i < rollNumber; i++) {
            Document response = RestGet.get(path);
            Elements img = response.select("img");
            Integer rollValue = Integer.valueOf(img.attr("alt"));
            DiceResultHolder.addDiceResult(rollValue);
        }
        int maxRollResult = MapUtil.getMaxValue(DiceResultHolder.get());
        int minRollResult = MapUtil.getMinValue(DiceResultHolder.get());

        Double deviation =  (maxRollResult - minRollResult) * 100 / (rollNumber / (diceNumber * 6.0));
        assertThat(deviation).as("Deviation is greater than expected.").isLessThan(expectedDeviation);
    }

    private static Stream<Arguments> deviationDiceData() {
        return Stream.of(
                Arguments.of(1, 1000, 5.0),
                Arguments.of(1, 50000, 5.0),
                Arguments.of(1, 10000, 5.0),
                Arguments.of(2, 1000, 5.0),
                Arguments.of(2, 50000, 5.0),
                Arguments.of(2, 10000, 5.0)
        );
    }

}
