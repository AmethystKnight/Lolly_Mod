package com.invictus.lollymod.item;


import com.invictus.lollymod.LollyMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LollyMod.MODID);

    //see if i can add a short jump boost and speed modifier later.
    public static final DeferredItem<Item> LOLLY_ITEM = ITEMS.registerSimpleItem("lolly_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredItem<Item> LOLLY_POP = ITEMS.registerSimpleItem("lolly_pop", new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 1), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1.0f)
                    .alwaysEdible()
                    .build()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); };

}
