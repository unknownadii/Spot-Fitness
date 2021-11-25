package com.example.spotfitness

object AllExercisesClass {

     fun addExerciseData(): ArrayList<ExerciseData>
    {
        val listData = ArrayList<ExerciseData>()
        listData.add(
            ExerciseData(R.drawable.star_jump,
                "Star Jump","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.squates,
                "Squats","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.pushups,
                "Push Ups","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.lungs,
                "Lunges","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.plank,
                "Plank","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.sideplank,
                "Side Plank","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.stepups,
                "Step-ups","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.chairdips,
                "Chair dips","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.wallsit,
                "Wall sit","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.pullups,
                "Pull-ups","10 Second")
        )
        return listData
    }
}