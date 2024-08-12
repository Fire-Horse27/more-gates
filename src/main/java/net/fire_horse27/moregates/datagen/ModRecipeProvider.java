package net.fire_horse27.moregates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<Item> MATERIAL = List.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS);

    private static final List<Item> GATE = List.of(Items.OAK_FENCE_GATE, Items.SPRUCE_FENCE_GATE,
            Items.BIRCH_FENCE_GATE, Items.JUNGLE_FENCE_GATE, Items.ACACIA_FENCE_GATE, Items.DARK_OAK_FENCE_GATE,
            Items.MANGROVE_FENCE_GATE, Items.CHERRY_FENCE_GATE, Items.BAMBOO_FENCE_GATE, Items.CRIMSON_FENCE_GATE,
            Items.WARPED_FENCE_GATE);

    @Override
    public void generate(RecipeExporter exporter) {
        for(int i = 0; i < 11; i++) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, GATE.get(i), 2)
                    .pattern("#P#")
                    .pattern("#P#")
                    .group("wooden_fence_gate")
                    .input('#', Items.STICK)
                    .input('P', MATERIAL.get(i))
                    .criterion(hasItem(MATERIAL.get(i)), conditionsFromItem(MATERIAL.get(i)))
                    .offerTo(exporter);
        }
    }
}
