#Author: Katherine Reynolds
#Date: 06/22/2021
#File: Lab 2, SeasonsAndDays.py

import sys

#user input to determine the day of the week
day_num = int(input("Enter a number between 1 and 7: "))
day = ""
month = ""

#if else if statements to assign value to day based on user input value
if day_num == 1:
    day = "Monday" 
elif day_num == 2:
    day = "Tuesday"
elif day_num == 3:
    day = "Wednesday"  
elif day_num == 4:
    day = "Thursday"
elif day_num == 5:
    day = "Friday"
elif day_num == 6:
    day = "Saturday"
elif day_num == 7:
    day = "Sunday"
else:
    sys.exit()

#lists for seasons
spring = ["Spring", "spring", "SPRING"]
summer = ["Summer", "summer", "SUMMER"]
fall = ["Fall", "fall", "FALL"]
winter = ["Winter", "winter", "WINTER"]

#user input for season
season = input("What season is it? ")

#if else if statements to determine what month based on user input season
if season == spring[0] or season == spring[1] or season == spring[2]:
    month = "March"
elif season == winter[0] or season == winter[1] or season == winter[2]:
    month = "December"
elif season == fall[0] or season == fall[1] or season == fall[2]:
    month = "September"
elif season == summer[0] or season == summer[1] or season == summer[2]:
    if day_num <= 3:
        month = "June"
    else: 
        month = "July"
else: 
    print("Season does not exist...")
    

#print out day of the week and day_num value user input
print("The day is", day, "which is day number:", day_num)

#if else statements to print out month and season, printing out Go Swimming if the if statement conditions are met
if season == summer[0] or season == summer[1] or season == summer[2] and day_num == 6:
    print("The month is", month, "which is in the", season)
    print("Go Swimming!")
else:
    print("The month is ", month, " which is in the ", season)