package com.invictus.lollymod.item;

import com.invictus.lollymod.LollyMod;
import com.invictus.lollymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LollyMod.MODID);

    public static final Supplier<CreativeModeTab> LOLLY_TAB = CREATIVE_MODE_TAB.register("lolly_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LOLLY_ITEM.get()))
            .title(Component.translatable("creativetab.lollymod.lollies"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.LOLLY_ITEM);
                output.accept(ModBlocks.LOLLY_BLOCK);
            })
            .build());

    public static void register(IEventBus eventBus) { CREATIVE_MODE_TAB.register(eventBus); }
}
