package magicalpsirevival;

import java.io.IOException;
import java.nio.file.Path;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;

import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MagicalPsiRevival.MODID)
public class MagicalPsiRevival {

    public static final String MODID = "magipsi";
    public static final Logger LOGGER = LoggerFactory.getLogger(MagicalPsiRevival.MODID);

    @SuppressWarnings("removal")
    public MagicalPsiRevival() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

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
        PathPackResources pathResourcePack = new PathPackResources(modFile.getFileName() + ":" + path, true, path);
        Pack.ResourcesSupplier resourcesSupplier = (string) -> pathResourcePack;

        LOGGER.info("Adding Psi Overrides Pack from {}", path.getFileName());

        try {
            PackMetadataSection packMetadataSection = pathResourcePack.getMetadataSection(PackMetadataSection.TYPE);

            if (packMetadataSection != null) {
                event.addRepositorySource((consumer) -> consumer.accept(Pack.readMetaAndCreate(
                    "builtin/psi_overrides",
                    Component.literal("Magical Psi Revival - Psi Overrides"),
                    true,
                    resourcesSupplier,
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    PackSource.BUILT_IN
                )));
            } else {
                LOGGER.error("No valid pack metadata found for {}", path.getFileName());
            }
        }
        catch (IOException e) {
            LOGGER.error("Failed to load pack metadata for {}", path.getFileName(), e);
        }
    }

}
