# -*- coding: utf-8 -*-
"""
Date: 07/06/2021
File: Lab 8, MyFunctions.py 
Author: Katherine Reynolds
"""

#method that multiplies the values passed by *args together and prints out the results
def multiplyTogether(message, *args):
    total = 1
    for i in args:
        total *= i
    print("Using the function multiplyTogether()")
    print("Message is : ", message)
    print("Result is : ", total)
    print("**********")
    return total

#method that adds together the values passed by *args together and prints out the results
def addTogether(message, *args):
    total = 0
    for i in args:
        total += i
    print("Using the function addTogether()")
    print("Message is : ", message)
    print("Result is : ", total)
    print("**********")
    return total

#method that adds together the values passed by *args together and 
#then divides them by the length of the args to get the average and then prints out the results
def calculateAverage (*args):
    total = 0
    for i in args:
        total += i
    average = total / len(args)
    print("Using the function calculateTogether()")
    print("Average is : ", average)
    print("**********")
    return average

#method that finds the minimum value passed by *args 
#and then prints out that value and its location, location starts at index 0
def findMin(*args):
    num_min = 0
    location = 0
    for i in args:
        if i < num_min:
            num_min = i
    for num in args:
        if num != num_min:
            location += 1
        else:
            break
    print("Smallest value is : ", num_min, " at location : ", location)
    print("**********")
    return (num_min, location)

#method that finds the maximum value passed by *args 
#and then prints out that value and its location, location starts at index 0
def countLargest(*args):
    num_max = 0
    location = 0
    for i in args:
        if i > num_max:
            num_max = i
    for num in args:
        if num != num_max:
            location += 1
        else:
            break
    print("Lagest value is : ", num_max, " at location : ", location)
    print("**********")
    return (num_max, location)






