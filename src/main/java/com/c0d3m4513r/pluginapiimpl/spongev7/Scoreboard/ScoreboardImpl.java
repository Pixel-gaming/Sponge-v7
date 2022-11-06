package com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard;

import com.c0d3m4513r.pluginapi.Nullable;
import com.c0d3m4513r.pluginapi.Scoreboard.DisplaySlot;
import com.c0d3m4513r.pluginapi.Scoreboard.Objective;
import com.c0d3m4513r.pluginapi.Scoreboard.Scoreboard;
import lombok.NonNull;
import lombok.Value;
import lombok.val;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlots;

@Value
public class ScoreboardImpl extends Scoreboard {
    //This exists, so I can access something in this class, to run the static block
    public static final Object none = null;
    static {
        constructor = ScoreboardImpl::new;
    }
    org.spongepowered.api.scoreboard.Scoreboard spongeScoreboard;
    public ScoreboardImpl(org.spongepowered.api.scoreboard.Scoreboard spongeScoreboard){
        this.spongeScoreboard=spongeScoreboard;
    }
    private ScoreboardImpl(){
        this(org.spongepowered.api.scoreboard.Scoreboard.builder().build());
    }

    @Override
    public void addObjective(Objective objective) throws IllegalArgumentException {
        spongeScoreboard.addObjective(((ObjectiveImpl)objective).getObjective());
    }

    @Override
    public void updateDisplaySlot(@Nullable Objective objective, @NonNull DisplaySlot displaySlot) throws IllegalStateException {
        final org.spongepowered.api.scoreboard.displayslot.DisplaySlot spongeDisplaySlot;
        switch (displaySlot){
            case List:
                spongeDisplaySlot = DisplaySlots.LIST;
                break;
            case Below_Name:
                spongeDisplaySlot = DisplaySlots.BELOW_NAME;
                break;
            case Sidebar:
                spongeDisplaySlot = DisplaySlots.SIDEBAR;
                break;
            default:
                throw new RuntimeException("Unknown DisplaySlot value");
        }
        org.spongepowered.api.scoreboard.objective.Objective spongeObjective = objective!=null?((ObjectiveImpl)objective).getObjective():null;
        spongeScoreboard.updateDisplaySlot(spongeObjective,spongeDisplaySlot);
    }

    @Override
    public void removeObjective(Objective objective) {
        spongeScoreboard.removeObjective(((ObjectiveImpl)objective).getObjective());
    }
}
