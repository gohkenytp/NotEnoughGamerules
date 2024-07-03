package net.reikeb.not_enough_gamerules.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.PistonEvent;
import net.reikeb.not_enough_gamerules.Gamerules;
import net.reikeb.not_enough_gamerules.NotEnoughGamerules;

@EventBusSubscriber(modid = NotEnoughGamerules.MODID)
public class PistonActiveEvent {

    @SubscribeEvent
    public static void onPistonEvent(PistonEvent.Pre event) {
        if (event.getLevel().getLevelData().getGameRules().getBoolean(Gamerules.DISABLE_PISTONS)) {
            event.setCanceled(event.isCanceled());
        }
    }
}
