package net.reikeb.not_enough_gamerules.events;

import net.minecraft.world.entity.item.PrimedTnt;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class ExplodesEvent {

    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Start event) {
        if ((!event.getLevel().getLevelData().getGameRules().getBoolean(Gamerules.TNT_EXPLODES)) && (event.getExplosion().getExplosionSound() instanceof PrimedTnt)) {
            event.setCanceled(event.isCanceled());
        }
    }
}
