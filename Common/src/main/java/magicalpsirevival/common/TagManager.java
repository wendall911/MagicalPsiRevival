package magicalpsirevival.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagManager {

    public static class Items {

        public static final TagKey<Item> INGOTS_GOLD = createCommon("ingots/gold");
        public static final TagKey<Item> INGOTS_IRON = createCommon("ingots/iron");
        public static final TagKey<Item> DUSTS_REDSTONE = createCommon("dusts/redstone");
        public static final TagKey<Item> DUSTS_GLOWSTONE = createCommon("dusts/glowstone");
        public static final TagKey<Item> SLIME_BALLS = createCommon("slime_balls");
        public static final TagKey<Item> GUNPOWDERS = createCommon("gunpowders");
        public static final TagKey<Item> GLASS_BLOCKS = createCommon("glass_blocks");
        public static final TagKey<Item> GEMS_PRISMARINE = createCommon("gems/prismarine");
        public static final TagKey<Item> STRINGS = createCommon("strings");

        private static TagKey<Item> createCommon(String id) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", id));
        }
    }

}
