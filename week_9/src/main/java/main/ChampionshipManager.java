import java.util.*;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers;
    private List<RaceResult> races;

    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RaceResult result) {
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getStandings() {

        drivers.sort((d1, d2) ->
                Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));

        return drivers;
    }

    public Driver getLeader() {
        return getStandings().get(0);
    }

    public int getTotalChampionshipPoints() {

        int total = 0;

        for (Driver d : drivers)
            total += d.getTotalPoints();

        return total;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RaceResult> getRaces() {
        return races;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }
}