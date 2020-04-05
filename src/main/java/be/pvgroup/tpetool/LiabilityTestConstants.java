package be.pvgroup.tpetool;

import be.pvgroup.tpetool.model.liability.LiabilityAnswers;
import be.pvgroup.tpetool.model.liability.LiabilityData;
import be.pvgroup.tpetool.model.liability.LiabilityInput;

import java.math.BigDecimal;

import static be.pvgroup.tpetool.TestConstants.NACEBEL_56101;

public class LiabilityTestConstants {

    public static LiabilityAnswers liabilityAnswers() {
        LiabilityAnswers.LiabilityAnswersBuilder answersBuilder = LiabilityAnswers.LiabilityAnswersBuilder.aLiabilityAnswers();

        LiabilityAnswers liabilityAnswers = answersBuilder
            .withNumberOfCoowners(new BigDecimal(1))
            .withNumberOfOwners(BigDecimal.ONE)
            .withNumberOfFullTimeEmployees(new BigDecimal(1))
            .withNumberOfPartTimeEmployees(new BigDecimal(1))
                .withExploitationLimit(new BigDecimal(2500000))
            .build();


        return liabilityAnswers;
    }

    public static LiabilityAnswers liabilityAnswersLimit2500000() {
        LiabilityAnswers.LiabilityAnswersBuilder answersBuilder = LiabilityAnswers.LiabilityAnswersBuilder.aLiabilityAnswers();

        LiabilityAnswers liabilityAnswers = answersBuilder
                .withNumberOfCoowners(new BigDecimal(1))
                .withNumberOfOwners(BigDecimal.ONE)
                .withNumberOfFullTimeEmployees(new BigDecimal(1))
                .withNumberOfPartTimeEmployees(new BigDecimal(1))
                .withExploitationLimit(new BigDecimal(2500000))
                .build();

        return liabilityAnswers;
    }

    public static LiabilityData liabilityData() {
        LiabilityData.LiabilityDataBuilder dataBuilder = LiabilityData.LiabilityDataBuilder.aLiabilityData();


        LiabilityData liabilityData = dataBuilder
                .withNacebel(NACEBEL_56101)
                .withAnswers(liabilityAnswers())
                .build();

        return liabilityData;
    }

    public static LiabilityData liabilityDataLimi2500000() {
        LiabilityData.LiabilityDataBuilder dataBuilder = LiabilityData.LiabilityDataBuilder.aLiabilityData();


        LiabilityData liabilityData = dataBuilder
                .withNacebel(NACEBEL_56101)
                .withAnswers(liabilityAnswersLimit2500000())
                .build();

        return liabilityData;
    }

    public static LiabilityInput liabilityInput() {
        LiabilityInput.LiabilityInputBuilder builder = LiabilityInput.LiabilityInputBuilder.aLiabilityInput();

        LiabilityInput input = builder
                .withData(liabilityData())
                .build();

        return input;
    }

    public static LiabilityInput liabilityInputLimi2500000() {
        LiabilityInput.LiabilityInputBuilder builder = LiabilityInput.LiabilityInputBuilder.aLiabilityInput();

        LiabilityInput input =  builder
                .withData(liabilityDataLimi2500000())
                .build();


        return input;
    }




}
