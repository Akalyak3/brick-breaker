import java.util.Scanner;

public class BrickBreakerConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paddlePosition = 5; // Initial paddle position
        int ballPosition = 5; // Ball starts above the paddle
        int ballDirection = 1; // Ball moves right initially
        int bricks = 10; // Total bricks to break
        int score = 0;

        System.out.println("Welcome to Console Brick Breaker!");
        System.out.println("Instructions: Use 'a' to move left, 'd' to move right, 'q' to quit.");
        System.out.println();

        while (bricks > 0) {
            // Display game field
            displayField(paddlePosition, ballPosition);

            // Get user input
            System.out.print("Move: ");
            char move = scanner.next().charAt(0);

            // Update paddle position
            if (move == 'a' && paddlePosition > 1) {
                paddlePosition--;
            } else if (move == 'd' && paddlePosition < 9) {
                paddlePosition++;
            } else if (move == 'q') {
                System.out.println("You quit the game!");
                break;
            }

            // Update ball position and check collisions
            ballPosition += ballDirection;
            if (ballPosition == 0 || ballPosition == 10) {
                ballDirection *= -1; // Reverse direction if ball hits a wall
            }

            if (ballPosition == paddlePosition) {
                score += 10;
                bricks--;
                System.out.println("Brick broken! Score: " + score);
            }

            if (bricks == 0) {
                System.out.println("Congratulations! You broke all the bricks. Final Score: " + score);
            }
        }

        if (bricks > 0) {
            System.out.println("Game Over! Final Score: " + score);
        }
        scanner.close();
    }

    // Display the game field
    private static void displayField(int paddlePosition, int ballPosition) {
        System.out.println("\nGame Field:");
        for (int i = 0; i < 10; i++) {
            if (i == ballPosition) {
                System.out.print("O"); // Ball
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            if (i == paddlePosition) {
                System.out.print("="); // Paddle
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
