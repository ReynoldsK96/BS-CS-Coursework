#Author: Katherine Reynolds
#Date: 06/21/2021
#File: Rectangle.py

"""
A simple program which calculates the perimeter and area
of a rectangle using user's input
"""

#Information for the user
info = "Calculate the perimeter and area of a rectangle"

print(info)

#getting user's input and saving it to variables
width = eval(input("What is the width? "))
length = eval(input("What is the length? "))

print ("----------")
print ("calculating")
print ("----------")

#calculate perimeter (P = 2(w+1))
perimeter = 2*(width + length)

#calculating area (A = w*l)
area = length * width

#printing the results to the user
print ("The width of the rectangle is : ", width)
print ("The length of the rectangle is : ", length)
print ("The area of the rectangle is ", area)
print ("The perimeter of the rectangle is ", perimeter)
