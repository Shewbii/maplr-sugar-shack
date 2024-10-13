package fr.shewbii.maplr_sugar_shack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuantityException extends RuntimeException {
    public QuantityException(Integer newQty, Integer stock) {
        super(String.format("Vous ne pouvez pas demander plus de produit (%d) qu'il y en a stock (%d)", newQty, stock));
    }
}
