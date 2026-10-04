package magicalpsirevival.mixin;

import net.minecraft.client.model.geom.builders.MeshDefinition;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import vazkii.psi.client.model.ModelPsimetalExosuit;

import magicalpsirevival.client.FocusingPlateModel;

@Mixin(ModelPsimetalExosuit.class)
public class ModelPsimetalExosuitMixin {

    @Inject(method = "createInsideMesh", at = @At("HEAD"), cancellable = true)
    private static void createInsideMesh(CallbackInfoReturnable<MeshDefinition> cir) {
        cir.setReturnValue(FocusingPlateModel.createInsideMesh());
    }

    @Inject(method = "createOutsideMesh", at = @At("HEAD"), cancellable = true)
    private static void createOutsideMesh(CallbackInfoReturnable<MeshDefinition> cir) {
        cir.setReturnValue(FocusingPlateModel.createOutsideMesh());
    }

}
