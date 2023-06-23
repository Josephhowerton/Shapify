package com.fitness.model.util.extensions

import com.fitness.model.util.createUniqueIdentifier
import com.fitness.framework.extensions.StaticExtensions.emptyString
import com.fitness.model.cache.nutrition.food.FoodEntity
import com.fitness.model.cache.nutrition.food.MeasureEntity
import com.fitness.model.cache.nutrition.food.NutrientsEntity
import com.fitness.model.cache.nutrition.food.QualifiedEntity
import com.fitness.model.cache.nutrition.food.QualifierEntity
import com.fitness.model.cache.nutrition.food.ServingSizeEntity
import com.fitness.model.remote.nutrition.food.FoodDto
import com.fitness.model.remote.nutrition.food.MeasureDto
import com.fitness.model.remote.nutrition.food.NutrientsDto
import com.fitness.model.remote.nutrition.food.QualifiedDto
import com.fitness.model.remote.nutrition.food.QualifierDto
import com.fitness.model.remote.nutrition.food.ServingSizeDto

fun FoodDto.toFoodEntity(mealId: String) =
    FoodEntity(
        id = createUniqueIdentifier(),
        apiId = foodId,
        mId = mealId,
        food = emptyString(),
        label = label,
        knownAs = knownAs,
        image = image,
        brand = brand,
        category = category,
        categoryLabel = categoryLabel,
        foodContentsLabel = foodContentsLabel,
        quantity = 0,
        measure = emptyString(),
        measureURI = emptyString(),
        weight = 0,
        retainedWeight = 0,
        servingSizes = servingSizes.toServingSizeEntityList(),
        servingsPerContainer = servingsPerContainer,
        dietLabels = emptyList(),
        healthLabels = emptyList(),
        cautions = emptyList()
    )

fun MeasureDto.toMeasureEntity(foodId: String) =
    MeasureEntity(
        id = createUniqueIdentifier(),
        fId = foodId,
        unit = unit,
        unitUri = unitUri,
        weight = weight,
        qualified = qualifiedDto.toQualifiedEntityList()
    )

fun NutrientsDto.toNutrientsEntity(foodId: String) =
    NutrientsEntity(
        id = createUniqueIdentifier(),
        fId = foodId,
        CalciumCa = CalciumCa,
        CarbohydrateDifference = CarbohydrateDifference,
        Cholesterol = Cholesterol,
        Energy = Energy,
        FattyAcidsMonounsaturated = FattyAcidsMonounsaturated,
        FattyAcidsPolyunsaturated = FattyAcidsPolyunsaturated,
        FattyAcidsSaturated = FattyAcidsSaturated,
        Fat = Fat,
        FatTrans = FatTrans,
        Iron = Iron,
        FiberDietary = FiberDietary,
        Potassium = Potassium,
        Magnesium = Magnesium,
        Sodium = Sodium,
        Niacin = Niacin,
        Phosphorus = Phosphorus,
        Protein = Protein,
        Riboflavin = Riboflavin,
        Sugar = Sugar,
        Thiamin = Thiamin,
        VitaminB12 = VitaminB12,
        VitaminB6 = VitaminB6,
        VitaminC = VitaminC,
        Zinc = Zinc
       )

fun QualifiedDto.toQualifiedEntity() =
    QualifiedEntity(
        qualifiers = qualifiers.toQualifierEntityList(),
        weight = weight
    )

fun List<QualifiedDto>.toQualifiedEntityList() = map {
    it.toQualifiedEntity()
}

fun QualifierDto.toQualifierEntity() =
    QualifierEntity(
        label = label,
        uri = uri
    )

fun List<QualifierDto>.toQualifierEntityList() = map {
    it.toQualifierEntity()
}

fun ServingSizeDto.toServingSizeEntity() =
    ServingSizeEntity(
        unit = unit,
        quantity = quantity,
        unitUri = unitUri
    )

fun List<ServingSizeDto>.toServingSizeEntityList() = map {
    it.toServingSizeEntity()
}