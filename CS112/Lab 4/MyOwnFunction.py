# -*- coding: utf-8 -*-
"""
Date: 06/28/2021
File: Lab 4, MyOwnFunction.py 
Author: Katherine Reynolds
"""
#creates a list that starts at of numbers between 1 and 13
def createList(start=0, end=50, increment=1):
    nums = []
    for i in range(start, end, increment):
        nums.append(i)
    return nums

#adds the elements of a list together to get the sum total of the list
def sumOfNums(numbers):
    numsSum = 0
    for i in range(len(numbers)):
        numsSum = numsSum + numbers[i]
    return numsSum

#multiplies the elements of a list together to get the total product of the list
def productOfNums(numbers):
    numsProduct = 1
    for i in range(len(numbers)):
        numsProduct = numsProduct * numbers[i]
    return numsProduct

#assesses to see if an element of a list is even, if it is even it prints out that element
def evenNumsOnly(numbers):
    for i in range(len(numbers)):
        if numbers[i] % 2 == 0:
            print(numbers[i], end = ","),

#calling functions and printint out    
numbers = createList(1, 14, 1)

print(numbers)

numsSum = sumOfNums(numbers)

print("Sum total: ", numsSum)

numsProduct = productOfNums(numbers)

print("Multiply total: ", numsProduct)

evenNumsOnly(numbers)