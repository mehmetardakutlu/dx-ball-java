import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class mainClass {

    public static void main(String[] args){

        // Canvas properties, scale and set the canvas with the given parameters
        double xScale = 800.0, yScale = 400.0;
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(0.0, xScale);
        StdDraw.setYscale(0.0, yScale);
// Color array for bricks (first import java.awt.Color )
        Color[] colors = { new Color(0, 100, 0), new Color(34, 139, 34),
                new Color(46, 139, 87), new Color(50, 205, 50),
                new Color(60, 179, 113), new Color(0, 255, 127), new Color(144,238,144),
                new Color(152, 251, 152), new Color(57, 255, 20)
        };
// Game Components (These can be changed for custom scenarios)
        double ballRadius = 8; // Ball radius
        double ballVelocity = 5; // Magnitude of the ball velocity
        Color ballColor = new Color(255, 200, 0); // Color of the ball
        double[] initialBallPos = {400,18}; //Initial position of the ball in the format {x, y}
        double[] paddlePos = {400, 5}; // Initial position of the center of the paddle
        double paddleHalfwidth = 60; // Paddle halfwidth
        double paddleHalfheight = 5; // Paddle halfheight
        double paddleSpeed = 20; // Paddle speed
        Color paddleColor = new Color(0, 0, 128); // Paddle color
        double brickHalfwidth = 50; // Brick halfwidth
        double brickHalfheight = 10; // Brick halfheight
// 2D arrays to store center coordinates of bricks in the format {x, y}
        // There are four different maps
        double[][] brickCoordinatesMap1 = new double[][]{
                {50, 320},{150, 320},{650, 320},{750, 320},
                {50,300},{150, 300},{250, 300},{550, 300},{650, 300},{750, 300},
                {50, 280},{150, 280},{250, 280},{350, 280},{450, 280},{550, 280},{650, 280},{750, 280},
                {50, 260},{150, 260},{250, 260},{350, 260},{450, 260},{550, 260},{650, 260},{750, 260},
                {50, 240},{150, 240},{250, 240},{350, 240},{450, 240},{550, 240},{650, 240},{750, 240},
                {50, 220},{150, 220},{250, 220},{550, 220},{650, 220},{750, 220},
                {50, 200},{150, 200},{650, 200},{750, 200}};

        double[][] brickCoordinatesMap2 = new double[][]{
                {350, 340},{450, 340},
                {350, 320},{450, 320},
                {250, 300},{350, 300},{450, 300},{550, 300},
                {150, 280},{250, 280},{350, 280},{450, 280},{550, 280},{650, 280},
                {50, 260},{150, 260},{250, 260},{550, 260},{650, 260},{750, 260},
                {50, 240},{150, 240},{250, 240},{550, 240},{650, 240},{750, 240},
                {150, 220},{250, 220},{350, 220},{450, 220},{550, 220},{650, 220},
                {250, 200},{350, 200},{450, 200},{550, 200},
                {350,180},{450, 180},
                {350,160},{450, 160}};

        double[][] brickCoordinatesMap3 = new double[][]{
                {50, 320},{150, 320},{250, 320},{350, 320},{450, 320},{550, 320},{650, 320},{750, 320},
                {150,300},{250, 300},{350, 300},{450, 300},{550, 300},{650, 300},
                {250, 280},{350, 280},{450, 280},{550, 280},
                {50, 260},{350, 260},{450, 260},{750, 260},
                {250, 240},{350, 240},{450, 240},{550, 240},
                {150, 220},{250, 220},{350, 220},{450, 220},{550, 220},{650, 220},
                {50, 200},{150, 200},{250, 200},{350, 200},{450, 200},{550, 200},{650, 200},{750, 200}};

        double[][] brickCoordinatesMap4 = new double[][]{
                {50, 340},{150, 340},{650, 340},{750, 340},
                {50, 320},{150, 320},{250, 320},{550, 320},{650, 320},{750, 320},
                {50, 300},{150, 300},{650, 300},{750, 300},
                {50, 280},{350, 280},{450, 280},{750, 280},
                {250, 260},{350, 260},{450, 260},{550, 260},
                {50, 240},{350, 240},{450, 240},{750, 240},
                {50, 220},{150, 220},{650, 220},{750, 220},
                {50, 200},{150, 200},{250, 200},{550, 200},{650, 200},{750, 200},
                {50, 180},{150, 180},{650, 180},{750, 180}};

// Brick colors for every map
        Color [] brickColorsOption1 = new Color[] {
                colors[8], colors[6], colors[6], colors[5],
                colors[7], colors[3], colors[2], colors[1], colors[4], colors[3],
                colors[0], colors[4], colors[0], colors[1], colors[2], colors[3], colors[6], colors[2],
                colors[1], colors[5], colors[2], colors[4], colors[0], colors[5], colors[7], colors[0],
                colors[2], colors[6], colors[3], colors[6], colors[7], colors[8], colors[1], colors[6],
                colors[3], colors[4], colors[5], colors[0], colors[2], colors[5],
                colors[7], colors[8], colors[3], colors[4]};

        Color [] brickColorsOption2 = new Color[] {
                colors[2], colors[1],
                colors[3], colors[0],
                colors[4], colors[2], colors[1], colors[8],
                colors[5], colors[3], colors[5], colors[3], colors[0], colors[7],
                colors[6], colors[4], colors[6], colors[1], colors[8], colors[6],
                colors[7], colors[5], colors[7], colors[0], colors[7], colors[5],
                colors[8], colors[6], colors[1], colors[8], colors[5], colors[4],
                colors[0], colors[7], colors[4], colors[3],
                colors[3], colors[2],
                colors[0], colors[1]};

        Color [] brickColorsOption3 = new Color[] {
                colors[0], colors[1], colors[2], colors[3],colors[4], colors[5], colors[6],colors[7],
                colors[7], colors[6], colors[8], colors[2], colors[1], colors[0],
                colors[1], colors[0], colors[3], colors[4],
                colors[0], colors[2], colors[5], colors[0],
                colors[4], colors[3], colors[0], colors[1],
                colors[0], colors[1], colors[2], colors[8], colors[6], colors[7],
                colors[7], colors[6], colors[5], colors[4],colors[3], colors[2], colors[1], colors[0]};

        Color [] brickColorsOption4 = new Color[] {
                colors[0], colors[1], colors[1], colors[0],
                colors[2], colors[3], colors[4], colors[4], colors[3], colors[2],
                colors[5], colors[6], colors[6], colors[5],
                colors[7], colors[0], colors[3], colors[7],
                colors[8], colors[2], colors[6], colors[8],
                colors[7], colors[3], colors[0], colors[7],
                colors[5], colors[6], colors[6], colors[5],
                colors[2], colors[3], colors[4], colors[4], colors[3], colors[2],
                colors[0], colors[1], colors[1], colors[0]};


        double[][][] maps = {brickCoordinatesMap1, brickCoordinatesMap2, brickCoordinatesMap3, brickCoordinatesMap4};
        Color [][] mapColors = {brickColorsOption1, brickColorsOption2, brickColorsOption3, brickColorsOption4};

        // The map and the places of the power-ups will be determined randomly
        Random random = new Random();
        int randomMapPicker = random.nextInt(maps.length);

        // Determining the map number
        double [][] brickCoordinates = maps[randomMapPicker];
        Color [] brickColors = mapColors[randomMapPicker];

        // Matching power-up codes with their brick numbers
        int[][] powerUpPairs = new int[6][2];

        Color[] powerUpColors = {new Color(158,158,158), new Color(175,135,95),
        new Color(215,95,215), new Color(95,135,175), new Color(128,0,128),
        new Color(255,0,0)};

        Random brickPicker = new Random();
        ArrayList<Integer> usedBrickPositions = new ArrayList<>();
        int poweredBrickNum;

        // Determining the positions of the power-ups
        for(int i = 0; i < powerUpPairs.length; i++){
            poweredBrickNum = brickPicker.nextInt(brickCoordinates.length);
            powerUpPairs[i][0] = i;
            // A while loop is used to avoid getting the same numbers
            while(usedBrickPositions.contains(poweredBrickNum)){
                poweredBrickNum = brickPicker.nextInt(brickCoordinates.length);
            }
            powerUpPairs[i][1] = poweredBrickNum;
            usedBrickPositions.add(poweredBrickNum);
        }

        // Coloring the bricks that have get the power ups
        for(int i = 0; i < powerUpPairs.length; i++){
            brickColors[powerUpPairs[i][1]] = powerUpColors[i];
        }

        // Checks if the power-ups are used
        boolean[] isPowerUpsUsed = new boolean[powerUpPairs.length];
        Arrays.fill(isPowerUpsUsed,false);

        // An array that stores the status of the bricks (whether they are intact or cleared)
        boolean[] isBricksBroken = new boolean[brickCoordinates.length];
        // Initially, all the bricks are intact
        Arrays.fill(isBricksBroken, false);

        // Enabling double buffering for smoother animations
        StdDraw.enableDoubleBuffering();

        // Defining important variables that will be used in the remaining of the code
        int pauseDuration = 25;// Time interval between each frame in milliseconds
        // Boolean variables which indicate the current status of the game
        boolean isGameStarted = false;
        boolean isGameLost = false;
        boolean isGameWon = false;
        boolean isGamePaused = false;
        boolean isSpaceCooledDown = true;
        boolean spaceChecker = false;
        boolean isFireBall = false;
        // Keep track of the number of cleared bricks and the player's score
        int bricksBroken = 0;
        int score = 0;
        // Sets a time limit for the repeated space key presses
        int spaceCooldownTime = 8;
        // Some variables for the brick collision
        ArrayList<Integer> collidingBricks = new ArrayList<>();
        int orderOfBrickCollisions = 0;

        int guideLineLength = 50; // Length of the trajectory line
        // Initial shooting angle
        double thetaDegrees = 0;

        // Setting the initial position of the trajectory line
        double finalLinePos_x = paddlePos[0] + guideLineLength;
        double finalLinePos_y = 2 * paddleHalfheight + ballRadius;

        // Starting the initial game with a while loop
        while(!isGameStarted){
            StdDraw.clear(StdDraw.WHITE); // Preparing to create a new frame
            StdDraw.setPenColor(paddleColor); // Drawing the paddle with the predefined properties
            StdDraw.filledRectangle(paddlePos[0],paddlePos[1],paddleHalfwidth,paddleHalfheight);
            // Drawing all the bricks using a for loop
            for(int i = 0; i < brickCoordinates.length; i++){
                StdDraw.setPenColor(brickColors[i]);
                StdDraw.filledRectangle(brickCoordinates[i][0], brickCoordinates[i][1], brickHalfwidth, brickHalfheight);
            }
            // Drawing the ball with the predefined properties
            StdDraw.setPenColor(ballColor);
            StdDraw.filledCircle(initialBallPos[0],initialBallPos[1],ballRadius);
            // Drawing trajectory line
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.004);
            StdDraw.line(initialBallPos[0],initialBallPos[1],finalLinePos_x,finalLinePos_y);
            // Writing the angle information
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 20) );
            StdDraw.textLeft(15,375,"Angle: " + thetaDegrees);
            // Shifting the value of the angle taking user input
            if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && thetaDegrees < 180){
                thetaDegrees += 1;
            }
            if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && thetaDegrees > 0){
                thetaDegrees -= 1;
            }
            // Shifting the endpoint of the trajectory line
            finalLinePos_x = guideLineLength * Math.cos(Math.toRadians(thetaDegrees)) + initialBallPos[0];
            finalLinePos_y = guideLineLength * Math.sin(Math.toRadians(thetaDegrees)) + initialBallPos[1];
            // Pressing space will initialize the main game
            if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                isGameStarted = true;
                isSpaceCooledDown = false;

            }
            // Displaying the frame and waiting for 25ms
            StdDraw.show();
            StdDraw.pause(pauseDuration);
        }

        // After the space key is pressed, the ball's velocity components are determined using thetaDegrees
        double ballVelocity_x = ballVelocity * Math.cos(Math.toRadians(thetaDegrees));
        double ballVelocity_y = ballVelocity * Math.sin(Math.toRadians(thetaDegrees));

        // The only two ways of breaking the main game while loop are clearing all the bricks or
        // allowing the ball to hit the bottom surface
        while(true){
            // Position of the ball is updated in each frame
            initialBallPos[0] += ballVelocity_x;
            initialBallPos[1] += ballVelocity_y;


            // Vertical collision with the paddle
            if (2 * paddleHalfheight <= initialBallPos[1] &&
                    initialBallPos[1] <= 2 * paddleHalfheight + ballRadius &&
                    Math.abs(initialBallPos[0] - paddlePos[0]) <= paddleHalfwidth) {
                // Reversing the velocity at y-axis
                ballVelocity_y = Math.abs(ballVelocity_y);
                // Ball is reflected from inside the paddle, which will look more sensible
                initialBallPos[1] += 2 * (2 * paddleHalfheight + ballRadius - initialBallPos[1]);
            }

            // Horizontal collision with the paddle
            if (0 < initialBallPos[1] && initialBallPos[1] <= 2 * paddleHalfheight &&
                    paddleHalfwidth < Math.abs(initialBallPos[0] - paddlePos[0]) &&
                    Math.abs(initialBallPos[0] - paddlePos[0]) <= paddleHalfwidth + ballRadius) {
                // Reversing the velocity at x-axis
                ballVelocity_x = -ballVelocity_x;
                // Visual improvements
                if (initialBallPos[0] < paddlePos[0]) {
                    initialBallPos[0] += 2 * (paddlePos[0] - paddleHalfwidth - ballRadius - initialBallPos[0]);
                } else if (initialBallPos[0] > paddlePos[0]) {
                    initialBallPos[0] += 2 * (paddlePos[0] + paddleHalfwidth + ballRadius - initialBallPos[0]);
                }
            }

            // Corner collision block, which has a lot of requirements to enter
            if (2 * paddleHalfheight < initialBallPos[1] &&
                    initialBallPos[1] < 2 * paddleHalfheight + ballRadius &&
                    paddleHalfwidth < Math.abs(initialBallPos[0] - paddlePos[0]) &&
                    Math.abs(initialBallPos[0] - paddlePos[0]) < paddleHalfwidth + ballRadius &&
                    (Math.sqrt(Math.pow(initialBallPos[0] - (paddlePos[0] - paddleHalfwidth), 2)
                    + Math.pow(initialBallPos[1] - 2 * paddleHalfheight, 2)) <= ballRadius ||
                    Math.sqrt(Math.pow(initialBallPos[0] - (paddlePos[0] + paddleHalfwidth), 2)
                    + Math.pow(initialBallPos[1] - 2 * paddleHalfheight, 2)) <= ballRadius)) {

                double[] paddleCornerCoords = new double[2];
                double normalAngle = 0;
                double velocityAngle = 0;
                double enteringCoefficient = 1;
                boolean isBallEntered = false;

                // Finding the correct corner that the ball hit
                if (Math.sqrt(Math.pow(initialBallPos[0] - (paddlePos[0] - paddleHalfwidth), 2)
                        + Math.pow(initialBallPos[1] - 2 * paddleHalfheight, 2)) <= ballRadius) {
                    paddleCornerCoords[0] = paddlePos[0] - paddleHalfwidth;
                    paddleCornerCoords[1] = 2 * paddleHalfheight;
                } else if (Math.sqrt(Math.pow(initialBallPos[0] - (paddlePos[0] + paddleHalfwidth), 2)
                        + Math.pow(initialBallPos[1] - 2 * paddleHalfheight, 2)) <= ballRadius) {
                    paddleCornerCoords[0] = paddlePos[0] + paddleHalfwidth;
                    paddleCornerCoords[1] = 2 * paddleHalfheight;
                }

                // Handling the case in which the ball enters the paddle
                if (Math.pow(initialBallPos[0] - paddleCornerCoords[0], 2) +
                        Math.pow(initialBallPos[1] - paddleCornerCoords[1], 2) < Math.pow(ballRadius, 2)) {

                    // Finding the distance that travelled by the ball after entering the paddle
                    double discriminant = 4 * Math.pow(paddleCornerCoords[0] * ballVelocity_x +
                            paddleCornerCoords[1] * ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                            initialBallPos[1] * ballVelocity_y, 2) - 4 * (Math.pow(ballVelocity_x, 2) +
                            Math.pow(ballVelocity_y, 2)) * (Math.pow(paddleCornerCoords[0], 2) +
                            Math.pow(initialBallPos[0], 2) + Math.pow(paddleCornerCoords[1], 2) +
                            Math.pow(initialBallPos[1], 2) - 2 * paddleCornerCoords[0] * initialBallPos[0] -
                            2 * paddleCornerCoords[1] * initialBallPos[1] - Math.pow(ballRadius, 2));

                    double firstRoot = (-2 * (paddleCornerCoords[0] * ballVelocity_x + paddleCornerCoords[1] *
                            ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                            initialBallPos[1] * ballVelocity_y) + Math.sqrt(discriminant)) /
                            (2 * (Math.pow(ballVelocity_x, 2) + Math.pow(ballVelocity_y, 2)));

                    double secondRoot = (-2 * (paddleCornerCoords[0] * ballVelocity_x + paddleCornerCoords[1] *
                            ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                            initialBallPos[1] * ballVelocity_y) - Math.sqrt(discriminant)) /
                            (2 * (Math.pow(ballVelocity_x, 2) + Math.pow(ballVelocity_y, 2)));

                    // Choosing the correct root
                    if (0 < firstRoot && firstRoot < 1) {
                        enteringCoefficient = firstRoot;
                    } else if (0 < secondRoot && secondRoot < 1) {
                        enteringCoefficient = secondRoot;
                    }
                    // Bringing back the ball to the state that it touches the paddle
                    initialBallPos[0] = initialBallPos[0] - enteringCoefficient * ballVelocity_x;
                    initialBallPos[1] = initialBallPos[1] - enteringCoefficient * ballVelocity_y;
                    isBallEntered = true;
                }
                // Finding the angles that the normal and the initial velocity makes
                if (initialBallPos[1] - paddleCornerCoords[1] > 0) {
                    normalAngle = Math.acos((initialBallPos[0] - paddleCornerCoords[0]) / ballRadius);
                } else if (initialBallPos[1] - paddleCornerCoords[1] < 0) {
                    normalAngle = 2 * Math.PI - Math.acos((initialBallPos[0] - paddleCornerCoords[0]) / ballRadius);
                }

                if (ballVelocity_y >= 0) {
                    velocityAngle = Math.acos(ballVelocity_x / ballVelocity);
                } else if (ballVelocity_y < 0) {
                    velocityAngle = 2 * Math.PI - Math.acos(ballVelocity_x / ballVelocity);
                }
                // Updating velocity components
                ballVelocity_x = ballVelocity * Math.cos(Math.PI - velocityAngle + 2 * normalAngle);
                ballVelocity_y = ballVelocity * Math.sin(Math.PI - velocityAngle + 2 * normalAngle);

                // Reflecting the ball in the updated direction
                if (isBallEntered) {
                    initialBallPos[0] += ballVelocity_x * enteringCoefficient;
                    initialBallPos[1] += ballVelocity_y * enteringCoefficient;
                }

            }


            // Checking all the bricks for a possible collision using a for loop,
            for (int i = 0; i < brickCoordinates.length; i++) {// Cleared bricks are not considered
                if (!isBricksBroken[i]) {
                    if (Math.abs(initialBallPos[0] - brickCoordinates[i][0]) <= brickHalfwidth &&
                            brickHalfheight <= Math.abs(initialBallPos[1] - brickCoordinates[i][1]) &&
                            Math.abs(initialBallPos[1] - brickCoordinates[i][1]) <= brickHalfheight + ballRadius) {

                        collidingBricks.add(i);
                        orderOfBrickCollisions ++;
                    }

                    if (Math.abs(initialBallPos[1] - brickCoordinates[i][1]) <= brickHalfheight &&
                            brickHalfwidth <= Math.abs(initialBallPos[0] - brickCoordinates[i][0]) &&
                            Math.abs(initialBallPos[0] - brickCoordinates[i][0]) <= brickHalfwidth + ballRadius) {

                        collidingBricks.add(i);
                        orderOfBrickCollisions ++;
                    }

                    if (brickHalfwidth < Math.abs(initialBallPos[0] - brickCoordinates[i][0]) &&
                        Math.abs(initialBallPos[0] - brickCoordinates[i][0]) < brickHalfwidth + ballRadius &&
                        brickHalfheight < Math.abs(initialBallPos[1] - brickCoordinates[i][1]) &&
                        Math.abs(initialBallPos[1] - brickCoordinates[i][1]) < brickHalfheight + ballRadius &&
                        (Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] + brickHalfwidth), 2) +
                        Math.pow(initialBallPos[1] - (brickCoordinates[i][1] + brickHalfheight), 2)) <= ballRadius ||
                        Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] - brickHalfwidth), 2) +
                        Math.pow(initialBallPos[1] - (brickCoordinates[i][1] + brickHalfheight), 2)) <= ballRadius ||
                        Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] - brickHalfwidth), 2) +
                        Math.pow(initialBallPos[1] - (brickCoordinates[i][1] - brickHalfheight), 2)) <= ballRadius ||
                        Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] + brickHalfwidth), 2) +
                        Math.pow(initialBallPos[1] - (brickCoordinates[i][1] - brickHalfheight), 2)) <= ballRadius)) {

                        collidingBricks.add(i);
                        orderOfBrickCollisions += 2;
                    }
                }
            }

            // Checking all the bricks for a possible collision using a for loop,
            for (int i = 0; i < brickCoordinates.length; i++) {// Cleared bricks are not considered
                if (!isBricksBroken[i]) {
                    // Vertical brick collisions
                    if (Math.abs(initialBallPos[0] - brickCoordinates[i][0]) <= brickHalfwidth &&
                            brickHalfheight <= Math.abs(initialBallPos[1] - brickCoordinates[i][1]) &&
                            Math.abs(initialBallPos[1] - brickCoordinates[i][1]) <= brickHalfheight + ballRadius) {

                        // Changing y component of velocity depending on whether the ball hits the bottom
                        // or the top surface
                        if (initialBallPos[1] < brickCoordinates[i][1]) {
                            // If the ball is a fireball, all the velocity and direction changes that
                            // may be caused from the brick collisions are prevented
                            if(!isFireBall) {
                                ballVelocity_y = -Math.abs(ballVelocity_y);
                                initialBallPos[1] += 2 * (brickCoordinates[i][1] - brickHalfheight - ballRadius - initialBallPos[1]);
                            }
                        }
                        else if (initialBallPos[1] > brickCoordinates[i][1]) {
                            if(!isFireBall) {
                                ballVelocity_y = Math.abs(ballVelocity_y);
                                initialBallPos[1] += 2 * (brickCoordinates[i][1] + brickHalfheight + ballRadius - initialBallPos[1]);
                            }
                        }

                        // Marking the brick as cleared
                        isBricksBroken[i] = true;
                        // Incrementing the score
                        score += 10;
                        // Incrementing the number of cleared bricks
                        bricksBroken++;

                        if(collidingBricks.size() == 2 && orderOfBrickCollisions == 3){
                            for(int j : collidingBricks){
                                if(j != i){
                                    isBricksBroken[j] = true;
                                }
                            }
                            score += 10;
                            bricksBroken ++;
                        }

                        if(collidingBricks.size() == 2 && orderOfBrickCollisions == 2){
                            for (int j : collidingBricks){
                                if (j != i){
                                    if (brickCoordinates[i][1] == brickCoordinates[j][1]){
                                        isBricksBroken[j] = true;
                                        score += 10;
                                        bricksBroken++;
                                    }
                                }
                            }
                        }
                    }

                    // Horizontal brick collisions
                    if (Math.abs(initialBallPos[1] - brickCoordinates[i][1]) <= brickHalfheight &&
                            brickHalfwidth <= Math.abs(initialBallPos[0] - brickCoordinates[i][0]) &&
                            Math.abs(initialBallPos[0] - brickCoordinates[i][0]) <= brickHalfwidth + ballRadius) {

                        // Changing y component of velocity depending on whether the ball hits the right side
                        // or the left side
                        if (initialBallPos[0] < brickCoordinates[i][0]) {
                            if(!isFireBall) {
                                ballVelocity_x = -Math.abs(ballVelocity_x);
                                initialBallPos[0] += 2 * (brickCoordinates[i][0] - brickHalfwidth - ballRadius - initialBallPos[0]);
                            }
                        }
                        else if (initialBallPos[0] > brickCoordinates[i][0]) {
                            if(!isFireBall) {
                                ballVelocity_x = Math.abs(ballVelocity_x);
                                initialBallPos[0] += 2 * (brickCoordinates[i][0] + brickHalfwidth + ballRadius - initialBallPos[0]);
                            }
                        }
                        // Marking the brick as cleared
                        isBricksBroken[i] = true;
                        // Incrementing the score
                        score += 10;
                        // Incrementing the number of cleared bricks
                        bricksBroken ++;

                        if(collidingBricks.size() == 2 && orderOfBrickCollisions == 3){
                            for(int j : collidingBricks){
                                if(j != i){
                                    isBricksBroken[j] = true;
                                }
                            }
                            score += 10;
                            bricksBroken ++;
                        }

                        if(collidingBricks.size() == 2 && orderOfBrickCollisions == 2){
                            for(int j : collidingBricks){
                                if(j != i){
                                    if(brickCoordinates[i][0] == brickCoordinates[j][0]) {
                                        isBricksBroken[j] = true;
                                        score += 10;
                                        bricksBroken++;
                                    }
                                }
                            }
                        }
                    }

                    // Corner collision case for bricks which has numerous requirements
                    // Unlike the paddle, the code searches for all the four corners
                    if (brickHalfwidth < Math.abs(initialBallPos[0] - brickCoordinates[i][0]) &&
                            Math.abs(initialBallPos[0] - brickCoordinates[i][0]) < brickHalfwidth + ballRadius &&
                            brickHalfheight < Math.abs(initialBallPos[1] - brickCoordinates[i][1]) &&
                            Math.abs(initialBallPos[1] - brickCoordinates[i][1]) < brickHalfheight + ballRadius &&
                            collidingBricks.size() == 1 &&
                            (Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] + brickHalfwidth), 2) +
                            Math.pow(initialBallPos[1] - (brickCoordinates[i][1] + brickHalfheight), 2)) <= ballRadius ||
                            Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] - brickHalfwidth), 2) +
                            Math.pow(initialBallPos[1] - (brickCoordinates[i][1] + brickHalfheight), 2)) <= ballRadius ||
                            Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] - brickHalfwidth), 2) +
                            Math.pow(initialBallPos[1] - (brickCoordinates[i][1] - brickHalfheight), 2)) <= ballRadius ||
                            Math.sqrt(Math.pow(initialBallPos[0] - (brickCoordinates[i][0] + brickHalfwidth), 2) +
                            Math.pow(initialBallPos[1] - (brickCoordinates[i][1] - brickHalfheight), 2)) <= ballRadius)) {

                        double[] brickCornerCoords = new double[2];
                        boolean isBallEntered = false;
                        double normalAngle = 0;
                        double velocityAngle = 0;
                        double enteringCoefficient = 0;

                        // Determining the corner that the collision occurred
                        if (initialBallPos[0] > brickCoordinates[i][0] && initialBallPos[1] > brickCoordinates[i][1]) {
                            brickCornerCoords[0] = brickCoordinates[i][0] + brickHalfwidth;
                            brickCornerCoords[1] = brickCoordinates[i][1] + brickHalfheight;
                        }
                        else if (initialBallPos[0] < brickCoordinates[i][0] && initialBallPos[1] > brickCoordinates[i][1]) {
                            brickCornerCoords[0] = brickCoordinates[i][0] - brickHalfwidth;
                            brickCornerCoords[1] = brickCoordinates[i][1] + brickHalfheight;
                        }
                        else if (initialBallPos[0] < brickCoordinates[i][0] && initialBallPos[1] < brickCoordinates[i][1]) {
                            brickCornerCoords[0] = brickCoordinates[i][0] - brickHalfwidth;
                            brickCornerCoords[1] = brickCoordinates[i][1] - brickHalfheight;
                        }
                        else if (initialBallPos[0] > brickCoordinates[i][0] && initialBallPos[1] < brickCoordinates[i][1]) {
                            brickCornerCoords[0] = brickCoordinates[i][0] + brickHalfwidth;
                            brickCornerCoords[1] = brickCoordinates[i][1] - brickHalfheight;
                        }

                        // Handles the ball penetration to the brick with the same technique used in the paddle
                        if (Math.sqrt(Math.pow(initialBallPos[0] - brickCornerCoords[0], 2) +
                                Math.pow(initialBallPos[1] - brickCornerCoords[1], 2)) < ballRadius) {

                            double discriminant = 4 * Math.pow(brickCornerCoords[0] * ballVelocity_x +
                                    brickCornerCoords[1] * ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                                    initialBallPos[1] * ballVelocity_y, 2) - 4 * (Math.pow(ballVelocity_x, 2) +
                                    Math.pow(ballVelocity_y, 2)) * (Math.pow(brickCornerCoords[0], 2) +
                                    Math.pow(initialBallPos[0], 2) + Math.pow(brickCornerCoords[1], 2) +
                                    Math.pow(initialBallPos[1], 2) - 2 * brickCornerCoords[0] * initialBallPos[0] -
                                    2 * brickCornerCoords[1] * initialBallPos[1] - Math.pow(ballRadius, 2));

                            double firstRoot = (-2 * (brickCornerCoords[0] * ballVelocity_x + brickCornerCoords[1] *
                                    ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                                    initialBallPos[1] * ballVelocity_y) + Math.sqrt(discriminant)) /
                                    (2 * (Math.pow(ballVelocity_x, 2) + Math.pow(ballVelocity_y, 2)));

                            double secondRoot = (-2 * (brickCornerCoords[0] * ballVelocity_x + brickCornerCoords[1] *
                                    ballVelocity_y - initialBallPos[0] * ballVelocity_x -
                                    initialBallPos[1] * ballVelocity_y) - Math.sqrt(discriminant)) /
                                    (2 * (Math.pow(ballVelocity_x, 2) + Math.pow(ballVelocity_y, 2)));

                            if (0 < firstRoot && firstRoot < 1) {
                                enteringCoefficient = firstRoot;
                            }
                            else if (0 < secondRoot && secondRoot < 1) {
                                enteringCoefficient = secondRoot;
                            }
                            if(!isFireBall) {
                                initialBallPos[0] = initialBallPos[0] - enteringCoefficient * ballVelocity_x;
                                initialBallPos[1] = initialBallPos[1] - enteringCoefficient * ballVelocity_y;
                                isBallEntered = true;
                            }
                        }

                        // Finding the angles of the initial velocity and normal line

                        if (initialBallPos[1] - brickCornerCoords[1] > 0) {
                            normalAngle = Math.acos((initialBallPos[0] - brickCornerCoords[0]) / ballRadius);
                        }
                        else if (initialBallPos[1] - brickCornerCoords[1] < 0) {
                            normalAngle = 2 * Math.PI - Math.acos((initialBallPos[0] - brickCornerCoords[0]) / ballRadius);
                        }
                        if (ballVelocity_y >= 0) {
                            velocityAngle = Math.acos(ballVelocity_x / ballVelocity);
                        }
                        else if (ballVelocity_y < 0) {
                            velocityAngle = 2 * Math.PI - Math.acos(ballVelocity_x / ballVelocity);
                        }
                        if(!isFireBall) {
                            // Updating velocity parameters
                            ballVelocity_x = ballVelocity * Math.cos(Math.PI - velocityAngle + 2 * normalAngle);
                            ballVelocity_y = ballVelocity * Math.sin(Math.PI - velocityAngle + 2 * normalAngle);
                        }

                        // Reflecting the ball
                        if (isBallEntered) {
                            initialBallPos[0] += ballVelocity_x * enteringCoefficient;
                            initialBallPos[1] += ballVelocity_y * enteringCoefficient;
                        }
                        // Marking the brick as cleared
                        isBricksBroken[i] = true;
                        // Incrementing the score
                        score += 10;
                        // Incrementing the number of cleared bricks
                        bricksBroken ++;
                    }
                }
            }

            collidingBricks.clear();
            orderOfBrickCollisions = 0;

            // Checking whether the power-up bricks are cleared
            // If the brick is cleared and its power-up is not used, the power-up will be applied
            for(int i = 0; i < powerUpPairs.length; i++){
                if(isBricksBroken[powerUpPairs[i][1]] && !isPowerUpsUsed[i]){
                    // Shrinking the ball
                    if(i == 0 && ballVelocity == 5){
                        ballRadius = 6;
                    }
                    // Enlarging the paddle
                    else if(i == 1){
                        paddleHalfwidth = 90;
                        if(paddlePos[0] > xScale - paddleHalfwidth){
                            paddlePos[0] = xScale - paddleHalfwidth;
                        }

                        if(paddlePos[0] < paddleHalfwidth){
                            paddlePos[0] = paddleHalfwidth;
                        }
                    }
                    // Speeding up the ball
                    else if(i == 2 && ballRadius >= 8){
                        ballVelocity_x *= 1.5;
                        ballVelocity_y *= 1.5;
                        ballVelocity = 7.5;
                    }
                    // Increasing the ball radius
                    else if(i == 3){
                        ballRadius = 12;
                    }
                    // Shrinking the paddle
                    else if(i == 4){
                        paddleHalfwidth = 40;
                    }
                    // Turning the ball into a fireball
                    else if(i == 5){
                        ballColor = new Color(255, 69, 0);
                        isFireBall = true;
                    }
                    isPowerUpsUsed[i] = true;
                }
            }

            // Bouncing the ball from the right wall
            if (initialBallPos[0] > xScale - ballRadius) {
                ballVelocity_x = -Math.abs(ballVelocity_x);
                initialBallPos[0] += 2 * (xScale - ballRadius - initialBallPos[0]);
            }

            // Bouncing the ball from the left wall
            if(initialBallPos[0] < ballRadius){
                ballVelocity_x = Math.abs(ballVelocity_x);
                initialBallPos[0] += 2 * (ballRadius - initialBallPos[0]);
            }

            // Bouncing the ball from the top wall
            if(initialBallPos[1] >= yScale - ballRadius){
                ballVelocity_y = - Math.abs(ballVelocity_y);
                initialBallPos[1] += 2 * (yScale - ballRadius - initialBallPos[1]);
            }


            // If the ball touches the bottom wall, the main loop is broken and isGameLost becomes true
            // The player is redirected to the game over screen
            if(initialBallPos[1] <= ballRadius){
                isGameLost = true;
                break;
            }

            // If the number of cleared bricks equal the length of the brick coordinates,
            // It means that all the bricks are cleared
            // The main loop is broken, and the user is redirected to the victory screen
            if(bricksBroken == brickCoordinates.length){
                isGameWon = true;
                break;
            }

            // If 200 ms has passed after the last game status change,
            // The space key becomes ready again to change the game status
            if(spaceCooldownTime == 0){
                isSpaceCooledDown = true;
            }

            // If the space key is not held down, spaceChecker becomes false,
            if(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                spaceChecker = false;
            }

            // Pressing the space key resets the timer
            if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                spaceCooldownTime = 8;
            }

            // If the user is not pressing space key repeatedly or holding it down,
            // isGamePaused returns true, initiating the pause loop
            if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && isSpaceCooledDown && !spaceChecker){
                isSpaceCooledDown = false;
                isGamePaused = true;
                spaceChecker = true;
                spaceCooldownTime = 8;
            }

            // Moving the paddle along the x-axis using right and left arrow keys
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && paddlePos[0] < xScale - paddleHalfwidth) {
                paddlePos[0] += paddleSpeed;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && paddlePos[0] > paddleHalfwidth) {
                paddlePos[0] -= paddleSpeed;
            }

            // This code handles the paddle bug caused by the velocity gap between the paddle and the ball
            if(Math.abs(initialBallPos[0] - paddlePos[0]) < paddleHalfwidth &&
            Math.abs(initialBallPos[1] - paddlePos[1]) < paddleHalfheight){
                initialBallPos[1] = 2 * paddleHalfheight + ballRadius;
                ballVelocity_y = Math.abs(ballVelocity_y);
            }

            // Pause loop shows the pause screen until a space key hit which does not conflicts with the limitations
            while(isGamePaused){
                StdDraw.clear(StdDraw.WHITE);
                StdDraw.setPenColor(paddleColor);
                StdDraw.filledRectangle(paddlePos[0], paddlePos[1], paddleHalfwidth, paddleHalfheight);

                for(int i = 0; i < brickCoordinates.length; i++){
                    if(!isBricksBroken[i]){
                        StdDraw.setPenColor(brickColors[i]);
                        StdDraw.filledRectangle(brickCoordinates[i][0], brickCoordinates[i][1], brickHalfwidth, brickHalfheight);
                    }
                }
                StdDraw.setPenColor(ballColor);
                StdDraw.filledCircle(initialBallPos[0], initialBallPos[1], ballRadius);
                StdDraw.setPenColor(StdDraw.BLACK);
                // Unlike the main loop, a "PAUSED" text is shown
                StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 25) );
                StdDraw.textLeft(15,375,"Paused");
                StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 18) );
                StdDraw.textLeft(690,375,"Score: " + score);
                StdDraw.show();
                StdDraw.pause(25);

                if(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                    spaceChecker = false;
                }

                if(spaceCooldownTime == 0){
                    isSpaceCooledDown = true;
                }

                if(!isSpaceCooledDown){
                    spaceCooldownTime -= 1;
                }

                if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                    spaceCooldownTime = 8;
                }

                if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && isSpaceCooledDown && !spaceChecker){
                    isGamePaused = false;
                    isSpaceCooledDown = false;
                    spaceChecker = true;
                    spaceCooldownTime = 8;
                }
            }

            // Resetting the canvas, drawing updated components and displaying the new frame
            StdDraw.clear(StdDraw.WHITE);
            StdDraw.setPenColor(paddleColor);
            StdDraw.filledRectangle(paddlePos[0], paddlePos[1], paddleHalfwidth, paddleHalfheight);
            for (int i = 0; i < brickCoordinates.length; i++) {
                if (!isBricksBroken[i]) {
                    StdDraw.setPenColor(brickColors[i]);
                    StdDraw.filledRectangle(brickCoordinates[i][0], brickCoordinates[i][1], brickHalfwidth, brickHalfheight);
                }
            }
            StdDraw.setPenColor(ballColor);
            StdDraw.filledCircle(initialBallPos[0], initialBallPos[1], ballRadius);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 18) );
            StdDraw.textLeft(690,375,"Score: " + score);
            StdDraw.show();
            StdDraw.pause(pauseDuration);

            if(!isSpaceCooledDown){
                spaceCooldownTime -= 1;
            }

        }
        if(isGameLost){
            StdDraw.clear(StdDraw.WHITE);
            StdDraw.setPenColor(paddleColor);
            StdDraw.filledRectangle(paddlePos[0], paddlePos[1], paddleHalfwidth, paddleHalfheight);
            for (int i = 0; i < brickCoordinates.length; i++) {
                if (!isBricksBroken[i]) {
                    StdDraw.setPenColor(brickColors[i]);
                    StdDraw.filledRectangle(brickCoordinates[i][0], brickCoordinates[i][1], brickHalfwidth, brickHalfheight);
                }
            }
            StdDraw.setPenColor(ballColor);
            StdDraw.filledCircle(initialBallPos[0], initialBallPos[1], ballRadius);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 48) );
            StdDraw.text(400,110,"GAME OVER!");
            // Score is displayed below the "GAME OVER!" text
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 28) );
            StdDraw.text(400,60,"Score: " + score);
            StdDraw.show();
        }

        // If all the brick are cleared, the victory screen appears
        if(isGameWon){
            StdDraw.clear(StdDraw.WHITE);
            StdDraw.setPenColor(paddleColor);
            StdDraw.filledRectangle(paddlePos[0], paddlePos[1], paddleHalfwidth, paddleHalfheight);
            for (int i = 0; i < brickCoordinates.length; i++) {
                if (!isBricksBroken[i]) {
                    StdDraw.setPenColor(brickColors[i]);
                    StdDraw.filledRectangle(brickCoordinates[i][0], brickCoordinates[i][1], brickHalfwidth, brickHalfheight);
                }
            }
            StdDraw.setPenColor(ballColor);
            StdDraw.filledCircle(initialBallPos[0], initialBallPos[1], ballRadius);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 48) );
            StdDraw.text(400,110,"VICTORY!");
            // Score is displayed below the "VICTORY!" text
            StdDraw.setFont( new Font("Arial Rounded MT Bold", Font.PLAIN, 28) );
            StdDraw.text(400,60,"Score: " + score);
            StdDraw.show();
        }
    }
}
