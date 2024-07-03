package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingConversionEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class EntityConversionEvent {

    @SubscribeEvent
    public static void entityTransforms(LivingConversionEvent.Pre event) {
        if (!event.getEntity().level().getLevelData().getGameRules().getBoolean(Gamerules.DO_TRANSFORMATIONS)) {
            event.setCanceled(event.isCanceled());
        }
    }
}
