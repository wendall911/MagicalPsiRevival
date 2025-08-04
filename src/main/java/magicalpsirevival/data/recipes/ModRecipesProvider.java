package magicalpsirevival.data.recipes;

import java.util.function.Consumer;
import java.util.stream.Stream;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.common.Tags;

import vazkii.psi.common.Psi;
import vazkii.psi.common.block.base.ModBlocks;
import vazkii.psi.common.item.base.ModItems;
import vazkii.psi.common.lib.ModTags;

public class ModRecipesProvider extends RecipeProvider {

    public ModRecipesProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        CriterionTriggerInstance hasGold = has(Tags.Items.INGOTS_GOLD);
        CriterionTriggerInstance hasIron = has(Tags.Items.INGOTS_IRON);
        CriterionTriggerInstance hasPsigem = has(ModTags.GEM_PSIGEM);
		CriterionTriggerInstance hasPsimetal = has(ModTags.INGOT_PSIMETAL);
		CriterionTriggerInstance hasEbonyPsimetal = has(ModTags.INGOT_EBONY_PSIMETAL);
		CriterionTriggerInstance hasIvoryPsimetal = has(ModTags.INGOT_IVORY_PSIMETAL);
		CriterionTriggerInstance hasPsidust = has(ModTags.PSIDUST);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.cadAssembler)
            .define('G', Tags.Items.INGOTS_GOLD)
            .define('W', ItemTags.LOGS)
            .define('P', Blocks.PISTON)
            .pattern("GWG").pattern("WPW")
            .pattern(" G ")
            .unlockedBy("has_gold", hasGold)
            .save(consumer, Psi.location("assembler"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.programmer)
            .define('G', Tags.Items.INGOTS_GOLD)
            .define('M', Items.MAP)
            .define('W', ItemTags.LOGS)
            .define('D', ModTags.PSIDUST)
            .pattern("WMW")
            .pattern("WDW")
            .pattern("G G")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("programmer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyIron)
            .define('I', Tags.Items.INGOTS_IRON)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_iron", hasIron)
            .save(consumer, Psi.location("cad_assembly_iron"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyGold).define('I', Tags.Items.INGOTS_GOLD)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_gold", hasGold)
            .save(consumer, Psi.location("cad_assembly_gold"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyPsimetal)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_assembly_psimetal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyEbony)
            .define('I', ModTags.INGOT_EBONY_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_ebony_psimetal", hasEbonyPsimetal)
            .save(consumer, Psi.location("cad_assembly_ebony"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyIvory)
            .define('I', ModTags.INGOT_IVORY_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_ivory_psimetal", hasIvoryPsimetal)
            .save(consumer, Psi.location("cad_assembly_ivory"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreBasic)
            .define('I', Tags.Items.INGOTS_IRON)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.PSIDUST)
            .pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_core_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreOverclocked)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.INGOT_PSIMETAL).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_core_overclocked"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreConductive)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('P', ModTags.INGOT_PSIMETAL)
            .pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_core_conductive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreHyperClocked)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.GEM_PSIGEM).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_core_hyperclocked"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreRadiative)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('P', ModTags.GEM_PSIGEM).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_core_radiative"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketBasic)
            .define('W', ItemTags.LOGS)
            .define('D', ModTags.PSIDUST)
            .pattern("DW").pattern("W ")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_socket_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketSignaling)
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .pattern("DIW")
            .pattern("IW ")
            .pattern("W  ").unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_signaling"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketLarge)
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('I', ModTags.INGOT_PSIMETAL).pattern("DIW")
            .pattern("IW ")
            .pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_large"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketTransmissive)
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .pattern("DIW")
            .pattern("IG ")
            .pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_transmissive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketHuge)
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .pattern("DIW").pattern("IG ").pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_huge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryBasic)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.PSIDUST)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_battery_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryExtended)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.INGOT_PSIMETAL)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_battery_extended"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryUltradense)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.GEM_PSIGEM)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_battery_ultradense"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.spellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_basic"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.projectileSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(ItemTags.ARROWS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_projectile"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.loopSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.STRING)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_loopcast"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.circleSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST).requires(
                Ingredient.fromValues(
                    Stream.of(
                        new Ingredient.TagValue(Tags.Items.SLIMEBALLS),
                        new Ingredient.ItemValue(new ItemStack(Items.SNOWBALL))
                    )
                )
            )
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_circle"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.grenadeSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.GUNPOWDER)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_grenade"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.chargeSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.DUSTS_REDSTONE)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_charge"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.mineSpellBullet)
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(ItemTags.BUTTONS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_mine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.spellDrive)
            .define('W', ItemTags.LOGS)
            .define('P', Items.PAPER)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.DUSTS_REDSTONE)
            .pattern("WIW")
            .pattern("PRP")
            .pattern("PIP")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("spell_drive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalShovel)
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("GP").pattern(" W").pattern(" I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalPickaxe)
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("PGP").pattern(" W ").pattern(" I ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalAxe)
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("GP")
            .pattern("PW")
            .pattern(" I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalSword)
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern(" P")
            .pattern("IG")
            .pattern(" W")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.detonator)
            .define('P', ModTags.PSIDUST)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('B', ItemTags.BUTTONS)
            .pattern(" B ")
            .pattern("IPI")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("detonator"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitController)
            .define('W', ItemTags.LOGS)
            .define('P', Items.PAPER)
            .define('R', Tags.Items.DUSTS_REDSTONE)
            .define('G', Tags.Items.GLASS_COLORLESS)
            .define('I', ModTags.INGOT_PSIMETAL).pattern("WRW")
            .pattern("PGP")
            .pattern("WIW")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_controller"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.vectorRuler)
            .define('D', ModTags.PSIDUST)
            .define('W', ItemTags.LOGS)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("D")
            .pattern("W")
            .pattern("I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("vector_ruler"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorLight)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.DUSTS_GLOWSTONE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_light"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorWater)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.GEMS_PRISMARINE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorHeat)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Items.FIRE_CHARGE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_heat"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorStress)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Items.GLISTERING_MELON_SLICE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_stress"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorTrigger)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.GUNPOWDER)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_trigger"));
    }

}
