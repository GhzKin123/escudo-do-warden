package com.seunome.wardenshield.item;

import com.seunome.wardenshield.WardenShieldMod;
import com.seunome.wardenshield.item.custom.WardenShieldItem;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;

public class ModItems {
    public static final Item WARDEN_SHIELD = new WardenShieldItem(new Item.Settings().maxDamage(500));

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(WardenShieldMod.MOD_ID, "warden_shield"), WARDEN_SHIELD);
    }
}