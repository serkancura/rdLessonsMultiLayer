package com.rdLessons.multiLayerErrorHandling.helpers.errorHandiling;

// RuntimeException'dan türetilmiş CustomException oluşturuyoruz.
public class ServiceException extends RuntimeException {

    public ServiceException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
