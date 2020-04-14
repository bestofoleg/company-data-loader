package com.boo.companydataloader.service;

import com.ibm.icu.text.Transliterator;
import org.springframework.stereotype.Service;

@Service
public class RussianCharsetsCorrectorService {
    private static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";

    private static final Transliterator toLatinTrans =
            Transliterator.getInstance(CYRILLIC_TO_LATIN);

    public String correct(String text) {
        return toLatinTrans.transliterate(text);
    }
}
