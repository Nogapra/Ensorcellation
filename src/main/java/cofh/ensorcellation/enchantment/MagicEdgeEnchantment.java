package cofh.ensorcellation.enchantment;

import cofh.core.init.CoreEnchantments;
import cofh.lib.enchantment.DamageEnchantmentCoFH;
import cofh.lib.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.server.ServerWorld;

public class MagicEdgeEnchantment extends DamageEnchantmentCoFH {

    public MagicEdgeEnchantment() {

        super(Rarity.RARE, CoreEnchantments.Types.SWORD_OR_AXE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 3;
        treasureEnchantment = true;
    }

    @Override
    public int getMinCost(int level) {

        return 15 + (level - 1) * 9;
    }

    @Override
    protected int maxDelegate(int level) {

        return getMinCost(level) + 50;
    }

    @Override
    public boolean checkCompatibility(Enchantment ench) {

        return super.checkCompatibility(ench) && ench != Enchantments.SWEEPING_EDGE;
    }

    // region HELPERS
    public static float getExtraDamage(int level) {

        return level * 0.5F;
    }

    public static void onHit(LivingEntity entity, int level) {

        if (entity.level instanceof ServerWorld) {
            for (int i = 0; i < 2 * level; ++i) {
                Utils.spawnParticles(entity.level, ParticleTypes.ENCHANT, entity.getX() + entity.level.random.nextDouble(), entity.getY() + 1.0D + entity.level.random.nextDouble(), entity.getZ() + entity.level.random.nextDouble(), 1, 0, 0, 0, 0);
                Utils.spawnParticles(entity.level, ParticleTypes.ENCHANTED_HIT, entity.getX() + entity.level.random.nextDouble(), entity.getY() + 1.0D + entity.level.random.nextDouble(), entity.getZ() + entity.level.random.nextDouble(), 1, 0, 0, 0, 0);
            }
        }
    }
    // endregion
}
