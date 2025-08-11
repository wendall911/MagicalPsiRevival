package magicalpsirevival.client;

import net.minecraft.client.model.geom.builders.LayerDefinition;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.client.model.ModModelLayers;
import vazkii.psi.common.item.ItemExosuitSensor;

import magicalpsirevival.MagicalPsiRevival;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MagicalPsiRevival.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagicalPsiRevivalClient {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent evt) {
        SpellParam.RED = 0xFF003F;
        SpellParam.GREEN = 0x3FFF00;
        SpellParam.BLUE = 0x007FFF;
        SpellParam.PURPLE = 0xBF7FFF;
        SpellParam.CYAN = 0x00FFBF;
        SpellParam.YELLOW = 0xFFBF00; // For entities
        SpellParam.GRAY = 0x3F3F3F; // For connectors

        ItemExosuitSensor.defaultColor = 0xEFBFFF;
        ItemExosuitSensor.fireColor = 0xFF1F00;
        ItemExosuitSensor.lightColor = 0xFFDF00;
        ItemExosuitSensor.lowHealthColor = 0x7FFF00;
        ItemExosuitSensor.underwaterColor = 0x003FFF;
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(ModModelLayers.PSIMETAL_EXOSUIT_INNER_ARMOR,
            () -> LayerDefinition.create(FocusingPlateModel.createInsideMesh(), 64, 128));
        evt.registerLayerDefinition(ModModelLayers.PSIMETAL_EXOSUIT_OUTER_ARMOR,
            () -> LayerDefinition.create(FocusingPlateModel.createOutsideMesh(), 64, 128));
    }
}

