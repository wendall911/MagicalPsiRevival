package magicalpsirevival.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.bus.api.SubscribeEvent;

import magicalpsirevival.data.recipes.ModRecipesProvider;
import magicalpsirevival.MagicalPsiRevival;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = MagicalPsiRevival.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        gen.addProvider(event.includeServer(), new ModRecipesProvider(packOutput, provider));
    }

}
