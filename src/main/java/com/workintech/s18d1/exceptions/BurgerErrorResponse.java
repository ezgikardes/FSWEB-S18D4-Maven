package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//bu sınıfı, GlobalExceptionHandler'daki methodlarımızın
// döneceği payload'lar için oluşturduk.

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BurgerErrorResponse {
    private String message;
}
