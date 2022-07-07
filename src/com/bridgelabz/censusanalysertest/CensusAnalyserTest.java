package com.bridgelabz.censusanalysertest;

import com.bridgelabz.censusanalyser.CensusException;
import com.bridgelabz.censusanalyser.ReadFromCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CensusAnalyserTest {
    private static final String csvFilePath = "./src/test/resources/IndiaStateCensusData.csv";
    @Test
    public void checkTheNumberOfDataFromCSVFile(){
        try {
            int expected = ReadFromCSV.loadCSVFile(csvFilePath);
            Assertions.assertEquals(expected,29);
        }
        catch (CensusException c){
        }
    }
}
