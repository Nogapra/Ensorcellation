package cofh.ensorcellation.common.enchantment;

import cofh.core.init.CoreEnchantments;
import cofh.lib.common.enchantment.EnchantmentCoFH;
import net.minecraft.world.entity.EquipmentSlot;

public class LeechEnchantment extends EnchantmentCoFH {

    public LeechEnchantment() {

        super(Rarity.UNCOMMON, CoreEnchantments.Types.SWORD_OR_AXE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        maxLevel = 4;
    }

    @Override
    public int getMinCost(int level) {

        return 5 + (level - 1) * 10;
    }

    @Override
    protected int maxDelegate(int level) {

        return getMinCost(level) + 50;
    }

}