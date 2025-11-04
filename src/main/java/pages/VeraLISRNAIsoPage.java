package pages;

import com.microsoft.playwright.Page;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RNAIsoPage {

    private static volatile RNAIsoPage instance;

    private ArrayList<String> accessionId;
    Page page;

    private RNAIsoPage(ArrayList<String> accId, Page page) {
        this.accessionId = accId;
        this.page = page;
    }

    public static RNAIsoPage getInstance(ArrayList<String> accId, Page page) {
        if (instance == null) {
            synchronized (RNAIsoPage.class) {
                if (instance == null) {
                    instance = new RNAIsoPage(accId, page);
                }
            }
        }
        return instance;
    }

    // Getters only (no setters to preserve immutability)
    public ArrayList<String> getAccessionId() {
        return this.accessionId;
    }

    public void completeRNAIso() {};

}
