import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Init.read();
        Administrator a = new Administrator();

        List <Book> firstExercise, fourthExercise, fifthExercise;
        List <Language> secondExercise;
        List <Country> thirdExercise;

        for (int i = 0; i < 5; i++) {
            System.out.println((i > 0 ? "\n" : "") + "Step " + (i + 1) + " of 5.");

            int publishingRetailerID = (int) (Math.random() * 33 + 1);  // a -> b,   * (b - a + 1) + a
            System.out.println("Exercise 1, ID of Publishing Retailer: " + publishingRetailerID);

            firstExercise = a.getBooksForPublishingRetailerID(publishingRetailerID);

            for (Book b : firstExercise) {
                System.out.print(b.ID + " ");
            }

            System.out.println("\nExercise 2, ID of Publishing Retailer: " + publishingRetailerID);

            secondExercise = a.getLanguagesForPublishingRetailerID(publishingRetailerID);

            for (Language l : secondExercise) {
                System.out.print(l.name + " ");
            }

            List <Integer> bookIDs = new ArrayList<>();

            for (Book b : Init.books) {
                bookIDs.add(Integer.parseInt(b.ID));
            }

            int bookID = bookIDs.get((int)(Math.random() * bookIDs.size()));

            System.out.println("\nExercise 3, ID of Book: " + bookID);

            thirdExercise = a.getCountriesForBookID(bookID);

            for (Country c : thirdExercise) {
                System.out.print(c.countryCode + " ");
            }

            int publishingRetailerID1 = (int) (Math.random() * 33 + 1);
            int publishingRetailerID2 = (int) (Math.random() * 33 + 1);

            System.out.println("\nExercise 4, IDs of Publishing Retailers: " + publishingRetailerID1 + ", " + publishingRetailerID2);

            fourthExercise = a.getCommonBooksForRetailerIDs(publishingRetailerID1, publishingRetailerID2);

            for (Book b : fourthExercise) {
                System.out.print(b.ID + " ");
            }

            System.out.println("\nExercise 5, IDs of Publishing Retailers: " + publishingRetailerID1 + ", " + publishingRetailerID2);

            fifthExercise = a.getAllBooksForRetailerIDs(publishingRetailerID1, publishingRetailerID2);

            for (Book b : fifthExercise) {
                System.out.print(b.ID + " ");
            }

            System.out.println();
        }
    }
}
