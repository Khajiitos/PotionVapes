package me.khajiitos.potionvapes.common.util;

import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;

import java.lang.reflect.InvocationTargetException;

public abstract class LoaderController {
    public static LoaderController INSTANCE = null;
    // Fabric and Forge require different overrides for the GUI to work
    // We ought to have the controller loaded before the the actual mod,
    // so we can access the block in a mixin before mod init
    // Edit, maybe we don't need to use it before mod init but still
    public abstract VapeJuicerBlock createVapeJuicerBlock();

    public abstract Type getLoaderType();

    public enum Type {
        FORGE("me.khajiitos.potionvapes.forge.ForgeLoaderController"),
        FABRIC("me.khajiitos.potionvapes.fabric.FabricLoaderController");

        public final String controllerPackageName;

        Type(String controllerPackageName) {
            this.controllerPackageName = controllerPackageName;
        }
    }

    static {
        for (Type type : Type.values()) {
            try {
                Class<?> controllerClass = Class.forName(type.controllerPackageName);
                INSTANCE = (LoaderController) controllerClass.getConstructor().newInstance();
                break;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                     InstantiationException | InvocationTargetException ignored) {}
        }

        if (INSTANCE == null) {
            throw new RuntimeException("Failed to initialize LoaderController!");
        }
    }
}
