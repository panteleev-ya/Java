package ShortingWay;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Deque<Action> actions = new ArrayDeque<>();
        while (console.hasNextLine()) {
            Action nextAction = new Action(console.nextLine());
            Action prevAction = actions.peekLast();

            if (actions.isEmpty()) {
                actions.addLast(nextAction);
                continue;
            }

            // If directions are same
            if (prevAction.direction.equals(nextAction.direction)) {
                prevAction.distance += nextAction.distance;
            }

            // If directions are opposite
            else if (prevAction.hasOppositeDirectionsWith(nextAction)) {
                if (prevAction.distance > nextAction.distance) {
                    prevAction.distance -= nextAction.distance;
                } else if (prevAction.distance == nextAction.distance) {
                    actions.removeLast();
                } else {
                    actions.removeLast();
                    nextAction.distance -= prevAction.distance;
                    actions.addLast(nextAction);
                }
            }
            else {
                actions.addLast(nextAction);
            }
        }
        while (!actions.isEmpty()) {
            System.out.println(actions.pop());
        }
        console.close();
    }

    private static class Action {
        public Direction direction;
        public int distance;

        public Action(String line) {
            String[] words = line.split(" ");
            String direction = words[0];
            if (direction.equals("TOP")) {
                this.direction = Direction.TOP;
            } else if (direction.equals("RIGHT")) {
                this.direction = Direction.RIGHT;
            } else if (direction.equals("BOTTOM")) {
                this.direction = Direction.BOTTOM;
            } else {
                this.direction = Direction.LEFT;
            }
            this.distance = Integer.parseInt(words[1]);
        }

        public boolean hasOppositeDirectionsWith(Action action) {
            if (this.direction.equals(Direction.BOTTOM) && action.direction.equals(Direction.TOP)) {
                return true;
            } else if (this.direction.equals(Direction.TOP) && action.direction.equals(Direction.BOTTOM)) {
                return true;
            } else if (this.direction.equals(Direction.LEFT) && action.direction.equals(Direction.RIGHT)) {
                return true;
            } else if (this.direction.equals(Direction.RIGHT) && action.direction.equals(Direction.LEFT)) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return direction + " " + distance;
        }
    }

    private enum Direction {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }
}
