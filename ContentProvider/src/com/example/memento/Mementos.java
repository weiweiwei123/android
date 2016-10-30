package com.example.memento;

import android.net.Uri;
import android.provider.BaseColumns;

public class Mementos {
	public static final String AUTHORITY = "con.example.providers.memento";

	public static final class Memento implements BaseColumns {
		public static final String _ID = "_id";
		public static final String SUBJECT = "subject";
		public static final String BODY = "body";
		public static final String DATE = "date";
		public static final Uri MEMENTOS_CONTENT_URI= Uri.parse("content://"
				+ AUTHORITY + "/mementos");
		public static final Uri MEMENTO_CONTENT_URI= Uri.parse("content://"
				+ AUTHORITY + "/memento");
	}
}


