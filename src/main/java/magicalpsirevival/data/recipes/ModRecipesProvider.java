package magicalpsirevival.data.recipes;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.common.Tags;

import vazkii.psi.common.Psi;
import vazkii.psi.common.block.base.ModBlocks;
import vazkii.psi.common.item.base.ModItems;
import vazkii.psi.common.lib.ModTags;

public class ModRecipesProvider extends RecipeProvider {

    public ModRecipesProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(packOutput, provider);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput consumer) {
        Criterion<InventoryChangeTrigger.TriggerInstance> hasGold = has(Tags.Items.INGOTS_GOLD);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasIron = has(Tags.Items.INGOTS_IRON);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasPsigem = has(ModTags.GEM_PSIGEM);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasPsimetal = has(ModTags.INGOT_PSIMETAL);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasEbonyPsimetal = has(ModTags.INGOT_EBONY_PSIMETAL);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasIvoryPsimetal = has(ModTags.INGOT_IVORY_PSIMETAL);
        Criterion<InventoryChangeTrigger.TriggerInstance> hasPsidust = has(ModTags.PSIDUST);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.cadAssembler.get())
            .define('G', Tags.Items.INGOTS_GOLD)
            .define('W', ItemTags.LOGS)
            .define('P', Blocks.PISTON)
            .pattern("GWG").pattern("WPW")
            .pattern(" G ")
            .unlockedBy("has_gold", hasGold)
            .save(consumer, Psi.location("assembler"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.programmer.get())
            .define('G', Tags.Items.INGOTS_GOLD)
            .define('M', Items.MAP)
            .define('W', ItemTags.LOGS)
            .define('D', ModTags.PSIDUST)
            .pattern("WMW")
            .pattern("WDW")
            .pattern("G G")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("programmer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyIron.get())
            .define('I', Tags.Items.INGOTS_IRON)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_iron", hasIron)
            .save(consumer, Psi.location("cad_assembly_iron"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyGold.get()).define('I', Tags.Items.INGOTS_GOLD)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_gold", hasGold)
            .save(consumer, Psi.location("cad_assembly_gold"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyPsimetal.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_assembly_psimetal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyEbony.get())
            .define('I', ModTags.INGOT_EBONY_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_ebony_psimetal", hasEbonyPsimetal)
            .save(consumer, Psi.location("cad_assembly_ebony"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadAssemblyIvory.get())
            .define('I', ModTags.INGOT_IVORY_PSIMETAL)
            .define('W', ItemTags.LOGS)
            .pattern("I  ")
            .pattern("IWI")
            .pattern("  I")
            .unlockedBy("has_ivory_psimetal", hasIvoryPsimetal)
            .save(consumer, Psi.location("cad_assembly_ivory"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreBasic.get())
            .define('I', Tags.Items.INGOTS_IRON)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.PSIDUST)
            .pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_core_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreOverclocked.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.INGOT_PSIMETAL).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_core_overclocked"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreConductive.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('P', ModTags.INGOT_PSIMETAL)
            .pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_core_conductive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreHyperClocked.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('P', ModTags.GEM_PSIGEM).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_core_hyperclocked"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadCoreRadiative.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('P', ModTags.GEM_PSIGEM).pattern("I  ")
            .pattern("DPD")
            .pattern("  I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_core_radiative"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketBasic.get())
            .define('W', ItemTags.LOGS)
            .define('D', ModTags.PSIDUST)
            .pattern("DW").pattern("W ")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_socket_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketSignaling.get())
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .pattern("DIW")
            .pattern("IW ")
            .pattern("W  ").unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_signaling"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketLarge.get())
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('I', ModTags.INGOT_PSIMETAL).pattern("DIW")
            .pattern("IW ")
            .pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_large"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketTransmissive.get())
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_REDSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .pattern("DIW")
            .pattern("IG ")
            .pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_transmissive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadSocketHuge.get())
            .define('W', ItemTags.LOGS)
            .define('D', Tags.Items.DUSTS_GLOWSTONE)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .pattern("DIW").pattern("IG ").pattern("W  ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_socket_huge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryBasic.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.PSIDUST)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("cad_battery_basic"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryExtended.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.INGOT_PSIMETAL)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("cad_battery_extended"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.cadBatteryUltradense.get())
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('D', ModTags.GEM_PSIGEM)
            .pattern("I")
            .pattern("D")
            .pattern("I")
            .unlockedBy("has_psigem", hasPsigem)
            .save(consumer, Psi.location("cad_battery_ultradense"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.spellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_basic"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.projectileSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(ItemTags.ARROWS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_projectile"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.loopSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.STRINGS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_loopcast"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.circleSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST).requires(
                Ingredient.fromValues(
                    Stream.of(
                        new Ingredient.TagValue(Tags.Items.SLIME_BALLS),
                        new Ingredient.ItemValue(new ItemStack(Items.SNOWBALL))
                    )
                )
            )
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_circle"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.grenadeSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.GUNPOWDERS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_grenade"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.chargeSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(Tags.Items.DUSTS_REDSTONE)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_charge"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.mineSpellBullet.get())
            .requires(ItemTags.LOGS)
            .requires(Items.PAPER)
            .requires(ModTags.PSIDUST)
            .requires(ItemTags.BUTTONS)
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("spell_bullet_mine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.spellDrive.get())
            .define('W', ItemTags.LOGS)
            .define('P', Items.PAPER)
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.DUSTS_REDSTONE)
            .pattern("WIW")
            .pattern("PRP")
            .pattern("PIP")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("spell_drive"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalShovel.get())
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("GP").pattern(" W").pattern(" I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalPickaxe.get())
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("PGP").pattern(" W ").pattern(" I ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalAxe.get())
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("GP")
            .pattern("PW")
            .pattern(" I")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.psimetalSword.get())
            .define('W', ItemTags.LOGS)
            .define('P', ModTags.INGOT_PSIMETAL)
            .define('G', ModTags.GEM_PSIGEM)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern(" P")
            .pattern("IG")
            .pattern(" W")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("psimetal_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.detonator.get())
            .define('P', ModTags.PSIDUST)
            .define('I', Tags.Items.INGOTS_GOLD)
            .define('B', ItemTags.BUTTONS)
            .pattern(" B ")
            .pattern("IPI")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("detonator"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitController.get())
            .define('W', ItemTags.LOGS)
            .define('P', Items.PAPER)
            .define('R', Tags.Items.DUSTS_REDSTONE)
            .define('G', Tags.Items.GLASS_BLOCKS)
            .define('I', ModTags.INGOT_PSIMETAL).pattern("WRW")
            .pattern("PGP")
            .pattern("WIW")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_controller"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.vectorRuler.get())
            .define('D', ModTags.PSIDUST)
            .define('W', ItemTags.LOGS)
            .define('I', Tags.Items.INGOTS_GOLD)
            .pattern("D")
            .pattern("W")
            .pattern("I")
            .unlockedBy("has_psidust", hasPsidust)
            .save(consumer, Psi.location("vector_ruler"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorLight.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.DUSTS_GLOWSTONE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_light"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorWater.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.GEMS_PRISMARINE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_water"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorHeat.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Items.FIRE_CHARGE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_heat"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorStress.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Items.GLISTERING_MELON_SLICE)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_stress"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.exosuitSensorTrigger.get())
            .define('I', ModTags.INGOT_PSIMETAL)
            .define('R', Tags.Items.INGOTS_GOLD)
            .define('M', Tags.Items.GUNPOWDERS)
            .pattern(" I ")
            .pattern("IMR")
            .pattern(" R ")
            .unlockedBy("has_psimetal", hasPsimetal)
            .save(consumer, Psi.location("exosuit_sensor_trigger"));
    }

}
