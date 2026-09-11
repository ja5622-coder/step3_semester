import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only rule
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Matches + fitness rule
        static boolean isDraftable(int matchesPlayed,
                                    boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        public String getName() {
            return name;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        @Override
        public int compareTo(Player other) {

            // Higher batting average comes first
            return Double.compare(
                other.battingAverage,
                this.battingAverage
            );
        }
    }

    static String draftAndRank(Player[] players) {

        int count = 0;

        // Count draftable players
        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                        player.matchesPlayed,
                        player.injured)) {

                count++;
            }
        }

        // Create array for draftable players
        Player[] draftable = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                        player.matchesPlayed,
                        player.injured)) {

                draftable[index] = player;
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + draftable[i].getName();

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}
