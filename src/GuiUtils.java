
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.GameRenderer;
import java.awt.*;

public class GuiUtils {

    // ** Gradient Shape ** //
    public static void drawGradientRect(Matrix4f mat, int zLevel, int left, int top, int right, int bottom, int startColor, int endColor) {
        float startAlpha = (float) (startColor >> 24 & 255) / 255.0F;
        float startRed = (float) (startColor >> 16 & 255) / 255.0F;
        float startGreen = (float) (startColor >> 8 & 255) / 255.0F;
        float startBlue = (float) (startColor & 255) / 255.0F;
        float endAlpha = (float) (endColor >> 24 & 255) / 255.0F;
        float endRed = (float) (endColor >> 16 & 255) / 255.0F;
        float endGreen = (float) (endColor >> 8 & 255) / 255.0F;
        float endBlue = (float) (endColor & 255) / 255.0F;

        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder buffer = tessellator.getBuilder();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        buffer.vertex(mat, right, top, zLevel).color(startRed, startGreen, startBlue, startAlpha).endVertex();
        buffer.vertex(mat, left, top, zLevel).color(startRed, startGreen, startBlue, startAlpha).endVertex();
        buffer.vertex(mat, left, bottom, zLevel).color(endRed, endGreen, endBlue, endAlpha).endVertex();
        buffer.vertex(mat, right, bottom, zLevel).color(endRed, endGreen, endBlue, endAlpha).endVertex();
        tessellator.end();

        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    // ** Generic Rectangle ** //
    public static void drawRect(Matrix4f mat, int p_drawRect_0_, int p_drawRect_1_, int p_drawRect_2_, int p_drawRect_3_, int p_drawRect_4_) {
        int lvt_5_2_;
        if (p_drawRect_0_ < p_drawRect_2_) {
            lvt_5_2_ = p_drawRect_0_;
            p_drawRect_0_ = p_drawRect_2_;
            p_drawRect_2_ = lvt_5_2_;
        }

        if (p_drawRect_1_ < p_drawRect_3_) {
            lvt_5_2_ = p_drawRect_1_;
            p_drawRect_1_ = p_drawRect_3_;
            p_drawRect_3_ = lvt_5_2_;
        }

        float lvt_5_3_ = (float) (p_drawRect_4_ >> 24 & 255) / 255.0F;
        float lvt_6_1_ = (float) (p_drawRect_4_ >> 16 & 255) / 255.0F;
        float lvt_7_1_ = (float) (p_drawRect_4_ >> 8 & 255) / 255.0F;
        float lvt_8_1_ = (float) (p_drawRect_4_ & 255) / 255.0F;

        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder buffer = tessellator.getBuilder();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        buffer.vertex(mat, p_drawRect_0_, p_drawRect_3_, 0.0F).color(lvt_6_1_, lvt_7_1_, lvt_8_1_, lvt_5_3_).endVertex();
        buffer.vertex(mat, p_drawRect_2_, p_drawRect_3_, 0.0F).color(lvt_6_1_, lvt_7_1_, lvt_8_1_, lvt_5_3_).endVertex();
        buffer.vertex(mat, p_drawRect_2_, p_drawRect_1_, 0.0F).color(lvt_6_1_, lvt_7_1_, lvt_8_1_, lvt_5_3_).endVertex();
        buffer.vertex(mat, p_drawRect_0_, p_drawRect_1_, 0.0F).color(lvt_6_1_, lvt_7_1_, lvt_8_1_, lvt_5_3_).endVertex();
        tessellator.end();

        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    // ** Configurable Shape (Curve, Fill, Linewidth). Also can do circles due to the curve by (2) for height & curve ** //
    public static void drawShape(Region region, PoseStack poseStack, int color, int curve, boolean fill, float lineWidth) {
        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tesselator.getBuilder();
        Matrix4f matrix4f = poseStack.last().pose();
        if (!fill) {
            GL11.glLineWidth(lineWidth);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        }
        else
            bufferBuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
        drawRoundedSquare(bufferBuilder, matrix4f, region, curve, color);
        if (!fill) {
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            GL11.glLineWidth(1f);
        }
        tesselator.end();
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
    }

    public static void drawRoundedSquare(BufferBuilder wr, Matrix4f matrix, Region region, int curve, int color) {
        Color c = new Color(color);

        wr.vertex(matrix, (float) region.x, (float) (region.y + curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        wr.vertex(matrix, (float) region.x, (float) (region.getBottom() - curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        if (curve != 0)
            addArch(wr, matrix, region.x + curve, region.getBottom() - curve, curve, 270, 360, c);
        wr.vertex(matrix, (float) (region.x + curve), (float) region.getBottom(), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        wr.vertex(matrix, (float) (region.getRight() - curve), (float) region.getBottom(), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        if (curve != 0)
            addArch(wr, matrix, region.getRight() - curve, region.getBottom() - curve, curve, 0, 90, c);
        wr.vertex(matrix, (float) region.getRight(), (float) (region.getBottom() - curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        wr.vertex(matrix, (float) region.getRight(), (float) (region.y + curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        if (curve != 0)
            addArch(wr, matrix, region.getRight() - curve, region.y + curve, curve, 90, 180, c);
        wr.vertex(matrix, (float) (region.getRight() - curve), (float) region.y, 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        wr.vertex(matrix, (float) (region.x + curve), (float) region.y, 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        if (curve != 0)
            addArch(wr, matrix, region.x + curve, region.y + curve, curve, 180, 270, c);
    }

    // ** Draw an image with a custom size e.g (16x16, 32x32) ** //
    public static void drawTexturedModalRect(PoseStack poseStack, int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
        float f = 1.0F / textureWidth;
        float f1 = 1.0F / textureHeight;

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder wr = tessellator.getBuilder();
        wr.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        wr.vertex(x, y + height, 0.0D).uv((u * f), (((v + (float)height) * f1))).endVertex();
        wr.vertex(x + width, y + height, 0.0D).uv(((u + (float)width) * f), ((v + (float)height) * f1)).endVertex();
        wr.vertex(x + width, y, 0.0D).uv(((u + (float)width) * f), (v * f1)).endVertex();
        wr.vertex(x, y, 0.0D).uv((u * f), (v * f1)).endVertex();
        tessellator.end();
    }

    public static void addArch(BufferBuilder wr, Matrix4f matrix, int x, int y, int radius, int startAngle, int endAngle, Color c) {
        for (int i = startAngle; i < endAngle; i++) {
            wr.vertex(matrix, (float) (x + Math.sin(i * Math.PI / 180) * radius), (float) (y + Math.cos(i * Math.PI / 180) * radius), 0.0F)
                    .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).endVertex();
        }
    }
}
