# tic-tac-toe-kotlin
This is a basic tic-tac-toe application made in kotlin

This game was made as a project for #30daysofKotlin. The goal of tic-tac-toe is to be the first player to get three in a row on a 3-by-3 grid or four in a row in a 4-by-4 grid. 
Here the app allows the users to choose between two modes
vs Computer
vs Player

## 3 concepts of Kotlin
-Navigation (Intents)

-Activity: Lifecycle

-Layout manipulation and Animation


## Project Implementation details
I have three activities :-

*SplashScreenActivity* - This screen uses LottieAnimationView to show the animating objects.Also, I have used ValueAnimator and created AnimatorSet for animations.

*GameDetailsActivity* - We have a RadioGroup to select between the two modes. (vs comp or vs player) The intent to the next screen carries the string name of the mode. 

*MainActivity* - Game’s main logic. It gets the mode with intent. When the game ends, a dialog pops up to choose between new game/ restart game


# Game Screenshots

<table>
  <tr>
    <td><img src="https://github.com/vansh1sh/tic-tac-toe-kotlin/blob/master/screenshots/1.png" width=270 height=480></td>
    <td><img src="https://github.com/vansh1sh/tic-tac-toe-kotlin/blob/master/screenshots/2.png" width=270 height=480></td>
  </tr>
   <tr>
   	<td><img src="https://github.com/vansh1sh/tic-tac-toe-kotlin/blob/master/screenshots/3.png" width=270 height=480></td>
    <td><img src="https://github.com/vansh1sh/tic-tac-toe-kotlin/blob/master/screenshots/4.png" width=270 height=480></td>
  </tr>
 </table>
