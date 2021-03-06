package com.bridgelabz.censusanalysertest;

import com.bridgelabz.censusanalyser.CensusException;
import com.bridgelabz.censusanalyser.ReadFromCSV;
import com.bridgelabz.censusanalyser.StateCSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CensusAnalyserTest {
    private static final String csvFilePath = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String stateCsvPath = "./src/test/resources/IndiaStateCode.csv";
    @Test
    public void checkTheNumberOfDataFromCSVFile_CorrectTestCase(){
        try {
            int expected = ReadFromCSV.loadCSVFile(csvFilePath);
            Assertions.assertEquals(expected,29);
        }
        catch (CensusException c){
        }
    }
    //Check for sad case
    @Test
    public void checkTheNumberOfDataFromCSVFile_IncorrectTestCase(){
        try {
            int expected = ReadFromCSV.loadCSVFile(csvFilePath);
            Assertions.assertEquals(expected,12);
        }
        catch (CensusException c){
        }
    }
    @Test
    public void checkNumberOfEntriesFromStateCsvFile(){
        try {
            int expected = StateCSVReader.loadCSVFile(stateCsvPath);
            Assertions.assertEquals(expected,12);
        }
        catch (CensusException c){
        }
    }
}
