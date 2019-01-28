<dl>
	<img src="https://github.com/Chioxin/BlackjackProject/blob/master/BlackjackTable.jpg?raw=true" alt="A Blackjack Table" ALIGN="right" width="450"/>
</dl>

## Blackjack Project

### Project Description
The goal was to recreate Blackjack as a console command game. There is a dealer, and a player. Each have their own hand, and the player is allowed to make a choice as to hit or stand while the dealer has to follow the rule of "always hit if less than 17 points." The game can properly account for Aces, and adjust for them based on the player's hand score. The game will call a win when someone gets Blackjack from the draw, otherwise normal Blackjack playing rules are in effect. This is our our first, very heavy, object oriented thinking program.

<dl>
	<img src="https://github.com/Chioxin/BlackjackProject/blob/master/BlackjackUML.png?raw=true" alt="A Blackjack Table" ALIGN="right" width="450"/>
</dl>

### UML

We were given a UML for the for the hand and deck of cards, and how they are suppose to work. I followed them them as religiously as I could! The UML does not show a few of the needed other classes to complete the project. I created a Super Class "Player" and two classes that extend that class called "Dealer" and "User." There's a table class as well, and a "main" class. I also created a UserKeyboard class to handle interactions with the keyboard to collect inputs and try/catch the Exceptions that could come from that. Lastly, I made a "GameAction" Enumerated class to handle actions the dealer and user can take in the game. 

### Topics/Technologies
* Object Oriented Design
	* Polymorphism
	* Inheritance
	* Encapsulation
	* Abstraction
* Object Collections Framework
* Enumerated Types
* Try/Catch Exception Handling
* Git
* Eclipse