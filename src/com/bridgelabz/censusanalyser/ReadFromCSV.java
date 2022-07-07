package com.bridgelabz.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadFromCSV {
        public static int loadCSVFile(String pathOfCSVfile) throws CensusException {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(pathOfCSVfile));
                CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(IndiaCensusCSV.class);
                csvToBeanBuilder.withIgnoreEmptyLine(true);
                CsvToBean<IndiaCensusCSV> csvToBean =csvToBeanBuilder.build();
                Iterator<IndiaCensusCSV> iterator =csvToBean.iterator();
                int numOfEntries = 0;
                while(iterator.hasNext()){
                    numOfEntries++;
                    IndiaCensusCSV data = iterator.next();
                }
                return numOfEntries;
            }
            catch (IOException e){
                throw new CensusException(e.getMessage(),
                        CensusException.ExceptionType.CENSUS_FILE_PROBLEM);
            }
    }
}
