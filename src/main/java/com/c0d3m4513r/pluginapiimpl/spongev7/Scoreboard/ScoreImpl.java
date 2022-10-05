package com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard;

import com.c0d3m4513r.pluginapi.Scoreboard.Score;
import lombok.Data;
import lombok.NonNull;

@Data
public class ScoreImpl implements Score {
    @NonNull
    org.spongepowered.api.scoreboard.Score spongeScore;

    @Override
    public int getScore() {
        return spongeScore.getScore();
    }

    @Override
    public String getName() {
        return spongeScore.getName().toPlain();
    }

    @Override
    public void setScore(int score) {
        spongeScore.setScore(score);
    }
}
