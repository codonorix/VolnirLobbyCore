package net.volnir.volnirlobbycore;

import net.volnir.volnirlobbycore.cosmeticbox.banners.gui.BannerGuiClickEvent;
import net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem.CosmeticBoxInteractEvent;
import net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem.CosmeticBoxItemClick;
import net.volnir.volnirlobbycore.cosmeticbox.particles.effects.*;
import net.volnir.volnirlobbycore.cosmeticbox.particles.gui.ParticleGuiClickEvent;
import net.volnir.volnirlobbycore.cosmeticbox.pet.PetContainer;
import net.volnir.volnirlobbycore.cosmeticbox.pet.PetGuiClick;
import net.volnir.volnirlobbycore.cosmeticbox.pet.pets.RemovePetOnLeave;
import net.volnir.volnirlobbycore.cosmeticbox.pet.tempCommand;
import net.volnir.volnirlobbycore.flysystem.FlyCommand;
import net.volnir.volnirlobbycore.joinmessage.JoinMessageSend;
import net.volnir.volnirlobbycore.jukebox.JukeBoxEvent;
import net.volnir.volnirlobbycore.jukebox.JukeBoxInvClickEvent;
import net.volnir.volnirlobbycore.npc.NpcRightClickEvent;
import net.volnir.volnirlobbycore.npc.NpcSpawnCommand;
import net.volnir.volnirlobbycore.sitonentities.SitOnEntiteEvent;
import net.volnir.volnirlobbycore.spawn.SetSpawnCommand;
import net.volnir.volnirlobbycore.staffpunch.StaffPunchEvent;
import net.volnir.volnirlobbycore.userprofile.UserProfileItemClick;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class VolnirLobbyCore extends JavaPlugin {
    private static VolnirLobbyCore instance;
    private static Location spawnLocation;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getSpawnLocation();
        loadParticles();

        // Plugin startup logic
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("pet").setExecutor(new tempCommand());
        this.getCommand("setSpawn").setExecutor(new SetSpawnCommand());
        this.getCommand("spawnnpc").setExecutor(new NpcSpawnCommand());
        this.getCommand("spawnnpc").setTabCompleter(new NpcSpawnCommand());

        Bukkit.getPluginManager().registerEvents(new JoinMessageSend(), this);
        Bukkit.getPluginManager().registerEvents(new JukeBoxEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JukeBoxInvClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SitOnEntiteEvent(), this);
        Bukkit.getPluginManager().registerEvents(new StaffPunchEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PetGuiClick(), this);
        Bukkit.getPluginManager().registerEvents(new RemovePetOnLeave(), this);
        Bukkit.getPluginManager().registerEvents(new OnJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new UserProfileItemClick(), this);
        Bukkit.getPluginManager().registerEvents(new NpcRightClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticBoxItemClick(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticBoxInteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ParticleGuiClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BannerGuiClickEvent(), this);
    }

    @Override
    public void onDisable() {
        for(Entity mob : PetContainer.getPlayerPets().values()) {
            mob.remove();
        }
    }

    public static VolnirLobbyCore getInstance() {
        return instance;
    }

    public static Location getSpawnLocation() {
        if(VolnirLobbyCore.getInstance().getConfig().getLocation("SpawnLocation") == null) {
            Logger logger = Bukkit.getLogger();
            logger.info("================================================");
            logger.info("                 VOLNIR LOBBY");
            logger.info("================================================");
            logger.info("‼‼ No lobby location set. Please set a lobby.");
        }else{
            spawnLocation = VolnirLobbyCore.getInstance().getConfig().getLocation("SpawnLocation");
        }

        return spawnLocation;
    }

    private static void loadParticles() {
        new EmeraldRings().emeraldRings();
        new InLove().inLove();
        new FromTheAshes().coneEffect();
        new ShadowWalk().shadowWalk();
        new RainCloud().rainCloud();
        new PartyTime().partyTime();
        new FlameSpiral().flameSpiral();
        new Angel().angel();
    }
}
