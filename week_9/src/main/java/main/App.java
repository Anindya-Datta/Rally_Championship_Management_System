public class App {

    public static void main(String[] args) {

        // Get Singleton instance
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Create cars
        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 300);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20", 310);

        // Create drivers
        Driver d1 = new Driver("Sebastien Ogier", "France", gravelCar);
        Driver d2 = new Driver("Kalle Rovanpera", "Finland", asphaltCar);
        Driver d3 = new Driver("Ott Tanak", "Estonia", gravelCar);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        // Register drivers
        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        // ======================
        // Race 1
        // ======================

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland (Jyväskylä)");

        race1.recordResult("Sebastien Ogier", 1);
        race1.recordResult("Ott Tanak", 2);
        race1.recordResult("Kalle Rovanpera", 3);
        race1.recordResult("Thierry Neuville", 4);

        manager.addRaceResult(race1);

        // Assign points
        d1.addPoints(25);
        d3.addPoints(18);
        d2.addPoints(15);
        d4.addPoints(12);

        // ======================
        // Race 2
        // ======================

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally (Monaco)");

        race2.recordResult("Kalle Rovanpera", 1);
        race2.recordResult("Thierry Neuville", 2);
        race2.recordResult("Sebastien Ogier", 3);
        race2.recordResult("Ott Tanak", 4);

        manager.addRaceResult(race2);

        d2.addPoints(25);
        d4.addPoints(18);
        d1.addPoints(15);
        d3.addPoints(12);

        // ======================
        // Championship Standings
        // ======================

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");

        int position = 1;

        for (Driver d : manager.getStandings()) {

            System.out.println(position + ". "
                    + d.getName() + " (" + d.getCountry() + "): "
                    + d.getTotalPoints() + " points");

            position++;
        }

        // ======================
        // Leader
        // ======================

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");

        Driver leader = manager.getLeader();

        System.out.println(leader.getName() + " with "
                + leader.getTotalPoints() + " points");

        // ======================
        // Statistics
        // ======================

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");

        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.totalRacesHeld());

        System.out.println("Average Points Per Driver: "
                + ChampionshipStatistics.averagePointsPerDriver(manager));

        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.mostSuccessfulCountry(manager));

        System.out.println("Total Championship Points: "
                + manager.getTotalChampionshipPoints());

        // ======================
        // Race Results
        // ======================

        System.out.println("\n===== RACE RESULTS =====");

        for (RaceResult race : manager.getRaces()) {

            System.out.println("Race: " + race.getRaceName());

            for (String driver : race.getResults().keySet()) {

                int pos = race.getResults().get(driver);

                int points = 0;

                if (pos == 1) points = 25;
                else if (pos == 2) points = 18;
                else if (pos == 3) points = 15;
                else if (pos == 4) points = 12;

                System.out.println("  Position " + pos + ": "
                        + driver + " - " + points + " points");
            }

            System.out.println();
        }

        // ======================
        // Car Performance
        // ======================

        System.out.println("===== CAR PERFORMANCE RATINGS =====");

        System.out.println("Gravel Car Performance: "
                + gravelCar.calculatePerformance());

        System.out.println("Asphalt Car Performance: "
                + asphaltCar.calculatePerformance());
    }
}