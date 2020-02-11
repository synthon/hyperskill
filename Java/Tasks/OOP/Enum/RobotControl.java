public static void moveRobot(Robot robot, int toX, int toY) {

    // check X
    if (robot.getX() < toX) {
        while (!robot.getDirection().name().equals("RIGHT")) {
            robot.turnRight();
        }
    }
    if (robot.getX() > toX) {
        while (!robot.getDirection().name().equals("LEFT")) {
            robot.turnLeft();
        }
    }
    while (robot.getX() != toX) {
        robot.stepForward();
    }

    // check Y
    if (robot.getY() < toY) {
        while (!robot.getDirection().name().equals("UP")) {
            robot.turnRight();
        }
    }
    if (robot.getY() > toY) {
        while (!robot.getDirection().name().equals("DOWN")) {
            robot.turnLeft();
        }
    }
    while (robot.getY() != toY) {
        robot.stepForward();
    }
}
