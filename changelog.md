### 1.1.2
* As per recommendations the key binds are always registered. They will be ignored if use key toggle is false
* Bumped NeoForge version to 21.4.67-beta
* Unified configuration files to be names equally and all lowercase

### 1.1.1
* Code cleanup
* Added Homepage and Sources links to Fabric fabric.mod.json file
* Added issueTrackerURL and displayURL to NeoForge neoforge.mods.toml file
* Added flag clientSideOnly to Forge mods.toml file
* Added mod_logo_file as a property and implemented it on the respective files
* General cleanup of files mods.toml and neoforge.mods.toml
* Attempt to fix order of configs/key binds registration in Forge version (Hopefully still works)

### 1.1.0
* Standardized functionality between the different launchers
* Settings match in all versions
* Invisible Barrier setting ignores the key toggle or default state (If true barriers wont show the highlight, if false they will)
* If Use Key is false, no key bind will show on the Controls settings.