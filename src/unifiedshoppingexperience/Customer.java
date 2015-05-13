package unifiedshoppingexperience;

import interfaces.ICustomer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shared.CreateOrderErrors;

/**
 * Contains information about a customer and provides methods to handle the
 * actions the customer should be able to do.
 *
 * @author Gruppe 12
 */
public class Customer implements ICustomer
{
    private String ID;
    private String firstName;
    private String surName;
    private String email;
    private String phoneNumber;
    private ShoppingCart shoppingCart;
    private ArrayList<WishList> wishLists;
    private Map<Integer, Order> orders;
    private PersonalizedData pData;

    /**
     * Creates a customer with full information provided about the customer.
     *
     * @param ID The ID of the customer within the system.
     * @param firstName The first name of the customer.
     * @param surName The last name of the customer.
     * @param email The email of the customer.
     * @param phoneNumber The phone number of the customer.
     */
    public Customer(String ID, String firstName, String surName, String email, String phoneNumber)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shoppingCart = new ShoppingCart();
        this.wishLists = new ArrayList();
        this.orders = new HashMap();
        this.pData = new PersonalizedData();
    }

    /**
     * Creates a customer based on the least amount of needed information.
     *
     * @param ID The ID of the customer within the system.
     */
    public Customer(String ID)
    {
        this.ID = ID;
        this.shoppingCart = new ShoppingCart();
        this.wishLists = new ArrayList();
        this.orders = new HashMap();
        this.pData = new PersonalizedData();
    }

    /**
     * Adds a product to the shopping cart of a customer and returns the cart it
     * is added to.
     *
     * @param product The product to add to the cart.
     * @return Returns the cart the product was added to.
     */
    public Cart addToCart(Product product)
    {
        shoppingCart.addProduct(product);
        return shoppingCart;
    }

    /**
     * Gets all the wishlists of the customer.
     *
     * @return Returns a list of the wishlists the customer has.
     */
    public List<WishList> getWishLists()
    {
        return wishLists;
    }

    /**
     * Gets a specified wishlist.
     *
     * @param wishListIndex The index of the wishlist.
     * @return Returns the specified wishlist
     */
    public Cart getWishList(int wishListIndex)
    {
        return wishLists.get(wishListIndex);
    }

    /**
     * Creates a order based on a carts data.
     *
     * @return Returns the order that was created.
     */
    public CreateOrderErrors createOrder()
    {
        if (this.email == null)
        {
            return CreateOrderErrors.NO_EMAIL;
        }

        Order order = new Order(shoppingCart.getProducts().toArray(new ProductLine[0]), shoppingCart.getPrice());
        orders.put(order.getID(), order);
        return CreateOrderErrors.UNPAID;
    }

    /**
     * Gets the customers shopping cart.
     *
     * @return Returns the customers shopping cart.
     */
    public Cart getShoppingCart()
    {
        return shoppingCart;
    }

    public Order getOrder(Integer orderID)
    {
        return orders.get(orderID);
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String getSurname()
    {
        return surName;
    }

    public void setSurname(String surName)
    {
        this.surName = surName;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPersonalizedData()
    {
        return pData.toString();
    }
}
