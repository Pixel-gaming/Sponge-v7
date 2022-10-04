package com.c0d3m4513r.pluginapiimpl.spongev7;

import com.c0d3m4513r.pluginapi.entity.Player;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.stream.Collectors;

@Value
public class World implements com.c0d3m4513r.pluginapi.World {
    @NonNull
    org.spongepowered.api.world.World world;

    @Override
    public Collection<Player> getPlayers() {
        return world.getPlayers()
                .parallelStream()
                .map(com.c0d3m4513r.pluginapiimpl.spongev7.entity.Player::new)
                .collect(Collectors.toList());
    }
}
