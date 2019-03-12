package hackerRank;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

public class WebCrawler {

	public WebCrawler() {
	}
	
	public static void main(String[] args) {
		new StevensCreekToyota().getH2Header("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getImageLink("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferRate("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferLabel("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferDownpayment("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferDownpaymentLabel("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferTerm("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferTermLabel("https://www.stevenscreektoyota.com/lease-specials");
		new StevensCreekToyota().getOfferTitle("https://www.stevenscreektoyota.com/lease-specials");
	}

}

class StevensCreekToyota {
	
	public void getH2Header(String url) {
		try {
			System.out.println("Getting H2 header for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements h2_headers = document.select("div[class$=card-content]");
			for (Element h2_header : h2_headers ) {
				Element child = h2_header.child(0);
				System.out.println(child.text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getImageLink(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting Vehicle Image links for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements vehicle_images = document.select("a[class$=offer-image-link]");
			for (Element vehicle_image : vehicle_images ) {
				Element child = vehicle_image.child(0);
				System.out.println(child.attr("src"));
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferRate(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer rate for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_rates = document.select("div[class$=rates]");
			for (Element monthly_price : offer_rates) {
				System.out.println(monthly_price.child(0).child(0).text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferLabel(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Label for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_labels = document.select("div[class$=rates]");
			for (Element offer_label : offer_labels) {
				System.out.println(offer_label.child(0).child(0).nextElementSibling().text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferDownpayment(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Downpayment for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_downpayments = document.select("div[class$=rates]");
			for (Element offer_downpayment : offer_downpayments) {
				System.out.println(offer_downpayment.child(0).nextElementSibling().child(0).text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferDownpaymentLabel(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Downpayment Label for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_downpayment_labels = document.select("div[class$=rates]");
			for (Element offer_downpayment_label : offer_downpayment_labels) {
				System.out.println(offer_downpayment_label.child(0).nextElementSibling().child(0).nextElementSibling().text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferTerm(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Term for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_terms = document.select("div[class$=rates]");
			for (Element offer_term : offer_terms) {
				System.out.println(offer_term.child(2).child(0).text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferTermLabel(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Term Label for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_term_labels = document.select("div[class$=rates]");
			for (Element offer_term_label : offer_term_labels) {
				System.out.println(offer_term_label.child(2).child(1).text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
	public void getOfferTitle(String url) {
		try {
			System.out.println(" ");
			System.out.println("Getting offer Title for : " + url);
			Document document = Jsoup.connect(url).get();
			Elements offer_titles = document.select("h2[class$=font-bold]");
			for (Element offer_title : offer_titles) {
				System.out.println(offer_title.text());
			}
		} catch (IOException e) {
			System.err.println("For :" + url + ":" + e.getMessage());
		}
	}
	
}
