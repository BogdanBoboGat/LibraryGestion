import java.io.*;
import java.util.*;

public class Init {

    static List <Book> books = new ArrayList<>();
    static List <Language> languages = new ArrayList<>();
    static List <Author> authors = new ArrayList<>();
    static List <EditorialGroup> editorialGroups= new ArrayList<>();
    static List <PublishingBrand> publishingBrands = new ArrayList<>();
    static List <PublishingRetailer> publishingRetailers = new ArrayList<>();
    static List <Country> countries = new ArrayList<>();

    static void read() {

        File booksIn = new File("src/init/books.in");
        File languagesIn = new File("src/init/languages.in");
        File authorsIn = new File("src/init/authors.in");
        File booksAuthorsIn = new File("src/init/books-authors.in");
        File editorialGroupsIn = new File("src/init/editorial-groups.in");
        File publishingBrandsIn = new File("src/init/publishing-brands.in");
        File editorialGroupsBooksIn = new File("src/init/editorial-groups-books.in");
        File publishingBrandsBooksIn = new File("src/init/publishing-brands-books.in");
        File publishingRetailersIn = new File("src/init/publishing-retailers.in");
        File countriesIn = new File("src/init/countries.in");
        File publishingRetailersCountriesIn = new File("src/init/publishing-retailers-countries.in");
        File publishingRetailersBooksIn = new File("src/init/publishing-retailers-books.in");
        File publishingRetailersEditorialGroupsIn = new File("src/init/publishing-retailers-editorial-groups.in");
        File publishingRetailersPublishingBrandsIn = new File("src/init/publishing-retailers-publishing-brands.in");

        try (BufferedReader br = new BufferedReader(new FileReader(booksIn))) {

            String line = br.readLine();
            String[] oneBook;
            Calendar date;
            String[] calParse;

            while ((line = br.readLine()) != null) {

                oneBook = line.split("###");
                date = Calendar.getInstance();
                calParse = oneBook[7].split("\\.| |:");

                date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(calParse[0]));
                date.set(Calendar.MONTH, Integer.parseInt(calParse[1]));
                date.set(Calendar.YEAR, Integer.parseInt(calParse[2]));
                date.set(Calendar.HOUR, Integer.parseInt(calParse[3]));
                date.set(Calendar.MINUTE, Integer.parseInt(calParse[4]));
                date.set(Calendar.SECOND, Integer.parseInt(calParse[5]));

                Book b = new Book(oneBook[0], oneBook[1], oneBook[2], oneBook[3], oneBook[4], oneBook[5], date);
                books.add(b);
            }
        }
        catch (FileNotFoundException FileNotFoundBooks) {System.out.println("File books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(languagesIn))) {

            String line = br.readLine();
            String[] oneLanguage;

            while ((line = br.readLine()) != null) {

                oneLanguage = line.split("###");

                Language l = new Language(oneLanguage[0], oneLanguage[1], oneLanguage[2]);
                languages.add(l);
            }
        }
        catch (FileNotFoundException FileNotFoundLanguages) {System.out.println("File languages.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(booksIn))) {

            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {

                oneChain = line.split("###");
                for (Book b : books) {
                    if (b.ID.equals(oneChain[0])) {
                        for (Language l : languages) {
                            if (l.ID.equals(oneChain[6])) {
                                b.languageID = l;
                                break;
                            }
                        }
                        break;
                    }
                }

            }
        }
        catch (FileNotFoundException FileNotFoundBooks) {System.out.println("File books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(authorsIn))) {

            String line = br.readLine();
            String[] oneAuthor;

            while ((line = br.readLine()) != null) {

                oneAuthor = line.split("###");

                Author a = new Author(oneAuthor[0], oneAuthor[1], oneAuthor[2]);
                authors.add(a);
            }
        }
        catch (FileNotFoundException FileNotFoundAuthors) {System.out.println("File authors.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(booksAuthorsIn))) {

            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {

                oneChain = line.split("###");

                for (Book b : books) {
                    if(b.ID.equals(oneChain[0])){
                        for(Author a : authors){
                            if(a.ID.equals(oneChain[1])){
                                b.authors.add(a);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundBooksAuthors) {System.out.println("File books-authors.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(editorialGroupsIn))) {
            String line = br.readLine();
            String[] oneEditorialGroup;

            while ((line = br.readLine()) != null) {
                oneEditorialGroup = line.split("###");

                EditorialGroup e = new EditorialGroup(oneEditorialGroup[0], oneEditorialGroup[1]);
                editorialGroups.add(e);
            }
        }
        catch (FileNotFoundException FileNotFoundBooksEditorialGroups) {System.out.println("File editorial-groups.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingBrandsIn))) {
            String line = br.readLine();
            String[] onePublishingBrand;

            while ((line = br.readLine()) != null) {
                onePublishingBrand = line.split("###");

                PublishingBrand p = new PublishingBrand(onePublishingBrand[0], onePublishingBrand[1]);
                publishingBrands.add(p);
            }
        }
        catch (FileNotFoundException FileNotFoundBooksPublishingBrands) {System.out.println("File publishing-brands.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(editorialGroupsBooksIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");

                for (EditorialGroup e : editorialGroups) {
                    if(e.ID.equals(oneChain[0])){
                        for(Book b : books){
                            if(b.ID.equals(oneChain[1])){
                                e.books.add(b);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundEditorialGroupsBooks) {System.out.println("File editorial-groups-books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingBrandsBooksIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");

                for (PublishingBrand p : publishingBrands) {
                    if(p.ID.equals(oneChain[0])){
                        for(Book b : books){
                            if(b.ID.equals(oneChain[1])){
                                p.books.add(b);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingBrandsBooks) {System.out.println("File publishing-brands-books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailersIn))) {
            String line = br.readLine();
            String[] onePublishingRetailer;

            while ((line = br.readLine()) != null) {
                onePublishingRetailer = line.split("###");

                PublishingRetailer p = new PublishingRetailer(onePublishingRetailer[0], onePublishingRetailer[1]);
                publishingRetailers.add(p);
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingBrandsBooks) {System.out.println("File publishing-brands-books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(countriesIn))) {
            String line = br.readLine();
            String[] oneCountry;

            while ((line = br.readLine()) != null) {
                oneCountry = line.split("###");

                Country c = new Country(oneCountry[0], oneCountry[1]);
                countries.add(c);
            }
        }
        catch (FileNotFoundException FileNotFoundCountries) {System.out.println("File countries.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailersCountriesIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");

                for (PublishingRetailer p : publishingRetailers) {
                    if (p.ID.equals(oneChain[0])) {
                        for (Country c : countries) {
                            if (c.ID.equals(oneChain[1])) {
                                p.countries.add(c);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingRetailersCountries) {System.out.println("File publishing-retailers-countries.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailersBooksIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");
                for (PublishingRetailer p : publishingRetailers) {
                    if (p.ID.equals(oneChain[0])) {
                        for (Book b : books) {
                            if (b.ID.equals(oneChain[1])) {
                                p.publishingArtifacts.add(b);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingRetailersBooks) {System.out.println("File publishing-retailers-books.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailersEditorialGroupsIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");
                for (PublishingRetailer p : publishingRetailers) {
                    if (p.ID.equals(oneChain[0])) {
                        for (EditorialGroup e : editorialGroups) {
                            if (e.ID.equals(oneChain[1])) {
                                p.publishingArtifacts.add(e);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingRetailersEditorialGroups) {System.out.println("File publishing-retailers-editorial-groups.in not found!");}
        catch (IOException e) {e.printStackTrace();}

        try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailersPublishingBrandsIn))) {
            String line = br.readLine();
            String[] oneChain;

            while ((line = br.readLine()) != null) {
                oneChain = line.split("###");
                for (PublishingRetailer pr : publishingRetailers) {
                    if (pr.ID.equals(oneChain[0])) {
                        for (PublishingBrand pb : publishingBrands) {
                            if (pb.ID.equals(oneChain[1])) {
                                pr.publishingArtifacts.add(pb);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException FileNotFoundPublishingRetailersPublishingBrands) {System.out.println("File publishing-retailers-publishing-brands.in not found!");}
        catch (IOException e) {e.printStackTrace();}
        }
    }