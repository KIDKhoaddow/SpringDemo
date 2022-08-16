package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.ICRUDService;

import java.text.ParseException;
import java.util.Locale;

public class ProductFormatter implements Formatter<Product> {

    private ICRUDService<Product> productICRUDService;

    @Autowired
    public ProductFormatter(ICRUDService<Product> productICRUDService){
        this.productICRUDService=productICRUDService;
    }

    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Product object, Locale locale) {
        return null;
    }
}
