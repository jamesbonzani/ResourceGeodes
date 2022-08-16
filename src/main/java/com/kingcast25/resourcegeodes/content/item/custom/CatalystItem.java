package com.kingcast25.resourcegeodes.content.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CatalystItem extends Item {
    public CatalystItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 16;
    }


}
