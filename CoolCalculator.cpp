#include "SFML/Graphics.hpp"
#include <string>
#include <iostream>

using namespace std;

int main()
{
	// Creates a window with title.
    sf::RenderWindow window(sf::VideoMode(800, 800), "Cool Calculator");

	// This is a display loop, as long as the window closed event is not used it will continue forever. 
    while (window.isOpen())
    {
        sf::Event event;
        // Event loop, switch cases. All of the event functions will go in here, the main chunk of the GUI.
        while (window.pollEvent(event))
        {
            switch (event.type) {

			// If the closed event is used it will close the window.
            case sf::Event::Closed:
                    window.close();
            }
        }

        window.clear(sf::Color(18, 33, 43)); // Color background
        window.display();
    }


	// ORIGINAL PROGRAM BELOW STARTING TO ADD GUI.

	char op;
	float num1, num2;
	string response;
	bool finished = false;

	// Loops through the calculator until the user types "z" in the operator position.
	while (finished == false)
	{
		// Beginning Dialogue
		cout << "Type z as the operator to end.\n";
		cout << "Enter operator: +, -, *, /, ^,: ";

		// This takes the user's input and assigs it to the variable op.
		cin >> op;

		// This takes the user's input twice and assigns it to two variables, num1 and num2.
		cout << "Enter two operands: ";
		cin >> num1 >> num2;

		// The main chunk of the program, uses a switch case to change the resulting cout statement. 
		switch (op)
		{
		case '+':
			cout << num1 << " + " << num2 << " = " << num1 + num2 << "\n";
			break;

		case '-':
			cout << num1 << " - " << num2 << " = " << num1 - num2 << "\n";
			break;

		case '*':
			cout << num1 << " * " << num2 << " = " << num1 * num2 << "\n";
			break;

		case '/':
			cout << num1 << " / " << num2 << " = " << num1 / num2 << "\n";
			break;

		case '^':
			cout << num1 << "^" << num2 << " = " << pow(num1, num2) << "\n";

			// Changes the variable finished to be true to end the loop when the user types z.
		case 'z':
			cout << "Ending.\n";
			finished = true;

		default:
			// If the operator is other than +, -, *, /, ^, or z, error message is shown
			cout << "Error! operator is not correct.\n";
			break;
		}
	}

    return 0;
}