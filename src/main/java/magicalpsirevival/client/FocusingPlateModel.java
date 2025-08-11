package magicalpsirevival.client;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class FocusingPlateModel {

    public static MeshDefinition createInsideMesh() {
        CubeDeformation deformation = new CubeDeformation(0.01f);
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild(
            "body",
            CubeListBuilder.create().addBox( -1.0F, 0.0F, -1.0F, 2, 2, 2, deformation),
            PartPose.ZERO
        );
        PartDefinition belt = body.addOrReplaceChild(
            "belt",
            CubeListBuilder.create()
                .texOffs(0, 53)
                .addBox(-2.5F, 8.0F, -4.0F, 5, 13, 3),
            PartPose.rotation(-0.08726646259971647F, 0.0F, 0.0F)
        );
        PartDefinition leftLeg = root.addOrReplaceChild(
            "left_leg",
            CubeListBuilder.create()
                .mirror()
                .texOffs(0, 69)
                .addBox(-1.39F, 1.0F, -2.49F, 4, 5, 5, deformation),
            PartPose.offset(1.9F, 12.0F, 0.0F)
        );
        PartDefinition leftSkirt = leftLeg.addOrReplaceChild(
            "left_skirt",
            CubeListBuilder.create()
                .mirror()
                .texOffs(16, 53)
                .addBox(-1.5F, 0.0F, -0.5F, 5, 13, 6, deformation),
            PartPose.offsetAndRotation(
                0.5F,
                -2.0F,
                -2.5F,
                0.0F,
                -0.17453292519943295F,
                -0.2617993877991494F
            )
        );
        PartDefinition rightLeg = root.addOrReplaceChild(
            "right_leg",
            CubeListBuilder.create()
                .texOffs(0, 69)
                .addBox(-2.61F, 1.0F, -2.51F, 4, 5, 5, deformation),
            PartPose.offset(-1.9F, 12.0F, 0.0F)
        );
        PartDefinition rightSkirt = rightLeg.addOrReplaceChild(
            "right_skirt",
            CubeListBuilder.create()
                .texOffs(16, 53)
                .addBox(-3.5F, 0.0F, -0.5F, 5, 13, 6, deformation),
            PartPose.offsetAndRotation(
                0.5F,
                -2.0F,
                -2.5F,
                0.0F,
                0.17453292519943295F,
                0.2617993877991494F
            )
        );

        return mesh;
    }

    public static MeshDefinition createOutsideMesh() {
        CubeDeformation deformation = new CubeDeformation(0.01F);
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        // helm
        PartDefinition head = root.addOrReplaceChild(
            "head",
            CubeListBuilder.create()
                .addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, deformation),
            PartPose.ZERO
        );
        PartDefinition helm = head.addOrReplaceChild(
            "helm",
            CubeListBuilder.create()
                .addBox(-4.5F, -9.0F, -5.0F, 9, 9, 10, deformation),
            PartPose.ZERO
        );

        // sensor
        PartDefinition sensor = helm.addOrReplaceChild(
            "sensor",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .addBox(-1.5F, -7.0F, -1.0F, 3, 13, 5, deformation),
            PartPose.offset(0.0f, -5.0f, -5.0f));
        PartDefinition sensorColor = sensor.addOrReplaceChild(
            "sensorColor",
            CubeListBuilder.create()
                .mirror()
                .addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, deformation),
            PartPose.offset(0.0f, -6.0f, 6.0f)
        );

        // body
        PartDefinition body = root.addOrReplaceChild(
            "body",
            CubeListBuilder.create()
                .addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, deformation),
            PartPose.ZERO
        );
        PartDefinition bodyMain = body.addOrReplaceChild(
            "body_main",
            CubeListBuilder.create()
                .texOffs(0, 19)
                .addBox(-4.5F, -0.5F, -3.0F, 9, 7, 6, deformation),
            PartPose.ZERO
        );

        // leftArm
        PartDefinition leftArm = root.addOrReplaceChild(
            "left_arm",
            CubeListBuilder.create()
                .mirror().addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, deformation),
            PartPose.offset(4.0f, 2.0f, 0.0f)
        );
        PartDefinition leftArmMain = leftArm.addOrReplaceChild(
            "left_arm_main",
            CubeListBuilder.create()
                .texOffs(0, 44).mirror()
                .addBox(0.5F, 6.0F, -2.5F, 3, 4, 5, deformation),
            PartPose.ZERO
        );
        PartDefinition leftArmPauldron = leftArmMain.addOrReplaceChild(
            "left_arm_pauldron",
            CubeListBuilder.create()
                .texOffs(0, 32)
                .mirror()
                .addBox(1.0F, -2.5F, -2.5F, 3, 7, 5, deformation),
            PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0F, 0.0F, -0.17453292519943295F)
        );
        PartDefinition leftArmCrystal = leftArmPauldron.addOrReplaceChild(
            "left_arm_crystal",
            CubeListBuilder.create()
                .texOffs(16, 32)
                .mirror()
                .addBox(2.5F, -5.5F, -1.5F, 3, 11, 3, deformation),
            PartPose.ZERO
        );

        // rightArm
        PartDefinition rightArm = root.addOrReplaceChild(
            "right_arm",
            CubeListBuilder.create()
                .mirror()
                .addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, deformation),
            PartPose.offset(-4.0f, 2.0f, 0.0f)
        );
        PartDefinition rightArmMain = rightArm.addOrReplaceChild(
            "right_arm_main",
            CubeListBuilder.create()
                .texOffs(0, 44)
                .addBox(-3.5F, 6.0F, -2.51F, 3, 4, 5, deformation),
            PartPose.ZERO
        );
        PartDefinition rightArmPauldron = rightArmMain.addOrReplaceChild(
            "right_arm_pauldron",
            CubeListBuilder.create()
                .texOffs(0, 32)
                .addBox(-4.0F, -2.5F, -2.5F, 3, 7, 5, deformation),
            PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.0F, 0.0F, 0.17453292519943295F)
        );
        PartDefinition rightArmCrystal = rightArmPauldron.addOrReplaceChild(
            "right_arm_crystal",
            CubeListBuilder.create()
                .texOffs(16, 32)
                .addBox(-5.5F, -5.5F, -1.5F, 3, 11, 3, deformation),
            PartPose.ZERO
        );

        // boots
        PartDefinition bootL = root.addOrReplaceChild(
            "left_leg",
            CubeListBuilder.create()
                .texOffs(0, 80)
                .mirror()
                .addBox(-2.39F, 8.0F, -2.49F, 5, 4, 5, deformation),
            PartPose.offset(1.9F, 12.0F, 0.0F)
        );
        PartDefinition bootR = root.addOrReplaceChild(
            "right_leg",
            CubeListBuilder.create()
                .texOffs(0, 80)
                .addBox(-2.61F, 8.0F, -2.51F, 5, 4, 5, deformation),
            PartPose.offset(-1.9F, 12.0F, 0.0F)
        );

        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        return mesh;
    }

}
