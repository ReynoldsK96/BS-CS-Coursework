# -*- coding: utf-8 -*-
"""
Date: 06/30/2021
File: Lab 5, AnonymousFunctions.py 
Author: Katherine Reynolds
"""

#takes three parameters, adds them together, and them multiplies them by 10
x = lambda a, b, c: (a+b+c)*10

print(x(2, 2, 2))

#takes two parameters and adds them together
addTwo = lambda a, b: (a+b)

print("Add two : ", addTwo(9, 9))

#takes three parameters and calculates the average 
average = lambda a, b, c: (a+b+c)/3

print("Average of three :", average(1, 2, 3))

#takes one parameter and raises it to the power of three
powerThree = lambda a: a**3

print("Power of three : ", powerThree(5))

#takes no parameters and prints out preset string
info = lambda: "Hello World"

print("Info : ", info())

#takes one parameter and changes it to lowercase
lowerStr = lambda a: a.lower()

print("Lower case string : ", lowerStr("CWU"))

#takes one parameter and removes the white spaces and changes it to uppercase
subUpperStr = lambda a: a.strip().upper()

result = subUpperStr(" ccWucentral")

#I could not figure out how to attatch the substring to the other two arguments so I did it here
print("Upper sub string : ", result[1:4])

#takes one parameter and cuts it in half
halfList = lambda a: a[0:(len(a)//2)]

nums = [1, 2, 3, 4, 5, 6]

print("First half of the list : ", halfList(nums))