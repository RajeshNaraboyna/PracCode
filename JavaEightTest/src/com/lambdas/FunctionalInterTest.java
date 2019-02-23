package com.lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterTest {

	public static void main(String[] args) {

	}

	static interface IAccount {
		void addAccount(String id);
	}

	static class Account implements IAccount {

		@Override
		public void addAccount(String id) {

		}
	}

	static class AccountService {

		public void addAccount(Consumer<IAccount> consumer) {
			consumer.accept(new Account());
		}

	}

}
