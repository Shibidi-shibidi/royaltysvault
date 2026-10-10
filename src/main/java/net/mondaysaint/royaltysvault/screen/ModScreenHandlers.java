package net.mondaysaint.royaltysvault.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.RoyaltySVault;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RuneImbuingScreenHandler> RUNE_IMBUING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(RoyaltySVault.MOD_ID, "rune_imbuing"),
                    new ExtendedScreenHandlerType<>(RuneImbuingScreenHandler::new));


    public static void registerScreenHandlers(){
        RoyaltySVault.LOGGER.info("Registering Screen Handlers for Royalty's Vault");
    }
}
