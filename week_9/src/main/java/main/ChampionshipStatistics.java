import java.util.HashMap;
import java.util.Map;

public class ChampionshipStatistics {

    public static double averagePointsPerDriver(ChampionshipManager manager) {

        int totalPoints = manager.getTotalChampionshipPoints();
        int totalDrivers = Driver.getTotalDrivers();

        return (double) totalPoints / totalDrivers;
    }

    public static String mostSuccessfulCountry(ChampionshipManager manager) {

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver d : manager.getDrivers()) {

            countryPoints.put(
                d.getCountry(),
                countryPoints.getOrDefault(d.getCountry(), 0)
                + d.getTotalPoints()
            );
        }

        String bestCountry = "";
        int max = 0;

        for (String country : countryPoints.keySet()) {

            if (countryPoints.get(country) > max) {
                max = countryPoints.get(country);
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int totalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}