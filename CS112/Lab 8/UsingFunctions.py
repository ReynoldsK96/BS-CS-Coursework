# -*- coding: utf-8 -*-
"""
Date: 07/06/2021
File: Lab 8, UsingFunctions.py 
Author: Katherine Reynolds
"""
#importing module MyFunctions
import MyFunctions as X

#Calling methods from imported module
X.multiplyTogether("Hello", 2, 2, 2)

X.addTogether("Hi!", 5, 2, 3)

X.calculateAverage(2, 1, 3)

#location started at index 0
X.findMin(10, 5, -4, 2, 7, 8)

#Location started at index 0
X.countLargest(2, 2, 899, 56, -9, 87, 899, 764, -100, 899, 2, 2)

for i in range(2, 21):
    if (i % 2) == 0:
        print(i)