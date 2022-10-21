package net.unusualotter.randommod.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlazingSwordItem extends Item {
    public BlazingSwordItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.world.isClient) {
            target.setFireTicks(60);
            attacker.getStackInHand(attacker.getActiveHand()).damage(1, attacker, (p) -> p.sendToolBreakStatus(attacker.getActiveHand()));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        for (BlockPos pos : BlockPos.iterate(new BlockPos(user.getBlockPos().getX() + 3, user.getBlockPos().getY(), user.getBlockPos().getZ() + 3),
                new BlockPos(user.getBlockPos().getX() - 3, user.getBlockPos().getY(), user.getBlockPos().getZ() - 3))) {
            user.getItemCooldownManager().set(this, 60);
            if (!world.isClient) {
                if (world.getBlockState(pos).equals(Blocks.AIR.getDefaultState())) {
                    world.setBlockState(pos, Blocks.FIRE.getDefaultState());
                    if (!user.getAbilities().creativeMode) {
                        user.getStackInHand(hand).damage(5, user, (p) -> p.sendToolBreakStatus(hand));
                    }
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 1, false, false));
                }
            }
        }
        return super.use(world, user, hand);
    }
}
