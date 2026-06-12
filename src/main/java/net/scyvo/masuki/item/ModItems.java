package net.scyvo.masuki.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.scyvo.masuki.Masuki;

import java.util.function.Function;

public class ModItems {
    public static final Item MASUKI = registerItem("mami", Item::new);
    public static final Item SAUCED_MASUKI = registerItem("sauced_mami", Item::new);
    public static final Item SPECIAL_SAUCE = registerItem("special_sauce", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Masuki.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Masuki.MOD_ID, name)))));
    }

    public static void registerModItems(){
        Masuki.LOGGER.info("Registering Mod Items for " + Masuki.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(fabricCreativeModeTabOutput -> {
            fabricCreativeModeTabOutput.accept(MASUKI);
            fabricCreativeModeTabOutput.accept(SAUCED_MASUKI);
            fabricCreativeModeTabOutput.accept(SPECIAL_SAUCE);
        });
    }



}
