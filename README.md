## Anti Ender Crystal PVP Plugin
This plugin is designed to prevent players from using ender crystals or respawn anchors to attack other players. Players will still be knocked back & you can still place ender crystals, but no damage is done to players by ender crystals or respawn anchors.

### Config
```yaml
disable-global-crystal-explosion-damage: true
world-list:
  - world_nether
  - world_the_end
```
If `disable-global-crystal-explosion-damage` is `true` - `world-list` functions as a blacklist, excluding worlds from the global block.<br />
If `disable-global-crystal-explosion-damage` is `false` - `world-list` functions as a whitelist, meaning worlds in the list will have explosions blocked.

Original Plugin by Savag3life
