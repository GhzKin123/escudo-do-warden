package com.seunome.wardenshield;

import com.seunome.wardenshield.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class WardenShieldMod implements ModInitializer {
    public static final String MOD_ID = "wardenshield";
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "tab"))
        .icon(() -> new ItemStack(ModItems.WARDEN_SHIELD))
        .displayName(Text.literal("Warden Shield Mod"))
        .build();

    @Override
    public void onInitialize() {
        ModItems.register();
    }
}