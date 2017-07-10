# Minesweeper
A minesweeper clone made using Java and JavaFX for the UI

*July 3rd, 2017
  Added some more issues/enhancements that can serve to both drive the project forward, and keep on learning JavaFX and more    Java.

*July 4th, 2017
  Decided to place the calculation of the bomb number around a cell inside the controller. It knows the grid, it can iterate trough each neighbour and check if it has a bomb or not. Maybe a method in gameGrid to get a cell at a specified position will be useful...
Can also add an extra field to a cell: uncovered. A boolean. When the number of cells with uncovered==true is equal to the total game grid size - NUM_OF_MINES the game ends :)

*July 10th, 2017
  Dialog box on losing now closes, but game context not destroyed properly...to do soon!
