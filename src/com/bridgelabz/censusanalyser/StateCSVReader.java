package com.bridgelabz.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCSVReader {
    static CsvToBean<StateCSV> csvToBean = null;
    public static int stateCSV(String pathName) throws CensusException{
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathName));
            CsvToBeanBuilder<StateCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCSV.class);
            csvToBeanBuilder.withIgnoreEmptyLine(true);
            csvToBean = new CsvToBean<>();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalStateException e){
            throw new RuntimeException(e);
        }
        Iterator<StateCSV> iterator = csvToBean.iterator();
        Iterable<StateCSV> iterable = () -> iterator;
        int numOfEntries = (int) StreamSupport.stream(iterable.spliterator(),false).count();
        return numOfEntries;
    }
}
