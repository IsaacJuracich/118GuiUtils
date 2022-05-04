import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.renderer.GameRenderer;
import java.util.function.BiConsumer;

public class RenderUtils {

    public static void poseStackProper(PoseStack stack, Runnable runnable) {
        stack.pushPose();
        runnable.run();
        stack.popPose();
    }

    public static void properRenderSystem(boolean color, Runnable runnable) {
        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        if (color)
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
        runnable.run();
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        if (color)
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void tesselatorNbufferbuilder(BiConsumer<Tesselator, BufferBuilder> callback) {
        Tesselator tess = Tesselator.getInstance();
        BufferBuilder buffer = tess.getBuilder();
        callback.accept(tess, buffer);
    }
}