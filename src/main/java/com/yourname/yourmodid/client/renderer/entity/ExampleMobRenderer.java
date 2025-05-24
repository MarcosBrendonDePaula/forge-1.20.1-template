package com.yourname.yourmodid.client.renderer.entity;

import com.yourname.yourmodid.YourModName;
import com.yourname.yourmodid.client.model.ExampleMobModel; // Import your model
import com.yourname.yourmodid.common.entity.ExampleMobEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleMobRenderer extends MobRenderer<ExampleMobEntity, ExampleMobModel<ExampleMobEntity>> {

    // Define the texture location for your mob
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(YourModName.MODID, "textures/entity/example_mob.png");
    // You will need to create this texture file in src/main/resources/assets/yourmodid/textures/entity/

    public ExampleMobRenderer(EntityRendererProvider.Context pContext) {
        // The second argument is the model instance, the third is the shadow radius
        super(pContext, new ExampleMobModel<>(pContext.bakeLayer(ExampleMobModel.LAYER_LOCATION)), 0.5f); // Use the LayerLocation defined in your model class
        // TODO: Define ExampleMobModel.LAYER_LOCATION in ExampleMobModel.java
        // Example: public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(YourModName.MODID, "example_mob"), "main");

    }

    @Override
    public ResourceLocation getTextureLocation(ExampleMobEntity pEntity) {
        return TEXTURE_LOCATION;
    }

    // You can override other methods here for custom rendering logic, like adding layers (e.g., armor, overlays)
}

