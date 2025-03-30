package pl.flezy.pearltweaks.Listener;

import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;
import pl.flezy.pearltweaks.PearlTweaks;

public class PearlListener implements Listener {
    private final PearlTweaks p;
    public PearlListener(PearlTweaks p) {
        this.p = p;
    }

    @EventHandler
    private void onPearlThrow(PlayerInteractEvent event){
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
            ItemStack item = event.getItem();
            Player player = event.getPlayer();
            if (item != null && item.getType() == Material.ENDER_PEARL &&
                    player.getCooldown(Material.ENDER_PEARL)==0){
                if (p.config.disablePearl){
                    event.setCancelled(true);
                    Bukkit.getScheduler().runTask(p,()->player.setCooldown(Material.ENDER_PEARL,0));
                    return;
                }
                if (player.hasPermission("pearltweaks.bypasscooldown")){
                    Bukkit.getScheduler().runTask(p,()->player.setCooldown(Material.ENDER_PEARL,0));
                    return;
                }
                if (p.config.customCooldownEnable){
                    Bukkit.getScheduler().runTask(p,()->player.setCooldown(Material.ENDER_PEARL,p.config.customCooldownTime));
                }
            }
        }
    }

    @EventHandler
    private void onPearlLaunch(ProjectileLaunchEvent event){
        if (event.getEntity() instanceof EnderPearl pearl){
            Vector velocity = pearl.getVelocity();
            velocity.multiply(p.config.velocityMultiplier);
            pearl.setVelocity(velocity);
        }
    }

    @EventHandler
    private void onPearlLand(ProjectileHitEvent event){
        if (event.getEntity() instanceof EnderPearl pearl &&
                pearl.getShooter() instanceof Player shooter){
            if (!p.config.throwBeyondBorder) {
                Location loc = pearl.getLocation();
                World world = loc.getWorld();
                if (world != null) {
                    WorldBorder worldBorder = world.getWorldBorder();
                    if (!worldBorder.isInside(loc)) {
                        pearl.remove();
                        return;
                    }
                }
            }
            shooter.setMetadata("enderPearlDamage", new FixedMetadataValue(p,true));
            Bukkit.getScheduler().runTask(p,()->shooter.removeMetadata("enderPearlDamage",p));
        }
    }

    @EventHandler
    private void onPearlDamage(EntityDamageEvent event){
        if (event.getEntity() instanceof Player player &&
        player.hasMetadata("enderPearlDamage")){
            player.removeMetadata("enderPearlDamage",p);
            if (p.config.disableDamage || player.hasPermission("pearltweaks.disabledamage")){
                event.setCancelled(true);
                return;
            }
            if (p.config.customDamageEnable){
                event.setDamage(p.config.customDamageAmount);
            }
        }
    }
}
