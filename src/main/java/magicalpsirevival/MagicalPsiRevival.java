package magicalpsirevival;

import java.nio.file.Path;
import java.util.Optional;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;

import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforgespi.locating.IModFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MagicalPsiRevival.MODID)
public class MagicalPsiRevival {

    public static final String MODID = "magipsi";
    public static final Logger LOGGER = LoggerFactory.getLogger(MagicalPsiRevival.MODID);

    public MagicalPsiRevival(IEventBus eventBus) {
        eventBus.addListener(this::addPackFinders);
    }

    private void addPackFinders(final AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            addPsiOverridesPack(event);
        }
    }

    private void addPsiOverridesPack(final AddPackFindersEvent event) {
        IModFile modFile = ModList.get().getModFileById(MODID).getFile();
        Path path = modFile.findResource("psi_overrides");
        final PackLocationInfo packLocationInfo = new PackLocationInfo(
            "builtin/psi_overrides",
            Component.literal("Magical Psi Revival - Psi Overrides"),
            PackSource.BUILT_IN,
            Optional.empty()
        );

        final PackResources packResources = new PathPackResources(
            packLocationInfo,
            path
        );

        LOGGER.info("Adding Psi Overrides Pack from {}", path.getFileName());

        event.addRepositorySource(consumer -> {
            Pack pack = Pack.readMetaAndCreate(
                packLocationInfo,
                new SinglePackResourceResourcesSupplier(packResources),
                PackType.CLIENT_RESOURCES,
                new PackSelectionConfig(true, Pack.Position.TOP, true)
            );

            if (pack != null) {
                consumer.accept(pack);
            }
            else {
                LOGGER.error("Failed to create pack for Psi Overrides from {}", path.getFileName());
            }
        });
    }

    private record SinglePackResourceResourcesSupplier(PackResources packResources) implements Pack.ResourcesSupplier {

        @Override
        public PackResources openPrimary(PackLocationInfo location) {
            return packResources();
        }

        @Override
        public PackResources openFull(PackLocationInfo location, Pack.Metadata metadata) {
            return packResources();
        }

    }

}
