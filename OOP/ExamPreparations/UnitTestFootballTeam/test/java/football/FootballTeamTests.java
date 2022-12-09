package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTests {

   private Footballer footballer;
   private FootballTeam footballTeam;

   @Before
    public void setUp(){
       this.footballer = new Footballer("Ivan");
       this.footballTeam = new FootballTeam("Ivan team", 10);
   }

   @Test(expected = NullPointerException.class)
    public void testCreateTeamWithNullNameThrowsEx(){
       new FootballTeam(null, 2);
   }

   @Test(expected = IllegalArgumentException.class)
    public void testCreateTeamWithNegativePositionsThrowsEx(){
       new FootballTeam("name", -2);
   }

   @Test
    public void testSetVacantPositionsReturnsCorrectNumber(){
       FootballTeam footballTeam1 = new FootballTeam("name", 3);
       assertEquals(3, footballTeam1.getVacantPositions());
   }

   @Test(expected =  IllegalArgumentException.class)
    public void testAddFootballerThrowsExWhenNoVacantPositions(){
       FootballTeam footballTeam1 = new FootballTeam("name", 0);
       footballTeam1.addFootballer(footballer);
   }

   @Test
    public void testAddFootballerAddsFootballer(){
       footballTeam.addFootballer(footballer);
       assertEquals(1, footballTeam.getCount());
       Footballer footballer1 = new Footballer("Gosho");
       footballTeam.addFootballer(footballer1);
       assertEquals(2, footballTeam.getCount());
   }

   @Test
    public void testRemoveFootballerRemovesFootballer(){
       Footballer footballer1 = new Footballer("Petar");
       Footballer footballer2 = new Footballer("Georgi");
       footballTeam.addFootballer(footballer);
       footballTeam.addFootballer(footballer1);
       footballTeam.addFootballer(footballer2);

       footballTeam.removeFootballer("Ivan");
       assertEquals(2, footballTeam.getCount());
   }

   @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrowsExWhenNoneFound(){
       footballTeam.removeFootballer("Ivo");
   }

   @Test
    public void testFootballerForSalesMakesFootballerInactive(){
       Footballer footballer1 = new Footballer("Petar");
       footballTeam.addFootballer(footballer1);

       footballTeam.footballerForSale(footballer1.getName());

       assertFalse(footballer1.isActive());
   }

   @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSalesThrowsExWhenNoneFound(){
       Footballer footballer1 = new Footballer("Petar");

       footballTeam.footballerForSale("Petar");
   }
}
