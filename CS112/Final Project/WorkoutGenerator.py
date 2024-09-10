# -*- coding: utf-8 -*-
"""
Date: 07/26/2021
File: Final Project, WorkoutGenerator.py 
Author: Katherine Reynolds
"""
import random
#super class
class Workout:
    
    #nondefault constructor that calls the two class methods to generate the fields for the object
    def __init__(self):
        self.numRounds = self.roundGenerator()
        self.movementThree = self.cardioMovements()
    
    #generates a random number between 3 and 6 to be the amount of rounds in the workout
    def roundGenerator(self):
        num = random.randrange(3, 6, 1)
        numRounds = "For time, " + str(num) + " rounds: "
        return numRounds
        
    #determines which cardio movement will be part of the workout by randomly selecting one of the list elements
    #and then determines how many reps of that movement should be done
    def cardioMovements(self):
        movements = ["bike", "run", "row", "burpees"]
        num = random.randrange(0, 3, 1)
        selectedMovement = movements[num]
        if selectedMovement == "burpees":
            reps = random.randrange(5, 25, 1)
            movementThree = str(reps) + " " + selectedMovement
        elif selectedMovement == "run":
            reps = random.randrange(100, 400, 100)
            movementThree = str(reps) + " meter " + selectedMovement
        else:
            reps = random.randrange(10, 30, 5)
            movementThree = str(reps) + " cal " + selectedMovement
        return movementThree
    

#subclass of Workout        
class LowerBodyWorkout(Workout):
    
    #calls super class' constructor and then calls its own specialized methods to generate the rest of the object's fields
    def __init__(self):
        Workout.__init__(self)
        self.movementOne = self.lowerHighRepMovements()
        self.movementTwo = self.lowerBarbellMovements()  
    
    
    #determines which movement will be part of the workout by randomly selecting one of the list elements
    #and then determines how many reps of that movement should be done
    def lowerHighRepMovements(self):
        num = random.randrange(0, 6, 1)
        movements = ["air squats", "goblet squats", "bulgarian split squat", "reverse lunges", "jumping lunges", "toes to bar", "sit-ups"]
        selectedMovement = movements[num]
        if selectedMovement == "toes to bar":
            reps = random.randrange(10, 25, 3)
        elif selectedMovement == "sit-ups":
            reps = random.randrange(15, 30, 5)
        else:
            reps = random.randrange(15, 30, 10)
        movementOne = str(reps) + " " + selectedMovement
        return movementOne
            
    #determines which movement will be part of the workout by randomly selecting one of the list elements
    #and then determines how many reps of that movement should be done
    def lowerBarbellMovements(self):
        num = random.randrange(0, 2, 1)
        movements = ["squat snatches", "squat cleans", "thrusters"]
        selectedMovement = movements[num]
        reps = random.randrange(5, 20, 5)
        if reps < 10:
            movementTwo = str(reps) + " " + selectedMovement + ", choose a heavier weight"
        else:
            movementTwo = str(reps) + " " + selectedMovement + ", choose a lighter weight"
        return movementTwo
    
    #method that puts all the object fields into on string variable to make printing everything out easier
    def printLowerBodyWorkout(self):
        str = self.numRounds + "\n" + self.movementOne + "\n" + self.movementTwo + "\n" + self.movementThree + "\n**********\n"
        return str
    
#subclass of Workout
class UpperBodyWorkout(Workout):

    #calls super class' constructor and then calls its own specialized methods to generate the rest of the object's fields
    def __init__(self):
        Workout.__init__(self)
        self.movementOne = self.upperHighRepMovements()
        self.movementTwo = self.upperBarbellMovements()
        
    #determines which movement will be part of the workout by randomly selecting one of the list elements
    #and then determines how many reps of that movement should be done
    def upperHighRepMovements(self):
        num = random.randrange(0, 4, 1)
        movements = ["pull-ups", "push ups", "handstand push-ups", "sit-ups", "toes to bar"]
        selectedMovement = movements[num]
        if selectedMovement == "toes to bar" or selectedMovement == "handstand push-ups":
            reps = random.randrange(10, 25, 3)
            movementOne = str(reps) + " " + selectedMovement
        elif selectedMovement == "sit-ups":
            reps = random.randrange(15, 30, 5)
            movementOne = str(reps) + " " + selectedMovement
        else:
            reps = random.randrange(5, 20, 2)
            if reps > 10:
                movementOne = str(reps) + " " + selectedMovement + ", can be kipping"
            else:
                movementOne = str(reps) + " " + selectedMovement + ", try to do them all strict"
        return movementOne
                
    #determines which movement will be part of the workout by randomly selecting one of the list elements
    #and then determines how many reps of that movement should be done
    def upperBarbellMovements(self):
        num = random.randrange(0, 7, 1)
        movements = ["strict press", "push press", "push jerk", "power cleans", "power snatches", "clean and jerk", "thrusters", "clusters"]
        selectedMovement = movements[num]
        reps = random.randrange(5, 20, 5)
        if reps < 10:
            movementTwo = str(reps) + " " + selectedMovement + ", choose a heavier weight"
        else:
            movementTwo = str(reps) + " " + selectedMovement + ", choose a lighter weight"
        return movementTwo
        
    #method that puts all the object fields into on string variable to make printing everything out easier
    def printUpperBodyWorkout(self):
        str = self.numRounds + "\n" + self.movementOne + "\n" + self.movementTwo + "\n" + self.movementThree + "\n**********\n"
        return str
        
#sets up condition for while loop
status = "Y"

#creates file if it does not already exist, and writes to it without overwriting what is already there so any number of workouts can be written to it
file = open("GeneratedWorkouts.txt", 'a')

#information for user
print("This program generates crossfit metcon style workouts. It will randomly generate 3 movements, number of rounds, and number of reps.")

#as long as user wishes to generate workouts and inputs "Y" at then end loop will continue
while status == "Y":    
    
    #accepts user input on whether the workout should target the lower or upper body
    workoutType = input("Would you like a workout that targets your upper or lower body? (lower/upper) : ")
    
    #generates object of type LowerBodyWorkout if lower was input and writes it to file
    if workoutType == "LOWER" or workoutType == "lower" or workoutType == "Lower": 
        workout = LowerBodyWorkout()
        file.write(workout.printLowerBodyWorkout())
    #generates object of type UpperBodyWorkout if upper was input and writes it to file
    elif workoutType == "UPPER" or workoutType == "upper" or workoutType == "Upper":
        workout = UpperBodyWorkout()
        file.write(workout.printUpperBodyWorkout())
    #else statement to catch any invalid inputs to program exits cleanly and does not break
    else:
        print("Invalid input. Try again.")
        break
    
    #input on whether the user wants to end the program, breaks the while loop if "N" or any other input than "Y" is input
    status = input("Would you like to generate another workout? (Y/N): ")

#closes file
file.close()