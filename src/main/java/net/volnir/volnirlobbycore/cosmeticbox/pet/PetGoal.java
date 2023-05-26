package net.volnir.volnirlobbycore.cosmeticbox.pet;

import com.destroystokyo.paper.entity.ai.Goal;
import com.destroystokyo.paper.entity.ai.GoalKey;
import com.destroystokyo.paper.entity.ai.GoalType;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class PetGoal implements Goal<Mob>, Listener {
	private final GoalKey<Mob> key = GoalKey.of(Mob.class, new NamespacedKey(VolnirLobbyCore.getInstance(), "COSMETICS_PET"));
	private final Mob mob;
	private final LivingEntity owner;

	private LivingEntity target;
	private boolean attackPlayers = true;
	private boolean attackMobs = false;

	private double moveDistance = 3.5D; //If entity is outside of this range, they will walk to the player.
	private double maxDistance = 16D; //If outside of this range, they will teleport to the owner
	private double maxForgetTargetDistance = 120D; //If outside of this range, the mob will forget the player.

	public PetGoal(Mob mob, LivingEntity owner) {
		this.mob = mob;
		this.owner = owner;
	}

	public PetGoal(Mob mob, LivingEntity owner, boolean attackMobs, boolean attackPlayers) {
		this.mob = mob;
		this.owner = owner;
		this.attackMobs = attackMobs;
		this.attackPlayers = attackPlayers;
	}

	@Override
	public boolean shouldActivate() {
		return true;
	}

	@Override
	public boolean shouldStayActive() {
		return shouldActivate();
	}

	@Override
	public void start() {
		Bukkit.getPluginManager().registerEvents(this, VolnirLobbyCore.getInstance());
	}

	@Override
	public void stop() {
		HandlerList.unregisterAll(this);
	}

	@Override
	public void tick() {
		if(target == null) {
			if(!owner.getWorld().equals(mob.getWorld())) {
				mob.teleport(owner);
				return;
			}
			mob.setTarget(null); //Stop mobs (such as zombie) from automatically targeting someone else.
			double distance = owner.getLocation().distance(mob.getLocation());

			if(distance > maxDistance) {
				mob.teleport(owner);
				return;
			}

			if(distance > moveDistance) mob.getPathfinder().moveTo(owner);
			return;
		}

		if(!isValidTarget(target)) {
			target = null;
			return;
		}

		double distance = owner.getLocation().distance(mob.getLocation());

		if(distance > maxForgetTargetDistance) {
			target = null;
			return;
		}
		mob.setTarget(owner);
	}

	public LivingEntity getOwner() { return owner; }
	public boolean isValidTarget(LivingEntity target) {
		if(!target.isValid() || target.equals(owner)) return false;
		if(target instanceof Player p) return p.getGameMode() != GameMode.CREATIVE && p.getGameMode() != GameMode.SPECTATOR;
		else if (target instanceof Mob m) {
			Goal<Mob> goal = Bukkit.getMobGoals().getGoal(m, key);
			if(goal instanceof PetGoal petGoal) {
				return !petGoal.getOwner().equals(owner);
			}
		}
		return true;
	}

	public void setTarget(LivingEntity newTarget) {
		if(isValidTarget(newTarget)) target = newTarget;
	}

	@Override
	public @NotNull GoalKey<Mob> getKey() {
		return key;
	}

	@Override
	public @NotNull EnumSet<GoalType> getTypes() {
		return EnumSet.of(GoalType.TARGET);
	}

	@EventHandler
	private void entityRemove(EntityRemoveFromWorldEvent event) {
		if(event.getEntity().equals(mob)) HandlerList.unregisterAll(this);
	}
}
