package com.c0d3m4513r.pluginapiimpl.spongev7.entity;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import com.flowpowered.math.vector.Vector3d;
import lombok.NonNull;
import lombok.Value;
import org.spongepowered.api.text.Text;

@Value
public class Player implements com.c0d3m4513r.pluginapi.entity.Player {
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
    public Point3D getPosition() {
        Vector3d position = player.getLocation().getPosition();
        return new Point3D(position.getX(),position.getY(),position.getZ());
    }
}
