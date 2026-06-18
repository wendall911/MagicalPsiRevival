# MagicalPsiRevival — Project Context

## What This Is
A remake of [Magical Psi Redux](https://www.curseforge.com/minecraft/mc-mods/magical-psi-redux) (TheIllusiveC4), which was itself a remake of the original
[Magical Psi](https://www.curseforge.com/minecraft/mc-mods/magical-psi) (Wiiv). Replaces every asset and description of the [Psi](https://www.curseforge.com/minecraft/mc-mods/psi) mod with magic-themed counterparts, including recipe changes for thematic consistency.

Required client+server for full consistency due to recipe changes. Can be installed client-only if needed, but recipe changes will not apply.

License: Psi License (assets/overall); MIT (code)

## Project Structure
Forge-only: `src/` at repo root (single-loader layout)

## Branch Convention
| Branch | Modloaders |
|--------|------------|
| 1.20.1 | Forge      |
| 1.21.1 | NeoForge   |

Maintained: 1.20.1, 1.21.1

## Dependencies
- Psi (required at runtime — this mod is an asset/recipe replacement for it)

## Distribution
Side: both (clientRequired = true, serverRequired = true; client-only install is functional but loses recipe consistency)

## Release Process
Follow the standard wendall911 release process in `../docs/minecraft/MINECRAFT_DEVELOPMENT_NOTES.md`.
