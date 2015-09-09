package com.snapdeal.hack.model.neo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimilarCategoryNeoResponse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6212095339111925948L;

	private List<String> columns = new ArrayList<String>();

    private List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

}
