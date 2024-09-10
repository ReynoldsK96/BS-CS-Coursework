#pragma once
#include <list>
#include <iostream>


namespace pizzaParts {
    enum class topping {
        pepperoni,
        mushrooms,
        peppers,
        onions
    };

    enum class crust {
        thin,
        hand_tossed,
        pan,
        original
    };
}

class Pizza {
public:
    // ctors
    // default constructor
    Pizza() = default;

    // constructor that takes initial values for the pizza
    Pizza(pizzaParts::crust, std::initializer_list<pizzaParts::topping>);

    // save pizza to favorites
    void makeFavorite(Pizza*);
       
    // pizza toppings methods
    size_t numberOfToppings();
    void addTopping(pizzaParts::topping);
    bool removeTopping(pizzaParts::topping);
    std::list<pizzaParts::topping> getAllToppings();

    // pizza crust methods
    void addCrust(pizzaParts::crust myCrust);
    void changeCrust(pizzaParts::crust myCrust);
    pizzaParts::crust getCrust();

    // ostream override
    friend std::ostream& operator << (std::ostream& os, Pizza& myPizza);

private:
    // properties
    std::list<pizzaParts::topping> mToppings;
    pizzaParts::crust mCrust;
};