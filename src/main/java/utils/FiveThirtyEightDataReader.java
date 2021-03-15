package utils;

import model.Team;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewlayser on 3/15/17.
 */
public class FiveThirtyEightDataReader {
    private FiveThirtyEightDataReader() {

    }

    public static List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        Reader in = null;
        try {
            in = new FileReader("src/main/java/utils/fivethirtyeight_ncaa_forecasts.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.EXCEL.parse(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : records) {
            List<Double> winProbabilities = new ArrayList<>();
            for (int i = 4; i < 10; i++) {
                winProbabilities.add(Double.parseDouble(record.get(i)));
            }
            Team team = new Team(record.get(12), record.get(14), Integer.parseInt(record.get(15)), winProbabilities);
            teams.add(team);
        }
        return teams;
    }
}
