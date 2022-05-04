// Made with Blockbench 3.5.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.minecolonies.coremod.client.model;

import com.minecolonies.api.client.render.modeltype.CitizenModel;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.model.HumanoidModel;

public class ModelEntityAlchemistMale extends CitizenModel<AbstractEntityCitizen>
{

    public ModelEntityAlchemistMale(final ModelPart part)
    {
        super(part);
        hat.visible = false;
    }

    public static LayerDefinition createMesh()
    {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partDefinition = meshdefinition.getRoot();

        PartDefinition HeadDefinition = partDefinition.addOrReplaceChild("head",
          CubeListBuilder.create()
            .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F)
            .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation( 0.5F))
          , PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition shortBeardDefinition = HeadDefinition.addOrReplaceChild("shortBeard",
          CubeListBuilder.create()
            .texOffs(24, 0).addBox(-3.5F, -24.0F, -4.0F, 7.0F, 3.0F, 1.0F)
            .texOffs(24, 4).addBox(-3.5F, -23.0F, -4.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation( 0.5F))
          , PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition glassesDefinition = HeadDefinition.addOrReplaceChild("glasses",
          CubeListBuilder.create()
            .texOffs(64, 48).addBox(-5.5F, -3.6F, -1.3F, 7.0F, 7.0F, 1.0F, new CubeDeformation( -2.0F))
            .texOffs(64, 56).addBox(-1.5F, -3.6F, -1.3F, 7.0F, 7.0F, 1.0F, new CubeDeformation( -2.0F))
            .texOffs(80, 48).addBox(-1.0F, -0.6F, -2.55F, 2.0F, 1.0F, 1.0F, new CubeDeformation( -0.3F))
            .texOffs(81, 49).addBox(-4.8F, -0.9F, -2.89F, 2.0F, 2.0F, 5.0F, new CubeDeformation( -0.6F))
            .texOffs(80, 56).addBox(2.8F, -0.9F, -2.89F, 2.0F, 2.0F, 5.0F, new CubeDeformation( -0.6F))
          , PartPose.offset(0.0F, -3.7F, -2.1F));

        PartDefinition PointHatDefinition = HeadDefinition.addOrReplaceChild("PointHat",
          CubeListBuilder.create()
            .texOffs(96, 0).addBox(-4.0F, -2.19F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation( 0.81F))
            .texOffs(76, 10).addBox(-8.0F, -0.4F, -5.0F, 16.0F, 1.0F, 10.0F)
            .texOffs(98, 21).addBox(-5.0F, -0.4F, -8.0F, 10.0F, 1.0F, 3.0F)
            .texOffs(93, 21).addBox(-7.0F, -0.4F, -7.0F, 2.0F, 1.0F, 2.0F)
            .texOffs(85, 21).addBox(5.0F, -0.4F, -7.0F, 2.0F, 1.0F, 2.0F)
            .texOffs(93, 25).addBox(-7.0F, -0.4F, 5.0F, 2.0F, 1.0F, 2.0F)
            .texOffs(85, 25).addBox(5.0F, -0.4F, 5.0F, 2.0F, 1.0F, 2.0F)
            .texOffs(98, 25).addBox(-5.0F, -0.4F, 5.0F, 10.0F, 1.0F, 3.0F)
          , PartPose.offset(0.0F, -6.2F, -0.1F));

        PartDefinition top4_r1Definition = PointHatDefinition.addOrReplaceChild("top4_r1",
          CubeListBuilder.create()
            .texOffs(84, 0).addBox(-0.3F, -9.5F, -2.4F, 2.0F, 3.0F, 2.0F)
          , PartPose.offset(0.0F, 0.1F, -0.4F));

        PartDefinition top3_r1Definition = PointHatDefinition.addOrReplaceChild("top3_r1",
          CubeListBuilder.create()
            .texOffs(88, 1).addBox(-2.5F, -7.5F, -1.8F, 4.0F, 3.0F, 4.0F)
          , PartPose.offset(0.0F, 0.1F, -0.4F));

        PartDefinition top2_r1Definition = PointHatDefinition.addOrReplaceChild("top2_r1",
          CubeListBuilder.create()
            .texOffs(58, 9).addBox(-3.5F, -4.9F, -3.8F, 7.0F, 3.0F, 7.0F)
          , PartPose.offset(0.0F, 0.1F, 0.0F));

        PartDefinition BodyDefinition = partDefinition.addOrReplaceChild("body",
          CubeListBuilder.create()
            .texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F)
            .texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation( 0.25F))
            .texOffs(102, 36).addBox(-4.0F, -5.2F, -2.5F, 8.0F, 2.0F, 5.0F, new CubeDeformation( 0.21F))
            .texOffs(108, 43).addBox(-5.0F, -3.0F, 2.7F, 10.0F, 18.0F, 0.0F)
          , PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition capeBodyDefinition = BodyDefinition.addOrReplaceChild("capeBody",
          CubeListBuilder.create()
            .texOffs(102, 36).addBox(-4.0F, -5.2F, -2.5F, 8.0F, 2.0F, 5.0F, new CubeDeformation( 0.21F))
            .texOffs(108, 43).addBox(-5.0F, -3.0F, 2.7F, 10.0F, 18.0F, 0.0F)
          , PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition Potion1Definition = BodyDefinition.addOrReplaceChild("Potion1",
          CubeListBuilder.create()
            .texOffs(81, 37).addBox(-1.4152F, 3.4965F, -1.4F, 5.0F, 6.0F, 5.0F, new CubeDeformation( -1.4F))
            .texOffs(91, 52).addBox(-0.9152F, 4.2965F, -0.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation( -1.3F))
            .texOffs(96, 48).addBox(0.0848F, 3.6465F, 0.1F, 2.0F, 2.0F, 2.0F, new CubeDeformation( -0.5F))
            .texOffs(61, 40).addBox(-1.4152F, 5.1465F, -1.4F, 5.0F, 3.0F, 5.0F, new CubeDeformation( -1.3F))
          , PartPose.offset(1.1F, 4.78F, -4.2F));

        PartDefinition IngredientPouchDefinition = BodyDefinition.addOrReplaceChild("IngredientPouch",
          CubeListBuilder.create()
            .texOffs(78, 35).addBox(-1.1333F, -0.9417F, -0.35F, 2.0F, 1.0F, 1.0F, new CubeDeformation( -0.1F))
            .texOffs(79, 33).addBox(-0.6333F, -1.4417F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation( -0.25F))
            .texOffs(84, 33).addBox(-1.6333F, -0.2417F, -0.35F, 3.0F, 3.0F, 1.0F)
            .texOffs(86, 28).addBox(-1.6333F, -0.1417F, -1.45F, 3.0F, 3.0F, 2.0F, new CubeDeformation( -0.4F))
            .texOffs(97, 36).addBox(-1.3333F, -1.9417F, -0.65F, 4.0F, 4.0F, 1.0F, new CubeDeformation( -1.0F))
          , PartPose.offset(-2.0667F, 10.3417F, -2.65F));

        PartDefinition top_r1Definition = IngredientPouchDefinition.addOrReplaceChild("top_r1",
          CubeListBuilder.create()
            .texOffs(81, 31).addBox(-0.5F, -2.65F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation( -0.1F))
          , PartPose.offset(-0.1333F, 1.3583F, 0.15F));

        PartDefinition Right_ArmDefinition = partDefinition.addOrReplaceChild("right_arm",
          CubeListBuilder.create()
            .texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F)
            .texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation( 0.25F))
          , PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition capeShoulderRightDefinition = Right_ArmDefinition.addOrReplaceChild("capeShoulderRight",
          CubeListBuilder.create()
            .texOffs(110, 29).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation( 0.2F))
          , PartPose.offset(-1.1F, -1.2F, 0.0F));

        PartDefinition Left_ArmDefinition = partDefinition.addOrReplaceChild("left_arm",
          CubeListBuilder.create()
            .texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F)
            .texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation( 0.25F))
          , PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition capeShoulderLeftDefinition = Left_ArmDefinition.addOrReplaceChild("capeShoulderLeft",
          CubeListBuilder.create()
            .texOffs(92, 29).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation( 0.2F))
          , PartPose.offset(1.1F, -1.2F, 0.0F));

        PartDefinition Right_LegDefinition = partDefinition.addOrReplaceChild("right_leg",
          CubeListBuilder.create()
            .texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F)
            .texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation( 0.25F))
          , PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition Left_LegDefinition = partDefinition.addOrReplaceChild("left_leg",
          CubeListBuilder.create()
            .texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F)
            .texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation( 0.25F))
          , PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }
}
