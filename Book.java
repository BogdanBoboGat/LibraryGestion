import java.util.*;

public class Book implements IPublishingArtifact{
    String ID;
    String name;
    String subtitle;
    String ISBN;
    String pageCount;
    String keywords;
    Language languageID;
    Calendar createdOn;
    List <Author> authors;

    public Book(String ID, String name, String subtitle, String ISBN, String pageCount, String keywords, Calendar createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.createdOn = createdOn;
        this.authors = new ArrayList<>();
    }

    @Override
    public String Publish() {
        String authors = "";

        for (Author a: this.authors) {
            authors += a.firstName;
            authors += " ";
            authors += a.lastName;
            authors += "; ";
        }

        return "<xml>\n" +
                    "\t<title>" + this.name + "</title>\n" +
                    "\t<subtitle>" + this.subtitle + "</subtitle>\n" +
                    "\t<isbn>" + this.ISBN + "</isbn>\n" +
                    "\t<pageCount>" + this.pageCount + "</pageCount>\n" +
                    "\t<keywords>" + this.keywords + "</keywords>\n" +
                    "\t<languageID>" + this.languageID.ID + "</languageID>\n" +
                    "\t<createdOn>"
                                    + (this.createdOn.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + this.createdOn.get(Calendar.DAY_OF_MONTH) : this.createdOn.get(Calendar.DAY_OF_MONTH))
                                    + ":" + (this.createdOn.get(Calendar.MONTH) < 10 ? "0" + this.createdOn.get(Calendar.MONTH) : this.createdOn.get(Calendar.MONTH))
                                    + ":" +  this.createdOn.get(Calendar.YEAR)
                                    + " " + (this.createdOn.get(Calendar.HOUR) < 10 ? "0" + this.createdOn.get(Calendar.HOUR) : this.createdOn.get(Calendar.HOUR))
                                    + ":" + (this.createdOn.get(Calendar.MINUTE) < 10 ? "0" + this.createdOn.get(Calendar.MINUTE) : this.createdOn.get(Calendar.MINUTE))
                                    + ":" + (this.createdOn.get(Calendar.SECOND) < 10 ? "0" + this.createdOn.get(Calendar.SECOND) : this.createdOn.get(Calendar.SECOND)) +
                    "<createdOn>\n" +
                    "\t<authors>" + authors + "<authors>\n" +
               "</xml>";
    }
}

