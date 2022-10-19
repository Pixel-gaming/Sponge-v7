package com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard;

import com.c0d3m4513r.pluginapi.Scoreboard.Score;
import com.c0d3m4513r.pluginapi.Scoreboard.Scoreboard;
import lombok.Data;
import lombok.NonNull;
import org.spongepowered.api.scoreboard.critieria.Criteria;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.text.Text;

@Data
public class ObjectiveImpl extends com.c0d3m4513r.pluginapi.Scoreboard.Objective {
    @NonNull
    public Objective objective;
    //This exists, so I can access something in this class, to run the static block
    public static final Object none = null;
    static {
        com.c0d3m4513r.pluginapi.Scoreboard.Objective.construct = ObjectiveImpl::new;
    }

    public ObjectiveImpl(@NonNull Objective build) {
        super();
        objective=build;
    }
    @Override
    public void setDisplayName(@NonNull String name) {
        objective.setDisplayName(Text.of(name));
    }

    @Override
    public String getName(){
        return objective.getName();
    }

    @Override
    public Score getOrCreateScore(String name) {
        return new ScoreImpl(objective.getOrCreateScore(Text.of(name)));
    }

    @Override
    public com.c0d3m4513r.pluginapi.Scoreboard.Objective createNewInstance(Scoreboard scoreboard, String name, String displayName, com.c0d3m4513r.pluginapi.Scoreboard.Criteria criteria) {
        return new ObjectiveImpl(scoreboard,name,displayName, criteria);
    }
    private static Criterion getCriterion(com.c0d3m4513r.pluginapi.Scoreboard.Criteria criteria){
        switch (criteria){
            case Dummy: return Criteria.DUMMY;
            case Trigger: return Criteria.TRIGGER;
            case Deaths: return Criteria.DEATHS;
            case Health: return Criteria.HEALTH;
            case PlayerKills: return Criteria.PLAYER_KILLS;
            case TotalKills: return Criteria.TOTAL_KILLS;
            default: throw new RuntimeException("Criteria had more variants, than expected");
        }
    }
    ObjectiveImpl(Scoreboard scoreboard,String name,String displayName,com.c0d3m4513r.pluginapi.Scoreboard.Criteria criteria){
        this(Objective.builder().name(name).displayName(Text.of(displayName)).criterion(getCriterion(criteria)).build());
        scoreboard.addObjective(this);
    }
}
