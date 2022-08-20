package com.kingcast25.resourcegeodes.client.render;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.config.ResourceGeodesClientConfigs;
import com.kingcast25.resourcegeodes.content.block.entity.BuddingBlockEntity;
import com.kingcast25.resourcegeodes.content.item.custom.TierViewerItem;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.awt.*;

public class BuddingBlockBER implements BlockEntityRenderer<BuddingBlockEntity> {


    private final BlockEntityRendererProvider.Context context;

    public static final boolean shouldRenderTiers = ResourceGeodesClientConfigs.RENDER_TIER.get();

    public BuddingBlockBER(BlockEntityRendererProvider.Context ctx){
        context = ctx;
    }





    @Override
    public void render(BuddingBlockEntity ent, float partialTicks, PoseStack stack, MultiBufferSource source, int light, int overlay) {
        //ResourceGeodes.logInfo("Rendering Budding Block Entity");
        //ResourceGeodes.logInfo(ent.getBlockPos().toString());

        for (ItemStack i : Minecraft.getInstance().player.getHandSlots()) {
            if (i.getItem() instanceof TierViewerItem) {
                renderTiers(ent, partialTicks, stack, source, light, overlay);
            }

        }
    }






    private void renderTiers(BuddingBlockEntity ent, float partialTicks, PoseStack stack, MultiBufferSource source, int light, int overlay){
        if (shouldRenderTiers) {
            Color color = new Color(ResourceGeodesClientConfigs.BASE_COLOR.get());

                switch (ent.getGrowthTier()) {
                    case 1:
                        color = new Color(ResourceGeodesClientConfigs.TIER_1_COLOR.get());
                        ResourceGeodes.logInfo(color.toString());
                        break;
                    case 2:
                        color = new Color(ResourceGeodesClientConfigs.TIER_2_COLOR.get());
                        break;
                    case 3:
                        color = new Color(ResourceGeodesClientConfigs.TIER_3_COLOR.get());
                        ResourceGeodes.logInfo(color.toString());
                        break;
                    case 4:
                        color = new Color(ResourceGeodesClientConfigs.TIER_4_COLOR.get());
                        break;
                    case 5:
                        color = cycle(ent.oldColor);
                        ent.oldColor = color;
                        break;
                }

                double x = ent.getBlockPos().getX();
                double y = ent.getBlockPos().getY();
                double z = ent.getBlockPos().getZ();

                float r = color.getRed();
                float g = color.getGreen();
                float b = color.getBlue();
                float a = color.getAlpha();



                AABB box = new AABB(0, 0, 0, 1, 1, 1)
                        .move(x, y, z);
                //.inflate(0.005);

                //Math.sin((ent.getLevel().getGameTime() + partialTicks)*10%360)

                VertexConsumer buffer = MC.renderBuffers().bufferSource().getBuffer(RenderType.lines());
                RenderSystem.lineWidth(Math.max(2.5F, (float) Minecraft.getInstance().getWindow().getWidth() / 1920.0F * 2.5F));
                RenderSystem.depthMask(false);
                stack.pushPose();
                stack.translate(-x, -y, -z);
                LevelRenderer.renderLineBox(stack, buffer, box, r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f);
                stack.popPose();
            }

    }


    public static Minecraft MC = Minecraft.getInstance();

    public static void drawLineBox(PoseStack matrixStack, AABB aabb, Color color) {
        //ResourceGeodes.logInfo("Drawing Line Box");
        Entity camEntity = MC.getCameraEntity();
        double d0 = camEntity.getX();
        double d1 = camEntity.getY() + camEntity.getEyeHeight();
        double d2 = camEntity.getZ();

        RenderSystem.depthMask(false); // disable showing lines through blocks
        VertexConsumer vertexConsumer = MC.renderBuffers().bufferSource().getBuffer(RenderType.lines());

        matrixStack.pushPose();
        matrixStack.translate(-d0, -d1, -d2); // because we start at 0,0,0 relative to camera
        LevelRenderer.renderLineBox(matrixStack, vertexConsumer, aabb,  color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        matrixStack.popPose();



    }



    public Color cycle(Color oldColor){
        float[] values = Color.RGBtoHSB(oldColor.getRed(), oldColor.getGreen(), oldColor.getBlue(), null);
        float hue = values[0] + ResourceGeodesClientConfigs.CYCLE_SPEED.get()/3600f;
        Color newColor = Color.getHSBColor(hue, 0.5f, 1f);
        ResourceGeodes.logInfo(String.valueOf(newColor));
        return newColor;
    }







}
