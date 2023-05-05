package streams.chp10;

import java.util.*;
import java.util.stream.Collectors;

public class FootballTeamTest {

    public static void main(String[] args) {

        List<FootballTeam> data = FootballTeamTestData.getFootBallTeamData();

        //1. Group teams by league
        Map<League, List<FootballTeam>> teamsByLeague = new HashMap<>();
        System.out.println("\n1. Group teams by league : " + teamsByLeague);

        //2. grouping imperative data
        imperativeGrouping(data);

        //3.Counting total teams in each league
        Map<League, Long> totalTeamsByLeague = totalTeamsInEachLeague(data);
        System.out.println("\n3. Total teams in each League : " + totalTeamsByLeague);

        //4. Total goals in each league
        Map<League, Integer> goalsByLeague = totalGoalsInEachLeague(data);
        System.out.println("\n4. Total goals in each league : " + goalsByLeague);

        //5. partition teams by the ones i8n the champions league and the ones that are not
        System.out.println("\n5. partition teams by the ones in the champions league and the ones that are not");
        Map<Boolean, List<FootballTeam>> partitionedByChampionsLeague = partitionByCL(data);
        System.out.println(partitionedByChampionsLeague);

        //6. Grouping team by attacking, defensive
        System.out.println("\n6. Grouping team by attacking, defensive");
        Map<String, List<FootballTeam>> byStyle = groupByAttackDefense(data);
        System.out.println(byStyle);

        /*7.Grouping by attacking/defensive but league wise

        LA_LIGA={ATTACKING=[Real Sociedad], DEFENSIVE=[Villareal, Atletico Madrid]},
        BUNDESLIGA={ATTACKING=[Bayern], DEFENSIVE=[RB Leipzig, Dortmund]},
        PREMIER_LEAGUE=[Leicester City, Tottenham, Liverpool],
        CHAMPIONS_LEAGUE=[Bayern, Atletico Madrid, Liverpool]}*/

        System.out.println("7.Grouping by attacking/defensive but league wise");
        Map<League, Map<String, List<FootballTeam>>> byStyleInEachLeague = groupByAttackDefenseLeague(data);
        System.out.println(byStyleInEachLeague);

        //8. IntSummaryStatistics in each league
        System.out.println("\n8. IntSummaryStatistics in each league");
        Map<League, IntSummaryStatistics> stats = IntSummaryStatistics(data);
        System.out.println(stats);

        //9



    }

    private static Map<League, IntSummaryStatistics> IntSummaryStatistics(List<FootballTeam> data) {
        return data.stream()
                    .collect(Collectors.groupingBy(FootballTeam::getLeague,
                            Collectors.summarizingInt(FootballTeam::getGoalsFor)));
    }

    private static Map<League, Map<String, List<FootballTeam>>> groupByAttackDefenseLeague(List<FootballTeam> data) {
        return data.stream()
                .collect(Collectors.groupingBy(FootballTeam::getLeague,
                        Collectors.groupingBy(team -> getStyleOfTeam(team))));
    }

    private static Map<String, List<FootballTeam>> groupByAttackDefense(List<FootballTeam> data) {
        return data.stream()
                    .collect(Collectors.groupingBy(team -> getStyleOfTeam(team)));
    }

    private static String getStyleOfTeam(FootballTeam team) {
        if(team.getGoalsFor() > 20)
            return "ATTACKING";
        return "DEFENSIVE";
    }


    private static Map<Boolean, List<FootballTeam>> partitionByCL(List<FootballTeam> data) {

        return data.stream()
                .collect(Collectors.partitioningBy(team -> isTeamInChampionsLeague(team)));

    }

    public static boolean isTeamInChampionsLeague(FootballTeam team){
        return team.getLeague().equals(League.CHAMPIONS_LEAGUE);
    }

    private static Map<League, Integer> totalGoalsInEachLeague(List<FootballTeam> data) {
        return data.stream()
                .collect(Collectors.groupingBy(FootballTeam::getLeague,
                        Collectors.summingInt(FootballTeam::getGoalsFor)));
    }

    private static Map<League, Long> totalTeamsInEachLeague(List<FootballTeam> data) {
        return data.stream()
                    .collect(Collectors.groupingBy(FootballTeam::getLeague,
                            Collectors.counting()));
    }

    private static void imperativeGrouping(List<FootballTeam> data) {

        Map<League,List<FootballTeam>> group = new HashMap<>();

        for(FootballTeam team : data){

            League league = team.getLeague();

            if(null == group.get(league)){
                group.put(league, new ArrayList<>());
            }

            group.get(league).add(team);
        }

        System.out.println("\n2. Imperative Style : " + group);

      /*  group.forEach((k,v) -> {
            System.out.println("Key : " + k);
            System.out.println("Value : " + group.get(k));
        });*/

        group = new HashMap<>();
        for(FootballTeam team : data){
            League league = team.getLeague();
            List<FootballTeam> teamList = group.computeIfAbsent(league, k -> new ArrayList<>());
            teamList.add(team);
        }
        System.out.println("\nImperative style two : " + group);

    }
}