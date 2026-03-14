import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private Map<String, Integer> results;

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        results = new HashMap<>();
    }

    @Override
    public void recordResult(String driverName, int position) {
        results.put(driverName, position);
    }

    @Override
    public Map<String, Integer> getResults() {
        return results;
    }

    @Override
    public String getRaceName() {
        return raceName;
    }
}