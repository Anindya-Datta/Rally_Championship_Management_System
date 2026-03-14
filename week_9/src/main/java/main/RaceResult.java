import java.util.Map;

public interface RaceResult {

    void recordResult(String driverName, int position);

    Map<String, Integer> getResults();

    String getRaceName();
}