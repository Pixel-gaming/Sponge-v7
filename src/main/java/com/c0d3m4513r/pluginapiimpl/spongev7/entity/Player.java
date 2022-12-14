package com.c0d3m4513r.pluginapiimpl.spongev7.entity;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import com.c0d3m4513r.pluginapi.Scoreboard.Scoreboard;
import com.c0d3m4513r.pluginapi.messages.Title;
import com.c0d3m4513r.pluginapi.registry.Sound;
import com.c0d3m4513r.pluginapi.world.Location;
import com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard.ScoreboardImpl;
import com.flowpowered.math.vector.Vector3d;
import lombok.NonNull;
import lombok.Value;
import org.spongepowered.api.text.Text;

@Value
public class Player implements com.c0d3m4513r.pluginapi.entity.Player,Viewer {
    @NonNull
    org.spongepowered.api.entity.living.player.Player player;

    @Override
    public boolean hasPerm(String perm) {
        return player.hasPermission(perm);
    }

    @Override
    public String getIdentifier() {
        return player.getIdentifier();
    }

    @Override
    public void sendMessage(@NonNull String message) {
        player.sendMessage(Text.of(message));
    }

    @Override
    public Location getLocation() {
        return new com.c0d3m4513r.pluginapiimpl.spongev7.World.Location(player);
    }

    @Override
    public org.spongepowered.api.effect.Viewer getSpongeViewer() {
        return player;
    }

    @Override
    public Scoreboard getScoreboard() {
        return new ScoreboardImpl(player.getScoreboard());
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) {
        player.setScoreboard(((ScoreboardImpl)scoreboard).getSpongeScoreboard());
    }
}
