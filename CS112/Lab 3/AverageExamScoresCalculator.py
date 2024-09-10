#Author: Katherine Reynolds
#Date: 06/23/2021
#File: Lab 3, AverageExamScoresCalculator.py

#variables
sum_elements = 0
average_score = 0
scores = []

#while loop to populate list with user input scores
while 1 > 0:
    user_input = eval(input("Enter an exam score or -1 to stop: "))
    if user_input == -1:
        break
    else:
        scores.append(user_input)
        
print("The exam scores:")

#for loop to print out list of scores
for num in scores:
    print(num, end=", ")
    
#for loop to add all values in score list
for num in range(len(scores)):
    sum_elements = sum_elements + scores[num]
    
#calculating average score
average_score = sum_elements/len(scores)

print()
print("Average of the exam scores : ", average_score)