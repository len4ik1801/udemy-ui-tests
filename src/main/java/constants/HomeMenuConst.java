package constants;

import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.Arrays.asList;

public interface HomeMenuConst {
    List<String> CATEGORIES_NAMES = asList(
        "Development","Business","Finance & Accounting","IT & Software","Office Productivity","Personal Development","Design","Marketing","Lifestyle","Photography","Health & Fitness","Music","Teaching & Academics"
    );
    String BASE_URL = "https://www.udemy.com/";
    String SEARCH_VALUE = "angular";
    String INCORRECT_SEARCH_VALUE = "Python";
    String URL_ROUT = "ref=home";


}
