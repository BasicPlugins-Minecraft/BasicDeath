package me.mobmaker.basicdeath;

import me.mobmaker.basicdeath.data.Messages;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.scheduler.BukkitRunnable;

public class ExpireRunnable extends BukkitRunnable {

    private final Player player;

    public ExpireRunnable(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        player.setInvulnerable(false);
        pdc.remove(BasicDeath.deathKey);
        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 50);
        player.spawnParticle(Particle.DRIP_LAVA, player.getLocation().add(0,1,0), 2);
        player.sendMessage(Messages.INVULNERABILITY_ENDED.get());
    }
}
