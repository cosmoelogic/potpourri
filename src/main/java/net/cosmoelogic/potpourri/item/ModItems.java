package net.cosmoelogic.potpourri.item;

import net.cosmoelogic.potpourri.Potpourri;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;

public class ModItems {
    public static final Item ZOMBIE_JERKY = new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1.0f).build()));
    public static final Item SPIDER_BITE = new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1.0f).build()));
    public static final Item SPIKED_DELIGHT = new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1.0f).build()));
    public static final Item POTPOURRI = new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(10).saturationModifier(1.2f).usingConvertsTo(Items.BOWL).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1), 1.0f).build()));


    public static void registerItems() {
        Registry.register(Registries.ITEM, Identifier.of(Potpourri.MOD_ID, "cooked_rotten_flesh"), ZOMBIE_JERKY);
        Registry.register(Registries.ITEM, Identifier.of(Potpourri.MOD_ID, "cooked_spider_eye"), SPIDER_BITE);
        Registry.register(Registries.ITEM, Identifier.of(Potpourri.MOD_ID, "cooked_pufferfish"), SPIKED_DELIGHT);
        Registry.register(Registries.ITEM, Identifier.of(Potpourri.MOD_ID, "potpourri"), POTPOURRI);



        for (Field field : ModItems.class.getDeclaredFields()) {
            try {
                Object value = field.get(null);
                if (value instanceof Item item) {
                    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.add(item));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s: Items registered.%n", Potpourri.MOD_ID);
    }
}
