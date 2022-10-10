/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;


public class DrivableTrader<T> extends Trader<T> {

    private final List<T> inventory;
    private final List<T> wishlist;
    /**
     * Construct a DrivableTrader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this DrivableTrader's inventory
     * @param wishlist  Objects in this DrivableTrader's wishlist
     * @param money     The DrivableTrader's money
     */
    public DrivableTrader(List<T> inventory, List<T> wishlist, int money) {
        super(money);
        this.inventory = inventory;
        this.wishlist = wishlist;
    }

    public void addToWishlist(T item) {
        if (item instanceof Drivable) {
            this.wishlist.add(item);
        }
    }
    public void AddToInventory(T item) {
        if (item instanceof Drivable) {
            this.inventory.add(item);
        }
    }

    public int getSellingPrice(T item){
        if (item instanceof Tradable) {
            if (item instanceof Drivable) {
                return ((Tradable) item).getPrice() + ((Drivable) item).getMaxSpeed();
            }
        }
        return Tradable.MISSING_PRICE;
    }
}