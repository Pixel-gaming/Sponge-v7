package com.c0d3m4513r.pluginapiimpl.spongev7.entity;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import com.c0d3m4513r.pluginapi.messages.Title;
import com.c0d3m4513r.pluginapi.registry.Sound;
import com.flowpowered.math.vector.Vector3d;
import lombok.val;
import org.spongepowered.api.text.Text;

public interface Viewer extends com.c0d3m4513r.pluginapi.entity.Viewer {
    org.spongepowered.api.effect.Viewer getSpongeViewer();
    default void playSound(Sound sound, Point3D position, int volume){
        getSpongeViewer().playSound(((com.c0d3m4513r.pluginapiimpl.spongev7.Registry.Sound)sound).getSpongeSound(),
                new Vector3d(
                        position.getX().doubleValue(),
                        position.getY().doubleValue(),
                        position.getZ().doubleValue()
                ),
                volume);
    }
    default void sendTitle(Title title){
        val builder = org.spongepowered.api.text.title.Title.builder();
        if (title.getTitle().isPresent()) builder.title(Text.of(title.getTitle().get()));
        if (title.getSubtitle().isPresent()) builder.subtitle(Text.of(title.getSubtitle().get()));
        org.spongepowered.api.text.title.Title spongeTitle = builder.build();
        getSpongeViewer().sendTitle(spongeTitle);
    }
}
