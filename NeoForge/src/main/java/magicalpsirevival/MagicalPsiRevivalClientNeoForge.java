package magicalpsirevival;

import net.minecraft.client.model.geom.builders.LayerDefinition;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import vazkii.psi.client.model.ModModelLayers;

import magicalpsirevival.client.FocusingPlateModel;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = MagicalPsiRevival.MODID, value = Dist.CLIENT)
public class MagicalPsiRevivalClientNeoForge {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent evt) {
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(ModModelLayers.PSIMETAL_EXOSUIT_INNER_ARMOR,
            () -> LayerDefinition.create(FocusingPlateModel.createInsideMesh(), 64, 128));
        evt.registerLayerDefinition(ModModelLayers.PSIMETAL_EXOSUIT_OUTER_ARMOR,
            () -> LayerDefinition.create(FocusingPlateModel.createOutsideMesh(), 64, 128));
    }

}
