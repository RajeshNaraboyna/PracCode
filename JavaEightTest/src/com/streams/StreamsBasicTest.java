package com.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsBasicTest {

	public static void main(String[] args) {
		List<Account> list = new ArrayList<>();
		list.add(new Account("1212","AccFirst"));
		list.add(new Account("1212","AccFirst"));
		list.add(new Account("1213","AccFirst1"));
		list.add(new Account("1214","AccFirst2"));
		list.add(new Account("1215","AccFirst3"));
		list.add(new Account("1216","AccFirst4"));
		list.add(new Account("1217","AccFirst5"));
		list.add(new Account("1218","AccFirst6"));
		list.add(new Account("1219","AccFirst7"));
		
		list.stream().distinct().collect(Collectors.toList());
//		list.sort();
	}

	static class Account {
		public String accId;
		public String accName;

		
		
		public Account() {
			super();
		}

		public Account(String accId, String accName) {
			super();
			this.accId = accId;
			this.accName = accName;
		}

		public String getAccId() {
			return accId;
		}

		public void setAccId(String accId) {
			this.accId = accId;
		}

		public String getAccName() {
			return accName;
		}

		public void setAccName(String accName) {
			this.accName = accName;
		}

	}

}
