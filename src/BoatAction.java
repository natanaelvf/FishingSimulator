/**
 * Actions available to a boat
 * 
 * @author fc
 *
 */
public enum BoatAction {
    LEFT, RIGHT, UP, DOWN, FISH, END_TRIP;

    public static BoatAction fromString(String s) {
        s = s.toLowerCase();
        switch (s) {
        case "l":
            return LEFT;
        case "r":
            return RIGHT;
        case "u":
            return UP;
        case "d":
            return DOWN;
        case "f":
            return FISH;
        case "e":
            return END_TRIP;
        default:
            return null;
        }
    }
}
