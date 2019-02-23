package com.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.*;
import java.util.List;

public class CollectionCompTest {

	public static void main(String[] args) {
		List<Invoice> invoices = new ArrayList<>();
		Collections.sort(invoices, new Comparator<Invoice>() {
			public int compare(Invoice inv1, Invoice inv2) {
				return Double.compare(inv2.getAmount(), inv1.getAmount());
			}
		});

		// Collections.sort(invoices, (Invoice inv1, Invoice inv2) ->
		// Double.compare(inv2.getAmount(), inv1.getAmount()));
		invoices.sort(comparingDouble(Invoice::getAmount))/*.revese()*/;
	}

	public static class Invoice {

		public double getAmount() {
			return 0;
		}

	}

}
