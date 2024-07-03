package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.BabyEntitySpawnEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class BabySpawnEvent {

    @SubscribeEvent
    public static void onBabySpawn(BabyEntitySpawnEvent event) {
        if (event.getChild() == null) return;
        if (!event.getChild().level().getLevelData().getGameRules().getBoolean(Gamerules.DO_BABIES_SPAWN)) {
            event.setCanceled(event.isCanceled());
        }
    }
}
