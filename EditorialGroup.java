import java.util.*;

public class EditorialGroup implements IPublishingArtifact{
    String ID;
    String name;
    List <Book> books;

    public EditorialGroup(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    @Override
    public String Publish() {
        String books = "";
        String authors = "";

        for (Book b: this.books) {

            for (Author a : b.authors){
                authors += a.firstName;
                authors += " ";
                authors += a.lastName;
                authors += "; ";
            }

            books += "\t\t<book>\n";
            books += "\t\t\t<title>" + b.name + "</title>\n" +
                    "\t\t\t<subtitle>" + b.subtitle + "</subtitle>\n" +
                    "\t\t\t<isbn>" + b.ISBN + "</isbn>\n" +
                    "\t\t\t<pageCount>" + b.pageCount + "</pageCount>\n" +
                    "\t\t\t<keywords>" + b.keywords + "</keywords>\n" +
                    "\t\t\t<languageID>" + b.languageID.ID + "</languageID>\n" +
                    "\t\t\t<createdOn>"
                    + (b.createdOn.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + b.createdOn.get(Calendar.DAY_OF_MONTH) : b.createdOn.get(Calendar.DAY_OF_MONTH))
                    + ":" + (b.createdOn.get(Calendar.MONTH) < 10 ? "0" + b.createdOn.get(Calendar.MONTH) : b.createdOn.get(Calendar.MONTH))
                    + ":" +  b.createdOn.get(Calendar.YEAR)
                    + " " + (b.createdOn.get(Calendar.HOUR) < 10 ? "0" + b.createdOn.get(Calendar.HOUR) : b.createdOn.get(Calendar.HOUR))
                    + ":" + (b.createdOn.get(Calendar.MINUTE) < 10 ? "0" + b.createdOn.get(Calendar.MINUTE) : b.createdOn.get(Calendar.MINUTE))
                    + ":" + (b.createdOn.get(Calendar.SECOND) < 10 ? "0" + b.createdOn.get(Calendar.SECOND) : b.createdOn.get(Calendar.SECOND)) +
                    "<createdOn>\n" +
                    "\t\t\t<authors>" + authors + "<authors>\n";
            books += "\t\t</book>\n";
        }

        return "<xml>\n" +
                    "\t<editorialGroup>\n" +
                        "\t\t<ID>" + this.ID + "</ID>\n" +
                        "\t\t<Name>" + this.name + "</Name>\n" +
                    "\t</editorialGroup>\n" +
                    "\t<books>\n" +
                        books +
                    "\t</books>\n" +
                "</xml>";
    }
}