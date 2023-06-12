package com.fitness.shapify.util

import kotlin.math.abs


object ScreenUtil {

    fun calculateWeightProgressAsFraction(startWeight: Float, currentWeight: Float, targetWeight: Float) : Float {
        val totalWeightDifference = startWeight-targetWeight
        val currentWeightDifference = currentWeight-startWeight

        return abs(currentWeightDifference/totalWeightDifference)
    }

    fun calculateWeightProgress(startWeight: Float, currentWeight: Float, targetWeight: Float) : Float =
        calculateWeightProgressAsFraction(startWeight, currentWeight, targetWeight)*100


    fun formatWeightProgress(startWeight: Float, currentWeight: Float, targetWeight: Float) : String {

        val overUnder =
            if( isOnTrack(startWeight, currentWeight, targetWeight) ){
                "towards"
            } else if(isGoalToGain(startWeight = startWeight, targetWeight = targetWeight)){
                "under"
            }else if(!isGoalToGain(startWeight = startWeight, targetWeight = targetWeight)){
                "over"
            } else{
                return "Completed"
            }
        return "${"%.1f".format(calculateWeightProgress(startWeight, currentWeight, targetWeight))}% $overUnder"
    }

    fun isGoalToGain(startWeight: Float, targetWeight: Float) : Boolean = (startWeight-targetWeight) < 0

    fun isOnTrack(startWeight: Float, currentWeight: Float, targetWeight: Float) : Boolean =
        isGoalToGain(startWeight, targetWeight) && currentWeight-startWeight > 0 ||
                !isGoalToGain(startWeight, targetWeight) && currentWeight-startWeight < 0
}