package com.example.spotfitness.Data

import com.example.spotfitness.R

object AllExercisesClass {
 var  arrayHistoryList : ArrayList<String> =ArrayList()
     fun addExerciseData(): ArrayList<ExerciseData>
    {
        val listData = ArrayList<ExerciseData>()
        listData.add(
            ExerciseData(
                R.drawable.star_jump,
                "Star Jump","10 Second","1.Stand with your feet shoulder-width apart and a slight bend in your knees. Your shoulders should be directly over your hips with a neutral head and neck position. Your arms should be long and by your sides. Your chin should remain tucked throughout the movement, as if you were holding an egg under your chin.\n" +
                        "2.Pre-tension your shoulders and hips with a good inhale and exhale, and engage your core. Maintain a neutral spine, and begin to bend your hips, knees, and ankles to lower into a quarter-squat or full-squat position. All repetitions should begin from this starting position.\n" +
                        "3.Explosively push your feet into the ground to begin the jump. As you jump into the air, reach your arms and legs out to the side, forming the letter X in the air. Your arms and legs should be fully extended.\n" +
                        "4.Land in a quarter squat or full squat position. Your landing posture should be the same as your jumping posture. Land from your jump on the balls of your feet, and evenly distribute the weight along each entire foot, allowing your hips and knees to bend to absorb force.\n" +
                        "5.Your bodyweight should be loaded into your midfoot and heel. Keep your toes engaged and your knees in line with your toes. Land softly and under control while keeping your core engaged throughout the landing.\n" +
                        "6.Continue to jump for the desired number of repetitions.")
        )
        listData.add(
            ExerciseData(
                R.drawable.squates,
                "Squats","10 Second","Step 1: Stand straight with feet hip-width apart.\n" +
                        "Stand with your feet apart, slightly wider than your hips, and place your hands on your hips.\n" +
                        "\n" +
                        "Step 2: Tighten your stomach muscles.\n" +
                        "Standing up tall, gently pull your shoulders back, subtly lift your chest. On an exhale, try to pull your navel into your back to engage your deep abdominal muscles, which keep the spine and pelvis stable.\n" +
                        "\n" +
                        "Step 3: Lower down, as if sitting in an invisible chair.\n" +
                        "Bend your knees while keeping your upper body as straight as possible, as if you were lowering yourself onto a seat behind you. It is OK to allow your torso to tilt naturally as you squat, just don’t collapse your chest or round your shoulders forward. If you’re too erect, your hips cannot release properly and you’ll put too much strain on your knees.\n" +
                        "\n" +
                        "Lower yourself as far as you can without leaning your upper body more than a few inches forward. Go as deep as you can comfortably. If you have knee issues, don’t go deeper than a 90-degree angle, with your thighs parallel to the floor.\n" +
                        "\n" +
                        "Tip: Don’t allow your knees to go too far forward. You don’t want them to stick out past your toes—instead, try to keep them in line with your toes. Also, don’t let your knees cave inward. Press them outward (almost as if you were pushing out an invisible resistance band) so they stay aligned with your feet as you squat down.\n" +
                        "\n" +
                        "Step 4: Straighten your legs to lift back up.\n" +
                        "Straighten your legs, being careful not to lock your knees when you reach a standing position.\n" +
                        "\n" +
                        "Tip: Keep your heels “glued” to the floor as you squat, and then think about driving them into the ground as you rise up to return to the starting position. This will put even more emphasis on your glutes.\n" +
                        "\n" +
                        "Step 5: Repeat the movement.")
        )
        listData.add(
            ExerciseData(
                R.drawable.pushups,
                "Push Ups","10 Second","1. Get down on all fours, placing your hands slightly wider than your shoulders. \n" +
                        "\n" +
                        "2. Straighten your arms and legs. \n" +
                        "\n" +
                        "3. Lower your body until your chest nearly touches the floor. \n" +
                        "\n" +
                        "4. Pause, then push yourself back up. \n" +
                        "\n" +
                        "5. Repeat.  ")
        )
        listData.add(
            ExerciseData(
                R.drawable.lungs,
                "Lunges","10 Second","The basic lunge works the quads, glutes, and hamstrings. To correctly do a lunge:\n" +
                        "\n" +
                        "Start by standing up tall.\n" +
                        "Step forward with one foot until your leg reaches a 90-degree angle. Your rear knee should remain parallel to the ground and your front knee shouldn’t go beyond your toes.\n" +
                        "Lift your front lunging leg to return to the starting position.\n" +
                        "Repeat 10 to 12 reps on one leg, or switch off between legs until you’ve totaled 10 to 12 reps per leg.")
        )
        listData.add(
            ExerciseData(
                R.drawable.plank,
                "Plank","10 Second","1. Plant hands directly under shoulders (slightly wider than shoulder width) like you’re about to do a push-up.\n" +
                        "\n" +
                        "2. Ground toes into the floor and squeeze glutes to stabilize your body. Your legs should be working, too — be careful not to lock or hyperextend your knees.\n" +
                        "\n" +
                        "3. Neutralize your neck and spine by looking at a spot on the floor about a foot beyond your hands. Your head should be in line with your back.\n" +
                        "\n" +
                        "4. Hold the position for 20 seconds. As you get more comfortable with the move, hold your plank for as long as possible without compromising your form or breath.")
        )
        listData.add(
            ExerciseData(
                R.drawable.sideplank,
                "Side Plank","10 Second","Lie on your right side with your legs straight and feet stacked on top of each other. Place your right elbow under your right shoulder with your forearm pointing away from you and your hand balled into a fist. The pinky side of your hand should be in contact with the ground.\n" +
                        "With your neck neutral, breathe out and brace your core.\n" +
                        "Lift your hips off the mat so that you’re supporting your weight on your elbow and the side of your right foot. Your body should be in a straight line from your ankles to your head.\n" +
                        "Hold this position for the duration of the exercise. Depending on your fitness level, aim for between 15 to 60 seconds.\n" +
                        "Repeat on your left side.\n" +
                        "Some points to keep in mind during the exercise:\n" +
                        "\n" +
                        "If you find it hard to hold a side plank, that’s OK. You can try performing the exercise from your knees instead of your feet while you’re building your strength.\n" +
                        "Keep your hips stacked and facing forward. Try to avoid rotating your body.\n" +
                        "Avoid letting your hips sag during the exercise. If you can’t hold the position, try reducing the duration of the side plank. It’s better to perform 20 seconds with good form than 50 seconds with poor form.\n" +
                        "Try to keep your face and bottom hand relaxed during the exercise.")
        )
        listData.add(
            ExerciseData(
                R.drawable.stepups,
                "Step-ups","10 Second","Grab a pair of dumbbells and stand next to a plyometric box or a bench with one foot on the box and the other foot on the floor. The height of the box should allow you to maintain a tall posture and a level pelvis. Your leg should be bent at a 90-degree angle. Evenly distribute your weight across the foot on the box, and grip the floor with your other foot to create a stable position.\n" +
                        "Maintain a neutral head and neck position and a tall posture. Your chin should remain tucked throughout the movement, as if you were holding an egg under your chin. Your shoulders should be slightly ahead of your hips and your arms should be long with a slight bend in your elbows. Pre-tension your shoulders and hips while engaging your core. All repetitions should begin from this position.\n" +
                        "Push your foot into the plyometric box to initiate the upward movement. As you begin to stand up, keep your chest high, squeeze your glute, allow your knee to straighten and your hips to travel forward.\n" +
                        "As you finish the movement, squeeze your glute and quadricep while maintaining a neutral spine. Your opposite foot should finish on top of the plyometric box and your shoulders should finish over your hips.\n" +
                        "While maintaining your alignment and a level pelvis, begin the downward movement by slowly stepping off the box. Slowly bend your hip, knee, and ankle to lower your foot toward the floor. Lower until your foot contacts the ground. Pause at the bottom position before beginning the next repetition.")
        )
        listData.add(
            ExerciseData(
                R.drawable.chairdips,
                "Chair dips","10 Second","Press into your palms to lift your body and slide forward just far enough that your behind clears the edge of the chair.\n" +
                        "Lower yourself until your elbows are bent between 45 and 90 degrees. Control the movement throughout the range of motion.\n" +
                        "Push yourself back up slowly until your arms are almost straight and repeat.")
        )
        listData.add(
            ExerciseData(
                R.drawable.wallsit,
                "Wall sit","10 Second","Stand near a wall (around two feet away). You’re probably thinking any old distance will do, but complacency on wall proximity is the one true danger in the wall sit. Stand too far away and you’ll miss the wall entirely and potentially crack your head open, and being too near will prevent you getting your legs into the right position during the exercise.\n" +
                        "\n" +
                        "Lean back against the wall with your torso, with your feet shoulder-width apart. Then press back and slide down the wall until your thighs are parallel with the ground. Your knees should be above your ankles and bent at right-angles. Keep your head, shoulders and upper back against the wall and hold the position.")
        )
        listData.add(
            ExerciseData(
                R.drawable.pullups,
                "Pull-ups","10 Second","Here’s how to do Pullups with proper form:\n" +
                        "\n" +
                        "Grab the pullup bar with your palms down (shoulder-width grip)\n" +
                        "Hang to the pullup-bar with straight arms and your legs off the floor\n" +
                        "Pull yourself up by pulling your elbows down to the floor\n" +
                        "Go all the way up until your chin passes the be bar\n" +
                        "Lower yourself until your arms are straight")
        )
        return listData
    }
}