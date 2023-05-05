package streams.chp10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulateMap {

    public static Map<League, List<FootballTeam>> group = new HashMap<>();

    public static void main(String[] args) {

        List<FootballTeam> data = FootballTeamTestData.getFootBallTeamData();

        for(FootballTeam team : data){

            League league = team.getLeague();

            if(null == group.get(league)){
                group.put(league, new ArrayList<>());
            }

            group.get(league).add(team);
        }

        group.forEach((k,v) -> {
            System.out.println("Key : " + k);
            System.out.println("Value : " + group.get(k));
        });

    }
}
