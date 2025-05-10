//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;

public class ProblemSetTest {

    @Test
    public void testCardClassExists() {
        try {
            Class.forName("Card");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        }
    }
    
    @Test
    public void testCardConstructor() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            assertNotNull(constructor, "Constructor with (String, String, int) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card constructor with (String, String, int) parameters does not exist");
        }
    }
    
    @Test
    public void testGetNameMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getNameMethod = cardClass.getMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), 
                    "getName() should return String");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getName() method does not exist in Card class");
        }
    }
    
    @Test
    public void testGetSuitMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getSuitMethod = cardClass.getMethod("getSuit");
            assertEquals(String.class, getSuitMethod.getReturnType(), 
                    "getSuit() should return String");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getSuit() method does not exist in Card class");
        }
    }
    
    @Test
    public void testGetValueMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getValueMethod = cardClass.getMethod("getValue");
            assertEquals(int.class, getValueMethod.getReturnType(), 
                    "getValue() should return int");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getValue() method does not exist in Card class");
        }
    }
    
    @Test
    public void testToStringMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method toStringMethod = cardClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a cow instance if the class exists
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            Object card = constructor.newInstance("7","Hearts",7);
            
            String result = (String) toStringMethod.invoke(card);
            assertEquals("7 of Hearts", result, 
                    "toString() should return name of suit in the specified format");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in Card class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
    }
    
    @Test
    public void testEqualsMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method equalsMethod = cardClass.getMethod("equals", Object.class);
            assertEquals(boolean.class, equalsMethod.getReturnType(), 
                    "equals() should return boolean");
            
            // Create cow instances if the class exists
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            Object card1 = constructor.newInstance("7", "Hearts", 7);
            Object card2 = constructor.newInstance("7", "Hearts", 7);
            Object card3 = constructor.newInstance("8", "Hearts", 7);
            Object card4 = constructor.newInstance("7", "Clubs", 7);
            Object card5 = constructor.newInstance("7", "Clubs", 8);
            
            // Test equals method with all attributes the same
            boolean result1 = (boolean) equalsMethod.invoke(card1, card2);
            assertTrue(result1, "equals() should return true when all attributes match");
            
            // Test equals method with different name
            boolean result2 = (boolean) equalsMethod.invoke(card1, card3);
            assertFalse(result2, "equals() should return false when names don't match");
            
            // Test equals method with different age
            boolean result3 = (boolean) equalsMethod.invoke(card1, card4);
            assertFalse(result3, "equals() should return false when suit don't match");
            
            // Test equals method with different weight
            boolean result4 = (boolean) equalsMethod.invoke(card1, card5);
            assertFalse(result4, "equals() should return false when value don't match");
            
            // Test equals with null and different class
            boolean result5 = (boolean) equalsMethod.invoke(card1, new Object[]{null});
            assertFalse(result5, "equals() should return false when comparing with null");
            
            boolean result6 = (boolean) equalsMethod.invoke(card1, "Not a card");
            assertFalse(result6, "equals() should return false when comparing with object of different class");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("equals(Object) method does not exist in Card class");
        } catch (Exception e) {
            fail("Error testing equals(): " + e.getMessage());
        }
    }
    
    @Test
    public void testCardFieldsExist() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Field[] fields = cardClass.getDeclaredFields();
            
            boolean hasNameField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("name") && field.getType() == String.class);
            boolean hasSuitField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("suit") && field.getType() == String.class);
            boolean hasValueField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("value") && field.getType() == int.class);
            
            assertTrue(hasNameField, "Card class should have a name field of type String");
            assertTrue(hasSuitField, "Card class should have an suit field of type String");
            assertTrue(hasValueField, "Card class should have a value field of type int");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        }
    }

    @Test
    public void Deck()
   {
      Card[] yoo = {new Card("Ace", "Heart", 1),new Card("2", "Heart", 2) };
      Deck whatever = new Deck(yoo);
        whatever.draw();
        whatever.draw();
        whatever.draw();

        assertEquals(null, whatever.draw());
   }
   

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */
}
