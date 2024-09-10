#Author: Katherine Reynolds
#Date: 06/22/2021
#File: Lab 2, Cars.py

#lists of car make, model, and year
makes = ["Honda", "Toyota", "Mercedes", "Ford"]
models = ["Accord", "Camry", "C63AMG", "F150"]
years = [2001, 1989, 2019, 2020]

#changing values at specific indexes in years and models lists
years[1] = 2019
models[3] = "F350"

#adding another car make, model, and year to the appropriate list
makes.append("BMW")
models.append("M6")
years.append(2009)

#printing out the different car info pieces from the various lists
print("Car 1 : ", years[0], " ", makes[0], " ", models[0])
print("Car 2 : ", years[1], " ", makes[1], " ", models[1])
print("Car 3 : ", years[2], " ", makes[2], " ", models[2])
print("Car 4 : ", years[3], " ", makes[3], " ", models[3])
print("Car 5 : ", years[4], " ", makes[4], " ", models[4])