package FlightControl.domain;

    /**
     *
     * @author nowakor
     */
    public class Flight {
        private String departure;
        private String destination;
        private Airplane plane;

        public Flight( Airplane plane,String departure, String destination) {
            this.plane = plane;
            this.departure = departure;
            this.destination = destination;
        }

        public String getDeparture() {
            return departure;
        }

        public String getDestination() {
            return destination;
        }

        public Airplane getPlane() {
            return plane;
        }

        @Override
        public String toString() {
            return plane.toString() + "(" + departure + "-" + destination + ")";
        }




    }

