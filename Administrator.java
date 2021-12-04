import java.util.*;

public class Administrator {

    public List <Book> getBooksForPublishingRetailerID(int publishingRetailerID) {

        HashSet <Book> hashSet = new HashSet<>();
        for (PublishingRetailer pr : Init.publishingRetailers) {
            if (pr.ID.equals(String.valueOf(publishingRetailerID))) {
                for (IPublishingArtifact i : pr.publishingArtifacts) {
                    if (i instanceof Book)
                        hashSet.add(((Book)i));
                    else if (i instanceof PublishingBrand) {
                        hashSet.addAll(((PublishingBrand) i).books);
                    }
                    else if (i instanceof EditorialGroup) {
                        hashSet.addAll(((EditorialGroup) i).books);
                    }
                }
                break;
            }
        }

        return new ArrayList<>(hashSet);
    }

    public List <Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {

        HashSet <Language> hashSet = new HashSet<>();
        for (PublishingRetailer pr : Init.publishingRetailers) {
            if (pr.ID.equals(String.valueOf(publishingRetailerID))) {
                for (IPublishingArtifact i : pr.publishingArtifacts) {
                    if (i instanceof Book)
                        hashSet.add(((Book) i).languageID);
                    else if (i instanceof PublishingBrand) {
                        for(Book b : ((PublishingBrand) i).books){
                            hashSet.add(b.languageID);
                        }
                    }
                    else if (i instanceof EditorialGroup) {
                        for(Book b : ((EditorialGroup) i).books) {
                            hashSet.add(b.languageID);
                        }
                    }
                }
                break;
            }
        }

        return new ArrayList<>(hashSet);
    }

    public List <Country> getCountriesForBookID(int bookID) {

        HashSet <Country> hashSet = new HashSet<>();
        for (PublishingRetailer pr : Init.publishingRetailers) {
            for (IPublishingArtifact i : pr.publishingArtifacts) {
                if (i instanceof Book) {
                    if (((Book) i).ID.equals(String.valueOf(bookID))){
                        hashSet.addAll(pr.countries);
                        break;
                    }
                }

                else if (i instanceof PublishingBrand) {
                    for (Book b : ((PublishingBrand) i).books) {
                        if (b.ID.equals(String.valueOf(bookID))) {
                           hashSet.addAll(pr.countries);
                           break;
                        }
                    }
                }

                else if (i instanceof EditorialGroup) {
                    for (Book b : ((EditorialGroup) i).books) {
                        if (b.ID.equals(String.valueOf(bookID))) {
                            hashSet.addAll(pr.countries);
                            break;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(hashSet);
    }

    public List <Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){

        List <Book> ID1 = getBooksForPublishingRetailerID(retailerID1);
        List <Book> ID2 = getBooksForPublishingRetailerID(retailerID2);
        List <Book> common = new ArrayList<>();

        for (Book b : ID1) {
            if (ID2.contains(b)) {
                common.add(b);
            }
        }

        return common;
    }

    public List <Book> getAllBooksForRetailerIDs (int retailerID1, int retailerID2) {

        List <Book> ID1 = getBooksForPublishingRetailerID(retailerID1);
        List <Book> ID2 = getBooksForPublishingRetailerID(retailerID2);
        HashSet <Book> hashSet= new HashSet<>();

        hashSet.addAll(ID1);
        hashSet.addAll(ID2);

        return new ArrayList<>(hashSet);
    }
}
