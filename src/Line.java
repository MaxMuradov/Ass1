public class Line {
        private final Point start;
        private final Point end;

        // constructors

        /**
         *
         * @param start start
         * @param end
         */
        public Line(final Point start, final Point end) {
                this.start = new Point(start.getX(), start.getY());
                this.end = new Point(end.getX(), end.getY());
        }

        public Line(final double x1, final double y1, final double x2, final double y2)
        {
                this.start = new Point(x1, y1);
                this.end = new Point(x2, y2);
        }

        // Return the length of the line
        public double length() {
                return start.distance(end);
        }

        // Returns the middle point of the line

        /**
         *
         * @return
         */
        public Point middle() {
                return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY())/2);
        }

        // Returns the start point of the line
        public Point start() {
                return start;
        }

        // Returns the end point of the line
        public Point end() {
                return end;
        }

        // Returns true if the lines intersect, false otherwise
        public boolean isIntersecting(Line other){
                if (this.equals(other))
                        return false;

                int o1 = this.start.orientation(other);
                int o2 = this.end.orientation(other);
                int o3 = other.start().orientation(this);
                int o4 = other.end().orientation(this);

                if ( o1 != o2 && o3 != o4)
                        return true;

                // Special Cases
                // p1, q1 and p2 are collinear and p2 lies on segment p1q1
                if (o1 == 0 && this.start.onTheLine(other)) return true;

                // p1, q1 and q2 are collinear and q2 lies on segment p1q1
                if (o2 == 0 && this.end.onTheLine(other)) return true;

                // p2, q2 and p1 are collinear and p1 lies on segment p2q2
                if (o3 == 0 && other.start().onTheLine(this)) return true;

                // p2, q2 and q1 are collinear and q1 lies on segment p2q2
                if (o4 == 0 && other.end().onTheLine(this)) return true;

                return false; // Doesn't fall in any of the above cases
        }

        // Returns true if this 2 lines intersect with this line, false otherwise
        public boolean isIntersecting(Line other1, Line other2) {
                return isIntersecting(other1) && isIntersecting(other2);
        }

        // Returns the intersection point if the lines intersect,
        // and null otherwise.
/*        public Point intersectionWith(Line other)
        {
                if (isIntersecting(other))
                {
                    double x,y;

                    double koefSlope1 = (other.start().getY() - other.end().getY()) /
                            (other.end().getX() - other.start().getX());
                    double koefSlope2 = (this.start().getY() - this.end().getY()) /
                                (this.end().getX() - this.start().getX());

                    double b1 = other.start().getY() - koefSlope1*other.start().getX();
                    double b2 = this.start().getY() - koefSlope1*this.start().getX();

                    if (Double.valueOf(koefSlope1).equals(koefSlope2) && (Double.valueOf(b1).equals(b2))) {
                              return null;
                    }
                    else
                    //if (!Double.valueOf(koefSlope2 - koefSlope1).equals((double) 0)) {
                    {
                            x = (b1 - b2) / (koefSlope2 - koefSlope1);
                            y = koefSlope1*x + b1;
                    }

                    return new Point(x, y);
                }
                return null;
        }*/

        public Point intersectionWith(Line other) {
                if (!isIntersecting(other)) return null;

                //Check if this line is vertical
                boolean thisVertical = (this.end().getX() - this.start().getX() == 0);
                // Check if the other line is vertical
                boolean otherVertical = (other.end().getX() - other.start().getX() == 0);
                double x, y;

                if (thisVertical) {
                        // This line is vertical, use its x value and plug into the other line's equation
                        x = this.start().getX();
                        double m2 = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
                        double b2 = other.start().getY() - m2 * other.start().getX();
                        y = m2 * x + b2;
                } else if (otherVertical) {
                        // Other line is vertical, use its x value and plug into this line's equation
                        x = other.start().getX();
                        double m1 = (this.end().getY() - this.start().getY()) / (this.end().getX() - this.start().getX());
                        double b1 = this.start().getY() - m1 * this.start().getX();
                        y = m1 * x + b1;
                } else {

                        double m1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
                        double m2 = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());


                        double b1 = start.getY() - m1 * start.getX();
                        double b2 = other.start.getY() - m2 * other.start.getX();

                        if (Math.abs(m1 - m2) < 1e-9) return null; // Parallel or coincident lines

                        x = (b2 - b1) / (m1 - m2);
                        y = m1 * x + b1;
                }

                return new Point(x, y);
        }


        // equals -- return true if the lines are equal, false otherwise
        public boolean equals(Line other) {
            return (start.equals(other.start()) && end.equals(other.end())) ||
                    (start.equals(other.end()) && end.equals(other.start()));
        }
}
