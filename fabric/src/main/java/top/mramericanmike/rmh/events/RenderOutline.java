package top.mramericanmike.rmh.events;

public class RenderOutline {
    private static boolean doRender = false;

    public static boolean doRenderOutline() {
        return isDoRender();
    }

    public static boolean isDoRender() {
        return doRender;
    }

    public static void setDoRender(boolean doRender) {
        RenderOutline.doRender = doRender;
    }
}
