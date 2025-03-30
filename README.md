# PearlTweaks

PearlTweaks is a Minecraft plugin for Spigot 1.17.1+ designed to enhance the mechanics of Ender Pearls. This plugin provides various customization options, allowing server administrators to tweak how Ender Pearls behave, including disabling pearl damage, modifying throw velocity, and setting custom cooldowns.

## Features
- Disable Ender Pearl usage entirely.
- Prevent Ender Pearls from being thrown beyond world borders.
- Adjust the velocity of thrown Ender Pearls.
- Disable or customize Ender Pearl damage.
- Set custom cooldown times for Ender Pearl usage.
- Permissions for bypassing cooldowns and damage restrictions.

## Installation
1. Download the latest version of PearlTweaks.
2. Place the .jar file in your server's `plugins` folder.
3. Restart or reload your server.
4. Configure the plugin via `config.yml` as needed.

## Configuration
PearlTweaks provides a configuration file (`config.yml`) that allows server owners to tweak various Ender Pearl settings, such as:
- Enabling/disabling Ender Pearl usage.
- Adjusting the throw velocity.
- Customizing damage taken from teleportation.
- Setting cooldown times for Ender Pearl throws.

## Commands
- `/pearltweaks reload` (Aliases: `/pt reload`) - Reloads the plugin configuration.

## Permissions
- `pearltweaks.command` - Allows use of the PearlTweaks command (default: OP).
- `pearltweaks.bypasscooldown` - Allows players to bypass Ender Pearl cooldown.
- `pearltweaks.disabledamage` - Prevents players from taking damage from Ender Pearl teleportation.

