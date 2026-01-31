# DX-Ball / Brick Breaker Game (Java)

A dynamic implementation of the classic DX-Ball game developed using Java and the StdDraw library. This repository contains both the standard assignment version and a modified custom version with power-ups and extra features.

## Gameplay Demo
Click to watch the gameplay:
[YouTube Demo 1](https://youtu.be/DxoPygkJWY) | [YouTube Demo 2](https://youtu.be/PGflxhDdUw)

## Project Structure
* **`code/MehmetArdaKutlu.java`**: The standard implementation handling basic game mechanics, collision physics, and game states.
* **`code/MehmetArdaKutluModified.java`**: The enhanced version featuring 4 unique maps, 6 types of power-ups, and custom visuals.
* **`report/MehmetArdaKutlu.pdf`**: Contains the detailed project documentation.
* **`stdlib.jar`**: The StdDraw library required to run the game.

## Features (Standard Version)
* **Advanced Physics:** Implements elastic collision principles for interactions with walls, paddles, and bricks.
* **Complex Collision Handling:** Solves quadratic equations to handle corner collisions and prevent ball penetration bugs.

## Features (Custom Version)
Unlike the standard implementation, the modified version includes significant enhancements:

* **4 Unique Maps:** Randomly selected maps for varied gameplay.
* **6 Different Power-ups:**
    * **Red Brick (Fire Ball):** Passes through bricks without bouncing.
    * **Purple Brick:** Decreases paddle width.
    * **Brown Brick:** Increases paddle width.
    * **Light Blue Brick:** Increases ball radius.
    * **Gray Brick:** Decreases ball radius.
    * **Pink Brick:** Increases ball speed.

## Technologies
* **Language:** Java
* **Library:** StdDraw
* **Concepts:** Vector Mathematics, Trigonometry, Collision Detection Algorithms.

## Detailed Report
For a deep dive into the mathematical models (trajectory calculations, collision proofs) and implementation details, please refer to the [Project Report](report/MehmetArdaKutlu.pdf).
