package magicalpsirevival.mixin;

import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import vazkii.psi.common.item.ItemExosuitSensor;

@Mixin(ItemExosuitSensor.class)
public class ItemExosuitSensorMixin {

    @Shadow
    @Mutable
    public static int defaultColor = 0xEFBFFF;

    @Shadow
    @Mutable
    public static int fireColor = 0xFF1F00;

    @Shadow
    @Mutable
    public static int lightColor = 0xFFDF00;

    @Shadow
    @Mutable
    public static int lowHealthColor = 0x7FFF00;

    @Shadow
    @Mutable
    public static int underwaterColor = 0x003FFF;

}
