package com.c0d3m4513r.pluginapiimpl.spongev7.Registry;

import com.c0d3m4513r.pluginapi.Data.Point3D;
import com.c0d3m4513r.pluginapi.World;
import com.flowpowered.math.vector.Vector3d;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.SoundTypes;

import java.util.Optional;
@Value
@EqualsAndHashCode(callSuper = true)
public class Sound extends com.c0d3m4513r.pluginapi.registry.Sound {
    //This exists, so I can access something in this class, to run the static block
    public static final Object none = null;
    static {
        new Sound();
    }
    @NonNull
    SoundType spongeSound;

    public Sound(){
        this(SoundTypes.BLOCK_NOTE_PLING);
    }
    public Sound(@NonNull SoundType soundType){
        if (sound==null) sound=this;
        spongeSound=soundType;
    }
    @Override
    protected Sound getSoundInt(String key) {
        Optional<SoundType> osnd = Sponge.getRegistry().getType(SoundType.class,key);
        return osnd.map(Sound::new).orElse(null);
    }
}
