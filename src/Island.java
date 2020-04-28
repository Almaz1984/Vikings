import java.util.HashMap;
import java.util.Map;

public class Island {


    String name;
    public Island (String name){
        this.name=name;
    }
    private Map ways  = new HashMap();
    public void addWay (Map ways){
        this.ways=ways;
    }
    public Map getWays() {
        return ways;
    }
}
