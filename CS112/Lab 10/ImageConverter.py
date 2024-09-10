# -*- coding: utf-8 -*-
"""
Date: 07/22/2021
File: Lab 10, ImageConverter.py 
Author: Katherine Reynolds
"""
from PIL import Image

status = "yes"

while status == "yes" or status == "Yes":

    file = input("What image would you like to modify? " )
    img = Image.open(file)

    width = int(img.width/2)
    height = int(img.height/2)

    newImage = img.resize((width, height))
    newImage = newImage.convert('L')
    
    if file[len(file)-4:len(file)] == ".jpg":
        newImage.save(file[0:len(file)-4] + "_edited.jpg")
    elif file[len(file)-4:len(file)] == ".png":
        newImage.save(file[0:len(file)-4] + "_edited.png")
    else: 
        print("Other file type than .jpg or .png")
        break
    status = input("Would you like to edit another picture? (yes/no): ")
    
print("Goodbye!")

