package com.warpedreality.lostpowers.events;

import com.warpedreality.lostpowers.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventMobDrops {

    @SubscribeEvent
    public void onAnimalDeath(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();

            if (player.getHeldItemMainhand().getItem() != ModItems.ENDER_STAFF) {

                if (event.getEntity() instanceof EntityGuardian || event.getEntity() instanceof EntityElderGuardian) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityBlaze) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityCreeper) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                }
            }
        }
    }
}
