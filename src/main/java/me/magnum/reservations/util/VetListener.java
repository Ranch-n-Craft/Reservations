package me.magnum.reservations.util;

import me.magnum.lib.Common;
import me.magnum.reservations.Reservations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static me.magnum.reservations.util.Config.pre;
import static me.magnum.reservations.util.Config.waiting;

public class VetListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		if ((DataWorks.clients.size()>0)&& event.getPlayer().hasPermission("reservations.notify")){
			BukkitRunnable notice = new BukkitRunnable() {
				@Override
				public void run () {
					Common.tell(event.getPlayer(),
					            pre+waiting);
					
				}
			};
			notice.runTaskLater(Reservations.getPlugin(), 20*10);
		}
	}

}