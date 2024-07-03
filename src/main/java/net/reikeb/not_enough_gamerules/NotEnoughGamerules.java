package net.reikeb.not_enough_gamerules;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(NotEnoughGamerules.MODID)
public class NotEnoughGamerules {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // Register the modid
    public static final String MODID = "not_enough_gamerules";

    public NotEnoughGamerules() {

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(new Gamerules());
        NeoForge.EVENT_BUS.register(this);
    }

    public static DamageSource damageSource(Level level, String name) {
        return damageSource(level, name, DamageTypes.GENERIC);
    }

    public static DamageSource damageSource(Level level, String name, ResourceKey<DamageType> damageTypes) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageTypes)) {
            @Override
            public @NotNull Component getLocalizedDeathMessage(@NotNull LivingEntity entity) {
                return Component.translatable("death.attack." + name);
            }
        };
    }
}
