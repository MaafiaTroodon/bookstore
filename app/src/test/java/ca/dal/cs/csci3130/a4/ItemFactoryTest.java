package ca.dal.cs.csci3130.a4;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.factory.Burger;
import ca.dal.cs.csci3130.a4.factory.DaVinciCode;
import ca.dal.cs.csci3130.a4.factory.Item;
import ca.dal.cs.csci3130.a4.factory.ItemFactory;
import ca.dal.cs.csci3130.a4.factory.ItemFactoryProducer;
import ca.dal.cs.csci3130.a4.factory.Pizza;
import ca.dal.cs.csci3130.a4.factory.Poutine;
import ca.dal.cs.csci3130.a4.factory.SherlockHolmes;

public class ItemFactoryTest {

    @Test
    public void testFoodFactory() {
        ItemFactory factory = ItemFactoryProducer.getFactory(false);
        Item chickenBurger = factory.getItem(AppConstants.CHICKEN_BURGER);
        assertThat(chickenBurger, instanceOf(Burger.class));
        assertFalse(chickenBurger instanceof Pizza);

        Item classicPoutine = factory.getItem(AppConstants.CLASSIC_POUTINE);
        assertThat(classicPoutine, instanceOf(Poutine.class));
        assertFalse(classicPoutine instanceof Burger);

        Item cheesePizza = factory.getItem(AppConstants.CHEESE_PIZZA);
        assertThat(cheesePizza, instanceOf(Pizza.class));
        assertFalse(cheesePizza instanceof Burger);
    }

    @Test
    public void testBookFactory() {
        ItemFactory factory = ItemFactoryProducer.getFactory(true);

        Item sherlock = factory.getItem(AppConstants.SHERLOCK_HOLMES);
        assertThat(sherlock, instanceOf(SherlockHolmes.class));
        assertFalse(sherlock instanceof DaVinciCode);

        Item daVinciCode = factory.getItem(AppConstants.DA_VINCI_CODE);
        assertThat(daVinciCode, instanceOf(DaVinciCode.class));
        assertFalse(daVinciCode instanceof SherlockHolmes);
    }
}
