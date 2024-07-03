package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class EntityDimensionChangeEvent {

    @SubscribeEvent
    public static void onDimensionChange(EntityTravelToDimensionEvent event) {
        if (event.getEntity().level().getLevelData().getGameRules().getBoolean(Gamerules.DISABLE_DIMENSION_CHANGE)) {
            event.setCanceled(event.isCanceled());
        }
    }
}
