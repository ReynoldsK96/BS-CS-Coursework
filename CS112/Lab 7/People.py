# -*- coding: utf-8 -*-
"""
Date: 07/06/2021
File: Lab 7, People.py 
Author: Katherine Reynolds
"""
#super class
class Human:
    
    #not-default constructor
    def __init__(self, name, age):
        self.name = name
        self.age = age
        
    #method that prints out hobby
    def hobby(self):
        print("Likes watching Netflix.")
        
    #method that prints out name and age of object
    def info(self):
        print(self.name, "is ", self.age, "years old.")
        

#subclass of Human
class Hiker(Human):
    
    #not-default constructor, calls Human constructor
    def __init__(self, name, age):
        Human.__init__(self, name, age)
    
    #method that prints out hobby
    def hobby(self):
        print("Likes going on hikes.")

#subclass of Human
class Scientist(Human):
    
    #not-default constructor, calls Human constructor
    def __init__(self, name, age, lab):
        Human.__init__(self, name, age)
        self.lab = lab
    
    #method that prints out hobby
    def hobby(self):
        print("Likes doing scienctific experiments.")
        
    #method that prints out what lab the object works at
    def labName(self):
        print("Works at the ", self.lab, " labratory.")
        
#subclass of Human
class Swimmer(Human):
    
    #non-default constructor, calls Human constructor
    def __init__(self, name, age, hours):
        Human.__init__(self, name, age)
        self.hours = hours
        
    #method that prints out hobby
    def hobby(self):
        print("Likes swimming in the lake.")
        
    #prints out how many hours the object swims
    def hoursSwimming(self):
        print("Swims ", self.hours, " hours per week." )

#sublass of Scientist and Swimmer, which are subclasses of Human        
class ScientificSwimmer(Scientist, Swimmer):
    
    #non-default constructor, calls Scientist and Swimmer constructors
    def __init__(self, name, age, lab, hours):
        Scientist.__init__(self, name, age, lab)
        Swimmer.__init__(self, name, age, hours)
        
#creating objects of the different classes and assigning values
person1 = Human("Megan", 20)
person2 = Hiker("Jack", 43)
person3 = Scientist("Mike Flex", 27, "research")
person4 = Swimmer("Tom Accer", 23, 15)
person5 = ScientificSwimmer("John Smith", 30, "nuclear", 100)

#printing out info for the objects
person1.info()
person1.hobby()
print("")

person2.info()
person2.hobby()
print("")

person3.info()
person3.hobby()
person3.labName()
print("")

person4.info()
person4.hobby()
person4.hoursSwimming()
print("")

person5.info()
person5.hobby()
person5.labName()
person5.hoursSwimming()
print("")


