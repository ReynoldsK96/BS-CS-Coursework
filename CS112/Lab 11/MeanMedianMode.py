# -*- coding: utf-8 -*-
"""
Date: 07/28/2021
File: Lab 11, MeanMedianMode.py 
Author: Katherine Reynolds
"""
def mean(nums):
    total = 0
    for i in nums:
        total += i
    mean = total / len(nums)
    print("mean " + str(mean))
    return mean

def median(nums):
    nums.sort()
    n = len(nums)
    if (n % 2 != 0):
        median = nums[int(n/2)]
    else:
        one = nums[(n-1)//2]
        two = nums[(n+2)//2]
        median = (one + two)/2
    print("median " + str(median))
    return median

def mode(nums):
    dictionary = {}
    for i in nums:
        if i in dictionary.keys():
            dictionary[i] = dictionary[i] + 1
        else:
            dictionary[i] = 1
    for key, value in dictionary.items():
        if value == max(dictionary.values()):
            print("Mode is " + str(key) + " with " + str(value) + " occurances")
    return mode

nums = [2, 3, 4, 5, 5]

print("list of numbers: " + str(nums))
mean(nums)
median(nums)
mode(nums)

print("**********")

nums = [2, 5, 7, 4, 5, 5, -1, 7, 7]

print("list of numbers: " + str(nums))
mean(nums)
median(nums)
mode(nums)

            