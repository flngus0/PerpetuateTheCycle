package flingus.perpetuate.index;

import flingus.perpetuate.PerpetuateTheCycle;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent MOSS_FANFARE = registerSound("fanfare.moss");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = PerpetuateTheCycle.id(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init(){}
}
