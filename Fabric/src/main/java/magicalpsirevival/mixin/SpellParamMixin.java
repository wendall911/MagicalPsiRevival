package magicalpsirevival.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import vazkii.psi.api.spell.SpellParam;

@Mixin(SpellParam.class)
public class SpellParamMixin {

    @Shadow
    @Mutable
    public static int RED = 0xFF003F;

    @Shadow
    @Mutable
    public static int GREEN = 0x3FFF00;

    @Shadow
    @Mutable
    public static int BLUE = 0x007FFF;

    @Shadow
    @Mutable
    public static int PURPLE = 0xBF7FFF;

    @Shadow
    @Mutable
    public static int CYAN = 0x00FFBF;

    @Shadow
    @Mutable
    public static int YELLOW = 0xFFBF00;

    @Shadow
    @Mutable
    public static int GRAY = 0x3F3F3F;

}
