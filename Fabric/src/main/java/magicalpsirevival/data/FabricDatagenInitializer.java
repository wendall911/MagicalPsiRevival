package magicalpsirevival.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import magicalpsirevival.MagicalPsiRevival;
import magicalpsirevival.data.recipes.ModRecipesProvider;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        if (System.getProperty(MagicalPsiRevival.MODID + ".common_datagen") != null) {
            configureCommonDatagen(pack);
        }
        else {
            configureFabricDatagen(pack);
        }
    }

    /*
     * Datagen common across all modloaders.
     */
    public static void configureCommonDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(ModRecipesProvider::new);
    }

    /*
     * Fabric only datagen.
     */
    public static void configureFabricDatagen(FabricDataGenerator.Pack pack) {
    }

}
