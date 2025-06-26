package com.seunome.wardenshield.item.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WardenShieldItem extends Item {
    public WardenShieldItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, user.getX(), user.getY(), user.getZ());
            cloud.setRadius(2.5F);
            cloud.setDuration(30);
            cloud.setParticleType(ParticleTypes.SONIC_BOOM);
            cloud.addEffect(new StatusEffectInstance(StatusEffects.HARM, 1, 1));
            world.spawnEntity(cloud);
            user.getItemCooldownManager().set(this, 100);
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, user.getSoundCategory(), 1.0F, 1.0F);
        }
        return TypedActionResult.success(stack, world.isClient);
    }
}