package com.c0d3m4513r.pluginapiimpl.spongev7.World;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import com.c0d3m4513r.pluginapi.entity.Player;
import com.c0d3m4513r.pluginapi.messages.Title;
import com.c0d3m4513r.pluginapi.registry.Sound;
import com.c0d3m4513r.pluginapi.world.Location;
import com.c0d3m4513r.pluginapiimpl.spongev7.entity.Viewer;
import com.flowpowered.math.vector.Vector3d;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.val;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Locatable;

import java.util.Collection;
import java.util.stream.Collectors;

@Value
public class World implements com.c0d3m4513r.pluginapi.World, Viewer {
    @NonNull
    org.spongepowered.api.world.World world;

    @Override
    public Collection<Player> getPlayers() {
        return world.getPlayers()
                .parallelStream()
                .map(com.c0d3m4513r.pluginapiimpl.spongev7.entity.Player::new)
                .collect(Collectors.toList());
    }

    @Override
    public Location getSpawnLocation() {
        return new com.c0d3m4513r.pluginapiimpl.spongev7.World.Location(
            new Locatable() {
                @Override
                public org.spongepowered.api.world.Location<org.spongepowered.api.world.World> getLocation() {
                    return world.getSpawnLocation();
                }

                @Override
                public org.spongepowered.api.world.World getWorld() {
                    return world;
                }
            }
        );
    }

    @Override
    public org.spongepowered.api.effect.Viewer getSpongeViewer() {
        return world;
    }
}
