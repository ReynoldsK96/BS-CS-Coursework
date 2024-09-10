# -*- coding: utf-8 -*-
"""
Date: 07/19/2021
File: Lab 9, FormatFixer.py 
Author: Katherine Reynolds
"""
file2 = open("data_fixed.txt", 'w')
with open("lab9data.txt", 'r') as file1:
    all_lines = file1.readlines()
    for line in all_lines:
        x, y, z = line.split(',')
        name = x + z
        nameLength = len(name)
        num = int(y) * 100
        newLine = name[0:nameLength-1] + ", " + str(num) + "\n"
        file2.write(newLine)

file1.close()
file2.close()