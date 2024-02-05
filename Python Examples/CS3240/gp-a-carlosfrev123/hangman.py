# Mark Sherriff (mss2x)

# This program plays the game Hangman.
# Input a word, then guess the letters!

import random

secretWord= input("Enter a word: ").lower()
numberOfGuessesLeft= 5

#Populates the hidden word string with correct number of "-"
secretWord = secretWord[::-1]
hiddenWord= "["
for i in range(len(secretWord)):
    hiddenWord+="-"
    if (i==len(secretWord)-1):
        hiddenWord+="]"

#Main loop to run through the hangman game
while (numberOfGuessesLeft>0):
    guess = (input(hiddenWord+" You have " + str(numberOfGuessesLeft)+ " guesses left, enter a letter: ")).lower()
    #Checks if guess is in the secret word
    if guess in secretWord.lower():

        #Replaces "-" with correctly guessed letter
        for i in range(len(secretWord)):
            if secretWord[i]== guess:
                x = secretWord[i:].find(guess)
                hiddenWord= hiddenWord[0:i+1]+guess.upper()+hiddenWord[i+2:]

        if ("-" in hiddenWord):
                    print ("Correct!")
    else:
        numberOfGuessesLeft-=1
        if (numberOfGuessesLeft>0):
            print("Incorrect!")

    #if all letters are guessed
    if not "-" in hiddenWord:
        print("You win! The word was "+ '"'+secretWord.upper()+'"')
        break
    # if user is out of guesses
    if (numberOfGuessesLeft==0):
        print ('You lose! The word was "'+ secretWord.upper()+'"')
