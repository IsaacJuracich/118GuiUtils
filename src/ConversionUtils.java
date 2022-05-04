import net.optifine.Config;

public class ConversionUtils {

    // ** Fixes FPS String ** //
    public static String getFPS() {
        return Config.getFpsString().split("/")[0] + " FPS";
    }

    // ** Call with Potion Id ** //
    public static String potionNameFix(String potionName) {
        return capitalizeString(potionName.replace("_", " ")).replace("Effect.Minecraft.", "");
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            }
            else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'')
                found = false;
        }
        return String.valueOf(chars);
    }
}
