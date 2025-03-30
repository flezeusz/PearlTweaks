package pl.flezy.pearltweaks;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final PearlTweaks p;
    public Config(PearlTweaks p) {
        this.p = p;
    }

    public boolean disablePearl;
    public boolean throwBeyondBorder;
    public double velocityMultiplier;
    public boolean disableDamage;

    public boolean customDamageEnable;
    public double customDamageAmount;

    public boolean customCooldownEnable;
    public int customCooldownTime;


    public void reload() {
        p.reloadConfig();
        FileConfiguration config = p.getConfig();

        disablePearl = config.getBoolean("disablePearl");
        throwBeyondBorder = config.getBoolean("throwBeyondBorder");
        velocityMultiplier = config.getDouble("velocityMultiplier");
        disableDamage = config.getBoolean("disableDamage");

        customDamageEnable = config.getBoolean("customDamage.enable");
        customDamageAmount = config.getDouble("customDamage.amount");

        customCooldownEnable = config.getBoolean("customCooldown.enable");
        customCooldownTime = config.getInt("customCooldown.time");
    }
}
