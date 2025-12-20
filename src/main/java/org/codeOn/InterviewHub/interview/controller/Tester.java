class MovieTicket {
    //Implement your code here 
    private int movieId;
    private int noOfSeats;
    private double costPerTicket;
    
   public MovieTicket(int movieId, int noOfSeats){
        this.movieId = movieId;
        this.noOfSeats = noOfSeats;
    }
    public double calculateTotalAmount(){
        return noOfSeats*costPerTicket;
    }
    public int getMovieId(){
        return movieId;
    }
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }
    public int getNoOfSeats(){
        return noOfSeats;
    }
    public void setNoOfSeats(int noOfSeats){
        this.noOfSeats = noOfSeats;
    }public double getCostPerTicket(){
        return costPerTicket;
    }
    public void setCostPerTicket(double costPerTicket){
        this.costPerTicket = costPerTicket;
    }
    
}


class Tester {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket(112, 3);
        double amount = movieTicket.calculateTotalAmount();
        if (amount==0)
            System.out.println("Sorry! Please enter valid movie Id and number of seats");
        else
            System.out.println("Total amount for booking : $" + amount);
    }
}