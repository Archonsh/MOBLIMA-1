package org.gp3.moblima.model;

import java.util.ArrayList;
import java.util.Date;


public class Slot implements Model, Comparable
{
    private ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    private Cinema cinema;
    private Movie movie;
    private Date date;
    private Constant.MovieType movieType;
    private boolean platinum;

    public Slot(int col, int row, Cinema cinema, Movie movie, Date date, Constant.MovieType movieType, boolean plat) {

        for(int i=0;i<row;i++)
        {
            this.seats.add(new ArrayList<Seat>());
            for(int j=0;j<col;j++)
            {
                Seat tmpseat = new Seat(j,i,false);
                this.seats.get(i).add(tmpseat);
            }
        }
        this.platinum = plat;
        this.cinema = cinema;
        this.movie = movie;
        this.date = date;
        this.movieType = movieType;
    }

    public Slot()
    {}


    public int compareTo(Object o)
    {
        Slot s = (Slot) o;
        return this.date.compareTo(s.date);
    }

    public ArrayList<ArrayList<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(int row, int col) {
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                Seat tmpseat = new Seat(j,i,false);
                this.seats.get(i).add(tmpseat);
            }
        }
    }

    public boolean occupySeat(int row, int col)
    {
        if(this.seats.get(row).get(col).isOcccupied())
            return false;
        this.seats.get(row).get(col).setOcccupied(true);
        return true;
    }

    public boolean freeSeat(int row, int col)
    {
        if(!this.seats.get(row).get(col).isOcccupied())
            return false;
        this.seats.get(row).get(col).setOcccupied(false);
        return true;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        return Constant.holidayFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Constant.MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(Constant.MovieType movieType) {
        this.movieType = movieType;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }
}
