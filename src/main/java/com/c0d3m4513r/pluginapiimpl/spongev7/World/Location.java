package com.c0d3m4513r.pluginapiimpl.spongev7.World;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import lombok.Value;
import lombok.val;
import org.spongepowered.api.world.Locatable;

@Value
public class Location implements com.c0d3m4513r.pluginapi.world.Location {
    Locatable locatable;

    @Override
    public Point3D getPosition() {
        val pos = locatable.getLocation().getPosition();
        return new Point3D(pos.getX(),pos.getY(),pos.getZ());
    }
}
