package streams.chp10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballTeamTest {

    public static void main(String[] args) {

        List<FootballTeam> data = FootballTeamTestData.getFootBallTeamData();

        //1. Group teams by league
        Map<League, List<FootballTeam>> teamsByLeague = new HashMap<>();
        System.out.println("\n1. Group teams by league : " + teamsByLeague);

        //2. grouping imperative data
        imperativeGrouping(data);

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

        System.out.println("\n Imperative Style : " + group);

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
        System.out.println("\n Imperative style two : " + group);

    }
}