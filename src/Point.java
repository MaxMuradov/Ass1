public class Point {
        // you forgot to declare them.
        private final double x;
        private final double y;
        // constructor
        public Point(final double x1, final double y1) {
                this.x = x1;
                this.y = y1;
        }

        // distance -- return the distance of this point to the other point
        public double distance(final Point other) {
                return Math.sqrt(Math.pow(other.getX() - this.x, 2)
                        + Math.pow(other.getY() - this.y, 2));
        }

        // equals -- return true is the points are equal, false otherwise
        public boolean equals(final Point other) {
                return (Double.valueOf(this.x).equals(other.getX())
                        && Double.valueOf(this.y).equals(other.getY()));
        }

        public boolean onTheLine(final Line other) {
        return this.x <= Math.max(other.start().getX(), other.end().getX())
                && this.x >= Math.min(other.start().getX(), other.end().getX())
                && this.y <= Math.max(other.start().getY(), other.end().getY())
                && this.y >= Math.min(other.start().getY(), other.end().getY());
        }

        public int orientation(final Line other) {
                double orientation = ((other.start().getY() - this.y)
                        * (other.end().getX() - other.start().getX()))
                        - ((other.start().getX() - this.x)
                        * (other.end().getY() - other.start().getY()));

                if (orientation == 0) {
                        return 0;
                } else {
                        return orientation > 0 ? 1 : -1;
                }
        }

        // Return the x and y values of this point
        public double getX() {
                return this.x;
        }

        public double getY() {
                return this.y;
        }
}
