## Sliding Puzzle

#### Game rules
- The game is played on a board of size N (width) times M (height).
- Each of the cells contains a number between 1 and NxM-1, except for the empty cell.
- Moves are possible relative to the empty cell, by shifting one the neighboring cells into the empty cell.
  - Therefore, there are four possible moves, which we call UP, DOWN, LEFT, and RIGHT.
- Note that if the empty cell is at the top, bottom, left, or right border, then some of the four moves are impossible.
  - We call them invalid, in contrary to the valid ones.
- At the beginning of the game, the cells are completely unordered.
- The goal of the game is to solve the puzzle, which corresponds to reaching a state in which all cells are numbered
  from 1 to NxM-1, starting row-wise from top left to bottom right. In that case, the empty cell is at bottom of the rightmost column.
___
`Game`
 - Instances of this class represent a running sliding puzzle game.
 - In addition to the sliding puzzle itself, it takes track of all previously played moves.
 - Allows users to backtrack to previous game states.
 - It also keeps track of the total number of previously played moves, where backtracking moves are also counted.
 - A new instance of this class contains an unsolved puzzle.
___
`Puzzle`
- Instances of this class represent a sliding puzzle of size `width` * `height`.
- Initially, the puzzle is solved, i.e., all cells are numbered from `1` to * `width` * `height` - `1` from top  left to bottom right, with the empty cell at the bottom of the rightmost column. 
- It keeps track of the current state of the puzzle when moves are being played.
___
`Move`
- The four instances `UP`, `DOWN`, `LEFT`, and `RIGHT` of this enum class represent the four possible game moves. 
___

### Running tests
- [ ] `GameTest`
- [ ] `MoveTest`
- [ ] `SlidingPuzzleTest`
___

### Roles

> ! =>  to be defined

### Tasks

**`Cihat Ünsal`**
- [ ] `Move`

**`Halil Kömürcü`** 
- [ ] `ConsoleApp`

**`Igor Santana`**
- [ ] `JavaFXApp`


| Task     | Due date   | Assignee      |
|----------|------------|---------------|
| 20.12.23 | Game logic | Cihat Ünsal   |
| 20.12.23 | JavaFxApp  | Igor Santana  |
| 20.12.23 | ConsoleApp | Halil Kömürcü |
